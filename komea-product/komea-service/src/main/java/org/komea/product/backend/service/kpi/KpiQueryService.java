/**
 *
 */

package org.komea.product.backend.service.kpi;

import java.io.Serializable;

import org.komea.eventory.api.engine.ICEPQuery;
import org.komea.product.backend.api.IDynamicDataQueryRegisterService;
import org.komea.product.backend.api.IEventEngineService;
import org.komea.product.backend.api.IKpiQueryRegisterService;
import org.komea.product.backend.api.IKpiQueryService;
import org.komea.product.backend.service.cron.ICronRegistryService;
import org.komea.product.backend.service.entities.IEntityService;
import org.komea.product.cep.api.dynamicdata.IDynamicDataQuery;
import org.komea.product.database.dto.KpiResult;
import org.komea.product.database.model.Kpi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sleroy
 */
@Service
@Transactional
public class KpiQueryService implements IKpiQueryService {

	private static final Logger	             LOGGER	= LoggerFactory.getLogger("kpi-query-service");

	@Autowired
	private ICronRegistryService	         cronRegistry;

	@Autowired
	private IDynamicDataQueryRegisterService	dynamicDataQueryRegisterService;

	@Autowired
	private IEntityService	                 entityService;

	@Autowired
	private IEventEngineService	             esperEngine;

	@Autowired
	private IKpiQueryRegisterService	     kpiQueryRegisterService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.komea.product.cep.tester.IKpiQueryRegisterService#refreshEsper(org
	 * .komea.product.database.model.Kpi)
	 */
	@Override
	public void createOrUpdateQueryFromKpi(final Kpi _kpi) {

		LOGGER.debug("Refreshing Esper with KPI {}", _kpi.getKpiKey());
		evaluateFormulaAndRegisterQuery(_kpi);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.komea.product.cep.tester.IKpiQueryRegisterService#getEsperQueryFromKpi
	 * (org.komea.product.database.model.Kpi)
	 */
	@Override
	public KpiResult getQueryValueFromKpi(final Kpi _kpi) {

		KpiResult result = new KpiResult();
		try {
			result = getKpiResultFromKpi(_kpi);
		} catch (final Exception e) {
			LOGGER.error("KPI {}  could not return any result ", _kpi.getEsperRequest(), e);
		}
		return new InferMissingEntityValuesIntoKpiResult(result, _kpi, entityService).inferEntityKeys();
	}

	@Override
	public void removeQuery(final Kpi _kpi) {
		// Removes in both
		esperEngine.removeQuery(_kpi.getEsperRequest());
		dynamicDataQueryRegisterService.removeQuery(_kpi.getEsperRequest());

	}

	private void evaluateFormulaAndRegisterQuery(final Kpi _kpi) {

		final InstantiateQueryFromFormula instantiateQueryFromFormula = new InstantiateQueryFromFormula(_kpi);
		Object queryImplementation = instantiateQueryFromFormula.instantiate();
		if (queryImplementation == null) {
			LOGGER.error("Could not provide an implementation for the kpi {}, using stub", _kpi.getKpiKey());
			queryImplementation = new NoQueryImplementation();
		}
		kpiQueryRegisterService.registerQuery(_kpi, queryImplementation);

	}

	private IDynamicDataQuery findDynamicQuery(final String computeKPIEsperKey) {

		return dynamicDataQueryRegisterService.getQuery(computeKPIEsperKey);
	}

	private ICEPQuery<Serializable, KpiResult> findEventQuery(final String computeKPIEsperKey) {

		return esperEngine.getQueryOrFail(computeKPIEsperKey);
	}

	private KpiResult getKpiResultFromKpi(final Kpi _kpi) {

		KpiResult result;
		final String formula = _kpi.getEsperRequest();
		LOGGER.trace("Request value from KPI {}", _kpi.getKpiKey());
		final IDynamicDataQuery query = findDynamicQuery(formula);
		if (query != null) {
			result = obtainDynamicQueryResult(formula, query);
		} else {
			result = obtainCepQueryResult(formula);
		}
		LOGGER.trace("Result of the query is {}", result);
		return result;
	}

	private KpiResult obtainCepQueryResult(final String computeKPIEsperKey) {

		// IF IT FAILS WE CHECK FOR EVENT QUERY
		LOGGER.trace("Is {} an event query ?", computeKPIEsperKey);
		return findEventQuery(computeKPIEsperKey).getResult();
	}

	private KpiResult obtainDynamicQueryResult(final String computeKPIEsperKey, final IDynamicDataQuery query) {

		LOGGER.trace("This query {} is a dynamic query", computeKPIEsperKey);
		return query.getResult();
	}

}

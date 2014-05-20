/**
 * 
 */

package org.komea.product.plugins.kpi.standard.jenkins;

import java.util.Collections;
import java.util.List;

import org.komea.eventory.api.cache.BackupDelay;
import org.komea.eventory.api.filters.IEventFilter;
import org.komea.eventory.api.filters.IFilterDefinition;
import org.komea.eventory.api.formula.ICEPFormula;
import org.komea.eventory.filter.EventFilterBuilder;
import org.komea.eventory.query.FilterDefinition;
import org.komea.product.cep.filter.OnlyEventFilter;
import org.komea.product.database.alert.IEvent;
import org.komea.product.database.dto.KpiResult;
import org.komea.product.plugins.kpi.filters.EventTypeFilter;
import org.komea.product.plugins.kpi.filters.WithProjectFilter;
import org.komea.product.plugins.kpi.formula.ProjectFormula;
import org.komea.product.plugins.kpi.standard.bugzilla.AbstractCEPQueryImplementation;
import org.komea.product.plugins.kpi.standard.jenkins.formula.SuccessfulBuildRateFormula;

/**
 * Successful build rate per week.
 * 
 * @author sleroy
 */
public class SuccessfulBuildRate extends AbstractCEPQueryImplementation {

	/**
     * 
     */
	public SuccessfulBuildRate() {

		super(BackupDelay.DAY);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.komea.product.cep.api.ICEPQueryImplementation#getFilterDefinitions()
	 */
	@Override
	public List<IFilterDefinition> getFilterDefinitions() {

		final IEventFilter<?> eventFilter = EventFilterBuilder.create().chain(new OnlyEventFilter())
		        .chain(new WithProjectFilter()).chain(new EventTypeFilter("build_complete", "build_started")).build();
		final IFilterDefinition filterDefinition = FilterDefinition.create()
		        .setCacheConfiguration(buildExpirationCache()).setFilter(eventFilter).setFilterName("jenkins-filter");

		return Collections.singletonList(filterDefinition);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.komea.product.cep.api.ICEPQueryImplementation#getFormula()
	 */
	@Override
	public ICEPFormula<IEvent, KpiResult> getFormula() {

		return new ProjectFormula(new SuccessfulBuildRateFormula());
	}

}
/**
 * 
 */

package org.komea.product.backend.service.olap;

import java.util.List;

import org.komea.product.backend.service.kpi.TimeSerie;
import org.komea.product.database.dao.timeserie.TimeCoordinate;
import org.komea.product.service.dto.EntityKey;

/**
 * @author sleroy
 */
public class TimeSerieImpl implements TimeSerie {

	private final List<TimeCoordinate>	buildGlobalPeriodTimeSeries;
	private EntityKey	               entityKey	= new EntityKey();

	/**
	 * @param _buildGlobalPeriodTimeSeries
	 */
	public TimeSerieImpl(final List<TimeCoordinate> _buildGlobalPeriodTimeSeries) {

		super();

		buildGlobalPeriodTimeSeries = _buildGlobalPeriodTimeSeries;

	}

	/**
	 * @param _buildPeriodTimeSeries
	 * @param _entityKey
	 */
	public TimeSerieImpl(final List<TimeCoordinate> _buildPeriodTimeSeries, final EntityKey _entityKey) {

		buildGlobalPeriodTimeSeries = _buildPeriodTimeSeries;
		entityKey = _entityKey;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.komea.product.backend.service.kpi.TimeSerie#getCoordinates()
	 */
	@Override
	public List<TimeCoordinate> getCoordinates() {

		return buildGlobalPeriodTimeSeries;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.komea.product.backend.service.kpi.TimeSerie#getEntityKey()
	 */
	@Override
	public EntityKey getEntityKey() {

		return entityKey;
	}

}

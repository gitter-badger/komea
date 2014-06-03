package org.komea.product.service.dto;

import java.util.Date;

public final class PeriodCriteria {

    /**
     * This method create a criteria with limit date between a start Date and an
     * end date. with a limit of : value per entity
     *
     * @param _startDate the start date to find the historical values
     * @param _endDate the end date to find the historical values
     * @param _limitNumber the limit number of values / entities
     * @return the criteria
     */
    public static PeriodCriteria CreateLimitCriteria(final Date _startDate, final Date _endDate) {

        return new PeriodCriteria(_startDate, _endDate);
    }

    /**
     * This method create a criteria with limit date between a start Date and
     * and now. with a limit of : value per entity
     *
     * @param _startDate the start date to find the historical values
     * @param _limitNumber the limit number of values / entities
     * @return the criteria
     */
    public static PeriodCriteria CreateLimitCriteriaFromStartingDate(final Date _startDate) {

        return new PeriodCriteria(_startDate, new Date());
    }

    //
    private Date startDate;

    private Date endDate;

    public PeriodCriteria() {

        // TODO Auto-generated LimitCriteria stub
    }

    private PeriodCriteria(final Date _startDate, final Date _endDate) {

        super();
        startDate = _startDate;
        endDate = _endDate;
    }
    //

    public Date getStartDate() {

        return startDate;
    }

    public void setStartDate(final Date _startDate) {

        startDate = _startDate;
    }

    public Date getEndDate() {

        return endDate;
    }

    public void setEndDate(final Date _endDate) {

        endDate = _endDate;
    }

    public PeriodCriteria previous() {
        final PeriodCriteria periodCriteria = new PeriodCriteria();
        periodCriteria.setStartDate(new Date(2 * startDate.getTime() - endDate.getTime()));
        periodCriteria.setEndDate(new Date(startDate.getTime()));
        return periodCriteria;
    }

    @Override
    public String toString() {
        return "PeriodCriteria{" + "startDate=" + startDate + ", endDate=" + endDate + '}';
    }

}

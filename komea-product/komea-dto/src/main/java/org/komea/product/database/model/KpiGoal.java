
package org.komea.product.database.model;



import java.util.Date;

import javax.validation.constraints.Size;

import org.komea.product.database.api.IHasKey;
import org.komea.product.database.api.IKeyVisitor;



public class KpiGoal implements IHasKey
{


    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_kpigoal
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private static final long serialVersionUID = 1L;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.entityID
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private Integer           entityID;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.frequency
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    @Size(min = 0, max = 45)
    private String            frequency;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.id
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private Integer           id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.idKpi
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private Integer           idKpi;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.untilDate
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private Date              untilDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpigoal.value
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    private Double            value;



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpigoal
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public KpiGoal() {


        super();
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpigoal
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public KpiGoal(
            final Integer id,
            final Integer idKpi,
            final Integer entityID,
            final Date untilDate,
            final Double value,
            final String frequency) {


        this.id = id;
        this.idKpi = idKpi;
        this.entityID = entityID;
        this.untilDate = untilDate;
        this.value = value;
        this.frequency = frequency;
    }


    /*
     * (non-Javadoc)
     * @see org.komea.product.database.api.IHasKey#accept(org.komea.product.database.api.IKeyVisitor)
     */
    @Override
    public void accept(final IKeyVisitor _visitor) {


        // TODO Auto-generated method stub

    }


    /*
     * (non-Javadoc)
     * @see org.komea.product.database.api.IHasKey#getDisplayName()
     */
    @Override
    public String getDisplayName() {


        // TODO Auto-generated method stub
        return null;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.entityID
     *
     * @return the value of kom_kpigoal.entityID
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public Integer getEntityID() {


        return entityID;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.frequency
     *
     * @return the value of kom_kpigoal.frequency
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public String getFrequency() {


        return frequency;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.id
     *
     * @return the value of kom_kpigoal.id
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    @Override
    public Integer getId() {


        return id;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.idKpi
     *
     * @return the value of kom_kpigoal.idKpi
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public Integer getIdKpi() {


        return idKpi;
    }


    /*
     * (non-Javadoc)
     * @see org.komea.product.database.api.IHasKey#getKey()
     */
    @Override
    public String getKey() {


        // TODO Auto-generated method stub
        return null;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.untilDate
     *
     * @return the value of kom_kpigoal.untilDate
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public Date getUntilDate() {


        return untilDate;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpigoal.value
     *
     * @return the value of kom_kpigoal.value
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public Double getValue() {


        return value;
    }


    /**
     * @return
     */
    public boolean isAssociatedToAnEntity() {
    
    
        return entityID != null;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.entityID
     *
     * @param entityID
     *            the value for kom_kpigoal.entityID
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public void setEntityID(final Integer entityID) {


        this.entityID = entityID;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.frequency
     *
     * @param frequency
     *            the value for kom_kpigoal.frequency
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public void setFrequency(final String frequency) {


        this.frequency = frequency;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.id
     *
     * @param id
     *            the value for kom_kpigoal.id
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    @Override
    public void setId(final Integer id) {


        this.id = id;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.idKpi
     *
     * @param idKpi
     *            the value for kom_kpigoal.idKpi
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public void setIdKpi(final Integer idKpi) {


        this.idKpi = idKpi;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.untilDate
     *
     * @param untilDate
     *            the value for kom_kpigoal.untilDate
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public void setUntilDate(final Date untilDate) {


        this.untilDate = untilDate;
    }


    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpigoal.value
     *
     * @param value
     *            the value for kom_kpigoal.value
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    public void setValue(final Double value) {


        this.value = value;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpigoal
     *
     * @mbggenerated Mon May 26 14:58:02 CEST 2014
     */
    @Override
    public String toString() {


        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", idKpi=").append(idKpi);
        sb.append(", entityID=").append(entityID);
        sb.append(", untilDate=").append(untilDate);
        sb.append(", value=").append(value);
        sb.append(", frequency=").append(frequency);
        sb.append("]");
        return sb.toString();
    }


}

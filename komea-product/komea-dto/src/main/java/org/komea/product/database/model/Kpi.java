
package org.komea.product.database.model;



import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ValueDirection;
import org.komea.product.database.enums.ValueType;



public class Kpi implements Serializable
{
    
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.id
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    private Integer           id;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.kpiKey
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String            kpiKey;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.name
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @NotNull
    @Size(min = 0, max = 255)
    private String            name;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.description
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @Size(min = 0, max = 2048)
    private String            description;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.idProvider
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    private Integer           idProvider;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.minValue
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    private Double            minValue;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.maxValue
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    private Double            maxValue;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.valueDirection
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @NotNull
    private ValueDirection    valueDirection;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.valueType
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @NotNull
    private ValueType         valueType;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.entityType
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @NotNull
    private EntityType        entityType;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column kom_kpi.esperRequest
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    @Size(min = 0, max = 65535)
    private String            esperRequest;
    
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_kpi
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    private static final long serialVersionUID = 1L;
    
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Kpi() {
    
    
        super();
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     * 
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Kpi(
            final Integer id,
            final String kpiKey,
            final String name,
            final String description,
            final Integer idProvider,
            final Double minValue,
            final Double maxValue,
            final ValueDirection valueDirection,
            final ValueType valueType,
            final EntityType entityType,
            final String esperRequest) {
    
    
        this.id = id;
        this.kpiKey = kpiKey;
        this.name = name;
        this.description = description;
        this.idProvider = idProvider;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.valueDirection = valueDirection;
        this.valueType = valueType;
        this.entityType = entityType;
        this.esperRequest = esperRequest;
    }
    
    
    /**
     * Compute the esper key from a KPI.
     * 
     * @param _entityID
     *            the entity ID.
     * @return the kpi key.
     */
    public String computeKPIEsperKey(final int _entityID) {
    
    
        return "KPI_" + getKpiKey() + "_T_" + getEntityType().ordinal() + "_ENTITY_" + _entityID;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.description
     * 
     * @return the value of kom_kpi.description
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public String getDescription() {
    
    
        return description;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.entityType
     * 
     * @return the value of kom_kpi.entityType
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public EntityType getEntityType() {
    
    
        return entityType;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.esperRequest
     * 
     * @return the value of kom_kpi.esperRequest
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public String getEsperRequest() {
    
    
        return esperRequest;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.id
     * 
     * @return the value of kom_kpi.id
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Integer getId() {
    
    
        return id;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.idProvider
     * 
     * @return the value of kom_kpi.idProvider
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Integer getIdProvider() {
    
    
        return idProvider;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.kpiKey
     * 
     * @return the value of kom_kpi.kpiKey
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public String getKpiKey() {
    
    
        return kpiKey;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.maxValue
     * 
     * @return the value of kom_kpi.maxValue
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Double getMaxValue() {
    
    
        return maxValue;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.minValue
     * 
     * @return the value of kom_kpi.minValue
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public Double getMinValue() {
    
    
        return minValue;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.name
     * 
     * @return the value of kom_kpi.name
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public String getName() {
    
    
        return name;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.valueDirection
     * 
     * @return the value of kom_kpi.valueDirection
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public ValueDirection getValueDirection() {
    
    
        return valueDirection;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column kom_kpi.valueType
     * 
     * @return the value of kom_kpi.valueType
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public ValueType getValueType() {
    
    
        return valueType;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.description
     * 
     * @param description
     *            the value for kom_kpi.description
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setDescription(final String description) {
    
    
        this.description = description;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.entityType
     * 
     * @param entityType
     *            the value for kom_kpi.entityType
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setEntityType(final EntityType entityType) {
    
    
        this.entityType = entityType;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.esperRequest
     * 
     * @param esperRequest
     *            the value for kom_kpi.esperRequest
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setEsperRequest(final String esperRequest) {
    
    
        this.esperRequest = esperRequest;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.id
     * 
     * @param id
     *            the value for kom_kpi.id
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setId(final Integer id) {
    
    
        this.id = id;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.idProvider
     * 
     * @param idProvider
     *            the value for kom_kpi.idProvider
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setIdProvider(final Integer idProvider) {
    
    
        this.idProvider = idProvider;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.kpiKey
     * 
     * @param kpiKey
     *            the value for kom_kpi.kpiKey
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setKpiKey(final String kpiKey) {
    
    
        this.kpiKey = kpiKey;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.maxValue
     * 
     * @param maxValue
     *            the value for kom_kpi.maxValue
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setMaxValue(final Double maxValue) {
    
    
        this.maxValue = maxValue;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.minValue
     * 
     * @param minValue
     *            the value for kom_kpi.minValue
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setMinValue(final Double minValue) {
    
    
        this.minValue = minValue;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.name
     * 
     * @param name
     *            the value for kom_kpi.name
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setName(final String name) {
    
    
        this.name = name;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.valueDirection
     * 
     * @param valueDirection
     *            the value for kom_kpi.valueDirection
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setValueDirection(final ValueDirection valueDirection) {
    
    
        this.valueDirection = valueDirection;
    }
    
    
    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column kom_kpi.valueType
     * 
     * @param valueType
     *            the value for kom_kpi.valueType
     * @mbggenerated Fri Jan 17 14:09:20 CET 2014
     */
    public void setValueType(final ValueType valueType) {
    
    
        this.valueType = valueType;
    }
    
}

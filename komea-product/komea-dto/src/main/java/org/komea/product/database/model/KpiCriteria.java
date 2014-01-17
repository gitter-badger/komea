package org.komea.product.database.model;

import java.util.ArrayList;
import java.util.List;
import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.ValueDirection;
import org.komea.product.database.enums.ValueType;

public class KpiCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public KpiCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> valueDirectionCriteria;

        protected List<Criterion> valueTypeCriteria;

        protected List<Criterion> entityTypeCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            valueDirectionCriteria = new ArrayList<Criterion>();
            valueTypeCriteria = new ArrayList<Criterion>();
            entityTypeCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getValueDirectionCriteria() {
            return valueDirectionCriteria;
        }

        protected void addValueDirectionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            valueDirectionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        protected void addValueDirectionCriterion(String condition, ValueDirection value1, ValueDirection value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            valueDirectionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getValueTypeCriteria() {
            return valueTypeCriteria;
        }

        protected void addValueTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            valueTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        protected void addValueTypeCriterion(String condition, ValueType value1, ValueType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            valueTypeCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getEntityTypeCriteria() {
            return entityTypeCriteria;
        }

        protected void addEntityTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            entityTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        protected void addEntityTypeCriterion(String condition, EntityType value1, EntityType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            entityTypeCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumOrdinalTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || valueDirectionCriteria.size() > 0
                || valueTypeCriteria.size() > 0
                || entityTypeCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(valueDirectionCriteria);
                allCriteria.addAll(valueTypeCriteria);
                allCriteria.addAll(entityTypeCriteria);
            }
            return allCriteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
            allCriteria = null;
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
            allCriteria = null;
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andKpiKeyIsNull() {
            addCriterion("kpiKey is null");
            return (Criteria) this;
        }

        public Criteria andKpiKeyIsNotNull() {
            addCriterion("kpiKey is not null");
            return (Criteria) this;
        }

        public Criteria andKpiKeyEqualTo(String value) {
            addCriterion("kpiKey =", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyNotEqualTo(String value) {
            addCriterion("kpiKey <>", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyGreaterThan(String value) {
            addCriterion("kpiKey >", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyGreaterThanOrEqualTo(String value) {
            addCriterion("kpiKey >=", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyLessThan(String value) {
            addCriterion("kpiKey <", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyLessThanOrEqualTo(String value) {
            addCriterion("kpiKey <=", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyLike(String value) {
            addCriterion("kpiKey like", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyNotLike(String value) {
            addCriterion("kpiKey not like", value, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyIn(List<String> values) {
            addCriterion("kpiKey in", values, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyNotIn(List<String> values) {
            addCriterion("kpiKey not in", values, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyBetween(String value1, String value2) {
            addCriterion("kpiKey between", value1, value2, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andKpiKeyNotBetween(String value1, String value2) {
            addCriterion("kpiKey not between", value1, value2, "kpiKey");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andIdProviderIsNull() {
            addCriterion("idProvider is null");
            return (Criteria) this;
        }

        public Criteria andIdProviderIsNotNull() {
            addCriterion("idProvider is not null");
            return (Criteria) this;
        }

        public Criteria andIdProviderEqualTo(Integer value) {
            addCriterion("idProvider =", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderNotEqualTo(Integer value) {
            addCriterion("idProvider <>", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderGreaterThan(Integer value) {
            addCriterion("idProvider >", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderGreaterThanOrEqualTo(Integer value) {
            addCriterion("idProvider >=", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderLessThan(Integer value) {
            addCriterion("idProvider <", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderLessThanOrEqualTo(Integer value) {
            addCriterion("idProvider <=", value, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderIn(List<Integer> values) {
            addCriterion("idProvider in", values, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderNotIn(List<Integer> values) {
            addCriterion("idProvider not in", values, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderBetween(Integer value1, Integer value2) {
            addCriterion("idProvider between", value1, value2, "idProvider");
            return (Criteria) this;
        }

        public Criteria andIdProviderNotBetween(Integer value1, Integer value2) {
            addCriterion("idProvider not between", value1, value2, "idProvider");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNull() {
            addCriterion("minValue is null");
            return (Criteria) this;
        }

        public Criteria andMinValueIsNotNull() {
            addCriterion("minValue is not null");
            return (Criteria) this;
        }

        public Criteria andMinValueEqualTo(Double value) {
            addCriterion("minValue =", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotEqualTo(Double value) {
            addCriterion("minValue <>", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThan(Double value) {
            addCriterion("minValue >", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueGreaterThanOrEqualTo(Double value) {
            addCriterion("minValue >=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThan(Double value) {
            addCriterion("minValue <", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueLessThanOrEqualTo(Double value) {
            addCriterion("minValue <=", value, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueIn(List<Double> values) {
            addCriterion("minValue in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotIn(List<Double> values) {
            addCriterion("minValue not in", values, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueBetween(Double value1, Double value2) {
            addCriterion("minValue between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMinValueNotBetween(Double value1, Double value2) {
            addCriterion("minValue not between", value1, value2, "minValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNull() {
            addCriterion("maxValue is null");
            return (Criteria) this;
        }

        public Criteria andMaxValueIsNotNull() {
            addCriterion("maxValue is not null");
            return (Criteria) this;
        }

        public Criteria andMaxValueEqualTo(Double value) {
            addCriterion("maxValue =", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotEqualTo(Double value) {
            addCriterion("maxValue <>", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThan(Double value) {
            addCriterion("maxValue >", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueGreaterThanOrEqualTo(Double value) {
            addCriterion("maxValue >=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThan(Double value) {
            addCriterion("maxValue <", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueLessThanOrEqualTo(Double value) {
            addCriterion("maxValue <=", value, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueIn(List<Double> values) {
            addCriterion("maxValue in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotIn(List<Double> values) {
            addCriterion("maxValue not in", values, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueBetween(Double value1, Double value2) {
            addCriterion("maxValue between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andMaxValueNotBetween(Double value1, Double value2) {
            addCriterion("maxValue not between", value1, value2, "maxValue");
            return (Criteria) this;
        }

        public Criteria andValueDirectionIsNull() {
            addCriterion("valueDirection is null");
            return (Criteria) this;
        }

        public Criteria andValueDirectionIsNotNull() {
            addCriterion("valueDirection is not null");
            return (Criteria) this;
        }

        public Criteria andValueDirectionEqualTo(ValueDirection value) {
            addValueDirectionCriterion("valueDirection =", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionNotEqualTo(ValueDirection value) {
            addValueDirectionCriterion("valueDirection <>", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionGreaterThan(ValueDirection value) {
            addValueDirectionCriterion("valueDirection >", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionGreaterThanOrEqualTo(ValueDirection value) {
            addValueDirectionCriterion("valueDirection >=", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionLessThan(ValueDirection value) {
            addValueDirectionCriterion("valueDirection <", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionLessThanOrEqualTo(ValueDirection value) {
            addValueDirectionCriterion("valueDirection <=", value, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionIn(List<ValueDirection> values) {
            addValueDirectionCriterion("valueDirection in", values, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionNotIn(List<ValueDirection> values) {
            addValueDirectionCriterion("valueDirection not in", values, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionBetween(ValueDirection value1, ValueDirection value2) {
            addValueDirectionCriterion("valueDirection between", value1, value2, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueDirectionNotBetween(ValueDirection value1, ValueDirection value2) {
            addValueDirectionCriterion("valueDirection not between", value1, value2, "valueDirection");
            return (Criteria) this;
        }

        public Criteria andValueTypeIsNull() {
            addCriterion("valueType is null");
            return (Criteria) this;
        }

        public Criteria andValueTypeIsNotNull() {
            addCriterion("valueType is not null");
            return (Criteria) this;
        }

        public Criteria andValueTypeEqualTo(ValueType value) {
            addValueTypeCriterion("valueType =", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotEqualTo(ValueType value) {
            addValueTypeCriterion("valueType <>", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThan(ValueType value) {
            addValueTypeCriterion("valueType >", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeGreaterThanOrEqualTo(ValueType value) {
            addValueTypeCriterion("valueType >=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThan(ValueType value) {
            addValueTypeCriterion("valueType <", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeLessThanOrEqualTo(ValueType value) {
            addValueTypeCriterion("valueType <=", value, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeIn(List<ValueType> values) {
            addValueTypeCriterion("valueType in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotIn(List<ValueType> values) {
            addValueTypeCriterion("valueType not in", values, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeBetween(ValueType value1, ValueType value2) {
            addValueTypeCriterion("valueType between", value1, value2, "valueType");
            return (Criteria) this;
        }

        public Criteria andValueTypeNotBetween(ValueType value1, ValueType value2) {
            addValueTypeCriterion("valueType not between", value1, value2, "valueType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNull() {
            addCriterion("entityType is null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIsNotNull() {
            addCriterion("entityType is not null");
            return (Criteria) this;
        }

        public Criteria andEntityTypeEqualTo(EntityType value) {
            addEntityTypeCriterion("entityType =", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotEqualTo(EntityType value) {
            addEntityTypeCriterion("entityType <>", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThan(EntityType value) {
            addEntityTypeCriterion("entityType >", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeGreaterThanOrEqualTo(EntityType value) {
            addEntityTypeCriterion("entityType >=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThan(EntityType value) {
            addEntityTypeCriterion("entityType <", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeLessThanOrEqualTo(EntityType value) {
            addEntityTypeCriterion("entityType <=", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeIn(List<EntityType> values) {
            addEntityTypeCriterion("entityType in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotIn(List<EntityType> values) {
            addEntityTypeCriterion("entityType not in", values, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeBetween(EntityType value1, EntityType value2) {
            addEntityTypeCriterion("entityType between", value1, value2, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotBetween(EntityType value1, EntityType value2) {
            addEntityTypeCriterion("entityType not between", value1, value2, "entityType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_kpi
     *
     * @mbggenerated do_not_delete_during_merge Fri Jan 17 11:14:03 CET 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_kpi
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
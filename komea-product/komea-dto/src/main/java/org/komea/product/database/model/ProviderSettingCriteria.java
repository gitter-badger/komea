package org.komea.product.database.model;

import java.util.ArrayList;
import java.util.List;

public class ProviderSettingCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public ProviderSettingCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
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
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
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

        public Criteria andProviderSettingKeyIsNull() {
            addCriterion("providerSettingKey is null");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyIsNotNull() {
            addCriterion("providerSettingKey is not null");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyEqualTo(String value) {
            addCriterion("providerSettingKey =", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyNotEqualTo(String value) {
            addCriterion("providerSettingKey <>", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyGreaterThan(String value) {
            addCriterion("providerSettingKey >", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyGreaterThanOrEqualTo(String value) {
            addCriterion("providerSettingKey >=", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyLessThan(String value) {
            addCriterion("providerSettingKey <", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyLessThanOrEqualTo(String value) {
            addCriterion("providerSettingKey <=", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyLike(String value) {
            addCriterion("providerSettingKey like", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyNotLike(String value) {
            addCriterion("providerSettingKey not like", value, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyIn(List<String> values) {
            addCriterion("providerSettingKey in", values, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyNotIn(List<String> values) {
            addCriterion("providerSettingKey not in", values, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyBetween(String value1, String value2) {
            addCriterion("providerSettingKey between", value1, value2, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andProviderSettingKeyNotBetween(String value1, String value2) {
            addCriterion("providerSettingKey not between", value1, value2, "providerSettingKey");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
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
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_pvds
     *
     * @mbggenerated do_not_delete_during_merge Thu Feb 20 01:05:41 CET 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_pvds
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
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
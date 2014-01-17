package org.komea.product.database.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MeasureCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public MeasureCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
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
     * This method corresponds to the database table kom_msr
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
     * This method corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_msr
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
     * This class corresponds to the database table kom_msr
     *
     * @mbggenerated Fri Jan 17 11:14:03 CET 2014
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andIdKpiIsNull() {
            addCriterion("idKpi is null");
            return (Criteria) this;
        }

        public Criteria andIdKpiIsNotNull() {
            addCriterion("idKpi is not null");
            return (Criteria) this;
        }

        public Criteria andIdKpiEqualTo(Integer value) {
            addCriterion("idKpi =", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiNotEqualTo(Integer value) {
            addCriterion("idKpi <>", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiGreaterThan(Integer value) {
            addCriterion("idKpi >", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiGreaterThanOrEqualTo(Integer value) {
            addCriterion("idKpi >=", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiLessThan(Integer value) {
            addCriterion("idKpi <", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiLessThanOrEqualTo(Integer value) {
            addCriterion("idKpi <=", value, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiIn(List<Integer> values) {
            addCriterion("idKpi in", values, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiNotIn(List<Integer> values) {
            addCriterion("idKpi not in", values, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiBetween(Integer value1, Integer value2) {
            addCriterion("idKpi between", value1, value2, "idKpi");
            return (Criteria) this;
        }

        public Criteria andIdKpiNotBetween(Integer value1, Integer value2) {
            addCriterion("idKpi not between", value1, value2, "idKpi");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterionForJDBCDate("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterionForJDBCDate("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterionForJDBCDate("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterionForJDBCDate("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("date not between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupIsNull() {
            addCriterion("idPersonGroup is null");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupIsNotNull() {
            addCriterion("idPersonGroup is not null");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupEqualTo(Integer value) {
            addCriterion("idPersonGroup =", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupNotEqualTo(Integer value) {
            addCriterion("idPersonGroup <>", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupGreaterThan(Integer value) {
            addCriterion("idPersonGroup >", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupGreaterThanOrEqualTo(Integer value) {
            addCriterion("idPersonGroup >=", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupLessThan(Integer value) {
            addCriterion("idPersonGroup <", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupLessThanOrEqualTo(Integer value) {
            addCriterion("idPersonGroup <=", value, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupIn(List<Integer> values) {
            addCriterion("idPersonGroup in", values, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupNotIn(List<Integer> values) {
            addCriterion("idPersonGroup not in", values, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupBetween(Integer value1, Integer value2) {
            addCriterion("idPersonGroup between", value1, value2, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonGroupNotBetween(Integer value1, Integer value2) {
            addCriterion("idPersonGroup not between", value1, value2, "idPersonGroup");
            return (Criteria) this;
        }

        public Criteria andIdPersonIsNull() {
            addCriterion("idPerson is null");
            return (Criteria) this;
        }

        public Criteria andIdPersonIsNotNull() {
            addCriterion("idPerson is not null");
            return (Criteria) this;
        }

        public Criteria andIdPersonEqualTo(Integer value) {
            addCriterion("idPerson =", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonNotEqualTo(Integer value) {
            addCriterion("idPerson <>", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonGreaterThan(Integer value) {
            addCriterion("idPerson >", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonGreaterThanOrEqualTo(Integer value) {
            addCriterion("idPerson >=", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonLessThan(Integer value) {
            addCriterion("idPerson <", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonLessThanOrEqualTo(Integer value) {
            addCriterion("idPerson <=", value, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonIn(List<Integer> values) {
            addCriterion("idPerson in", values, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonNotIn(List<Integer> values) {
            addCriterion("idPerson not in", values, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonBetween(Integer value1, Integer value2) {
            addCriterion("idPerson between", value1, value2, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdPersonNotBetween(Integer value1, Integer value2) {
            addCriterion("idPerson not between", value1, value2, "idPerson");
            return (Criteria) this;
        }

        public Criteria andIdProjectIsNull() {
            addCriterion("idProject is null");
            return (Criteria) this;
        }

        public Criteria andIdProjectIsNotNull() {
            addCriterion("idProject is not null");
            return (Criteria) this;
        }

        public Criteria andIdProjectEqualTo(Integer value) {
            addCriterion("idProject =", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectNotEqualTo(Integer value) {
            addCriterion("idProject <>", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectGreaterThan(Integer value) {
            addCriterion("idProject >", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectGreaterThanOrEqualTo(Integer value) {
            addCriterion("idProject >=", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectLessThan(Integer value) {
            addCriterion("idProject <", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectLessThanOrEqualTo(Integer value) {
            addCriterion("idProject <=", value, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectIn(List<Integer> values) {
            addCriterion("idProject in", values, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectNotIn(List<Integer> values) {
            addCriterion("idProject not in", values, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectBetween(Integer value1, Integer value2) {
            addCriterion("idProject between", value1, value2, "idProject");
            return (Criteria) this;
        }

        public Criteria andIdProjectNotBetween(Integer value1, Integer value2) {
            addCriterion("idProject not between", value1, value2, "idProject");
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

        public Criteria andValueEqualTo(Double value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(Double value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(Double value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(Double value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(Double value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(Double value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<Double> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<Double> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(Double value1, Double value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(Double value1, Double value2) {
            addCriterion("value not between", value1, value2, "value");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_msr
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
     * This class corresponds to the database table kom_msr
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
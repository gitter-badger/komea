package org.komea.product.database.model;

import java.util.ArrayList;
import java.util.List;

import org.komea.product.database.enums.EntityType;
import org.komea.product.database.enums.RetentionPeriod;

public class ActivityFilterCriteria {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public ActivityFilterCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
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
     * This method corresponds to the database table kom_acfi
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
     * This method corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table kom_acfi
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
     * This class corresponds to the database table kom_acfi
     *
     * @mbggenerated Thu Feb 20 01:05:41 CET 2014
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> entityTypeCriteria;

        protected List<Criterion> infoRetentionCriteria;

        protected List<Criterion> minorRetentionCriteria;

        protected List<Criterion> majorRetentionCriteria;

        protected List<Criterion> criticalRetentionCriteria;

        protected List<Criterion> blockerRetentionCriteria;

        protected List<Criterion> allCriteria;

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
            entityTypeCriteria = new ArrayList<Criterion>();
            infoRetentionCriteria = new ArrayList<Criterion>();
            minorRetentionCriteria = new ArrayList<Criterion>();
            majorRetentionCriteria = new ArrayList<Criterion>();
            criticalRetentionCriteria = new ArrayList<Criterion>();
            blockerRetentionCriteria = new ArrayList<Criterion>();
        }

        public List<Criterion> getEntityTypeCriteria() {
            return entityTypeCriteria;
        }

        protected void addEntityTypeCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            entityTypeCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addEntityTypeCriterion(String condition, EntityType value1, EntityType value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            entityTypeCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getInfoRetentionCriteria() {
            return infoRetentionCriteria;
        }

        protected void addInfoRetentionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            infoRetentionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addInfoRetentionCriterion(String condition, RetentionPeriod value1, RetentionPeriod value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            infoRetentionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getMinorRetentionCriteria() {
            return minorRetentionCriteria;
        }

        protected void addMinorRetentionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            minorRetentionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addMinorRetentionCriterion(String condition, RetentionPeriod value1, RetentionPeriod value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            minorRetentionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getMajorRetentionCriteria() {
            return majorRetentionCriteria;
        }

        protected void addMajorRetentionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            majorRetentionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addMajorRetentionCriterion(String condition, RetentionPeriod value1, RetentionPeriod value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            majorRetentionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getCriticalRetentionCriteria() {
            return criticalRetentionCriteria;
        }

        protected void addCriticalRetentionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criticalRetentionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addCriticalRetentionCriterion(String condition, RetentionPeriod value1, RetentionPeriod value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criticalRetentionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public List<Criterion> getBlockerRetentionCriteria() {
            return blockerRetentionCriteria;
        }

        protected void addBlockerRetentionCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            blockerRetentionCriteria.add(new Criterion(condition, value, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        protected void addBlockerRetentionCriterion(String condition, RetentionPeriod value1, RetentionPeriod value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            blockerRetentionCriteria.add(new Criterion(condition, value1, value2, "org.apache.ibatis.type.EnumTypeHandler"));
            allCriteria = null;
        }

        public boolean isValid() {
            return criteria.size() > 0
                || entityTypeCriteria.size() > 0
                || infoRetentionCriteria.size() > 0
                || minorRetentionCriteria.size() > 0
                || majorRetentionCriteria.size() > 0
                || criticalRetentionCriteria.size() > 0
                || blockerRetentionCriteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            if (allCriteria == null) {
                allCriteria = new ArrayList<Criterion>();
                allCriteria.addAll(criteria);
                allCriteria.addAll(entityTypeCriteria);
                allCriteria.addAll(infoRetentionCriteria);
                allCriteria.addAll(minorRetentionCriteria);
                allCriteria.addAll(majorRetentionCriteria);
                allCriteria.addAll(criticalRetentionCriteria);
                allCriteria.addAll(blockerRetentionCriteria);
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

        public Criteria andEntityTypeLike(EntityType value) {
            addEntityTypeCriterion("entityType like", value, "entityType");
            return (Criteria) this;
        }

        public Criteria andEntityTypeNotLike(EntityType value) {
            addEntityTypeCriterion("entityType not like", value, "entityType");
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

        public Criteria andIdEntityIsNull() {
            addCriterion("idEntity is null");
            return (Criteria) this;
        }

        public Criteria andIdEntityIsNotNull() {
            addCriterion("idEntity is not null");
            return (Criteria) this;
        }

        public Criteria andIdEntityEqualTo(Integer value) {
            addCriterion("idEntity =", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityNotEqualTo(Integer value) {
            addCriterion("idEntity <>", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityGreaterThan(Integer value) {
            addCriterion("idEntity >", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityGreaterThanOrEqualTo(Integer value) {
            addCriterion("idEntity >=", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityLessThan(Integer value) {
            addCriterion("idEntity <", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityLessThanOrEqualTo(Integer value) {
            addCriterion("idEntity <=", value, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityIn(List<Integer> values) {
            addCriterion("idEntity in", values, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityNotIn(List<Integer> values) {
            addCriterion("idEntity not in", values, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityBetween(Integer value1, Integer value2) {
            addCriterion("idEntity between", value1, value2, "idEntity");
            return (Criteria) this;
        }

        public Criteria andIdEntityNotBetween(Integer value1, Integer value2) {
            addCriterion("idEntity not between", value1, value2, "idEntity");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionIsNull() {
            addCriterion("infoRetention is null");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionIsNotNull() {
            addCriterion("infoRetention is not null");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionEqualTo(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention =", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionNotEqualTo(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention <>", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionGreaterThan(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention >", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionGreaterThanOrEqualTo(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention >=", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionLessThan(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention <", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionLessThanOrEqualTo(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention <=", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionLike(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention like", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionNotLike(RetentionPeriod value) {
            addInfoRetentionCriterion("infoRetention not like", value, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionIn(List<RetentionPeriod> values) {
            addInfoRetentionCriterion("infoRetention in", values, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionNotIn(List<RetentionPeriod> values) {
            addInfoRetentionCriterion("infoRetention not in", values, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addInfoRetentionCriterion("infoRetention between", value1, value2, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andInfoRetentionNotBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addInfoRetentionCriterion("infoRetention not between", value1, value2, "infoRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionIsNull() {
            addCriterion("minorRetention is null");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionIsNotNull() {
            addCriterion("minorRetention is not null");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionEqualTo(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention =", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionNotEqualTo(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention <>", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionGreaterThan(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention >", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionGreaterThanOrEqualTo(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention >=", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionLessThan(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention <", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionLessThanOrEqualTo(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention <=", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionLike(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention like", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionNotLike(RetentionPeriod value) {
            addMinorRetentionCriterion("minorRetention not like", value, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionIn(List<RetentionPeriod> values) {
            addMinorRetentionCriterion("minorRetention in", values, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionNotIn(List<RetentionPeriod> values) {
            addMinorRetentionCriterion("minorRetention not in", values, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addMinorRetentionCriterion("minorRetention between", value1, value2, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMinorRetentionNotBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addMinorRetentionCriterion("minorRetention not between", value1, value2, "minorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionIsNull() {
            addCriterion("majorRetention is null");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionIsNotNull() {
            addCriterion("majorRetention is not null");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionEqualTo(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention =", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionNotEqualTo(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention <>", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionGreaterThan(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention >", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionGreaterThanOrEqualTo(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention >=", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionLessThan(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention <", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionLessThanOrEqualTo(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention <=", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionLike(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention like", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionNotLike(RetentionPeriod value) {
            addMajorRetentionCriterion("majorRetention not like", value, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionIn(List<RetentionPeriod> values) {
            addMajorRetentionCriterion("majorRetention in", values, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionNotIn(List<RetentionPeriod> values) {
            addMajorRetentionCriterion("majorRetention not in", values, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addMajorRetentionCriterion("majorRetention between", value1, value2, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andMajorRetentionNotBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addMajorRetentionCriterion("majorRetention not between", value1, value2, "majorRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionIsNull() {
            addCriterion("criticalRetention is null");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionIsNotNull() {
            addCriterion("criticalRetention is not null");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionEqualTo(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention =", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionNotEqualTo(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention <>", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionGreaterThan(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention >", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionGreaterThanOrEqualTo(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention >=", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionLessThan(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention <", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionLessThanOrEqualTo(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention <=", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionLike(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention like", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionNotLike(RetentionPeriod value) {
            addCriticalRetentionCriterion("criticalRetention not like", value, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionIn(List<RetentionPeriod> values) {
            addCriticalRetentionCriterion("criticalRetention in", values, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionNotIn(List<RetentionPeriod> values) {
            addCriticalRetentionCriterion("criticalRetention not in", values, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addCriticalRetentionCriterion("criticalRetention between", value1, value2, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andCriticalRetentionNotBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addCriticalRetentionCriterion("criticalRetention not between", value1, value2, "criticalRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionIsNull() {
            addCriterion("blockerRetention is null");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionIsNotNull() {
            addCriterion("blockerRetention is not null");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionEqualTo(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention =", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionNotEqualTo(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention <>", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionGreaterThan(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention >", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionGreaterThanOrEqualTo(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention >=", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionLessThan(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention <", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionLessThanOrEqualTo(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention <=", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionLike(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention like", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionNotLike(RetentionPeriod value) {
            addBlockerRetentionCriterion("blockerRetention not like", value, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionIn(List<RetentionPeriod> values) {
            addBlockerRetentionCriterion("blockerRetention in", values, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionNotIn(List<RetentionPeriod> values) {
            addBlockerRetentionCriterion("blockerRetention not in", values, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addBlockerRetentionCriterion("blockerRetention between", value1, value2, "blockerRetention");
            return (Criteria) this;
        }

        public Criteria andBlockerRetentionNotBetween(RetentionPeriod value1, RetentionPeriod value2) {
            addBlockerRetentionCriterion("blockerRetention not between", value1, value2, "blockerRetention");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table kom_acfi
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
     * This class corresponds to the database table kom_acfi
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
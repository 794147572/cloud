package com.jxph.cloud.service.fast.api.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponTaskJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public CouponTaskJobExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

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

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdIsNull() {
            addCriterion("operaor_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdIsNotNull() {
            addCriterion("operaor_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdEqualTo(Integer value) {
            addCriterion("operaor_user_id =", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdNotEqualTo(Integer value) {
            addCriterion("operaor_user_id <>", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdGreaterThan(Integer value) {
            addCriterion("operaor_user_id >", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("operaor_user_id >=", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdLessThan(Integer value) {
            addCriterion("operaor_user_id <", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("operaor_user_id <=", value, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdIn(List<Integer> values) {
            addCriterion("operaor_user_id in", values, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdNotIn(List<Integer> values) {
            addCriterion("operaor_user_id not in", values, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdBetween(Integer value1, Integer value2) {
            addCriterion("operaor_user_id between", value1, value2, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andOperaorUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("operaor_user_id not between", value1, value2, "operaorUserId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNull() {
            addCriterion("application is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIsNotNull() {
            addCriterion("application is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationEqualTo(String value) {
            addCriterion("application =", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotEqualTo(String value) {
            addCriterion("application <>", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThan(String value) {
            addCriterion("application >", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationGreaterThanOrEqualTo(String value) {
            addCriterion("application >=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThan(String value) {
            addCriterion("application <", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLessThanOrEqualTo(String value) {
            addCriterion("application <=", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationLike(String value) {
            addCriterion("application like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotLike(String value) {
            addCriterion("application not like", value, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationIn(List<String> values) {
            addCriterion("application in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotIn(List<String> values) {
            addCriterion("application not in", values, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationBetween(String value1, String value2) {
            addCriterion("application between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andApplicationNotBetween(String value1, String value2) {
            addCriterion("application not between", value1, value2, "application");
            return (Criteria) this;
        }

        public Criteria andCouponConditionIsNull() {
            addCriterion("coupon_condition is null");
            return (Criteria) this;
        }

        public Criteria andCouponConditionIsNotNull() {
            addCriterion("coupon_condition is not null");
            return (Criteria) this;
        }

        public Criteria andCouponConditionEqualTo(String value) {
            addCriterion("coupon_condition =", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionNotEqualTo(String value) {
            addCriterion("coupon_condition <>", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionGreaterThan(String value) {
            addCriterion("coupon_condition >", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_condition >=", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionLessThan(String value) {
            addCriterion("coupon_condition <", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionLessThanOrEqualTo(String value) {
            addCriterion("coupon_condition <=", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionLike(String value) {
            addCriterion("coupon_condition like", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionNotLike(String value) {
            addCriterion("coupon_condition not like", value, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionIn(List<String> values) {
            addCriterion("coupon_condition in", values, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionNotIn(List<String> values) {
            addCriterion("coupon_condition not in", values, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionBetween(String value1, String value2) {
            addCriterion("coupon_condition between", value1, value2, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andCouponConditionNotBetween(String value1, String value2) {
            addCriterion("coupon_condition not between", value1, value2, "couponCondition");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdIsNull() {
            addCriterion("task_manager_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdIsNotNull() {
            addCriterion("task_manager_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdEqualTo(Integer value) {
            addCriterion("task_manager_id =", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdNotEqualTo(Integer value) {
            addCriterion("task_manager_id <>", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdGreaterThan(Integer value) {
            addCriterion("task_manager_id >", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("task_manager_id >=", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdLessThan(Integer value) {
            addCriterion("task_manager_id <", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdLessThanOrEqualTo(Integer value) {
            addCriterion("task_manager_id <=", value, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdIn(List<Integer> values) {
            addCriterion("task_manager_id in", values, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdNotIn(List<Integer> values) {
            addCriterion("task_manager_id not in", values, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdBetween(Integer value1, Integer value2) {
            addCriterion("task_manager_id between", value1, value2, "taskManagerId");
            return (Criteria) this;
        }

        public Criteria andTaskManagerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("task_manager_id not between", value1, value2, "taskManagerId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
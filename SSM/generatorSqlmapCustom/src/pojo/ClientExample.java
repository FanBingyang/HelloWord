package pojo;

import java.util.ArrayList;
import java.util.List;

public class ClientExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientExample() {
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

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Integer value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Integer value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Integer value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Integer value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Integer value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Integer> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Integer> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Integer value1, Integer value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNull() {
            addCriterion("client_name is null");
            return (Criteria) this;
        }

        public Criteria andClientNameIsNotNull() {
            addCriterion("client_name is not null");
            return (Criteria) this;
        }

        public Criteria andClientNameEqualTo(String value) {
            addCriterion("client_name =", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotEqualTo(String value) {
            addCriterion("client_name <>", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThan(String value) {
            addCriterion("client_name >", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameGreaterThanOrEqualTo(String value) {
            addCriterion("client_name >=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThan(String value) {
            addCriterion("client_name <", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLessThanOrEqualTo(String value) {
            addCriterion("client_name <=", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameLike(String value) {
            addCriterion("client_name like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotLike(String value) {
            addCriterion("client_name not like", value, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameIn(List<String> values) {
            addCriterion("client_name in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotIn(List<String> values) {
            addCriterion("client_name not in", values, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameBetween(String value1, String value2) {
            addCriterion("client_name between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientNameNotBetween(String value1, String value2) {
            addCriterion("client_name not between", value1, value2, "clientName");
            return (Criteria) this;
        }

        public Criteria andClientSexIsNull() {
            addCriterion("client_sex is null");
            return (Criteria) this;
        }

        public Criteria andClientSexIsNotNull() {
            addCriterion("client_sex is not null");
            return (Criteria) this;
        }

        public Criteria andClientSexEqualTo(String value) {
            addCriterion("client_sex =", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexNotEqualTo(String value) {
            addCriterion("client_sex <>", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexGreaterThan(String value) {
            addCriterion("client_sex >", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexGreaterThanOrEqualTo(String value) {
            addCriterion("client_sex >=", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexLessThan(String value) {
            addCriterion("client_sex <", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexLessThanOrEqualTo(String value) {
            addCriterion("client_sex <=", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexLike(String value) {
            addCriterion("client_sex like", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexNotLike(String value) {
            addCriterion("client_sex not like", value, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexIn(List<String> values) {
            addCriterion("client_sex in", values, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexNotIn(List<String> values) {
            addCriterion("client_sex not in", values, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexBetween(String value1, String value2) {
            addCriterion("client_sex between", value1, value2, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientSexNotBetween(String value1, String value2) {
            addCriterion("client_sex not between", value1, value2, "clientSex");
            return (Criteria) this;
        }

        public Criteria andClientTelIsNull() {
            addCriterion("client_tel is null");
            return (Criteria) this;
        }

        public Criteria andClientTelIsNotNull() {
            addCriterion("client_tel is not null");
            return (Criteria) this;
        }

        public Criteria andClientTelEqualTo(String value) {
            addCriterion("client_tel =", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelNotEqualTo(String value) {
            addCriterion("client_tel <>", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelGreaterThan(String value) {
            addCriterion("client_tel >", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelGreaterThanOrEqualTo(String value) {
            addCriterion("client_tel >=", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelLessThan(String value) {
            addCriterion("client_tel <", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelLessThanOrEqualTo(String value) {
            addCriterion("client_tel <=", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelLike(String value) {
            addCriterion("client_tel like", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelNotLike(String value) {
            addCriterion("client_tel not like", value, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelIn(List<String> values) {
            addCriterion("client_tel in", values, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelNotIn(List<String> values) {
            addCriterion("client_tel not in", values, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelBetween(String value1, String value2) {
            addCriterion("client_tel between", value1, value2, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientTelNotBetween(String value1, String value2) {
            addCriterion("client_tel not between", value1, value2, "clientTel");
            return (Criteria) this;
        }

        public Criteria andClientAddressIsNull() {
            addCriterion("client_address is null");
            return (Criteria) this;
        }

        public Criteria andClientAddressIsNotNull() {
            addCriterion("client_address is not null");
            return (Criteria) this;
        }

        public Criteria andClientAddressEqualTo(String value) {
            addCriterion("client_address =", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressNotEqualTo(String value) {
            addCriterion("client_address <>", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressGreaterThan(String value) {
            addCriterion("client_address >", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressGreaterThanOrEqualTo(String value) {
            addCriterion("client_address >=", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressLessThan(String value) {
            addCriterion("client_address <", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressLessThanOrEqualTo(String value) {
            addCriterion("client_address <=", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressLike(String value) {
            addCriterion("client_address like", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressNotLike(String value) {
            addCriterion("client_address not like", value, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressIn(List<String> values) {
            addCriterion("client_address in", values, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressNotIn(List<String> values) {
            addCriterion("client_address not in", values, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressBetween(String value1, String value2) {
            addCriterion("client_address between", value1, value2, "clientAddress");
            return (Criteria) this;
        }

        public Criteria andClientAddressNotBetween(String value1, String value2) {
            addCriterion("client_address not between", value1, value2, "clientAddress");
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
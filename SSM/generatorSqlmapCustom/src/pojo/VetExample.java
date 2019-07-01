package pojo;

import java.util.ArrayList;
import java.util.List;

public class VetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VetExample() {
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

        public Criteria andVetIdIsNull() {
            addCriterion("vet_id is null");
            return (Criteria) this;
        }

        public Criteria andVetIdIsNotNull() {
            addCriterion("vet_id is not null");
            return (Criteria) this;
        }

        public Criteria andVetIdEqualTo(Integer value) {
            addCriterion("vet_id =", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdNotEqualTo(Integer value) {
            addCriterion("vet_id <>", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdGreaterThan(Integer value) {
            addCriterion("vet_id >", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("vet_id >=", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdLessThan(Integer value) {
            addCriterion("vet_id <", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdLessThanOrEqualTo(Integer value) {
            addCriterion("vet_id <=", value, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdIn(List<Integer> values) {
            addCriterion("vet_id in", values, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdNotIn(List<Integer> values) {
            addCriterion("vet_id not in", values, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdBetween(Integer value1, Integer value2) {
            addCriterion("vet_id between", value1, value2, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("vet_id not between", value1, value2, "vetId");
            return (Criteria) this;
        }

        public Criteria andVetNameIsNull() {
            addCriterion("vet_name is null");
            return (Criteria) this;
        }

        public Criteria andVetNameIsNotNull() {
            addCriterion("vet_name is not null");
            return (Criteria) this;
        }

        public Criteria andVetNameEqualTo(String value) {
            addCriterion("vet_name =", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameNotEqualTo(String value) {
            addCriterion("vet_name <>", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameGreaterThan(String value) {
            addCriterion("vet_name >", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameGreaterThanOrEqualTo(String value) {
            addCriterion("vet_name >=", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameLessThan(String value) {
            addCriterion("vet_name <", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameLessThanOrEqualTo(String value) {
            addCriterion("vet_name <=", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameLike(String value) {
            addCriterion("vet_name like", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameNotLike(String value) {
            addCriterion("vet_name not like", value, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameIn(List<String> values) {
            addCriterion("vet_name in", values, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameNotIn(List<String> values) {
            addCriterion("vet_name not in", values, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameBetween(String value1, String value2) {
            addCriterion("vet_name between", value1, value2, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetNameNotBetween(String value1, String value2) {
            addCriterion("vet_name not between", value1, value2, "vetName");
            return (Criteria) this;
        }

        public Criteria andVetSexIsNull() {
            addCriterion("vet_sex is null");
            return (Criteria) this;
        }

        public Criteria andVetSexIsNotNull() {
            addCriterion("vet_sex is not null");
            return (Criteria) this;
        }

        public Criteria andVetSexEqualTo(String value) {
            addCriterion("vet_sex =", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexNotEqualTo(String value) {
            addCriterion("vet_sex <>", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexGreaterThan(String value) {
            addCriterion("vet_sex >", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexGreaterThanOrEqualTo(String value) {
            addCriterion("vet_sex >=", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexLessThan(String value) {
            addCriterion("vet_sex <", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexLessThanOrEqualTo(String value) {
            addCriterion("vet_sex <=", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexLike(String value) {
            addCriterion("vet_sex like", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexNotLike(String value) {
            addCriterion("vet_sex not like", value, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexIn(List<String> values) {
            addCriterion("vet_sex in", values, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexNotIn(List<String> values) {
            addCriterion("vet_sex not in", values, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexBetween(String value1, String value2) {
            addCriterion("vet_sex between", value1, value2, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetSexNotBetween(String value1, String value2) {
            addCriterion("vet_sex not between", value1, value2, "vetSex");
            return (Criteria) this;
        }

        public Criteria andVetAgeIsNull() {
            addCriterion("vet_age is null");
            return (Criteria) this;
        }

        public Criteria andVetAgeIsNotNull() {
            addCriterion("vet_age is not null");
            return (Criteria) this;
        }

        public Criteria andVetAgeEqualTo(String value) {
            addCriterion("vet_age =", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeNotEqualTo(String value) {
            addCriterion("vet_age <>", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeGreaterThan(String value) {
            addCriterion("vet_age >", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeGreaterThanOrEqualTo(String value) {
            addCriterion("vet_age >=", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeLessThan(String value) {
            addCriterion("vet_age <", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeLessThanOrEqualTo(String value) {
            addCriterion("vet_age <=", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeLike(String value) {
            addCriterion("vet_age like", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeNotLike(String value) {
            addCriterion("vet_age not like", value, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeIn(List<String> values) {
            addCriterion("vet_age in", values, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeNotIn(List<String> values) {
            addCriterion("vet_age not in", values, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeBetween(String value1, String value2) {
            addCriterion("vet_age between", value1, value2, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetAgeNotBetween(String value1, String value2) {
            addCriterion("vet_age not between", value1, value2, "vetAge");
            return (Criteria) this;
        }

        public Criteria andVetTelIsNull() {
            addCriterion("vet_tel is null");
            return (Criteria) this;
        }

        public Criteria andVetTelIsNotNull() {
            addCriterion("vet_tel is not null");
            return (Criteria) this;
        }

        public Criteria andVetTelEqualTo(String value) {
            addCriterion("vet_tel =", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelNotEqualTo(String value) {
            addCriterion("vet_tel <>", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelGreaterThan(String value) {
            addCriterion("vet_tel >", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelGreaterThanOrEqualTo(String value) {
            addCriterion("vet_tel >=", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelLessThan(String value) {
            addCriterion("vet_tel <", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelLessThanOrEqualTo(String value) {
            addCriterion("vet_tel <=", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelLike(String value) {
            addCriterion("vet_tel like", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelNotLike(String value) {
            addCriterion("vet_tel not like", value, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelIn(List<String> values) {
            addCriterion("vet_tel in", values, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelNotIn(List<String> values) {
            addCriterion("vet_tel not in", values, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelBetween(String value1, String value2) {
            addCriterion("vet_tel between", value1, value2, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetTelNotBetween(String value1, String value2) {
            addCriterion("vet_tel not between", value1, value2, "vetTel");
            return (Criteria) this;
        }

        public Criteria andVetMajorIsNull() {
            addCriterion("vet_major is null");
            return (Criteria) this;
        }

        public Criteria andVetMajorIsNotNull() {
            addCriterion("vet_major is not null");
            return (Criteria) this;
        }

        public Criteria andVetMajorEqualTo(String value) {
            addCriterion("vet_major =", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorNotEqualTo(String value) {
            addCriterion("vet_major <>", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorGreaterThan(String value) {
            addCriterion("vet_major >", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorGreaterThanOrEqualTo(String value) {
            addCriterion("vet_major >=", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorLessThan(String value) {
            addCriterion("vet_major <", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorLessThanOrEqualTo(String value) {
            addCriterion("vet_major <=", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorLike(String value) {
            addCriterion("vet_major like", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorNotLike(String value) {
            addCriterion("vet_major not like", value, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorIn(List<String> values) {
            addCriterion("vet_major in", values, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorNotIn(List<String> values) {
            addCriterion("vet_major not in", values, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorBetween(String value1, String value2) {
            addCriterion("vet_major between", value1, value2, "vetMajor");
            return (Criteria) this;
        }

        public Criteria andVetMajorNotBetween(String value1, String value2) {
            addCriterion("vet_major not between", value1, value2, "vetMajor");
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
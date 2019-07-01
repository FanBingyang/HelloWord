package pojo;

import java.util.ArrayList;
import java.util.List;

public class IllExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IllExample() {
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

        public Criteria andPetNameIsNull() {
            addCriterion("pet_name is null");
            return (Criteria) this;
        }

        public Criteria andPetNameIsNotNull() {
            addCriterion("pet_name is not null");
            return (Criteria) this;
        }

        public Criteria andPetNameEqualTo(String value) {
            addCriterion("pet_name =", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotEqualTo(String value) {
            addCriterion("pet_name <>", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThan(String value) {
            addCriterion("pet_name >", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameGreaterThanOrEqualTo(String value) {
            addCriterion("pet_name >=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThan(String value) {
            addCriterion("pet_name <", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLessThanOrEqualTo(String value) {
            addCriterion("pet_name <=", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameLike(String value) {
            addCriterion("pet_name like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotLike(String value) {
            addCriterion("pet_name not like", value, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameIn(List<String> values) {
            addCriterion("pet_name in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotIn(List<String> values) {
            addCriterion("pet_name not in", values, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameBetween(String value1, String value2) {
            addCriterion("pet_name between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetNameNotBetween(String value1, String value2) {
            addCriterion("pet_name not between", value1, value2, "petName");
            return (Criteria) this;
        }

        public Criteria andPetKindIsNull() {
            addCriterion("pet_kind is null");
            return (Criteria) this;
        }

        public Criteria andPetKindIsNotNull() {
            addCriterion("pet_kind is not null");
            return (Criteria) this;
        }

        public Criteria andPetKindEqualTo(String value) {
            addCriterion("pet_kind =", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindNotEqualTo(String value) {
            addCriterion("pet_kind <>", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindGreaterThan(String value) {
            addCriterion("pet_kind >", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindGreaterThanOrEqualTo(String value) {
            addCriterion("pet_kind >=", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindLessThan(String value) {
            addCriterion("pet_kind <", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindLessThanOrEqualTo(String value) {
            addCriterion("pet_kind <=", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindLike(String value) {
            addCriterion("pet_kind like", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindNotLike(String value) {
            addCriterion("pet_kind not like", value, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindIn(List<String> values) {
            addCriterion("pet_kind in", values, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindNotIn(List<String> values) {
            addCriterion("pet_kind not in", values, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindBetween(String value1, String value2) {
            addCriterion("pet_kind between", value1, value2, "petKind");
            return (Criteria) this;
        }

        public Criteria andPetKindNotBetween(String value1, String value2) {
            addCriterion("pet_kind not between", value1, value2, "petKind");
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

        public Criteria andIllnessIsNull() {
            addCriterion("illness is null");
            return (Criteria) this;
        }

        public Criteria andIllnessIsNotNull() {
            addCriterion("illness is not null");
            return (Criteria) this;
        }

        public Criteria andIllnessEqualTo(String value) {
            addCriterion("illness =", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotEqualTo(String value) {
            addCriterion("illness <>", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessGreaterThan(String value) {
            addCriterion("illness >", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessGreaterThanOrEqualTo(String value) {
            addCriterion("illness >=", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLessThan(String value) {
            addCriterion("illness <", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLessThanOrEqualTo(String value) {
            addCriterion("illness <=", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessLike(String value) {
            addCriterion("illness like", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotLike(String value) {
            addCriterion("illness not like", value, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessIn(List<String> values) {
            addCriterion("illness in", values, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotIn(List<String> values) {
            addCriterion("illness not in", values, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessBetween(String value1, String value2) {
            addCriterion("illness between", value1, value2, "illness");
            return (Criteria) this;
        }

        public Criteria andIllnessNotBetween(String value1, String value2) {
            addCriterion("illness not between", value1, value2, "illness");
            return (Criteria) this;
        }

        public Criteria andTimIsNull() {
            addCriterion("tim is null");
            return (Criteria) this;
        }

        public Criteria andTimIsNotNull() {
            addCriterion("tim is not null");
            return (Criteria) this;
        }

        public Criteria andTimEqualTo(String value) {
            addCriterion("tim =", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotEqualTo(String value) {
            addCriterion("tim <>", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimGreaterThan(String value) {
            addCriterion("tim >", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimGreaterThanOrEqualTo(String value) {
            addCriterion("tim >=", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLessThan(String value) {
            addCriterion("tim <", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLessThanOrEqualTo(String value) {
            addCriterion("tim <=", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimLike(String value) {
            addCriterion("tim like", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotLike(String value) {
            addCriterion("tim not like", value, "tim");
            return (Criteria) this;
        }

        public Criteria andTimIn(List<String> values) {
            addCriterion("tim in", values, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotIn(List<String> values) {
            addCriterion("tim not in", values, "tim");
            return (Criteria) this;
        }

        public Criteria andTimBetween(String value1, String value2) {
            addCriterion("tim between", value1, value2, "tim");
            return (Criteria) this;
        }

        public Criteria andTimNotBetween(String value1, String value2) {
            addCriterion("tim not between", value1, value2, "tim");
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
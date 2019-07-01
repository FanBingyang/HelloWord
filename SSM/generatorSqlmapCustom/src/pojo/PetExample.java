package pojo;

import java.util.ArrayList;
import java.util.List;

public class PetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetExample() {
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

        public Criteria andPetIdIsNull() {
            addCriterion("pet_id is null");
            return (Criteria) this;
        }

        public Criteria andPetIdIsNotNull() {
            addCriterion("pet_id is not null");
            return (Criteria) this;
        }

        public Criteria andPetIdEqualTo(Integer value) {
            addCriterion("pet_id =", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotEqualTo(Integer value) {
            addCriterion("pet_id <>", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThan(Integer value) {
            addCriterion("pet_id >", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pet_id >=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThan(Integer value) {
            addCriterion("pet_id <", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdLessThanOrEqualTo(Integer value) {
            addCriterion("pet_id <=", value, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdIn(List<Integer> values) {
            addCriterion("pet_id in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotIn(List<Integer> values) {
            addCriterion("pet_id not in", values, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdBetween(Integer value1, Integer value2) {
            addCriterion("pet_id between", value1, value2, "petId");
            return (Criteria) this;
        }

        public Criteria andPetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pet_id not between", value1, value2, "petId");
            return (Criteria) this;
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

        public Criteria andPetBirIsNull() {
            addCriterion("pet_bir is null");
            return (Criteria) this;
        }

        public Criteria andPetBirIsNotNull() {
            addCriterion("pet_bir is not null");
            return (Criteria) this;
        }

        public Criteria andPetBirEqualTo(String value) {
            addCriterion("pet_bir =", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirNotEqualTo(String value) {
            addCriterion("pet_bir <>", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirGreaterThan(String value) {
            addCriterion("pet_bir >", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirGreaterThanOrEqualTo(String value) {
            addCriterion("pet_bir >=", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirLessThan(String value) {
            addCriterion("pet_bir <", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirLessThanOrEqualTo(String value) {
            addCriterion("pet_bir <=", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirLike(String value) {
            addCriterion("pet_bir like", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirNotLike(String value) {
            addCriterion("pet_bir not like", value, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirIn(List<String> values) {
            addCriterion("pet_bir in", values, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirNotIn(List<String> values) {
            addCriterion("pet_bir not in", values, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirBetween(String value1, String value2) {
            addCriterion("pet_bir between", value1, value2, "petBir");
            return (Criteria) this;
        }

        public Criteria andPetBirNotBetween(String value1, String value2) {
            addCriterion("pet_bir not between", value1, value2, "petBir");
            return (Criteria) this;
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
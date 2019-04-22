/*
 * Copyright (C) 2015-2019 UTN-FRRe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.edu.utn.frre.dacs.dao.request.criteria;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

/**
 * 
 * 
 * @author Dr. Jorge Villaverde
 * @version 1.0
 */
public class LikePropertySeachCriteria<T> extends PropertySearchCriteria<T> {
	
	/**
	 * @param property
	 */
	public LikePropertySeachCriteria(String property, Object value) {
		super(property, value);
	}

	public static <T> Builder<T> newBuilder() {
		return new  Builder<T>();
	}
	
	public static class Builder<T> {
		private LikePropertySeachCriteria<T> build;
		
		public Builder<T> equal(String property, Object value) {
			this.build = new LikePropertySeachCriteria<T>(property, value);
			return this;
		}
		
		public LikePropertySeachCriteria<T> build() {
			return this.build;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Predicate buildPropertyValueExpression(CriteriaBuilder cb, Expression<?> attributeExpression) {
		return cb.like((Expression<String>)attributeExpression, (String)getValue());
	}

	@Override
	protected String operatorName() {
		return "LIKE";
	}
	
}

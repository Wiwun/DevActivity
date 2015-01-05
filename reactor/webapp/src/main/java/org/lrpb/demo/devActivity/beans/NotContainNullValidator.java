package org.lrpb.demo.devActivity.beans;

import java.util.Collection;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotContainNullValidator  implements ConstraintValidator<NotContainNull, Collection<?>> {

	@Override
	public void initialize(NotContainNull constraintAnnotation) {
	}

	@Override
	public boolean isValid(Collection<?> value, ConstraintValidatorContext context) {
		return value.contains(null)? false:true;
	}

}

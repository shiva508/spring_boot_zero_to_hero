package com.pool.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class H2DriverPresentsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		try {
			Class.forName("org.h2.Driver");
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

}

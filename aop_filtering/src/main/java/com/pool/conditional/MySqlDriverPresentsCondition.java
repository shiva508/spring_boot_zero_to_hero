package com.pool.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySqlDriverPresentsCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	return true;
	} catch (Exception e) {
		return false;
	}
	}

}

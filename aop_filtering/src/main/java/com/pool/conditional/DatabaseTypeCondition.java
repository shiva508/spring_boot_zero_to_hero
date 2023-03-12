package com.pool.conditional;

import java.util.Map;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attributes = metadata.getAnnotationAttributes(DatabaseType.class.getName());
		String type = (String) attributes.get("value");
		String enabledDBType = context.getEnvironment().getProperty("dbType");
		return (enabledDBType != null && type != null && enabledDBType.equalsIgnoreCase(type));
	}

}

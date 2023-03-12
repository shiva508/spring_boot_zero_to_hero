package com.pool.config.cache;

import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;

@Configuration
public class StudentPoolCacheConfig {

	public Config cacheConfig() {
		return new Config().setInstanceName("hazelCast-instance")
				.addMapConfig(new MapConfig().setName("org_cache").setTimeToLiveSeconds(2000));
	}

}

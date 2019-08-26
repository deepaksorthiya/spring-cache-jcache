/**
	Aug 21, 2019
	deepakk
 */
package com.example;

import java.time.Duration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author deepakk
 *
 */
@Configuration
@EnableCaching
@PropertySource("classpath:ehcache.properties")
public class CacheConfig {
	
	@Value("${maxTime}")
	int maxTime;

	@Bean
	public JCacheManagerCustomizer cacheManagerCustomizer() {
		javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;
		jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(CacheConfigurationBuilder
				.newCacheConfigurationBuilder(Object.class, Object.class, ResourcePoolsBuilder.heap(100))
				.withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(3600))).build());
		return cm -> {
			cm.createCache("userCache", jcacheConfiguration);
		};
	}
}

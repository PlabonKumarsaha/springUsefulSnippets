package com.bracits.fingerprint.config;

import java.security.KeyPair;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EhcacheConfig {

  /**
   * Ehcache Manager.
   */
  @Bean(name="ehCacheManager")
  public CacheManager cacheManager() {
    CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
        .withCache("keyPairCache",
            CacheConfigurationBuilder.newCacheConfigurationBuilder(
                String.class, KeyPair.class, ResourcePoolsBuilder.heap(10)
            )
        )
        .build();
    cacheManager.init();
    return cacheManager;
  }

}

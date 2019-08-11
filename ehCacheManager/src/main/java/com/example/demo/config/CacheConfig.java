package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.EhCacheManagerApplication;

import net.sf.ehcache.cluster.CacheCluster;
import net.sf.ehcache.config.CacheConfiguration;

@Configuration
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {

	@Bean
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCache());
	}
	
	
	public net.sf.ehcache.CacheManager ehCache() {
		
        CacheConfiguration tensecond = new CacheConfiguration();		
		
         tensecond.setName("ten-second-cache");
         tensecond.setMemoryStoreEvictionPolicy("LRU");
         tensecond.maxEntriesLocalHeap(1000);
         tensecond.setTimeToLiveSeconds(10);
         
        
         CacheConfiguration twentysecond = new CacheConfiguration();		
 		
         twentysecond.setName("twenty-second-cache");
         twentysecond.setMemoryStoreEvictionPolicy("LRU");
         twentysecond.setTimeToLiveSeconds(10);
         twentysecond.maxEntriesLocalHeap(1000);

        
         net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
         
           config.addCache(tensecond);
           config.addCache(twentysecond);
		
		return net.sf.ehcache.CacheManager.create(config);
		
		
	}

	@Override
	public CacheResolver cacheResolver() {
		// TODO Auto-generated method stub
		return super.cacheResolver();
	}

	@Override
	public KeyGenerator keyGenerator() {
		// TODO Auto-generated method stub
		return super.keyGenerator();
	}

	@Override
	public CacheErrorHandler errorHandler() {
		// TODO Auto-generated method stub
		return super.errorHandler();
	}

	
}

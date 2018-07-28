/**
 * 
 */
package com.simple.service;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.ehcache.CacheManager;

/**
 * @author suganapa
 *
 */
public class BaseService {
	
	public  CacheManager cacheManager; 
	
	public CacheManager getCacheManager() {
		
		if(cacheManager == null) {
			cacheManager = CacheManager.newInstance();
		}
		return cacheManager;
	}
	
	public void setCacheManager(CacheManager cacheManager) {
		
		this.cacheManager = cacheManager;
	}
}

package com.abhishek.hackernews.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EvictCacheService {

	@Autowired
	APIService apiService;

	@Scheduled(fixedRate = 600000)
	public void evictCache() {
		apiService.evictCache();
	}
}

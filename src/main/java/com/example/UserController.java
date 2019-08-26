package com.example;

import java.util.Iterator;

import javax.cache.Cache;
import javax.cache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author deepakk
 *
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	CacheManager cacheManager;

	@GetMapping("/")
	public void getInt() {
		Cache<Object, Object> cache = cacheManager.getCache("userCache");
		Iterator<Cache.Entry<Object, Object>> allCacheEntries = cache.iterator();
		while (allCacheEntries.hasNext()) {
			Cache.Entry<Object, Object> currentEntry = allCacheEntries.next();
			System.out.println("Key: " + currentEntry.getKey() + " Value: " + currentEntry.getValue());
		}
		System.out.println(cache);
	}

	@GetMapping("/set/{name}")
	@Cacheable(cacheNames = "userCache")
	public String setCache(@PathVariable String name) {
		return name;
	}

}

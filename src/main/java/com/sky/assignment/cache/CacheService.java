package com.sky.assignment.cache;

import net.spy.memcached.internal.OperationFuture;
import com.sky.assignment.model.Recommendations;

/**
 * Created by iman on 30/05/15.
 */

public interface CacheService {
    /**
     * Retrieve data from Memcached by key
     *
     * @param key
     * @return
     */
    Object getCacheByKey(String key);

    /**
     * @param key
     * @param expTime
     * @param value
     * @return
     */
    OperationFuture<Boolean> addCache(String key, int expTime, Object value);

    /**
     * @param key
     */
    void cleanupCache(String key);

    /**
     *
     */
    void closeMemcachedClient();

}

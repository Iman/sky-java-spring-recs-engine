package com.sky.assignment.cache;

import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.sky.assignment.model.Recommendations;

/**
 * Created by iman on 30/05/15.
 */

@Service
public class Cache implements CacheService {
    @Autowired
    MemcachedClient memcacheClient = null;

    public final static int TIMEOUT = 5; //Min


    public OperationFuture<Boolean> addCache(String subscriberId, int expTime, Object value) {
        OperationFuture<Boolean> status = memcacheClient.set(subscriberId, expTime, value);
        return status;
    }

    public Object getCacheByKey(String key) {

        Future<Object> f = null;

        Object obj = null;

        f = memcacheClient.asyncGet(key);
        try {
            obj = f.get(TIMEOUT, TimeUnit.SECONDS);

        } catch (TimeoutException e) {
            f.cancel(false);
        } catch (InterruptedException ex) {
            //Do something
            return false;

        } catch (ExecutionException ex) {
            //Do something
            return false;
        }
        return obj;
    }

    public void closeMemcachedClient() {
        memcacheClient.shutdown();
    }

    public void cleanupCache(String key) {
        memcacheClient.delete(key);
    }

}

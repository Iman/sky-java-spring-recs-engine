package com.sky.assignment.cache;

import com.sky.assignment.model.Recommendation;
import org.junit.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

/**
 * Created by iman on 30/05/15.
 */

@Configuration
@ComponentScan("com.sky.assignment")
public class CacheTest {

    public final static int CACHE_DURATION = 300;

    private Cache cacheService = new Cache();

    private Recommendation recommendation;
    private static final long START = 1415290983863L;
    private static final long END = 1415294905557L;

    @Before
    public void before() {
        recommendation = new Recommendation(UUID.randomUUID().toString(), START, END);
        cacheService.addCache("FOO", CACHE_DURATION, recommendation);
    }

    @Ignore
    @Test
    public void shouldCheckValueInCache() {
        Recommendation rec = (Recommendation) cacheService.getCacheByKey("FOO");
        Assert.assertEquals(rec.uuid, recommendation.uuid);
    }

    @After
    public void tearDown() {
        cacheService.closeMemcachedClient();
    }
}

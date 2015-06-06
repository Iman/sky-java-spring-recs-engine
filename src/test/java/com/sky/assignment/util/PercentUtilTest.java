package com.sky.assignment.util;

/**
 * Created by iman on 29/05/15.
 */


import java.util.UUID;

import com.sky.assignment.model.Recommendation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class PercentUtilTest {

    private Recommendation recommendation;
    private static final long START = 1415286000000L;
    private static final long END = 1415289600000L;

    @Before
    public void doBefore() {
        recommendation = new Recommendation(UUID.randomUUID().toString(), START, END);
    }

    /**
     * Check the difference is grater then percent then return true.
     *
     * @throws Exception
     */
    @Test
    public void shouldCheckTimeDifIsGraterThenPercentOrNot() throws Exception {
        boolean expectTrue = PercentUtil.hasPastPercentage(recommendation, START, END, 40);
        Assert.assertNotNull(expectTrue);
        Assert.assertTrue(expectTrue);
    }

    /**
     * Check the difference is less then percent then return false.
     *
     * @throws Exception
     */
    @Test
    public void shouldCheckTimeDifIsLessThenPercentOrNot() throws Exception {
        boolean expectFalse = PercentUtil.hasPastPercentage(recommendation, END, START, 80);
        Assert.assertNotNull(expectFalse);
        Assert.assertFalse(expectFalse);
    }

    /**
     * Exception catch test
     */
    @Test
    public void shoudlHandleExceptionForConvertTimeToPercentage() {
        try {
            PercentUtil.hasPastPercentage(null, 0, 0, 0);
        } catch (Exception exception) {
            Assert.assertTrue(exception instanceof NullPointerException);
            Assert.fail("NullPointerException is thrown !");
        }
    }

}

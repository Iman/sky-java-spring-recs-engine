package com.sky.assignment.util;

/**
 * Created by iman on 29/05/15.
 */

import com.sky.assignment.RecsEngine;
import com.sky.assignment.model.Recommendation;
import java.util.concurrent.TimeUnit;



public class PercentUtil {


    public static boolean hasPastPercentage(Recommendation r, long start, long end, long percentage) {

        try {

            long percent = TimeUnit.MILLISECONDS.toMinutes(r.end - r.start) * 100 / TimeUnit.MILLISECONDS.toMinutes(end - start);
            return (percent <= percentage) ? false : true;

        } catch (Exception exception) {

            //Do Something
            return false;
        }
    }
}


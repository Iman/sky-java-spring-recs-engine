package com.sky.assignment.filters;

import com.sky.assignment.model.Recommendation;
import com.sky.assignment.util.PercentUtil;
import org.springframework.stereotype.Component;

@Component
public class PercentCompleteFilter implements RecFilter {

    @Override
    public boolean isRelevant(Recommendation r, long start, long end) {
        // this filter should discard recommendations that running time is past 60%
        // for example if recommendation start time is 8:00 and end time is 9:00 then
        // this recommendation should be discarded if timeslot start is past 8:36, which is 60% of total show time

        //Filter if past 60%
        return PercentUtil.hasPastPercentage(r, start, end, 60);

////      The other possibility is to filter by range in between x and y
//        if (PercentUtil.hasPastPercentage(r, start, end, 60) && PercentUtil.hasPastPercentage(r, start, end, 80))
//        {
//            return true;
//        }
//        return false;
    }
}

package com.sky.assignment;

import com.sky.assignment.cache.CacheService;
import com.sky.assignment.model.Recommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
@RequestMapping("/recs")
public class RecsController extends WebMvcConfigurerAdapter  {

    public final static int CACHE_TIMEOUT = 300;
    private RecsEngine recsEngine;
    private CacheService cacheService;


    @Autowired
    public RecsController(RecsEngine recsEngine, CacheService cacheService) {
        this.recsEngine = recsEngine;
        this.cacheService = cacheService;
    }

    @RequestMapping(value = {"/personalised"}, method = RequestMethod.GET)
    @ResponseBody
    public Recommendations getPersonalisedRecommendations(@RequestParam("num") Long numberOfRecs,
                                                          @RequestParam("start") Long start,
                                                          @RequestParam("end") Long end,
                                                          @RequestParam("subscriber") String subscriber) {

        //Use subscriber + num (subscriber id with number of items in XML) is set as unique memcache key and if cache is present in memcache then get form the cache
        String key = subscriber + numberOfRecs.toString();
        if(key != null && cacheService.getCacheByKey(key) != null) {
            return (Recommendations) cacheService.getCacheByKey(key);
        } else {
            Recommendations recommendations = recsEngine.recommend(numberOfRecs, start, end);
            cacheService.addCache(key, CACHE_TIMEOUT, recommendations);
            return recommendations;
        }
    }
}

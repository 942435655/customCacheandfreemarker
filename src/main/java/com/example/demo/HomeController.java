package com.example.demo;

import com.example.utils.ConcurrentHashMapCacheUtils;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Copyright (C), 2015-2019, XXX有限公司
 * @FileName: HomeController
 * @author: 唐涛
 * @Date: 2019/2/26 21:50
 * @Description: xxxx
 * @since 1.0.0
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(ModelMap model) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(i+"");
            ConcurrentHashMapCacheUtils.setCache("my_cache_key_" + i, i, 60*1000);
        }
        model.put("time", new Date());
        model.put("message", stringList);
        System.out.println("已经存入到缓存中");
        return "views/index";
    }

    @RequestMapping(value = "/welcome")
    public String home(ModelMap model) {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {


            Object cache = ConcurrentHashMapCacheUtils.getCache("my_cache_key_" + i);
            if (cache != null) {
                stringList.add(cache.toString());
                System.out.println(cache.toString());
            }

            /*ConcurrentHashMapCacheUtils.showUtilsInfo();*/
        }
        System.out.println("从缓存中取出数据");
        model.put("time", new Date());
        model.put("message", stringList);
        return "views/welcome";
    }
}
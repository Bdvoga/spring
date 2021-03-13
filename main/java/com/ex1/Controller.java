package com.ex1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private Service service;
    @Autowired
    private Service serviceFrom;
    @Autowired
    private Service serviceTo;
    @Autowired
    private Step step;
    @Autowired
    private Route route;

    @RequestMapping(method = RequestMethod.GET, value = "/serviceId", produces = "text/plain")
    public @ResponseBody String callByBean() {

        //Service
        service.setId(2L);
        service.setName("name2");
        List<String> list1 = new ArrayList<>();
        list1.add("one");
        list1.add("two");
        service.setParamsToCall(list1);

        System.out.println("--Service--");
        System.out.println(service.getId());
        System.out.println(service.getName());
        System.out.println(service.getParamsToCall());

        //Step
        step.setId(5L);

        serviceFrom.setId(3L);
        serviceFrom.setName("333");
        List<String> list2 = new ArrayList<>();
        list2.add("aaa");
        list2.add("bbb");
        serviceFrom.setParamsToCall(list2);
        step.setServiceFrom(serviceFrom);

        serviceTo.setId(4L);
        serviceTo.setName("44");
        List<String> list3 = new ArrayList<>();
        list3.add("1qw2");
        list3.add("wsde1");
        serviceTo.setParamsToCall(list3);
        step.setServiceTo(serviceTo);

        Map<String, String> paramsServiceFrom = new HashMap<>();
        paramsServiceFrom.put("1", "one");
        paramsServiceFrom.put("2", "two");
        step.setParamsServiceFrom(paramsServiceFrom);

        Map<String, String> paramsServiceTo = new HashMap<>();
        paramsServiceTo.put("3", "333");
        paramsServiceTo.put("4", "444");
        step.setParamsServiceTo(paramsServiceTo);

        System.out.println("--Step--");
        System.out.println(step.getId());
        System.out.println(step.getServiceFrom());
        System.out.println(step.getServiceTo());
        System.out.println(step.getParamsServiceFrom());
        System.out.println(step.getParamsServiceTo());

        //Route
        route.setId("123");
        List<Step> steps = new ArrayList<>();
        steps.add(step);
        route.setSteps(steps);

        System.out.println("--Route--");
        System.out.println(route.getId());
        System.out.println(route.getSteps().toString());

        return "Ok!";
    }
}
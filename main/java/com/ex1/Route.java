package com.ex1;

import java.util.List;

public class Route {
    String id;
    List<Step> steps;

    public Route(String id, List<Step> steps) {
        this.id = id;
        this.steps = steps;
    }

    //    public Route() {
//        this.id = "330";
//        assert false;
//        this.steps.add(new Step());
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public void setSteps(List<Step> steps) {
        this.steps = steps;
    }
}

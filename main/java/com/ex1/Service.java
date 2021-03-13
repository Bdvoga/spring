package com.ex1;

import java.util.List;

public class Service {
    private Long id;
    private String name;
    private List<String> paramsToCall;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getParamsToCall() {
        return paramsToCall;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParamsToCall(List<String> paramsToCall) {
        this.paramsToCall = paramsToCall;
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", paramsToCall=" + paramsToCall +
                '}';
    }
}

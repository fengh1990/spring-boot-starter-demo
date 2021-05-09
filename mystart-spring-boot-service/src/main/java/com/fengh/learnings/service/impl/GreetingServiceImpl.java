package com.fengh.learnings.service.impl;

import com.fengh.learnings.service.GreetingService;

import java.util.List;

public class GreetingServiceImpl implements GreetingService {

    private final List<String> members;

    public GreetingServiceImpl(List<String> members) {
        this.members = members;
    }


    @Override
    public void sayHello() {
        this.members.forEach(s -> System.out.println("hello," + s));
    }
}

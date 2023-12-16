package com.example.mapstruct.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    private final SimpleMapper simpleMapper;

    public SimpleController(SimpleMapper simpleMapper) {
        this.simpleMapper = simpleMapper;
    }

    @GetMapping("/test")
    public String test() {
        SimpleSource source = new SimpleSource();
        source.setName("sourceName");
        source.setDescription("sourceDescription");
        return simpleMapper.toDestination(source).getDesc();
    }
}

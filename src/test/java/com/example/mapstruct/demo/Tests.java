package com.example.mapstruct.demo;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void testMapper() {
        SimpleMapper mapper = Mappers.getMapper(SimpleMapper.class);
        SimpleSource source = new SimpleSource();
        source.setName("sourceName");
        source.setDescription("sourceDescription");
        SimpleDestination destination = mapper.toDestination(source);
        assertEquals("sourceDescription", destination.getDesc());
    }
}

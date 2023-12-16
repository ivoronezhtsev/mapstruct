package com.example.mapstruct.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SimpleMapper {
    @Mapping(source = "description", target = "desc")
    SimpleDestination toDestination(SimpleSource source);
}

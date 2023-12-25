# Пример работы с mapstruct
В pom.xml прописывается  
```
<dependency>
<groupId>org.mapstruct</groupId>
<artifactId>mapstruct</artifactId>
<version>1.4.2.Final</version>
</dependency>

<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-compiler-plugin</artifactId>
    <version>3.5.1</version>
    <configuration>
        <source>1.8</source>
        <target>1.8</target>
        <annotationProcessorPaths>
            <path>
                <groupId>org.mapstruct</groupId>
                <artifactId>mapstruct-processor</artifactId>
                <version>1.4.2.Final</version>
            </path>
        </annotationProcessorPaths>
    </configuration>
</plugin>
```
Пишем интерфейс с аннотацией @Mapper
```
    @Mapper(componentModel = "spring")
    public interface SimpleMapper {
        @Mapping(source = "description", target = "desc")
        SimpleDestination toDestination(SimpleSource source);
    }
```
где @Mapping аннотация которая указывает как маппить поля, при отсутвии библиотека
считает что поля имеют одинаковые имена.
componentModel = "spring" нужно для указания что маппер - бин.</br>
Для сборки обязательно делать mvn clean install, при этом код генерируется.

### Swagger
Используется spring-doc</br>
Доступен по localhost:8080/swagger-ui.html
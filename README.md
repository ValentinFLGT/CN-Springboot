# Springboot

Spring Boot is a framework that allows you to quickly start developing applications or services by providing the necessary dependencies and auto-configuring them.

- To enable auto-configuration, the annotation `@EnableAutoConfiguration` is used. Custom configurations take precedence over Spring Boot configurations.

- The starters allow you to import a set of dependencies according to the nature of the application to be developed in order to get started quickly.

### The 'IoC' container 🛠

IoC (Inversion of Control) is also known as dependency injection (DI). It is a process whereby objects define their dependencies, that is, the other objects they work with, only through constructor arguments, arguments to a factory method, or properties that are set on the object instance after it is constructed or returned from a factory method. The container then injects those dependencies when it creates the bean.

### But what is a 'Bean' ? 🤔

In Spring, the objects that form the backbone of your application and that are managed by the Spring IoC container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. Otherwise, a bean is simply one of many objects in your application.

### Core-Spring annotations 🎯

- @Autowire
    - This annotation is applied on fields, setter methods, and constructors. It injects object dependency implicitly.

```java=
@Autowired
private CharacterDao characterDao;
```

- @Qualifier
    - This annotation is used along with @Autowired annotation. When you need more control of the dependency injection process, @Qualifier can be used. @Qualifier can be specified on individual constructor arguments or method parameters.

```java=
@Component
public class BeanB1 implements BeanInterface {..}

@Component
public class BeanB2 implements BeanInterface {..}
```

Here, if BeanA autowires this interface, Spring will not know which one of the two implementations to inject.
> One solution to this problem is the use of the `@Qualifier` annotation.

```java=
@Component
public class BeanA {
  @Autowired
  @Qualifier("beanB2")
  private BeanInterface dependency;
  ...
}
```

- @Configuration
    - This annotation is used on classes which define beans. `@Configuration` is an analog for XML configuration file – it is configuration using Java class.

```java=
@Configuration
public class DataConfig{ 
  @Bean
  public DataSource source(){
    DataSource source = new OracleDataSource();
    source.setURL();
    source.setUser();
    return source;
  }
  @Bean
  public PlatformTransactionManager manager(){
    PlatformTransactionManager manager = new BasicDataSourceTransactionManager();
    manager.setDataSource(source());
    return manager;
  }
}
```

### Stereotype annotations 🎈

- @Component
    - The `@Component` annotation marks the Java class as a bean or say component so that the component-scanning mechanism of Spring can add into the application context.
- @Controller
    - The `@Controller` annotation is used to indicate the class is a Spring controller.
- @Service
    - This annotation is used on a class. The `@Service` marks a Java class that performs some service, such as execute business logic, perform calculations and call external APIs.
- @Repository
    - This annotation is used on Java classes which directly access the database.

### Enable Swagger API Documentation 📕

1. Add Swagger dependencies
```java=
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-ui</artifactId>
    <version>1.5.2</version>
</dependency>
```
2. Reload your maven project to update dependencies

![](https://i.imgur.com/HsuQuaN.png)

3. Go to `http://localhost:8080/swagger-ui.html`







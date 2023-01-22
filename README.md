<b>< Connect Spring Boot project to mySQL Database ></b><br>
<br>
The process is as below in order...
<br>
   - Create Controller class
   - Create Bean Class (Model) which includes getter and setter methods
   - Add JPA & mySQL dependencies in pom.xml (Below Dependencies)
<br>
  <em>
  <pre>
  &#60;dependency&#62;
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
  &#60;/dependency&#62;
<br>
  &#60;dependency&#62;
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
  &#60;/dependency&#62;
  </pre>
</em>

   - Add Annotation @Entity on Bean Class (Model)<br>
   - In case SDK cannot resolve symbol java during mySQL & Spring Boot connection configuration<br>
   (Reference: https://stackoverflow.com/questions/73350585/upgrade-from-spring-boot-2-7-2-to-spring-boot-3-0-0-snapshot-java-package-java).<br> 
   There is no need to add hibernate-entitymanager artifact as dependency in pom.xml.
   spring-boot-starter-data-jpa artifact is enough. You shoud just consider the following points.
   Replace Java EE 8 With Jakarta EE 9 APIs:Spring Boot 3.0 will be the first version of Spring Boot that makes use of Jakarta EE 9 APIs (jakarta.) instead of EE 8 (javax.). This entails that we will have to look for EE 8 imports with javax.* and replace them with jakarta.*. <br>
   Typical EE 8 packages used in Spring Boot microservices include the following:<br>
<em>
<pre>
    javax.persistence.*<br>
    javax.validation.*<br>
    javax.servlet.*<br>
    javax.annotation.*<br>
    javax.transaction.*<br>
    </pre>
</em>

<br> Be aware that packages such as javax.sql.* and javax.crypto.* come from Java 17 JDK, not from EE 8, so they are safe to stay!

   - Create Repository Interface with JPA Repository extended
   - Add in application.properties for which spring looks when doing configurations for setting various properties (For example, pointing to another server 9000 rather than local server 8080)
   - Set new connection in mySQL and create new Schema, then run Spring Boot Project again. <br>
   Under the schema, table which is created in Bean class appears (If connection is made successfully)<br>
   - Inject repository into Controller class by using annotation "Autowired"  and declare HTTP methods (GetMapping, PostMapping etc..) in Controller Class to implement CRUD operation<br>
   - For configuration checking, POSTMAN is used as client tool and implement methods (When to use POST method, JSON format is used frequently)

# soap-webservice

This web service return a list of standards by standard code.

![alt text](https://github.com/rswijesena/soap-webservice/blob/master/webservice/src/main/resources/sample.png)

Setup.

1 .Generate model classes.

mvn generate-sources

Generated source of model classes will be available here. https://github.com/rswijesena/soap-webservice/tree/master/webservice/target/generated-sources/xjc/com/sai/ws

2. Run test suite.

mvn test

3 Start web service.

mvn spring-boot:run

Once successfully startup, you can access the wsdl file, http://localhost:9090/sai/ws/saiservice.wsdl


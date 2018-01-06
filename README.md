# soap-webservice

This web service return a list of standards by standard code.

![alt text](https://github.com/rswijesena/soap-webservice/blob/master/webservice/src/main/resources/sample.png)

Setup.

1 .Generate model classes.

mvn generate-sources

Generated source of model classes will be available here. https://github.com/rswijesena/soap-webservice/tree/master/webservice/target/generated-sources/xjc/com/sai/ws

2. Run test suite.

mvn test

3. Start web service.

mvn spring-boot:run

Once successfully startup, you can access the wsdl file, http://localhost:9090/sai/ws/saiservice.wsdl
https://github.com/rswijesena/soap-webservice/blob/master/webservice/src/main/resources/wsdl/sai.wsdl

Sample client application can be found here, https://github.com/rswijesena/soap-webservice/tree/master/webservice/src/main/java/com/sai/ws/client

Unit test for the web serivce can be found here, https://github.com/rswijesena/soap-webservice/tree/master/webservice/src/test/java/com/sai/ws




# soap-webservice

This webservice return a list of standards by standadrd code.

![alt text](https://github.com/rswijesena/soap-webservice/blob/master/webservice/src/main/resources/sample.png)

Setup.

1 .Generate model classes.

mvn generate-sources

2. Run test suite.

mvn test

3 Start web service.

mvn spring-boot:run

Once sucessfully startup, you can access the wsdl file, http://localhost:9090/codenotfound/ws/

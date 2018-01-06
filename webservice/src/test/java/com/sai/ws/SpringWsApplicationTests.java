package com.sai.ws;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sai.ws.client.SAIClient;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringWsApplicationTests {

    @Autowired
    private SAIClient SAIClient;

    @Test
    public void testStandardCode() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        BigInteger code = standard.get(0).getStandardCode();
        BigInteger bi = BigInteger.valueOf(100);
        assertThat(code).isEqualTo(bi);
    }

    @Test
    public void testStandardPubliser() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        String publisher = standard.get(0).getPublisher();
        assertThat(publisher).isEqualTo("Publisher one");
    }

    @Test
    public void testStandardName() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        String publisher = standard.get(0).getStandardName();
        assertThat(publisher).isEqualTo("Standard one");
    }

    @Test
    public void testRelationshipNames() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        List<String> relationshipName = standard.get(0).getRelationship().get(0).getRelationshipName();
        assertThat(relationshipName.get(0)).isEqualTo("Relationship name 01");
    }

    @Test
    public void testRelationshipStatusCode() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        String statusCode = standard.get(0).getRelationship().get(0).getStatusCode();
        assertThat(statusCode).isEqualTo("recode 001");
    }

    @Test
    public void testRelationshipStatusDate() throws DatatypeConfigurationException {
        List<Standard> standard =  SAIClient.testClient("100");
        XMLGregorianCalendar date = standard.get(0).getRelationship().get(0).getStatusDate();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDay = new Date();
        XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(toDay));
        assertThat(date).isEqualTo(cal);
    }


}
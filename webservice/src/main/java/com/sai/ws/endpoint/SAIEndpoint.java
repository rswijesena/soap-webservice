package com.sai.ws.endpoint;

import com.sai.ws.GetStandards;
import com.sai.ws.GetStandardsResponse;
import com.sai.ws.ObjectFactory;
import com.sai.ws.Standard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * This class contains the endpoint definition and the mock implementation.
 * also Iterate through input codes and search standard code from the mock data and return requested data.
 */
@Endpoint
public class SAIEndpoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(SAIEndpoint.class);

    @PayloadRoot(namespace = "http://sai.com/ws/", localPart = "getStandards")
    @ResponsePayload
    public GetStandardsResponse getStandards(@RequestPayload GetStandards getStandards) throws DatatypeConfigurationException {
        ObjectFactory factory = new ObjectFactory();
        GetStandardsResponse response = factory.createGetStandardsResponse();
        LOGGER.debug("getStandards request for " + getStandards.getStandardsList());

        //Mock standards.
        //Record one
        Standard standard = new Standard();
        standard.setPublisher("Publisher one");
        standard.setStandardName("Standard one");
        standard.setStandardCode(BigInteger.valueOf(100));
        Standard.Relationship relationship = new Standard.Relationship();
        relationship.setRelationshipType("relationship Type 1");
        relationship.setStatusCode("recode 001");
        relationship.getRelationshipName().add("Relationship name 01");
        relationship.getRelationshipName().add("Relationship name 02");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(dateFormat.format(date));
        relationship.setStatusDate(cal);
        standard.getRelationship().add(relationship);

        //Record two
        Standard standard1 = new Standard();
        standard1.setPublisher("Publisher two");
        standard1.setStandardName("Standard two");
        standard1.setStandardCode(BigInteger.valueOf(200));
        Standard.Relationship relationship1 = new Standard.Relationship();
        relationship1.setRelationshipType("relationship Type 2");
        relationship1.setStatusCode("recode 002");
        relationship1.setStatusDate(cal);
        standard1.getRelationship().add(relationship1);

        //record three
        Standard standard2 = new Standard();
        standard2.setPublisher("Publisher three");
        standard2.setStandardName("Standard three");
        standard2.setStandardCode(BigInteger.valueOf(300));
        Standard.Relationship relationship2 = new Standard.Relationship();
        relationship2.setRelationshipType("relationship Type 3");
        relationship2.setStatusCode("recode 003");
        relationship2.setStatusDate(cal);
        standard2.getRelationship().add(relationship2);

        //Add all mock data to the list
        response.getStandards().add(standard);
        response.getStandards().add(standard1);
        response.getStandards().add(standard2);

        //new response class initiate to hold search data.
        GetStandardsResponse responseAfterSearch = factory.createGetStandardsResponse();

        //Iterate through input codes and search standard code from the mock data and return requested data.
        for(String list : getStandards.getStandardsList()){

            List<Standard> newList = response.getStandards();
            Iterator<Standard> iter = newList.iterator();
            while (iter.hasNext()) {
                Standard c = iter.next();
                int result = list.compareTo(String.valueOf(c.getStandardCode()));

                if (result == 0) {
                    responseAfterSearch.getStandards().add(c);
                }
            }

        }

        return responseAfterSearch;
    }

}
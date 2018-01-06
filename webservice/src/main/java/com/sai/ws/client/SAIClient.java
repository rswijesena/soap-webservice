package com.sai.ws.client;

import com.sai.ws.GetStandards;
import com.sai.ws.GetStandardsResponse;
import com.sai.ws.ObjectFactory;
import com.sai.ws.Standard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

/**
 * sample test client that invoke the webservice getStandard method and return standard list.
 */
@Component
public class SAIClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(SAIClient.class);

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    /**
     * Return StandardList by standard code.
     * @param code Standard code
     * @return List of Standards.
     * @throws DatatypeConfigurationException
     */
    public List<Standard> testClient(String code) throws DatatypeConfigurationException {

        ObjectFactory factory = new ObjectFactory();
        GetStandards getStandards = factory.createGetStandards();
        getStandards.getStandardsList().add(code);

        GetStandardsResponse getStandardsResponse = (GetStandardsResponse) webServiceTemplate.marshalSendAndReceive(getStandards);

        List<Standard> list = getStandardsResponse.getStandards();

        return list;
    }
}
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.06 at 09:04:28 PM AEDT 
//


package com.sai.ws;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sai.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sai.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Standard }
     * 
     */
    public Standard createStandard() {
        return new Standard();
    }

    /**
     * Create an instance of {@link GetStandardsResponse }
     * 
     */
    public GetStandardsResponse createGetStandardsResponse() {
        return new GetStandardsResponse();
    }

    /**
     * Create an instance of {@link GetStandards }
     * 
     */
    public GetStandards createGetStandards() {
        return new GetStandards();
    }

    /**
     * Create an instance of {@link Standard.Relationship }
     * 
     */
    public Standard.Relationship createStandardRelationship() {
        return new Standard.Relationship();
    }

}
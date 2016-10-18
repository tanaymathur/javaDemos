package com.pluralsight.cxfdemo.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.phase.Phase;
import org.w3c.dom.Element;

/**
 * Interceptor for processing requests in to the server. As part of message
 * handling, this interceptor will retrieve the API key from the SOAP header
 * using the namespace of the orders web service.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class OrderServiceSoapHeaderInInterceptor extends
      AbstractSoapInterceptor {

   /**
    * Set the phase for this interceptor to USER_PROTOCOL
    */
   public OrderServiceSoapHeaderInInterceptor() {
      super(Phase.USER_PROTOCOL);
   }

   @Override
   public void handleMessage(SoapMessage message) throws Fault {
      // Set the qualified name using the orders web service namespace and the
      // local part name of apikey.
      QName qname = new QName("http://www.pluralsight.com/service/Orders/",
            "apikey");

      // Get the SOAP header from the message using the qualified name.
      SoapHeader header = (SoapHeader) message.getHeader(qname);

      // Get the element from the soap header and set the api key to its text
      // content.
      String apikey = ((Element) header.getObject()).getTextContent();

      // Output the api key.
      System.err.println("API Key = " + apikey);

   }

}

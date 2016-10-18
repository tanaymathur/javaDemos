package com.pluralsight.cxfdemo.orders;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.interceptor.AbstractSoapInterceptor;
import org.apache.cxf.binding.soap.interceptor.SoapOutInterceptor;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.phase.Phase;

/**
 * Interceptor for processing outbound client requests. Enhances the soap
 * message by adding a header for an API key.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public class OrderServiceSoapHeaderOutInterceptor extends
      AbstractSoapInterceptor {

   /**
    * Constructor to set this interceptor phase as WRITE and to add the
    * interceptor before the SoapOutInterceptor class; otherwise, the soap
    * message will not be available in the state we need.
    */
   public OrderServiceSoapHeaderOutInterceptor() {
      super(Phase.WRITE);
      this.addBefore(SoapOutInterceptor.class.getName());

   }

   @Override
   public void handleMessage(SoapMessage message) throws Fault {
      // Create a qualified name using the orders web service namespace and the
      // local part name of apikey.
      QName qname = new QName("http://www.pluralsight.com/service/Orders/",
            "apikey");

      // Set the apikey value.
      String apikey = "a1b2c3d4e5";

      try {
         // Create a new soap header instance using the qualified name, apikey
         // and a JAXB data binding for the apikey string.
         SoapHeader header = new SoapHeader(qname, apikey, new JAXBDataBinding(
               apikey.getClass()));

         // Add the header to the message header.
         message.getHeaders().add(header);

      } catch (Exception e) {
         // Throw a fault if an exception occurs during header processing.
         throw new Fault(e);
      }

   }

}

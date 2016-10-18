package com.pluralsight.cxfdemo.orders;

import static org.junit.Assert.*;

import javax.xml.ws.soap.SOAPFaultException;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.pluralsight.schema.order.ObjectFactory;
import com.pluralsight.schema.order.OrderInquiryResponseType;
import com.pluralsight.schema.order.OrderInquiryType;
import com.pluralsight.service.orders.Orders;

/**
 * This is a test case for the DefaultOrdersEndpoint web service. The test case
 * contains two test methods. The first is a success scenario that executes a
 * happy path test of the orders web service. The second is an exception test.
 * It tests the failure scenario when a null input is passed by the client.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
// The @RunWith annotation tells jUnit to use the Spring jUnit 4 test runner for
// exection of the tests.
@RunWith(SpringJUnit4ClassRunner.class)
// The @ContextConfiguration annotation provides the classpath to the test
// spring configuration file.
@ContextConfiguration({ "classpath:test-beans.xml" })
public class DefaultOrdersEndpointTest {

   // Interface for the Orders web
   private Orders ordersService;

   // Input parameter to the web service.
   private OrderInquiryType orderInquiryType;

   // Auto wired from the CXF JAX-WS client configuration in the spring test
   // beans file
   @Autowired
   private JaxWsProxyFactoryBean testOrdersClient;

   // @Before indicates the method should be run prior to every test in the
   // class.
   @Before
   public void setUp() throws Exception {
      // Initialize the orders web service using the JaxWsProxyFactoryBean
      // class's create method. Pass in the Orders class to avoid having to cast
      // the resulting object.
      ordersService = testOrdersClient.create(Orders.class);

      // Initialize the request type
      ObjectFactory factory = new ObjectFactory();
      orderInquiryType = factory.createOrderInquiryType();
      orderInquiryType.setAccountId(999);
      orderInquiryType.setEan13(1234567890123L);
      orderInquiryType.setOrderQuantity(4);
      orderInquiryType.setUniqueOrderId(12345);

   }

   // @After indicates the method should be run after every test in the class.
   @After
   public void tearDown() throws Exception {
   }

   /**
    * Happy path test for a successful execution of the orders web service.
    */
   @Test
   public void testProcessOrderPlacementSuccess() {
      // Call the web service.
      OrderInquiryResponseType response = ordersService
            .processOrderPlacement(orderInquiryType);
      // Check that the account ID is equal to 999, which was set in the setUp
      // method.
      assertTrue(response.getAccount().getAccountId() == 999);

   }

   /**
    * Exception test for a failed execution of the orders web service.
    * 
    * @throws Exception
    */
   // @Test(expected) indicates that an exception is expected to be thrown from
   // the method.
   @Test(expected = SOAPFaultException.class)
   public void testProcessOrderPlacementFailureInvalidParameter()
         throws Exception {
      // Call the orders service process order placement method with null, which
      // will result in a SOAP fault.
      ordersService.processOrderPlacement(null);
   }

}

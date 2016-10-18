package com.pluralsight.cxfdemo.orders;

import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.pluralsight.schema.order.AccountType;
import com.pluralsight.schema.order.BookType;
import com.pluralsight.schema.order.ObjectFactory;
import com.pluralsight.schema.order.OrderInquiryResponseType;
import com.pluralsight.schema.order.OrderItemType;
import com.pluralsight.schema.order.OrderStatusType;
import com.pluralsight.schema.order.OrderType;

/**
 * Implementation of the core business logic around orders.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
@Service
public class DefaultOrderService implements OrderService {

   @Override
   public OrderInquiryResponseType processOrder(int uniqueOrderId,
         int orderQuantity, int accountId, long ean13) {
      // The ObjectFactory was generated as part of the Maven code-gen plug-in.
      // It wraps the creation of schema objects that were also generated. This
      // factory should be used for all schema object creation.
      ObjectFactory factory = new ObjectFactory();

      // 1. Create the response.
      OrderInquiryResponseType response = factory
            .createOrderInquiryResponseType();

      // 2. Create an account type.
      AccountType account = factory.createAccountType();
      account.setAccountId(accountId);
      response.setAccount(account);

      // 3. Create the order line item type and populate it.
      OrderItemType orderItem = factory.createOrderItemType();
      BookType book = factory.createBookType();
      book.setEan13(ean13);
      book.setTitle("A CXF Book");
      orderItem.setBook(book);
      try {
         GregorianCalendar cal = new GregorianCalendar();
         cal.setTime(new Date(System.currentTimeMillis()));
         XMLGregorianCalendar estimatedShippingDate = DatatypeFactory
               .newInstance().newXMLGregorianCalendar(cal);
         orderItem.setExpectedShippingDate(estimatedShippingDate);
      } catch (Exception e) {
         // TODO: Handle this exception.
      }
      orderItem.setLineNumber(Integer.valueOf(1));
      orderItem.setPrice(new BigDecimal(5));
      orderItem.setQuantityShipped(orderQuantity);

      // 4. Create the order and populate it.
      OrderType order = factory.createOrderType();
      order.setOrderStatus(OrderStatusType.READY);
      order.getOrderItems().add(orderItem);
      response.setOrder(order);

      // 5. Return the response.
      return response;
   }

}

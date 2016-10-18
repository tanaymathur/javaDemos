package com.pluralsight.cxfdemo.orders;

import com.pluralsight.schema.order.OrderInquiryResponseType;

/**
 * Interface for the internal service providing core business logic behavior and
 * members.
 * 
 * @author Michael Hoffman, Pluralsight
 * 
 */
public interface OrderService {

   /**
    * Service behavior that realizes the task of processing an order in the
    * system. Accepts key information from the customer then manipulates data,
    * sends messages, etc., to accomplish order processing. Returns an order
    * inquiry response type with the relevant information for the calling
    * consumer of the web service.
    * 
    * @param uniqueOrderId
    * @param orderQuantity
    * @param accountId
    * @param ean13
    * @return OrderInquiryResponseType
    */
   OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity,
         int accountId, long ean13);
}


package com.pluralsight.schema.order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for OrderInquiryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="OrderInquiryType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uniqueOrderId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orderQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ean13" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderInquiryType", propOrder = {
    "uniqueOrderId",
    "orderQuantity",
    "accountId",
    "ean13"
})
public class OrderInquiryType {

    protected int uniqueOrderId;
    protected int orderQuantity;
    protected int accountId;
    protected long ean13;

    /**
     * Gets the value of the uniqueOrderId property.
     * 
     */
    public int getUniqueOrderId() {
        return uniqueOrderId;
    }

    /**
     * Sets the value of the uniqueOrderId property.
     * 
     */
    public void setUniqueOrderId(int value) {
        this.uniqueOrderId = value;
    }

    /**
     * Gets the value of the orderQuantity property.
     * 
     */
    public int getOrderQuantity() {
        return orderQuantity;
    }

    /**
     * Sets the value of the orderQuantity property.
     * 
     */
    public void setOrderQuantity(int value) {
        this.orderQuantity = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     */
    public int getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     */
    public void setAccountId(int value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the ean13 property.
     * 
     */
    public long getEan13() {
        return ean13;
    }

    /**
     * Sets the value of the ean13 property.
     * 
     */
    public void setEan13(long value) {
        this.ean13 = value;
    }

}

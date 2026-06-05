package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AppointmentRef;
import org.openapitools.model.BillingAccountRef;
import org.openapitools.model.OrderItemActionType;
import org.openapitools.model.OrderItemRelationship;
import org.openapitools.model.OrderPrice;
import org.openapitools.model.OrderTerm;
import org.openapitools.model.PaymentRef;
import org.openapitools.model.ProductOfferingQualificationItemRef;
import org.openapitools.model.ProductOfferingQualificationRef;
import org.openapitools.model.ProductOfferingRef;
import org.openapitools.model.ProductOrderItemStateType;
import org.openapitools.model.ProductRefOrValue;
import org.openapitools.model.QuoteItemRef;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * An identified part of the order. A product order is decomposed into one or more order items.
 */

@Schema(name = "ProductOrderItem", description = "An identified part of the order. A product order is decomposed into one or more order items.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class ProductOrderItem {

  private String id;

  private @Nullable Integer quantity;

  private OrderItemActionType action;

  private @Nullable AppointmentRef appointment;

  private @Nullable BillingAccountRef billingAccount;

  @Valid
  private List<@Valid OrderPrice> itemPrice = new ArrayList<>();

  @Valid
  private List<@Valid OrderTerm> itemTerm = new ArrayList<>();

  @Valid
  private List<@Valid OrderPrice> itemTotalPrice = new ArrayList<>();

  @Valid
  private List<@Valid PaymentRef> payment = new ArrayList<>();

  private @Nullable ProductRefOrValue product;

  private @Nullable ProductOfferingRef productOffering;

  private @Nullable ProductOfferingQualificationItemRef productOfferingQualificationItem;

  @Valid
  private List<@Valid ProductOrderItem> productOrderItem = new ArrayList<>();

  @Valid
  private List<@Valid OrderItemRelationship> productOrderItemRelationship = new ArrayList<>();

  @Valid
  private List<@Valid ProductOfferingQualificationRef> qualification = new ArrayList<>();

  private @Nullable QuoteItemRef quoteItem;

  private @Nullable ProductOrderItemStateType state;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public ProductOrderItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductOrderItem(String id, OrderItemActionType action) {
    this.id = id;
    this.action = action;
  }

  public ProductOrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)
   * @return id
   */
  @NotNull 
  @Schema(name = "id", description = "Identifier of the line item (generally it is a sequence number 01, 02, 03, ...)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public ProductOrderItem quantity(@Nullable Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Quantity ordered
   * @return quantity
   */
  
  @Schema(name = "quantity", description = "Quantity ordered", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quantity")
  public @Nullable Integer getQuantity() {
    return quantity;
  }

  @JsonProperty("quantity")
  public void setQuantity(@Nullable Integer quantity) {
    this.quantity = quantity;
  }

  public ProductOrderItem action(OrderItemActionType action) {
    this.action = action;
    return this;
  }

  /**
   * Get action
   * @return action
   */
  @NotNull @Valid 
  @Schema(name = "action", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("action")
  public OrderItemActionType getAction() {
    return action;
  }

  @JsonProperty("action")
  public void setAction(OrderItemActionType action) {
    this.action = action;
  }

  public ProductOrderItem appointment(@Nullable AppointmentRef appointment) {
    this.appointment = appointment;
    return this;
  }

  /**
   * Get appointment
   * @return appointment
   */
  @Valid 
  @Schema(name = "appointment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("appointment")
  public @Nullable AppointmentRef getAppointment() {
    return appointment;
  }

  @JsonProperty("appointment")
  public void setAppointment(@Nullable AppointmentRef appointment) {
    this.appointment = appointment;
  }

  public ProductOrderItem billingAccount(@Nullable BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
    return this;
  }

  /**
   * Get billingAccount
   * @return billingAccount
   */
  @Valid 
  @Schema(name = "billingAccount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("billingAccount")
  public @Nullable BillingAccountRef getBillingAccount() {
    return billingAccount;
  }

  @JsonProperty("billingAccount")
  public void setBillingAccount(@Nullable BillingAccountRef billingAccount) {
    this.billingAccount = billingAccount;
  }

  public ProductOrderItem itemPrice(List<@Valid OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
    return this;
  }

  public ProductOrderItem addItemPriceItem(OrderPrice itemPriceItem) {
    if (this.itemPrice == null) {
      this.itemPrice = new ArrayList<>();
    }
    this.itemPrice.add(itemPriceItem);
    return this;
  }

  /**
   * Get itemPrice
   * @return itemPrice
   */
  @Valid 
  @Schema(name = "itemPrice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemPrice")
  public List<@Valid OrderPrice> getItemPrice() {
    return itemPrice;
  }

  @JsonProperty("itemPrice")
  public void setItemPrice(List<@Valid OrderPrice> itemPrice) {
    this.itemPrice = itemPrice;
  }

  public ProductOrderItem itemTerm(List<@Valid OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
    return this;
  }

  public ProductOrderItem addItemTermItem(OrderTerm itemTermItem) {
    if (this.itemTerm == null) {
      this.itemTerm = new ArrayList<>();
    }
    this.itemTerm.add(itemTermItem);
    return this;
  }

  /**
   * Get itemTerm
   * @return itemTerm
   */
  @Valid 
  @Schema(name = "itemTerm", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemTerm")
  public List<@Valid OrderTerm> getItemTerm() {
    return itemTerm;
  }

  @JsonProperty("itemTerm")
  public void setItemTerm(List<@Valid OrderTerm> itemTerm) {
    this.itemTerm = itemTerm;
  }

  public ProductOrderItem itemTotalPrice(List<@Valid OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
    return this;
  }

  public ProductOrderItem addItemTotalPriceItem(OrderPrice itemTotalPriceItem) {
    if (this.itemTotalPrice == null) {
      this.itemTotalPrice = new ArrayList<>();
    }
    this.itemTotalPrice.add(itemTotalPriceItem);
    return this;
  }

  /**
   * Get itemTotalPrice
   * @return itemTotalPrice
   */
  @Valid 
  @Schema(name = "itemTotalPrice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("itemTotalPrice")
  public List<@Valid OrderPrice> getItemTotalPrice() {
    return itemTotalPrice;
  }

  @JsonProperty("itemTotalPrice")
  public void setItemTotalPrice(List<@Valid OrderPrice> itemTotalPrice) {
    this.itemTotalPrice = itemTotalPrice;
  }

  public ProductOrderItem payment(List<@Valid PaymentRef> payment) {
    this.payment = payment;
    return this;
  }

  public ProductOrderItem addPaymentItem(PaymentRef paymentItem) {
    if (this.payment == null) {
      this.payment = new ArrayList<>();
    }
    this.payment.add(paymentItem);
    return this;
  }

  /**
   * Get payment
   * @return payment
   */
  @Valid 
  @Schema(name = "payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("payment")
  public List<@Valid PaymentRef> getPayment() {
    return payment;
  }

  @JsonProperty("payment")
  public void setPayment(List<@Valid PaymentRef> payment) {
    this.payment = payment;
  }

  public ProductOrderItem product(@Nullable ProductRefOrValue product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   */
  @Valid 
  @Schema(name = "product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product")
  public @Nullable ProductRefOrValue getProduct() {
    return product;
  }

  @JsonProperty("product")
  public void setProduct(@Nullable ProductRefOrValue product) {
    this.product = product;
  }

  public ProductOrderItem productOffering(@Nullable ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
    return this;
  }

  /**
   * Get productOffering
   * @return productOffering
   */
  @Valid 
  @Schema(name = "productOffering", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOffering")
  public @Nullable ProductOfferingRef getProductOffering() {
    return productOffering;
  }

  @JsonProperty("productOffering")
  public void setProductOffering(@Nullable ProductOfferingRef productOffering) {
    this.productOffering = productOffering;
  }

  public ProductOrderItem productOfferingQualificationItem(@Nullable ProductOfferingQualificationItemRef productOfferingQualificationItem) {
    this.productOfferingQualificationItem = productOfferingQualificationItem;
    return this;
  }

  /**
   * Get productOfferingQualificationItem
   * @return productOfferingQualificationItem
   */
  @Valid 
  @Schema(name = "productOfferingQualificationItem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOfferingQualificationItem")
  public @Nullable ProductOfferingQualificationItemRef getProductOfferingQualificationItem() {
    return productOfferingQualificationItem;
  }

  @JsonProperty("productOfferingQualificationItem")
  public void setProductOfferingQualificationItem(@Nullable ProductOfferingQualificationItemRef productOfferingQualificationItem) {
    this.productOfferingQualificationItem = productOfferingQualificationItem;
  }

  public ProductOrderItem productOrderItem(List<@Valid ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
    return this;
  }

  public ProductOrderItem addProductOrderItemItem(ProductOrderItem productOrderItemItem) {
    if (this.productOrderItem == null) {
      this.productOrderItem = new ArrayList<>();
    }
    this.productOrderItem.add(productOrderItemItem);
    return this;
  }

  /**
   * Get productOrderItem
   * @return productOrderItem
   */
  @Valid 
  @Schema(name = "productOrderItem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOrderItem")
  public List<@Valid ProductOrderItem> getProductOrderItem() {
    return productOrderItem;
  }

  @JsonProperty("productOrderItem")
  public void setProductOrderItem(List<@Valid ProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
  }

  public ProductOrderItem productOrderItemRelationship(List<@Valid OrderItemRelationship> productOrderItemRelationship) {
    this.productOrderItemRelationship = productOrderItemRelationship;
    return this;
  }

  public ProductOrderItem addProductOrderItemRelationshipItem(OrderItemRelationship productOrderItemRelationshipItem) {
    if (this.productOrderItemRelationship == null) {
      this.productOrderItemRelationship = new ArrayList<>();
    }
    this.productOrderItemRelationship.add(productOrderItemRelationshipItem);
    return this;
  }

  /**
   * Get productOrderItemRelationship
   * @return productOrderItemRelationship
   */
  @Valid 
  @Schema(name = "productOrderItemRelationship", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOrderItemRelationship")
  public List<@Valid OrderItemRelationship> getProductOrderItemRelationship() {
    return productOrderItemRelationship;
  }

  @JsonProperty("productOrderItemRelationship")
  public void setProductOrderItemRelationship(List<@Valid OrderItemRelationship> productOrderItemRelationship) {
    this.productOrderItemRelationship = productOrderItemRelationship;
  }

  public ProductOrderItem qualification(List<@Valid ProductOfferingQualificationRef> qualification) {
    this.qualification = qualification;
    return this;
  }

  public ProductOrderItem addQualificationItem(ProductOfferingQualificationRef qualificationItem) {
    if (this.qualification == null) {
      this.qualification = new ArrayList<>();
    }
    this.qualification.add(qualificationItem);
    return this;
  }

  /**
   * Get qualification
   * @return qualification
   */
  @Valid 
  @Schema(name = "qualification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("qualification")
  public List<@Valid ProductOfferingQualificationRef> getQualification() {
    return qualification;
  }

  @JsonProperty("qualification")
  public void setQualification(List<@Valid ProductOfferingQualificationRef> qualification) {
    this.qualification = qualification;
  }

  public ProductOrderItem quoteItem(@Nullable QuoteItemRef quoteItem) {
    this.quoteItem = quoteItem;
    return this;
  }

  /**
   * Get quoteItem
   * @return quoteItem
   */
  @Valid 
  @Schema(name = "quoteItem", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quoteItem")
  public @Nullable QuoteItemRef getQuoteItem() {
    return quoteItem;
  }

  @JsonProperty("quoteItem")
  public void setQuoteItem(@Nullable QuoteItemRef quoteItem) {
    this.quoteItem = quoteItem;
  }

  public ProductOrderItem state(@Nullable ProductOrderItemStateType state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   */
  @Valid 
  @Schema(name = "state", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("state")
  public @Nullable ProductOrderItemStateType getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(@Nullable ProductOrderItemStateType state) {
    this.state = state;
  }

  public ProductOrderItem atBaseType(@Nullable String atBaseType) {
    this.atBaseType = atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return atBaseType
   */
  
  @Schema(name = "@baseType", description = "When sub-classing, this defines the super-class", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@baseType")
  public @Nullable String getAtBaseType() {
    return atBaseType;
  }

  @JsonProperty("@baseType")
  public void setAtBaseType(@Nullable String atBaseType) {
    this.atBaseType = atBaseType;
  }

  public ProductOrderItem atSchemaLocation(@Nullable URI atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return atSchemaLocation
   */
  @Valid 
  @Schema(name = "@schemaLocation", description = "A URI to a JSON-Schema file that defines additional attributes and relationships", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@schemaLocation")
  public @Nullable URI getAtSchemaLocation() {
    return atSchemaLocation;
  }

  @JsonProperty("@schemaLocation")
  public void setAtSchemaLocation(@Nullable URI atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  public ProductOrderItem atType(@Nullable String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class entity name
   * @return atType
   */
  
  @Schema(name = "@type", description = "When sub-classing, this defines the sub-class entity name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@type")
  public @Nullable String getAtType() {
    return atType;
  }

  @JsonProperty("@type")
  public void setAtType(@Nullable String atType) {
    this.atType = atType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductOrderItem productOrderItem = (ProductOrderItem) o;
    return Objects.equals(this.id, productOrderItem.id) &&
        Objects.equals(this.quantity, productOrderItem.quantity) &&
        Objects.equals(this.action, productOrderItem.action) &&
        Objects.equals(this.appointment, productOrderItem.appointment) &&
        Objects.equals(this.billingAccount, productOrderItem.billingAccount) &&
        Objects.equals(this.itemPrice, productOrderItem.itemPrice) &&
        Objects.equals(this.itemTerm, productOrderItem.itemTerm) &&
        Objects.equals(this.itemTotalPrice, productOrderItem.itemTotalPrice) &&
        Objects.equals(this.payment, productOrderItem.payment) &&
        Objects.equals(this.product, productOrderItem.product) &&
        Objects.equals(this.productOffering, productOrderItem.productOffering) &&
        Objects.equals(this.productOfferingQualificationItem, productOrderItem.productOfferingQualificationItem) &&
        Objects.equals(this.productOrderItem, productOrderItem.productOrderItem) &&
        Objects.equals(this.productOrderItemRelationship, productOrderItem.productOrderItemRelationship) &&
        Objects.equals(this.qualification, productOrderItem.qualification) &&
        Objects.equals(this.quoteItem, productOrderItem.quoteItem) &&
        Objects.equals(this.state, productOrderItem.state) &&
        Objects.equals(this.atBaseType, productOrderItem.atBaseType) &&
        Objects.equals(this.atSchemaLocation, productOrderItem.atSchemaLocation) &&
        Objects.equals(this.atType, productOrderItem.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, quantity, action, appointment, billingAccount, itemPrice, itemTerm, itemTotalPrice, payment, product, productOffering, productOfferingQualificationItem, productOrderItem, productOrderItemRelationship, qualification, quoteItem, state, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOrderItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    appointment: ").append(toIndentedString(appointment)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("    itemTerm: ").append(toIndentedString(itemTerm)).append("\n");
    sb.append("    itemTotalPrice: ").append(toIndentedString(itemTotalPrice)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    productOfferingQualificationItem: ").append(toIndentedString(productOfferingQualificationItem)).append("\n");
    sb.append("    productOrderItem: ").append(toIndentedString(productOrderItem)).append("\n");
    sb.append("    productOrderItemRelationship: ").append(toIndentedString(productOrderItemRelationship)).append("\n");
    sb.append("    qualification: ").append(toIndentedString(qualification)).append("\n");
    sb.append("    quoteItem: ").append(toIndentedString(quoteItem)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    atBaseType: ").append(toIndentedString(atBaseType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(@Nullable Object o) {
    return o == null ? "null" : o.toString().replace("\n", "\n    ");
  }
}


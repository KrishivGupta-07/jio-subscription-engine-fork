package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.BillingAccountRef;
import org.openapitools.model.Price;
import org.openapitools.model.PriceAlteration;
import org.openapitools.model.ProductOfferingPriceRef;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * An amount, usually of money, that represents the actual price paid by the Customer for this item or this order
 */

@Schema(name = "OrderPrice", description = "An amount, usually of money, that represents the actual price paid by the Customer for this item or this order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class OrderPrice {

  private @Nullable String description;

  private @Nullable String name;

  private @Nullable String priceType;

  private @Nullable String recurringChargePeriod;

  private @Nullable String unitOfMeasure;

  private @Nullable BillingAccountRef billingAccount;

  private @Nullable Price price;

  @Valid
  private List<@Valid PriceAlteration> priceAlteration = new ArrayList<>();

  private @Nullable ProductOfferingPriceRef productOfferingPrice;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public OrderPrice description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail the semantics of this order item price.
   * @return description
   */
  
  @Schema(name = "description", description = "A narrative that explains in detail the semantics of this order item price.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public OrderPrice name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * A short descriptive name such as \"Subscription price\".
   * @return name
   */
  
  @Schema(name = "name", description = "A short descriptive name such as \"Subscription price\".", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(@Nullable String name) {
    this.name = name;
  }

  public OrderPrice priceType(@Nullable String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * A category that describes the price, such as recurring, discount, allowance, penalty, and so forth
   * @return priceType
   */
  
  @Schema(name = "priceType", description = "A category that describes the price, such as recurring, discount, allowance, penalty, and so forth", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priceType")
  public @Nullable String getPriceType() {
    return priceType;
  }

  @JsonProperty("priceType")
  public void setPriceType(@Nullable String priceType) {
    this.priceType = priceType;
  }

  public OrderPrice recurringChargePeriod(@Nullable String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
    return this;
  }

  /**
   * Could be month, week...
   * @return recurringChargePeriod
   */
  
  @Schema(name = "recurringChargePeriod", description = "Could be month, week...", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("recurringChargePeriod")
  public @Nullable String getRecurringChargePeriod() {
    return recurringChargePeriod;
  }

  @JsonProperty("recurringChargePeriod")
  public void setRecurringChargePeriod(@Nullable String recurringChargePeriod) {
    this.recurringChargePeriod = recurringChargePeriod;
  }

  public OrderPrice unitOfMeasure(@Nullable String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

  /**
   * Could be minutes, GB...
   * @return unitOfMeasure
   */
  
  @Schema(name = "unitOfMeasure", description = "Could be minutes, GB...", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("unitOfMeasure")
  public @Nullable String getUnitOfMeasure() {
    return unitOfMeasure;
  }

  @JsonProperty("unitOfMeasure")
  public void setUnitOfMeasure(@Nullable String unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public OrderPrice billingAccount(@Nullable BillingAccountRef billingAccount) {
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

  public OrderPrice price(@Nullable Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   */
  @Valid 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public @Nullable Price getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(@Nullable Price price) {
    this.price = price;
  }

  public OrderPrice priceAlteration(List<@Valid PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
    return this;
  }

  public OrderPrice addPriceAlterationItem(PriceAlteration priceAlterationItem) {
    if (this.priceAlteration == null) {
      this.priceAlteration = new ArrayList<>();
    }
    this.priceAlteration.add(priceAlterationItem);
    return this;
  }

  /**
   * a strucuture used to describe a price alteration
   * @return priceAlteration
   */
  @Valid 
  @Schema(name = "priceAlteration", description = "a strucuture used to describe a price alteration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priceAlteration")
  public List<@Valid PriceAlteration> getPriceAlteration() {
    return priceAlteration;
  }

  @JsonProperty("priceAlteration")
  public void setPriceAlteration(List<@Valid PriceAlteration> priceAlteration) {
    this.priceAlteration = priceAlteration;
  }

  public OrderPrice productOfferingPrice(@Nullable ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
    return this;
  }

  /**
   * Get productOfferingPrice
   * @return productOfferingPrice
   */
  @Valid 
  @Schema(name = "productOfferingPrice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOfferingPrice")
  public @Nullable ProductOfferingPriceRef getProductOfferingPrice() {
    return productOfferingPrice;
  }

  @JsonProperty("productOfferingPrice")
  public void setProductOfferingPrice(@Nullable ProductOfferingPriceRef productOfferingPrice) {
    this.productOfferingPrice = productOfferingPrice;
  }

  public OrderPrice atBaseType(@Nullable String atBaseType) {
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

  public OrderPrice atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public OrderPrice atType(@Nullable String atType) {
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
    OrderPrice orderPrice = (OrderPrice) o;
    return Objects.equals(this.description, orderPrice.description) &&
        Objects.equals(this.name, orderPrice.name) &&
        Objects.equals(this.priceType, orderPrice.priceType) &&
        Objects.equals(this.recurringChargePeriod, orderPrice.recurringChargePeriod) &&
        Objects.equals(this.unitOfMeasure, orderPrice.unitOfMeasure) &&
        Objects.equals(this.billingAccount, orderPrice.billingAccount) &&
        Objects.equals(this.price, orderPrice.price) &&
        Objects.equals(this.priceAlteration, orderPrice.priceAlteration) &&
        Objects.equals(this.productOfferingPrice, orderPrice.productOfferingPrice) &&
        Objects.equals(this.atBaseType, orderPrice.atBaseType) &&
        Objects.equals(this.atSchemaLocation, orderPrice.atSchemaLocation) &&
        Objects.equals(this.atType, orderPrice.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, name, priceType, recurringChargePeriod, unitOfMeasure, billingAccount, price, priceAlteration, productOfferingPrice, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderPrice {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    priceAlteration: ").append(toIndentedString(priceAlteration)).append("\n");
    sb.append("    productOfferingPrice: ").append(toIndentedString(productOfferingPrice)).append("\n");
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


package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import org.openapitools.model.Price;
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
 * Is an amount, usually of money, that modifies the price charged for an order item.
 */

@Schema(name = "PriceAlteration", description = "Is an amount, usually of money, that modifies the price charged for an order item.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class PriceAlteration {

  private @Nullable Integer applicationDuration;

  private @Nullable String description;

  private @Nullable String name;

  private String priceType;

  private @Nullable Integer priority;

  private @Nullable String recurringChargePeriod;

  private @Nullable String unitOfMeasure;

  private Price price;

  private @Nullable ProductOfferingPriceRef productOfferingPrice;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public PriceAlteration() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PriceAlteration(String priceType, Price price) {
    this.priceType = priceType;
    this.price = price;
  }

  public PriceAlteration applicationDuration(@Nullable Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
    return this;
  }

  /**
   * Duration during which the alteration applies on the order item price (for instance 2 months free of charge for the recurring charge)
   * @return applicationDuration
   */
  
  @Schema(name = "applicationDuration", description = "Duration during which the alteration applies on the order item price (for instance 2 months free of charge for the recurring charge)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("applicationDuration")
  public @Nullable Integer getApplicationDuration() {
    return applicationDuration;
  }

  @JsonProperty("applicationDuration")
  public void setApplicationDuration(@Nullable Integer applicationDuration) {
    this.applicationDuration = applicationDuration;
  }

  public PriceAlteration description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * A narrative that explains in detail the semantics of this order item price alteration
   * @return description
   */
  
  @Schema(name = "description", description = "A narrative that explains in detail the semantics of this order item price alteration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public PriceAlteration name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the order item price alteration
   * @return name
   */
  
  @Schema(name = "name", description = "Name of the order item price alteration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(@Nullable String name) {
    this.name = name;
  }

  public PriceAlteration priceType(String priceType) {
    this.priceType = priceType;
    return this;
  }

  /**
   * A category that describes the price such as recurring, one time and usage.
   * @return priceType
   */
  @NotNull 
  @Schema(name = "priceType", description = "A category that describes the price such as recurring, one time and usage.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("priceType")
  public String getPriceType() {
    return priceType;
  }

  @JsonProperty("priceType")
  public void setPriceType(String priceType) {
    this.priceType = priceType;
  }

  public PriceAlteration priority(@Nullable Integer priority) {
    this.priority = priority;
    return this;
  }

  /**
   * Priority level for applying this alteration among all the defined alterations on the order item price
   * @return priority
   */
  
  @Schema(name = "priority", description = "Priority level for applying this alteration among all the defined alterations on the order item price", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("priority")
  public @Nullable Integer getPriority() {
    return priority;
  }

  @JsonProperty("priority")
  public void setPriority(@Nullable Integer priority) {
    this.priority = priority;
  }

  public PriceAlteration recurringChargePeriod(@Nullable String recurringChargePeriod) {
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

  public PriceAlteration unitOfMeasure(@Nullable String unitOfMeasure) {
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

  public PriceAlteration price(Price price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
   */
  @NotNull @Valid 
  @Schema(name = "price", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Price getPrice() {
    return price;
  }

  @JsonProperty("price")
  public void setPrice(Price price) {
    this.price = price;
  }

  public PriceAlteration productOfferingPrice(@Nullable ProductOfferingPriceRef productOfferingPrice) {
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

  public PriceAlteration atBaseType(@Nullable String atBaseType) {
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

  public PriceAlteration atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public PriceAlteration atType(@Nullable String atType) {
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
    PriceAlteration priceAlteration = (PriceAlteration) o;
    return Objects.equals(this.applicationDuration, priceAlteration.applicationDuration) &&
        Objects.equals(this.description, priceAlteration.description) &&
        Objects.equals(this.name, priceAlteration.name) &&
        Objects.equals(this.priceType, priceAlteration.priceType) &&
        Objects.equals(this.priority, priceAlteration.priority) &&
        Objects.equals(this.recurringChargePeriod, priceAlteration.recurringChargePeriod) &&
        Objects.equals(this.unitOfMeasure, priceAlteration.unitOfMeasure) &&
        Objects.equals(this.price, priceAlteration.price) &&
        Objects.equals(this.productOfferingPrice, priceAlteration.productOfferingPrice) &&
        Objects.equals(this.atBaseType, priceAlteration.atBaseType) &&
        Objects.equals(this.atSchemaLocation, priceAlteration.atSchemaLocation) &&
        Objects.equals(this.atType, priceAlteration.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(applicationDuration, description, name, priceType, priority, recurringChargePeriod, unitOfMeasure, price, productOfferingPrice, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceAlteration {\n");
    sb.append("    applicationDuration: ").append(toIndentedString(applicationDuration)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    priceType: ").append(toIndentedString(priceType)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    recurringChargePeriod: ").append(toIndentedString(recurringChargePeriod)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
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


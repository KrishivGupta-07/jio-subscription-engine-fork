package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * RelatedProductOrderItem (ProductOrder item) .The product order item which triggered product creation/change/termination.
 */

@Schema(name = "RelatedProductOrderItem", description = "RelatedProductOrderItem (ProductOrder item) .The product order item which triggered product creation/change/termination.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class RelatedProductOrderItem {

  private @Nullable String orderItemAction;

  private String orderItemId;

  private @Nullable String productOrderHref;

  private String productOrderId;

  private @Nullable String role;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  private @Nullable String atReferredType;

  public RelatedProductOrderItem() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public RelatedProductOrderItem(String orderItemId, String productOrderId) {
    this.orderItemId = orderItemId;
    this.productOrderId = productOrderId;
  }

  public RelatedProductOrderItem orderItemAction(@Nullable String orderItemAction) {
    this.orderItemAction = orderItemAction;
    return this;
  }

  /**
   * Action of the order item for this product
   * @return orderItemAction
   */
  
  @Schema(name = "orderItemAction", description = "Action of the order item for this product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderItemAction")
  public @Nullable String getOrderItemAction() {
    return orderItemAction;
  }

  @JsonProperty("orderItemAction")
  public void setOrderItemAction(@Nullable String orderItemAction) {
    this.orderItemAction = orderItemAction;
  }

  public RelatedProductOrderItem orderItemId(String orderItemId) {
    this.orderItemId = orderItemId;
    return this;
  }

  /**
   * Identifier of the order item where the product was managed
   * @return orderItemId
   */
  @NotNull 
  @Schema(name = "orderItemId", description = "Identifier of the order item where the product was managed", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderItemId")
  public String getOrderItemId() {
    return orderItemId;
  }

  @JsonProperty("orderItemId")
  public void setOrderItemId(String orderItemId) {
    this.orderItemId = orderItemId;
  }

  public RelatedProductOrderItem productOrderHref(@Nullable String productOrderHref) {
    this.productOrderHref = productOrderHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return productOrderHref
   */
  
  @Schema(name = "productOrderHref", description = "Reference of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOrderHref")
  public @Nullable String getProductOrderHref() {
    return productOrderHref;
  }

  @JsonProperty("productOrderHref")
  public void setProductOrderHref(@Nullable String productOrderHref) {
    this.productOrderHref = productOrderHref;
  }

  public RelatedProductOrderItem productOrderId(String productOrderId) {
    this.productOrderId = productOrderId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return productOrderId
   */
  @NotNull 
  @Schema(name = "productOrderId", description = "Unique identifier of a related entity.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productOrderId")
  public String getProductOrderId() {
    return productOrderId;
  }

  @JsonProperty("productOrderId")
  public void setProductOrderId(String productOrderId) {
    this.productOrderId = productOrderId;
  }

  public RelatedProductOrderItem role(@Nullable String role) {
    this.role = role;
    return this;
  }

  /**
   * role of the product order item for this product
   * @return role
   */
  
  @Schema(name = "role", description = "role of the product order item for this product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("role")
  public @Nullable String getRole() {
    return role;
  }

  @JsonProperty("role")
  public void setRole(@Nullable String role) {
    this.role = role;
  }

  public RelatedProductOrderItem atBaseType(@Nullable String atBaseType) {
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

  public RelatedProductOrderItem atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public RelatedProductOrderItem atType(@Nullable String atType) {
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

  public RelatedProductOrderItem atReferredType(@Nullable String atReferredType) {
    this.atReferredType = atReferredType;
    return this;
  }

  /**
   * The actual type of the target instance when needed for disambiguation.
   * @return atReferredType
   */
  
  @Schema(name = "@referredType", description = "The actual type of the target instance when needed for disambiguation.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@referredType")
  public @Nullable String getAtReferredType() {
    return atReferredType;
  }

  @JsonProperty("@referredType")
  public void setAtReferredType(@Nullable String atReferredType) {
    this.atReferredType = atReferredType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RelatedProductOrderItem relatedProductOrderItem = (RelatedProductOrderItem) o;
    return Objects.equals(this.orderItemAction, relatedProductOrderItem.orderItemAction) &&
        Objects.equals(this.orderItemId, relatedProductOrderItem.orderItemId) &&
        Objects.equals(this.productOrderHref, relatedProductOrderItem.productOrderHref) &&
        Objects.equals(this.productOrderId, relatedProductOrderItem.productOrderId) &&
        Objects.equals(this.role, relatedProductOrderItem.role) &&
        Objects.equals(this.atBaseType, relatedProductOrderItem.atBaseType) &&
        Objects.equals(this.atSchemaLocation, relatedProductOrderItem.atSchemaLocation) &&
        Objects.equals(this.atType, relatedProductOrderItem.atType) &&
        Objects.equals(this.atReferredType, relatedProductOrderItem.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderItemAction, orderItemId, productOrderHref, productOrderId, role, atBaseType, atSchemaLocation, atType, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RelatedProductOrderItem {\n");
    sb.append("    orderItemAction: ").append(toIndentedString(orderItemAction)).append("\n");
    sb.append("    orderItemId: ").append(toIndentedString(orderItemId)).append("\n");
    sb.append("    productOrderHref: ").append(toIndentedString(productOrderHref)).append("\n");
    sb.append("    productOrderId: ").append(toIndentedString(productOrderId)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("    atBaseType: ").append(toIndentedString(atBaseType)).append("\n");
    sb.append("    atSchemaLocation: ").append(toIndentedString(atSchemaLocation)).append("\n");
    sb.append("    atType: ").append(toIndentedString(atType)).append("\n");
    sb.append("    atReferredType: ").append(toIndentedString(atReferredType)).append("\n");
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


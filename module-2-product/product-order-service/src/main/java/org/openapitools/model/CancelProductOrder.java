package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.time.OffsetDateTime;
import org.openapitools.model.ProductOrderRef;
import org.openapitools.model.TaskStateType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Request for cancellation an existing product order
 */

@Schema(name = "CancelProductOrder", description = "Request for cancellation an existing product order")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class CancelProductOrder {

  private @Nullable String id;

  private @Nullable String href;

  private @Nullable String cancellationReason;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime effectiveCancellationDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime requestedCancellationDate;

  private ProductOrderRef productOrder;

  private @Nullable TaskStateType state;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public CancelProductOrder() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CancelProductOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
  }

  public CancelProductOrder id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * id of the cancellation request (this is not an order id)
   * @return id
   */
  
  @Schema(name = "id", description = "id of the cancellation request (this is not an order id)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(@Nullable String id) {
    this.id = id;
  }

  public CancelProductOrder href(@Nullable String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink to access the cancellation request
   * @return href
   */
  
  @Schema(name = "href", description = "Hyperlink to access the cancellation request", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("href")
  public @Nullable String getHref() {
    return href;
  }

  @JsonProperty("href")
  public void setHref(@Nullable String href) {
    this.href = href;
  }

  public CancelProductOrder cancellationReason(@Nullable String cancellationReason) {
    this.cancellationReason = cancellationReason;
    return this;
  }

  /**
   * Reason why the order is cancelled.
   * @return cancellationReason
   */
  
  @Schema(name = "cancellationReason", description = "Reason why the order is cancelled.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cancellationReason")
  public @Nullable String getCancellationReason() {
    return cancellationReason;
  }

  @JsonProperty("cancellationReason")
  public void setCancellationReason(@Nullable String cancellationReason) {
    this.cancellationReason = cancellationReason;
  }

  public CancelProductOrder effectiveCancellationDate(@Nullable OffsetDateTime effectiveCancellationDate) {
    this.effectiveCancellationDate = effectiveCancellationDate;
    return this;
  }

  /**
   * Date when the order is cancelled.
   * @return effectiveCancellationDate
   */
  @Valid 
  @Schema(name = "effectiveCancellationDate", description = "Date when the order is cancelled.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("effectiveCancellationDate")
  public @Nullable OffsetDateTime getEffectiveCancellationDate() {
    return effectiveCancellationDate;
  }

  @JsonProperty("effectiveCancellationDate")
  public void setEffectiveCancellationDate(@Nullable OffsetDateTime effectiveCancellationDate) {
    this.effectiveCancellationDate = effectiveCancellationDate;
  }

  public CancelProductOrder requestedCancellationDate(@Nullable OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
    return this;
  }

  /**
   * Date when the submitter wants the order to be cancelled
   * @return requestedCancellationDate
   */
  @Valid 
  @Schema(name = "requestedCancellationDate", description = "Date when the submitter wants the order to be cancelled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("requestedCancellationDate")
  public @Nullable OffsetDateTime getRequestedCancellationDate() {
    return requestedCancellationDate;
  }

  @JsonProperty("requestedCancellationDate")
  public void setRequestedCancellationDate(@Nullable OffsetDateTime requestedCancellationDate) {
    this.requestedCancellationDate = requestedCancellationDate;
  }

  public CancelProductOrder productOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
    return this;
  }

  /**
   * Get productOrder
   * @return productOrder
   */
  @NotNull @Valid 
  @Schema(name = "productOrder", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productOrder")
  public ProductOrderRef getProductOrder() {
    return productOrder;
  }

  @JsonProperty("productOrder")
  public void setProductOrder(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
  }

  public CancelProductOrder state(@Nullable TaskStateType state) {
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
  public @Nullable TaskStateType getState() {
    return state;
  }

  @JsonProperty("state")
  public void setState(@Nullable TaskStateType state) {
    this.state = state;
  }

  public CancelProductOrder atBaseType(@Nullable String atBaseType) {
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

  public CancelProductOrder atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public CancelProductOrder atType(@Nullable String atType) {
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
    CancelProductOrder cancelProductOrder = (CancelProductOrder) o;
    return Objects.equals(this.id, cancelProductOrder.id) &&
        Objects.equals(this.href, cancelProductOrder.href) &&
        Objects.equals(this.cancellationReason, cancelProductOrder.cancellationReason) &&
        Objects.equals(this.effectiveCancellationDate, cancelProductOrder.effectiveCancellationDate) &&
        Objects.equals(this.requestedCancellationDate, cancelProductOrder.requestedCancellationDate) &&
        Objects.equals(this.productOrder, cancelProductOrder.productOrder) &&
        Objects.equals(this.state, cancelProductOrder.state) &&
        Objects.equals(this.atBaseType, cancelProductOrder.atBaseType) &&
        Objects.equals(this.atSchemaLocation, cancelProductOrder.atSchemaLocation) &&
        Objects.equals(this.atType, cancelProductOrder.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, cancellationReason, effectiveCancellationDate, requestedCancellationDate, productOrder, state, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrder {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    effectiveCancellationDate: ").append(toIndentedString(effectiveCancellationDate)).append("\n");
    sb.append("    requestedCancellationDate: ").append(toIndentedString(requestedCancellationDate)).append("\n");
    sb.append("    productOrder: ").append(toIndentedString(productOrder)).append("\n");
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


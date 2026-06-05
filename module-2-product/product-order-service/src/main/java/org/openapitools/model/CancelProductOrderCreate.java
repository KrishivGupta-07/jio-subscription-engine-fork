package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import java.time.OffsetDateTime;
import org.openapitools.model.ProductOrderRef;
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
 * Request for cancellation an existing product order Skipped properties: id,href,state,effectiveCancellationDate
 */

@Schema(name = "CancelProductOrder_Create", description = "Request for cancellation an existing product order Skipped properties: id,href,state,effectiveCancellationDate")
@JsonTypeName("CancelProductOrder_Create")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class CancelProductOrderCreate {

  private @Nullable String cancellationReason;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime requestedCancellationDate;

  private ProductOrderRef productOrder;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public CancelProductOrderCreate() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CancelProductOrderCreate(ProductOrderRef productOrder) {
    this.productOrder = productOrder;
  }

  public CancelProductOrderCreate cancellationReason(@Nullable String cancellationReason) {
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

  public CancelProductOrderCreate requestedCancellationDate(@Nullable OffsetDateTime requestedCancellationDate) {
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

  public CancelProductOrderCreate productOrder(ProductOrderRef productOrder) {
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

  public CancelProductOrderCreate atBaseType(@Nullable String atBaseType) {
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

  public CancelProductOrderCreate atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public CancelProductOrderCreate atType(@Nullable String atType) {
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
    CancelProductOrderCreate cancelProductOrderCreate = (CancelProductOrderCreate) o;
    return Objects.equals(this.cancellationReason, cancelProductOrderCreate.cancellationReason) &&
        Objects.equals(this.requestedCancellationDate, cancelProductOrderCreate.requestedCancellationDate) &&
        Objects.equals(this.productOrder, cancelProductOrderCreate.productOrder) &&
        Objects.equals(this.atBaseType, cancelProductOrderCreate.atBaseType) &&
        Objects.equals(this.atSchemaLocation, cancelProductOrderCreate.atSchemaLocation) &&
        Objects.equals(this.atType, cancelProductOrderCreate.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancellationReason, requestedCancellationDate, productOrder, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrderCreate {\n");
    sb.append("    cancellationReason: ").append(toIndentedString(cancellationReason)).append("\n");
    sb.append("    requestedCancellationDate: ").append(toIndentedString(requestedCancellationDate)).append("\n");
    sb.append("    productOrder: ").append(toIndentedString(productOrder)).append("\n");
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


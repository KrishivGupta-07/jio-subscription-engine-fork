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
 * It&#39;s a productOfferingQualification item that has been executed previously.
 */

@Schema(name = "ProductOfferingQualificationItemRef", description = "It's a productOfferingQualification item that has been executed previously.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class ProductOfferingQualificationItemRef {

  private String id;

  private @Nullable String productOfferingQualificationHref;

  private String productOfferingQualificationId;

  private @Nullable String productOfferingQualificationName;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  private @Nullable String atReferredType;

  public ProductOfferingQualificationItemRef() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ProductOfferingQualificationItemRef(String id, String productOfferingQualificationId) {
    this.id = id;
    this.productOfferingQualificationId = productOfferingQualificationId;
  }

  public ProductOfferingQualificationItemRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of an item of a product offering qualification
   * @return id
   */
  @NotNull 
  @Schema(name = "id", description = "Id of an item of a product offering qualification", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationHref(@Nullable String productOfferingQualificationHref) {
    this.productOfferingQualificationHref = productOfferingQualificationHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return productOfferingQualificationHref
   */
  
  @Schema(name = "productOfferingQualificationHref", description = "Reference of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOfferingQualificationHref")
  public @Nullable String getProductOfferingQualificationHref() {
    return productOfferingQualificationHref;
  }

  @JsonProperty("productOfferingQualificationHref")
  public void setProductOfferingQualificationHref(@Nullable String productOfferingQualificationHref) {
    this.productOfferingQualificationHref = productOfferingQualificationHref;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationId(String productOfferingQualificationId) {
    this.productOfferingQualificationId = productOfferingQualificationId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return productOfferingQualificationId
   */
  @NotNull 
  @Schema(name = "productOfferingQualificationId", description = "Unique identifier of a related entity.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productOfferingQualificationId")
  public String getProductOfferingQualificationId() {
    return productOfferingQualificationId;
  }

  @JsonProperty("productOfferingQualificationId")
  public void setProductOfferingQualificationId(String productOfferingQualificationId) {
    this.productOfferingQualificationId = productOfferingQualificationId;
  }

  public ProductOfferingQualificationItemRef productOfferingQualificationName(@Nullable String productOfferingQualificationName) {
    this.productOfferingQualificationName = productOfferingQualificationName;
    return this;
  }

  /**
   * Name of the related entity.
   * @return productOfferingQualificationName
   */
  
  @Schema(name = "productOfferingQualificationName", description = "Name of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productOfferingQualificationName")
  public @Nullable String getProductOfferingQualificationName() {
    return productOfferingQualificationName;
  }

  @JsonProperty("productOfferingQualificationName")
  public void setProductOfferingQualificationName(@Nullable String productOfferingQualificationName) {
    this.productOfferingQualificationName = productOfferingQualificationName;
  }

  public ProductOfferingQualificationItemRef atBaseType(@Nullable String atBaseType) {
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

  public ProductOfferingQualificationItemRef atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public ProductOfferingQualificationItemRef atType(@Nullable String atType) {
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

  public ProductOfferingQualificationItemRef atReferredType(@Nullable String atReferredType) {
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
    ProductOfferingQualificationItemRef productOfferingQualificationItemRef = (ProductOfferingQualificationItemRef) o;
    return Objects.equals(this.id, productOfferingQualificationItemRef.id) &&
        Objects.equals(this.productOfferingQualificationHref, productOfferingQualificationItemRef.productOfferingQualificationHref) &&
        Objects.equals(this.productOfferingQualificationId, productOfferingQualificationItemRef.productOfferingQualificationId) &&
        Objects.equals(this.productOfferingQualificationName, productOfferingQualificationItemRef.productOfferingQualificationName) &&
        Objects.equals(this.atBaseType, productOfferingQualificationItemRef.atBaseType) &&
        Objects.equals(this.atSchemaLocation, productOfferingQualificationItemRef.atSchemaLocation) &&
        Objects.equals(this.atType, productOfferingQualificationItemRef.atType) &&
        Objects.equals(this.atReferredType, productOfferingQualificationItemRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productOfferingQualificationHref, productOfferingQualificationId, productOfferingQualificationName, atBaseType, atSchemaLocation, atType, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductOfferingQualificationItemRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productOfferingQualificationHref: ").append(toIndentedString(productOfferingQualificationHref)).append("\n");
    sb.append("    productOfferingQualificationId: ").append(toIndentedString(productOfferingQualificationId)).append("\n");
    sb.append("    productOfferingQualificationName: ").append(toIndentedString(productOfferingQualificationName)).append("\n");
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


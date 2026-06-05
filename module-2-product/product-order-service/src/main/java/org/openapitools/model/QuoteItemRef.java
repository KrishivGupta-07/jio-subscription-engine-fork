package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * It&#39;s a Quote item that has been executed previously.
 */

@Schema(name = "QuoteItemRef", description = "It's a Quote item that has been executed previously.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class QuoteItemRef {

  private String id;

  private @Nullable String href;

  private @Nullable String name;

  private @Nullable String quoteHref;

  private String quoteId;

  private @Nullable String quoteName;

  private @Nullable String atBaseType;

  private @Nullable String atSchemaLocation;

  private @Nullable String atType;

  private @Nullable String atReferredType;

  public QuoteItemRef() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public QuoteItemRef(String id, String quoteId) {
    this.id = id;
    this.quoteId = quoteId;
  }

  public QuoteItemRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Id of an item of a quote
   * @return id
   */
  @NotNull 
  @Schema(name = "id", description = "Id of an item of a quote", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  public QuoteItemRef href(@Nullable String href) {
    this.href = href;
    return this;
  }

  /**
   * Hyperlink reference
   * @return href
   */
  
  @Schema(name = "href", description = "Hyperlink reference", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("href")
  public @Nullable String getHref() {
    return href;
  }

  @JsonProperty("href")
  public void setHref(@Nullable String href) {
    this.href = href;
  }

  public QuoteItemRef name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the related entity.
   * @return name
   */
  
  @Schema(name = "name", description = "Name of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(@Nullable String name) {
    this.name = name;
  }

  public QuoteItemRef quoteHref(@Nullable String quoteHref) {
    this.quoteHref = quoteHref;
    return this;
  }

  /**
   * Reference of the related entity.
   * @return quoteHref
   */
  
  @Schema(name = "quoteHref", description = "Reference of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quoteHref")
  public @Nullable String getQuoteHref() {
    return quoteHref;
  }

  @JsonProperty("quoteHref")
  public void setQuoteHref(@Nullable String quoteHref) {
    this.quoteHref = quoteHref;
  }

  public QuoteItemRef quoteId(String quoteId) {
    this.quoteId = quoteId;
    return this;
  }

  /**
   * Unique identifier of a related entity.
   * @return quoteId
   */
  @NotNull 
  @Schema(name = "quoteId", description = "Unique identifier of a related entity.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quoteId")
  public String getQuoteId() {
    return quoteId;
  }

  @JsonProperty("quoteId")
  public void setQuoteId(String quoteId) {
    this.quoteId = quoteId;
  }

  public QuoteItemRef quoteName(@Nullable String quoteName) {
    this.quoteName = quoteName;
    return this;
  }

  /**
   * Name of the related entity.
   * @return quoteName
   */
  
  @Schema(name = "quoteName", description = "Name of the related entity.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("quoteName")
  public @Nullable String getQuoteName() {
    return quoteName;
  }

  @JsonProperty("quoteName")
  public void setQuoteName(@Nullable String quoteName) {
    this.quoteName = quoteName;
  }

  public QuoteItemRef atBaseType(@Nullable String atBaseType) {
    this.atBaseType = atBaseType;
    return this;
  }

  /**
   * When sub-classing, this defines the super-class
   * @return atBaseType
   */
  
  @Schema(name = "@baseType", example = "Place", description = "When sub-classing, this defines the super-class", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@baseType")
  public @Nullable String getAtBaseType() {
    return atBaseType;
  }

  @JsonProperty("@baseType")
  public void setAtBaseType(@Nullable String atBaseType) {
    this.atBaseType = atBaseType;
  }

  public QuoteItemRef atSchemaLocation(@Nullable String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
    return this;
  }

  /**
   * A URI to a JSON-Schema file that defines additional attributes and relationships
   * @return atSchemaLocation
   */
  
  @Schema(name = "@schemaLocation", example = "http://host/schemas/Subclass.schema.json", description = "A URI to a JSON-Schema file that defines additional attributes and relationships", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@schemaLocation")
  public @Nullable String getAtSchemaLocation() {
    return atSchemaLocation;
  }

  @JsonProperty("@schemaLocation")
  public void setAtSchemaLocation(@Nullable String atSchemaLocation) {
    this.atSchemaLocation = atSchemaLocation;
  }

  public QuoteItemRef atType(@Nullable String atType) {
    this.atType = atType;
    return this;
  }

  /**
   * When sub-classing, this defines the sub-class Extensible name
   * @return atType
   */
  
  @Schema(name = "@type", example = "VendorProductOffering", description = "When sub-classing, this defines the sub-class Extensible name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("@type")
  public @Nullable String getAtType() {
    return atType;
  }

  @JsonProperty("@type")
  public void setAtType(@Nullable String atType) {
    this.atType = atType;
  }

  public QuoteItemRef atReferredType(@Nullable String atReferredType) {
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
    QuoteItemRef quoteItemRef = (QuoteItemRef) o;
    return Objects.equals(this.id, quoteItemRef.id) &&
        Objects.equals(this.href, quoteItemRef.href) &&
        Objects.equals(this.name, quoteItemRef.name) &&
        Objects.equals(this.quoteHref, quoteItemRef.quoteHref) &&
        Objects.equals(this.quoteId, quoteItemRef.quoteId) &&
        Objects.equals(this.quoteName, quoteItemRef.quoteName) &&
        Objects.equals(this.atBaseType, quoteItemRef.atBaseType) &&
        Objects.equals(this.atSchemaLocation, quoteItemRef.atSchemaLocation) &&
        Objects.equals(this.atType, quoteItemRef.atType) &&
        Objects.equals(this.atReferredType, quoteItemRef.atReferredType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, name, quoteHref, quoteId, quoteName, atBaseType, atSchemaLocation, atType, atReferredType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QuoteItemRef {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quoteHref: ").append(toIndentedString(quoteHref)).append("\n");
    sb.append("    quoteId: ").append(toIndentedString(quoteId)).append("\n");
    sb.append("    quoteName: ").append(toIndentedString(quoteName)).append("\n");
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


package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.net.URI;
import org.openapitools.model.Money;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Provides all amounts (tax included, duty free, tax rate), used currency and percentage to apply for Price Alteration.
 */

@Schema(name = "Price", description = "Provides all amounts (tax included, duty free, tax rate), used currency and percentage to apply for Price Alteration.")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class Price {

  private @Nullable Float percentage;

  private @Nullable Float taxRate;

  private @Nullable Money dutyFreeAmount;

  private @Nullable Money taxIncludedAmount;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public Price percentage(@Nullable Float percentage) {
    this.percentage = percentage;
    return this;
  }

  /**
   * Percentage to apply for ProdOfferPriceAlteration
   * @return percentage
   */
  
  @Schema(name = "percentage", description = "Percentage to apply for ProdOfferPriceAlteration", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("percentage")
  public @Nullable Float getPercentage() {
    return percentage;
  }

  @JsonProperty("percentage")
  public void setPercentage(@Nullable Float percentage) {
    this.percentage = percentage;
  }

  public Price taxRate(@Nullable Float taxRate) {
    this.taxRate = taxRate;
    return this;
  }

  /**
   * Tax rate
   * @return taxRate
   */
  
  @Schema(name = "taxRate", description = "Tax rate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxRate")
  public @Nullable Float getTaxRate() {
    return taxRate;
  }

  @JsonProperty("taxRate")
  public void setTaxRate(@Nullable Float taxRate) {
    this.taxRate = taxRate;
  }

  public Price dutyFreeAmount(@Nullable Money dutyFreeAmount) {
    this.dutyFreeAmount = dutyFreeAmount;
    return this;
  }

  /**
   * Get dutyFreeAmount
   * @return dutyFreeAmount
   */
  @Valid 
  @Schema(name = "dutyFreeAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dutyFreeAmount")
  public @Nullable Money getDutyFreeAmount() {
    return dutyFreeAmount;
  }

  @JsonProperty("dutyFreeAmount")
  public void setDutyFreeAmount(@Nullable Money dutyFreeAmount) {
    this.dutyFreeAmount = dutyFreeAmount;
  }

  public Price taxIncludedAmount(@Nullable Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
    return this;
  }

  /**
   * Get taxIncludedAmount
   * @return taxIncludedAmount
   */
  @Valid 
  @Schema(name = "taxIncludedAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("taxIncludedAmount")
  public @Nullable Money getTaxIncludedAmount() {
    return taxIncludedAmount;
  }

  @JsonProperty("taxIncludedAmount")
  public void setTaxIncludedAmount(@Nullable Money taxIncludedAmount) {
    this.taxIncludedAmount = taxIncludedAmount;
  }

  public Price atBaseType(@Nullable String atBaseType) {
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

  public Price atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public Price atType(@Nullable String atType) {
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
    Price price = (Price) o;
    return Objects.equals(this.percentage, price.percentage) &&
        Objects.equals(this.taxRate, price.taxRate) &&
        Objects.equals(this.dutyFreeAmount, price.dutyFreeAmount) &&
        Objects.equals(this.taxIncludedAmount, price.taxIncludedAmount) &&
        Objects.equals(this.atBaseType, price.atBaseType) &&
        Objects.equals(this.atSchemaLocation, price.atSchemaLocation) &&
        Objects.equals(this.atType, price.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(percentage, taxRate, dutyFreeAmount, taxIncludedAmount, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    sb.append("    percentage: ").append(toIndentedString(percentage)).append("\n");
    sb.append("    taxRate: ").append(toIndentedString(taxRate)).append("\n");
    sb.append("    dutyFreeAmount: ").append(toIndentedString(dutyFreeAmount)).append("\n");
    sb.append("    taxIncludedAmount: ").append(toIndentedString(taxIncludedAmount)).append("\n");
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


package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openapitools.model.AgreementItemRef;
import org.openapitools.model.BillingAccountRef;
import org.openapitools.model.Characteristic;
import org.openapitools.model.ProductOfferingRef;
import org.openapitools.model.ProductPrice;
import org.openapitools.model.ProductRefOrValue;
import org.openapitools.model.ProductRelationship;
import org.openapitools.model.ProductSpecificationRef;
import org.openapitools.model.ProductStatusType;
import org.openapitools.model.ProductTerm;
import org.openapitools.model.RelatedParty;
import org.openapitools.model.RelatedPlaceRefOrValue;
import org.openapitools.model.RelatedProductOrderItem;
import org.openapitools.model.ResourceRef;
import org.openapitools.model.ServiceRef;
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
 * A product offering procured by a customer or other interested party playing a party role. A product is realized as one or more service(s) and / or resource(s).
 */

@Schema(name = "Product", description = "A product offering procured by a customer or other interested party playing a party role. A product is realized as one or more service(s) and / or resource(s).")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class Product {

  private @Nullable String id;

  private @Nullable String href;

  private @Nullable String description;

  private @Nullable Boolean isBundle;

  private @Nullable Boolean isCustomerVisible;

  private @Nullable String name;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime orderDate;

  private @Nullable String productSerialNumber;

  private @Nullable String randomAtt;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private @Nullable OffsetDateTime terminationDate;

  @Valid
  private List<@Valid AgreementItemRef> agreement = new ArrayList<>();

  private @Nullable BillingAccountRef billingAccount;

  @Valid
  private List<@Valid RelatedPlaceRefOrValue> place = new ArrayList<>();

  @Valid
  private List<@Valid ProductRefOrValue> product = new ArrayList<>();

  @Valid
  private List<@Valid Characteristic> productCharacteristic = new ArrayList<>();

  private @Nullable ProductOfferingRef productOffering;

  @Valid
  private List<@Valid RelatedProductOrderItem> productOrderItem = new ArrayList<>();

  @Valid
  private List<@Valid ProductPrice> productPrice = new ArrayList<>();

  @Valid
  private List<@Valid ProductRelationship> productRelationship = new ArrayList<>();

  private @Nullable ProductSpecificationRef productSpecification;

  @Valid
  private List<@Valid ProductTerm> productTerm = new ArrayList<>();

  @Valid
  private List<@Valid ResourceRef> realizingResource = new ArrayList<>();

  @Valid
  private List<@Valid ServiceRef> realizingService = new ArrayList<>();

  @Valid
  private List<@Valid RelatedParty> relatedParty = new ArrayList<>();

  private @Nullable ProductStatusType status;

  private @Nullable String atBaseType;

  private @Nullable URI atSchemaLocation;

  private @Nullable String atType;

  public Product id(@Nullable String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the product
   * @return id
   */
  
  @Schema(name = "id", description = "Unique identifier of the product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public @Nullable String getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(@Nullable String id) {
    this.id = id;
  }

  public Product href(@Nullable String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the product
   * @return href
   */
  
  @Schema(name = "href", description = "Reference of the product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("href")
  public @Nullable String getHref() {
    return href;
  }

  @JsonProperty("href")
  public void setHref(@Nullable String href) {
    this.href = href;
  }

  public Product description(@Nullable String description) {
    this.description = description;
    return this;
  }

  /**
   * Is the description of the product. It could be copied from the description of the Product Offering.
   * @return description
   */
  
  @Schema(name = "description", description = "Is the description of the product. It could be copied from the description of the Product Offering.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public @Nullable String getDescription() {
    return description;
  }

  @JsonProperty("description")
  public void setDescription(@Nullable String description) {
    this.description = description;
  }

  public Product isBundle(@Nullable Boolean isBundle) {
    this.isBundle = isBundle;
    return this;
  }

  /**
   * If true, the product is a ProductBundle which is an instantiation of a BundledProductOffering. If false, the product is a ProductComponent which is an instantiation of a SimpleProductOffering.
   * @return isBundle
   */
  
  @Schema(name = "isBundle", description = "If true, the product is a ProductBundle which is an instantiation of a BundledProductOffering. If false, the product is a ProductComponent which is an instantiation of a SimpleProductOffering.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isBundle")
  public @Nullable Boolean getIsBundle() {
    return isBundle;
  }

  @JsonProperty("isBundle")
  public void setIsBundle(@Nullable Boolean isBundle) {
    this.isBundle = isBundle;
  }

  public Product isCustomerVisible(@Nullable Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
    return this;
  }

  /**
   * If true, the product is visible by the customer.
   * @return isCustomerVisible
   */
  
  @Schema(name = "isCustomerVisible", description = "If true, the product is visible by the customer.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isCustomerVisible")
  public @Nullable Boolean getIsCustomerVisible() {
    return isCustomerVisible;
  }

  @JsonProperty("isCustomerVisible")
  public void setIsCustomerVisible(@Nullable Boolean isCustomerVisible) {
    this.isCustomerVisible = isCustomerVisible;
  }

  public Product name(@Nullable String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product. It could be the same as the name of the product offering
   * @return name
   */
  
  @Schema(name = "name", description = "Name of the product. It could be the same as the name of the product offering", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public @Nullable String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(@Nullable String name) {
    this.name = name;
  }

  public Product orderDate(@Nullable OffsetDateTime orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Is the date when the product was ordered
   * @return orderDate
   */
  @Valid 
  @Schema(name = "orderDate", description = "Is the date when the product was ordered", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("orderDate")
  public @Nullable OffsetDateTime getOrderDate() {
    return orderDate;
  }

  @JsonProperty("orderDate")
  public void setOrderDate(@Nullable OffsetDateTime orderDate) {
    this.orderDate = orderDate;
  }

  public Product productSerialNumber(@Nullable String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
    return this;
  }

  /**
   * Is the serial number for the product. This is typically applicable to tangible products e.g. Broadband Router.
   * @return productSerialNumber
   */
  
  @Schema(name = "productSerialNumber", description = "Is the serial number for the product. This is typically applicable to tangible products e.g. Broadband Router.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productSerialNumber")
  public @Nullable String getProductSerialNumber() {
    return productSerialNumber;
  }

  @JsonProperty("productSerialNumber")
  public void setProductSerialNumber(@Nullable String productSerialNumber) {
    this.productSerialNumber = productSerialNumber;
  }

  public Product randomAtt(@Nullable String randomAtt) {
    this.randomAtt = randomAtt;
    return this;
  }

  /**
   * Get randomAtt
   * @return randomAtt
   */
  
  @Schema(name = "randomAtt", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("randomAtt")
  public @Nullable String getRandomAtt() {
    return randomAtt;
  }

  @JsonProperty("randomAtt")
  public void setRandomAtt(@Nullable String randomAtt) {
    this.randomAtt = randomAtt;
  }

  public Product startDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Is the date from which the product starts
   * @return startDate
   */
  @Valid 
  @Schema(name = "startDate", description = "Is the date from which the product starts", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("startDate")
  public @Nullable OffsetDateTime getStartDate() {
    return startDate;
  }

  @JsonProperty("startDate")
  public void setStartDate(@Nullable OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public Product terminationDate(@Nullable OffsetDateTime terminationDate) {
    this.terminationDate = terminationDate;
    return this;
  }

  /**
   * Is the date when the product was terminated
   * @return terminationDate
   */
  @Valid 
  @Schema(name = "terminationDate", description = "Is the date when the product was terminated", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("terminationDate")
  public @Nullable OffsetDateTime getTerminationDate() {
    return terminationDate;
  }

  @JsonProperty("terminationDate")
  public void setTerminationDate(@Nullable OffsetDateTime terminationDate) {
    this.terminationDate = terminationDate;
  }

  public Product agreement(List<@Valid AgreementItemRef> agreement) {
    this.agreement = agreement;
    return this;
  }

  public Product addAgreementItem(AgreementItemRef agreementItem) {
    if (this.agreement == null) {
      this.agreement = new ArrayList<>();
    }
    this.agreement.add(agreementItem);
    return this;
  }

  /**
   * Get agreement
   * @return agreement
   */
  @Valid 
  @Schema(name = "agreement", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("agreement")
  public List<@Valid AgreementItemRef> getAgreement() {
    return agreement;
  }

  @JsonProperty("agreement")
  public void setAgreement(List<@Valid AgreementItemRef> agreement) {
    this.agreement = agreement;
  }

  public Product billingAccount(@Nullable BillingAccountRef billingAccount) {
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

  public Product place(List<@Valid RelatedPlaceRefOrValue> place) {
    this.place = place;
    return this;
  }

  public Product addPlaceItem(RelatedPlaceRefOrValue placeItem) {
    if (this.place == null) {
      this.place = new ArrayList<>();
    }
    this.place.add(placeItem);
    return this;
  }

  /**
   * Get place
   * @return place
   */
  @Valid 
  @Schema(name = "place", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("place")
  public List<@Valid RelatedPlaceRefOrValue> getPlace() {
    return place;
  }

  @JsonProperty("place")
  public void setPlace(List<@Valid RelatedPlaceRefOrValue> place) {
    this.place = place;
  }

  public Product product(List<@Valid ProductRefOrValue> product) {
    this.product = product;
    return this;
  }

  public Product addProductItem(ProductRefOrValue productItem) {
    if (this.product == null) {
      this.product = new ArrayList<>();
    }
    this.product.add(productItem);
    return this;
  }

  /**
   * Get product
   * @return product
   */
  @Valid 
  @Schema(name = "product", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("product")
  public List<@Valid ProductRefOrValue> getProduct() {
    return product;
  }

  @JsonProperty("product")
  public void setProduct(List<@Valid ProductRefOrValue> product) {
    this.product = product;
  }

  public Product productCharacteristic(List<@Valid Characteristic> productCharacteristic) {
    this.productCharacteristic = productCharacteristic;
    return this;
  }

  public Product addProductCharacteristicItem(Characteristic productCharacteristicItem) {
    if (this.productCharacteristic == null) {
      this.productCharacteristic = new ArrayList<>();
    }
    this.productCharacteristic.add(productCharacteristicItem);
    return this;
  }

  /**
   * Get productCharacteristic
   * @return productCharacteristic
   */
  @Valid 
  @Schema(name = "productCharacteristic", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productCharacteristic")
  public List<@Valid Characteristic> getProductCharacteristic() {
    return productCharacteristic;
  }

  @JsonProperty("productCharacteristic")
  public void setProductCharacteristic(List<@Valid Characteristic> productCharacteristic) {
    this.productCharacteristic = productCharacteristic;
  }

  public Product productOffering(@Nullable ProductOfferingRef productOffering) {
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

  public Product productOrderItem(List<@Valid RelatedProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
    return this;
  }

  public Product addProductOrderItemItem(RelatedProductOrderItem productOrderItemItem) {
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
  public List<@Valid RelatedProductOrderItem> getProductOrderItem() {
    return productOrderItem;
  }

  @JsonProperty("productOrderItem")
  public void setProductOrderItem(List<@Valid RelatedProductOrderItem> productOrderItem) {
    this.productOrderItem = productOrderItem;
  }

  public Product productPrice(List<@Valid ProductPrice> productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  public Product addProductPriceItem(ProductPrice productPriceItem) {
    if (this.productPrice == null) {
      this.productPrice = new ArrayList<>();
    }
    this.productPrice.add(productPriceItem);
    return this;
  }

  /**
   * Get productPrice
   * @return productPrice
   */
  @Valid 
  @Schema(name = "productPrice", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productPrice")
  public List<@Valid ProductPrice> getProductPrice() {
    return productPrice;
  }

  @JsonProperty("productPrice")
  public void setProductPrice(List<@Valid ProductPrice> productPrice) {
    this.productPrice = productPrice;
  }

  public Product productRelationship(List<@Valid ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
    return this;
  }

  public Product addProductRelationshipItem(ProductRelationship productRelationshipItem) {
    if (this.productRelationship == null) {
      this.productRelationship = new ArrayList<>();
    }
    this.productRelationship.add(productRelationshipItem);
    return this;
  }

  /**
   * Get productRelationship
   * @return productRelationship
   */
  @Valid 
  @Schema(name = "productRelationship", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productRelationship")
  public List<@Valid ProductRelationship> getProductRelationship() {
    return productRelationship;
  }

  @JsonProperty("productRelationship")
  public void setProductRelationship(List<@Valid ProductRelationship> productRelationship) {
    this.productRelationship = productRelationship;
  }

  public Product productSpecification(@Nullable ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
    return this;
  }

  /**
   * Get productSpecification
   * @return productSpecification
   */
  @Valid 
  @Schema(name = "productSpecification", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productSpecification")
  public @Nullable ProductSpecificationRef getProductSpecification() {
    return productSpecification;
  }

  @JsonProperty("productSpecification")
  public void setProductSpecification(@Nullable ProductSpecificationRef productSpecification) {
    this.productSpecification = productSpecification;
  }

  public Product productTerm(List<@Valid ProductTerm> productTerm) {
    this.productTerm = productTerm;
    return this;
  }

  public Product addProductTermItem(ProductTerm productTermItem) {
    if (this.productTerm == null) {
      this.productTerm = new ArrayList<>();
    }
    this.productTerm.add(productTermItem);
    return this;
  }

  /**
   * Get productTerm
   * @return productTerm
   */
  @Valid 
  @Schema(name = "productTerm", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("productTerm")
  public List<@Valid ProductTerm> getProductTerm() {
    return productTerm;
  }

  @JsonProperty("productTerm")
  public void setProductTerm(List<@Valid ProductTerm> productTerm) {
    this.productTerm = productTerm;
  }

  public Product realizingResource(List<@Valid ResourceRef> realizingResource) {
    this.realizingResource = realizingResource;
    return this;
  }

  public Product addRealizingResourceItem(ResourceRef realizingResourceItem) {
    if (this.realizingResource == null) {
      this.realizingResource = new ArrayList<>();
    }
    this.realizingResource.add(realizingResourceItem);
    return this;
  }

  /**
   * Get realizingResource
   * @return realizingResource
   */
  @Valid 
  @Schema(name = "realizingResource", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realizingResource")
  public List<@Valid ResourceRef> getRealizingResource() {
    return realizingResource;
  }

  @JsonProperty("realizingResource")
  public void setRealizingResource(List<@Valid ResourceRef> realizingResource) {
    this.realizingResource = realizingResource;
  }

  public Product realizingService(List<@Valid ServiceRef> realizingService) {
    this.realizingService = realizingService;
    return this;
  }

  public Product addRealizingServiceItem(ServiceRef realizingServiceItem) {
    if (this.realizingService == null) {
      this.realizingService = new ArrayList<>();
    }
    this.realizingService.add(realizingServiceItem);
    return this;
  }

  /**
   * Get realizingService
   * @return realizingService
   */
  @Valid 
  @Schema(name = "realizingService", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("realizingService")
  public List<@Valid ServiceRef> getRealizingService() {
    return realizingService;
  }

  @JsonProperty("realizingService")
  public void setRealizingService(List<@Valid ServiceRef> realizingService) {
    this.realizingService = realizingService;
  }

  public Product relatedParty(List<@Valid RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
    return this;
  }

  public Product addRelatedPartyItem(RelatedParty relatedPartyItem) {
    if (this.relatedParty == null) {
      this.relatedParty = new ArrayList<>();
    }
    this.relatedParty.add(relatedPartyItem);
    return this;
  }

  /**
   * Get relatedParty
   * @return relatedParty
   */
  @Valid 
  @Schema(name = "relatedParty", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("relatedParty")
  public List<@Valid RelatedParty> getRelatedParty() {
    return relatedParty;
  }

  @JsonProperty("relatedParty")
  public void setRelatedParty(List<@Valid RelatedParty> relatedParty) {
    this.relatedParty = relatedParty;
  }

  public Product status(@Nullable ProductStatusType status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public @Nullable ProductStatusType getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(@Nullable ProductStatusType status) {
    this.status = status;
  }

  public Product atBaseType(@Nullable String atBaseType) {
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

  public Product atSchemaLocation(@Nullable URI atSchemaLocation) {
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

  public Product atType(@Nullable String atType) {
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
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.href, product.href) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.isBundle, product.isBundle) &&
        Objects.equals(this.isCustomerVisible, product.isCustomerVisible) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.orderDate, product.orderDate) &&
        Objects.equals(this.productSerialNumber, product.productSerialNumber) &&
        Objects.equals(this.randomAtt, product.randomAtt) &&
        Objects.equals(this.startDate, product.startDate) &&
        Objects.equals(this.terminationDate, product.terminationDate) &&
        Objects.equals(this.agreement, product.agreement) &&
        Objects.equals(this.billingAccount, product.billingAccount) &&
        Objects.equals(this.place, product.place) &&
        Objects.equals(this.product, product.product) &&
        Objects.equals(this.productCharacteristic, product.productCharacteristic) &&
        Objects.equals(this.productOffering, product.productOffering) &&
        Objects.equals(this.productOrderItem, product.productOrderItem) &&
        Objects.equals(this.productPrice, product.productPrice) &&
        Objects.equals(this.productRelationship, product.productRelationship) &&
        Objects.equals(this.productSpecification, product.productSpecification) &&
        Objects.equals(this.productTerm, product.productTerm) &&
        Objects.equals(this.realizingResource, product.realizingResource) &&
        Objects.equals(this.realizingService, product.realizingService) &&
        Objects.equals(this.relatedParty, product.relatedParty) &&
        Objects.equals(this.status, product.status) &&
        Objects.equals(this.atBaseType, product.atBaseType) &&
        Objects.equals(this.atSchemaLocation, product.atSchemaLocation) &&
        Objects.equals(this.atType, product.atType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, href, description, isBundle, isCustomerVisible, name, orderDate, productSerialNumber, randomAtt, startDate, terminationDate, agreement, billingAccount, place, product, productCharacteristic, productOffering, productOrderItem, productPrice, productRelationship, productSpecification, productTerm, realizingResource, realizingService, relatedParty, status, atBaseType, atSchemaLocation, atType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isBundle: ").append(toIndentedString(isBundle)).append("\n");
    sb.append("    isCustomerVisible: ").append(toIndentedString(isCustomerVisible)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    productSerialNumber: ").append(toIndentedString(productSerialNumber)).append("\n");
    sb.append("    randomAtt: ").append(toIndentedString(randomAtt)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    terminationDate: ").append(toIndentedString(terminationDate)).append("\n");
    sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
    sb.append("    billingAccount: ").append(toIndentedString(billingAccount)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    productCharacteristic: ").append(toIndentedString(productCharacteristic)).append("\n");
    sb.append("    productOffering: ").append(toIndentedString(productOffering)).append("\n");
    sb.append("    productOrderItem: ").append(toIndentedString(productOrderItem)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    productRelationship: ").append(toIndentedString(productRelationship)).append("\n");
    sb.append("    productSpecification: ").append(toIndentedString(productSpecification)).append("\n");
    sb.append("    productTerm: ").append(toIndentedString(productTerm)).append("\n");
    sb.append("    realizingResource: ").append(toIndentedString(realizingResource)).append("\n");
    sb.append("    realizingService: ").append(toIndentedString(realizingService)).append("\n");
    sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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


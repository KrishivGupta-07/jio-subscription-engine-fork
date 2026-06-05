package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.model.CancelProductOrder;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * The event data structure
 */

@Schema(name = "CancelProductOrderStateChangeEventPayload", description = "The event data structure")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2026-06-05T16:24:09.119988100+05:30[Asia/Calcutta]", comments = "Generator version: 7.22.0")
public class CancelProductOrderStateChangeEventPayload {

  private @Nullable CancelProductOrder cancelProductOrder;

  public CancelProductOrderStateChangeEventPayload cancelProductOrder(@Nullable CancelProductOrder cancelProductOrder) {
    this.cancelProductOrder = cancelProductOrder;
    return this;
  }

  /**
   * Get cancelProductOrder
   * @return cancelProductOrder
   */
  @Valid 
  @Schema(name = "cancelProductOrder", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cancelProductOrder")
  public @Nullable CancelProductOrder getCancelProductOrder() {
    return cancelProductOrder;
  }

  @JsonProperty("cancelProductOrder")
  public void setCancelProductOrder(@Nullable CancelProductOrder cancelProductOrder) {
    this.cancelProductOrder = cancelProductOrder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CancelProductOrderStateChangeEventPayload cancelProductOrderStateChangeEventPayload = (CancelProductOrderStateChangeEventPayload) o;
    return Objects.equals(this.cancelProductOrder, cancelProductOrderStateChangeEventPayload.cancelProductOrder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cancelProductOrder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CancelProductOrderStateChangeEventPayload {\n");
    sb.append("    cancelProductOrder: ").append(toIndentedString(cancelProductOrder)).append("\n");
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


package com.jio.subscription.payments.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.OffsetDateTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "payment_method")
public class PaymentMethodEntity extends AuditedEntity {

    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "type", length = 40, nullable = false)
    private String type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "is_preferred")
    private Boolean preferred;

    @Column(name = "authorization_code")
    private String authorizationCode;

    @Column(name = "status", length = 40)
    private String status;

    @Column(name = "status_reason")
    private String statusReason;

    @Column(name = "status_date")
    private OffsetDateTime statusDate;

    @Column(name = "account_id", length = 64)
    private String accountId;

    /** Vault/PSP token reference. Raw PANs are never stored. */
    @Column(name = "token_ref")
    private String tokenRef;

    @Column(name = "valid_for_start")
    private OffsetDateTime validForStart;

    @Column(name = "valid_for_end")
    private OffsetDateTime validForEnd;

    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(name = "dto_json")
    private String dtoJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPreferred() {
        return preferred;
    }

    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public OffsetDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(OffsetDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getTokenRef() {
        return tokenRef;
    }

    public void setTokenRef(String tokenRef) {
        this.tokenRef = tokenRef;
    }

    public OffsetDateTime getValidForStart() {
        return validForStart;
    }

    public void setValidForStart(OffsetDateTime validForStart) {
        this.validForStart = validForStart;
    }

    public OffsetDateTime getValidForEnd() {
        return validForEnd;
    }

    public void setValidForEnd(OffsetDateTime validForEnd) {
        this.validForEnd = validForEnd;
    }

    public String getDtoJson() {
        return dtoJson;
    }

    public void setDtoJson(String dtoJson) {
        this.dtoJson = dtoJson;
    }
}

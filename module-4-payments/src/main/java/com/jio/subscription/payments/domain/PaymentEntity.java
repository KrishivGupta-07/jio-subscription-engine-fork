package com.jio.subscription.payments.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "payment")
public class PaymentEntity extends AuditedEntity {

    @Id
    @Column(name = "id", length = 64, nullable = false)
    private String id;

    @Column(name = "correlator_id")
    private String correlatorId;

    @Column(name = "status", length = 40, nullable = false)
    private String status;

    @Column(name = "amount_value", precision = 19, scale = 4)
    private BigDecimal amountValue;

    @Column(name = "amount_currency", length = 3)
    private String amountCurrency;

    @Column(name = "total_amount_value", precision = 19, scale = 4)
    private BigDecimal totalAmountValue;

    @Column(name = "total_amount_currency", length = 3)
    private String totalAmountCurrency;

    @Column(name = "tax_amount_value", precision = 19, scale = 4)
    private BigDecimal taxAmountValue;

    @Column(name = "tax_amount_currency", length = 3)
    private String taxAmountCurrency;

    @Column(name = "captured_amount", precision = 19, scale = 4, nullable = false)
    private BigDecimal capturedAmount = BigDecimal.ZERO;

    @Column(name = "refunded_amount", precision = 19, scale = 4, nullable = false)
    private BigDecimal refundedAmount = BigDecimal.ZERO;

    @Column(name = "authorization_code")
    private String authorizationCode;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "account_id", length = 64)
    private String accountId;

    @Column(name = "payment_method_id", length = 64)
    private String paymentMethodId;

    @Column(name = "psp_reference")
    private String pspReference;

    @Column(name = "payment_date")
    private OffsetDateTime paymentDate;

    @Column(name = "status_date")
    private OffsetDateTime statusDate;

    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    @Column(name = "dto_json")
    private String dtoJson;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorrelatorId() {
        return correlatorId;
    }

    public void setCorrelatorId(String correlatorId) {
        this.correlatorId = correlatorId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(BigDecimal amountValue) {
        this.amountValue = amountValue;
    }

    public String getAmountCurrency() {
        return amountCurrency;
    }

    public void setAmountCurrency(String amountCurrency) {
        this.amountCurrency = amountCurrency;
    }

    public BigDecimal getTotalAmountValue() {
        return totalAmountValue;
    }

    public void setTotalAmountValue(BigDecimal totalAmountValue) {
        this.totalAmountValue = totalAmountValue;
    }

    public String getTotalAmountCurrency() {
        return totalAmountCurrency;
    }

    public void setTotalAmountCurrency(String totalAmountCurrency) {
        this.totalAmountCurrency = totalAmountCurrency;
    }

    public BigDecimal getTaxAmountValue() {
        return taxAmountValue;
    }

    public void setTaxAmountValue(BigDecimal taxAmountValue) {
        this.taxAmountValue = taxAmountValue;
    }

    public String getTaxAmountCurrency() {
        return taxAmountCurrency;
    }

    public void setTaxAmountCurrency(String taxAmountCurrency) {
        this.taxAmountCurrency = taxAmountCurrency;
    }

    public BigDecimal getCapturedAmount() {
        return capturedAmount;
    }

    public void setCapturedAmount(BigDecimal capturedAmount) {
        this.capturedAmount = capturedAmount;
    }

    public BigDecimal getRefundedAmount() {
        return refundedAmount;
    }

    public void setRefundedAmount(BigDecimal refundedAmount) {
        this.refundedAmount = refundedAmount;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public OffsetDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(OffsetDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public OffsetDateTime getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(OffsetDateTime statusDate) {
        this.statusDate = statusDate;
    }

    public String getDtoJson() {
        return dtoJson;
    }

    public void setDtoJson(String dtoJson) {
        this.dtoJson = dtoJson;
    }
}

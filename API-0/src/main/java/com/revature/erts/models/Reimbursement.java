package com.revature.erts.models;

import java.com.revature.erts.models.Status;
import com.revature.erts.models.ReimbursementType;
import models.DatatypeCrossRef;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;

public class Reimbursement {
    private String reimbursementUUID;
    private int amount;
    private String description;
    private SerialBlob receipt;
    private String paymentID;
    private ReimbursementType type;
    private Status status;
    private Timestamp submitted;
    private String submitterUUID;
    private Timestamp resolved;
    private String resolverUUID;

    public Reimbursement() {
        super();
    }

    public Reimbursement(String reimbursementUUID, int amount, String description, SerialBlob receipt, String paymentID,
                         ReimbursementType type, Status status, Timestamp submitted, String submitterUUID,
                         Timestamp resolved, String resolverUUID) {
        this.reimbursementUUID = reimbursementUUID;
        this.amount = amount;
        this.description = description;
        this.receipt = receipt;
        this.paymentID = paymentID;
        this.type = type;
        this.status = status;
        this.submitted = submitted;
        this.submitterUUID = submitterUUID;
        this.resolved = resolved;
        this.resolverUUID = resolverUUID;
    }

    public Reimbursement(String reimbursementUUID, float amount, String description, byte[] receiptByteArray,
                         String paymentID, String typeUUID, String statusUUID, Timestamp submitted,
                         String submitterUUID, Timestamp resolved, String resolverUUID) {
        this.reimbursementUUID = reimbursementUUID;
        this.amount = DatatypeCrossRef.moneyFloat2Int(amount);
        this.description = description;
        this.receipt = SerialBlob(receiptByteArray);
        this.paymentID = paymentID;
        this.type = DatatypeCrossRef.typeUUID2Enum(typeUUID);
        this.status = DatatypeCrossRef.statusUUID2Enum(statusUUID);
        this.submitted = submitted;
        this.submitterUUID = submitterUUID;
        this.resolved = resolved;
        this.resolverUUID = resolverUUID;
    }

    public String getReimbursementUUID() {
        return this.reimbursementUUID;
    }

    public void setReimbursementUUID(String reimbursementUUID) {
        this.reimbursementUUID = reimbursementUUID;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SerialBlob getReceipt() {
        return this.receipt;
    }

    public void setReceipt(SerialBlob receipt) {
        this.receipt = receipt;
    }

    public String getPaymentID() {
        return this.paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public ReimbursementType getType() {
        return this.type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Timestamp getSubmitted() {
        return this.submitted;
    }

    public void setSubmitted(Timestamp submitted) {
        this.submitted = submitted;
    }

    public String getSubmitterUUID() {
        return this.submitterUUID;
    }

    public void setSubmitterUUID(String submitterUUID) {
        this.submitterUUID = submitterUUID;
    }

    public Timestamp getResolved() {
        return this.resolved;
    }

    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getResolverUUID() {
        return this.resolverUUID;
    }

    public void setResolverUUID(String resolverUUID) {
        this.resolverUUID = resolverUUID;
    }

    @Override
    public String toString() {
        return "Reimbursement{" +
                "reimbursementUUID='" + reimbursementUUID + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                // ", receipt=" + receipt +
                ", paymentID='" + paymentID + '\'' +
                ", typeUUID='" + DatatypeCrossRef.typeEnum2UUID(type) + '\'' +
                ", typeText='" + DatatypeCrossRef.typeEnum2Text(type) + '\'' +
                ", statusUUID='" + DatatypeCrossRef.statusEnum2UUID(status) + '\'' +
                ", statusText='" + DatatypeCrossRef.statusEnum2Text(status) + '\'' +
                ", submitted=" + submitted +
                ", submitterUUID='" + submitterUUID + '\'' +
                ", resolved=" + resolved +
                ", resolverUUID='" + resolverUUID + '\'' +
                '}';
    }

}
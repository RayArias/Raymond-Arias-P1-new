package com.revature.erts.dtos.requests;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;
import java.util.Arrays;

public class NewReimbursementRequest {
    private String reimbursementUUID;
    private float amount;
    private String description;
    private byte[] receiptByteArray;
    private String paymentID;
    private String typeUUID;
    private String statusUUID;
    private Timestamp submitted;
    private String submitterUUID;
    private Timestamp resolved;
    private String resolverUUID;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(String reimbursementUUID, float amount, String description, byte[] receiptByteArray,
                                   String paymentID, String typeUUID, String statusUUID, Timestamp submitted,
                                   String submitterUUID) {
        this.reimbursementUUID = reimbursementUUID;
        this.amount            = amount;
        this.description       = description;
        this.receiptByteArray  = receiptByteArray;
        this.paymentID         = paymentID;
        this.typeUUID          = typeUUID;
        this.statusUUID        = statusUUID;
        this.submitted         = submitted;
        this.submitterUUID     = submitterUUID;
        this.resolved          = null;
        this.resolverUUID      = null;
    }

    public NewReimbursementRequest(String reimbursementUUID, float amount, String description, byte[] receiptByteArray,
                                   String paymentID, String typeUUID, String statusUUID, Timestamp submitted,
                                   String submitterUUID, Timestamp resolved, String resolverUUID) {
        this.reimbursementUUID = reimbursementUUID;
        this.amount            = amount;
        this.description       = description;
        this.receiptByteArray  = receiptByteArray;
        this.paymentID         = paymentID;
        this.typeUUID          = typeUUID;
        this.statusUUID        = statusUUID;
        this.submitted         = submitted;
        this.submitterUUID     = submitterUUID;
        this.resolved          = resolved;
        this.resolverUUID      = resolverUUID;
    }
    public String getUUID() {
        return this.reimbursementUUID;
    }

    public void setId(String reimbursementUUID) {
        this.reimbursementUUID = reimbursementUUID;
    }

    public float getAmount() { return this.amount; }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getReceiptByteArray() { return this.receiptByteArray; }

    public void setReceipt(byte[] receiptByteArray) { this.receiptByteArray = receiptByteArray; }

    public String getPaymentID() { return this.paymentID; }

    public void setPaymentID(String paymentID) { this.paymentID = paymentID; }

    public String getTypeUUID() { return this.typeUUID; }

    public void setTypeUUID(String typeUUID) { this.typeUUID = typeUUID; }

    public String getStatusUUID() { return this.statusUUID; }

    public void setStatusUUID(String statusUUID) { this.statusUUID = statusUUID; }

    public Timestamp getSubmitted() { return this.submitted; }

    public void setSubmitted(Timestamp submitted) { this.submitted = submitted; }

    public String getSubmitterUUID() { return this.submitterUUID; }

    public void setSubmitterUUID(String submitterUUID) { this.submitterUUID = submitterUUID; }

    public Timestamp getResolved() { return this.resolved; }
    public void setResolved(Timestamp resolved) {
        this.resolved = resolved;
    }

    public String getResolverUUID() { return this.resolverUUID; }

    public void setResolverUUID(String resolverUUID) {
        this.resolverUUID = resolverUUID;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "reimbursementUUID='" + reimbursementUUID + '\'' +
                ", amount=" + amount + '\'' +
                ", description='" + description + '\'' +
                // ", receiptByteArray=" + Arrays.toString(receiptByteArray) +
                ", paymentID='" + paymentID + '\'' +
                ", typeUUID='" + typeUUID + '\'' +
                ", statusUUID='" + statusUUID + '\'' +
                ", submitted=" + submitted +
                ", submitterUUID='" + submitterUUID + '\'' +
                ", resolved=" + resolved + '\'' +
                ", resolverUUID" + resolverUUID + '\'' +
                '}';
    }
}

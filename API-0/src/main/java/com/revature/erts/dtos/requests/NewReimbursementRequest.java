package com.revature.erts.dtos.requests;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;
import java.util.Arrays;

public class NewReimbursementRequest {
    private String id;
    private float amount;
    private String description;
    private byte[] receiptByteArray;
    private String paymentID;
    private String typeID;
    private String statusID;
    private Timestamp submitted;
    private String submitterID;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(String id, float amount, String description, byte[] receiptByteArray,
                                   String paymentID, String typeID, String statusID, Timestamp submitted,
                                   String submitterID) {
        this.id               = id;
        this.amount           = amount;
        this.description      = description;
        this.receiptByteArray = receiptByteArray;
        this.paymentID        = paymentID;
        this.typeID           = typeID;
        this.statusID         = statusID;
        this.submitted        = submitted;
        this.submitterID      = submitterID;
    }

    public String getID() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTypeID() { return this.typeID; }

    public void setTypeID(String typeID) { this.typeID = typeID; }

    public String getStatusID() { return this.statusID; }

    public void setStatusID(String statusID) { this.statusID = statusID; }

    public Timestamp getSubmitted() { return this.submitted; }

    public void setSubmitted(Timestamp submitted) { this.submitted = submitted; }

    public String getSubmitterID() { return this.submitterID; }

    public void setUserID(String submitterID) { this.submitterID = submitterID; }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                // ", receiptByteArray=" + Arrays.toString(receiptByteArray) +
                ", paymentID='" + paymentID + '\'' +
                ", typeID='" + typeID + '\'' +
                ", statusID='" + statusID + '\'' +
                ", submitted=" + submitted +
                ", submitterID='" + submitterID + '\'' +
                '}';
    }
}

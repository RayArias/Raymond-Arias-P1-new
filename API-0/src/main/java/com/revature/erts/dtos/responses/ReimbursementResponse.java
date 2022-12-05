package com.revature.erts.dtos.responses;

import com.revature.erts.models.DatatypeCrossRef;
import com.revature.erts.models.ReimbursementType;
import com.revature.erts.models.Status;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Timestamp;


public class ReimbursementResponse {
    private String reimbursementUUID;
    private int amount;
    private String description;
    private ReimbursementType type;
    private SerialBlob receipt;
    private Status status;
    private Timestamp submitted;
    private String submitterUUID;
    private Timestamp resolved;
    private String resolverUUID;

    public ReimbursementResponse() {
        super();
    }

    public ReimbursementResponse(String reimbursementUUID, int amount, String description, SerialBlob receipt,
                                 ReimbursementType type, Status status, Timestamp submitted, String submitterUUID,
                                 Timestamp resolved, String resolverUUID) {
        this.reimbursementUUID = reimbursementUUID;
        this.amount            = amount;
        this.description       = description;
        this.receipt           = receipt;
        this.type              = type;
        this.status            = status;
        this.submitted         = submitted;
        this.submitterUUID     = submitterUUID;
        this.resolved          = resolved;
        this.resolverUUID      = resolverUUID;
    }

    public int getAmountAsInt() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getAmountAsFloat() {return DatatypeCrossRef.int2MoneyFloat(amount); }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SerialBlob getReceipt() { return this.receipt; }

    public void setReceipt(SerialBlob receipt) { this.receipt = receipt; }

    public ReimbursementType getType() {
        return this.type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }

    public String getTypeText() { return DatatypeCrossRef.typeEnum2Text(this.type); }

    public void setType(String typeText) { this.type = DatatypeCrossRef.typeText2Enum(typeText); }

    public String getTypeUUID() { return DatatypeCrossRef.typeEnum2UUID(this.type); }

    public void setTypeByUUID(String typeUUID) { this.type = DatatypeCrossRef.typeUUID2Enum(typeUUID); }

    public Status getStatus() { return this.status; }

    public void setStatus(Status status) { this.status = status; }

    public String getStatusText() { return DatatypeCrossRef.statusEnum2Text(this.status); }

    public void setStatus(String statusText) { this.status = DatatypeCrossRef.statusText2Enum(statusText); }

    public String getStatusUUID() { return DatatypeCrossRef.statusEnum2UUID(this.status); }

    public void setStatusByUUID(String statusUUID) { this.status = DatatypeCrossRef.statusUUID2Enum(statusUUID); }

    public Timestamp getSubmitted() { return this.submitted; }

    public void setSubmitted(Timestamp submitted) { this.submitted = submitted; }

    public String getSubmitterUUID() { return this.submitterUUID; }

    public void setSubmitterUUID(String submitterUUID) { this.submitterUUID = submitterUUID; }

    public Timestamp getResolved() { return this.resolved; }

    public void setResolved(Timestamp resolved) { this.resolved = resolved; }

    public String getResolverUUID() { return this.resolverUUID; }

    public void setResolverUUID(String resolverUUID) { this.resolverUUID = resolverUUID; }

    @Override
    public String toString() {
        return "ReimbursementResponse{" +
                "reimbursementUUID='" + reimbursementUUID + '\'' +
                ", amount="           + amount            + '\'' +
                ", description='"     + description       + '\'' +
                ", typeUUID='"        + getTypeUUID()     + '\'' +
                ", typeText='"        + getTypeText()     + '\'' +
                // ", receipt="       + receipt           + '\'' +  (how do you place a SerialBlob in a toString()?
                ", statusUUID='"      + getStatusUUID()   + '\'' +
                ", statusText='"      + getStatusText()   + '\'' +
                ", submitted='"       + submitted         + '\'' +
                ", submitterUUID='"   + submitterUUID     + '\'' +
                ", resolved='"        + resolved          + '\'' +
                ", resolverUUID='"    + resolverUUID      + '\'' +
                '}';
    }
}

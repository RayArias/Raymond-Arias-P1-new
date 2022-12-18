package com.revature.erts.models;

import java.sql.Timestamp;
import java.util.UUID;

public class Reimbursement {
    static {
        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);
    }

    private String id;
    private int amount;
    private String description;
    private String paymentId;
    private ReimbursementType type;
    private ReimbursementStatus status;
    private Timestamp submitted;
    private String submitterId;
    private Timestamp resolved;
    private String resolverId;

    public Reimbursement() {
        super();
    }

    public Reimbursement(String id, int amount, String description, String paymentId, ReimbursementType type,
                         ReimbursementStatus status, Timestamp submitted, String submitterId,
                         String resolverId) {

        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);

        this.id          = id;
        this.amount      = amount;
        this.description = description;
        this.paymentId   = paymentId;
        this.type        = type;
        this.status      = status;
        this.submitted   = submitted;
        this.submitterId = submitterId;
        this.resolved    = makeTime;
        this.resolverId  = resolverId;

    }

    public Reimbursement(String id, float amount, String description, String paymentId, String typeUUID,
                         String statusUUID, Timestamp submitted, String submitterId,
                         String resolverId) {

        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);

        this.id          = id;
        this.amount      = DatatypeCrossRef.moneyFloat2Int(amount);
        this.description = description;
        this.paymentId   = paymentId;
        this.type        = DatatypeCrossRef.typeUUID2Enum(typeUUID);
        this.status      = DatatypeCrossRef.statusUUID2Enum(statusUUID);
        this.submitted   = submitted;
        this.submitterId = submitterId;
        this.resolved    = makeTime;
        this.resolverId  = resolverId;

    }

    public Reimbursement(String id, float amount, String description, String paymentId, String typeUUID,
                         String statusUUID, String submitterId) {

        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);

        this.id          = id;
        this.amount      = DatatypeCrossRef.moneyFloat2Int(amount);
        this.description = description;
        this.paymentId   = paymentId;
        this.type        = DatatypeCrossRef.typeUUID2Enum(typeUUID);
        this.status      = DatatypeCrossRef.statusUUID2Enum(statusUUID);
        this.submitted   = makeTime;
        this.submitterId = submitterId;

    }

    public String getId() {
        return this.id;
    }

    public void assignId() { this.id = UUID.randomUUID().toString(); }

    public int getIntAmount() {
        return this.amount;
    }

    public float getFloatAmount() { return ((float) this.amount) / 100.00F; }

    public void setIntAmount(int amount) {
        this.amount = amount;
    }

    public void setFloatAmount(float amountf) { this.amount = (int) Math.floor(amountf * 100.0); }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPaymentId() { return this.paymentId; }

    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public ReimbursementType getType() { return this.type; }

    public void setType(ReimbursementType type) { this.type = type; }

    public ReimbursementStatus getStatus() { return this.status; }

    public void setStatus(ReimbursementStatus status) { this.status = status; }

    public Timestamp getSubmitted() { return this.submitted; }

    public void stampSubmitted() {
        long now = System.currentTimeMillis();
        this.submitted = new Timestamp(now);
    }

    public String getSubmitterId() { return this.submitterId; }

    public void setSubmitterId(String submitterId) { this.submitterId = submitterId; }

    public Timestamp getResolved() { return this.resolved; }

    public void stampResolved() {
        long now = System.currentTimeMillis();
        this.resolved = new Timestamp(now);
    }

    public String getResolverId() { return this.resolverId; }

    public void setResolverId(String resolverId) { this.resolverId = resolverId; }

    @Override
    public String toString() {
        return "Reimbursement{"   +
                "id='"            + id                                       + '\'' +
                ", amountInt="    + amount                                   +
                ", amountFloat="  + DatatypeCrossRef.int2MoneyFloat(amount)  +
                ", description='" + description                              + '\'' +
                ", paymentId='"   + paymentId                                + '\'' +
                ", typeUUID='"    + DatatypeCrossRef.typeEnum2UUID(type)     + '\'' +
                ", typeText='"    + DatatypeCrossRef.typeEnum2Text(type)     + '\'' +
                ", statusUUID='"  + DatatypeCrossRef.statusEnum2UUID(status) + '\'' +
                ", statusText='"  + DatatypeCrossRef.statusEnum2Text(status) + '\'' +
                ", submitted="    + submitted                                +
                ", submitterId='" + submitterId                              + '\'' +
                ", resolved="     + resolved                                 +
                ", resolverId='"  + resolverId                               + '\'' +
                '}';
    }

}

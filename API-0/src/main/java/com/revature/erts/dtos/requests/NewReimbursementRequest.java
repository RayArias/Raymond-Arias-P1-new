package com.revature.erts.dtos.requests;

public class NewReimbursementRequest {
    private String id;
    private String date;
    private String amount;
    private String description;
    private String typeID;
    private String statusID;
    private String userID;

    public NewReimbursementRequest() {
        super();
    }

    public NewReimbursementRequest(String id, String date, String amount, String description, String typeID,
                                   String statusID, String userID) {
        this.id          = id;
        this.date        = date;
        this.amount      = amount;
        this.description = description;
        this.typeID      = typeID;
        this.statusID    = statusID;
        this.userID      = userID;
    }

    public String getID() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeID() {
        return this.typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getStatusID() {
        return this.statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "NewReimbursementRequest{" +
                "id='" + this.id + '\'' +
                ", date='" + this.date + '\'' +
                ", amount='" + this.amount + '\'' +
                ", description=" + this.description + '\'' +
                ", typeID=" + this.typeID + '\'' +
                ", statusID" + this.statusID + '\'' +
                ", userID=" + this.userID + '}';
    }
}
package com.revature.erts.services;

import com.revature.erts.daos.ReimbursementDAO;
import com.revature.erts.dtos.requests.NewReimbursementRequest;
import com.revature.erts.dtos.responses.ReimbursementResponse;
import com.revature.erts.services.UserService;
import com.revature.erts.models.Status;
import com.revature.erts.models.ReimbursementType;
import com.revature.erts.models.Reimbursement;
import com.revature.erts.models.User;
import com.revature.erts.utils.custom_exceptions.InvalidAuthException;
import com.revature.erts.utils.custom_exceptions.InvalidReimbursementTicketException;

import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;

/* purpose of ReimbursementService is to validate and retrieve data from the DAO (DATA ACCESS OBJECT) */
/* Service class is essentially an api */
public class ReimbursementService {
    /* dependency injection = when a class is dependent on another class */
    private final ReimbursementDAO reimbursementDAO;

    public ReimbursementService() { super(); }
    public ReimbursementService(ReimbursementDAO reimbursementDAO) {
        this.reimbursementDAO = reimbursementDAO;
    }

    public Reimbursement newReimbursement(NewReimbursementRequest req) {
        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);
        Reimbursement createdReimbursement = new Reimbursement(UUID.randomUUID().toString(), req.getAmount(),
                req.getDescription(), req.getBytes(), req.getTypeID(), Status.PENDING, req.getUserID());
        ReimbursementDAO.save(createdReimbursement);
        return createdReimbursement;
    }

    public List<Reimbursement> getAllReimbursements() {
        return reimbursementDAO.findAll();
    }

    public List<Reimbursement> getAllReimbursementsByUserUUID(String userUUID) {
        return ReimbursementDAO.getAllReimbursementsByUserUUID(userUUID);
    }

    public List<Reimbursement> getAllReimbursementsByStatusUUID(String statusUUID) {
        return ReimbursementDAO.getAllReimbursementsbyStatusUUID(statusUUID);
    }

    public List<Reimbursement> getAllReimbursementsByUserUUIDAndStatusUUID(String userUUID, String statusUUID) {
        return ReimbursementDAO.getAllReimbursementsByUserUUIDAndStatusID(userUUID, statusUUID);
    }

    public List<Reimbursement> getAllReimbursementsBySubmittedDate(Timestamp submitted) {
        return ReimbursementDAO.getAllReimbursementsBySubmittedDate(submitted);
    }

    public List<Reimbursement> getAllReimbursementsByTypeUUID(String typeUUID) {
        return ReimbursementDAO.getAllReimbursementsByTypeUUID(typeUUID);
    }

    public boolean isValidStatusUUID(String statusUUID) {

        //          UUIDs for statuses                             PENDING
        boolean statusUuidIsValid = (statusUUID == "5d3d4eec-06cb-4979-a9fc-5d00300f422b") || (statusUUID ==
                //             APPROVED                                                   DENIED
                "9be2a384-a18f-47a9-a190-9b4482e9f5b5") || (statusUUID == "1889b06d-9aea-42bd-9d8a-d29993e4ff16");

        return statusUuidIsValid;
    }

    public boolean isValidTypeUUID(String typeUUID) {

        //  UUIDs for reimbursement types                      LODGING
        boolean typeUuidIsValid = (typeUUID == "72b289fd-4899-496f-9329-27accb781525") || (typeUUID ==
                //           TRANSPORTATION                                              FOOD
                "5c7798a9-c3ee-4655-8841-afa43344161f") || (typeUUID == "dee0f0d7-c3e5-4d33-8406-1c1cd6396b45") ||
                //                            OTHER
                (typeUUID == "5bda58cb-1c32-46ed-b1fc-5a93d0270dc3");

        return typeUuidIsValid;
    }

}


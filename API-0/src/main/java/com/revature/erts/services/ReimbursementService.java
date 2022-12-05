package com.revature.erts.services;

import com.revature.erts.daos.ReimbursementDAO;
import com.revature.erts.dtos.requests.NewReimbursementRequest;
import com.revature.erts.dtos.responses.ReimbursementResponse;
import com.revature.erts.models.*;
import com.revature.erts.utils.custom_exceptions.InvalidAuthException;
import com.revature.erts.utils.custom_exceptions.InvalidReimbursementTicketException;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.sql.Timestamp;

/* purpose of ReimbursementService is to validate and retrieve data from the DAO (DATA ACCESS OBJECT) */
/* Service class is essentially an api */
public class ReimbursementService {
    /* dependency injection = when a class is dependent on another class */
    private final ReimbursementDAO reimbursementDAO;

    public ReimbursementService() {
        super();
        this.reimbursementDAO = null;
    }
    public ReimbursementService(ReimbursementDAO reimbursementDAO) {
        this.reimbursementDAO = reimbursementDAO;
    }

    public Reimbursement newReimbursement(NewReimbursementRequest req) throws SQLException {
        long now = System.currentTimeMillis();
        Timestamp makeTime = new Timestamp(now);
        Reimbursement createdReimbursement = null;
        try {
            createdReimbursement = new Reimbursement(UUID.randomUUID().toString(), req.getAmount(),
                    req.getDescription(), req.getReceiptByteArray(), req.getPaymentID(), req.getTypeUUID(),
                    DatatypeCrossRef.statusEnum2UUID(Status.PENDING), makeTime, req.getSubmitterUUID());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        reimbursementDAO.save(createdReimbursement);
        return createdReimbursement;
    }

    public List<Reimbursement> getAllReimbursements() {
        return reimbursementDAO.findAll();
    }

    public List<Reimbursement> getAllReimbursementsByUserUUID(String userUUID) {
        return reimbursementDAO.getAllReimbursementsByUserUUID(userUUID);
    }

    public List<Reimbursement> getAllReimbursementsByStatusUUID(String statusUUID) {
        return reimbursementDAO.getAllReimbursementsByStatusUUID(statusUUID);
    }

    public List<Reimbursement> getAllReimbursementsByUserUUIDAndStatusUUID(String userUUID, String statusUUID) {
        return reimbursementDAO.getAllReimbursementsByUserUUIDAndStatusUUID(userUUID, statusUUID);
    }

    public List<Reimbursement> getAllReimbursementsByDateSubmitted(Timestamp submitted) {
        return reimbursementDAO.getAllReimbursementsByDateSubmitted(submitted);
    }

    public List<Reimbursement> getAllReimbursementsByTypeUUID(String typeUUID) {
        return reimbursementDAO.getAllReimbursementsByTypeUUID(typeUUID);
    }
}


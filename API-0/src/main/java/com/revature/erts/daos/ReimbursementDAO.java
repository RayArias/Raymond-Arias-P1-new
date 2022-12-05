
package com.revature.erts.daos;

import com.revature.erts.models.ReimbursementType;
import com.revature.erts.models.Status;
import com.revature.erts.models.Reimbursement;
import com.revature.erts.models.DatatypeCrossRef;
import com.revature.erts.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.sql.rowset.serial.SerialBlob;
import java.util.ArrayList;
import java.util.List;


/* purpose of ReimbursementDAO is to return data from the database */
/* DAO = DATA ACCESS OBJECT */
public class ReimbursementDAO implements CrudDAO<Reimbursement> {

    @Override
    public void save(Reimbursement obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            /* always start with the PrepareStatement */
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO reimbursements (id, amount, description, receipt, payment_id, type_id, status_id," +
                            "submitted, submitter_id, resolved) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString   (1, obj.getReimbursementUUID());
            ps.setFloat    (2, obj.getAmount());
            ps.setString   (3, obj.getDescription());
            ps.setBytes    (4, DatatypeCrossRef.serialBlob2ByteArray(obj.getReceipt()));
            ps.setString   (5, obj.getPaymentID());
            ps.setString   (6, DatatypeCrossRef.typeEnum2UUID(obj.getType()));
            ps.setString   (7, DatatypeCrossRef.statusEnum2UUID(obj.getStatus()));
            ps.setTimestamp(8, obj.getSubmitted());
            ps.setString   (9, obj.getSubmitterUUID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Reimbursement obj) {

    }

    @Override
    public void update(Reimbursement obj) {

    }

    @Override
    public Reimbursement findById() {
        return null;
    }

    @Override
    public List<Reimbursement> findAll() {
        List<Reimbursement> reimbursements = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * from reimbursements");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Reimbursement currentReimbursement = new Reimbursement(rs.getString("id"),
                        rs.getFloat("amount"),        rs.getString("description"),
                        rs.getBytes("receipt"),       rs.getString("payment_id"),
                        rs.getString("type_id"),      rs.getString("status_id"),
                        rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"),  rs.getString("resolver_id"));
                reimbursements.add(currentReimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursements;
    }

    /* custom methods */

    public List<String> findAllReimbursementIDs() {
        List<String> reimbursementIDs = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (id) from reimbursements");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String currentReimbursementID = rs.getString("id");
                reimbursementIDs.add(currentReimbursementID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursementIDs;
    }

    public List<Reimbursement> getAllReimbursementsByTypeUUID(String typeID) {
        List<Reimbursement> reimbursementList = null;
        Reimbursement reimbursement;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE type_id = ?");
            ps.setString (1, typeID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getFloat("amount"),
                        rs.getString("description"), rs.getBytes("receipt"), rs.getString("payment_id"),
                        rs.getString("type_id"), rs.getString("status_id"), rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"), rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    public List<Reimbursement> getAllReimbursementsByUserUUID(String userUUID) {
        List<Reimbursement> reimbursementList = null;
        Reimbursement reimbursement;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE user_id = ?");
            ps.setString (1, userUUID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getFloat("amount"),
                        rs.getString("description"), rs.getBytes("receipt"),
                        rs.getString("payment_id"), rs.getString("type_id"),
                        rs.getString("status_id"), rs.getTimestamp("submitted"),
                        rs.getString("submitter_id"), rs.getTimestamp("resolved"),
                        rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    public List<Reimbursement> getAllReimbursementsByStatusUUID(String statusUUID) {
        List<Reimbursement> reimbursementList = null;
        Reimbursement reimbursement;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE status_id = ?");
            ps.setString (1, statusUUID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getFloat("amount"),
                        rs.getString("description"), rs.getBytes("receipt"), rs.getString("payment_id"),
                        rs.getString("type_id"), rs.getString("status_id"), rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"), rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    public List<Reimbursement> getAllReimbursementsByUserUUIDAndStatusUUID(String userUUID, String statusUUID) {
        List<Reimbursement> reimbursementList = null;
        Reimbursement reimbursement;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE user_id = ? AND" +
                    "status_id = ?");
            ps.setString(1, userUUID);
            ps.setString(2, statusUUID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getFloat("amount"),
                        rs.getString("description"), rs.getBytes("receipt"),
                        rs.getString("payment_id"), rs.getString("type_id"),
                        rs.getString("status_id"), rs.getTimestamp("submitted"),
                        rs.getString("submitter_id"), rs.getTimestamp("resolved"),
                        rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    public List<Reimbursement> getAllReimbursementsByDateSubmitted(Timestamp submitted) {
        List<Reimbursement> reimbursementList = null;
        Reimbursement reimbursement;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE submitted = ?");
            ps.setTimestamp (1, submitted);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getFloat("amount"),
                        rs.getString("description"), rs.getBytes("receipt"), rs.getString("payment_id"),
                        rs.getString("type_id"), rs.getString("status_id"), rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"), rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

}


package java.com.revature.erts.daos;

import com.revature.erts.models.ReimbursementType;
import java.com.revature.erts.models.Status;
import com.revature.erts.models.Reimbursement;
import models.DatatypeCrossRef;
import com.revature.erts.utils.ConnectionFactory;
import com.revature.erts.daos.CrudDAO;

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

    public List<Reimbursement> getReimbursementsByTypeUUID(String typeID) {
        List<Reimbursement> reimbursementList;
        Reimbursement reimbursement = null;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE type_id = ?");
            ps.setString (1, typeID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getString("amount"),
                        rs.getString("description"), rs.getBytes("receipt"), rs.getString("payment_id"),
                        rs.getString("status_id"), rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"), rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }

    public List<Reimbursement> getReimbursementsByUserUUID(String userID) {
        List<Reimbursement> reimbursementList;
        Reimbursement reimbursement = null;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reimbursements WHERE user_id = ?");
            ps.setString (1, userID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reimbursement = new Reimbursement(rs.getString("id"), rs.getString("amount"),
                        rs.getString("description"), rs.getBytes("receipt"), rs.getString("payment_id"),
                        rs.getString("status_id"), rs.getTimestamp("submitted"), rs.getString("submitter_id"),
                        rs.getTimestamp("resolved"), rs.getString("resolver_id"));
                reimbursementList.add(reimbursement);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reimbursementList;
    }
}

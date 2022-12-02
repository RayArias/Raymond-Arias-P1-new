// Class ReimbursementStatusDAO
// For Package com.revature.erts.daos
// For Program ERTS by Raymond Arias
// Version *.*.*
// Based on skeleton code by Bao Duong
// For completion date, see Class MainDriver
/*
package daos;

import java.com.revature.erts.models.Status;
import com.revature.erts.utils.ConnectionFactory;
import com.revature.erts.daos.CrudDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* purpose of UserRoleDAO is to return data from the database */
/* DAO = DATA ACCESS OBJECT */ /*
public class ReimbursementStatusDAO implements CrudDAO<Status> {
    @Override
    public void save(Status obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            /* always start with the PrepareStatement */ /*
            PreparedStatement ps = con.prepareStatement("INSERT INTO reimbursement_statuses (id, status) VALUES (?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getStatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Status findById() {
        return null;
    }

    @Override
    public List<Status> findAll() {
        List<Status> reimbursementStatusList = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * from reimbursement_statuses");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Status currentStatus = new Status(rs.getString("id"), rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reimbursementStatusList;
    }
}
*/
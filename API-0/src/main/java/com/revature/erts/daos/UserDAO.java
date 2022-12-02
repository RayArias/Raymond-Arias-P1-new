package daos;

import com.revature.erts.utils.ConnectionFactory;
import com.revature.erts.daos.CrudDAO;
import models.DatatypeCrossRef;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* purpose of UserDAO is to return data from the database */
/* DAO = DATA ACCESS OBJECT */
public class UserDAO implements CrudDAO<User>{
    @Override
    public void save(User obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            /* always start with the PrepareStatement */
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (id, username, email, given_name, " +
                    "surname, password, role) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getGivenName());
            ps.setString(5, obj.getSurname());
            ps.setString(6, obj.getPassword());
            ps.setString(7, DatatypeCrossRef.userRoleEnum2UUID(obj.getRole()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(User user) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE * FROM users WHERE id = ?");
            ps.setString(1, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User obj) {
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE * IN users WHERE id = ? (username, email, " +
                    "given_name, surname, password, role) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getId());
            ps.setString(2, obj.getUsername());
            ps.setString(3, obj.getEmail());
            ps.setString(4, obj.getGivenName());
            ps.setString(5, obj.getSurname());
            ps.setString(6, obj.getPassword());
            ps.setString(7, DatatypeCrossRef.userRoleEnum2UUID(obj.getRole()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findById(String userUUID) {
        User user;

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setString(1, userUUID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("email"), rs.getString("username"),
                        rs.getString("given_name"), rs.getString("surname"), rs.getString("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User currentUser = new User(rs.getString("id"), rs.getString("email"), rs.getString("username"),
                        rs.getString("given_name"), rs.getString("surname"), rs.getString("role_id"));
                users.add(currentUser);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    /* custom methods */

    public List<String> findAllUsernames() {
        List<String> usernames = new ArrayList<>();

        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT (username) from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String currentUsername = rs.getString("username");
                usernames.add(currentUsername);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usernames;
    }

    public User getUserByUsernameAndPassword(String username, String password) {
        User user = null;
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("given_name"), rs.getString("surname"), rs.getString("role_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getAllUsersByUsername(String username) {
        List<User> users = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username LIKE ?");
            ps.setString(1, username + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("given_name"), rs.getString("surname"), rs.getString("role_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public List<User> getAllUsersByRoleUUID(String roleUUID) {
        List<User> users = new ArrayList<>();
        try (Connection con = ConnectionFactory.getInstance().getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE role_id = ?");
            ps.setString(1, roleUUID);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("username"), rs.getString("email"),
                        rs.getString("given_name"), rs.getString("surname"), rs.getString("role_id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById() {
        return null;
    }

}

package com.revature.erts.models;

import static com.revature.erts.models.UserRole.*;
import static com.revature.erts.models.ReimbursementType.*;
import static com.revature.erts.models.Status.*;
import com.revature.erts.utils.custom_exceptions.InvalidReimbursementStatusException;
import com.revature.erts.utils.custom_exceptions.InvalidReimbursementTypeException;
import com.revature.erts.utils.custom_exceptions.InvalidUserRoleException;

import java.lang.String;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class DatatypeCrossRef {


// CONVERTING REIMBURSEMENT TYPE
    public static ReimbursementType typeText2Enum(String reimbrsmntTypeText) {
        ReimbursementType type;

        switch(reimbrsmntTypeText) {
            case "LODGING":
                type = LODGING;
                break;

            case "TRAVEL":
                type = TRAVEL;
                break;

            case "FOOD":
                type = FOOD;
                break;

            case "OTHER":
                type = OTHER;
                break;

            default:
                throw new InvalidReimbursementTypeException("Invalid Reimbursement Text string.");
        }
        return type;
    }

    public static String typeEnum2Text(ReimbursementType type) {
        String reimbursementTypeText;

        switch (type) {
            case LODGING:
                reimbursementTypeText = "LODGING";
                break;

            case TRAVEL:
                reimbursementTypeText = "TRAVEL";
                break;

            case FOOD:
                reimbursementTypeText = "FOOD";
                break;

            default:
                reimbursementTypeText = "OTHER";
                break;
        }
        return reimbursementTypeText;
    }

    public static String typeText2UUID(String reimbrsmntTypeText) {
        String typeUUID;

        switch(reimbrsmntTypeText) {
            case "LODGING":
                typeUUID = "72b289fd-4899-496f-9329-27accb781525";
                break;

            case "TRAVEL":
                typeUUID = "5c7798a9-c3ee-4655-8841-afa43344161f";
                break;

            case "FOOD":
                typeUUID = "dee0f0d7-c3e5-4d33-8406-1c1cd6396b45";
                break;

            case "OTHER":
                typeUUID = "5bda58cb-1c32-46ed-b1fc-5a93d0270dc3";
                break;

            default:
                throw new InvalidReimbursementTypeException("Invalid Reimbursement Type Text string.");
        }
        return typeUUID;
    }

    public static String typeEnum2UUID(ReimbursementType type) {
        String typeUUID;

        switch (type) {
            case LODGING:
                typeUUID = "72b289fd-4899-496f-9329-27accb781525";
                break;

            case TRAVEL:
                typeUUID = "5c7798a9-c3ee-4655-8841-afa43344161f";
                break;

            case FOOD:
                typeUUID = "dee0f0d7-c3e5-4d33-8406-1c1cd6396b45";
                break;

            default:
                typeUUID = "5bda58cb-1c32-46ed-b1fc-5a93d0270dc3";
                break;
        }
        return typeUUID;
    }

    public static String typeUUID2Text(String typeUUID) {
        String reimbrsmntTypeText;

        switch(typeUUID) {
            case "72b289fd-4899-496f-9329-27accb781525":
                reimbrsmntTypeText = "LODGING";
                break;

            case "5c7798a9-c3ee-4655-8841-afa43344161f":
                reimbrsmntTypeText = "TRAVEL";
                break;

            case "dee0f0d7-c3e5-4d33-8406-1c1cd6396b45":
                reimbrsmntTypeText = "FOOD";
                break;

            case "5bda58cb-1c32-46ed-b1fc-5a93d0270dc3":
                reimbrsmntTypeText = "OTHER";
                break;

            default:
                throw new InvalidReimbursementTypeException("Invalid Reimbursement Type UUID string.");
        }
        return reimbrsmntTypeText;
    }

    public static ReimbursementType typeUUID2Enum(String typeUUID) {
        ReimbursementType type;

        switch (typeUUID) {
            case "72b289fd-4899-496f-9329-27accb781525":
                type = LODGING;
                break;

            case "5c7798a9-c3ee-4655-8841-afa43344161f":
                type = TRAVEL;
                break;

            case "dee0f0d7-c3e5-4d33-8406-1c1cd6396b45":
                type = FOOD;
                break;

            case "5bda58cb-1c32-46ed-b1fc-5a93d0270dc3":
                type = OTHER;
                break;

            default:
                throw new InvalidReimbursementTypeException("Invalid Reimbursement Type UUID string.");
        }
        return type;
    }


// CONVERTING REIMBURSEMENT STATUS
    public static Status statusText2Enum(String statusText) {
        Status status;

        switch(statusText) {
            case "PENDING":
                status = PENDING;
                break;

            case "APPROVED":
                status = APPROVED;
                break;

            case "DENIED":
                status = DENIED;
                break;

            default:
                throw new InvalidReimbursementStatusException("Invalid Reimbursement Status Text string.");
        }
        return status;
    }

    public static String statusEnum2Text(Status status) {
        String statusText;

        switch (status) {
            case PENDING:
                statusText = "PENDING";
                break;

            case APPROVED:
                statusText = "APPROVED";
                break;

            default:  // (DENIED)
                statusText = "DENIED";
                break;
        }
        return statusText;
    }

    public static String statusText2UUID(String statusText) {
        String statusUUID;

        switch(statusText) {
            case "PENDING":
                statusUUID = "5d3d4eec-06cb-4979-a9fc-5d00300f422b";
                break;

            case "APPROVED":
                statusUUID = "9be2a384-a18f-47a9-a190-9b4482e9f5b5";
                break;

            case "DENIED":
                statusUUID = "1889b06d-9aea-42bd-9d8a-d29993e4ff16";
                break;

            default:
                throw new InvalidReimbursementStatusException("Invalid Reimbursement Status Text string.");
        }
        return statusUUID;
    }

    public static String statusEnum2UUID(Status status) {
        String statusUUID;

        switch (status) {

            case PENDING:
                statusUUID = "5d3d4eec-06cb-4979-a9fc-5d00300f422b";
                break;

            case APPROVED:
                statusUUID = "9be2a384-a18f-47a9-a190-9b4482e9f5b5";
                break;

            default: // (DENIED)
                statusUUID = "1889b06d-9aea-42bd-9d8a-d29993e4ff16";
                break;
        }
        return statusUUID;
    }

    public static Status statusUUID2Enum(String statusUUID) {
        Status status;

        switch (statusUUID) {

            case "5d3d4eec-06cb-4979-a9fc-5d00300f422b":
                status = PENDING;
                break;

            case "9be2a384-a18f-47a9-a190-9b4482e9f5b5":
                status = APPROVED;
                break;

            case "1889b06d-9aea-42bd-9d8a-d29993e4ff16":
                status = DENIED;
                break;

            default:
                throw new InvalidReimbursementStatusException("Invalid Reimbursement Status UUID string.");
        }
        return status;
    }

    public static String statusUUID2Text(String statusUUID) {
        String statusText;

        switch(statusUUID) {
            case "5d3d4eec-06cb-4979-a9fc-5d00300f422b":
                statusText = "PENDING";
                break;

            case "9be2a384-a18f-47a9-a190-9b4482e9f5b5":
                statusText = "APPROVED";
                break;

            case "1889b06d-9aea-42bd-9d8a-d29993e4ff16":
                statusText = "DENIED";
                break;

            default:
                throw new InvalidReimbursementStatusException("Invalid Reimbursement Status UUID string.");
        }
        return statusText;
    }


// CONVERTING USER ROLE
    public static UserRole userRoleText2Enum(String roleText) {
        UserRole userRole;

        switch(roleText) {
            case "ADMIN":
                userRole = ADMIN;
                break;

            case "MANAGER":
                userRole = MANAGER;
                break;

            case "EMPLOYEE":
                userRole = EMPLOYEE;
                break;

            default:
                throw new InvalidUserRoleException("Invalid User Role Text string.");
        }
        return userRole;
    }

    public static String userRoleEnum2Text(UserRole role) {
        String roleText;

        switch(role) {
            case ADMIN:
                roleText = "ADMIN";
                break;

            case MANAGER:
                roleText = "MANAGER";
                break;

            default:
                roleText = "EMPLOYEE";
                break;
        }

        return roleText;
    }

    public static String userRoleText2UUID(String roleText) {
        String roleUUID;

        switch(roleText) {
            case "ADMIN":
                roleUUID = "3a89e958-6504-4cb6-ac83-14c0af1b732e";
                break;

            case "MANAGER":
                roleUUID = "240eebc4-1bcb-49be-b816-96c8d19f76fd";
                break;

            case "EMPLOYEE":
                roleUUID = "17083287-4167-4edb-abc0-ca8dec1c9152";
                break;

            default:
                throw new InvalidUserRoleException("Invalid User Role Text string.");
        }
        return roleUUID;
    }

    public static String userRoleEnum2UUID(UserRole role) {
        String roleUUID;

        switch(role) {
            case ADMIN:
                roleUUID = "3a89e958-6504-4cb6-ac83-14c0af1b732e";
                break;

            case MANAGER:
                roleUUID = "240eebc4-1bcb-49be-b816-96c8d19f76fd";
                break;

            default:
                roleUUID = "17083287-4167-4edb-abc0-ca8dec1c9152";
                break;
        }

        return roleUUID;
    }

    public static UserRole userRoleUUID2Enum(String roleUUID) {
        UserRole userRole;

        switch(roleUUID) {
            case "3a89e958-6504-4cb6-ac83-14c0af1b732e":
                userRole = ADMIN;
                break;

            case "240eebc4-1bcb-49be-b816-96c8d19f76fd":
                userRole = MANAGER;
                break;

            case "17083287-4167-4edb-abc0-ca8dec1c9152":
                userRole = EMPLOYEE;
                break;

            default:
                throw new InvalidUserRoleException("Invalid User Role UUID string.");
        }
        return userRole;
    }

    public static String userRoleUUID2Text(String roleUUID) {
        String roleText;

        switch(roleUUID) {
            case "3a89e958-6504-4cb6-ac83-14c0af1b732e":
                roleText = "ADMIN";
                break;

            case "240eebc4-1bcb-49be-b816-96c8d19f76fd":
                roleText = "MANAGER";
                break;

            case "17083287-4167-4edb-abc0-ca8dec1c9152":
                roleText = "EMPLOYEE";
                break;

            default:
                throw new InvalidUserRoleException("Invailid User Role UUID string.");
        }
        return roleText;
    }



    public static int String2Int(String s) {
        float f = Float.parseFloat(s);
        int i = moneyFloat2Int(f);
        return i;
    }

    public static String int2String(int i) {
        float f = int2MoneyFloat(i);
        String s = String.valueOf(f);
        return s;
    }

    public static float int2MoneyFloat(int i) {
        float f = (float)(i) / 100.0f;
        return f;
    }

    public static int moneyFloat2Int(float f) {
        int i = (int)(Math.floor(f) * 100.0f);
        return i;
    }

    public static SerialBlob byteArray2SerialBlob(byte[] bytearr) throws SQLException {
        SerialBlob output = null;
        try {
            output.setBytes(0L, bytearr);
            return output;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] serialBlob2ByteArray(SerialBlob sblob) throws SerialException {
        try {
            return sblob.getBytes(0L, (int)sblob.length());
        } catch(SerialException e) {
            e.printStackTrace();
        }
        return null;
    }
}

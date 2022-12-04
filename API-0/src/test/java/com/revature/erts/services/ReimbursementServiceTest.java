package com.revature.erts.services;

import com.revature.erts.daos.ReimbursementDAO;
import com.revature.erts.dtos.requests.NewReimbursementRequest;
import com.revature.erts.models.DatatypeCrossRef;
import com.revature.erts.models.Reimbursement;
import com.revature.erts.models.Status;
import com.revature.erts.models.ReimbursementType;
import com.revature.erts.services.ReimbursementService;

import com.revature.erts.utils.custom_exceptions.InvalidUserException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;

/*
   Mockito is a mocking framework. JAVA-based library that is used for effective unit testing of JAVA applications.
   Mocking is the act of removing external dependencies from a unit test in order to create a controlled environment around it. Typically, we mock all other classes that interact with the class that we want to test.
 */
public class ReimbursementServiceTest {
    private ReimbursementService sut;
    private final ReimbursementDAO mockReimbursementDao = Mockito.mock(ReimbursementDAO.class);

    /*
        Common JUnit annotations:
            - @Test (marks a method as a test case)
            - @Ignore (tells JUnit to skip this test case)
            - @Before (logic that runs once before every test case)
            - @After (logic that runs once after every test case)
            - @BeforeClass (logic that runs only once before all test cases)
            - @AfterClass (logic that runs only once after all test cases)

        Common Mockito terminologies:
            - stub: a stub is a fake class that comes with pre-programmed return values.
            - mocking: allows us to create a mock (copy) object of a class or an interface. We can then use the mock to stub return values for its methods and verify if they were called.
            - spying: a Spy is like a partial mock, which will track the interactions with the object like a mock.

        Still confused on spying vs mocking? https://stackoverflow.com/questions/15052984/what-is-the-difference-between-mocking-and-spying-when-using-mockito
     */

    @Before
    public void init() {
        sut = new ReimbursementService(mockReimbursementDao);
    }

    @Ignore
    public void test_isValidUsername_givenCorrectUsername() {
        // AAA = Arrange Act Assert

        // Arrange (essentially the setup)
        String validUsername = "bduong0929";

        // Act (essentially calling the method you are testing)
        // boolean condition = sut.isValidUsername(validUsername);

        // Assert (compare the actual to the expected)
        // assertTrue(condition);
    }

    @Ignore
    public void test_getAllReimbursementsByStatusUUID() {
        // Arrange
        ReimbursementService spySut = Mockito.spy(sut);
        // String  = "user2";
        List<String> stubbedUsernames = Arrays.asList("tester001", "tester002", "tester003");

        // controlled env
        Mockito.when(mockReimbursementDao.getAllReimbursementsByStatusUUID(DatatypeCrossRef.statusEnum2UUID(Status.PENDING)));

        // Act
        //boolean condition = spySut.isDuplicateUsername(uniqueUsername);

        // Assert
        //assertFalse(condition);
    }

    @Ignore
    public void test_isValidSignup_persistUserGivenUsernameAndPassword() {
        // Arrange
        ReimbursementService spySut = Mockito.spy(sut);
        //String = "michael007";
        //String = "passw0rd";
        //String = "passw0rd";
        NewReimbursementRequest stubbedReq = new NewReimbursementRequest(/* */);

        // Act
        // Reimbursement submittedReimbursement = spySut.getAllReimbursementsByUserUUID(stubbedReq);

        // Assert
        /* assertNotNull(submittedReimbursement);
        assertNotNull(submittedReimbursement.getReimbursementUUID());
        assertNotNull(submittedReimbursement.getAmount());
        assertNotNull(submittedReimbursement.getDescription());
        assertNotEquals("", submittedReimbursement.getType());
        assertEquals(Status.PENDING, submittedReimbursement.getStatus());
        Mockito.verify(mockReimbursementDao, Mockito.times(1)).save(submittedReimbursement); */
    }

    @Ignore // (expected = InvalidUserException.class)
    public void test_invalidUsername_givenIncorrectUsername() throws InvalidUserException {
        // do some logic to throw exception

        // Arrange
        //UserService spySut = Mockito.spy(sut);
        String invalidUsername = "m!ch@el006";
        String validPassword1 = "passw0rd";
        String validPassword2 = "passw0rd";
        // NewUserRequest stubbedReq = new NewUserRequest(invalidUsername, validPassword1, validPassword2);

        //Act
        //    User createdUser = spySut.signup(stubbedReq);


        //Assert
        /* assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
        assertNotNull(createdUser.getUsername());
        assertNotNull(createdUser.getPassword());
        assertNotEquals("", createdUser.getUsername());
        assertEquals(UserRole.EMPLOYEE, createdUser.getRole());
        Mockito.verify(mockUserDao, Mockito.times(1)).save(createdUser); */
    }
}

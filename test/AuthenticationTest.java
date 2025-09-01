/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.awt.event.ActionEvent;
import java.lang.reflect.Method;
//import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.Statement;
//import java.sql.*;

/**
 *
 * @author winso
 */
public class AuthenticationTest {
    
    public AuthenticationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of hashIt method, of class Authentication.
     */
    @Test
    public void testHashItConsistency() {
        System.out.println("Testing hashIt - consistency");
        String input = "1234";
        String hash1 = Authentication.hashIt(input);
        String hash2 = Authentication.hashIt(input);

        // Hash should always return the same result for the same input
        assertEquals("Hash should be consistent for the same input", hash1, hash2);
    }

    @Test
    public void testHashItDifferentInputs() {
        System.out.println("Testing hashIt - different inputs");
        String hash1 = Authentication.hashIt("1234");
        String hash2 = Authentication.hashIt("abcd");

        // Different inputs should produce different hashes
        assertNotEquals("Different inputs should produce different hashes", hash1, hash2);
    }

    @Test
    public void testHashItNotNull() {
        System.out.println("Testing hashIt - not null");
        String input = "test";
        String result = Authentication.hashIt(input);

        assertNotNull("Hash result should not be null", result);
        assertTrue("Hash should not be empty", result.length() > 0);
    }

    @Test
    public void testHashItBase64Format() {
        System.out.println("Testing hashIt - Base64 format");
        String input = "test";
        String result = Authentication.hashIt(input);

        // Base64 should contain only A-Z, a-z, 0-9, +, /, and possibly =
        assertTrue("Hash should be in Base64 format", result.matches("^[A-Za-z0-9+/=]+$"));
    }

    /**
     * Test of getAuthenticatedAccountNumber method, of class Authentication.
     */
    @Test
    public void testGetAuthenticatedAccountNumber() {
        System.out.println("Testing getAuthenticatedAccountNumber");

        // Initially, it should be empty
        assertEquals("Initially should be empty", "", Authentication.getAuthenticatedAccountNumber());

        // Simulate authentication
        // Normally, this would be set after login, so we set it manually
        java.lang.reflect.Field field;
        try {
            field = Authentication.class.getDeclaredField("authenticatedAccountNumber");
            field.setAccessible(true);
            field.set(null, "123456");
        } catch (Exception e) {
            fail("Failed to set field: " + e.getMessage());
        }

        // Now it should return the updated value
        assertEquals("Should return the account number set internally", "123456", Authentication.getAuthenticatedAccountNumber());
    }
    
    /**
     * Test of jButton2ActionPerformed method, of class Authentication.
     */
    @Test
    public void testSignUpButtonAction() throws Exception {
        System.out.println("Testing Sign Up button");
        Authentication authFrame = new Authentication();
        authFrame.setVisible(true);

        ActionEvent event = new ActionEvent(authFrame, ActionEvent.ACTION_PERFORMED, "SignUp");

        // Access private method using reflection
        Method method = Authentication.class.getDeclaredMethod("jButton2ActionPerformed", ActionEvent.class);
        method.setAccessible(true);
        method.invoke(authFrame, event);

        // After click, Authentication should be hidden
        assertFalse("Authentication frame should not be visible after SignUp click", authFrame.isVisible());
    }
    
    /**
     * Test of jButton1ActionPerformed method, of class Authentication.
     */
//    @Test
//    public void testSignInButtonAction() throws Exception {
//        System.out.println("Testing Sign In button");
//
//        // Reset static authenticated account number before the test
//        Field authAccountField = Authentication.class.getDeclaredField("authenticatedAccountNumber");
//        authAccountField.setAccessible(true);
//        authAccountField.set(null, null);
//
//        // Setup Authentication frame
//        Authentication authFrame = new Authentication();
//
//        // Create an in-memory SQLite DB for testing
//        Connection conn = DriverManager.getConnection("jdbc:sqlite::memory:");
//        Statement stmt = conn.createStatement();
//        stmt.execute("CREATE TABLE Account(Account TEXT, Pin TEXT)");
//
//        String account = "12345";
//        String hashedPin = Authentication.hashIt("9999");
//        stmt.execute("INSERT INTO Account VALUES('" + account + "','" + hashedPin + "')");
//
//        // Inject this test DB connection into Authentication
//        Field connField = Authentication.class.getDeclaredField("conn");
//        connField.setAccessible(true);
//        connField.set(authFrame, conn);
//
//        // Also inject into javaconnect singleton
//        Field instanceField = javaconnect.class.getDeclaredField("uniqueJavaConnect");
//        instanceField.setAccessible(true);
//        Object javaConnectInstance = instanceField.get(null);
//
//        if (javaConnectInstance != null) {
//            Field javaConnField = javaconnect.class.getDeclaredField("conn");
//            javaConnField.setAccessible(true);
//            javaConnField.set(javaConnectInstance, conn);
//        }
//
//        // Access private text fields and set input values
//        Field field1 = Authentication.class.getDeclaredField("jTextField1");
//        field1.setAccessible(true);
//        javax.swing.JTextField textField1 = (javax.swing.JTextField) field1.get(authFrame);
//        textField1.setText(account);
//
//        Field field2 = Authentication.class.getDeclaredField("jTextField2");
//        field2.setAccessible(true);
//        javax.swing.JTextField textField2 = (javax.swing.JTextField) field2.get(authFrame);
//        textField2.setText("9999");
//
//        // Call the private method jButton1ActionPerformed
//        Method method = Authentication.class.getDeclaredMethod("jButton1ActionPerformed", java.awt.event.ActionEvent.class);
//        method.setAccessible(true);
//        ActionEvent event = new ActionEvent(authFrame, ActionEvent.ACTION_PERFORMED, "SignIn");
//        method.invoke(authFrame, event);
//
//        // Verify result
//        assertEquals("Authenticated account should be set correctly", account, Authentication.getAuthenticatedAccountNumber());
//    }

    
}

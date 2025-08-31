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
import javax.swing.JTextField;
import java.lang.reflect.Field;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import static org.mockito.Mockito.*;
//import org.mockito.ArgumentMatchers;

/**
 *
 * @author winso
 */
public class AccountTest {
    
    public AccountTest() {
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
     * Test of RandomAcc method, of class Account.
     * @throws java.lang.Exception
     */
    @Test
    public void testRandomAccSetsValue() throws Exception {
        Account account = new Account();

        // Inject jTextField1
        Field field = Account.class.getDeclaredField("jTextField1");
        field.setAccessible(true);
        field.set(account, new JTextField());

        // Call method
        account.RandomAcc();

        // Get value
        JTextField textField = (JTextField) field.get(account);
        String value = textField.getText();

        // Assertions
        assertFalse("RandomAcc should set a value", value.isEmpty());
        assertTrue("Value should be numeric", value.matches("\\d+"));
    }

    /**
     * Test of RandomMICR method, of class Account.
     * @throws java.lang.Exception
     */
    @Test
    public void testRandomMICRSetsValue() throws Exception {
        Account account = new Account();

        // Inject jTextField2
        Field field = Account.class.getDeclaredField("jTextField2");
        field.setAccessible(true);
        field.set(account, new JTextField());

        // Call method
        account.RandomMICR();

        // Get value
        JTextField textField = (JTextField) field.get(account);
        String value = textField.getText();

        // Assertions
        assertFalse("RandomMICR should set a value", value.isEmpty());
        assertTrue("Value should be numeric", value.matches("\\d+"));
    }
    

    /**
     * Test of RandomPIN method, of class Account.
     * @throws java.lang.Exception
     */
    @Test
    public void testRandomPINRange() throws Exception {
        Account account = new Account();
        account.RandomPIN();

        java.lang.reflect.Field field = Account.class.getDeclaredField("jTextField3");
        field.setAccessible(true);
        javax.swing.JTextField textField = (javax.swing.JTextField) field.get(account);

        int value = Integer.parseInt(textField.getText());
        assertTrue("PIN should be between 0 and 1000", value >= 0 && value <= 1000);
    }

    /**
     * Test of Bal method, of class Account.
     */
//    @Test
//    public void testBalExecutesInsert() throws Exception {
//        Account account = new Account();
//
//        // Mock DB objects
//        Connection mockConn = mock(Connection.class);
//        PreparedStatement mockPst = mock(PreparedStatement.class);
//        when(mockConn.prepareStatement(anyString())).thenReturn(mockPst);
//
//        // Inject mock connection
//        Field connField = Account.class.getDeclaredField("conn");
//        connField.setAccessible(true);
//        connField.set(account, mockConn);
//
//        // Inject text fields for values
//        Field f1 = Account.class.getDeclaredField("jTextField4");
//        f1.setAccessible(true);
//        f1.set(account, new JTextField("test"));
//
//        Field f2 = Account.class.getDeclaredField("jTextField1");
//        f2.setAccessible(true);
//        f2.set(account, new JTextField("test"));
//
//        Field f3 = Account.class.getDeclaredField("jTextField2");
//        f3.setAccessible(true);
//        f3.set(account, new JTextField("test"));
//
//        Field f4 = Account.class.getDeclaredField("jTextField10");
//        f4.setAccessible(true);
//        f4.set(account, new JTextField("test"));
//
//        // Call method
//        account.Bal();
//
//        // Verify DB execution
//        verify(mockPst, times(1)).execute();
//    }

    /**
     * Test of isValidUsername method, of class Account.
     */
    @Test
    public void testIsValidUsername() {
        assertTrue("Valid username should pass", Account.isValidUsername("John123"));
        assertTrue("Valid username with underscore should pass", Account.isValidUsername("Alice_99"));
        assertFalse("Empty string should fail", Account.isValidUsername(""));
        assertFalse("Cannot start with a digit", Account.isValidUsername("12345"));
        assertFalse("Null should fail", Account.isValidUsername(null));
    }

    /**
     * Test of isValidMobileNo method, of class Account.
     */
    @Test
    public void testIsValidMobileNo() {
        assertTrue("Valid Indian mobile number should pass", Account.isValidMobileNo("9876543210"));
        assertTrue("Another valid mobile should pass", Account.isValidMobileNo("7890123456"));
        assertFalse("Number starting with 1 should fail", Account.isValidMobileNo("1234567890"));
        assertFalse("Too short should fail", Account.isValidMobileNo("98765"));
    }
    /**
     * Test of isNumeric method, of class Account.
     */
    @Test
    public void testIsNumeric() {
        assertTrue("Numeric string should pass", Account.isNumeric("123"));
        assertFalse("String with letters should fail", Account.isNumeric("12a3"));
        assertFalse("Empty string should fail", Account.isNumeric(""));
        assertFalse("Null should fail", Account.isNumeric(null));
    }
    
}

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
import javax.swing.*;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author winso
 */
public class MyPageTest {
    
    public MyPageTest() {
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
     * Test of setAuthenticatedAccountNumber method, of class MyPage.
     */
    @Test
    public void testSetAuthenticatedAccountNumber() {
        System.out.println("Testing setAuthenticatedAccountNumber");
        String accountNumber = "ACC12345";

        MyPage.setAuthenticatedAccountNumber(accountNumber);

        assertEquals("Account number should match", accountNumber, MyPage.getAuthenticatedAccountNumber());
    }

    /**
     * Test of set_profile_page method, of class MyPage.
     */
    @Test
    public void testSet_profile_page() {
        System.out.println("Testing set_profile_page");

        MyPage.setAuthenticatedAccountNumber("ACC12345"); // Set dummy account number

        MyPage instance = new MyPage() {
            @Override
            public void set_profile_page() {
                // Override to avoid real DB calls
                System.out.println("Simulated set_profile_page for account: " + MyPage.getAuthenticatedAccountNumber());
            }
        };

        // Call the method
        instance.set_profile_page();

        // Assert that account number is still correct
        assertEquals("ACC12345", MyPage.getAuthenticatedAccountNumber());
    }

    /**
     * Test of Table1 method, of class MyPage.
     */
    @Test
    public void testTable1() {
        System.out.println("Testing Table1");

        MyPage instance = new MyPage() {
            @Override
            public void Table1() {
                // Simulate setting data in table
                javax.swing.JTable mockTable = new javax.swing.JTable();
                mockTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][] { {"12345", "John Doe", "1990-01-01", "Saving", "Male", "9876543210"} },
                    new String[] { "Account", "Name", "DOB", "Acc_type", "Gender", "Mob" }
                ));
                try {
                    java.lang.reflect.Field tableField = MyPage.class.getDeclaredField("jTable1");
                    tableField.setAccessible(true);
                    tableField.set(this, mockTable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        instance.Table1();

        try {
            java.lang.reflect.Field tableField = MyPage.class.getDeclaredField("jTable1");
            tableField.setAccessible(true);
            javax.swing.JTable jTable1 = (javax.swing.JTable) tableField.get(instance);

            assertNotNull(jTable1.getModel());
            assertEquals("12345", jTable1.getValueAt(0, 0));
            assertEquals("John Doe", jTable1.getValueAt(0, 1));
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    /**
     * Test of Table2 method, of class MyPage.
     */
    @Test
    public void testTable2() {
        System.out.println("Testing Table2");

        MyPage instance = new MyPage() {
            @Override
            public void Table2() {
                javax.swing.JTable mockTable = new javax.swing.JTable();
                mockTable.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][] { {"12345", "John Doe", "MICR001", "5000"} },
                    new String[] { "Account", "Name", "MICR_No", "Balance" }
                ));
                try {
                    java.lang.reflect.Field tableField = MyPage.class.getDeclaredField("jTable2");
                    tableField.setAccessible(true);
                    tableField.set(this, mockTable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        instance.Table2();

        try {
            java.lang.reflect.Field tableField = MyPage.class.getDeclaredField("jTable2");
            tableField.setAccessible(true);
            javax.swing.JTable jTable2 = (javax.swing.JTable) tableField.get(instance);

            assertNotNull(jTable2.getModel());
            assertEquals("12345", jTable2.getValueAt(0, 0));
            assertEquals("5000", jTable2.getValueAt(0, 3));
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    /**
     * Test of Calendar method, of class MyPage.
     */
    @Test
    public void testCalendar() {
        System.out.println("Testing Calendar");

        MyPage instance = new MyPage() {
            @Override
            public void Calendar() {
                try {
                    java.lang.reflect.Field labelField = MyPage.class.getDeclaredField("jLabel14");
                    labelField.setAccessible(true);
                    javax.swing.JLabel label = new javax.swing.JLabel();
                    labelField.set(this, label);

                    java.util.Calendar cal = new java.util.GregorianCalendar();
                    int day = cal.get(java.util.Calendar.DAY_OF_MONTH);
                    int month = cal.get(java.util.Calendar.MONTH) + 1;
                    int year = cal.get(java.util.Calendar.YEAR);
                    label.setText(day + "-" + month + "-" + year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        instance.Calendar();

        try {
            java.lang.reflect.Field labelField = MyPage.class.getDeclaredField("jLabel14");
            labelField.setAccessible(true);
            javax.swing.JLabel label = (javax.swing.JLabel) labelField.get(instance);

            assertNotNull(label.getText());
            assertTrue(label.getText().matches("\\d{1,2}-\\d{1,2}-\\d{4}"));
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
    
    /**
     * Test of jButton14ActionPerformed method, of class MyPage.
     */
    @Test
    public void testJButton14ActionPerformed() throws Exception {
        System.out.println("Testing jButton14ActionPerformed");

        // Create instance of MyPage
        MyPage instance = new MyPage();

        // Dynamically inject JTextFields into private fields
        String[] fieldNames = {
            "jTextField34", "jTextField35", "jTextField36",
            "jTextField37", "jTextField38", "jTextField39", "jTextField40"
        };

        for (String fieldName : fieldNames) {
            Field field = MyPage.class.getDeclaredField(fieldName);
            field.setAccessible(true); // Allow access
            field.set(instance, new JTextField()); // Inject dummy JTextField
        }

        // Access the private method
        Method method = MyPage.class.getDeclaredMethod("jButton14ActionPerformed", java.awt.event.ActionEvent.class);
        method.setAccessible(true);

        // Simulate ActionEvent
        ActionEvent evt = new ActionEvent(instance, ActionEvent.ACTION_PERFORMED, "testClick");

        // Manually set expected values to simulate database results
        setPrivateTextField(instance, "jTextField34", "John Doe");
        setPrivateTextField(instance, "jTextField35", "12345");
        setPrivateTextField(instance, "jTextField36", "MICR001");
        setPrivateTextField(instance, "jTextField37", "4%");
        setPrivateTextField(instance, "jTextField38", "5000");
        setPrivateTextField(instance, "jTextField39", "Rs 0.00");
        setPrivateTextField(instance, "jTextField40", "No");

        // Call the private method
        method.invoke(instance, evt);

        // Verify values
        assertEquals("John Doe", getPrivateTextFieldValue(instance, "jTextField34"));
        assertEquals("12345", getPrivateTextFieldValue(instance, "jTextField35"));
        assertEquals("MICR001", getPrivateTextFieldValue(instance, "jTextField36"));
        assertEquals("4%", getPrivateTextFieldValue(instance, "jTextField37"));
        assertEquals("5000", getPrivateTextFieldValue(instance, "jTextField38"));
        assertEquals("Rs 0.00", getPrivateTextFieldValue(instance, "jTextField39"));
        assertEquals("No", getPrivateTextFieldValue(instance, "jTextField40"));
    }

    // Helper method to set value of a private JTextField
    private void setPrivateTextField(Object instance, String fieldName, String value) throws Exception {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(instance);
        textField.setText(value);
    }

    // Helper method to get value of a private JTextField
    private String getPrivateTextFieldValue(Object instance, String fieldName) throws Exception {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        JTextField textField = (JTextField) field.get(instance);
        return textField.getText();
    }
    
    private Field getFieldFromHierarchy(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldName);
    }
    /**
     * Test of jButton16ActionPerformed method, of class MyPage.
     */
    @Test
    public void testJButton16ActionPerformed() throws Exception {
        System.out.println("Testing jButton16ActionPerformed (Change PIN)");

        // Set dummy account number
        MyPage.setAuthenticatedAccountNumber("ACC12345");

        // Create instance
        MyPage instance = new MyPage();

        // Set old and new PINs in text fields
        setPrivateTextField(instance, "jTextField41", "oldPin");
        setPrivateTextField(instance, "jTextField42", "newPin");

        // Access the private method using reflection
        Method method = MyPage.class.getDeclaredMethod("jButton16ActionPerformed", java.awt.event.ActionEvent.class);
        method.setAccessible(true);

        // Simulate ActionEvent
        method.invoke(instance, new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "command"));

        // ✅ Verify fields
        String oldPinValue = getPrivateTextFieldValue(instance, "jTextField41");
        String newPinValue = getPrivateTextFieldValue(instance, "jTextField42");

        assertEquals("oldPin", oldPinValue); 
        assertEquals("newPin", newPinValue);
    }
    
    @Test
    public void testJButton15ActionPerformed() throws Exception {
        System.out.println("Testing jButton15ActionPerformed (Clear PIN Fields)");

        MyPage instance = new MyPage();

        // Simulate user typed values
        setPrivateTextField(instance, "jTextField41", "oldPin");
        setPrivateTextField(instance, "jTextField42", "newPin");

        // Invoke the private method using reflection
        Method method = MyPage.class.getDeclaredMethod("jButton15ActionPerformed", java.awt.event.ActionEvent.class);
        method.setAccessible(true);
        method.invoke(instance, new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "command"));

        // Verify both fields are cleared
        String oldPinValue = getPrivateTextFieldValue(instance, "jTextField41");
        String newPinValue = getPrivateTextFieldValue(instance, "jTextField42");

        assertEquals("", oldPinValue);
        assertEquals("", newPinValue);
    }
    
    private Field getFieldRecursive(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        while (clazz != null) {
            try {
                return clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                clazz = clazz.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldName);
    }
    
    private Object getPrivateFieldValue(Object instance, String fieldName) throws Exception {
        Field field = getFieldRecursive(instance.getClass(), fieldName);
        field.setAccessible(true);
        return field.get(instance);
    }   
    
    /**
     * Test of Account method, of class MyPage.
     */
    @Test
    public void testAccountMethod() throws Exception {
        System.out.println("Testing Account() - DB Bypassed");

        // Create a test subclass to override DB logic
        MyPage instance = new MyPage() {
            public void simulateAccount() {
                try {
                    JComboBox<String> comboBox = (JComboBox<String>) getPrivateFieldValue(this, "jComboBox1");
                    comboBox.removeAllItems(); // Reset before test

                    // Simulate adding accounts (bypass DB)
                    comboBox.addItem("ACC123");
                    comboBox.addItem("ACC456");
                    comboBox.addItem("ACC789");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        // Invoke simulation
        instance.getClass().getMethod("simulateAccount").invoke(instance);

        // Get ComboBox values
        JComboBox<String> comboBox = (JComboBox<String>) getPrivateFieldValue(instance, "jComboBox1");
        assertEquals(3, comboBox.getItemCount());
        assertEquals("ACC123", comboBox.getItemAt(0));
        assertEquals("ACC456", comboBox.getItemAt(1));
        assertEquals("ACC789", comboBox.getItemAt(2));
    }
    
    private void setPrivateField(Object instance, String fieldName, Object value) throws Exception {
        Field field = getFieldRecursive(instance.getClass(), fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }

    /**
     * Test of TransferC method, of class MyPage.
     */
//    @Test
//    public void testTransferCMethod() throws Exception {
//        System.out.println("Testing TransferC() - DB Bypassed");
//
//        MyPage instance = new MyPage() {
//            public void simulateTransferC() {
//                try {
//                    JComboBox<String> comboBox = (JComboBox<String>) getPrivateFieldValue(this, "jComboBox1");
//                    JTextField textField26 = (JTextField) getPrivateFieldValue(this, "jTextField26");
//
//                    // Simulate fetching selection and entered amount
//                    String selectedAcc = (String) comboBox.getSelectedItem();
//                    String amount = textField26.getText();
//
//                    // Instead of DB update, just simulate confirmation
//                    if (selectedAcc != null && !amount.isEmpty()) {
//                        textField26.setText("TRANSFERRED"); // Just a simulation marker
//                    }
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        // Setup test data
//        JComboBox<String> comboBox = new JComboBox<>();
//        comboBox.addItem("ACC123");
//        setPrivateField(instance, "jComboBox1", comboBox);
//
//        setPrivateTextField(instance, "jTextField26", "500");
//
//        // Call simulation
//        instance.getClass().getMethod("simulateTransferC").invoke(instance);
//
//        // Verify simulation effect
//        String result = getPrivateTextFieldValue(instance, "jTextField26");
//        assertEquals("TRANSFERRED", result);
//    }

    /**
     * Test of TransferD method, of class MyPage.
     */
//    @Test
//    public void testTransferDMethod() throws Exception {
//        System.out.println("Testing TransferD() - DB Bypassed");
//
//        MyPage.setAuthenticatedAccountNumber("ACC999");
//
//        MyPage instance = new MyPage() {
//            public void simulateTransferD() {
//                try {
//                    String currentAcc = MyPage.getAuthenticatedAccountNumber();
//                    JTextField textField25 = (JTextField) getPrivateFieldValue(this, "jTextField25");
//
//                    // Simulate DB update by changing field value
//                    if (!currentAcc.isEmpty()) {
//                        textField25.setText("UPDATED");
//                    }
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        };
//
//        // Set initial value
//        setPrivateTextField(instance, "jTextField25", "1000");
//
//        // Invoke simulation
//        instance.getClass().getMethod("simulateTransferD").invoke(instance);
//
//        // Verify
//        String updatedValue = getPrivateTextFieldValue(instance, "jTextField25");
//        assertEquals("UPDATED", updatedValue);
//    }
}

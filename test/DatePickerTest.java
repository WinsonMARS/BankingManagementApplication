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
import javax.swing.*;

/**
 *
 * @author winso
 */
public class DatePickerTest {
    
    public DatePickerTest() {
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
     * Test of displayDate method, of class DatePicker.
     */
    @Test
    public void testDisplayDate() {
        System.out.println("Testing displayDate()");

        // Create a DatePicker instance with sample year and month
        DatePicker instance = new DatePicker(new JFrame());
        instance.year = 2025;
        instance.month = 8; // September (0-based index if your code uses Calendar months)

        // Call displayDate()
        instance.displayDate();

        // Verify that the label (l) text is formatted as "September 2025"
        String labelText = instance.l.getText();
        assertTrue("Label should contain correct month and year", labelText.contains("2025"));

        // Check that title is set correctly
        assertEquals("Date Picker", instance.d.getTitle());

        // Verify that some button values are set (at least first day is populated)
        boolean hasDay = false;
        for (int i = 7; i < instance.button.length; i++) {
            if (!instance.button[i].getText().isEmpty()) {
                hasDay = true;
                break;
            }
        }
        assertTrue("Calendar should have at least one day populated", hasDay);
    }

    /**
     * Test of setPickedDate method, of class DatePicker.
     */
    @Test
    public void testSetPickedDate() {
        System.out.println("Testing setPickedDate()");

        // Create DatePicker instance
        DatePicker instance = new DatePicker(new JFrame());
        instance.year = 2025;
        instance.month = 8; // September
        instance.day = "15";

        String result = instance.setPickedDate();
        assertEquals("2025-09-15", result);

        // Test edge case: if day is empty
        instance.day = "";
        result = instance.setPickedDate();
        assertEquals("", result);
    }
    
}

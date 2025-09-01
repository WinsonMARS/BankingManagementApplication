/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author winso
 */
public class javaconnectTest {
    
    public javaconnectTest() {
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
     * Test of getInstance method, of class javaconnect.
     */
    @Test
    public void testGetInstance() {
        System.out.println("Testing getInstance");
        javaconnect instance1 = javaconnect.getInstance();
        assertNotNull("Instance should not be null", instance1);

        javaconnect instance2 = javaconnect.getInstance();
        assertSame("Both calls should return the same instance (Singleton)", instance1, instance2);
    }

    /**
     * Test of ConnectDb method, of class javaconnect.
     */
    @Test
    public void testConnectDb() {
        System.out.println("Testing ConnectDb");
        javaconnect instance = javaconnect.getInstance();
        Connection conn = instance.ConnectDb();
        assertNotNull("Database connection should not be null", conn);
    }
    
}

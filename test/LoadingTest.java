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
import javax.swing.JProgressBar;
import java.lang.reflect.Field;

/**
 *
 * @author winso
 */
public class LoadingTest {
    
    public LoadingTest() {
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
     * Test of setUpLoading method, of class Loading.
     */
    @Test
    public void testSetUpLoading() {
        System.out.println("Testing setUpLoading");
        Loading instance = new Loading();

        // Run setUpLoading (it hides the frame and starts thread)
        instance.setUpLoading();

        // Check if thread is alive (it should be running)
        assertTrue("Thread should be alive after starting", instance.th.isAlive());

        // Stop the thread early to avoid blocking test (optional)
        instance.th.interrupt();
    }

    /**
     * Test of run method, of class Loading.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("Testing run");
        Loading instance = new Loading();

        // Access private field via reflection
        Field field = Loading.class.getDeclaredField("jProgressBar1");
        field.setAccessible(true);
        JProgressBar progressBar = (JProgressBar) field.get(instance);

        // Initially progress should be 0
        assertEquals(0, progressBar.getValue());

        // Run in a separate thread
        Thread t = new Thread(instance::run);
        t.start();

        // Let it update a bit
        Thread.sleep(200);

        // Progress bar should have increased
        assertTrue("Progress bar should be greater than 0", progressBar.getValue() > 0);

        // Stop the thread
        t.interrupt();
    }
    
}

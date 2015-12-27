

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarehouseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WarehouseTest
{
    private Warehouse warehous1;

    /**
     * Default constructor for test class WarehouseTest
     */
    public WarehouseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        warehous1 = new Warehouse("SomeCity", "SomeItem");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void ConstructTest()
    {
        assertEquals("SomeCity", warehous1.getCity());
        assertEquals("SomeItem", warehous1.getItem());
    }
}


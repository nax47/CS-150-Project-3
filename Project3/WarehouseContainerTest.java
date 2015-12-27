
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarehouseContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WarehouseContainerTest
{
    private WarehouseContainer warehouseCont1;

    /**
     * Default constructor for test class WarehouseContainerTest
     */
    public WarehouseContainerTest()
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
        warehouseCont1 = new WarehouseContainer();
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
    public void AddGetTest1()
    {
        warehouseCont1.add(new Warehouse("SomeCity1", "SomeItem1"));
        assertEquals(warehouseCont1.get(0).getCity(), "SomeCity1");
        assertEquals(warehouseCont1.get(0).getItem(), "SomeItem1");
        warehouseCont1.add(new Warehouse("SomeCity2", "SomeItem2"));
        warehouseCont1.add(new Warehouse("SomeCity3", "SomeItem3"));
        assertEquals(warehouseCont1.get(2).getCity(), "SomeCity3");
        assertEquals(warehouseCont1.get(2).getItem(), "SomeItem3");
        assertEquals(warehouseCont1.get(1).getCity(), "SomeCity2");
        assertEquals(warehouseCont1.get(1).getItem(), "SomeItem2");
        assertEquals(warehouseCont1.get(0).getCity(), "SomeCity1");
        assertEquals(warehouseCont1.get(0).getItem(), "SomeItem1");
    }

    @Test
    public void AddGetTest2()
    {
        assertEquals(false, warehouseCont1.add(null));
        assertEquals(null, warehouseCont1.get(-1));
    }

    @Test
    public void SizeTest()
    {
        assertEquals(0, warehouseCont1.size());
        warehouseCont1.add(new Warehouse("SomeCity1", "SomeItem1"));
        assertEquals(1, warehouseCont1.size());
        for(int i = 1; i<100; i++){
            warehouseCont1.add(new Warehouse("SomeCity"+(i+1), "SomeItem"+(i+1)));
        }
        assertEquals(100, warehouseCont1.size());
    }
}




import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityMapContainerTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityMapContainerTest
{
    private CityMapContainer cont;

    /**
     * Default constructor for test class CityMapContainerTest
     */
    public CityMapContainerTest()
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
        cont = new CityMapContainer();
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
    public void AddGetCityTest()
    {
        assertEquals(0,cont.getCities().size());
        cont.addCity(5);  
        assertEquals(1,cont.getCities().size());
        cont.addCity(9);  
        cont.addCity(63);  
        assertEquals(3,cont.getCities().size());
    }
    
    //Additional methods directly use only UnDirectedGraph class methods
    //please see UnDirectedGraph test methods
}


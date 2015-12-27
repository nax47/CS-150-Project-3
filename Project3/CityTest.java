

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CityTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CityTest
{
    private City city1;

    /**
     * Default constructor for test class CityTest
     */
    public CityTest()
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
        city1 = new City("Some City");
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
    public void NameTest()
    {
        assertEquals("Some City", city1.getName());
    }
}


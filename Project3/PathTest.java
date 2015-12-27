
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * The test class PathTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class PathTest
{
    private Path<Integer> path;

    /**
     * Default constructor for test class PathTest
     */
    public PathTest()
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
        path = new Path<Integer>();
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
    public void CostTest()
    {
        path.setPathCost(5.6);
        assertEquals(5.6, path.getPathCost(),0);
    }

    @Test
    public void AddTest(){
        assertEquals(false, path.iterator().hasNext());
        path.addPrev(5);
        assertTrue(5 == path.iterator().next());
        path.addPrev(9);
        path.addPrev(47);
        Iterator<Integer> itr = path.iterator();
        assertTrue(47 == itr.next());
        assertTrue(9 == itr.next());
        assertTrue(5 == itr.next());
    }

    @Test
    public void AddTest2(){
        assertEquals(false, path.addPrev(null));
    }
}


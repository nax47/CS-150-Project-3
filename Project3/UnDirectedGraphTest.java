
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnDirectedGraphTest.
 *
 * @author  Nakul Talwar
 * @version (a version number or a date)
 */
public class UnDirectedGraphTest
{
    private GraphReader reader;
    private UnDirectedGraph<Integer> graph;

    /**
     * Default constructor for test class UnDirectedGraphTest
     */
    public UnDirectedGraphTest()
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
        reader = new GraphReader("testgraph.txt");
        graph = new UnDirectedGraph<Integer>();
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
    public void addNodeTest()
    {
        assertEquals(graph.addNode(null), false);
        assertEquals(graph.getNodeCount(), 0);
        assertEquals(graph.addNode(47), true);
        assertEquals(graph.getNodeCount(), 1);
        assertEquals(graph.addNode(47), false);
        assertEquals(graph.getNodeCount(), 1);
        assertEquals(graph.addNode(74), true);
        assertEquals(graph.getNodeCount(), 2);
    }

    @Test
    public void addEdgeTest()
    {
        assertEquals(graph.addEdge(null,47,1), false);
        assertEquals(graph.addEdge(47,null,1), false);
        assertEquals(graph.addEdge(47,74,1), true);
        assertEquals(graph.getNode(47).adj.size(),1);
        assertEquals(graph.getNode(74).adj.size(),1);
        assertEquals(graph.addEdge(47,747,1), true);
        assertEquals(graph.getNode(47).adj.size(),2);
        assertEquals(graph.getNode(74).adj.size(),1);
    }

    @Test
    public void findShortestPathTest()
    {
        graph = reader.createGraph();
        assertEquals(graph.findShortestPath(1,1).getPathCost(), 0.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,2).getPathCost(), 13.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,3).getPathCost(), 30.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,4).getPathCost(), 9.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,5).getPathCost(), 41.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,6).getPathCost(), 8.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,7).getPathCost(), 3.0, 0);
        graph.clearAll();
        assertEquals(graph.findShortestPath(1,8).getPathCost(), 2.0, 0);
    }
}


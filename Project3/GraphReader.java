import java.util.*;
import java.io.*;
/**
 * GraphReader class - USED FOR TESTING.
 * 
 * @author Nakul Talwar
 */
public class GraphReader
{
    private UnDirectedGraph<Integer> graph;
    private Scanner sc;
    /**
     * Default constructor.
     * 
     * @param filename Name of file from which graph is to be read.
     */
    public GraphReader(String filename)
    {
        graph = new UnDirectedGraph<Integer>();
        try{
            sc = new Scanner(new File(filename));
        }catch(IOException e){
            System.out.println(e.toString());
        }
    }

    /**
     * Constructs graph by reading node and edge data from an external file.
     * 
     * @return Returns the created graph.
     */
    public UnDirectedGraph<Integer> createGraph(){
        Scanner sc2 = null;
        while(sc.hasNextLine()){
            sc2 = new Scanner(sc.nextLine());
            int n1 = Integer.parseInt(sc2.next());
            sc2.next();
            int n2 = Integer.parseInt(sc2.next());
            double weight = Double.parseDouble(sc2.next());
            graph.addEdge(n1,n2,weight);
        }
        sc2.close();
        sc.close();
        return graph;
    }
}

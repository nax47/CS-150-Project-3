import java.util.*;
/**
 * UnDirectedGraph class.
 * 
 * @author Nakul Talwar
 */
public class UnDirectedGraph<K>
{
    private HashMap<K,UnDirectedGraphNode> NodeMap;
    private int nodeCount;
    /**
     * Default constructor.
     */
    public UnDirectedGraph()
    {
        NodeMap= new HashMap<K,UnDirectedGraphNode>();
    }

    /**
     * Method to add a node to the graph.
     * 
     * @param name Key used to create node.
     * @return Returns whether or not the node was successfully added.
     */
    public boolean addNode(K name){
        if(name == null){return false;}
        else if(NodeMap.get(name) != null){return false;}
        else{
            NodeMap.put(name, new UnDirectedGraphNode(name));
            nodeCount++;
            return true;
        }
    }

    /**
     * Method to add an edge to the graph.
     * 
     * @param k1 Key for first node in the edge.
     * @param k2 Key for second node in the edge.
     * @param cost Weight for this edge
     * @return Returns whether or not the edge was successfully added.
     */
    public boolean addEdge(K k1, K k2, double cost){
        if(k1 == null || k2 == null){return false;}
        addNode(k1);
        addNode(k2);
        NodeMap.get(k1).adj.add(new Edge(NodeMap.get(k2), cost));
        NodeMap.get(k2).adj.add(new Edge(NodeMap.get(k1), cost));
        return true;
    }

    /**
     * Method to find the shortest path between two nodes.
     * 
     * @param k1 Key for first node.
     * @param k2 Key for second node.
     * @return Returns a list of nodes describing the shortest path.
     */
    public Path<K> findShortestPath(K k1, K k2){
        //System.out.println("Finding path from node "+k1.toString()+" to node "+k2.toString());
        if(k1 == null || k2 == null){return null;}
        PriorityQueue<UnDirectedGraphNode> AdjQueue = new PriorityQueue<UnDirectedGraphNode>(NodeMap.size(), new NodeDistanceComparator());
        UnDirectedGraphNode first = NodeMap.get(k1);
        first.dist = 0;
        AdjQueue.add(first);
        Path<K> path = new Path<K>();

        while(AdjQueue.peek()!=null){
            UnDirectedGraphNode current = AdjQueue.poll();
            current.known = true;
            //System.out.println("Processed node "+current.name.toString());
            //System.out.println("Shortest distance: "+current.dist);
            if(current.name.equals(k2)){
                path.setPathCost(current.dist);
                break;
            }
            for(int i = 0; i<current.adj.size(); i++){;
                UnDirectedGraphNode adj_current = current.adj.get(i).dest;
                if(adj_current.dist == -1){AdjQueue.add(adj_current);}
                if(!adj_current.known){
                    if(adj_current.dist>(current.dist+current.adj.get(i).cost) || adj_current.dist == -1){
                        AdjQueue.remove(adj_current);
                        adj_current.dist = current.dist+current.adj.get(i).cost;
                        adj_current.prev = current;
                        AdjQueue.add(adj_current);
                    }
                }
            }

        }

        UnDirectedGraphNode path_current = NodeMap.get(k2);
        //System.out.println("Shortest path from node "+k1.toString()+" to node "+k2.toString());
        while(path_current!=null){
            path.addPrev(path_current.name);
            //System.out.print(path_current.name.toString()+"<-");
            path_current = path_current.prev;
        }
        //System.out.println();

        return path;
    }

    /**
     * Method to reset the shortest path data stored within each node.
     */
    public void clearAll(){
        Iterator<K> itr= NodeMap.keySet().iterator();
        while(itr.hasNext()){
            NodeMap.get(itr.next()).reset();
        }
    }

    /**
     * Method to get the number of nodes.
     * 
     * @return Returns the number of nodes.
     */
    public int getNodeCount(){
        return NodeMap.size();
    }

    /**
     * Method to get a specific node.
     * 
     * @param k Key for node to be retrieved
     * @return Returns the node associated with key (or null if empty).
     */
    public UnDirectedGraphNode getNode(K k){
        return NodeMap.get(k);
    }

    /**
     * Method to get the set of nodes in this graph.
     * 
     * @return Returns the nodes as a Set of keys.
     */
    public Set<K> getNodeSet(){
        return NodeMap.keySet();
    }
    
    class UnDirectedGraphNode
    {
        public K name;   
        public LinkedList<Edge> adj;
        public double dist;
        public UnDirectedGraphNode prev;
        public boolean known;
        /**
         * Default constructor.
         */
        public UnDirectedGraphNode(K name)
        {
            this.name = name;
            adj = new LinkedList<Edge>();
            reset();
        }

        /**
         * Method to reset specific fields for this node.
         */
        public void reset(){
            dist = -1;
            prev = null;
            known = false;
        }
    }

    class NodeDistanceComparator implements Comparator<UnDirectedGraphNode>{
        /**
         * Method to compare two nodes based on distance from origin.
         * 
         * @param n1 First node.
         * @param n2 Second node.
         * @return Positive number if n1 has greater distance, negative number if smaller distance and 0 if equal.
         */
        public int compare(UnDirectedGraphNode n1, UnDirectedGraphNode n2){
            return Double.compare(n1.dist, n2.dist);
        }
    }

    class Edge
    {
        public UnDirectedGraphNode dest;
        public double cost;
        /**
         * Default constructor.
         */
        public Edge(UnDirectedGraphNode dest, double cost)
        {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
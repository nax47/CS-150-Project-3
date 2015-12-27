import java.util.*;
/**
 * MapContainer class.
 * 
 * @author Nakul Talwar
 */
public class CityMapContainer
{
    //Graph object to store map of cities
    private UnDirectedGraph<Integer> graph;
    /**
     * Default constructor.
     */
    public CityMapContainer()
    {
        graph = new UnDirectedGraph<Integer>();
    }

    /**
     * Method to add city to map.
     * 
     * @param city_number Number of city to be added.
     * @return Returns whether or not city was successfully added.
     */
    public boolean addCity(int city_number){
        return graph.addNode(city_number);
    }

    /**
     * Method to add interconnecting road between two cities.
     * 
     * @param city1 First city.
     * @param city2 Second city.
     * @param distance Distance between the cities.
     * @return Returns whether or not road was successfully added.
     */
    public boolean addRoad(int city1, int city2, double distance){
        return graph.addEdge(city1,city2,distance);
    }

    /**
     * Method to get number of cities.
     * 
     * @return Returns number of cities in map.
     */
    public int getCityCount(){
        return graph.getNodeCount();
    }

    /**
     * Method to reset internal parameters of each city in the map.
     */
    public void resetMap(){
        graph.clearAll();
    }

    /**
     * Method to find shortest path between two cities.
     * 
     * @param city First city.
     * @param city Second city.
     * @return Returns shortest path object.
     */
    public Path<Integer> findShortestPath(int city1, int city2){
        return graph.findShortestPath(city1,city2);
    }

    /**
     * Method to retrieve the set of cities in map.
     * 
     * @return Returns cities in a container object.
     */
    public CityContainer getCities(){
        Iterator itr = graph.getNodeSet().iterator();
        CityContainer cities = new CityContainer();
        while(itr.hasNext())
            cities.add(new City(itr.next().toString()));
        return cities;
    }
}

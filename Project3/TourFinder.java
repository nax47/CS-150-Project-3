import java.util.*;
/**
 * TourFinder class.
 * 
 * @author Nakul Talwar
 */
public class TourFinder
{
    private CityMapContainer citymap;
    private WarehouseContainer warehouses;
    private CityContainer cities;
    private TourContainer tours;
    private HashMap<String,CityContainer> CitiesOnTour;

    /**
     * Default constructor.
     */
    public TourFinder(CityMapContainer citymap, WarehouseContainer warehouses, CityContainer cities)
    {
        this.citymap = citymap;
        this.warehouses = warehouses;
        this.cities = cities;
        tours = new TourContainer();
        CitiesOnTour = new HashMap<String,CityContainer>();
    }

    /**
     * Method called externally to find the set of tours given a set of warehouses, a map and cities to include in the tours.
     * 
     * Calls subsequent methods to run algorithm.
     * @return Returns set of tours in a container object.
     */
    //To find the tour various steps are performed and a set of tours is stored in a container
    //One tour for each warehouse
    public TourContainer findTours(){
        findCitiesOnTour();
        for(int i=0; i<warehouses.size(); i++){
            tours.add(findTour(warehouses.get(i)));
        }
        return tours;
    }

    /**
     * Method called internally to assign a city to the tour for each warehouse based on minimum distance between each city and the warehouses.
     */
    //Algorithm compares distance of every city to distance of each warehouse
    //The closest warehouse to each city will supply the city
    //Each warehouse will have a certain set of cities to supply (from the total number of cities where the item is demanded)
    private void findCitiesOnTour(){
        for(int i=0; i<cities.size(); i++){
            String warehouse = "";
            City current_city = cities.get(i);
            double shortest_distance = -1;
            for(int j=0; j<warehouses.size(); j++){
                double current_distance = citymap.findShortestPath(Integer.parseInt(warehouses.get(j).getCity()),
                        Integer.parseInt(current_city.getName())).getPathCost();
                citymap.resetMap();
                if(current_distance<shortest_distance || shortest_distance == -1){
                    shortest_distance = current_distance;
                    warehouse = warehouses.get(j).getCity();
                }
            }
            if(CitiesOnTour.get(warehouse) == null){CitiesOnTour.put(warehouse,new CityContainer());}
            CityContainer tour_cities = CitiesOnTour.get(warehouse);
            tour_cities.add(current_city);
            CitiesOnTour.put(warehouse,tour_cities);
        }
    }

    /**
     * Method called internally to find the tour for a specific warehouse once a set of cities has been assigned to it.
     * 
     * @param warehouse Warehouse for which to calculate tour.
     * @return Returns the Tour object for this warehouse.
     */
    //Algorithm finds the closest city (from the list of cities to supply) at every step of iteration
    //Final step returns to the warehouse irrespective of distance
    //Djikstras algorithm performed at every city that is visited starting from warehouse and then every subsequent city picked from the list
    private Tour<Integer> findTour(Warehouse warehouse){
        Tour<Integer> tour = new Tour<Integer>();
        Path<Integer> next_dest_path = null;
        if(CitiesOnTour.get(warehouse.getCity())==null){return tour;}
        CityContainer cities_to_supply = CitiesOnTour.get(warehouse.getCity());
        String current_location = warehouse.getCity();
        int destination_index = 0;
        while(cities_to_supply.size()!=0){
            double shortest_distance = -1;          
            for(int i=0; i<cities_to_supply.size(); i++){
                Path<Integer> current_path = citymap.findShortestPath(Integer.parseInt(current_location),
                        Integer.parseInt(cities_to_supply.get(i).getName()));
                citymap.resetMap();
                double current_distance = current_path.getPathCost();
                if(current_distance<shortest_distance || shortest_distance == -1){
                    shortest_distance = current_distance;
                    next_dest_path = current_path;
                    destination_index = i;
                }
            }   
            tour.addPath(next_dest_path);
            current_location = cities_to_supply.remove(destination_index).getName();       
        }
        tour.addPath(citymap.findShortestPath(Integer.parseInt(current_location),
                Integer.parseInt(warehouse.getCity())));
        citymap.resetMap();
        return tour;
    }

}
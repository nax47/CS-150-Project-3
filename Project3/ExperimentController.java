import java.util.*;
/**
 * ExperimentController class.
 * 
 * @author Nakul Talwar 
 */
public class ExperimentController
{
    private CityContainer cities;
    private TopLevelContainer cont;
    private CityMapContainer citymap;
    private int cost_per_distance;
    private int baked_profit;
    private int meat_profit;
    private int dairy_profit;
    private int fruit_profit;
    private int veg_profit;
    private int bev_profit;
    private WarehouseContainer baked_stores;
    private WarehouseContainer meat_stores;
    private WarehouseContainer dairy_stores;
    private WarehouseContainer fruit_stores;
    private WarehouseContainer veg_stores;
    private WarehouseContainer bev_stores; 
    /**
     * Default constructor.
     */
    public ExperimentController(int cost_per_distance)
    {
        citymap = new CityMapContainer();
        this.cost_per_distance = cost_per_distance;
        baked_profit = 0;
        meat_profit = 0;
        dairy_profit = 0;
        fruit_profit = 0;
        veg_profit = 0;
        bev_profit = 0;
        cities = new CityContainer();
        cont = new TopLevelContainer();
        baked_stores = new WarehouseContainer();
        meat_stores = new WarehouseContainer();
        dairy_stores = new WarehouseContainer();
        fruit_stores = new WarehouseContainer();
        veg_stores = new WarehouseContainer();
        bev_stores = new WarehouseContainer();
    }

    /**
     * Method to set the city map.
     * 
     * @param citymap Map to be set.
     */
    public void setCityMap(CityMapContainer citymap){
        this.citymap = citymap;
        cities = citymap.getCities();
    }

    /**
     * Method to set profit per item for baked goods.
     * 
     * @param baked_profit Profit to be set.
     */
    public void setBakedProfit(int baked_profit){
        this.baked_profit = baked_profit;
    }

    /**
     * Method to set profit per item for meat.
     * 
     * @param meat_profit Profit to be set.
     */
    public void setMeatProfit(int meat_profit){
        this.meat_profit = meat_profit;
    }

    /**
     * Method to set profit per item for dairy.
     * 
     * @param dairy_profit Profit to be set.
     */
    public void setDairyProfit(int dairy_profit){
        this.dairy_profit = dairy_profit;
    }

    /**
     * Method to set profit per item for fruits.
     * 
     * @param fruit_profit Profit to be set.
     */
    public void setFruitProfit(int fruit_profit){
        this.fruit_profit = fruit_profit;
    }

    /**
     * Method to set profit per item for vegetables.
     * 
     * @param veg_profit Profit to be set.
     */
    public void setVegProfit(int veg_profit){
        this.veg_profit = veg_profit;
    }

    /**
     * Method to set profit per item for beverages.
     * 
     * @param bev_profit Profit to be set.
     */
    public void setBevProfit(int bev_profit){
        this.bev_profit = bev_profit;
    }

    /**
     * Method to set warehouse locations for baked goods.
     * 
     * @param baked_stores Container object for warehouse locations.
     */
    public void setBakedLocations(WarehouseContainer baked_stores){
        this.baked_stores = baked_stores;
    }

    /**
     * Method to set warehouse locations for meat.
     * 
     * @param meat_stores Container object for warehouse locations.
     */
    public void setMeatLocations(WarehouseContainer meat_stores){
        this.meat_stores = meat_stores;
    }

    /**
     * Method to set warehouse locations for dairy.
     * 
     * @param dairy_stores Container object for warehouse locations.
     */
    public void setDairyLocations(WarehouseContainer dairy_stores){
        this.dairy_stores = dairy_stores;
    }

    /**
     * Method to set warehouse locations for fruits.
     * 
     * @param fruit_stores Container object for warehouse locations.
     */
    public void setFruitLocations(WarehouseContainer fruit_stores){
        this.fruit_stores = fruit_stores;
    }

    /**
     * Method to set warehouse locations for vegetables.
     * 
     * @param veg_stores Container object for warehouse locations.
     */
    public void setVegLocations(WarehouseContainer veg_stores){
        this.veg_stores = veg_stores;
    }

    /**
     * Method to set warehouse locations for beverages.
     * 
     * @param bev_stores Container object for warehouse locations.
     */
    public void setBevLocations(WarehouseContainer bev_stores){
        this.bev_stores = bev_stores;
    }

    /**
     * Method to run customer generation simulation 10 times.
     * 
     * Generates approx 2000 customers.
     */
    public void runSim(){
        Simulation sim;
        for(int i =0; i<10; i++){
            sim = new Simulation(cities,cont);
            cont = sim.run();
        }
    }

    /**
     * Method to run algorithm to find routes for each type of item vendor.
     * 
     * Finds the tours individually for each warehouse for every type of good.
     */
    public void findRoutes(){
        System.out.print("\f");
        long startTime = System.nanoTime();
        findTours(baked_stores,baked_profit);
        findTours(meat_stores,meat_profit);
        findTours(dairy_stores,dairy_profit);
        findTours(fruit_stores,fruit_profit);
        findTours(veg_stores,veg_profit);
        findTours(bev_stores,bev_profit);
        long stopTime = System.nanoTime();
        System.out.println("Total time taken: "+(stopTime-startTime));
    }

    /**
     * Method that finds the tours for a specific set of warehouses.
     * 
     * Calls method in TourFinder object to run algorithm.
     * @param warehouses Warehouse set.
     * @param profit_per_unit Profit from selling one unit of this type of good.
     */
    private void findTours(WarehouseContainer warehouses, int profit_per_unit){
        CityContainer delivery_cities = new CityContainer();
        int total_delivery_count = 0;
        for(int i=0; i<cities.size(); i++){
            int city_delivery_count = cont.getCustomerCount(cities.get(i),new Item(warehouses.get(0).getItem()));
            if(city_delivery_count>0)
                delivery_cities.add(cities.get(i));
            total_delivery_count += city_delivery_count;
        }
        printTourStats(new TourFinder(citymap,warehouses,delivery_cities).findTours(),warehouses,(total_delivery_count*profit_per_unit));
    }

    /**
     * Method that prints the details and stats for every calculate tour.
     * 
     * Receives a set of tours from TourFinder object.
     * @param tours Tour set
     * @param warehouses Warehouse set to which the tours belong.
     * @param revenue Total revenue for one type of good from this set of tours.
     */
    private void printTourStats(TourContainer tours, WarehouseContainer warehouses, int revenue){
        System.out.println("Item: "+warehouses.get(0).getItem()+"\n");
        int cost = 0;
        for(int i=0; i<tours.size(); i++){
            Tour<Integer> current_tour = tours.get(i);
            Iterator<Path<Integer>> tour_itr = current_tour.iterator();
            System.out.println("Warehouse: "+warehouses.get(i).getCity());
            System.out.println("Tour-");
            System.out.print(warehouses.get(i).getCity());
            while(tour_itr.hasNext()){
                Path<Integer> current_path = tour_itr.next();
                Iterator<Integer> path_itr = current_path.iterator();
                path_itr.next();
                cost += (current_path.getPathCost()*cost_per_distance);
                while(path_itr.hasNext()){
                    System.out.print("->"+path_itr.next());
                }
            }
            System.out.println();
        }
        System.out.println("\nProfit for "+warehouses.get(0).getItem()+": "+(revenue-cost));
        System.out.println();
    }
}
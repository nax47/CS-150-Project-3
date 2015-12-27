/**
 * Runner class.
 * 
 * @author Nakul Talwar
 */
public class Runner
{
    public static final String map_file = "citymap.txt";
    public static final String goods_file = "goods.txt";
    public static final String locations_file = "locations.txt";
    private ExperimentController cntrl;

    /**
     * Default constructor.
     * 
     * @param cost_per_distance Cost per distance unit in the map.
     */
    public Runner(int cost_per_distance)
    {
        cntrl = new ExperimentController(cost_per_distance);
    }

    /**
     * Main method to run program.
     * 
     * @param args One argument input expected. Argument to describe cost per distance.
     */
    public static void main(String[] args){
        Runner runner = new Runner(Integer.parseInt(args[0]));
        runner.run();
    }

    /**
     * Method to perform several read operations and run route algorithm in sequence.
     */
    private void run(){
        readMap();
        readGoods();
        readLocations();
        runSim();
        findRoutes();
    }

    /**
     * Method to read map details from an external file.
     * Calls method in ExperimentController.
     */
    private void readMap(){
        cntrl.setCityMap(new MapReader(map_file).createMap());
    }

    /**
     * Method to read item price details from an external file.
     * Calls methods in ExperimentController.
     */
    private void readGoods(){
        GoodReader rdr = new GoodReader(goods_file);
        rdr.readGoodData();
        cntrl.setBakedProfit(rdr.getBakedProfit());
        cntrl.setMeatProfit(rdr.getMeatProfit());
        cntrl.setDairyProfit(rdr.getDairyProfit());
        cntrl.setFruitProfit(rdr.getFruitProfit());
        cntrl.setVegProfit(rdr.getVegProfit());
        cntrl.setBevProfit(rdr.getBevProfit());
    }

    /**
     * Method to read warehouse location details from an external file.
     * Calls methods in ExperimentController.
     */
    private void readLocations(){
        LocationReader rdr = new LocationReader(locations_file);
        rdr.readLocationData();
        cntrl.setBakedLocations(rdr.getBakedLocations());
        cntrl.setMeatLocations(rdr.getMeatLocations());
        cntrl.setDairyLocations(rdr.getDairyLocations());
        cntrl.setFruitLocations(rdr.getFruitLocations());
        cntrl.setVegLocations(rdr.getVegLocations());
        cntrl.setBevLocations(rdr.getBevLocations());
    }

    /**
     * Method to run simulation that generates customers.
     * Calls method in ExperimentController.
     */
    private void runSim(){
        cntrl.runSim();
    }

    /**
     * Method to run algorithm that calculates routes for each vendor.
     * Calls method in ExperimentController.
     */
    private void findRoutes(){
        cntrl.findRoutes();
    }
}

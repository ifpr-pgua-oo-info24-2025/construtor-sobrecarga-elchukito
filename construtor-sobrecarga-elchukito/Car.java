public class Car
{
    private String model;
    private String plate;
    private String mark;
    private Engine engine;
    private Driver driver;

    public Car(String model, String plate, String mark, String name, int numCNH, String EngineName, String type, int power)
    {
        this.model = model;
        this.plate = plate;
        this.mark = mark;
        this.engine = new Engine(EngineName, type, power);
        this.driver = new Driver(name, numCNH);
    }

    public Car(String model, String plate, String mark, String EngineName, String type, int power)
    {
        this.model = model;
        this.plate = plate;
        this.mark = mark;
        this.engine = new Engine(EngineName, type, power);
    }

    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public String getPlate() 
    {
        return plate;
    }
    public void setPlate(String plate)
    {
        this.plate = plate;
    }
    public String getMark() 
    {
        return mark;
    }
    public void setMark(String mark)
    {
        this.mark = mark;
    }
    public Engine getEngine() 
    {
        return engine;
    }
    public void setEngine(Engine engine) 
    {
     this.engine = engine;
    }
    public Driver getDriver() 
    {
        return driver;
    }
    public void setDriver(Driver driver) 
    {
        this.driver = driver;
    }

    public String toString()
    {
        if (driver != null)
        {
            return "\nMark: " + this.mark +
                   "\nModel: " + this.model +
                   "\nPlate: " + this.plate +
                   "\nDriver name: " + this.driver.getName() +
                   "\nDriver numCNH: " + this.driver.getNumCNH() +
                   "\nEngine name: " + this.engine.getName() + 
                   "\nEngine type: " + this.engine.getType() + 
                   "\nEngine power: " + this.engine.getPower();
        }
        else
        {
            return "\nMark: " + this.mark +
                   "\nModel: " + this.model +
                   "\nPlate: " + this.plate +
                   "\nEngine name: " + this.engine.getName() + 
                   "\nEngine type: " + this.engine.getType() + 
                   "\nEngine power: " + this.engine.getPower();
        }
    }
}
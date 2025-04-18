public class Engine
{
    private String name;
    private String type;
    private int power;

    public Engine(String name, String type, int power)
    {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getPower() 
    {
        return power;
    }
    public void setPower(int power) 
    {
        this.power = power;
    }
    public String getType() 
    {
        return type;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String toString()
    {
        return  "\nEngine name: " + this.name + 
                "\nEngine type: " + this.type + 
                "\nEngine power: " + this.power;
    }
}
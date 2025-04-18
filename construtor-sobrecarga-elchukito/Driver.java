public class Driver
{
    private String name;
    private int numCNH;

    public Driver(String name, int numCNH)
    {
        this.name = name;
        this.numCNH = numCNH;
    }
    
    public String getName() 
    {
        return name;
    }
    public void setName(String name) 
    {
        this.name = name;
    }
    public int getNumCNH() 
    {
        return numCNH;
    }
    public void setNumCNH(int numCNH) 
    {
        this.numCNH = numCNH;
    }

    public String toString()
    {
        return  "\nDriver name: " + this.name + 
                "\nDriver CNH: " + this.numCNH;
    }
}
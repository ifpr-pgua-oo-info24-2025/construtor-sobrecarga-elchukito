public class Main
{
    public static void main(String[] args)
    {
        Driver driver1 = new Driver("Sergio Moro", 123456789);
        Engine engine1 = new Engine("Carvao", 1200);
        Car car1 = new Car("Eater of roads", "jfd0-7069", "volquis vagen", engine1.getType(), engine1.getPower());
    
        System.out.println(car1.toString());
    }
}
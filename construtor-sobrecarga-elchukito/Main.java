import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Integer op=-1;
        Integer numDriver = 0;
        Integer numEngine = 0;
        Integer numCar = 0;
        String opSelect = "NULL";
        ArrayList <Driver> driver = new ArrayList<>();
        ArrayList <Engine> engine = new ArrayList<>();
        ArrayList <Car> car = new ArrayList<>();

        while (op != 4)
        {
            do
            {
                System.out.println("------Garagem-do-Sergio------");
                System.out.println("\tOque deseja gerenciar:\n");
                System.out.println("1- Motorista");
                System.out.println("2- Motor");
                System.out.println("3- Carro");
                System.out.println("4- Sair");
                System.out.print("* ");

                op = scan.nextInt();
            } while (op <= 0 || op > 4);

            switch(op)
            {
                case 1 : opSelect = "Motorista"; break;
                case 2 : opSelect = "Motor" ; break;
                case 3 : opSelect = "Carro"; break;
            }

            if (op != 4)
            {
                do
                {
                    System.out.println("------Menu-de-" + opSelect +"------");
                    System.out.println("\tOque deseja fazer:\n");
                    System.out.println("1- Adicionar");
                    System.out.println("2- Alterar");
                    System.out.println("3- Voltar");
                    System.out.print("* ");

                    op = scan.nextInt();
                } while (op <= 0 || op > 3);

                if (op == 1)
                {
                    if (opSelect == "Motorista")
                    {
                        System.out.println("----Menu-Adicionar-Motorista----");
                        System.out.print("\nNome: ");
                        scan.nextLine();
                        String name = scan.nextLine();
                        System.out.print("\n\nNumero da CNH: ");
                        int numCNH = scan.nextInt();

                        driver.add(new Driver(name, numCNH));
                        numDriver++;
                    }
                    else if (opSelect == "Motor")
                    {
                        System.out.println("-----Menu-Adicionar-Motor-----");
                        System.out.print("\n\nNome: ");
                        scan.nextLine();
                        String name = scan.nextLine();
                        System.out.print("\nTipo: ");
                        String type = scan.nextLine();
                        System.out.print("\n\nPotencia: ");
                        int power = scan.nextInt();

                        engine.add(new Engine(name, type, power));
                        numEngine++;
                    }
                    else if (opSelect == "Carro")
                    {
                        System.out.println("-----Menu-Adicionar-Carro-----");
                        System.out.print("\nModelo: ");
                        scan.nextLine();
                        String model = scan.nextLine();
                        System.out.print("\n\nMarca: ");
                        String mark = scan.nextLine();
                        System.out.print("\n\nPlaca: ");
                        String plate = scan.nextLine();

                        System.out.println("Qual motor pertence ao carro:");
                        for( int i=0; i < numEngine; i++)
                        {
                            System.out.println( (i+1) + "- " + engine.get(i).getName());
                        }

                        System.out.print("* ");
                        int _engine = (scan.nextInt() - 1);

                        System.out.println("A qual motorista o carro pertence:");
                        for( int i=0; i < numDriver; i++)
                        {
                            System.out.println( (i+1) + "- " + driver.get(i).getName());
                        }
                        System.out.println( (numDriver+1) + "- Nao possui");
                        System.out.print("* ");
                        int _driver = (scan.nextInt() - 1);
                        
                        // adiciona carro com driver
                        if (_driver != numDriver+1)
                        {
                            car.add(new Car(model, plate, mark, driver.get(_driver).getName(), driver.get(_driver).getNumCNH(), 
                            engine.get(_engine).getName(), engine.get(_engine).getType(), engine.get(_engine).getPower()));
                        }
                        // adiciona sem driver
                        else
                        {
                            car.add(new Car(model, plate, mark, 
                            engine.get(_engine).getName(), engine.get(_engine).getType(), engine.get(_engine).getPower()));
                        }
                        numCar++;
                    }
                    else
                    {
                        System.out.println("\n\t* Erro bizonho de opSelect *");
                        return;
                    }
                }
                else if (op == 2)
                {
                    // alterar
                }
                else
                {

                }
            }
            else
            {
                
            }
        }

        for( int i=0; i < numDriver; i++)
        {
            System.out.println("nome[" + i + "]: " + driver.get(i).getName());
        }

        for( int i=0; i < numEngine; i++)
        {
            System.out.println("motor[" + i + "]: " + engine.get(i).getName());
        }

        System.out.println("car[" + 0 + "]: " + car.get(0).toString());
        

        /*Engine[] engine = new Engine[2];
        engine[1] = new Engine("Carvao", 1200);
        Car[] car = new Car[2];
        car[1] = new Car(scan.nextLine(), scan.nextLine(), scan.nextLine(), engine[1].getType(), engine[1].getPower());
    
        System.out.println(car[1].toString());*/

        scan.close();
    }
}
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Integer op=-1;
        Integer op2=-1;
        Integer numDriver = 0;
        Integer numEngine = 0;
        Integer numCar = 0;
        String opSelect = "NULL";
        ArrayList <Driver> driver = new ArrayList<>();
        ArrayList <Engine> engine = new ArrayList<>();
        ArrayList <Car> car = new ArrayList<>();

        while (op != 0)
        {
            do
            {
                System.out.println("------Garagem-do-Sergio------");
                System.out.println("\tOque deseja gerenciar:\n");
                System.out.println("1- Motorista");
                System.out.println("2- Motor");
                System.out.println("3- Carro");
                System.out.println("0- Sair");
                System.out.print("* ");

                op = scan.nextInt();
            } while (op < 0 || op > 3);

            switch(op)
            {
                case 1 : opSelect = "Motorista"; break;
                case 2 : opSelect = "Motor" ; break;
                case 3 : opSelect = "Carro"; break;
            }
            
            if (op != 0)
            {
                do
                {
                    do
                    {
                        System.out.println("------Menu-de-" + opSelect +"------");
                        System.out.println("\tOque deseja fazer:\n");
                        System.out.println("1- Adicionar");
                        System.out.println("2- Alterar");
                        System.out.println("3- Exibir dados");
                        System.out.println("0- Voltar");
                        System.out.print("* ");

                        op2 = scan.nextInt();
                    } while (op2 < 0 || op2 > 3);

                    
                    // adicionar
                    if (op2 == 1)
                    {
                        if (opSelect == "Motorista")
                        {
                            System.out.println("------Adicionar-Motorista------");
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
                            System.out.println("--------Adicionar-Motor--------");
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
                            System.out.println("--------Adicionar-Carro--------");
                            System.out.print("\nModelo: ");
                            scan.nextLine();
                            String model = scan.nextLine();
                            System.out.print("\n\nMarca: ");
                            String mark = scan.nextLine();
                            System.out.print("\n\nPlaca: ");
                            String plate = scan.nextLine();

                            int _engine;
                            int _driver;

                            do
                            {
                                
                                System.out.println("Qual motor pertence ao carro:");
                                for( int i=0; i < numEngine; i++)
                                {
                                    System.out.println( (i+1) + "- " + engine.get(i).getName());
                                }
                                System.out.print("* ");
                                _engine = (scan.nextInt());
                            } while (_engine <= 0 || _engine > numEngine);


                            do
                            {
                                System.out.println("A qual motorista o carro pertence:");
                                for( int i=0; i < numDriver; i++)
                                {
                                    System.out.println( (i+1) + "- " + driver.get(i).getName());
                                }
                                System.out.println( (numDriver+1) + "- Nao possui");
                                System.out.print("* ");
                                _driver = (scan.nextInt());
                                
                            } while (_driver <= 0 || _driver > numDriver+1);
                            
                            // adiciona carro com driver
                            if (_driver != numDriver+1)
                            {
                                car.add(new Car(model, plate, mark, driver.get((_driver-1)).getName(), 
                                driver.get((_driver-1)).getNumCNH(), engine.get((_engine-1)).getName(), 
                                engine.get((_engine-1)).getType(), engine.get((_engine-1)).getPower()));
                            }
                            // adiciona sem driver
                            else
                            {
                                car.add(new Car(model, plate, mark, engine.get((_engine-1)).getName(), 
                                engine.get((_engine-1)).getType(), engine.get((_engine-1)).getPower()));
                            }
                            numCar++;
                        }
                        else
                        {
                            System.out.println("\n\t* Erro bizonho de opSelect *");
                            return;
                        }
                    }
                    // alterar
                    else if (op2 == 2)
                    {
                        if (opSelect == "Motorista")
                        {
                            do
                            {
                                do
                                {
                                    System.out.println("-------Alterar-Motorista-------");
                                    System.out.println("Quem deseja alterar:");
                                    
                                    for( int i=0; i < numDriver; i++)
                                    {
                                        System.out.println((i+1) + "- " + driver.get(i).getName());
                                    }

                                    System.out.println("0- Voltar");

                                    System.out.print("* ");
                                    op2 = scan.nextInt();
                                } while (op2 < 0 || op2 > numDriver);

                                if (op2 != 0)
                                {
                                    do
                                    {
                                        System.out.println("-------Alterar-Motorista-------");
                                        System.out.println("O que deseja alterar:");
                                        System.out.println("1- Nome");
                                        System.out.println("2- Numero da CNH");
                                        System.out.println("0- Voltar");

                                        System.out.print("* ");
                                        op = scan.nextInt();
                                    } while (op < 0 || op > 2);
                                }
                                else
                                {
                                    op2 = -1;
                                    op = -1;
                                }
                            } while (op == 0);

                            if (op == 1)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Novo nome: ");
                                scan.nextLine();
                                String name = scan.nextLine();

                                driver.get(op2-1).setName(name);
                            }
                            else if (op == 2)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Novo numero de CNH: ");
                                scan.nextLine();
                                int numCNH = scan.nextInt();

                                driver.get(op2-1).setNumCNH(numCNH);
                            }
                        }
                        else if (opSelect == "Motor")
                        {
                            do
                            {
                                do
                                {
                                    System.out.println("---------Alterar-Motor---------");
                                    System.out.println("Qual deseja alterar:");
                                    
                                    for( int i=0; i < numEngine; i++)
                                    {
                                        System.out.println((i+1) + "- " + engine.get(i).getName());
                                    }

                                    System.out.println("0- Voltar");

                                    System.out.print("* ");
                                    op2 = scan.nextInt();
                                } while (op2 < 0 || op2 > numEngine);

                                if (op2 != 0)
                                {
                                    do
                                    {
                                        System.out.println("---------Alterar-Motor---------");
                                        System.out.println("O que deseja alterar:");
                                        System.out.println("1- Nome");
                                        System.out.println("2- Tipo");
                                        System.out.println("3- Potencia");
                                        System.out.println("0- Voltar");

                                        System.out.print("* ");
                                        op = scan.nextInt();
                                    } while (op < 0 || op > 3);
                                }
                                else
                                {
                                    op2 = -1;
                                    op = -1;
                                }
                            } while (op == 0);

                            if (op == 1)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Novo nome: ");
                                scan.nextLine();
                                String name = scan.nextLine();

                                engine.get(op2-1).setName(name);
                            }
                            else if (op == 2)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Novo tipo: ");
                                scan.nextLine();
                                String type = scan.nextLine();

                                engine.get(op2-1).setType(type);
                            }
                            else if (op == 3)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Nova potencia: ");
                                scan.nextLine();
                                int power = scan.nextInt();

                                engine.get(op2-1).setPower(power);
                            }
                        }
                        else if (opSelect == "Carro")
                        {
                            do
                            {
                                do
                                {
                                    System.out.println("---------Alterar-Carro---------");
                                    System.out.println("Qual deseja alterar:");
                                    
                                    for( int i=0; i < numCar; i++)
                                    {
                                        System.out.println((i+1) + "- " + car.get(i).getPlate());
                                    }

                                    System.out.println("0- Voltar");

                                    System.out.print("* ");
                                    op2 = scan.nextInt();
                                } while (op2 < 0 || op2 > numCar);

                                if (op2 != 0)
                                {
                                    do
                                    {
                                        System.out.println("---------Alterar-Carro---------");
                                        System.out.println("O que deseja alterar:");
                                        System.out.println("1- Modelo");
                                        System.out.println("2- Marca");
                                        System.out.println("3- Placa");
                                        System.out.println("4- Motor");
                                        System.out.println("5- Motorista");
                                        System.out.println("0- Voltar");

                                        System.out.print("* ");
                                        op = scan.nextInt();
                                    } while (op < 0 || op > 5);
                                }
                                else
                                {
                                    op2 = -1;
                                    op = -1;
                                }
                            } while (op == 0);

                            if (op == 1)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Novo modelo: ");
                                scan.nextLine();
                                String model = scan.nextLine();

                                car.get(op2-1).setModel(model);
                            }
                            else if (op == 2)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Nova marca: ");
                                scan.nextLine();
                                String mark = scan.nextLine();

                                car.get(op2-1).setMark(mark);
                            }
                            else if (op == 3)
                            {
                                System.out.println("--------------------------------");
                                System.out.print("Nova placa: ");
                                scan.nextLine();
                                String plate = scan.nextLine();

                                car.get(op2-1).setPlate(plate);
                            }
                            else if (op == 4)
                            {
                                int _engine;

                                do
                                {
                                    System.out.println("--------------------------------");
                                    System.out.println("Novo motor: ");
                                    
                                    for( int i=0; i < numEngine; i++)
                                    {
                                        System.out.println((i+1) + "- " + engine.get(i).getName());
                                    }
                                    System.out.print("* ");
                                    _engine = scan.nextInt();
                                } while (_engine <= 0 || _engine > numEngine);

                                car.get(op2-1).setEngine(engine.get((_engine-1)));
                            }
                            else if (op == 5)
                            {
                                int _driver;

                                do
                                {
                                    System.out.println("--------------------------------");
                                    System.out.println("Novo motorista: ");
                                    
                                    for( int i=0; i < numDriver; i++)
                                    {
                                        System.out.println((i+1) + "- " + driver.get(i).getName());
                                    }
                                    System.out.println((numDriver+1) + "- Nao possui");

                                    System.out.print("* ");
                                    _driver = scan.nextInt();
                                } while (_driver <= 0 || _driver > numDriver+1);

                                if (_driver != (numDriver+1))
                                {
                                    car.get(op2-1).setDriver(driver.get((_driver-1)));
                                }
                                else
                                {
                                    car.get(op2-1).setDriver(null);
                                }
                            }
                        }
                        
                    }
                    else if (op2 == 3)
                    {
                        if (opSelect == "Motorista")
                        {
                            for( int i=0; i < numDriver; i++)
                            {
                                System.out.println("\n--------------------------------\n");
                                System.out.println("\t* Motorista " + (i+1) + "*");
                                System.out.println(driver.get(i).toString());
                            }
                            System.out.println("\n--------------------------------\n");
                        }
                        else if (opSelect == "Motor")
                        {
                            for( int i=0; i < numEngine; i++)
                            {
                                System.out.println("\n--------------------------------\n");
                                System.out.println("\t* Motor " + (i+1) + "*");
                                System.out.println(engine.get(i).toString());
                            }
                            System.out.println("\n--------------------------------\n");
                        }
                        else if (opSelect == "Carro")
                        {
                            for( int i=0; i < numCar; i++)
                            {
                                System.out.println("\n--------------------------------\n");
                                System.out.println("\t* Carro " + (i+1) + "*");
                                System.out.println(car.get(i).toString());
                            }
                            System.out.println("\n--------------------------------\n");
                        }
                    }
                    else
                    {

                    }

                }while (op2 != 0);
                
            }
            else
            {
                return;
            }

        }

        scan.close();
    }
}
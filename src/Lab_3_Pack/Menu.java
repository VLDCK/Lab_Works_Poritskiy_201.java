package Lab_3_Pack;

import java.util.Scanner;
import java.util.Vector;

public class Menu {

    public static void menuParking()
    {
        Scanner in = new Scanner(System.in);
        int numOfTask=0;
        int carIDl;
        String nameFind;
        Journal journal = new Journal();

        PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
        PrivateAuto auto1 = new PrivateAuto(9947700,"Tesla","Vasiliy",15);
        PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

        Vector<Record> recordVector =new Vector<Record>(10);
        recordVector.add( new Record(auto0));
        recordVector.add( new Record(auto1));
        recordVector.add( new Record(auto2));



        while (numOfTask!=6){
        System.out.println( "1 - Подсчет и выдача счета владельцу\t\t 3 - Создание отчета (сортировка по машине или по владельцу)\n"  +
                "2 - Получение списка всех машин на стоянке\t 4 - Отчет по конкретной машине или владельцу\n" +
                "5 - Журнал вьездов-выездов за период времени 6 - Выход из программы\n");

        System.out.println("Quantity of cars: " + recordVector.size());

        System.out.println("\nEnter the number of the function");
        numOfTask=in.nextInt();



        switch (numOfTask)
        {
            case 1: {
                System.out.println("Enter number");
                carIDl=in.nextInt();

                for(var i: recordVector)
                {
                    if(i.number==carIDl)
                        System.out.println(journal.reportForOwner(i));
                }

                break;
            }
            case 2: {
                journal.carList(recordVector);
                break;
            }
            case 3: {
                System.out.println("Sort by cars or owners?\n 1 - Cars \t 2 - Owners");
                numOfTask=in.nextInt();
                journal.sortByAutoOrOwner(numOfTask,recordVector);
                break;
            }
            case 4 :{
                System.out.println("Report by cars or owners?\n 1 - Cars \t 2 - Owners");
                numOfTask=in.nextInt();


                if(numOfTask ==1)
                {
                    System.out.println("Enter number");
                    carIDl=in.nextInt();
                    for(var i: recordVector)
                    {
                        if(i.number==carIDl)
                            journal.repByAuto(i);
                    }

                }
                else{

                    nameFind = in.nextLine();

                    for(Record i: recordVector)
                    {
                        if(i.personName==nameFind)
                            System.out.println(journal.reportByOwner(i));
                    }}
            break;
            }
            case 5: {
                Parking parking = new Parking();
                System.out.println("Enter number of the car");
                carIDl=in.nextInt();
                parking.setQuantityOfEE(5);
                for(var i: recordVector)
                {
                    if(i.number==carIDl)
                        System.out.println(parking.quantityOfEE(i));
                }

            }
        }}
    }
}

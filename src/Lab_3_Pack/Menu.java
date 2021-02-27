package Lab_3_Pack;

import java.util.Scanner;
import java.util.Vector;

public class Menu {

    public static void menuParking()
    {
        Scanner in = new Scanner(System.in);
        int numOfTask;
        int carIDl;

        Vector<Record> journalVector = new Vector<>(10);
        Vector<PrivateAuto> autoVector = new Vector<>(10);
        Vector<AutoOwner> ownerVector = new Vector<>(10);


        System.out.println( "1 - Подсчет и выдача счета владельцу\t\t 3 - Создание отчета (сортировка по машине или по владельцу)\n"  +
                "2 - Получение списка всех машин на стоянке\t 4 - Отчет по конкретной машине или владельцу\n" +
                "5 - Журнал вьездов-выездов за период времени 6 - Выход из программы\n");

        System.out.println("Quantity of cars: " + journalVector.size());

        System.out.println("\nEnter the number of the function");
        numOfTask=in.nextInt();



        switch (numOfTask)
        {
            case 1: {
                System.out.println("Enter ID");
                carIDl=in.nextInt()-1;

                try {
                    if(journalVector.elementAt(carIDl).personName==journalVector.elementAt(carIDl+1).personName)
                        System.out.println(journalVector.elementAt(carIDl).reportForOwner(journalVector.elementAt(carIDl),journalVector.elementAt(carIDl+1)));
                    else
                        System.out.println(journalVector.elementAt(carIDl).reportForOwner(journalVector.elementAt(carIDl),journalVector.elementAt(carIDl-1)));
                }
                catch (Exception e)
                {
                    System.out.println(journalVector.elementAt(carIDl).reportForOwner(journalVector.elementAt(carIDl)));
                }
                break;
            }
            case 2: {
                Record.carList(journalVector);
                break;
            }
            case 3: {
                System.out.println("Sort by cars or owners?\n 1 - Cars \t 2 - Owners");
                numOfTask=in.nextInt();
                journalVector.elementAt(0).sortByAutoOrOwner(numOfTask,journalVector);

            }
            case 4 :{
                System.out.println("Report by cars or owners?\n 1 - Cars \t 2 - Owners");
                numOfTask=in.nextInt();

                System.out.println("Enter ID");
                carIDl=in.nextInt()-1;
                if(numOfTask !=1){

                    try {
                        if (journalVector.elementAt(carIDl).personName == journalVector.elementAt(carIDl + 1).personName)
                            journalVector.firstElement().reportByOwner( journalVector.elementAt(carIDl), journalVector.elementAt(carIDl + 1));
                        else
                            journalVector.firstElement().reportByOwner( journalVector.elementAt(carIDl), journalVector.elementAt(carIDl - 1));
                    }
                    catch(Exception e)
                    {
                        journalVector.firstElement().reportByOwner(journalVector.elementAt(carIDl));
                    }
                }
                else{
                    journalVector.firstElement().repByAuto(journalVector.elementAt(carIDl));
                }

            }
            case 5: {
                Parking parking = new Parking();
                System.out.println("Enter ID of the car");
                carIDl=in.nextInt()-1;
                parking.setQuantityOfEE(5);
                System.out.println(journalVector.firstElement().quantityOfEE(journalVector.elementAt(carIDl),parking.getQuantityOfEE()));
            }

        }
    }
}

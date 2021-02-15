package Lab_3_Pack;

import java.util.Scanner;
import java.util.Vector;

public class MainClass {

    /*
    Створіть наступну модель: є приватна автостоянка.
    Кожного місяця, водіям, які паркували авто, видається рахунок
    за використання послугами стоянки.

    Можлива ситуація коли 1 власник має декілько авто.
    Повинна бути можливість отримати список всіх авто які є на
    стоянці зараз, та журнал обліку виїздів-заїздів за період.
    Потрібна можливість формування звіту по окремому авто або власнику.
    Звіт можливо сортувати або по авто, або по власникам.

    */

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        Vector<Journal> journalVector = new Vector<>(10);
        Vector<PrivateAuto> autoVector = new Vector<>(10);
        Vector<AutoOwner> ownerVector = new Vector<>(10);

        autoVector.add(new PrivateAuto(1,"Tesla",14));
        autoVector.add(new PrivateAuto(2,"BMW",34));
        autoVector.add(new PrivateAuto(3,"Audi",5));
        autoVector.add(new PrivateAuto(4,"Porsche",16));

        ownerVector.add(new AutoOwner("Vitaliy Led",2));
        ownerVector.add(new AutoOwner("Sergey Us",1));
        ownerVector.add(new AutoOwner("Vitaliy Nalivkin",1));

        journalVector.add(new Journal(ownerVector.elementAt(0),autoVector.elementAt(0)));
        journalVector.add(new Journal(ownerVector.elementAt(0),autoVector.elementAt(1)));
        journalVector.add(new Journal(ownerVector.elementAt(1),autoVector.elementAt(2)));
        journalVector.add(new Journal(ownerVector.elementAt(2),autoVector.elementAt(3)));


        int numOfTask;

        System.out.println( "1 - Подсчет и выдача счета владельцу\t\t 3 - Создание отчета (сортировка по машине или по владельцу)\n"  +
                            "2 - Получение списка всех машин на стоянке\t 4 - Отчет по конкретной машине или владельцу\n" +
                            "5 - Журнал вьездов-выездов за период времени 6 - Выход из программы");

        System.out.println("Введите номер выбранной функции");
        numOfTask=in.nextInt();


        switch (numOfTask)
        {
            case 1: {
                System.out.println("Enter ID");
                int carIDl=in.nextInt()-1;

                try {
                    if(journalVector.elementAt(carIDl).personName==journalVector.elementAt(carIDl+1).personName)
                        System.out.println(journalVector.elementAt(carIDl).countingForOwner(journalVector.elementAt(carIDl),journalVector.elementAt(carIDl+1)));
                    else
                        System.out.println(journalVector.elementAt(carIDl).countingForOwner(journalVector.elementAt(carIDl),journalVector.elementAt(carIDl-1)));
                }
                catch (Exception e)
                {
                    System.out.println(journalVector.elementAt(carIDl).countingForOwner(journalVector.elementAt(carIDl)));
                }

                break;
            }
            case 2: {
                Journal.carList(journalVector);
                break;
            }
            case 3: {
                System.out.println("Sort by cars or owners?\n 1 - Cars \t 2 - Owners");
                numOfTask=in.nextInt();
               Journal.SortByAutoOrOwner(numOfTask,journalVector);

            }
        }


        

    }
}

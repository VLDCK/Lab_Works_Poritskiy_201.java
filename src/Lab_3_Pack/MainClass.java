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
        Journal journal = new Journal();

        Vector<PrivateAuto> car = new Vector<>(10);
        car.add(new PrivateAuto("Tesla Model X","Vitaliy" ,1,12));
        car.add(new PrivateAuto("Audi A7","Ivan" ,2,4));
        car.add(new PrivateAuto("BMW X5","Artem" ,3,19));

        Vector<AutoOwner> autoOwnerVector = new Vector<>(10);
        autoOwnerVector.add(new AutoOwner("Vitaliy Led",1,car.elementAt(1)));

        int numOfTask;

        System.out.println( "1 - Подсчет и выдача счета владельцу\t\t 3 - Создание отчета (сортировка по машине или по владельцу)\n"  +
                            "2 - Получение списка всех машин на стоянке\t 4 - Отчет по конкретной машине или владельцу\n" +
                            "5 - Журнал вьездов-выездов за период времени 6 - Выход из программы");

        System.out.println("Введите номер выбранной функции");
        numOfTask=in.nextInt();


        switch (numOfTask)
        {
            case 1: {
                System.out.println( journal.countingForOwner(car.elementAt(0),
                                    autoOwnerVector.elementAt(0)));
            }
        }


        

    }
}

package Lab_3_Pack;


import java.util.Arrays;
import java.util.TreeSet;
import java.util.Set;

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


       Set carArr = new TreeSet();

       carArr.add(new PrivateAuto("Tesla Model X","I'm",1));
       carArr.add(new PrivateAuto("Audi","Vitaliy",2));
       carArr.add(new PrivateAuto("BMW","Ivan",3));


       for (Object i:carArr) {
            System.out.println(i);
       }
        

    }
}

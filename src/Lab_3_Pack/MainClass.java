package Lab_3_Pack;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Vector;

public class MainClass {

    //static LocalDate date;
    /*
    *Модель: автостоянка.
    *Водіям, що паркували авто можно видавати рахунок за використання
    *
    *Можлива ситуація коли 1 власник має декілько авто.
    *Повинна бути можливість отримати список всіх авто які є на
    *стоянці зараз, та журнал обліку виїздів-заїздів за період.
    *Потрібна можливість формування звіту по окремому авто або власнику.
    *Звіт можливо сортувати або по авто, або по власникам.
    */
    public static void main(String[] args) {


        Journal j = new Journal();
        Parking parking = new Parking();

        PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
        PrivateAuto auto1 = new PrivateAuto(9947700,"Susuki","Vitaliy",15);
        PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

        Record record1 = new Record(auto0);
        Record record2 = new Record(auto1);
        Record record3 = new Record(auto2);


        j.carEnter(record1);
        System.out.println(j.getInfoQuantityOfEnterExit(record1));

    
}}

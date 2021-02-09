package Lab_2_Pack._Lab_2_main;


import Lab_2_Pack._Lab_2_5_Task.*;

import java.util.Scanner;

public class Lab_2 {

    Scanner in = new Scanner(System.in);
    //1 Задание
    //Створіть метод, який приймає параметр значення enum для місяця, а
    // повертає кількість днів в місяці. Лютий завжди – 28.
    public enum Month
    {
        January(31),
        February(28),
        March(31),
        April(30),
        May(31),
        June(30),
        July(31),
        August(30),
        September(31),
        October(30),
        November(31),
        December(30);

        private int num;
        Month(int num)
        {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }
    public int countOfMonth(Month e)
    {
        int count=e.getNum();
        return count;
    }

    //2 Задание
    /*Продемонструйте у коді 2 способи обробки виключних ситуацій у методі
    (з try-catch и  throws), а також особливості використання блока finally.
    У якості виключення, що обробляється, оберіть будь яке =checked= виключення.*/
    public void exeptionVar_1()
    {
        int divByZero=0;
        try
        {
            divByZero = 10/0;
        }
        catch (Exception e)
        {
            System.out.println("Exception: divide by zero");

        }
        finally {
            System.out.println("It's finally block result = " +divByZero);
        }
    }
    public void exeptionVar_2()
    {
        System.out.println("Enter num 3-7");

        int num = in.nextInt();
        try{
            if(7<num || num<3)
            {
                throw new Exception("The number is unsuitable");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void exeptionVar_3() throws ArithmeticException
    {
        int div=0;
        try
        {
            div=10/div;
            throw new Exception("Exception throw");

        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    public static void main(String[] args) {

        Lab_2 t = new Lab_2();

        System.out.println(t.countOfMonth(Month.February));
        System.out.println("\nКонец 1 задания\n");

        t.exeptionVar_1();
        t.exeptionVar_2();

        t.exeptionVar_3();

        System.out.println("\nКонец 2 задания\n");

        Gun gun_1 = new Gun();
        gun_1.setName("FN MAG");
        gun_1.setClassOfWeapon("Machine Gun");
        gun_1.showAbstr();

        Gun gun_2 = new Gun();
        gun_2.automaticShooting(gun_1.getName());

        gun_2.secInterfaceFun(gun_2);

        System.out.println("\nКонец 3 задания\n");


        gun_1.retIntrFun();


        Shooting shooting = new Gun();

        System.out.println("\nКонец 4 задания\n");


        /*Створіть інтерфейс Спортивний з методами, притаманними
        будь якій спортивній діяльності з будь-якого виду спорту.
        Імплементуйте його в класах Волейболіст, Футболіст, Борець, Боксер.
        Створіть масив типу даних Спортивний та заповніть його різними спортсменами.
        Продемонструйте поліморфізм, пробігши по масиву в foreach. */

        SportInterface[] sportInterface = new SportInterface[4];

        sportInterface[0] = new FootballPlayer();
        sportInterface[1] = new VolleyballPlayer();
        sportInterface[2] = new Boxer();
        sportInterface[3] = new Fighter();



        for(var i :sportInterface)
        {
            System.out.println(i.nameOfEvent()+"|| Is it team sport? " +i.isTeamSport());
        }
        System.out.println("\nКонец 5 задания\n");




    }
}

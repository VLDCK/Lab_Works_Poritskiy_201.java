package Lab_3_Pack;

//Класс журнал имеет следующие фнкции:
    // 1 - Подсчет и выдача счета владельцу;
    // 2 - Получение списка всех машин на стоянке;
    // 3 - Создание отчета (сортировка по машине или по владельцу);
    // 4 - Отчет по конкретной машине или владельцу;
    // 5 - Журнал вьездов-выездов за период времени;

import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.Vector;

public class Journal implements Comparator<Journal> ,Comparable<Journal>{

    int ID;
    String modalName;
    String personName;
    int carQuantity;
    int parkingDays;


    Journal(AutoOwner autoOwner, PrivateAuto privateAuto)
    {
        this.modalName = privateAuto.getModelOfCar();
        this.personName = autoOwner.getName_Surname();
        this.carQuantity = autoOwner.getCarQuantity();
        this.ID = privateAuto.getKeyNumber();
        this.parkingDays = privateAuto.getParkingDays();

    }

    @Override
    public String toString() {
        return  "ID: " +ID +  "  --  | Model Of The Car: " + modalName + "   --   | Owner: " + personName + "\n";
    }


    //Функции отвечающие за подсчет и выдачу чека владельуц(больше 1 машины)
    public int compareOwner(Journal o1, Journal o2)
    {
        int a=1;
        if(o1.personName==o2.personName)
            a= o1.parkingDays + o2.parkingDays;
        return a;
    }
    public int countingForTwoMoreCars(Journal journal1,Journal journal2)
    {
        Parking parking = new Parking();
        return parking.paymentForParking(compareOwner(journal1,journal2));
    }
    public String countingForOwner(Journal journal1,Journal journal2)
    {
        Parking parking = new Parking();
        return this.carQuantity<2?
                "Owner "+ this.personName+ ". Payment for "+ this.modalName+
                " is equal "+ parking.paymentForParking(this.parkingDays):
                "Owner "+ this.personName+ ". Payment for "+ this.carQuantity+" is equal " + countingForTwoMoreCars(journal1,journal2);
    }
    public String countingForOwner(Journal journal1){
        Parking parking = new Parking();

        return "Owner "+ this.personName+ ". Payment for "+ this.modalName+
                        " is equal "+ parking.paymentForParking(this.parkingDays);
    }


    public static void carList(Vector<Journal> vecJ){
        for(Object o : vecJ)
        {
            System.out.println(o.toString());
        }
    }


    @Override
    public int compare(Journal o1, Journal o2) {
        int a=1;

        return a;
    }

    @Override
    public int compareTo(Journal o1)
    {
        return o1.personName.compareTo(this.personName);
    }

    public int compareToSecond(Journal o1)
    {
        return this.modalName.compareTo(o1.modalName);
    }

    public static void SortByAutoOrOwner(int numOfSort,Vector<Journal> vecJ)
    {
        if(numOfSort ==1)
            vecJ.sort(Journal::compareToSecond);

        else vecJ.sort(Journal::compareTo);

        carList(vecJ);



    }

}

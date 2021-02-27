package Lab_3_Pack;

//Класс журнал имеет следующие фнкции:
    // 1 - Подсчет и выдача счета владельцу;
    // 2 - Получение списка всех машин на стоянке;
    // 3 - Создание отчета (сортировка по машине или по владельцу);
    // 4 - Отчет по конкретной машине или владельцу;
    // 5 - Журнал вьездов-выездов за период времени;

import java.util.Vector;

public class Record implements Comparable<Record>{

    int ID;
    String modalName;
    String personName;
    int carQuantity;
    int parkingDays;
    Parking parking;
    Journal record;

    Record(AutoOwner autoOwner, PrivateAuto privateAuto)
    {
        this.modalName = privateAuto.getModelOfCar();
        this.personName = autoOwner.getName_Surname();
        this.carQuantity = autoOwner.getCarQuantity();
        this.ID = privateAuto.getKeyNumber();
        this.parkingDays = privateAuto.getParkingDays();

    }


    @Override
    public String toString() {
        return  "ID: " +ID +  "  --  | Model Of The Car: " + modalName + "   --   | Owner: " + personName+" " ;
    }

    public static void carList(Vector<Record> vecJ){
        for(Object o : vecJ)
        {
            System.out.println(o.toString()+'\n');
        }
    }

    private static void reportList(Vector<Record> vecJ){
        Parking parking = new Parking();
        for(Record o : vecJ)
        {
            System.out.println(o.toString() +".  --  Parking fee is "+parking.paymentForParking(o.parkingDays));
        }
    }

    public int sumParcDays(Record o1, Record o2){
        return o1.parkingDays + o2.parkingDays;
    }

    private  int countingForTwoMoreCars(Record journal1, Record journal2) {
        return parking.paymentForParking(sumParcDays(journal1,journal2));
    }


    public String reportForOwner(Record journal1, Record journal2) {

        return this.carQuantity<2?
                "Owner "+ this.personName+ ". Payment for "+ this.modalName+
                " is equal "+ parking.paymentForParking(this.parkingDays):
                "Owner "+ this.personName+ ". Payment for "+ this.carQuantity+" cars is equal " + countingForTwoMoreCars(journal1,journal2);
    }

    public String reportForOwner(Record journal1){

        return "Owner "+ this.personName+ ". Payment for "+ this.modalName+
                        " is equal "+ parking.paymentForParking(this.parkingDays);
    }


    @Override
    public int compareTo(Record o1)
    {
        return o1.personName.compareTo(this.personName);
    }

    public int compareToSecond(Record o1)
    {
        return this.modalName.compareTo(o1.modalName);
    }

    public void sortByAutoOrOwner(int numOfSort,Vector<Record> vecJ)
    {
        if(numOfSort ==1)
            vecJ.sort(Record::compareToSecond);

        else vecJ.sort(Record::compareTo);
        reportList(vecJ);

    }


    public void reportByOwner(Record journal1)
    {
        System.out.println("Name : "+ journal1.personName+" owns "+
                journal1.modalName+"  --  Parking fee is: "  +parking.paymentForParking(journal1.parkingDays));
    }
    public void reportByOwner(Record journal1, Record journal2)
    {
        if(journal1.carQuantity>1){
           System.out.println("Name : "+ journal1.personName+" owns "+journal1.carQuantity+
                   " cars--  Parking fee is: "  +countingForTwoMoreCars(journal1,journal2));}
        else
            {
                reportByOwner(journal1);
            }

    }
    public void repByAuto(Record journal1){

        System.out.println("Name of car model: " + journal1.modalName + "  --  Owner is "+ journal1.personName +
                "  --  Parking fee is: " + parking.paymentForParking(journal1.parkingDays));
    }

    public String quantityOfEE(Record journal, int days){

        return  parking.inOutCar(days);
    }
}

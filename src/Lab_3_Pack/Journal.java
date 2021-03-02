package Lab_3_Pack;

import java.util.Iterator;
import java.util.Vector;

//Класс журнал имеет следующие фнкции:
// 1 - Подсчет и выдача счета владельцу;
// 2 - Получение списка всех машин на стоянке;
// 3 - Создание отчета (сортировка по машине или по владельцу);
// 4 - Отчет по конкретной машине или владельцу;
// 5 - Журнал вьездов-выездов за период времени;
public class Journal {

    Record record ;
    Parking parking = new Parking();


    public int countingForTwoMoreCars(Record journal1, Record journal2) {
        return parking.paymentForParking(sumParcDays(journal1,journal2));
    }

    public int sumParcDays(Record record1, Record record2){
        return record1.parkingDays + record2.parkingDays;
    }

    public String reportForOwner(Record record){

        return "Owner "+ record.personName+ ". Payment for "+record.modalName+
                " is equal "+ parking.paymentForParking(record.getParkingDays());
    }

    public void carList(Vector<Record> records){
        for(Record o : records)
        {
            System.out.println(o.toString()+'\n');
        }
    }

    private void reportList(Vector<Record> vecJ){

        for(Record o : vecJ)
        {
            System.out.println(o.toString() +".  --  Parking fee is "+ parking.paymentForParking(o.parkingDays));
        }
    }
    public void sortByAutoOrOwner(int numOfSort,Vector<Record> records)
    {
        if(numOfSort ==1)
            records.sort(Record::compareToSecond);

        else records.sort(Record::compareTo);

        reportList(records);

    }

    public String reportByOwner(Record journal1)
    {
        return "Name : "+ journal1.personName+" owns "+
                journal1.modalName+"  --  Parking fee is: "  +parking.paymentForParking(journal1.getParkingDays());
    }
    public String reportByOwner(Record journal1, Record journal2)
    {

        return journal1.carQuantity>1?
                "Name : "+ journal1.personName+" owns "+journal1.carQuantity+
                " cars--  Parking fee is: "  +countingForTwoMoreCars(journal1,journal2):
                reportByOwner(journal1);


    }

    public void repByAuto(Record record){

        System.out.println("Name of car model: " + record.getModalName() + "  --  Owner is "+ record.getPersonName() +
                "  --  Parking fee is: " + parking.paymentForParking(record.getParkingDays()));
    }




}


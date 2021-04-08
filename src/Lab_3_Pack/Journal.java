package Lab_3_Pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

//Класс журнал имеет следующие фнкции:
// 1 - Подсчет и выдача счета владельцу;
// 2 - Получение списка всех машин на стоянке;
// 3 - Создание отчета (сортировка по машине или по владельцу);
// 4 - Отчет по конкретной машине или владельцу;
// 5 - Журнал вьездов-выездов за период времени;
public class Journal {

    public Parking parking = new Parking();
    ArrayList<Record> records;

    public void addRecord(Record record)
    {
        this.records.add(record);
    }

    public int countingForTwoMoreCars(Record record1, Record record2) {
        return parking.paymentForParking(parking.sumParkingDays(record1,record2));
    }


    public String reportForOwner(Record record){

        return "Owner "+ record.privateAuto.getOwner()+ ". Payment for "+record.privateAuto.getParkingDays()+
                " day/s is equal "+ parking.paymentForParking(record.privateAuto.getParkingDays());
    }

    public void carList(ArrayList<Record> records){
        for(Record o : records)
        {
            System.out.println(o.toString()+'\n');
        }
    }

    public ArrayList<Record> sortByAuto(ArrayList<Record> records)
    {
        records.sort(Record::compareTo);
        return records;
    }

    public ArrayList<Record> sortByOwner(ArrayList<Record> records)
    {
        records.sort(Record::compareToSecond);
       return records;
    }

    private void reportPayList(ArrayList<Record> vecJ){

        for(Record o : vecJ)
        {
            System.out.println(o.toString() +".  --  Parking fee is "
                                            + parking.paymentForParking(o.privateAuto.getParkingDays()));
        }
    }

    public String reportByOwner(Record record1)
    {
        return "Name : "+ record1.privateAuto.getOwner()+" owns "+
                record1.privateAuto.getModelOfCar()+" --  Parking fee is: "
                + parking.paymentForParking(record1.privateAuto.getParkingDays());
    }
    public String reportByAuto(Record record){

       return "Name of car model: " + record.privateAuto.getModelOfCar() +
              "  --  Owner is "+ record.privateAuto.getOwner() +
              "  --  Parking fee is: " + parking.paymentForParking(record.privateAuto.getParkingDays());
    }

    public void carEnter(Record record)
    {
        record.setDateOfEnter();
        record.setQuantityOfEnter();
    }

    public void carExit(Record record)
    {
        record.getDateOfEnter();
        record.setQuantityOfExit();
    }

    public String getInfoQuantityOfEnterExit(Record record)
    {
        return record.toString()+ "Enter the parking at " + record.getDateOfEnter()+
               "\nLeft the parking in "+ record.getQuantityOfExit() + " times"+
               "\nEntered the parking lot " +record.getQuantityOfEnter() +" times";

    }

}


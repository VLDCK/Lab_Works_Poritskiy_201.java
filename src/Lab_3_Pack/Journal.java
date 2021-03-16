package Lab_3_Pack;

import java.util.ArrayList;


//Класс журнал имеет следующие фнкции:
// 1 - Подсчет и выдача счета владельцу;
// 2 - Получение списка всех машин на стоянке;
// 3 - Создание отчета (сортировка по машине или по владельцу);
// 4 - Отчет по конкретной машине или владельцу;
// 5 - Журнал вьездов-выездов за период времени;
public class Journal {


    public Parking parking = new Parking();


    public int countingForTwoMoreCars(Record record1, Record record2) {
        return parking.paymentForParking(sumParcDays(record1,record2));
    }

    public int sumParcDays(Record record1, Record record2){
        return record1.getParkingDays() + record2.getParkingDays();
    }

    public String reportForOwner(Record record){

        return "Owner "+ record.personName+ ". Payment for "+record.modalName+
                " is equal "+ parking.paymentForParking(record.getParkingDays());
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
            System.out.println(o.toString() +".  --  Parking fee is "+ parking.paymentForParking(o.parkingDays));
        }
    }

    public String reportByOwner(Record record1)
    {
        return "Name : "+ record1.getPersonName()+" owns "+
                record1.getModalName()+" --  Parking fee is: "  + parking.paymentForParking(record1.getParkingDays());
    }

    public String repByAuto(Record record){

       return "Name of car model: " + record.getModalName() + "  --  Owner is "+ record.getPersonName() +
                "  --  Parking fee is: " + parking.paymentForParking(record.getParkingDays());
    }




}


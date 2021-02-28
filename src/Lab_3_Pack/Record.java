package Lab_3_Pack;



import java.util.Vector;

public class Record implements Comparable<Record>{

    int number;
    String modalName;
    String personName;
    int carQuantity;
    int parkingDays;
    Parking parking=new Parking();
    Journal journal;

    Record(PrivateAuto privateAuto)
    {
        this.number = privateAuto.getNumber();
        this.modalName = privateAuto.getModelOfCar();
        this.personName = privateAuto.getOwner();
        this.parkingDays = privateAuto.getParkingDays();
    }

    public void setCarQuantity(int carQuantity) {
        this.carQuantity = carQuantity;
    }
    public int getParkingDays() {
        return parkingDays;
    }
    public String getModalName() {
        return modalName;
    }
    public int getNumber() {
        return number;
    }
    public String getPersonName() {
        return personName;
    }


    @Override
    public String toString() {
        return  "Number: " +this.number +  "  --  | Model Of The Car: " + this.modalName + "   --   | Owner: " + this.personName+" " ;
    }


    public int sumParcDays(Record record1, Record record2){
        return record1.parkingDays + record2.parkingDays;
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







}

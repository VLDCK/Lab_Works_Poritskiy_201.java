package Lab_3_Pack;



import java.util.Comparator;
import java.util.Vector;

public class Record implements Comparable<Record>, Comparator{

    int number;
    String modalName;
    String personName;
    int carQuantity;
    int parkingDays;

    public Record(PrivateAuto privateAuto)
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
        return  "Number: " + this.number +  "  --  | Model Of The Car: " + this.modalName + "   --   | Owner: " + this.personName+" " ;
    }



    @Override
    public int compareTo(Record o1)
    {
        return this.getModalName().compareTo(o1.getModalName());
    }

    public int compareToSecond(Record o1)
    {

        return this.getPersonName().compareTo(o1.getPersonName());
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

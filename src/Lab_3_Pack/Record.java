package Lab_3_Pack;

import java.time.LocalDate;
import java.util.*;

public class Record implements Comparable<Record>{


    int quantityOfExit = 0;
    int quantityOfEnter = 0;
    Parking parking = new Parking();
    public PrivateAuto privateAuto;
    LocalDate dateOfEnter;

    public Record(PrivateAuto privateAuto) {
        this.privateAuto = privateAuto;
        this.setQuantityOfEnter();
    }

    public void setQuantityOfEnter() {
        quantityOfEnter =+ 1;
    }

    public int getQuantityOfEnter() {
        return quantityOfEnter;
    }

    public void setQuantityOfExit() {
        quantityOfExit =+ 1;
    }

    public int getQuantityOfExit() {
        return quantityOfExit;
    }

    public void setDateOfEnter(){
        dateOfEnter = LocalDate.now();
    }

    public String getDateOfEnter()
    {
        return dateOfEnter.toString();
    }

    @Override
    public String toString() {
        return  "Number: " + privateAuto.getNumber() +  "  --  | Model Of The Car: " + privateAuto.getModelOfCar()
                + "   --   | Owner: " + privateAuto.getOwner() ;
    }

    @Override
    public int compareTo(Record o1)
    {
        return privateAuto.getModelOfCar().compareTo(o1.privateAuto.getModelOfCar());
    }

    public int compareToSecond(Record o1)
    {
        return privateAuto.getOwner().compareTo(o1.privateAuto.getOwner());
    }

    public int SecondCompare(Record o1, Record o2) {
        return o1.privateAuto.getOwner().compareTo(o2.privateAuto.getOwner());

    }
}

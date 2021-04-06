package Lab_4_Pack;

import java.util.Arrays;
import java.util.Date;
import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class JournalTest {


    Journal j = new Journal();
    Parking parking = new Parking();

    PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
    PrivateAuto auto1 = new PrivateAuto(9947700,"Suzuki","Vitaliy",15);
    PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

    Record record1 = new Record(auto0);
    Record record2 = new Record(auto1);
    Record record3 = new Record(auto2);


    @Test
    void countingForTwoMoreCars() {

        int actual = parking.paymentForParking(parking.sumParkingDays(record1,record2));
        int expected = 30*(10+15);
        assertEquals(expected,actual);

    }

    @Test
    void reportForOwner() {

        String expected = "Owner Sergey. Payment for 10 day/s is equal 300";

        String actual = j.reportForOwner(record1);
        assertEquals(expected,actual);
    }

    @Test
    void sortByAuto() {
        ArrayList<Record> expected = new ArrayList<Record>(3);
        expected.add(record1);
        expected.add(record3);
        expected.add(record2);

        ArrayList<Record> ac = new ArrayList<Record>(3);
        ac.add(record1);
        ac.add(record2);
        ac.add(record3);

        ArrayList<Record> actual = j.sortByAuto(ac);
        assertEquals(expected,actual);
    }

    @Test
    void sortByOwner() {

        ArrayList<Record> expected = new ArrayList<Record>(3);
        expected.add(record1);
        expected.add(record3);
        expected.add(record2);

        ArrayList<Record> ac = new ArrayList<Record>(3);
        ac.add(record1);
        ac.add(record2);
        ac.add(record3);

        ArrayList<Record> actual = j.sortByAuto(ac);
        assertEquals(expected,actual);

    }

    @Test
    void reportByOwner() {
        String actual = j.reportByOwner(record1);
        String expected = "Name : Sergey owns Audi --  Parking fee is: "
                + parking.paymentForParking(record1.privateAuto.getParkingDays());

        assertEquals(expected,actual);

    }

    @Test
    void reportByAuto() {

        String actual = j.reportByAuto(record1);
        String expected = "Name of car model: Audi  --  Owner is Sergey  --  Parking fee is: "
                + parking.paymentForParking(record1.privateAuto.getParkingDays());

        assertEquals(expected,actual);

    }

    @Test
    void getInfoQuantityOfEnterExit() {
        record1.setDateOfEnter();

        String expected = record1.toString()+ "Enter the parking at " + record1.getDateOfEnter()+
                "\nLeft the parking in "+ record1.getQuantityOfExit() + " times"+
                "\nEntered the parking lot " +record1.getQuantityOfEnter() +" times";

        String actual = j.getInfoQuantityOfEnterExit(record1);

        assertEquals(expected,actual);

    }
}
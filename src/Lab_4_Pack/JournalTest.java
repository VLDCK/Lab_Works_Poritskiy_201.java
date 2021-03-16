package Lab_4_Pack;

import Lab_3_Pack.*;
import Lab_3_Pack.Record;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;

class JournalTest {

    Journal j = new Journal();
    PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
    PrivateAuto auto1 = new PrivateAuto(9947700,"Susuki","Vitaliy",15);
    PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

    Record record1 = new Record(auto0);
    Record record2 = new Record(auto1);
    Record record3 = new Record(auto2);

    Parking parking = new Parking();


    @Test
    void countingForTwoMoreCars() {

        int expected = 30*(10+15);
        int actual = j.countingForTwoMoreCars(record1,record2);
        assertEquals(expected,actual);
    }

    @Test
    void sumParcDays() {


        int actual = j.sumParcDays(record1,record2);

        int expected = record1.getParkingDays()+record2.getParkingDays();
        assertEquals(expected,actual);

    }

    @Test
    void reportForOwner() {
        String actual = "Owner "+ record3.getPersonName()+ ". Payment for "+record3.getModalName()+
                " is equal "+ parking.paymentForParking(record3.getParkingDays());

        String expected ="Owner Vasiliy. Payment for BMW is equal "+ parking.paymentForParking(record3.getParkingDays());

        assertEquals(expected,actual);
    }

    @Test
    void sortByAuto() {

        ArrayList<Record> expected = new ArrayList<Record>(3);

        expected.add(record1);
        expected.add(record3);
        expected.add(record2);

        ArrayList<Record> actual = new ArrayList<Record>(3);
        actual.add(record1);
        actual.add(record2);
        actual.add(record3);

        j.sortByAuto(actual);

        assertEquals(expected,actual);
    }

    @Test
    void sortByOwner() {

        ArrayList<Record> expected = new ArrayList<Record>(3);

        expected.add(record1);
        expected.add(record3);
        expected.add(record2);

        ArrayList<Record> actual = new ArrayList<Record>(3);
        actual.add(record1);
        actual.add(record2);
        actual.add(record3);

        j.sortByOwner(actual);
        assertEquals(expected,actual);
    }
    @Test
    void reportByOwner() {

        String actual = j.reportByOwner(record1);
        String expected = "Name : Sergey owns Audi --  Parking fee is: "
                + parking.paymentForParking(record1.getParkingDays());

        assertEquals(expected,actual);
    }

    @Test
    void repByAuto() {
        String actual = j.repByAuto(record1);
        String expected = "Name of car model: Audi  --  Owner is Sergey  --  Parking fee is: "
                + parking.paymentForParking(record1.getParkingDays());

        assertEquals(expected,actual);
    }
}
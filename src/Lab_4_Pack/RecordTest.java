package Lab_4_Pack;

import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;

import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

    Journal j = new Journal();
    Parking parking = new Parking();
    PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
    PrivateAuto auto1 = new PrivateAuto(9947700,"Suzuki","Vitaliy",15);
    PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

    Record record1 = new Record(auto0);
    Record record2 = new Record(auto1);
    Record record3 = new Record(auto2);


    @Test
    void getQuantityOfEnter() {

    record2.setQuantityOfEnter();
    int expected = 1;
    int actual = record2.getQuantityOfEnter();
    assertEquals(expected,actual);
    }


    @Test
    void getQuantityOfExit() {
        record2.setQuantityOfExit();
        int expected = 1;
        int actual = record2.getQuantityOfExit();
        assertEquals(expected,actual);

    }

    @Test
    void getDateOfEnter()
    {
        j.carEnter(record2);

        String expected ="2021-04-06";
        String actual = record2.getDateOfEnter();
        assertEquals(expected,actual);
    }
    @Test
    void testToString() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void compareToSecond() {
    }
}
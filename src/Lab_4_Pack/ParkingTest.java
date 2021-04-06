package Lab_4_Pack;

import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import java.util.Date;
import org.junit.jupiter.api.Test;

import static Lab_3_Pack.TimeOnTheParking.payForDay;
import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    Journal j = new Journal();
    Parking parking =new Parking();

    PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
    PrivateAuto auto1 = new PrivateAuto(9947700,"Suzuki","Vitaliy",15);
    PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

    Record record1 = new Record(auto0);
    Record record2 = new Record(auto1);
    Record record3 = new Record(auto2);



    @Test
    void sumParkingDays() {

        int expected = record1.privateAuto.getParkingDays()+
                record2.privateAuto.getParkingDays();

        int actual = parking.sumParkingDays(record1,record2);
        assertEquals(expected,actual);

    }
    @Test
    void sumOfExitEnter() {
        int expected = record1.getQuantityOfEnter()+record1.getQuantityOfExit();
        int actual = parking.sumOfExitEnter(record1);
        assertEquals(expected,actual);
    }

    @Test
    void inOutCar() {

        String expected = "For 7 day(s) the car was leaving the parking lot "+ parking.sumOfExitEnter(record1)+ " times\n";
        String actual = parking.inOutCar(record3);
    }

    @Test
    void paymentForParking() {
        int expected =  payForDay * record1.privateAuto.getParkingDays();
        int actual = parking.paymentForParking(record1.privateAuto.getParkingDays());
        assertEquals(expected,actual);
    }
}
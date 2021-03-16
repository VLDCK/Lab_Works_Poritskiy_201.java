package Lab_4_Pack;

import Lab_3_Pack.*;
import Lab_3_Pack.Record;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {

    Journal j = new Journal();
    Parking parking =new Parking();

    PrivateAuto auto0 = new PrivateAuto(1910120,"Audi","Sergey",10);
    PrivateAuto auto1 = new PrivateAuto(9947700,"Susuki","Vitaliy",15);
    PrivateAuto auto2 = new PrivateAuto(7481014,"BMW","Vasiliy",7);

    Record record1 = new Record(auto0);
    Record record2 = new Record(auto1);
    Record record3 = new Record(auto2);

    @Test
    void quantityOfEE() {

        parking.setQuantityOfEE(5);
        String expected = "Number: 1910120  --  | Model Of The Car: Audi   --   | Owner: Sergey " +
                          "For 10 day(s) the car was leaving the parking lot "
                        + parking.getQuantityOfEE()+" times\n" ;
        String actual = record1.toString() + parking.inOutCar(record1);
        assertEquals(expected,actual);

    }
    @Test
    void inOutCar() {

        parking.setQuantityOfEE(6);
        String expected = "For 10 day(s) the car was leaving the parking lot "
                        + parking.getQuantityOfEE()+" times\n";
        String actual = parking.inOutCar(record1);
    }

    @Test
    void paymentForParking() {

        int actual=parking.paymentForParking(record1.getParkingDays());
        int expected = 300;
        assertEquals(expected,actual);
    }
  }

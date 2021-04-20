package Lab_4_Pack;

import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

import static Lab_3_Pack.TimeOnTheParking.payForDay;
import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    Journal j = new Journal();
    Parking parking =new Parking();


    @Parameterized.Parameters
    public static Stream<Record> recordsParameters()
    {
        return Stream.of(
                new Record(new PrivateAuto(1910120,"Audi","Sergey",10)),
                new Record(new PrivateAuto(9947700,"Suzuki","Vitaliy",15)),
                new Record(new PrivateAuto(7481014,"BMW","Vasiliy",7)));
    }
    @Parameterized.Parameters
    private static Stream<Arguments> arguments() {
        return Stream.of(
                Arguments.of(
                        new Record(new PrivateAuto(1910120, "Audi", "Sergey", 10)),
                        new Record(new PrivateAuto(9947700, "Suzuki", "Vitaliy", 15)),
                        new Record(new PrivateAuto(7481014, "BMW", "Vasiliy", 7))
                ));
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void sumParkingDays(Record record_1, Record record_2) {

        int expected = record_1.privateAuto.getParkingDays()+
                record_2.privateAuto.getParkingDays();

        int actual = parking.sumParkingDays(record_1,record_2);
        assertEquals(expected,actual);

    }
    @ParameterizedTest
    @MethodSource("arguments")
    void sumOfExitEnter(Record record) {
        int expected = record.getQuantityOfEnter()+record.getQuantityOfExit();
        int actual = parking.sumOfExitEnter(record);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void inOutCar(Record record) {

        String expected = "For " +record.privateAuto.getParkingDays()+" day(s) the car was leaving the parking lot "
                + parking.sumOfExitEnter(record)+" times\n";
        String actual = parking.inOutCar(record);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void paymentForParking(Record record) {
        int expected =  payForDay * record.privateAuto.getParkingDays();
        int actual = parking.paymentForParking(record.privateAuto.getParkingDays());
        assertEquals(expected,actual);
    }
}
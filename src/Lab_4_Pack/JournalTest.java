package Lab_4_Pack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;
import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JournalTest {

    Journal j = new Journal();
    Parking parking = new Parking();

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
                        new Record(new PrivateAuto(1910120, "Audi", "Bob", 10)),
                        new Record(new PrivateAuto(9947700, "Suzuki", "Don", 15)),
                        new Record(new PrivateAuto(7481014, "BMW", "John", 7))
                ));
    }


    @ParameterizedTest
    @MethodSource("arguments")
    void countingForTwoMoreCars(Record record_1, Record record_2) {
        int actual = parking.paymentForParking(parking.sumParkingDays(record_1,record_2));
        int expected = 30*(record_1.privateAuto.getParkingDays()+
                record_2.privateAuto.getParkingDays());
        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void reportForOwner(Record record) {

       String expected = "Owner "+record.privateAuto.getOwner() +
               ". Payment for "+ record.privateAuto.getParkingDays()+" day/s is equal "+
               parking.paymentForParking(record.privateAuto.getParkingDays());

       String actual = j.reportForOwner(record);

       assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("arguments")
    void sortByAuto(Record record_1, Record record_2, Record record_3 ) {
        ArrayList<Record> expected = new ArrayList<Record>(3);
        expected.add(record_1);
        expected.add(record_3);
        expected.add(record_2);

        ArrayList<Record> records = new ArrayList<Record>(3);
        records.add(record_1);
        records.add(record_3);
        records.add(record_2);

        ArrayList<Record> actual = j.sortByAuto(records);
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("arguments")
    void sortByOwner(Record record_1, Record record_2, Record record_3) {

        ArrayList<Record> expected = new ArrayList<Record>(3);
        expected.add(record_1);
        expected.add(record_2);
        expected.add(record_3);


        ArrayList<Record> ac = new ArrayList<Record>(3);
        ac.add(record_1);
        ac.add(record_2);
        ac.add(record_3);

        ArrayList<Record> actual = j.sortByOwner(ac);
        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void reportByOwner(Record record) {
        String actual = j.reportByOwner(record);
        String expected = "Name : "+ record.privateAuto.getOwner()+" owns "+
                record.privateAuto.getModelOfCar()+" --  Parking fee is: "
                + parking.paymentForParking(record.privateAuto.getParkingDays());

        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void reportByAuto(Record record) {

        String actual = j.reportByAuto(record);
        String expected = "Name of car model: " + record.privateAuto.getModelOfCar() +
                "  --  Owner is "+ record.privateAuto.getOwner() +
                "  --  Parking fee is: " + parking.paymentForParking(record.privateAuto.getParkingDays());

        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void getInfoQuantityOfEnterExit(Record record) {
        record.setDateOfEnter();

        String expected = record.toString()+ "Enter the parking at " + record.getDateOfEnter()+
                "\nLeft the parking in "+ record.getQuantityOfExit() + " times"+
                "\nEntered the parking lot " +record.getQuantityOfEnter() +" times";

        String actual = j.getInfoQuantityOfEnterExit(record);

        assertEquals(expected,actual);

    }
}
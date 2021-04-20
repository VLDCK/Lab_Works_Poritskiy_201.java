package Lab_4_Pack;

import Lab_3_Pack.Journal;
import Lab_3_Pack.Parking;
import Lab_3_Pack.PrivateAuto;
import Lab_3_Pack.Record;

import java.time.LocalDate;
import java.util.Date;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assertions.*;

class RecordTest {

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

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void getQuantityOfEnter(Record record) {
    record.setQuantityOfEnter();
    int expected = 1;

    int actual = record.getQuantityOfEnter();
    assertEquals(expected,actual);
    }


    @ParameterizedTest
    @MethodSource("recordsParameters")
    void getQuantityOfExit(Record record) {
        record.setQuantityOfExit();
        int expected = 1;
        int actual = record.getQuantityOfExit();
        assertEquals(expected,actual);

    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void getDateOfEnter(Record record)
    {
        j.carEnter(record);

        String expected = LocalDate.now().toString();
        String actual = record.getDateOfEnter().toString();
        assertEquals(expected,actual);
    }

    @ParameterizedTest
    @MethodSource("recordsParameters")
    void testToString(Record record) {
        String expected = "Number: " + record.privateAuto.getNumber() +
                "  --  | Model Of The Car: " +record.privateAuto.getModelOfCar() +
                "   --   | Owner: " + record.privateAuto.getOwner();
        String actual = record.toString();

        assertEquals(expected,actual);
    }


}
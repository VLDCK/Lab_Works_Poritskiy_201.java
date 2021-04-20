package Lab_3_Pack;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class Parking implements TimeOnTheParking{



    public int sumOfExitEnter(Record record)
    {
        return record.getQuantityOfExit()+record.getQuantityOfEnter();
    }

    public int sumParkingDays(Record record1, Record record2){
        return record1.privateAuto.getParkingDays() + record2.privateAuto.getParkingDays();
    }

    @Override
    public String inOutCar(Record record)
    {
        return "For " +record.privateAuto.getParkingDays()+" day(s) the car was leaving the parking lot "
                + this.sumOfExitEnter(record)+" times\n";
    }
    @Override
    public int paymentForParking(int dataCount)
    {
        return payForDay * dataCount;
    }


}

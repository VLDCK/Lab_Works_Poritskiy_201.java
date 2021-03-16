package Lab_3_Pack;

public class Parking implements TimeOnTheParking{

    int quantityOfEE ;

    public void setQuantityOfEE(int quantityOfEE) {
        this.quantityOfEE = quantityOfEE;
    }

    public int getQuantityOfEE() {
        return quantityOfEE;
    }

    public String quantityOfEE(Record record){
        return record.toString() + inOutCar(record);
    }

    @Override
    public String inOutCar(Record record)
    {
        return "For " +record.getParkingDays()+" day(s) the car was leaving the parking lot "+ this.quantityOfEE+" times\n";
    }
    @Override
    public int paymentForParking(int dataCount)
    {
        return payForDay * dataCount;
    }


}

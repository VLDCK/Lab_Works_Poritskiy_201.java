package Lab_3_Pack;

public class Parking implements TimeOnTheParking{

    int quantityOfEE;
    Record journal;


    public void setQuantityOfEE(int quantityOfEE) {
        this.quantityOfEE = quantityOfEE;
    }
    public int getQuantityOfEE() {
        return quantityOfEE;
    }


    @Override
    public String inOutCar(int days)
    {
        return journal.toString()+"For " +days+" day(s) the car was leaving the parking lot "+ this.quantityOfEE+" times";
    }

    public int paymentForParking(int dataCount)
    {
        return payForDay * dataCount;
    }


}

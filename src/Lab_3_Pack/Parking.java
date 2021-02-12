package Lab_3_Pack;

public class Parking implements TimeOnTheParking{

    private int dataCount;
    private int paymentSum;


    public int getPaymentSum() {
        return paymentSum;
    }

    @Override
    public int quantityOfDays(int firstDay,int lastDay)
    {
        return this.dataCount = lastDay-firstDay;
    }

    @Override
    public int paymentForParking(int dataCount)
    {
        return paymentSum = payForDay * dataCount;
    }


}

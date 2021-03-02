package Lab_3_Pack;

public abstract class Car {

    private String modelOfCar;
    private int number;

    public Car(int number, String modelOfCar)
    {
        this.modelOfCar = modelOfCar;
        this.number = number;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }
    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Car number" +this.number+ "\tModelOfCar:" + this.modelOfCar + ' ';
    }
}

class PrivateAuto extends Car
{

    int parkingDays;
    String owner;

    public int getParkingDays() {
        return parkingDays;
    }
    public String getOwner() {
        return owner;
    }

    public PrivateAuto(int number, String modelOfCar, String owner, int parkingDays) {
        super(number,modelOfCar);
        this.owner = owner;
        this.parkingDays = parkingDays;
    }

    @Override
    public String toString() {
        return super.toString()+ "\towner: " + owner + "\tparkingDays: " + parkingDays ;
    }


}

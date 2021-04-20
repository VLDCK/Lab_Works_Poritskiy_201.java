package Lab_3_Pack;

public class PrivateAuto extends Car {

    int parkingDays;
    String owner;

    public int getParkingDays() {
        return parkingDays;
    }

    public String getOwner() {
        return owner;
    }


    public PrivateAuto(int number, String modelOfCar, String owner, int parkingDays) {
        super(number, modelOfCar);
        this.owner = owner;
        this.parkingDays = parkingDays;
    }

    @Override
    public String toString() {
        return super.toString() + "\tOwner: " + owner + "\tParking Days: " + parkingDays;
    }


}

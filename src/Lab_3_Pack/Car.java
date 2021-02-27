package Lab_3_Pack;

public abstract class Car {


    private String modelOfCar;
    private String ownerOfCar;
    private int number;

    public Car(int keyNumber, String modelOfCar)
    {
        this.modelOfCar = modelOfCar;
        this.number = keyNumber;
    };
    public Car(int keyNumber,String modelOfCar,String ownerOfCar)
    {
        this.modelOfCar = modelOfCar;
        this.ownerOfCar = ownerOfCar;
        this.number = keyNumber;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }
    public void setOwnerOfCar(String ownerOfCar) {
        this.ownerOfCar = ownerOfCar;
    }
    public void setKeyNumber(int keyNumber) {
        this.number = keyNumber;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }
    public String getOwnerOfCar() {
        return ownerOfCar;
    }
    public int getKeyNumber() {
        return number;
    }


    @Override
    public String toString() {
        return "Car " +
                "ModelOfCar='" + modelOfCar + '\'' +
                ", OwnerOfCar='" + ownerOfCar + '\'' +
                "\n";
    }
}

class PrivateAuto extends Car
{

    int parkingDays;

    public int getParkingDays() {
        return parkingDays;
    }

    public PrivateAuto(int keyNumber,String modelOfCar, String ownerOfCar, int parkingDays) {
        super(keyNumber,modelOfCar, ownerOfCar);
        this.parkingDays = parkingDays;
    }

    public PrivateAuto(int keyNumber,String modelOfCar, int parkingDays)
    {
        super(keyNumber,modelOfCar);
        this.parkingDays = parkingDays;
    }


}

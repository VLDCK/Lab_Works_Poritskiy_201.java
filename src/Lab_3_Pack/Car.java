package Lab_3_Pack;



// Абстрактный класс, который будет унаследован классом частного автомобиля
    //Описывает ключевые поля необходимые машине (модель, владельца, ID ключ)
public abstract class Car {


    private String modelOfCar;
    private String ownerOfCar;
    private int keyNumber;

    public Car(int keyNumber, String modelOfCar)
    {
        this.modelOfCar = modelOfCar;
        this.keyNumber = keyNumber;
    };
    public Car(int keyNumber,String modelOfCar,String ownerOfCar)
    {
        this.modelOfCar = modelOfCar;
        this.ownerOfCar = ownerOfCar;
        this.keyNumber = keyNumber;
    }

    public void setModelOfCar(String modelOfCar) {
        this.modelOfCar = modelOfCar;
    }
    public void setOwnerOfCar(String ownerOfCar) {
        this.ownerOfCar = ownerOfCar;
    }
    public void setKeyNumber(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public String getModelOfCar() {
        return modelOfCar;
    }
    public String getOwnerOfCar() {
        return ownerOfCar;
    }
    public int getKeyNumber() {
        return keyNumber;
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

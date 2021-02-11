package Lab_3_Pack;



// Абстрактный класс, который будет унаследован классом частного автомобиля
    //Описывает ключевые поля необходимые машине (модель, владельца, ID ключ)
public abstract class Car implements Comparable<Car>{


    private String modelOfCar;
    private String ownerOfCar;
    private int keyNumber;

    public Car(String modelOfCar,String ownerOfCar,int keyNumber)
    {
        this.modelOfCar = modelOfCar;
        this.ownerOfCar = modelOfCar;
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
    public int compareTo(Car car) {
        return this.modelOfCar.compareTo(car.getModelOfCar());
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

    public PrivateAuto(String modelOfCar, String ownerOfCar, int keyNumber) {
        super(modelOfCar, ownerOfCar, keyNumber);
    }
}

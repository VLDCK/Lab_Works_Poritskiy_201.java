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
        return "Car number: " +this.number+ "\tModelOfCar: " + this.modelOfCar ;
    }
}


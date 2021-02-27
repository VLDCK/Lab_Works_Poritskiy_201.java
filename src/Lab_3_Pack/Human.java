package Lab_3_Pack;

public class Human {

    private String name_Surname;
    public int carQuantity;
    public int age;

    Human(String name_Surname, int carQuantity){
        this.name_Surname = name_Surname;
        this.carQuantity = carQuantity;
    }

    Human(String name_Surname, int carQuantity,int age){
        this.name_Surname = name_Surname;
        this.carQuantity = carQuantity;
        this.age=age;
    }

    public String getName_Surname() {
        return name_Surname;
    }
    public int getCarQuantity()
    {
        return carQuantity;
    }

    @Override
    public String toString() {
        return  "Name of owner: " + name_Surname + "\tQuantity of auto: " + carQuantity +'\n';
    }
}

class AutoOwner extends Human{

    AutoOwner(String name_Surname, int carQuantity) {
        super(name_Surname, carQuantity);
    }


    }


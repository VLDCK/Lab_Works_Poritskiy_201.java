package Lab_2_Pack._Lab_2_main;


public abstract class Weapon {

    //3 Задание
    //Створіть тестовий приклад, який демонструє відмінність між інтерфейсами
    //та абстрактними класами за їхніми можливостями.


        private String name;
        private String classOfWeapon;

        public String getName(){return name;}
        public void setName(String newName){this.name=newName;}

        public String getClassOfWeapon(){return classOfWeapon;}
        public void setClassOfWeapon(String newClassOfWeapon){classOfWeapon=newClassOfWeapon;}

        public abstract void showAbstr();

}

 class Gun extends Weapon implements Shooting, SecondInterface
{
    @Override
    public void showAbstr() {

        System.out.println("This is abstract method"
                +"\nName: "+getName()
                +"\nClass of gun: "+ getClassOfWeapon()+'\n' );
    }

    @Override
    public void burstShooting(String name) {
        System.out.println(name +" It's shooting by burst\n");
    }

    @Override
    public void automaticShooting(String name) {
        System.out.println(name +"It's automatic shooting\n");
    }


    @Override
    public void secInterfaceFun(Shooting shooting) {
        System.out.println("I'm second interface method");
        shooting.burstShooting("FN MAG");
    }


    // 4 ЗАДАНИЕ ВОЗВРАЩАЕМОЕ ЗНАЧЕНИЕ
    @Override
    public Shooting retIntrFun() {

        return exitFun();
    }

    @Override
    public Shooting exitFun()
    {
        return null;
    }

}

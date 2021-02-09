package Lab_2_Pack._Lab_2_main;

public interface Shooting {

    void burstShooting(String name);

    void automaticShooting(String name);
}

interface SecondInterface
{
    //4 ЗАДАНИЕ ПАРАМЕТР МЕТОДА
    void secInterfaceFun(Shooting shooting);
    //4 ЗАДАНИЕ ВОЗВРАЩАЕМОЕ ЗНАЧЕНИЕ
    Shooting retIntrFun();

    Shooting exitFun();


}

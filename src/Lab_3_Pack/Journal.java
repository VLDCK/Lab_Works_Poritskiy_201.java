package Lab_3_Pack;

//Класс журнал имеет следующие фнкции:
    // 1 - Подсчет и выдача счета владельцу;
    // 2 - Получение списка всех машин на стоянке;
    // 3 - Создание отчета (сортировка по машине или по владельцу);
    // 4 - Отчет по конкретной машине или владельцу;
    // 5 - Журнал вьездов-выездов за период времени;

public class Journal {

    @Override
    public String toString() {
        return super.toString();
    }

    public String countingForOwner(PrivateAuto privateAuto, AutoOwner autoOwner)
    {
        Parking parking = new Parking();
        return autoOwner.getCarQuantity()<2?
                "Owner "+ autoOwner.getName_Surname()+ ". Payment for "+ privateAuto.getModelOfCar()+
                " is equal "+ parking.paymentForParking(privateAuto.getParkingDays()):

                "";
    }


}

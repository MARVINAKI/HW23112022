import Transport.Car;
import Transport.Transport;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listType = new ArrayList<>();
        Car.CarType passengerCar = new Car.CarType("Легковой автомобиль");
        Car.CarType truck = new Car.CarType("Грузовой автомобиль");
        Car.CarType bus = new Car.CarType("Автобус");

        Car nissan = new Car("Nissan", "Terrano", 2);
        nissan.setCarType(passengerCar);
        Car chevrolet = new Car("Chevrolet", "Cruze", 1.8);
        chevrolet.setCarType(passengerCar);
        Car lada = new Car("LADA", "Priora", 1.6);
        lada.setCarType(passengerCar);
        Car toyota = new Car("Toyota", "RAV4", 2);
        toyota.setCarType(passengerCar);
        Car man = new Car("MAN", "TGS 6x6", 12.4);
        man.setCarType(truck);
        Car volvo = new Car("Volvo", "FE II", 7.2);
        volvo.setCarType(truck);
        Car kamaz = new Car("KAMAZ", "65659", 12);
        kamaz.setCarType(truck);
        Car maz = new Car("MAZ", "5440M9", 12.8);
        maz.setCarType(truck);
        Car nefaz = new Car("Nefaz", "5299", 6.7);
        nefaz.setCarType(bus);
        Car gaz = new Car("GAZ", "A65R33-60", 2.7);
        gaz.setCarType(bus);
        Car volvoBus = new Car("Volvo", "9500", 7.7);
        volvoBus.setCarType(bus);
        Car hyundai = new Car("Hyundai", "Universe", 12.3);
        hyundai.setCarType(bus);


        Driver.DriversLicense categoryB = new Driver.DriversLicense("B");
        Driver.DriversLicense categoryC = new Driver.DriversLicense("C");
        Driver.DriversLicense categoryD = new Driver.DriversLicense("D");

        Driver kostya = new Driver("Иванов Константин Александрович", "да", 13);
        kostya.setDriversLicense(categoryB);
        Driver michael = new Driver("Michael Shumakher", " yes ", 40);
        michael.setDriversLicense(categoryB);
        Driver yurij = new Driver("Иванов Юрий Александрович", "да", 19);
        yurij.setDriversLicense(categoryB);
        Driver kvyat = new Driver("Daniil Kvyat", "yEs", 15);
        kvyat.setDriversLicense(categoryB);

        kostya.drive(nissan);
        /*

        C:\Users\Костя\.jdks\corretto-11.0.16.1\bin\java.exe "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.2\lib\idea_rt.jar=61718:C:\Program Files\JetBrains\IntelliJ IDEA 2022.2.2\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\Костя\IdeaProjects\HW23112022\out\production\HW23112022 Main
        Водитель ИВАНОВ КОНСТАНТИН АЛЕКСАНДРОВИЧ управляет автомобилем terrano (легковой автомобиль) и будет участвоать в заезде
        ИВАНОВ КОНСТАНТИН АЛЕКСАНДРОВИЧ жмет педаль газа
        nissan terrano начинает движение
        ИВАНОВ КОНСТАНТИН АЛЕКСАНДРОВИЧ уверенно двигается вперед
        ИВАНОВ КОНСТАНТИН АЛЕКСАНДРОВИЧ жмет педаль тормоза
        nissan terrano остановка на пит-стоп
        Осмотр легкового автомобиля...
        ИВАНОВ КОНСТАНТИН АЛЕКСАНДРОВИЧ жмет педаль газа
        nissan terrano начинает движение
        Итоги первого круга
        Лучшее время: Не фиксировалось
        Максимальная скорость: Не фиксировалось

        Process finished with exit code 0
        */
    }
}
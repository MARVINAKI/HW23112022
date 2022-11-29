package Transport;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Objects;

public class Car<A extends Driver> extends Transport implements Competing {
    private CarType carType;
    private BodyTypePass bodyTypePass;

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    public enum BodyTypePass {
        SEDAN("Седан"),
        HATCHBACK("Хетчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");


        private final String bodyTypePass;

        // always 'private'
        BodyTypePass(String bodyTypePass) {
            this.bodyTypePass = bodyTypePass;
        }

        public final BodyTypePass findBodyType(String bodyTypePass) {
            for (BodyTypePass type : values()) {
                if (type.getBodyType().equalsIgnoreCase(bodyTypePass)) {
                    return type;
                }
            }
            return null;
        }

        public String getBodyType() {
            return bodyTypePass;
        }
    }

    public static class CarType {
        private String carType;

        public CarType(String carType) {
            this.carType = carType == null || carType.trim().isEmpty() ? null : carType.trim().toLowerCase();
        }

        public final boolean checkPassCar() {
            return getCarType().equalsIgnoreCase("Легковой автомобиль");
        }

        public final boolean checkTruck() {
            return getCarType().equalsIgnoreCase("Грузовой автомобиль");
        }

        public final boolean checkBus() {
            return getCarType().equalsIgnoreCase("Автобус");
        }

        public String getCarType() {
            return carType;
        }

        private void setCarType(String carType) {
            this.carType = carType == null || carType.trim().isEmpty() ? null : carType.trim().toLowerCase();
        }

        @Override
        public String toString() {
            return carType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CarType carType1 = (CarType) o;
            return Objects.equals(carType, carType1.carType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(carType);
        }
    }

    @Override
    public void pitStop() {
        if (carType.checkPassCar()) {
            System.out.println(getBrand() + " " + getModel() + " остановка на пит-стоп");
            System.out.println("Осмотр легкового автомобиля...");
        }
        if (carType.checkTruck()) {
            System.out.println(getBrand() + " " + getModel() + " остановка на пит-стоп");
            System.out.println("Осмотр грузового автомобиля...");
        }
        if (carType.checkBus()) {
            System.out.println(getBrand() + " " + getModel() + " остановка на пит-стоп");
            System.out.println("Осмотр автобуса...");
        }
    }

    @Override
    public void bestLapTime() {
        System.out.println("Не фиксировалось");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Не фиксировалось");
    }

    public final CarType getCarType() {
        return carType;
    }

    public final void setCarType(CarType carType) {
        if (this.carType == null) {
            this.carType = carType;
            this.bodyTypePass = null;
        }
    }

    public final void setCarType(CarType carType, BodyTypePass bodyTypePass) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (this.bodyTypePass == null && getCarType().checkPassCar()) {
            this.bodyTypePass = bodyTypePass;
        }
    }

    @Override
    public String toString() {
        return "Автомобиль{" + getBrand() + "\\" +
                getModel() + "\\" +
                getEngineVolume() + "\\" +
                carType + "\\" +
                bodyTypePass + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car<?> car = (Car<?>) o;
        return carType.equals(car.carType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), carType);
    }
}

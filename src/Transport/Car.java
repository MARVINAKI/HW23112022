package Transport;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Objects;

public class Car<A extends Driver> extends Transport implements Competing {
    private CarType carType;
    private BodyTypePass bodyTypePass;
    private LoadCapacity loadCapacity;
    private PassCapacity passCapacity;

    public Car(String brand, String model, double engineVolume) {
        super(brand, model, engineVolume);
    }

    @Override
    public void printType() {
        System.out.println(getCarType().checkPassCar() ? bodyTypePass : getCarType().checkTruck() ? loadCapacity :
                passCapacity);
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

    public enum LoadCapacity {
        N1("до 3.5 тонн"),
        N2("от 3.5 - до 12 тонн"),
        N3("свыше 12 тонн");

        private final String loadCapacity;

        LoadCapacity(String loadCapacity) {
            this.loadCapacity = loadCapacity;
        }

        public String getLoadCapacity() {
            return loadCapacity;
        }
    }

    public enum PassCapacity {
        VERYSMALL("до 10 мест"),
        SMALL("до 25 мест"),
        MEDIUM("от 25 до 55 мест"),
        BIG("от 55 до 90"),
        VERYBIG("от 90 до 120 мест");

        public final String passCapacity;

        PassCapacity(String passCapacity) {
            this.passCapacity = passCapacity;
        }

        public final PassCapacity findPassCapacity(int passCapacity) {
            if (passCapacity > 0 && passCapacity <= 10) {
                return VERYSMALL;
            } else if (passCapacity <= 25) {
                return SMALL;
            } else if (passCapacity <= 55) {
                return MEDIUM;
            } else if (passCapacity <= 90) {
                return BIG;
            } else if (passCapacity <= 120) {
                return VERYBIG;
            } else {
                return null;
            }
        }

        public final String getPassCapacity() {
            return passCapacity;
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

    public final void setCarType(CarType carType, LoadCapacity loadCapacity) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (this.bodyTypePass == null && getCarType().checkTruck()) {
            this.loadCapacity = loadCapacity;
        }
    }

    public final void setCarType(CarType carType, int capacity) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (capacity != 0 && this.passCapacity == null && getCarType().checkBus()) {
            this.passCapacity = passCapacity.findPassCapacity(Math.abs(capacity));
        }
    }

    public final BodyTypePass getBodyTypePass() {
        return bodyTypePass;
    }

    public final LoadCapacity getLoadCapacity() {
        return loadCapacity;
    }

    public final PassCapacity getPassCapacity() {
        return passCapacity;
    }

    @Override
    public String toString() {
        return "Автомобиль{" + getBrand() + "\\" +
                getModel() + "\\" +
                getEngineVolume() + "\\" +
                carType + "\\" +
                (getCarType().checkPassCar() ? bodyTypePass : getCarType().checkTruck() ? loadCapacity :
                        passCapacity) + "}";
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

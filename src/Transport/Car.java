package Transport;

import java.sql.Driver;
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

        private String getBodyType() {
            return this.bodyTypePass;
        }
    }

    public enum LoadCapacity {
        N1(0, 3.5d),
        N2(3.5d, 12d),
        N3(12d, 100),
        UNDEFINED(0, 0);

        private final double from;
        private final double to;

        LoadCapacity(double from, double to) {
            this.from = from;
            this.to = to;
        }

        public final LoadCapacity checkTruckCap(double loadCapacity) {
            LoadCapacity cap = LoadCapacity.UNDEFINED;
            for (LoadCapacity capacity : LoadCapacity.values()) {
                if (loadCapacity > capacity.getFrom() && loadCapacity <= capacity.getTo()) {
                    return capacity;
                }
            }
            return cap;
        }

        private double getFrom() {
            return from;
        }

        private double getTo() {
            return to;
        }

        private void getLoadCapacity() {

        }
    }

    public enum PassCapacity {
        VERY_SMALL(10),
        SMALL(25),
        MEDIUM(50),
        BIG(80),
        VERY_BIG(120),
        UNDEFINED(0);

        public final int to;

        PassCapacity(int to) {
            this.to = to;
        }

        public final PassCapacity checkCapacityTo(int capacityTo) {
            for (PassCapacity capacity : PassCapacity.values()) {
                if (capacityTo <= capacity.getTo()) {
                    return capacity;
                }
            }
            return UNDEFINED;
        }

        private int getTo() {
            return to;
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
        }
    }

    public final void setCarType(CarType carType, BodyTypePass bodyTypePass) {
        this.carType = this.carType == null ? carType : this.carType;
        this.bodyTypePass = this.bodyTypePass == null && getCarType().checkPassCar() ? bodyTypePass : this.bodyTypePass;
    }

    public final void setCarType(CarType carType, LoadCapacity loadCapacity) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (this.bodyTypePass == null || getLoadCapacity() == LoadCapacity.UNDEFINED && getCarType().checkTruck()) {
            this.loadCapacity = loadCapacity;
        }
    }

    public final void setCarType(CarType carType, double loadCapacity) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (this.carType.checkTruck()) {
            this.loadCapacity = LoadCapacity.UNDEFINED;
            this.loadCapacity = getLoadCapacity() == LoadCapacity.UNDEFINED && carType.checkTruck() ? this.loadCapacity.checkTruckCap(loadCapacity) : this.loadCapacity;
        }
    }

    public final void setCarType(CarType carType, PassCapacity passCapacity) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (this.passCapacity == null || getPassCapacity() == PassCapacity.UNDEFINED && carType.checkBus()) {
            this.passCapacity = passCapacity;
        }

    }

    public final void setCarType(CarType carType, int capacityTo) {
        if (this.carType == null) {
            this.carType = carType;
        }
        if (getPassCapacity() == null || getPassCapacity() == PassCapacity.UNDEFINED && carType.checkBus()) {
            this.passCapacity = PassCapacity.UNDEFINED;
            this.passCapacity = this.passCapacity.checkCapacityTo(capacityTo);
        }
    }

    public final BodyTypePass getBodyTypePass() {
        return this.bodyTypePass;
    }

    public final LoadCapacity getLoadCapacity() {
        return this.loadCapacity;
    }

    public void setLoadCapacity(LoadCapacity loadCapacity) {
        this.loadCapacity = getLoadCapacity() == null ? loadCapacity : null;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = getLoadCapacity() == LoadCapacity.UNDEFINED && carType.checkTruck() ? this.loadCapacity.checkTruckCap(loadCapacity) : this.loadCapacity;
    }

    public final PassCapacity getPassCapacity() {
        return this.passCapacity;
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

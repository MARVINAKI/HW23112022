import Transport.Competing;
import Transport.Transport;
import Transport.Car;

import java.util.Objects;

public class Driver<A extends Car & Competing> {
    private String name;
    private String driverLicense;
    private int experience;
    private DriversLicense driversLicense;

    public Driver(String name, String driverLicense, int experience) {
        setName(name);
        setDriverLicense(driverLicense);
        setExperience(experience);
    }

    public void drive(A car) {
        if (driversLicense.checkCatB() && car.getCarType().checkPassCar()) {
            System.out.print("Водитель " + getName());
            System.out.print(" управляет автомобилем " + car.getModel() + " (" + car.getCarType() + ")");
            System.out.println(" и будет участвоать в заезде");
            startMoving();
            car.startMoving();
            moving();
            stopMoving();
            car.pitStop();
            startMoving();
            car.startMoving();
            System.out.println("Итоги первого круга");
            System.out.print("Лучшее время: ");
            car.bestLapTime();
            System.out.print("Максимальная скорость: ");
            car.maxSpeed();
        }
        if (driversLicense.checkCatC() && car.getCarType().checkTruck()) {
            System.out.print("Водитель " + getName());
            System.out.print(" управляет автомобилем " + car.getModel() + " (" + car.getCarType() + ")");
            System.out.println(" и будет участвоать в заезде");
        }
        if (driversLicense.checkCatD() && car.getCarType().checkBus()) {
            System.out.print("Водитель " + getName());
            System.out.print(" управляет автомобилем " + car.getModel() + " (" + car.getCarType() + ")");
            System.out.println(" и будет участвоать в заезде");
        }

    }

    public static class DriversLicense {
        private String driversLicense;

        public DriversLicense(String driversLicense) {
            setDriversLicense(driversLicense);
        }

        public final String getDriversLicense() {
            return driversLicense;
        }

        public final void setDriversLicense(String driversLicense) {
            this.driversLicense = driversLicense == null || driversLicense.trim().isEmpty() ? null : driversLicense.trim().toLowerCase();
        }

        public final boolean checkCatB() {
            return getDriversLicense().equalsIgnoreCase("B");
        }

        public final boolean checkCatC() {
            return getDriversLicense().equalsIgnoreCase("C");
        }

        public final boolean checkCatD() {
            return getDriversLicense().equalsIgnoreCase("D");
        }

        @Override
        public String toString() {
            return driversLicense;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DriversLicense that = (DriversLicense) o;
            return driversLicense.equals(that.driversLicense);
        }

        @Override
        public int hashCode() {
            return Objects.hash(driversLicense);
        }
    }

    public void moving() {
        System.out.println(getName() + " уверенно двигается вперед");
    }

    public void startMoving() {
        System.out.println(getName() + " жмет педаль газа");
    }

    public void stopMoving() {
        System.out.println(getName() + " жмет педаль тормоза");
    }

    public void refill() {
        System.out.println(getName() + " идет на АЗС");
    }

    public final DriversLicense getDriversLicense() {
        return driversLicense;
    }

    public final void setDriversLicense(DriversLicense driversLicense) {
        if (this.driversLicense == null && this.getDriverLicense().equalsIgnoreCase("YES") || this.driverLicense.equalsIgnoreCase("ДА")) {
            this.driversLicense = driversLicense;
        }
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if (this.name == null) {
            this.name = name == null || name.trim().isEmpty() ? null : name.trim().toUpperCase();
        }
    }

    public final String getDriverLicense() {
        return driverLicense;
    }

    public final void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense == null || driverLicense.trim().isEmpty() ? null : driverLicense.trim().toLowerCase();
        if (!this.driverLicense.equalsIgnoreCase("YES") || !this.driverLicense.equalsIgnoreCase("ДА")) {
            this.driversLicense = null;
        }
    }

    public final int getExperience() {
        return experience;
    }

    public final void setExperience(int experience) {
        this.experience = Math.abs(experience);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", driverLicense='" + driverLicense + '\'' +
                ", experience=" + experience +
                ", driversLicense=" + driversLicense +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver<?> driver = (Driver<?>) o;
        return experience == driver.experience && name.equals(driver.name) && driverLicense.equals(driver.driverLicense) && driversLicense.equals(driver.driversLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, driverLicense, experience, driversLicense);
    }
}

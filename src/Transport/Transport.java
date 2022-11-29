package Transport;

import java.util.Objects;

public abstract class Transport {
    private String brand;
    private String model;
    private double engineVolume;

    public Transport(String brand, String model, double engineVolume) {
        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
    }

    public abstract void printType();

    public void startMoving() {
        System.out.println(getBrand() + " " + getModel() + " начинает движение");
    }

    public void stopMoving() {
        System.out.println(getBrand() + " " + getModel() + " останавливаемся");
    }

    public final String getBrand() {
        return brand;
    }

    public final void setBrand(String brand) {
        if (this.brand == null) {
            this.brand = brand == null || brand.trim().isEmpty() ? null : brand.trim().toLowerCase();
        }
    }

    public final String getModel() {
        return model;
    }

    public final void setModel(String model) {
        if (this.model == null) {
            this.model = model == null || model.trim().isEmpty() ? null : model.trim().toLowerCase();
        }
    }

    public final double getEngineVolume() {
        return engineVolume;
    }

    public final void setEngineVolume(double engineVolume) {
        double scale = Math.pow(10, 1);
        this.engineVolume = Math.ceil(Math.abs((engineVolume / scale) * scale));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Double.compare(transport.engineVolume, engineVolume) == 0 && Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume=" + engineVolume +
                '}';
    }
}

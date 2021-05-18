package model;

import java.util.Objects;

public class GasStationOrder {
    private FuelType fuelType;
    private double price;
    private double count;
    private int discount = 0;

    public GasStationOrder(FuelType fuelType, double price, double count, int discount) {
        this.fuelType = fuelType;
        this.price = price;
        this.count = count;
        this.discount = discount;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasStationOrder that = (GasStationOrder) o;
        return Double.compare(that.price, price) == 0 && Double.compare(that.count, count) == 0 && discount == that.discount && fuelType == that.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuelType, price, count, discount);
    }

    @Override
    public String toString() {
        return "GasStationOrder{" +
                "fuelType=" + fuelType +
                ", price=" + price +
                ", count=" + count +
                ", discount=" + discount +
                '}';
    }
}

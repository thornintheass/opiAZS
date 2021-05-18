package model;

import java.util.Objects;

public class Cashier {
    private String gasStationName;
    private String fullName;
    private String address;
    private String telNumber;
    private boolean onWork;

    public Cashier(String gasStationName, String fullName, String address, String telNumber, boolean onWork) {
        this.gasStationName = gasStationName;
        this.fullName = fullName;
        this.address = address;
        this.telNumber = telNumber;
        this.onWork = onWork;
    }

    public String getGasStationName() {
        return gasStationName;
    }

    public void setGasStationName(String gasStationName) {
        this.gasStationName = gasStationName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public boolean isOnWork() {
        return onWork;
    }

    public void setOnWork(boolean onWork) {
        this.onWork = onWork;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cashier cashier = (Cashier) o;
        return onWork == cashier.onWork && Objects.equals(gasStationName, cashier.gasStationName) && Objects.equals(fullName, cashier.fullName) && Objects.equals(address, cashier.address) && Objects.equals(telNumber, cashier.telNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasStationName, fullName, address, telNumber, onWork);
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "gasStationName='" + gasStationName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", onWork=" + onWork +
                '}';
    }
}

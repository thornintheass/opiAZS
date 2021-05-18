package model;

import java.util.Objects;

public class Client {
    private String gasStationName;
    private String fullName;
    private String telNumber;
    private String gasStationCard;
    private GasStationOrder gasStationOrder;


    public Client(String gasStationName, String fullName, String telNumber, String gasStationCard, GasStationOrder gasStationOrder) {
        this.gasStationName = gasStationName;
        this.fullName = fullName;
        this.telNumber = telNumber;
        this.gasStationCard = gasStationCard;
        this.gasStationOrder = gasStationOrder;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getGasStationCard() {
        return gasStationCard;
    }

    public void setGasStationCard(String gasStationCard) {
        this.gasStationCard = gasStationCard;
    }

    public GasStationOrder getGasStation() {
        return gasStationOrder;
    }

    public void setGasStation(GasStationOrder gasStationOrder) {
        this.gasStationOrder = gasStationOrder;
    }

    public GasStationOrder getGasStationOrder() {
        return gasStationOrder;
    }

    public void setGasStationOrder(GasStationOrder gasStationOrder) {
        this.gasStationOrder = gasStationOrder;
    }

    @Override
    public String toString() {
        return "Client{" +
                "gasStationName='" + gasStationName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", gasStationCard='" + gasStationCard + '\'' +
                ", gasStationOrder=\n" + gasStationOrder +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(gasStationName, client.gasStationName) && Objects.equals(fullName, client.fullName) && Objects.equals(telNumber, client.telNumber) && Objects.equals(gasStationCard, client.gasStationCard) && Objects.equals(gasStationOrder, client.gasStationOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasStationName, fullName, telNumber, gasStationCard, gasStationOrder);
    }
}

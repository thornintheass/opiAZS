import model.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class App {

    public static void main(String[] args) {
        List<Cashier> cashiers = getTestCashiers();
        List<GasStationOrder> orders = getTestOrders();
        List<Client> clients = getTestClients(orders);

        task1(cashiers);

        task2(cashiers);

        task3(clients);

        task4(orders);

        System.out.println("\nТип палива, який має найбільший попит: ");
        findMaxOrMinByFuelType(orders, Task5And6Type.MAX);

        System.out.println("\nТип палива, який має найменший попит: ");
        findMaxOrMinByFuelType(orders, Task5And6Type.MIN);
    }

    private static void findMaxOrMinByFuelType(List<GasStationOrder> orders, Task5And6Type taskType) {
        Map.Entry<FuelType, Long> result;
        Stream<Map.Entry<FuelType, Long>> stream = orders.stream()
                .collect(Collectors.groupingBy(GasStationOrder::getFuelType, Collectors.counting()))
                .entrySet()
                .stream();
        result = switch (taskType) {
            case MAX -> stream.max(Map.Entry.comparingByValue()).get();
            case MIN -> stream.min(Map.Entry.comparingByValue()).get();
        };
        System.out.println(result.getKey() + " - " + result.getValue());
    }

    private static void task4(List<GasStationOrder> orders) {
        System.out.println("\nСередня вартість заправки автомобіля: ");

        double averagePrice = orders.stream().mapToDouble(GasStationOrder::getPrice).average().getAsDouble();
        System.out.println(averagePrice);
    }

    private static void task3(List<Client> clients) {
        System.out.println("СПИСОК КЛИЕНТОВ, КОТОРЫЕ ВЫБРАЛИ ОПРЕДЕЛЕННЫЙ ВИД ТОПЛЕВА\n");

        System.out.println("***E95***");
        clients.stream()
                .filter(client -> client.getGasStationOrder().getFuelType() == FuelType.E95)
                .forEach(System.out::println);

        System.out.println("\n***E92***");
        clients.stream()
                .filter(client -> client.getGasStationOrder().getFuelType() == FuelType.E92)
                .forEach(System.out::println);

        System.out.println("\n***E87***");
        clients.stream()
                .filter(client -> client.getGasStationOrder().getFuelType() == FuelType.E87)
                .forEach(System.out::println);

        System.out.println("\n***DIESEL***");
        clients.stream()
                .filter(client -> client.getGasStationOrder().getFuelType() == FuelType.DIESEL)
                .forEach(System.out::println);
    }

    private static void task2(List<Cashier> cashiers) {
        System.out.println("КАССИРЫ, КОТОРЫЕ РАБОТЮТА СЕЙЧАС");
        cashiers.stream().filter(Cashier::isOnWork).forEach(System.out::println);
        System.out.println("\n*****************\n");
    }

    private static void task1(List<Cashier> cashiers) {
        System.out.println("\nСПИСОК КАССИРОВ: ");
        cashiers.forEach(System.out::println);
        System.out.println("\n*****************\n");
    }

    private static List<Cashier> getTestCashiers() {
        List<Cashier> cashiers = new LinkedList<>();
        cashiers.add(new Cashier("GasStationName1", "Alex Yatsenko",
                "Atom Space", "+3806645456", true));
        cashiers.add(new Cashier("GasStationName2", "Test Test",
                "University", "+567676754", false));
        cashiers.add(new Cashier("GasStationName3", "Hello World",
                "Home", "+676767667", true));
        cashiers.add(new Cashier("GasStationName4", "Java World",
                "Dobr 2/56", "+8787878787", false));
        cashiers.add(new Cashier("GasStationName5", "Kotlin Dev",
                "Kiyv", "+988998989", true));
        return cashiers;
    }

    private static List<GasStationOrder> getTestOrders() {
        List<GasStationOrder> orders = new LinkedList<>();
        orders.add(new GasStationOrder(FuelType.E95, 100, 5, 0));
        orders.add(new GasStationOrder(FuelType.E92, 566.43, 11, 0));
        orders.add(new GasStationOrder(FuelType.E95, 452.05, 8.75, 10));
        orders.add(new GasStationOrder(FuelType.DIESEL, 342.34, 6.33, 0));
        orders.add(new GasStationOrder(FuelType.E87, 58.78, 1.4, 0));
        orders.add(new GasStationOrder(FuelType.E95, 687.5, 13.8, 5));
        return orders;
    }

    private static List<Client> getTestClients(List<GasStationOrder> orders) {
        List<Client> clients = new LinkedList<>();
        clients.add(new Client("GasStationName1", "Client 1", "+2134334", "Card @11", orders.get(0)));
        clients.add(new Client("GasStationName2", "Client 2", "+3453466", "Card @12", orders.get(1)));
        clients.add(new Client("GasStationName3", "Client 3", "+5465464", "Card @13", orders.get(2)));
        clients.add(new Client("GasStationName4", "Client 4", "+6767676", "Card @14", orders.get(3)));
        clients.add(new Client("GasStationName1", "Client 5", "+6786787", "Card @15", orders.get(4)));
        clients.add(new Client("GasStationName2", "Client 6", "+8908909", "Card @16", orders.get(5)));
        return clients;
    }

}
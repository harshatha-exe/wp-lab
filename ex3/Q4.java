import java.util.*;

class Vehicle {
    String make, model, fuelType;
    int year;

    Vehicle(String make, String model,
            int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    void fuelEfficiency() {}
    void maxSpeed() {}
    void distanceTravelled() {}
}

class Car extends Vehicle {

    Car(String make, String model,
        int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    void fuelEfficiency() {
        System.out.println("Fuel Efficiency: 20 km/l");
    }

    void maxSpeed() {
        System.out.println("Max Speed: 180 km/hr");
    }

    void distanceTravelled() {
        System.out.println("Distance: 500 km");
    }
}

class Truck extends Vehicle {

    Truck(String make, String model,
          int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    void fuelEfficiency() {
        System.out.println("Fuel Efficiency: 8 km/l");
    }

    void maxSpeed() {
        System.out.println("Max Speed: 100 km/hr");
    }

    void distanceTravelled() {
        System.out.println("Distance: 1000 km");
    }
}

class Motorcycle extends Vehicle {

    Motorcycle(String make, String model,
               int year, String fuelType) {
        super(make, model, year, fuelType);
    }

    void fuelEfficiency() {
        System.out.println("Fuel Efficiency: 45 km/l");
    }

    void maxSpeed() {
        System.out.println("Max Speed: 140 km/hr");
    }

    void distanceTravelled() {
        System.out.println("Distance: 250 km");
    }
}

public class Q4 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter make: ");
        String make = sc.next();

        System.out.print("Enter model: ");
        String model = sc.next();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        System.out.print("Enter fuel type: ");
        String fuel = sc.next();
        System.out.print("Enter vehicle type (1 - Car, 2 - Truck, 3 - Motorcycle): ");
        int choice = sc.nextInt();
        Vehicle v;
        switch (choice) {
            case 1:
                v = new Car(make, model, year, fuel);
                break;
            case 2:
                v = new Truck(make, model, year, fuel);
                break;
            case 3:
                v = new Motorcycle(make, model, year, fuel);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        v.fuelEfficiency();
        v.maxSpeed();
        v.distanceTravelled();
    }
}
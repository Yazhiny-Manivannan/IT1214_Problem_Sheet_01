class Vehicle {
    private String licensePlate;
    private String ownerName;
    private int hoursParked;

    Vehicle(String licensePlate, String ownerName, int hoursParked) {
        this.licensePlate = licensePlate;
        this.ownerName = ownerName;
        this.hoursParked = hoursParked;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
	
    public String getLicensePlate() {
        return licensePlate;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
	
    public String getOwnerName() {
        return ownerName;
    }
	
    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }
	
    public int getHoursParked() {
        return hoursParked;
    }

}

class ParkingLot {
	Vehicle[] vehicles;
	int count;
	
	ParkingLot() {
		vehicles = new Vehicle[5];
		count = 0;
	}
	
	   public void parkVehicle(Vehicle vehicle) {
        if (count < vehicles.length) {           // Check if there's space
            vehicles[count] = vehicle;
            count++;
            System.out.println("Vehicle parked: " + vehicle.getLicensePlate());
        } else {
            System.out.println("Parking lot is full!");
        }
    }

    public void removeVehicle(String licensePlate) {
        boolean found = false;
        for (int i = 0; i < count; i++) {                   // Go through each parked vehicle
            if (vehicles[i].getLicensePlate().equals(licensePlate)) {         // checking license plate is matching or not
                System.out.println("\nRemoving vehicle: " + licensePlate);

                for (int j = i; j < count - 1; j++) {
                    vehicles[j] = vehicles[j + 1];
                }
                vehicles[count - 1] = null;
                count--;
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Vehicle with license plate " + licensePlate + " not found.");
        }
    }

    public void displayAllVehicles() {
        System.out.println("\nParked Vehicles:");
        for (int i = 0; i < count; i++) {
            Vehicle v = vehicles[i];
            System.out.println("License Plate: " + v.getLicensePlate() + ", Owner: " + v.getOwnerName() + ", Hours Parked: " + v.getHoursParked());
        }
    }
}


class MainParking {
    public static void main(String[] args) {
        ParkingLot lot = new ParkingLot();

        // Park vehicles
        lot.parkVehicle(new Vehicle("ABC123", "John Doe", 2));
        lot.parkVehicle(new Vehicle("XYZ789", "Jane Smith", 4));
        lot.parkVehicle(new Vehicle("LMN456", "Bob Brown", 1));

        // Remove one vehicle
        lot.removeVehicle("XYZ789");

        // Display remaining vehicles
        lot.displayAllVehicles();
    }
}

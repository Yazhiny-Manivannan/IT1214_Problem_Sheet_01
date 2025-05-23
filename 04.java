class Ticket {
	int ticketNumber;
	String customerName;
	int seatNumber;
	
	Ticket(int ticketNumber, String customerName, int seatNumber){
		this.ticketNumber = ticketNumber;
		this.customerName = customerName;
		this.seatNumber = seatNumber;
	}
	
	public int getTicketNumber(){
		return ticketNumber;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public int getSeatNumber(){
		return seatNumber;
	}
}

class BookingSystem {
    private Ticket[] tickets;       // Array to store booked tickets
    private boolean[] seatsBooked; // Track which seats are booked
    private int count;        // Number of tickets booked

    BookingSystem() {
        tickets = new Ticket[10];      
        seatsBooked = new boolean[10];
        count = 0;
    }

 
    public void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (count >= 10) {
            System.out.println("All seats are fully booked!");
            return;
        }

        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number! (Choose 1-10)");
            return;
        }

        if (seatsBooked[seatNumber - 1]) {
            System.out.println("\nSeat " + seatNumber + " is already booked!");
            return;
        }

        Ticket t = new Ticket(ticketNumber, customerName, seatNumber);
        tickets[count] = t;
        seatsBooked[seatNumber - 1] = true;
        count++;
        System.out.println("\nTicket booked for " + customerName + " at seat " + seatNumber);
    }

    public void cancelTicket(int ticketNumber) {
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (tickets[i].getTicketNumber() == ticketNumber) {
                int seat = tickets[i].getSeatNumber();
                seatsBooked[seat - 1] = false;

                for (int j = i; j < count - 1; j++) {
                    tickets[j] = tickets[j + 1];
                }

                tickets[count - 1] = null;
                count--;
                found = true;
                System.out.println("\nTicket " + ticketNumber + " cancelled. Seat " + seat + " is now free.");
                break;
            }
        }

        if (!found) {
            System.out.println("Ticket number " + ticketNumber + " not found.");
        }
    }

    public void displayBookings() {
        System.out.println("\nCurrent Bookings:");
        if (count == 0) {
            System.out.println("No tickets booked yet.");
            return;
        }

        for (int i = 0; i < count; i++) {
            Ticket t = tickets[i];
            System.out.println("Ticket : " + t.getTicketNumber() + ", Name: " + t.getCustomerName() + ", Seat: " + t.getSeatNumber());
        }
    }
}


class MainCinema {
    public static void main(String[] args) {
        BookingSystem cinema = new BookingSystem();

        // Book tickets
        cinema.bookTicket(1, "Alice", 1);
        cinema.bookTicket(2, "Bob", 2);
        cinema.bookTicket(3, "Charlie", 3);

        // Cancel ticket number 2
        cinema.cancelTicket(2);

        // Try to book a new ticket at seat 2
        cinema.bookTicket(4, "David", 2);

        // Display all current bookings
        cinema.displayBookings();
    }
}
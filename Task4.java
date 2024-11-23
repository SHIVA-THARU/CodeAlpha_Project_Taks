import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    public Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true; // Rooms are available by default
        this.price = price;
    }
}

class Reservation {
    int roomNumber;
    String customerName;
    double paymentAmount;

    public Reservation(int roomNumber, String customerName, double paymentAmount) {
        this.roomNumber = roomNumber;
        this.customerName = customerName;
        this.paymentAmount = paymentAmount;
    }
}

public class Task4 {

    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Task4() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    // Initialize some rooms in the system
    private void initializeRooms() {
        rooms.add(new Room(101, "Single", 50.0));
        rooms.add(new Room(102, "Single", 50.0));
        rooms.add(new Room(201, "Double", 80.0));
        rooms.add(new Room(202, "Double", 80.0));
        rooms.add(new Room(301, "Suite", 150.0));
    }

    // Display available rooms
    public void viewAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.printf("Room %d (%s) - $%.2f per night%n", room.roomNumber, room.category, room.price);
            }
        }
    }

    // Make a reservation
    public void makeReservation(Scanner scanner) {
        System.out.print("\nEnter the room number you want to book: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom == null) {
            System.out.println("Invalid room number or room is not available.");
            return;
        }

        System.out.print("Enter your name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter payment amount: ");
        double payment = scanner.nextDouble();

        if (payment < selectedRoom.price) {
            System.out.println("Insufficient payment. Booking failed.");
            return;
        }

        selectedRoom.isAvailable = false;
        reservations.add(new Reservation(roomNumber, customerName, payment));
        System.out.println("Booking successful! Thank you for your reservation.");
    }

    // View booking details
    public void viewBookings() {
        System.out.println("\nBooking Details:");
        if (reservations.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }

        for (Reservation reservation : reservations) {
            System.out.printf("Room %d reserved by %s. Payment: $%.2f%n",
                    reservation.roomNumber, reservation.customerName, reservation.paymentAmount);
        }
    }

    // Show the main menu
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Hotel Reservation System!");
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Booking Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1 and 4.");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Task4 hotelReservationSystem = new Task4();
        hotelReservationSystem.showMenu();
    }
}

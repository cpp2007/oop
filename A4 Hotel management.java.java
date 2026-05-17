import java.util.Scanner;

public class HotelBooking {
    static int floors = 3;
    static int rooms = 4;
    static int[][] hotel = new int[floors][rooms];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Room Booking System");
            System.out.println("1. View Room Availability");
            System.out.println("2. Book a Room");
            System.out.println("3. Check Out from Room");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Try again.");
                sc.next();
                continue;
            }
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    displayRooms();
                    break;
                case 2:
                    bookRoom(sc);
                    break;
                case 3:
                    checkOut(sc);
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Booking System!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void displayRooms() {
        System.out.println("\nRoom Status (0 = Available, 1 = Booked)");
        for (int i = 0; i < floors; i++) {
            System.out.print("Floor " + (i + 1) + ": ");
            for (int j = 0; j < rooms; j++) {
                System.out.print(hotel[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void bookRoom(Scanner sc) {
        System.out.print("Enter Floor (1-" + floors + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.next();
            return;
        }
        int floor = sc.nextInt() - 1;

        System.out.print("Enter Room (1-" + rooms + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.next();
            return;
        }
        int room = sc.nextInt() - 1;

        if (isValid(floor, room)) {
            if (hotel[floor][room] == 0) {
                hotel[floor][room] = 1;
                System.out.println("Room booked successfully!");
            } else {
                System.out.println("Room already booked.");
            }
        } else {
            System.out.println("Invalid floor or room number.");
        }
    }
    public static void checkOut(Scanner sc) {
        System.out.print("Enter Floor (1-" + floors + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.next();
            return;
        }
        int floor = sc.nextInt() - 1;

        System.out.print("Enter Room (1-" + rooms + "): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            sc.next();
            return;
        }
        int room = sc.nextInt() - 1;
        if (isValid(floor, room)) {
            if (hotel[floor][room] == 1) {
                hotel[floor][room] = 0;
                System.out.println("Checked out successfully!");
            } else {
                System.out.println("Room is already available.");
            }
        } else {
            System.out.println("Invalid floor or room number.");
        }
    }
    public static boolean isValid(int floor, int room) {
        return floor >= 0 && floor < floors && room >= 0 && room < rooms;
    }
}
import java.util.Scanner;

public class OnlineReservationSystem {
    static class User {
        private String username;
        private String password;
        private String email;
        private String contact;

        public User(String username, String password, String email, String contact) {
            this.username = username;
            this.password = password;
            this.email = email;
            this.contact = contact;
        }

        public void updateProfile(String email, String contact) {
            this.email = email;
            this.contact = contact;
            System.out.println("Profile updated successfully.");
        }

        public void updatePassword(String newPassword) {
            this.password = newPassword;
            System.out.println("Password updated successfully.");
        }

        public boolean checkPassword(String password) {
            return this.password.equals(password);
        }

        @Override
        public String toString() {
            return "Username: " + username + "\nEmail: " + email + "\nContact: " + contact;
        }
    }

    static class ReservationSystem {
        private boolean[] seats;

        public ReservationSystem(int numSeats) {
            seats = new boolean[numSeats]; // Initialize seats array
        }

        public boolean makeReservation(int seatNumber) {
            if (seatNumber < 1 || seatNumber > seats.length) {
                System.out.println("Invalid seat number.");
                return false;
            }
            if (seats[seatNumber - 1]) {
                System.out.println("Seat " + seatNumber + " is already reserved.");
                return false;
            }
            seats[seatNumber - 1] = true;
            System.out.println("Reservation for seat " + seatNumber + " successful.");
            return true;
        }

        public void displayAvailableSeats() {
            System.out.println("\nAvailable Seats:");
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }

        public void displayReservedSeats() {
            System.out.println("\nReserved Seats:");
            for (int i = 0; i < seats.length; i++) {
                if (seats[i]) {
                    System.out.print((i + 1) + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Example usage
        User user = new User("viraj", "1234", "user1@example.com", "1234567890");
        ReservationSystem reservationSystem = new ReservationSystem(10); // 10 seats available

        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            if (username.equals(user.username) && user.checkPassword(password)) {
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Try again.");
            }
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Make Reservation");
            System.out.println("2. View Available Seats");
            System.out.println("3. View Reserved Seats");
            System.out.println("4. Update Profile");
            System.out.println("5. Update Password");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    reservationSystem.displayAvailableSeats();
                    System.out.print("Enter seat number to reserve: ");
                    int seatNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    reservationSystem.makeReservation(seatNumber);
                    break;
                case 2:
                    reservationSystem.displayAvailableSeats();
                    break;
                case 3:
                    reservationSystem.displayReservedSeats();
                    break;
                case 4:
                    System.out.print("Enter new email: ");
                    String newEmail = scanner.nextLine();
                    System.out.print("Enter new contact: ");
                    String newContact = scanner.nextLine();
                    user.updateProfile(newEmail, newContact);
                    break;
                case 5:
                    System.out.print("Enter new password: ");
                    String newPassword = scanner.nextLine();
                    user.updatePassword(newPassword);
                    break;
                case 6:
                    exit = true;
                    System.out.println("Logged out successfully.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}

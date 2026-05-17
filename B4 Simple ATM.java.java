import java.util.Scanner;
class Customer {
    double balance = 1000; 
}
public class SimpleATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        int choice = 0;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        System.out.printf("Current Balance: %.2f%n", c.balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ");
                        double deposit = sc.nextDouble();
                        if (deposit <= 0) {
                            throw new IllegalArgumentException("Invalid deposit amount!");
                        }
                        c.balance += deposit;
                        System.out.println("Deposit successful.");
                        break;

                    case 3:
                        System.out.print("Enter amount to withdraw: ");
                        double withdraw = sc.nextDouble();
                        if (withdraw <= 0) {
                            throw new IllegalArgumentException("Invalid withdrawal amount!");
                        }
                        if (withdraw > c.balance) {
                            throw new ArithmeticException("Insufficient funds!");
                        }
                        c.balance -= withdraw;
                        System.out.println("Withdrawal successful.");
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
              
            } 
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } 
            catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } 
            catch (Exception e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine(); 
            }

        } while (choice != 4);

        sc.close();
    }
}

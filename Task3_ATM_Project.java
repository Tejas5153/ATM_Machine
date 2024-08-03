import java.util.Scanner;

class abc 
{
    private double balance;

    public abc(double initialBalance) 
    {
        if (initialBalance >= 0) 
        {
            this.balance = initialBalance;
        } 
        else 
        {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        }
    }
    public void start() 
    {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    checkBalance(); 
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } 
        while (choice != 4);
        scanner.close();
    }

    private void showMenu() 
    {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private void withdraw(double amount) 
    {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: " + amount);
        } 
        else 
        {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    private void deposit(double amount) 
    {
        if (amount > 0) 
        {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } 
        else 
        {
            System.out.println("Invalid amount.");
        }
    }

    private void checkBalance() 
    {
        System.out.println("Current balance: " + balance);
    }

    public static void main(String[] args) 
    {
        abc atm = new abc(500.0); // Initial balance
        atm.start();
    }
}


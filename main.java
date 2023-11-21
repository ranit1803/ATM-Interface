import java.util.*;

public class main 
{
    private static int USER_ID = 1234; 
    private static final int max_i=3;
    private double balance = 1000; 
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String args[]) 
    {
        main atm = new main();
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the ATM!!");
        int i = 0;
        System.out.print("Enter Your User ID!: (1234)");
        int userId = scan.nextInt();
        while (i < max_i) 
        {
            if (userId == USER_ID) 
            {
                break;
            }
             else 
            {
                System.out.println("Invalid ID!\nTry Again..");
                i++;
                if (i < max_i) 
                {
                    System.out.println("Number of Tries remaining are:" + (max_i-i));
                } else {
                    System.out.println("Account Blocked!!\nMaximum login attempts reached\nTry Contacting The Bank");
                    return;
                }
            }
        }
        while (true) 
        {
            System.out.println("\nATM Menu:");
            System.out.println("1. View Transactions History");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Deposit Amount");
            System.out.println("4. Transfer Amount");
            System.out.println("5. Exit");
            System.out.print("Enter Your Choice: ");

            int choice = scan.nextInt();

            switch (choice) 
            {
            case 1:atm.viewHistory();
            break;
            case 2:System.out.println("Enter the amount to withdraw: ");
            double withdraw = scan.nextDouble();
            atm.withdraw(withdraw);
            break;
            case 3:System.out.print("Enter the amount to deposit: ");
            double deposit = scan.nextDouble();
            atm.deposit(deposit);
            break;
            case 4:System.out.print("Enter the amount to transfer: ");
            double transferAmount = scan.nextDouble();
            System.out.print("Enter the receiver's account number: ");
            int Receiver = scan.nextInt();
            atm.transfer(transferAmount, Receiver);
            break;
            case 5:System.out.println("Exiting...\nThank You For Using");
            return;
            default:System.out.println("Invalid Choice!");
            }
        }
    }

    public void viewHistory() 
    {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) 
        {
            System.out.println(transaction);
        }
    }


    public void withdraw(double amount) 
    {
        if (balance >= amount) 
        {
            balance = balance-amount;
            String transaction = "Withdraw: $" + amount + " \n Your New Balance is: " + balance;
            transactionHistory.add(transaction);
            System.out.println("$" + amount + " was withdrawn successfully!!.");
            System.out.println("Your new balance is: $" + balance);
        } 
        else {
            System.out.println("Check Your Balance.");
        }
    }

    public void deposit(double amount) 
    {
        balance = balance + amount;
        String transaction = "Deposit: $" + amount + "\n Your New Balance Is:" + balance;
        transactionHistory.add(transaction);
        System.out.println("$" + amount + " was deposited successfully!!");
        System.out.println("Your new balance is: $" + balance);
    }

    public void transfer(double amount, int Receiver) 
    {
        if (balance >= amount) 
        {
            balance =balance-amount;
            String transaction = "Transfer $" + amount + " \n Your New Balance is:" + balance;
            transactionHistory.add(transaction);
            System.out.println("$" + amount + "was transferred to account " + Receiver + " successfully!!");
            System.out.println("Your new balance is: $" + balance);
        } 
        else {
            System.out.println("Check Your Balance.");
        }
    }
}
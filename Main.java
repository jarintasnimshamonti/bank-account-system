import java.util.ArrayList;
import java.util.Scanner;

// ===== সাধারণ অ্যাকাউন্ট ক্লাস =====
class Account {
    private int accNo;
    private String name;
    protected double balance;
    private ArrayList<String> history = new ArrayList<>();

    // স্যার চাইলে এটা বদলে মিনিমাম ব্যালেন্স রাখা যাবে (যেমন 500)
    protected static final double MIN_BALANCE = 0;

    public Account(int accNo, String name, double initialDeposit) {
        this.accNo = accNo;
        this.name = name;
        this.balance = initialDeposit;
        history.add("Account opened with " + initialDeposit);
    }

    public int getAccNo() { return accNo; }
    public String getName() { return name; }
    public double getBalance() { return balance; }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }
        balance += amount;
        history.add("Deposited: " + amount);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }
        if (balance - amount < MIN_BALANCE) {
            System.out.println("Insufficient balance!");
            return false;
        }
        balance -= amount;
        history.add("Withdrawn: " + amount);
        return true;
    }

    public void showHistory() {
        System.out.println("--- Transaction History (" + name + ") ---");
        for (String h : history) {
            System.out.println(h);
        }
    }

    public String getType() { return "Current"; }

    public void showInfo() {
        System.out.println("Acc No : " + accNo);
        System.out.println("Name   : " + name);
        System.out.println("Type   : " + getType());
        System.out.println("Balance: " + balance);
    }

    protected void addHistory(String text) {
        history.add(text);
    }
}

// ===== সেভিংস অ্যাকাউন্ট (ইনহেরিটেন্স) =====
class SavingsAccount extends Account {
    private double interestRate; // শতকরা হার

    public SavingsAccount(int accNo, String name, double initialDeposit, double interestRate) {
        super(accNo, name, initialDeposit);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * interestRate / 100;
        balance += interest;
        addHistory("Interest added: " + interest);
        System.out.println("Interest added: " + interest);
    }

    @Override
    public String getType() { return "Savings (" + interestRate + "%)"; }
}

// ===== মেইন ক্লাস (মেনু) =====
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Account> accounts = new ArrayList<>();
    static int nextAccNo = 1001;

    static int readInt(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
            }
        }
    }

    static double readDouble(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                return Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid amount!");
            }
        }
    }

    static Account findAccount(int accNo) {
        for (Account a : accounts) {
            if (a.getAccNo() == accNo) return a;
        }
        return null;
    }

    static Account askAccount() {
        int no = readInt("Enter account number: ");
        Account acc = findAccount(no);
        if (acc == null) System.out.println("Account not found!");
        return acc;
    }

    static void createAccount() {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        int type = readInt("Type (1 = Current, 2 = Savings): ");
        double amount = readDouble("Initial deposit: ");
        if (amount < 0) {
            System.out.println("Invalid amount!");
            return;
        }

        Account acc;
        if (type == 2) {
            double rate = readDouble("Interest rate (%): ");
            acc = new SavingsAccount(nextAccNo, name, amount, rate);
        } else {
            acc = new Account(nextAccNo, name, amount);
        }
        accounts.add(acc);
        System.out.println("Account created! Your account number is " + nextAccNo);
        nextAccNo++;
    }

    public static void main(String[] args) {
        System.out.println("===== BANK ACCOUNT SYSTEM =====");
        int choice;
        do {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance / Info");
            System.out.println("5. Transaction History");
            System.out.println("6. Add Interest (Savings only)");
            System.out.println("0. Exit");
            choice = readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2: {
                    Account a = askAccount();
                    if (a != null) {
                        double amt = readDouble("Amount to deposit: ");
                        if (a.deposit(amt))
                            System.out.println("Deposited! New balance: " + a.getBalance());
                    }
                    break;
                }
                case 3: {
                    Account a = askAccount();
                    if (a != null) {
                        double amt = readDouble("Amount to withdraw: ");
                        if (a.withdraw(amt))
                            System.out.println("Withdrawn! New balance: " + a.getBalance());
                    }
                    break;
                }
                case 4: {
                    Account a = askAccount();
                    if (a != null) a.showInfo();
                    break;
                }
                case 5: {
                    Account a = askAccount();
                    if (a != null) a.showHistory();
                    break;
                }
                case 6: {
                    Account a = askAccount();
                    if (a != null) {
                        if (a instanceof SavingsAccount) {
                            ((SavingsAccount) a).addInterest();
                        } else {
                            System.out.println("This is not a savings account!");
                        }
                    }
                    break;
                }
                case 0:
                    System.out.println("Thank you! Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }
}


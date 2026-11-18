import java.util.Scanner;

// 22. Student class (3 objects created in problem22)
class Student {
    String name;
    int roll;
    double marks;

    Student(String name, int roll, double marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Roll: " + roll + ", Marks: " + marks);
    }
}

// 23. Local & instance variable
class VarDemo {
    int instanceVar = 10; // instance variable

    void show() {
        int localVar = 20; // local variable
        System.out.println("Instance variable: " + instanceVar);
        System.out.println("Local variable: " + localVar);
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nEnter problem number (1-28, 0 to exit): ");
            int n = sc.nextInt();
            if (n == 0) break;
            switch (n) {
                case 1: problem1(); break;
                case 2: problem2(); break;
                case 3: problem3(); break;
                case 4: problem4(); break;
                case 5: problem5(); break;
                case 6: problem6(); break;
                case 7: problem7(); break;
                case 8: problem8(); break;
                case 9: problem9(); break;
                case 10: problem10(); break;
                case 11: problem11(); break;
                case 12: problem12(); break;
                case 13: problem13(); break;
                case 14: problem14(); break;
                case 15: problem15(); break;
                case 16: problem16(); break;
                case 17: problem17(); break;
                case 18: problem18(); break;
                case 19: problem19(); break;
                case 20: problem20(); break;
                case 21: problem21(); break;
                case 22: problem22(); break;
                case 23: problem23(); break;
                case 24: problem24(); break;
                case 25: problem25(); break;
                case 26: problem26(); break;
                case 27: problem27(); break;
                case 28: problem28(); break;
                default: System.out.println("Invalid number");
            }
        }
    }

    // 1. Hello World
    static void problem1() {
        System.out.println("Hello World!");
    }

    // 2. Prime Number
    static void problem2() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        boolean prime = n > 1;
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) { prime = false; break; }
        }
        System.out.println(n + (prime ? " is Prime" : " is not Prime"));
    }

    // 3. Palindrome Number
    static void problem3() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), t = n, rev = 0;
        while (t > 0) { rev = rev * 10 + t % 10; t /= 10; }
        System.out.println(n + (rev == n ? " is Palindrome" : " is not Palindrome"));
    }

    // 4. Armstrong Number
    static void problem4() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), t = n, digits = String.valueOf(n).length();
        long sum = 0;
        while (t > 0) { sum += Math.pow(t % 10, digits); t /= 10; }
        System.out.println(n + (sum == n ? " is Armstrong" : " is not Armstrong"));
    }

    static long fact(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    // 5. Strong Number (sum of factorials of digits = number)
    static void problem5() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), t = n;
        long sum = 0;
        while (t > 0) { sum += fact(t % 10); t /= 10; }
        System.out.println(n + (sum == n ? " is Strong" : " is not Strong"));
    }

    // 6. Even-Odd
    static void problem6() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(n + (n % 2 == 0 ? " is Even" : " is Odd"));
    }

    // 7. Leap Year
    static void problem7() {
        System.out.print("Enter a year: ");
        int y = sc.nextInt();
        if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
            System.out.println(y + " is a Leap Year");
        else
            System.out.println(y + " is not a Leap Year");
    }

    // 8. Celsius to Fahrenheit
    static void problem8() {
        System.out.print("Enter temperature in Celsius: ");
        double c = sc.nextDouble();
        System.out.println("Fahrenheit = " + (c * 9 / 5 + 32));
    }

    // 9. Perfect Number
    static void problem9() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), sum = 0;
        for (int i = 1; i <= n / 2; i++) if (n % i == 0) sum += i;
        System.out.println(n + (sum == n && n > 0 ? " is Perfect" : " is not Perfect"));
    }

    // 10. Fibonacci Series
    static void problem10() {
        System.out.print("How many terms: ");
        int n = sc.nextInt();
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long c = a + b; a = b; b = c;
        }
        System.out.println();
    }

    // 11. Factorial
    static void problem11() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        System.out.println(n + "! = " + fact(n));
    }

    // 12. Sum of Digits
    static void problem12() {
        System.out.print("Enter a number: ");
        int n = sc.nextInt(), sum = 0;
        while (n > 0) { sum += n % 10; n /= 10; }
        System.out.println("Sum of digits = " + sum);
    }

    // 13. Star Triangle
    static void problem13() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) System.out.print("* ");
            System.out.println();
        }
    }

    // 14. Pyramid
    static void problem14() {
        System.out.print("Enter rows: ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 15. Diamond
    static void problem15() {
        System.out.print("Enter rows (half): ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
        for (int i = n - 1; i >= 1; i--) {
            for (int s = 1; s <= n - i; s++) System.out.print(" ");
            for (int j = 1; j <= 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }

    // 16. Number Swap (without third variable)
    static void problem16() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("Before: a=" + a + ", b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After:  a=" + a + ", b=" + b);
    }

    // 17. Decimal to Binary
    static void problem17() {
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();
        if (n == 0) { System.out.println("Binary = 0"); return; }
        String bin = "";
        while (n > 0) { bin = (n % 2) + bin; n /= 2; }
        System.out.println("Binary = " + bin);
    }

    // 18. Simple Calculator (switch-case)
    static void problem18() {
        System.out.print("Enter two numbers: ");
        double a = sc.nextDouble(), b = sc.nextDouble();
        System.out.print("Enter operator (+ - * / %): ");
        char op = sc.next().charAt(0);
        switch (op) {
            case '+': System.out.println("Result = " + (a + b)); break;
            case '-': System.out.println("Result = " + (a - b)); break;
            case '*': System.out.println("Result = " + (a * b)); break;
            case '/':
                if (b == 0) System.out.println("Cannot divide by zero");
                else System.out.println("Result = " + (a / b));
                break;
            case '%': System.out.println("Result = " + (a % b)); break;
            default: System.out.println("Invalid operator");
        }
    }

    // 19. Largest among 3 numbers
    static void problem19() {
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        System.out.println("Largest = " + max);
    }

    // 20. 1 + 2/4 + 3/8 + 4/16 + ... + n/2^n
    static void problem20() {
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        double sum = 1; // first term
        for (int k = 2; k <= n; k++) sum += k / Math.pow(2, k);
        System.out.println("Sum = " + sum);
    }

    // 21. Password (do-while)
    static void problem21() {
        String password = "java123";
        String input;
        do {
            System.out.print("Enter password: ");
            input = sc.next();
            if (!input.equals(password)) System.out.println("Wrong password, try again.");
        } while (!input.equals(password));
        System.out.println("Access granted!");
    }

    // 22. Student class with 3 objects
    static void problem22() {
        Student s1 = new Student("Rahim", 1, 85.5);
        Student s2 = new Student("Karim", 2, 78.0);
        Student s3 = new Student("Salma", 3, 92.25);
        s1.display();
        s2.display();
        s3.display();
    }

    // 23. Local & instance variable
    static void problem23() {
        VarDemo obj = new VarDemo();
        obj.show();
    }

    // 24. Shift operators
    static void problem24() {
        int a = 16;
        System.out.println("a = " + a);
        System.out.println("a << 2  = " + (a << 2));   // left shift: multiply by 4
        System.out.println("a >> 2  = " + (a >> 2));   // right shift: divide by 4
        System.out.println("-a >> 2 = " + (-a >> 2));  // signed right shift
        System.out.println("-a >>> 28 = " + (-a >>> 28)); // unsigned right shift
    }

    // 25. Leap Year (ternary operator)
    static void problem25() {
        System.out.print("Enter a year: ");
        int y = sc.nextInt();
        String res = ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) ? "Leap Year" : "Not a Leap Year";
        System.out.println(y + " is " + res);
    }

    static int gcd(int a, int b) {
        while (b != 0) { int t = b; b = a % b; a = t; }
        return a;
    }

    // 26. GCD
    static void problem26() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("GCD = " + gcd(a, b));
    }

    // 27. LCM
    static void problem27() {
        System.out.print("Enter two numbers: ");
        int a = sc.nextInt(), b = sc.nextInt();
        System.out.println("LCM = " + (a / gcd(a, b)) * b);
    }

    // 28. Just print how you felt after doing this
    static void problem28() {
        System.out.println("I feel happy and proud after finishing all 28 problems!");
    }
}

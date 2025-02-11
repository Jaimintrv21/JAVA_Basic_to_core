// Auto-generated file
abstract class Bank {
    abstract double getBalance();
}

class BankA extends Bank {
    @Override
    double getBalance() {
        return 100.0;
    }
}

class BankB extends Bank {
    @Override
    double getBalance() {
        return 150.0;
    }
}

class BankC extends Bank {
    @Override
    double getBalance() {
        return 200.0;
    }
}

public class module2_2_21 {
    public static void main(String[] args) {
        BankA bankA = new BankA();
        BankB bankB = new BankB();
        BankC bankC = new BankC();

        System.out.println("Balance in Bank A: $" + bankA.getBalance());
        System.out.println("Balance in Bank B: $" + bankB.getBalance());
        System.out.println("Balance in Bank C: $" + bankC.getBalance());
    }
}

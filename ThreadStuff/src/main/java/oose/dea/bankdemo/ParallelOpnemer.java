package oose.dea.bankdemo;

public class ParallelOpnemer implements Runnable {
    private Bank bank;
    private int amount;

    public ParallelOpnemer(Bank bank, int amount){
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.neemOp(amount);
    }
}

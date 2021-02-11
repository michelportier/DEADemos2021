package oose.dea.bankdemo;

public class ParallelStorter implements Runnable{
    private Bank bank;
    private int amount;

    public ParallelStorter(Bank bank, int amount){
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.stort(amount);
    }
}

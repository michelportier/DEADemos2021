package oose.dea.bankdemo;

public class Bank {
	private int saldo = 100;
	
	
	public synchronized void  stort (int amount){
		System.out.println("Saldo voor storting " + saldo + ", stort: " + amount );
		saldo = saldo + amount;
		System.out.println("Saldo na storting " + saldo );
	}
	
	public synchronized void neemOp(int amount){
		System.out.println("Saldo voor opname " + saldo + ", neem op: " + amount );

		if (saldo - amount > 0){
			// er is genoeg saldo om op te nemen
			sleep();
			saldo = saldo - amount;
		}

		else {
			System.out.println("Onvoldoende saldo, saldo: " + saldo);
			return;
		}
		System.out.println("Saldo na opname " + saldo );
	}

	private void sleep() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main (String[] args){
		Bank bank = new Bank();

//		bank.stort(50);
//		bank.neemOp(80);
//		bank.neemOp(100);

		// With runnables
//		Thread t1 = new Thread(new ParallelStorter(bank, 50));
//		Thread t2 = new Thread(new ParallelOpnemer(bank, 80));
//		Thread t3 = new Thread(new ParallelOpnemer(bank,100));

		// With Lambda's:
		Thread t1 = new Thread(
				() -> bank.stort(50)
		);

		Thread t2 = new Thread(
				() -> bank.neemOp(80)
		);

		Thread t3 = new Thread(
				() -> bank.neemOp(100)
		);

		t1.start();
		t2.start();
		t3.start();


	}
}

package at.htlklu.coffeemachine;

public class Main {

	public static void main(String[] args) {
		FilterMachine a = new FilterMachine("Horvat");
		EspressoMachine b = new EspressoMachine("Robert");
		
		a.fill();
		a.cook();
		a.cook();
		
		b.fill();
		b.cook();
		b.fill();
		b.cook();
	}
}

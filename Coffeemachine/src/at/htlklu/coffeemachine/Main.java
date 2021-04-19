package at.htlklu.coffeemachine;

public class Main {

	public static void main(String[] args) {
		FilterMachine a = new FilterMachine("A");
		EspressoMachine b = new EspressoMachine("B");
		FilterMachine c = new FilterMachine("C");
		EspressoMachine d = new EspressoMachine("D");
		
		a.fill();
		a.cook();
		a.cook();
		
		b.fill();
		b.cook();
		b.fill();
		b.cook();
		
		c.fill();
		c.cook();
		c.cook();
		
		d.fill();
		d.cook();
		d.cook();
	}
}

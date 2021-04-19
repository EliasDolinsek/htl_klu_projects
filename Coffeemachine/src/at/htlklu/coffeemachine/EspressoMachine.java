package at.htlklu.coffeemachine;

public class EspressoMachine extends CoffeeMachine {

	public EspressoMachine(String brand, boolean isFilled) {
		super(brand, 2, 250, 80, isFilled);
	}
	
	public EspressoMachine(String brand) {
		this(brand, true);
	}


}

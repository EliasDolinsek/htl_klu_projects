package at.htlklu.oopzoo.main;

import at.htlklu.oopzoo.Zoo;
import at.htlklu.oopzoo.impl.Flamingo;
import at.htlklu.oopzoo.impl.Pelican;
import at.htlklu.oopzoo.impl.mammals.Bats;
import at.htlklu.oopzoo.impl.mammals.Elephant;
import at.htlklu.oopzoo.impl.mammals.Lion;

public class Main {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		// Mammals
		zoo.addAnimal(new Elephant(12, "Jürgen"));
		zoo.addAnimalToFlightEnclosure(new Bats(5, "Robert"));
		zoo.addAnimal(new Lion(4, "Horvat"));
		
		// Others
		zoo.addAnimal(new Flamingo(6, "Mannfred"));
		zoo.addAnimal(new Pelican(2, "Susi"));
		
		zoo.flyAll();
		zoo.layEggsAll();
		zoo.trompetAll();
		zoo.printAll();
	}
}

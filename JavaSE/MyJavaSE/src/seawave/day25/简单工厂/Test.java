package seawave.day25.简单工厂;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Dog d = AnimalFactory.createDog();
		
		Dog d = (Dog) AnimalFactory.createAnimal("dog");
		d.eat();
		
		Cat c = (Cat) AnimalFactory.createAnimal("cat");
		c.eat();
	}

}

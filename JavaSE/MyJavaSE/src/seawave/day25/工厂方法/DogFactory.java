package seawave.day25.工厂方法;

public class DogFactory implements Factory {

	@Override
	public Animal createAnimal() {

		return new Dog();
	}

}

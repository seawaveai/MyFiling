package seawave.day25.工厂方法;

public class CatFactory implements Factory {

	@Override
	public Animal createAnimal() {

		return new Cat();
	}

}

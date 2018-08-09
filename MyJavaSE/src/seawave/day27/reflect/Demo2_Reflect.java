package seawave.day27.reflect;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Demo2_Reflect {

	/**
	 * * 榨汁机(Juicer)榨汁的案例
	 * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
	 * @throws IOException 
	 */
	public static void main(String[] args) throws Exception {
		Juicer j = new Juicer();//创建榨汁机
		//j.run(new Apple());
		//j.run(new Orange());
		
		//通过读取配置文件，来创建对应的对象
		BufferedReader br = new BufferedReader(new FileReader("config27.properties")); //seawave.day27.reflect.Apple
		Class clazz = Class.forName(br.readLine());	//获取该类的字节码文件
		Fruit f = (Fruit) clazz.newInstance();	//创建实例对象 ( newInstance()使用无参的构造函数创建对象 )
		j.run(f);
	}
}

interface Fruit {
	public void squeeze();
}

class Apple implements Fruit {
	public void squeeze() {
		System.out.println("榨出一杯苹果汁儿");
	}
}

class Orange implements Fruit {
	public void squeeze() {
		System.out.println("榨出一杯橘子汁儿");
	}
}

class Juicer {
	/*public void run(Apple a) {
		a.squeeze();
	}
	
	public void run(Orange o) {
		o.squeeze();
	}*/
	
	public void run(Fruit f) {
		f.squeeze();
	}
}
package seawave.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;

import seawave.day27.bean.Person;

public class Demo3_Constructor {

	/**
	 * Class类的newInstance()方法是使用该类无参的构造函数创建对象, 如果一个类没有无参的构造函数,
	 * 就不能这样创建了,可以调用Class类的getConstructor
	 * (String.class,int.class)方法获取一个指定的构造函数然后再调用Constructor类的newInstance
	 * ("张三",20)方法创建对象
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("seawave.day27.bean.Person");
		
		//通过无餐构造创建对象
		Person p1 = (Person) clazz.newInstance();				
		System.out.println(p1);
		
		//获取有参构造
		Constructor c = clazz.getConstructor(String.class,int.class);	
		Person p2 = (Person) c.newInstance("张三",23); //通过有参构造创建对象
		System.out.println(p2);
		
		
		
		
		//获取所有的构造方法
		Constructor[] constructors = clazz.getConstructors();
		for (int i = 0 ; i < constructors.length; i++) {
			
			System.out.println(constructors[i].getParameterCount());//构造函数参数的个数
			
			Parameter[] parameters = constructors[i].getParameters();
			for (Parameter parameter : parameters) {
				System.out.println(parameter);
				System.out.println(parameter.getName());
				System.out.println(parameter.getType());
				System.out.println(parameter.getParameterizedType());
			}
			
			Class[] parameterTypes = constructors[i].getParameterTypes();
			for (Class class1 : parameterTypes) {
				System.out.println(class1+"  w");
				System.out.println(class1.getName()+"  w");
				System.out.println(class1.getTypeName()+"  w");
				System.out.println(class1.getSimpleName()+"  w");
			}
			
		}
		
		
	}

}

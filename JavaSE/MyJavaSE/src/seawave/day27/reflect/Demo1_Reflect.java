package seawave.day27.reflect;

import seawave.day27.bean.Person;

public class Demo1_Reflect {

	/**
	 * 1.源文件阶段
	 * 		
	 * 		读取配置文件
	 * 
	 * 2.字节码阶段
	 * 
	 * 		当做静态方法的锁对象
	 * 		
	 * 3.创建对象阶段
	 * 
	 * 		判断是否是通一个字节码对象
	 * 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		//1.源文件阶段
		Class clazz1 = Class.forName("seawave.day27.bean.Person");
		
		//2.字节码阶段
		Class clazz2 = Person.class;
		
		// 3.创建对象阶段
		Person p = new Person();
		Class clazz3 = p.getClass();
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
		
		System.out.println(clazz1);
		System.out.println(clazz1.getName());
		System.out.println(clazz1.getTypeName()); 
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getSuperclass());
		System.out.println(clazz1.getTypeParameters()); 
	}

}

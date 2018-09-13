package seawave.day27.动态代理;

import java.lang.reflect.Proxy;

public class Test {

	/**
	 * * 在Java中java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，
	 * 通过使用这个类和接口就可以生成动态代理对象。
	 * JDK提供的代理只能针对接口做代理。我们有更强大的代理cglib，Proxy类中的方法创建动态代理类对象
	 */
	public static void main(String[] args) {
		UserImp ui = new UserImp();
		ui.add();
		ui.delete();
		System.out.println("-------------------------------");
		
		/*
		 * public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,
		 * InvocationHandler h)
		 *  英[ˈprɒksi]
		 */
		MyInvocationHandler m = new MyInvocationHandler(ui);
		User u = (User)Proxy.newProxyInstance(ui.getClass().getClassLoader(), ui.getClass().getInterfaces(), m);
		u.add();
		u.delete();
	}
}

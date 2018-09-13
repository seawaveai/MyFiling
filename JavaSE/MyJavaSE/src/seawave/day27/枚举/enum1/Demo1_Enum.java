package seawave.day27.枚举.enum1;

public class Demo1_Enum {

	/**
	 * 枚举就是单列（有限个单列）
	 */
	public static void main(String[] args) {
		demo1();
		demo2();
		demo3();
	}

	public static void demo3() {
		Week3 mon = Week3.MON;
		mon.show();//调用的是子类方法，就是匿名内部类实现的方法
	}

	public static void demo2() {
		Week2 mon = Week2.MON;
		System.out.println(mon.getName());
	}

	public static void demo1() {
		Week mon = Week.MON;
		Week tue = Week.TUE;
		Week wed = Week.WED;
		System.out.println(mon);
	}

}

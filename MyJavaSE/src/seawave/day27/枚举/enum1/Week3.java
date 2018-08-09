package seawave.day27.枚举.enum1;

public abstract class Week3 {

	public static final Week3 MON = new Week3("星期一") { // 匿名内部类   
		public void show() {
			System.out.println("星期一");
		}
	};

	public static final Week3 TUE = new Week3("星期二") {
		public void show() {
			System.out.println("星期二");
		}
	};

	public static final Week3 WED = new Week3("星期三") {
		public void show() {
			System.out.println("星期三");
		}
	};

	private String name;

	private Week3(String name) { // 私有构造,不让其他类创建本类对象
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void show();// 抽象
}

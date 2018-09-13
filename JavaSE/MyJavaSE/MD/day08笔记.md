###08.01_面向对象(代码块的概述和分类)(了解)(面试的时候会问,开发不用或者很少用)
* A:代码块概述
	* 在Java中，使用{}括起来的代码被称为代码块。
	
* B:代码块分类
	* 根据其位置和声明的不同，可以分为局部代码块，构造代码块，静态代码块，同步代码块(多线程讲解)。
	
* C:常见代码块的应用
	* a:局部代码块 
		* 在方法中出现；限定变量生命周期，及早释放提高内存利用率
	* b:构造代码块 (初始化块)  
		* 在类中方法外出现；把构造方法中相同的代码存放到一起，每创建一次对象就会执行一次，并且在构造方法前执行
	* c:静态代码块 
		* 在类中方法外出现，由static关键字修饰；用于给类进行初始化，加载的时候就执行，并且只执行一次。
		* 优先于主方法执行的。(不管是在主方法前面还是后面)
		* 一般用于加载驱动
	* d:同步代码块
		* 使用synchronized关键字加上一个锁对象来定义一段代码, 这就叫同步代码块
		* 当多线程并发, 有多段代码同时执行时, 我们希望某一段代码执行的过程中CPU不要切换到其他线程工作. 这时就需要同步.
		* 如果两段代码是同步的, 那么同一时间只能执行一段, 在一段代码没执行结束之前, 不会执行另外一段代码.

###08.02_面向对象(代码块的面试题)(掌握)
* A:看程序写结果
* 
		class Student {
			static {
				System.out.println("Student 静态代码块");
			}
			
			{
				System.out.println("Student 构造代码块");
			}
			
			public Student() {
				System.out.println("Student 构造方法");
			}
		}
	
		class Demo2_Student {
			static {
				System.out.println("Demo2_Student静态代码块");
			}
			
			public static void main(String[] args) {
				System.out.println("我是main方法");
				
				Student s1 = new Student();
				Student s2 = new Student();
			}
		}
Demo2_Student静态代码块
我是main方法
Student 静态代码块
Student 构造代码块
Student 构造方法

Student 构造代码块
Student 构造方法

###08.03_面向对象(继承案例演示)(掌握)
* A:继承(extends)
	* 让类与类之间产生关系,子父类关系 
* B:继承案例演示：
	* 动物类,猫类,狗类
	* 定义两个属性(颜色,腿的个数)两个功能(吃饭，睡觉)
* C:案例演示
	* 使用继承前
* D:案例演示
	* 使用继承后

###08.04_面向对象(继承的好处和弊端)(掌握)
* A:继承的好处
	* a:提高了代码的复用性
	* b:提高了代码的维护性
	* c:让类与类之间产生了关系，是多态的前提
* B:继承的弊端
	* 类的耦合性增强了。
	* 开发的原则：高内聚，低耦合。
	  * 耦合：类与类的关系
	  * 内聚：就是自己完成某件事情的能力

###08.05_面向对象(Java中类的继承特点)(掌握)
* A:Java中类的继承特点
	* a:Java只支持单继承，不支持多继承。(一个儿子只能有一个爹)
		* 有些语言是支持多继承，格式：extends 类1,类2,...
	* b:Java支持多层继承(继承体系)
* B:案例演示
	* Java中类的继承特点
		* 如果想用这个体系的所有功能用最底层的类创建对象
		* 如果想看这个体系的共性功能,看最顶层的类 

###08.06_面向对象(继承的注意事项和什么时候使用继承)(掌握)
* A:继承的注意事项
	* a:子类只能继承父类所有非私有的成员(成员方法和成员变量)
	* b:子类不能继承父类的构造方法，但是可以通过super关键字去访问父类构造方法。
	* c:不要为了部分功能而去继承
	 	  项目经理 姓名 工号 工资 奖金
	   	   程序员  姓名 工号 工资
* B:什么时候使用继承
	* 继承其实体现的是一种关系："is a"。
		Person
			Student
			Teacher
		水果
			苹果
			香蕉
			橘子
			
	采用假设法。
		如果有两个类A,B。只有他们符合A是B的一种，或者B是A的一种，就可以考虑使用继承。

###08.07_面向对象(继承中成员变量的关系)(掌握)
* A:案例演示
	* a:不同名的变量
	* b:同名的变量
	       子父类有重名的变量，就进原则，但一般在开发中是不存在的，因为子类继承父类了后，在重新定义没有意义。
###08.08_面向对象(this和super的区别和应用)(掌握)
* A:this和super都代表什么
	* this:代表当前对象的引用,谁来调用我,我就代表谁
	* super:代表当前对象父类的引用

* B:this和super的使用区别
	* a:调用成员变量
		* this.成员变量  调用本类的成员变量;也可以调用父类的成员变量(本类没有这个变量时，就会继承父类的变量),其实是先继承再调用
		* super.成员变量 调用父类的成员变量
	* b:调用成员方法
		* this.成员方法 调用本类的成员方法,也可以调用父类的方法
		* super.成员方法 调用父类的成员方法
	* c:调用构造方法
		* this(...)	 调用本类的构造方法, 构造方法不会被继承,所以this调用不了
		* super(...)  调用父类的构造方法	

###08.09_面向对象(继承中 构造方法的关系)(掌握)
* A:案例演示
	* 子类中所有的构造方法默认都会访问父类中空参数的构造方法
* B:为什么呢?
	* 因为子类会继承父类中的数据，可能还会使用父类的数据。
	* 所以，子类初始化之前，一定要先完成父类数据的初始化。    // 先父类数据初始化，再子类初始化
			super();    //这是一条语句，如果不写，系统会默认加上，用来访问父类中的空参构造。 
	* 其实：
		* 每一个构造方法的第一条语句默认都是：super()；  Object类是最顶层的父类。

###08.10_面向对象(继承中 构造方法的注意事项)(掌握) @@@
* A:案例演示
	父类没有无参构造方法,子类怎么办?
	* super解决
	* this解决
* B:注意事项
	* super(…)或者this(….)必须出现在构造方法的第一条语句上 //不能同时出现在第一行
	* 当第一条语句是this调用本类的构造方法时,通过调用别的构造方法实现super(),从而super()就在构造方法的第一句;
class Demo6_Extends {
	public static void main(String[] args) {
		Son s1 = new Son();
		System.out.println(s1.getName() + "..." + s1.getAge());   //子类无参构造通过访问到父类的有参的构造,  
		System.out.println("--------------------");
		Son s2 = new Son("张三",23);
		System.out.println(s2.getName() + "..." + s2.getAge());
	}
}
	class Father {
		private String name;			//姓名
		private int age;				//年龄
	
		/*public Father() {				//空参构造
			System.out.println("Father 空参构造");
		}*/
	
		public Father(String name,int age) {	//有参构造
			this.name = name;
			this.age = age;
			System.out.println("Father 有参构造");
		}
	
		public void setName(String name) {	//设置姓名
			this.name = name;
		}
	
		public String getName() {			//获取姓名
			return name;
		}
	
		public void setAge(int age) {		//设置年龄
			this.age = age;
		}
	
		public int getAge() {				//获取年龄
			return age;
		}
	}
	
	class Son extends Father {
		public Son() {						//空参构造
			this("王五",25);			//本类中的构造方法     只能传具体的,不能是this(name,age);
			//super("李四",24);			//调用父类中的构造方法
			System.out.println("Son 空参构造");
		}
	
		public Son(String name,int age) {	//有参构造
			super(name,age);   //super("name",age);与前面有区别, 
			System.out.println("Son 有参构造");
		}
	}

###08.11_面向对象(继承中的面试题)(掌握)
* A:案例演示		
看程序写结果1
		class Fu{
			public int num = 10;
			public Fu(){
				System.out.println("fu");
			}
		}
		class Zi extends Fu{
			public int num = 20;
			public Zi(){
				System.out.println("zi");
			}
			public void show(){
				int num = 30;
				System.out.println(num);
				System.out.println(this.num);
				System.out.println(super.num);
			}
		}
		class Test1_Extends {
			public static void main(String[] args) {
				Zi z = new Zi();
				z.show();
			}
		}

看程序写结果2
		class Fu {
			static {
				System.out.println("静态代码块Fu");
			}
	
			{
				System.out.println("构造代码块Fu");
			}
	
			public Fu() {
				System.out.println("构造方法Fu");
			}
		}
	
		class Zi extends Fu {
			static {
				System.out.println("静态代码块Zi");
			}
	
			{
				System.out.println("构造代码块Zi");
			}
	
			public Zi() {
				System.out.println("构造方法Zi");
			}
		}
	
		Zi z = new Zi(); 请执行结果。
	/*
	1,jvm调用了main方法,main进栈
	2,遇到Zi z = new Zi();会先将Fu.class和Zi.class分别加载进内存,再创建对象,当Fu.class加载进内存
	    父类的静态代码块会随着Fu.class一起加载,当Zi.class加载进内存,子类的静态代码块会随着Zi.class一起加载
	    第一个输出,静态代码块Fu,第二个输出静态代码块Zi
	3,走Zi类的构造方法,因为java中是分层初始化的,先初始化父类,再初始化子类,所以先走的父类构造,但是在执行
	   父类构造时,发现父类有构造代码块,构造代码块是优先于构造方法执行的所以
	   第三个输出构造代码块Fu,第四个输出构造方法Fu
	4,Fu类初始化结束,子类初始化,第五个输出的是构造代码块Zi,构造方法Zi
	*/

###08.12_面向对象(继承中 成员方法关系)(掌握)
* A:案例演示
	* a:不同名的方法   
	* b:同名的方法  ——可以重写    

###08.13_面向对象(方法重写概述及其应用)(掌握)
* A:什么是方法重写
	* 重写:子父类出现了一模一样的方法(注意:返回值类型可以是子父类,这个我们学完面向对象讲) 
* B:方法重写的应用：
	* 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法。这样，即沿袭了父类的功能，又定义了子类特有的内容。
* C:案例演示
	* a:定义一个手机类。

###08.14_面向对象(方法重写的注意事项)(掌握)
* A:方法重写注意事项
	* a:父类中私有方法不能被重写
		* 因为父类私有方法子类根本就无法继承
	* b:子类重写父类方法时，访问权限不能更低
		* 最好就一致
	* c:父类静态方法，子类也必须通过静态方法进行重写
		* 其实这个算不上方法重写，但是现象确实如此，至于为什么算不上方法重写，多态中我会讲解(静态只能覆盖静态)	
	* 子类重写父类方法的时候，最好声明一模一样。
* B:案例演示
	* 方法重写注意事项

###08.15_面向对象(方法重写的面试题)(掌握)
   方法重写的面试题
	* Override和Overload的区别?Overload能改变返回值类型吗?
	* overload可以改变返回值类型,只看参数列表
	* 方法重写：子类中出现了和父类中方法声明一模一样的方法。与返回值类型有关,返回值是一致(或者是子父类)的
	* 方法重载：本类中出现的方法名一样，参数列表不同的方法。与返回值类型无关。
	* 子类对象调用方法的时候：
		* 先找子类本身，再找父类。

###08.16_面向对象(使用继承前的学生和老师案例)(掌握)
* A:案例演示
	* 使用继承前的学生和老师案例
	* 属性:姓名,年龄
	* 行为:吃饭
	* 老师有特有的方法:讲课
	* 学生有特有的方法:学习

###08.17_面向对象(使用继承后的学生和老师案例)(掌握)
* A:案例演示
	* 使用继承后的学生和老师案例

###08.18_面向对象(猫狗案例分析,实现及测试)(掌握)
* A:猫狗案例分析
* B:案例演示
	* 猫狗案例继承版
	* 属性:毛的颜色,腿的个数
	* 行为:吃饭
	* 猫特有行为:抓老鼠catchMouse
	* 狗特有行为:看家lookHome


###08.19_面向对象(final关键字修饰类,方法以及变量的特点)(掌握)
* A:final概述
* B:final修饰特点
	* 修饰类，类不能被继承
	* 修饰变量，变量就变成了常量，只能被赋值一次
	* 修饰方法，方法不能被重写
* C:案例演示
	* final修饰特点

###08.20_面向对象(final关键字修饰局部变量)(掌握)
* A:案例演示
	* 方法内部或者方法声明上都演示一下(了解)
	* 基本类型，是值不能被改变
	* 引用类型，是地址值不能被改变,对象中的属性可以改变
		final int num = 10;
		//num = 20;  不能在赋值，只能是一次
		System.out.println(num); 

		final Person p = new Person("张三",23);
		//p = new Person("李四",24);  p记录的是地址值，不能再记录其他地址值，
		p.setName("李四");   可以修改对象的属性
		p.setAge(24);
		System.out.println(p.getName() + "..." + p.getAge());

		method(10); 方法调用后就弹栈了，这种在开发中没实际意义
		method(20);
	}
	public static void method(final int x) {
		System.out.println(x);   //使x在方法中不能被修改
	}

###08.21_面向对象(final修饰变量的初始化时机)(掌握)
* A:final修饰变量的初始化时机   public static final
	* 1.显示初始化（成员变量的默认初始化值是无效值）
	* 2.在对象构造完毕前即可(在对象构造方法完毕前就可以)   创建对象时会通过构造方法赋值,然后才打印,这样就不会出现未初始化变量.
	class Demo3_Final {
		public static void main(String[] args) {
			Demo d = new Demo();
			d.print();
		}
	}
	class Demo {
		final int num;	//成员变量的默认初始化值是无效值

		public void print() {
			System.out.println(num);
		}

		public Demo() {
			num = 10;
		}
		
	}
	
###08.22_day08总结
* 把今天的知识点总结一遍。
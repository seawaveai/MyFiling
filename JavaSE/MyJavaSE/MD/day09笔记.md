###09.01_面向对象(多态的概述及其代码体现)
* A:多态(polymorphic)概述
	* 事物存在的多种形态 
* B:多态前提
	* a:要有继承关系。
	* b:要有方法重写。
	* c:要有父类引用指向子类对象。
* C:案例演示
	* 代码体现多态
		
###09.02_面向对象(多态中的成员访问特点之 成员变量)
* 成员变量
	* 编译看左边(父类)，运行看左边(父类)。

###09.03_面向对象(多态中的成员访问特点之 成员方法)
* 成员方法
	* 编译看左边(父类)，运行看右边(子类)。动态绑定(如果父类没有这个方法，那么就会报错，编译主要是为了通过)
	* 编译看左边来判断是否通过，运行看右边也就是子类的方法进栈。

###09.04_面向对象(多态中的成员访问特点之 静态成员方法)@@
* 静态方法
	* 编译看左边(父类)，运行看左边(父类)。
	* (静态和类相关(可以类名.引用)，算不上重写，所以访问还是左边的)

    总结：只有非静态的成员方法,编译看左边,运行看右边 
class Demo2_Polymorphic {
	public static void main(String[] args) {
		/*Father f = new Son();					//父类引用指向子类对象
		System.out.println(f.num);

		Son s = new Son();
		System.out.println(s.num);*/

		Father f = new Son();
		f.print();		 	 //结果是son ,方法print不是静态的,运行时走的是子类
		f.method();		 //是Father.method()，就是类名.调用。 运行结果是father static method
	}
}
class Father {
	int num = 10;
	public void print() {
		System.out.println("father");
	}

	public static void method() {
		System.out.println("father static method");
	}
}

class Son extends Father {
	int num = 20;
	public void print() {
		System.out.println("son");
	}

	public static void method() {  //子类中可以没有这个方法，他会通过继承来拥有；但父类没有子类有是不可以的；
		System.out.println("son static method");
	}
}

###09.05_面向对象(超人的故事)  
* A:案例分析
	* 通过该案例帮助学生理解多态的现象     //父类引用指向子类对象，超人提升为人，向上转型。变大。

###09.06_面向对象(多态中向上转型和向下转型)
* A:案例演示
	* 详细讲解多态中向上转型和向下转型
	Person p = new SuperMan();向上转型  //变大  
	SuperMan sm = (SuperMan)p;向下转型  //变小

###09.07_面向对象(多态的好处和弊端) 
* A:多态的好处
	* a:提高了代码的维护性(继承保证)
	* b:提高了代码的扩展性(由多态保证)
	* c:可以当作形式参数,可以接收任意子类对象
* B:案例演示
	* 多态的好处
* C:多态的弊端
	* 不能使用子类的特有属性和行为。
* D:案例演示
	method(Animal a)
	method(Cat c)

public static void method(Animal a) {	//当作参数的时候用多态最好,因为扩展性强
		if (a instanceof Cat) {  //关键字 instanceof 判断前边的引用是否是后边的数据类型
			Cat c = (Cat)a;
			c.eat();
			c.catchMouse();
		}else if (a instanceof Dog) {
			Dog d = (Dog)a;
			d.eat();
			d.lookHome();
		}else {
			a.eat();
		}
	}

###09.08_面向对象(多态中的题目分析题)
* A:看下面程序是否有问题，如果没有，说出结果
		class Fu {
			public void show() {
				System.out.println("fu show");
			}
		}
	
		class Zi extends Fu {
			public void show() {
				System.out.println("zi show");
			}
	
			public void method() {
				System.out.println("zi method");
			}
		}
	
		class Test1Demo {
			public static void main(String[] args) {
				Fu f = new Zi();
				f.method();
				f.show();
			}
		}
* B:看下面程序是否有问题，如果没有，说出结果
* 
		class A {
			public void show() {
				show2();
			}
			public void show2() {
				System.out.println("我");
			}
		}
		class B extends A {
			public void show2() {
				System.out.println("爱");
			}
		}
		class C extends B {
			public void show() {
				super.show();
			}
			public void show2() {
				System.out.println("你");
			}
		}
		public class Test2DuoTai {
			public static void main(String[] args) {
				A a = new B();
				a.show();
				
				B b = new C();
				b.show();
			}
		}

###09.09_面向对象(抽象类的概述及其特点)
* A:抽象类概述
	* 抽象就是看不懂的 
* B:抽象类特点
	* a:抽象类和抽象方法必须用abstract关键字修饰
		* abstract class 类名 {}
		* public abstract void eat();
	* b:抽象类不一定有抽象方法，有抽象方法的类一定是抽象类或者是接口
	* c:抽象类不能实例化,那么抽象类如何实例化呢?
		* 按照多态的方式，由具体的子类实例化。其实这也是多态的一种，抽象类多态。
	* d:抽象类的子类
		* 要么是抽象类
		* 要么重写抽象类中的所有抽象方法
* C:案例演示
	* 抽象类特点

###09.10_面向对象(抽象类的成员特点)
* A:抽象类的成员特点
	* a:成员变量：既可以是变量，也可以是常量。abstract是否可以修饰成员变量?不能修饰成员变量
	* b:构造方法：有。
		* 用于子类访问父类数据的初始化。
	* c:成员方法：既可以是抽象的，也可以是非抽象的。
* B:案例演示
	* 抽象类的成员特点
* C:抽象类的成员方法特性：
	* a:抽象方法 强制要求子类做的事情。
	* b:非抽象方法 子类继承的事情，提高代码复用性。

###09.11_面向对象(葵花宝典)
* 案例演示
	* 抽象类的作用 
###09.12_面向对象(抽象类练习猫狗案例)
* A:案例演示
	* 具体事物：猫，狗
	* 共性：姓名，年龄，吃饭
	* 猫的特性:抓老鼠
	* 狗的特性:看家

###09.13_面向对象(抽象类练习老师案例)
* A:案例演示
	* 具体事物：基础班老师，就业班老师
	* 共性：姓名，年龄，讲课。
	* 具体事物:基础班学生,就业班学生
	* 共性:姓名,年龄,学习

###09.14_面向对象(抽象类练习员工案例)
* A:案例演示
	* 假如我们在开发一个系统时需要对程序员类进行设计，程序员包含3个属性：姓名、工号以及工资。
	* 经理，除了含有程序员的属性外，另为还有一个奖金属性。
	* 请使用继承的思想设计出程序员类和经理类。要求类中提供必要的方法进行属性访问。

###09.15_面向对象(抽象类中的面试题)
* A:面试题1
	* 一个抽象类如果没有抽象方法，可不可以定义为抽象类?如果可以，有什么意义?
	* 可以
	* 这么做目的只有一个,就是不让其他类创建本类对象,交给子类完成
* B:面试题2
	abstract不能和哪些关键字共存
	* abstract和static
		被abstract修饰的方法没有方法体
		被static修饰的可以用类名.调用,但是类名.调用抽象方法是没有意义的
	* abstract和final
		被abstract修饰的方法强制子类重写
		被final修饰的不让子类重写,所以他俩是矛盾
	* abstract和private
		被abstract修饰的是为了让子类看到并强制重写
		被private修饰不让子类访问,所以他俩是矛盾的

###09.16_面向对象(接口的概述及其特点)
* A:接口概述
	* 从狭义的角度讲就是指java中的interface
	* 从广义的角度讲对外提供规则的都是接口 
* B:接口特点
	* a:接口用关键字interface表示	
		* interface 接口名 {}
	* b:类实现接口用implements表示
		* class 类名 implements 接口名 {}
	* c:接口不能实例化，调用抽象方法没有意义
		* 那么，接口如何实例化呢?
		* 按照多态的方式来实例化。
	* d:接口的子类
		* a:可以是抽象类。但是意义不大。
		* b:可以是具体类。要重写接口中的所有抽象方法。(推荐方案)
* C:案例演示
	* 接口特点

###09.17_面向对象(接口的成员特点)
* A:接口成员特点
	* 成员变量；只能是常量，并且是静态的并公共的。
			* 默认修饰符：public static final
			* 建议：自己手动给出。
	* 构造方法：接口没有构造方法。
			* 接口中不写继承任何类，默认继承Object,extends Object;
	* 成员方法：只能是抽象方法。
			* 默认修饰符：public abstract
			* 建议：自己手动给出。
* B:案例演示
	* 接口成员特点

###09.18_面向对象(类与类,类与接口,接口与接口的关系)
* A:类与类,类与接口,接口与接口的关系
	* a:类与类：
		* 继承关系,只能单继承,可以多层继承。
	* b:类与接口：
		* 实现关系,可以单实现,也可以多实现。
		* 并且还可以在继承一个类的同时实现多个接口。
	* c:接口与接口：
		* 继承关系,可以单继承,也可以多继承。
* B:案例演示
	* 类与类,类与接口,接口与接口的关系

###09.19_面向对象(抽象类和接口的区别)
* A:成员区别
	* 抽象类：
		* 成员变量：可以变量，也可以常量
		* 构造方法：有
		* 成员方法：可以抽象，也可以非抽象
	* 接口：
		* 成员变量：只可以常量
		* 构造方法：无
		* 成员方法：只可以抽象
		
* B:关系区别
	* 类与类
		* 继承，单继承
	* 类与接口
		* 实现，单实现，多实现
	* 接口与接口
		* 继承，单继承，多继承
	* Java中是支持多继承的（接口和接口就是）。	
	
* C:设计理念区别
	* 抽象类 被继承体现的是：”is a”的关系。抽象类中定义的是该继承体系的共性功能。
	* 接口 被实现体现的是：”like a”的关系。接口中定义的是该继承体系的扩展功能。

###09.20_面向对象(猫狗案例加入跳高功能分析及其代码实现)
* A:案例演示
	* 动物类：姓名，年龄，吃饭，睡觉。
	* 猫和狗
	* 动物培训接口：跳高

###09.21_day09总结
* 把今天的知识点总结一遍。
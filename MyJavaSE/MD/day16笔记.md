###16.01_集合框架(去除ArrayList中重复字符串元素方式)(掌握)
* A:案例演示
	* 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
	* 思路：创建新集合方式
 			/**
			 *  A:案例演示
			 * 需求：ArrayList去除集合中字符串的重复值(字符串的内容相同)
			 * 思路：创建新集合方式
			 */
			public static void main(String[] args) {
				ArrayList list = new ArrayList();
				list.add("a");
				list.add("a");
				list.add("b");
				list.add("b");
				list.add("b");
				list.add("c");
				list.add("c");
				list.add("c");
				list.add("c");
				
				System.out.println(list);
				ArrayList newList = getSingle(list);
				System.out.println(newList);
			}
		
			/*
			 * 去除重复
			 * 1,返回ArrayList
			 * 2,参数列表ArrayList
			 */
			public static ArrayList getSingle(ArrayList list) {
				ArrayList newList = new ArrayList();			//创建一个新集合
				Iterator it = list.iterator();					//获取迭代器
				while(it.hasNext()) {							//判断老集合中是否有元素
					String temp = (String)it.next();	//将每一个元素临时记录住
					if(!newList.contains(temp)) {				//如果新集合中不包含该元素
						newList.add(temp);						//将该元素添加到新集合中
					}
				}
				return newList;									//将新集合返回
			}
###16.02_集合框架(去除ArrayList中重复自定义对象元素)(掌握)
* A:案例演示
	* 需求：ArrayList去除集合中自定义对象元素的重复值(对象的成员变量值相同)
* B:注意事项
	* 重写equals()方法的   //contains方法判断是否包含，底层是由equals实现的。
	* @override  public boolean equals(Object obj) {
					Peron p = (Person) obj;
					return this.name.equals(p.name) && this.age==p.age;
				}


###16.03_集合框架(LinkedList的特有功能)(掌握)
* A:LinkedList类概述
* B:LinkedList类特有功能
	* public void addFirst(E e)及addLast(E e)
	* public E getFirst()及getLast()
	* public E removeFirst()及public E removeLast()
	* public E get(int index);

###16.04_集合框架(栈和队列数据结构)(掌握)
* 栈
	* 先进后出 
* 队列
	* 先进先出

###16.05_集合框架(用LinkedList模拟栈数据结构的集合并测试)(掌握)@@@
* A:案例演示
	* 需求：请用LinkedList模拟栈数据结构的集合，并测试
	* 创建一个类将Linked中的方法封装
	* 
			public class Stack {
				private LinkedList list = new LinkedList();		//创建LinkedList对象
				
				public void in(Object obj) {
					list.addLast(obj);							//封装addLast()方法
				}
				
				public Object out() {
					return list.removeLast();					//封装removeLast()方法
				}
				
				public boolean isEmpty() {
					return list.isEmpty();						//封装isEmpty()方法
				}
			}
	

###16.06_集合框架(泛型概述和基本使用)(掌握)
* A:泛型概述
* B:泛型好处
	* 提高安全性(将运行期的错误转换到编译期) 
	* 黄线消失
	* 省去强转的麻烦
* C:泛型基本使用
	* <>中放的必须是引用数据类型 
* D:泛型使用注意事项
	* 前后的泛型必须一致,或者后面的泛型可以省略不写(1.7的新特性菱形泛型) 
	* 若定义Object类型可以接收任意类型，无意义，所以一般不定义成Object类型。 

###16.07_集合框架(ArrayList存储字符串和自定义对象并遍历泛型版)(掌握)
* A:案例演示
	* ArrayList存储字符串并遍历泛型版

###16.08_集合框架(泛型的由来)(了解)
* A:案例演示
	* 泛型的由来:通过Object转型问题引入
	* 早期的Object类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。也就存在这隐患，所以Java提供了泛型来解决这个安全问题。

###16.09_集合框架(泛型类的概述及使用)(了解)
* A:泛型类概述<T>
	* 把泛型定义在类上
* B:定义格式
	* public class 类名<泛型类型1,…>
	* public class Tool<Q>{
	  	....
	  }
* C:注意事项	
	* 泛型类型必须是引用类型
* D:案例演示
	* 泛型类的使用

###16.10_集合框架(泛型方法的概述和使用)(了解)@
* A:泛型方法概述
	* 把泛型定义在方法上
* B:定义格式	
	* public <泛型类型> 返回类型 方法名(泛型类型 变量名)  
	 public<T> void show(T t){
	  	System.out.println(t); 
	  }   
	public static<W> void print(W w){ 
		System.out.prinln(w);
	}
* C:案例演示
	* 泛型方法的使用            
 //非静态方法泛型最好与类的泛型一致；如果不一致，需要在方法上声明该泛型。
 //静态方法必须声明自己的泛型(随着类的加载而加载);一般是跟类的泛型不一样。和类的声明相同是可以的,一个是创建对象时赋值,一个是调用静态方法时赋值,相当于两个变量

###16.11_集合框架(泛型接口 的概述和使用)(了解)
* A:泛型接口概述
	* 把泛型定义在接口上
* B:定义格式	
	* public interface 接口名<泛型类型>  
* C:案例演示
	* 泛型接口的使用
//没有必要在实现接口的时候给自己类加泛型。所以一般随接口的泛型。
interface Inter<T> {
	public void show(T t);
}

/*class Demo implements Inter<String> {	  //推荐用这种
	@Override
	public void show(String t) {
		System.out.println(t);
	}	
}*/
class Demo<T> implements Inter<T> {	//没有必要在实现接口的时候给自己类加泛型
	@Override
	public void show(T t) {
		System.out.println(t);
	}	
}
###16.12_集合框架(泛型高级之通配符)(了解)
* A:泛型通配符<?>
	* 任意类型，如果没有明确，那么就是Object以及任意的Java类了  
	    List<?> list = new ArrayList<Integer>();	//当右边的泛型是不确定时,左边可以指定为?
* B:? extends E
	* 向下限定，E及其子类         
* C:? super E
	* 向上限定，E及其父类


###16.13_集合框架(增强for的概述和使用)(掌握)
* A:增强for概述
	* 简化数组和Collection集合的遍历 ，底层依赖的是叠加器
* B:格式：
		for(元素数据类型 变量 : 数组或者Collection集合) {
			使用变量即可，该变量就是元素
		}
* C:案例演示
	* 数组，集合存储元素用增强for遍历
* D:好处
	* 简化遍历

###16.14_集合框架(ArrayList存储字符串和自定义对象并遍历增强for版)(掌握)
* A:案例演示
	* ArrayList存储字符串并遍历增强for版
			ArrayList<String> list = new ArrayList<>();
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("d");
			for(String s : list) {
				System.out.println(s);
			}
###16.15_集合框架(三种迭代的能否删除)(掌握)

	* 普通for循环,可以删除,但是 索引要--（list.remove(i--);）。 //不会出现越界异常，因为--马上又++了。

	* 迭代器,可以删除,但是必须使用迭代器自身的remove方法,否则会出现并发修改异常

	* 增强for循环不能删除

###16.16_集合框架(静态导入的概述和使用)(掌握)jdk5.0新特新 @@
* A:静态导入概述 ,就是导入类中的静态方法
* B:格式：
	* import static 包名….类名.方法名;
	* import static java.util.Arrays.sort;	 //静态导入
	* import static java.util.Arrays.*;	 //把类中的静态方法都导入    
	* import static java.util.Arrays.toString;  //静态导入
* C:注意事项
	* 方法必须是静态的,如果有多个同名的静态方法，就不知道使用的是哪个?这个时候要使用，必须加前缀。由此可见，意义不大，所以一般不用，但是要能看懂。

###16.17_集合框架(可变参数 的概述和使用)(掌握)jdk5.0新特新  @@
* A:可变参数概述
	* 定义方法的时候不知道该定义多少个参数  //可以接收很多参数。。
* B:格式
	* 修饰符 返回值类型 方法名(数据类型…  变量名){}
* C:注意事项：
	* 这里的变量其实是一个数组
	* 如果一个方法有可变参数,还有多个参数,那么可变参数必须放在最后一个
print(11,22,33,44,55);
print(11,arr),  //arr是一个int数组,11是赋值给x的
public static void print(int x,int ... arr){
		for (int i : arr) {
			System.out.print(i+" ");
		}
	}

###16.18_集合框架(Arrays工具类的asList()方法的使用)(掌握) @@
* A:案例演示  ,数组转集合
	* Arrays工具类的asList()方法的使用                 
	* Collection中toArray(T[] a)泛型版的集合转数组     
//数组转换成集合虽然不能增加或减少元素，但是可以利用集合的思想操作数组，可以使用集合中的其他方法。
//基本数据类型的数组是把整个数组当成一个元素存入集合。所以数组转换成集合,数组必须是引用数据类型。
public class Demo4_AsList {
	public static void main(String[] args) {
		//demo1();
		//demo2();
		//集合转数组,加泛型的
		ArrayList<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		//String[] arr = list.toArray(new String[1]);	
			//Integer[] arr = al.toArray(new Integer[10]);
			//Object[] arr = al.toArray();
		String[] arr = list.toArray(new String[10]);		
		  //当集合转换数组时,数组长度如果是小于等于集合的size时,转换后的数组长度等于集合的size
		   //如果数组的长度大于了size,分配的数组长度就和你指定的长度一样
		for (String string : arr) {
			System.out.println(string);
		}
	}

	public static void demo2() {
		//int[] arr = {11,22,33,44,55};			
		//List<int[]> list = Arrays.asList(arr);	 //基本数据类型的数组转换成集合,会将整个数组当作一个对象转换
		//System.out.println(list);
		Integer[] arr = {11,22,33,44,55};	       //将数组转换成集合,数组必须是引用数据类型
		List<Integer> list = Arrays.asList(arr);
		System.out.println(list);
	}

	public static void demo1() {
		String[] arr = {"a","b","c"};
		List<String> list = Arrays.asList(arr);		//将数组转换成集合,是List集合接收
		//list.add("d");							//不能添加元素
		System.out.println(list);
	}
}

###16.19_集合框架(集合嵌套之ArrayList嵌套ArrayList)(掌握)
* A:案例演示
	* 集合嵌套之ArrayList嵌套ArrayList  //二维集合。。
	public static void main(String[] args) {
		ArrayList<ArrayList<Person>> list = new ArrayList<>();
		
		ArrayList<Person> first = new ArrayList<>();				//创建第一个班级
		first.add(new Person("杨幂", 30));
		first.add(new Person("李冰冰", 33));
		first.add(new Person("范冰冰", 20));
		
		ArrayList<Person> second = new ArrayList<>();
		second.add(new Person("黄晓明", 31));
		second.add(new Person("赵薇", 33));
		second.add(new Person("陈坤", 32));
		
		//将班级添加到学科集合中
		list.add(first);
		list.add(second);
		
		//遍历学科集合
		for(ArrayList<Person> a : list) {
			for(Person p : a) {
				System.out.println(p);
			}
		}
	}

###16.20_day16总结
* 把今天的知识点总结一遍。
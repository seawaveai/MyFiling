###03.01_Java语言基础(逻辑运算符的基本用法)(掌握)
* A:逻辑运算符有哪些
	*  & , 与
	*  | , 或
	*  ^ , 异或   两边相同为false,不同为true
	*  ! , 非
	
	* && , || 

* B:案例演示
* 逻辑运算符的基本用法	
* 注意事项：
	* a:逻辑运算符一般用于连接boolean类型的表达式或者值。
	* b:表达式：就是用运算符把常量或者变量连接起来的符合java语法的式子。
		* 算术表达式：a + b
		* 比较表达式：a == b(条件表达式)
* C:结论：
   &逻辑与:有false则false。
   |逻辑或:有true则true。
   ^逻辑异或:相同为false，不同为true。
   !逻辑非:非false则true，非true则false。
* 特点：偶数个不改变本身。

###03.02_Java语言基础(逻辑运算符&&和&的区别)(掌握)
* A:案例演示
	* &&和&的区别?
		* a:最终结果一样。
		* b:&&具有短路效果。左边是false，右边不执行
			&是无论左边是false还是true,右边都会执行
* B:同理||和|的区别?(学生自学)    $最终结果都一样,左边是true则不执行
* C:开发中常用谁?
	* &&, ||, !

###03.03_Java语言基础(位运算符的基本用法1)(了解)
* A:位运算符有哪些
	* &, |, ^, ~ , >>, >>>, <<
* B:案例演示
	* 位运算符的基本用法1
	
   &,|,^,~ 的用法
	* &:有0则0
	* |:有1则1
	* ^:相同则0，不同则1
	* ~:按位取反

###03.04_Java语言基础(位异或运算符的特点及面试题)(掌握)
* A:案例演示
	* 位异或运算符的特点
	* ^的特点：一个数据与另一个数据位异或两次，该数本身不变。
	
* B:面试题：
	* 请自己实现两个整数变量的交换(不要定义第三方变量)
      
	* 注意：以后讲课的过程中，我没有明确指定数据的类型，默认int类型。

###03.05_Java语言基础(位运算符的基本用法2及面试题)(了解)
* A:案例演示 >>,>>>,<<的用法:                               $$计算机存储的是补码,运算也是补码进行
	*  <<:左移	左边最高位丢弃，右边补齐0                    $向左移动几位就是乘以2的几次幂
	*  >>:右移	最高位是0，左边补齐0;最高为是1，左边补齐1     $向右移动几位就是除以2的几次幂
	*  >>>:无符号右移 无论最高位是0还是1，左边补齐0
    最有效率的算出2 * 8的结果
                     2<<3
在程序执行的过程中其值不可以发生改变
常量6种：1整型 2浮点 3字符 4字符串 5布尔 6null  
字符常量里面只能放单个数字或字母或标点符号，可以是空格符，但不能为空。

###03.06_Java语言基础(三元运算符的基本用法)(掌握)
* A:三元运算符的格式
* 		(关系表达式) ? 表达式1 : 表达式2;
* B:三元运算符的执行流程 
* C:案例演示
	* 获取两个数中的最大值 
	* 获取两个数中的最小值 
    int a = 10;
    int b = 5;
       int c = (a>b) ? a : b;    
	   int c = (a>b) ? b : a;  
###03.07_Java语言基础(三元运算符的练习)(掌握)
* A:案例演示
	* 比较两个整数是否相同       boolean d = (a==b) ? true : false;
	                           boolean d = (a==b) ;
                                   boolean d = (a==b) ? : ;  //不行。
* B:案例演示
	* 获取三个整数中的最大值
	int a=10,b=20,c=30 ;	
	int temp = (a>b) ? a : b ; 
	int max = (temp>c) ? temp : c ;
	System.out.println(max);

###03.08_Java语言基础(键盘录入的基本格式讲解)(掌握)
* A:为什么要使用键盘录入数据
	* a:为了让程序的数据更符合开发的数据
	* b:让程序更灵活一下
* B:如何实现键盘录入呢?
	* 先照格式来。
	 a:导包		
	 b:创建键盘录入对象	
	 c:通过对象获取数据	
		
* C:案例演示
	* 键盘录入1个整数，并输出到控制台。
	* 键盘录入2个整数，并输出到控制台。

###03.09_Java语言基础(键盘录入的练习1)(掌握)
* A:案例演示
	* 键盘录入练习：键盘录入两个数据，并对这两个数据求和，输出其结果
* B:案例演示
	* 键盘录入练习：键盘录入两个数据，获取这两个数据中的最大值

###03.10_Java语言基础(键盘录入的练习2)(掌握)
* A:案例演示
	* 键盘录入练习：键盘录入两个数据，比较这两个数据是否相等
* B:案例演示
	* 键盘录入练习：键盘录入三个数据，获取这三个数据中的最大值

###03.11_Java语言基础(顺序结构语句) (了解)
* A:什么是流程控制语句
	* 流程控制语句：可以控制程序的执行流程。
* B:流程控制语句的分类
	* 顺序结构
	* 选择结构
	* 循环结构
* C:执行流程：
	* 从上往下，依次执行。
* D:案例演示
	* 输出几句话看效果即可

###03.12_Java语言基础(选择结构if语句格式1及其使用)(掌握)
* A:选择结构的分类
	* if语句
	* switch语句
* B:if语句有几种格式
	* 格式1
	* 格式2
	* 格式3
* C:if语句的格式1
* 
		if(比较表达式) {
			语句体;
		}
* D:执行流程：
	* 先计算比较表达式的值，看其返回值是true还是false。
	* 如果是true，就执行语句体；
	* 如果是false，就不执行语句体；

###03.13_Java语言基础(选择结构if语句注意事项)(掌握) $$
    if语句注意事项
	* a:比较表达式无论简单还是复杂，结果必须是boolean类型
	* b:if语句控制的语句体如果是一条语句，大括号可以省略    //如果是多条语句，就不能省略。建议永远不要省略。
	* c:一般来说：有左大括号就没有分号，有分号就没有左大括号   

###03.14_Java语言基础(选择结构if语句格式2及其使用)(掌握)
* A:if语句的格式2
		if(比较表达式) {
			语句体1;
		}else {
			语句体2;
		}
* B:执行流程：
	* 首先计算比较表达式的值，看其返回值是true还是false。
	* 如果是true，就执行语句体1；
	* 如果是false，就执行语句体2；
* C:案例演示
	* a:获取两个数据中较大的值
	* b:判断一个数据是奇数还是偶数,并输出是奇数还是偶数
	*  注意事项：else后面是没有比较表达式的，只有if后面有。

###03.15_Java语言基础(if语句的格式2和三元的相互转换问题)(掌握)
* A:案例演示
	* if语句和三元运算符完成同一个效果
* B:案例演示
	* if语句和三元运算符的区别
	
	* 三元运算符实现的，都可以采用if else语句实现。反之不成立。
	
	* 什么时候if语句实现不能用三元改进呢?
		* 当if语句控制的操作是一个输出语句的时候就不能。
	    	为什么呢 ? 因为三元运算符是一个运算符，运算符操作完毕就应该有一个结果，而不是一个输出。

###03.16_Java语言基础(选择结构if语句格式3及其使用)(掌握)
* A:if语句的格式3：
		if(比较表达式1) {
			语句体1;
		}else if(比较表达式2) {
			语句体2;
		}else if(比较表达式3) {
			语句体3;
		}
		...
		else {
			语句体n+1;
		}
* B:执行流程：
	* 首先计算比较表达式1看其返回值是true还是false，
	* 如果是true，就执行语句体1，if语句结束。
	* 如果是false，接着计算比较表达式2看其返回值是true还是false，
	
	* 如果是true，就执行语句体2，if语句结束。
	* 如果是false，接着计算比较表达式3看其返回值是true还是false，
	
	* 如果都是false，就执行语句体n+1。
* C:注意事项:最后一个else可以省略,但是建议不要省略,可以对范围外的错误值提示 

###03.17_Java语言基础(选择结构if语句格式3练习)(掌握)
* A:练习1
* 
		需求：键盘录入一个成绩，判断并输出成绩的等级。
		90-100 优
		80-89  良
		70-79  中
		60-69  及
		0-59   差
		
* B:练习2
	* 需求：
		* 键盘录入x的值，计算出y的并输出。
		
		* x>=3	y = 2 * x + 1;
		* -1<x<3	y = 2 * x;
		* x<=-1	y = 2 * x - 1;

###03.18_Java语言基础(选择结构if语句的嵌套使用)(掌握)
* A:案例演示
	* 需求：获取三个数据中的最大值
	* if语句的嵌套使用。

###03.19_Java语言基础(选择结构switch语句的格式及其解释)(掌握)
* A:switch语句的格式
* 
		switch(表达式) {
		        case 值1：
				语句体1;
				break;

			    case 值2：
				语句体2;
				break;

			    …

			    default：	
				语句体n+1;
				break;
	    }
 
* B:switch语句的格式解释
* C:面试题
	* byte可以作为switch的表达式吗?     //基本数据类型中能转换成int类型的都可以
	* long可以作为switch的表达式吗?     //不可以
	* String可以作为switch的表达式吗?   //JDK7.0版本可以接收，JDK5.0可以接收枚举
* C:执行流程
	* 先计算表达式的值
	* 然后和case后面的匹配，如果有就执行对应的语句，否则执行default控制的语句

###03.20_Java语言基础(选择结构switch语句的练习)(掌握)
* A:整数(给定一个值,输出对应星期几)

###03.21_Java语言基础(选择结构switch语句的注意事项)(掌握)
* A:案例演示
	* a:case后面只能是常量，不能是变量;而且case后面的值不能相同的
	* b:default可以省略吗?
		* 可以省略，但是不建议，因为它的作用是对不正确的情况给出提示。
		* 特殊情况：
			* case就可以把值固定。
			* A,B,C,D
	* c:break可以省略吗?
		* 最后一个可以省略,其他最好不要省略
		* 会出现一个现象：case穿透。
		* 最终我们建议不要省略
	* d:default一定要在最后吗?
		* 不是，可以在任意位置,先执行case,然后是default。但是建议在最后。
	* e:switch语句的结束条件
		* a:遇到break就结束了
		* b:执行到switch的右大括号就结束了
 //default在前面时，若没有break也会穿透； 若有匹配的值，则按顺序执行，不会再跳转到default.
//default在后面时，若case没有break，也会执行default里的代码

###03.22_Java语言基础(选择结构switch语句练习)(掌握)
* A:看程序写结果：
		int x = 2;
		int y = 3;
		switch(x){
			default:
				y++;
				break;
			case 3:
				y++;
			case 4:
				y++;
		}
		System.out.println("y="+y);
	
* B:看程序写结果：
		int x = 2;
		int y = 3;
		switch(x){
			default:
				y++;
			case 3:
				y++;
			case 4:
				y++;
		}
		System.out.println("y="+y);

###03.23_Java语言基础(选择结构if语句和switch语句的区别)(掌握)
* A:总结switch语句和if语句的各自使用场景
* 	switch建议判断固定值的时候用
* 	if建议判断区间或范围的时候用
* B:案例演示
	* 分别用switch语句和if语句实现下列需求：
	   键盘录入月份，输出对应的季节

import java.util.Scanner;
class Monthyuefen {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入正确的月份，范围在1-12");
		int month = sc.nextInt();
		switch(month) {
			case 3:
			case 4:
			case 5:   //可以利用穿透来实现几个
				System.out.println("这个季节是春季");
			break;
			default:
				System.out.println("你输入的月份有误，没有这个季节");

		
		}
	}
}

###03.24_day03总结
把今天的知识点总结一遍。
/**
 * 
 */
package seawave.day12.scanner;

import java.util.Scanner;

/**
 * @author Xikang61
 * 
 */
public class Demo1_Scanner {
	
	public static void main(String[] args) {
		System.out.println("  --------------000  ");
		
		Scanner sc = new Scanner(System.in);
		
		if (sc.hasNextInt()) {     // 判断键盘录入的是否是int类型的数据
			int i = sc.nextInt();  // 键盘录入的数据存储在i中
			System.out.println(i);
		} else {
			System.out.println("输入的类型错误");
		}
		
		System.out.println("  --------------111  ");
	}
}

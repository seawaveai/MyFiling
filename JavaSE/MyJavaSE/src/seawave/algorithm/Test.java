/**
 * 
 */
package seawave.algorithm;

/**
 * @author Xikang61
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoubleLink dd = new DoubleLink();
		dd.add(1111);
		dd.add("aaa");
		dd.add(1111);
		dd.add("aaa");
		
		System.out.println(dd.contains("aaa"));
		//dd.remove(1111); 
		System.out.println("=========="+dd.toString());
		
		
		
	}

}

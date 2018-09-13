###12.01_常见对象(Scanner的概述和方法介绍)(掌握)
* A:Scanner的概述
* B:Scanner的构造方法原理
	* Scanner(InputStream source)
	* System类下有一个静态的字段：
		* public static final InputStream in; 标准的输入流，对应着键盘录入。

* C:一般方法
	* hasNextXxx() 判断是否还有下一个输入项,其中Xxx可以是Int,Double等。如果需要判断是否包含下一个字符串，则可以省略Xxx
	* nextXxx() 获取下一个输入项。Xxx的含义和上个方法中的Xxx相同,默认情况下，Scanner使用空格，回车等作为分隔符
	
	if(sc.hasNextInt()) {	//判断键盘录入的是否是int类型的数据
			int i = sc.nextInt();	//键盘录入的数据存储在i中
			System.out.println(i);
		}else {
			System.out.println("输入的类型错误");
		}

###12.02_常见对象(Scanner获取数据出现的小问题及解决方案)(掌握)
* A:两个常用的方法：
	* public int nextInt(): 获取一个int类型的值
	* public String nextLine(): 获取一个String类型的值
* B:案例演示
	* a:先演示获取多个int值，多个String值的情况
	* b:再演示先获取int值，然后获取String值,此会出现问题
	* c:问题解决方案
		* 第一种：先获取一个数值后，在创建一个新的键盘录入对象获取字符串。
		* 第二种：把所有的数据都先按照字符串获取，然后要什么，你就对应的转换为什么。(后面讲)
	
###12.03_常见对象(String类的概述)(掌握)
* A:String类的概述	
	* 通过JDK提供的API，查看String类的说明
	
	* 可以看到这样的两句话。
		* a:字符串字面值"abc"也可以看成是一个字符串对象。
		* b:字符串是常量，一旦被赋值，就不能被改变。
		
    ""是字符串常量，同时也是一个String类的对象。可以调用String中的方法。
	null是空常量，不能调用任何方法，否则会出现空指针异常。

###12.04_常见对象(String类的构造方法)(掌握)  
* A:常见构造方法     //int index是索引号
	* public String(): 空构造
	* public String(byte[] bytes): 把字节数组转成字符串    //在-128到127之间，然后转成相应的…  		   
	* public String(byte[] bytes,int index,int length): 把字节数组的一部分转成字符串  new String(arr2,2,3);  
	
	* public String(char[] value): 把字符数组转成字符串            new String(arr3);
	* public String(char[] value,int index,int count): 把字符数组的一部分转成字符串	    new String(arr3,5,4);
	       char[] arr2 = {48,65,97,6,1};
		   String str2 = new String(arr2);
	* public String(String original): 把字符串常量值转成字符串  //有引号变没有
						String s6 = new String("heimaHEIMA");
						System.out.println(s6);
* B:案例演示	
	* 演示String类的常见构造方法

###12.05_常见对象(String类的常见面试题)(掌握)
* 1.判断定义为String类型的s1和s2是否相等
	* String s1 = "abc";                 // 常量池中没有就创建，有就直接用
	* String s2 = "abc";
	* System.out.println(s1 == s2);   // true 都是指向常量池					
	* System.out.println(s1.equals(s2));   //true		
* 2.下面这句话在内存中创建了几个对象?
	* String s1 = new String("abc");      //在常量池和堆中都有，而在堆中相当于副本,所以是创建了2个对象。			
* 3.判断定义为String类型的s1和s2是否相等
	* String s1 = new String("abc");	 //堆中的		
	* String s2 = "abc";    //常量池中的
	* System.out.println(s1 == s2);     //false ,一个记录的是堆内存中的,一个是记录的是常量池中的,地址值不相同	
	* System.out.println(s1.equals(s2));   //对象的属性相同,true
* 4.判断定义为String类型的s1和s2是否相等
	* String s1 = "a" + "b" + "c";
	* String s2 = "abc";
	* System.out.println(s1 == s2);  	// true , java中有常量优化机制	如:byte b = 3 + 4; 在编译时就变成了7,常量优化机制
	* System.out.println(s1.equals(s2));  // true 
* 5.判断定义为String类型的s1和s2是否相等
	* String s1 = "ab";    //常量池
	* String s2 = "abc";   //常量池
	* String s3 = s1 + "c";   //先在StringBuffer或StringBuilder相加,然后通过toString转换,再赋地址值给s3
	* System.out.println(s3 == s2);  //false 
	* System.out.println(s3.equals(s2)); // true
		* Java 语言提供对字符串串联符号（"+"）以及将其他对象转换为字符串的特殊支持。字符串串联是通过 StringBuilder（或 StringBuffer）类及其 
		append 方法实现的。字符串转换是通过 toString 方法实现的

###12.06_常见对象(String类的 判断功能)(掌握)
* A:String类的判断功能
	* boolean equals(Object obj): 比较字符串的内容是否相同,区分大小写
	* boolean equalsIgnoreCase(String str): 比较字符串的内容是否相同,忽略大小写
	* boolean contains(String str): 判断大字符串中是否包含小字符串  
	
	* boolean startsWith(String str): 判断字符串是否以某个指定的字符串开头
	* boolean endsWith(String str): 判断字符串是否以某个指定的字符串结尾   
	* boolean isEmpty(): 判断字符串是否为空。  // ""里面不能有任何东西，空格也是元素。
	   

###12.07_常见对象(模拟用户登录)(掌握)
* A:案例演示
	* 需求：模拟登录,给三次机会,并提示还有几次。
	* 用户名和密码都是admin

###12.08_常见对象(String类的 获取功能)(掌握)
* A:String类的获取功能
	* int  length(): 获取字符串的长度。  //注意length是属性    字符的个数
	* char charAt(int index): 获取指定索引位置的字符        //字符串索引越界异常
	
	* int  indexOf(int ch): 返回指定字符在此字符串中第一次出现处的索引。    //如果不存在，返回的是-1   //这个方法StringBuffer没有
	* int  indexOf(String str): 返回指定字符串在此字符串中第一次出现处的索引。
	
	* int  indexOf(int ch,int fromIndex): 返回指定字符在此字符串中从指定位置后第一次出现处的索引。  //这个方法StringBuffer没有
	* int  indexOf(String str,int fromIndex): 返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
	  lastIndexOf 从后向前找，第一次出现的字符

	* String substring(int start):从指定位置开始截取字符串,默认到末尾。   //substring会产生一个新的字符串，需要新的记录，不然……
	* String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。  //包含开头，不包含右。左闭右开 //substring会产生新的字符串，用新的对象打印
	* String[] string  split( );  //进行分割，注意分割后字符串数组的长度。

		StringBuffer st = new StringBuffer();
		for(char i=0;i<256;i++){
			st.append(i);	
		}   
		String s = st.substring(0);
		int index = s.indexOf(" ");
		int index1 = s.indexOf('!');
		System.out.println(index);
		System.out.println(index1);	                                                                       

###12.09_常见对象(字符串的遍历)(掌握)
* A:案例演示
	* 需求：遍历字符串
	public static void main(String[] args) {
		String st = "avsaa123";
		for(int i=0;i<st.length();i++) {
			System.out.print(st.charAt(i)+" ");
		}
	}
	
###12.10_常见对象(统计不同类型字符个数)(掌握) 
* A:案例演示
	* 需求：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数,其他字符出现的次数。
	* ABCDEabcd123456!@#$%^   
方法二：
		for (int i = 0; i < sb.length(); i++) {
			char c  = sb.charAt(i);
			if(Character.isLetter(c)){
				if(Character.isLowerCase(c)){
					small++;
				}else if(Character.isUpperCase(c)){
					big++;
				}
			}else if(Character.isDigit(c)){
				sum++;
			}else{
				other++;
			}	
		}

###12.11_常见对象(String类的 转换功能)(掌握)
   String的转换功能：
	* byte[]  getBytes(): 把字符串转换为字节数组。  //字节是-128到127  把我们看的懂的转换成计数机看的懂得  gbk码表一个中文代表两个字节，第一个字节肯定是负。
	* char[]  toCharArray(): 把字符串转换为字符数组。

	* static String valueOf(char[] chs): 把字符数组转成字符串.是基于String构造方法完成的 //String s = 	String.valueOf(arr); copyValueOf(char data[])和valueOf功能是一样的。
	* static String valueOf(int i): 把int类型的数据转成字符串(byte.short会提升为int类型)。
	    * 注意：String类的valueOf方法可以把任意类型的数据转成字符串。

	* String toLowerCase():把字符串转成小写。(了解)  //注意打印     String s1 = "heiMA"; String s2 = s1.toLowerCase(); System.out.println(s2);
	* String toUpperCase():把字符串转成大写。                     
	* String concat(String str):把字符串拼接。  (s1.concat(s2)); 只能是字符 没有+强大。 
	
###12.12_常见对象(按要求转换字符)(链式编程掌握)     
* A:案例演示
	* 需求：把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
	        String s = "woAiHeiMa128";
		String s1 =s.substring(0, 2).toUpperCase().concat(s.substring(1).toLowerCase());  //只要保证每次调用完方法返回的是对象，就可以继续调用。
		System.out.println(s1);
	* 把字符串中的字母大小写转换后再输出
###12.13_常见对象(把数组转成字符串)
* A:案例演示
	* 需求：把数组中的数据按照指定个格式拼接成一个字符串
		* 举例： int[] arr = {1,2,3};	
		* 输出结果： ."[1, 2, 3]"
		int[] arr = {1,2,3,4};
		String s = "[";
		for(int i=0;i<arr.length;i++) {
			if(i==arr.length-1) {
				s = s+arr[i]+"]";
			}else{
			s =s + arr[i]+" ,";
			}
		}
		System.out.print(s);

###12.14_常见对象(String类的 其他功能)
* A:String的替换功能及案例演示
	* String replace(char old,char new)     // 若不存在，原字符不变
	* String replace(String old,String new)  // 一个是'' , 一个是"" .
	         String s =" heima heima ";
		 String s1=s.replace(' ','i');
		 System.out.println(s1);
	
* B:String的去除字符串 两端的空格及案例演示
	* String trim()    
		//String s =" heima heima ";
		  String s1=s.trim();
	
* C:String的按字典顺序比较两个字符串及案例演示  ？
	* int compareTo(String str)(暂时不用掌握)        //相同则比后面的，全部相同则比较个数。
	* int compareToIgnoreCase(String str)(了解) 
	
###12.15_常见对象(字符串反转)
* A:案例演示
	* 需求：把字符串反转
		* 举例：键盘录入"abc"		
		* 输出结果："cba"

###12.16_常见对象(在大串中查找小串出现的次数思路图解)
* A:画图演示
	* 需求：统计大串中小串出现的次数
	* 这里的大串和小串可以自己根据情况给出

###12.17_常见对象(在大串中查找小串出现的次数代码实现)
* A:案例演示	
	* 统计大串中小串出现的次数
	* while((index = max.indexOf(min))!= -1){
			max = max.substring(index+min.length());
			count++;
		}

###12.18_day12总结
* 把今天的知识点总结一遍。
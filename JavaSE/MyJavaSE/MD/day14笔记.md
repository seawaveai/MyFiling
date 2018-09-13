###14.01_常见对象(正则表达式的概述和简单使用)
* A:正则表达式
	* 是指一个用来描述或者匹配一系列符合某个语法规则的字符串的单个字符串。其实就是一种规则。有自己特殊的应用。
	* 作用:比如注册邮箱,邮箱有用户名和密码,一般会对其限制长度,这个限制长度的事情就是正则表达式做的
* B:案例演示
	* 需求：校验qq号码.
		* 1:要求必须是5-15位数字
		* 2:0不能开头
		* 3:必须都是数字
	* a:非正则表达式实现
	* b:正则表达式实现	  boolean  matches(String regex) ,告知此字符串是否匹配给定的正则表达式。
		String regex = "[1-9]\\d{4,14}";
		System.out.println("2553868".matches(regex));
		System.out.println("012345".matches(regex));
		System.out.println("2553868abc".matches(regex));

###14.02_常见对象(字符类演示)
* A:字符类
	* [abc] a、b 或 c（简单类） 
	* [^abc] 任何字符，除了 a、b 或 c（否定） 
	* [a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围） 
	* [0-9] 0到9的字符都包括

###14.03_常见对象(预定义字符类演示)
* A:预定义字符类
	* . 任何字符。
	* \d 数字：[0-9]
	* \w 单词字符：[a-zA-Z_0-9]
	* \s 空白字符: [ \r\n\f\x0B\t]  \f翻页  \x0b竖直
	
###14.04_常见对象(数量词)
* A:Greedy 数量词 
	* X?  X，一次或一次也没有
	* X*  X，零次或多次(0次到多次)
	* X+  X，一次或多次
	* X{n}  X，恰好 n 次 
	* X{n,}  X，至少 n 次 
	* X{n,m}  X，至少 n 次，但是不超过 m 次 

###14.05_常见对象(正则表达式的分割功能)   
* A:正则表达式的分割功能
	* String类的功能：public String[] split(String regex)
* B:案例演示
	* 正则表达式的分割功能      "." 与 "\\."

###14.06_常见对象(把给定字符串中的数字排序)
* A:案例演示
	* 需求：我有如下一个字符串:”91 27 46 38 50”，请写代码实现最终输出结果是：”27 38 46 50 91”
	 * 100
	 * 80
	 * 分析:
	 * 1,将字符串切割成字符串数组
	 * 2,将字符串转换成数字并将其存储在一个等长度的int数组中
	 * 3,排序
	 * 4,将排序后的结果遍历并拼接成一个字符串
	 */
	public static void main(String[] args) {
		String s = "91 27 46 38 50";
		//1,将字符串切割成字符串数组
		String[] sArr = s.split(" ");
		//2,将字符串转换成数字并将其存储在一个等长度的int数组中
		int[] arr = new int[sArr.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(sArr[i]); 	//将数字字符串转换成数字
		}
		
		//3,排序
		Arrays.sort(arr);
		
		//4,将排序后的结果遍历并拼接成一个字符串27 38 46 50 91
		/*String str = "";
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				str = str + arr[i];				//27 38 46 50 91
			}else {
				str = str + arr[i] + " ";		//27 38 46 50 
			}
		}
		
		System.out.println(str);*/
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				sb.append(arr[i]);
			}else {
				sb.append(arr[i] + " ");
			}
		}
		
		System.out.println(sb);
	}

###14.07_常见对象(正则表达式的替换功能)
* A:正则表达式的替换功能
	* String类的功能：public String replaceAll(String regex,String replacement)
* B:案例演示
	* 正则表达式的替换功能

###14.08_常见对象(正则表达式的分组功能)
* A:正则表达式的分组功能
	* 捕获组可以通过从左到右计算其开括号来编号。例如，在表达式 ((A)(B(C))) 中，存在四个这样的组： 
		1     ((A)(B(C))) 
		2     (A     ?    
		3     (B(C)) 
		4     (C) 
	 组零始终代表整个表达式。
B:案例演示
	a:切割
		需求：请按照叠词切割： "sdqqfgkkkhjppppkl";
	b:替换
		需求：我我....我...我.要...要要...要学....学学..学.编..编编.编.程.程.程..程
		将字符串还原成:“我要学编程”。

###14.09_常见对象(Pattern和Matcher的概述)
* A:Pattern和Matcher的概述
* B:模式和匹配器的典型调用顺序
	* 通过JDK提供的API，查看Pattern类的说明

	* 典型的调用顺序是 
	* Pattern p = Pattern.compile("a*b"); //将给定的正则表达式编译到模式中。
	* Matcher m = p.matcher("aaaaab");  //
	* boolean b = m.matches(); 

###14.10_常见对象(正则表达式的获取功能)
* A:正则表达式的获取功能
	* Pattern和Matcher的结合使用
* B:案例演示
	* 需求：把一个字符串中的手机号码获取出来
	    	String s = "我的手机号是13657087273,曾经用过12779862756,也用过13607931110";
		String regex = "1[368]\\d{9}";
		Pattern p = Pattern.compile(regex);  //获取正则表达式
		Matcher m = p.matcher(s);    	//获取匹配器
		while(m.find())  //查找
			System.out.println(m.group()); //获取

###14.11_常见对象(Math类概述和方法使用)
* A:Math类概述   lang包下，1.0版本， 静态的方法
	* Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 
* B:成员方法
	* public static int abs(int a)
	* public static double ceil(double a)
	* public static double floor(double a)
	* public static int max(int a,int b) min自学
	* public static double pow(double a,double b)
	* public static double random()
	* public static int round(float a) 参数为double的自学  //四舍五入  负数是5啥6进  [raʊnd]
	* public static double sqrt(double a)

###14.12_常见对象(Random类的概述和方法使用)
* A:Random类的概述  until包下 
	* 此类用于产生随机数如果用相同的种子创建两个 Random 实例，
	* 则对每个实例进行相同的方法调用序列，它们将生成并返回相同的数字序列。
* B:构造方法
	* public Random()
	* public Random(long seed)
* C:成员方法
	* public int nextInt()
	* public int nextInt(int n)(重点掌握)

###14.13_常见对象(System类的概述和方法使用)
* A:System类的概述   lang包下 父类是Object
	* System 类包含一些有用的类字段和方法。它不能被实例化。 
* B:成员方法
	* public static void gc()  //呼唤垃圾回收器
	* public static void exit(int status)  // 非0状态是异常终止，退出JVM
	* public static long currentTimeMillis()  //   1970.1.1 0.0.
	* pubiic static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)  
	*       //拷贝数组    源数组  指定源数组的位置  目标数组  指定目标数据的位置  复制数组的长度 
* C:案例演示
	* System类的成员方法使用

###14.14_常见对象(BigInteger类的概述和方法使用) math包
* A:BigInteger的概述
	* 可以让超过Integer范围内的数据进行运算
* B:构造方法
	* public BigInteger(String val)
* C:成员方法
	* public BigInteger add(BigInteger val)
	* public BigInteger subtract(BigInteger val)
	* public BigInteger multiply(BigInteger val)
	* public BigInteger divide(BigInteger val)
	* public BigInteger[] divideAndRemainder(BigInteger val)  //除数和余数

###14.15_常见对象(BigDecimal类的概述和方法使用)  math包
* A:BigDecimal的概述
	* 由于在运算的时候，float类型和double很容易丢失精度，演示案例。
	* 所以，为了能精确的表示、计算浮点数，Java提供了BigDecimal
	* 不可变的、任意精度的有符号十进制数。
* B:构造方法                                   
	* public BigDecimal(String val)     
* C:成员方法
	* public BigDecimal add(BigDecimal augend)
	* public BigDecimal subtract(BigDecimal subtrahend)
	* public BigDecimal multiply(BigDecimal multiplicand)
	* public BigDecimal divide(BigDecimal divisor)
* D:案例演示
	* BigDecimal类的构造方法和成员方法使用
	*   BigDecimal b1 =new BigDecimal(2.0);
		BigDecimal b2 =new BigDecimal(1.1);
		System.out.println(b1.subtract(b2)); //虽然位数多了，但还是达不到要求，开发中不推荐使用。
		
		BigDecimal b11 =new BigDecimal("2.0");
		BigDecimal b22 =new BigDecimal("1.1");
		System.out.println(b11.subtract(b22)); //通过在构造中传人字符串的方式，开发中推荐。
		
		BigDecimal b111 = BigDecimal.valueOf(2.0);  //valueOf()静态方法
		BigDecimal b222 = BigDecimal.valueOf(1.1);
		System.out.println(b111.subtract(b222));  //这种方式开发中也是推荐的 


###14.16_常见对象(Date类的概述和方法使用)(掌握)  
* A:Date类的概述   util包下，不是sql包，注意不要倒错了
	* 类 Date 表示特定的瞬间，精确到毫秒。 
* B:构造方法
	* public Date()
	* public Date(long date)
* C:成员方法
	* public long getTime()
	* public void setTime(long time)
		Date d1 = new Date();    //当前时间
		System.out.println(d1);
		Date d2 = new Date(0);  //Thu Jan 01 08:00:00 CST 1970 ,传人的是0就代表1970.1.1 0.0.0 
		System.out.println(d2);  //通过毫秒值创建时间对象

		System.out.println(d1.getTime());   //通过时间对象获取毫秒值
		System.out.println(System.currentTimeMillis());	//通过系统类的方法获取当前时间毫秒值

		Date d1 = new Date();	
		d1.setTime(1000);		//设置毫秒值,改变时间对象 是从1970 1 1 0 0开始  加1秒。
		System.out.println(d1);

###14.17_常见对象(SimpleDateFormat类实现日期和字符串的相互转换)(掌握)
* A:DateFormat类的概述
	* DateFormat 是日期/时间格式化子类的抽象类，它以与语言无关的方式格式化并解析日期或时间。是抽象类，不允许实例化，所以使用其子类SimpleDateFormat
* B:SimpleDateFormat构造方法
	* public SimpleDateFormat()
	* public SimpleDateFormat(String pattern)
* C:成员方法
	* public final String format(Date date)
	* public Date parse(String source)
	
		Date d = new Date();	//获取当前时间对象
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");   //创建我们要的日期格式
		System.out.println(sdf.format(d));	 //将日期对象转换为字符串

###14.18_常见对象(你来到这个世界多少天案例)(掌握)
* A:案例演示
	* 需求：算一下你来到这个世界多少天?
	 * 分析:
	 * 1,将生日字符串和今天字符串存在String类型的变量中
	 * 2,定义日期格式化对象
	 * 3,将日期字符串转换成日期对象
	 * 4,通过日期对象获得时间毫秒值
	 * 5,将两个时间毫秒值相减除以1000,再除以60,再除以60,再除以24得到天
public static void main(String[] args) throws ParseException {
		String birthday = "1983年07月08日";
		String today = "2088年6月6日";            
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		Date d1 = sdf.parse(birthday);      //时间字符串转换成日期对象
		Date d2 = sdf.parse(today);
		
		long time = d2.getTime() - d1.getTime();
		
		System.out.println(time / 1000 / 60 / 60 / 24 );
	}

###14.19_常见对象(Calendar类的概述和获取日期的方法)(掌握)
* A:Calendar类的概述
	* Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法。
* B:成员方法
	* public static Calendar getInstance()
	* public int get(int field)
		Calendar c = Calendar.getInstance();  //是抽象类,父类引用指向子类对象
		System.out.println(c);
		System.out.println(c.get(Calendar.YEAR));   	        //通过字段获取年
		System.out.println(c.get(Calendar.MONTH));    	//月是0-11
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_WEEK));    //从星期日开始
	/*
	 * 将星期存储表中进行查表
	 * 1,返回值类型String
	 * 2,参数列表int week
	 */
	public static String getWeek(int week) {
		String[] arr = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
		return arr[week];
	}
	
	/*
	 * 如果数字是个位前面补0
	 * 1,返回值类型String类型
	 * 2,参数列表,int num
	 */
	public static String getNum(int num) {
		/*if(num > 9) {
			return "" + num;
		}else {
			return "0" + num;
		}*/
		return num > 9 ? "" + num : "0" + num;
	}

###14.20_常见对象(Calendar类的add()和set()方法)(掌握)
* A:成员方法
	* public void add(int field,int amount)     //对指定字段进行向前减,向后加
	* public final void set(int year,int month,int date)  //修改指定字段
* B:案例演示
	* Calendar类的成员方法使用
		c.add(Calendar.MONTH, -1);		//对指定的字段进行向前是减或向后是加
		c.set(Calendar.YEAR, 2000);			//修改指定字段
		c.set(2000, 7, 8);                       //设定一个时间

###14.21_常见对象(如何获取任意年份是平年还是闰年)(掌握)@@
* A:案例演示
	需求：键盘录入任意一个年份，判断该年是闰年还是平年
	 * 分析:
	 * 1,键盘录入年Scanner
	 * 2,创建Calendar c = Calendar.getInstance();
	 * 3,通过set方法设置为那一年的3月1日,注意月份是0-11.
	 * 4,将日向前减去1
	 * 5,判断日是多少天,如果是29天返回true否则返回false

	private static boolean getYear(int year) {
			//2,创建Calendar c = Calendar.getInstance();
		Calendar c = Calendar.getInstance();
			//设置为那一年的3月1日
		c.set(year, 2, 1);
			//将日向前减去1
		c.add(Calendar.DAY_OF_MONTH, -1);
			//判断是否是29天
		return c.get(Calendar.DAY_OF_MONTH) == 29;
	}

###14.22_day14总结
* 把今天的知识点总结一遍。
* 计算从今天算起,100天以后是几月几号,并格式化成xxxx年x月x日的形式打印出来.
* Date和Calender类有什么区别和联系?
* 编写一个程序实现大小字符串的转换并输出.
	/**
	 * 1.调用Calendar类的add()方法计算100天后的日期
	 * 2.调用Calendar的getTime()方法返回Date类型对象
	 * 3.使用FULL格式的DateFormat对象,
	 * 4.使用format()方法格式化Date对象
	 */
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 2);

		Date date = calendar.getTime();  //System.out.println(date);  //Thu Jan 21 21:38:07 CST 2016

		DateFormat df = DateFormat.getDateInstance(DateFormat.FULL); 
	     	 //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss");  
		
		String string = df.format(date);
		System.out.println(string);  //2016年1月22日 星期五
	}

Date类用来表示某个特定的瞬间，能够精确到毫秒。而在实际应用中，往往需要把一个日期中的年、月、日等信息单独返回进行显示或处理，这个类中的大部分方法都已被标记过时。Calender类基本取代了Date类，该类中定义了一系列用于完成日期和时间字段操作的方法。 
Calendar的getTime()方法,返回一个表示Calendar时间值的Date对象 ; 同时Calendar有一个setTime(Date date)方法,将Date对象表示的时间值设置给Calendar对象，通过这两个方法就可以完成Date和Calendar对象之间的转换。

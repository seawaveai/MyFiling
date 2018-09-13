* 返回的是null
* readLine(); newLine();
* LineNumberReader()
    *lnr.setLineNumber(100);
	*lnr.getLineNumber()
* System.out.println((char)ch);	//将读到的字符强转后打印
* 装饰设计模式
* FileReader是使用默认码表读取文件, 如果需要使用指定码表读取, 那么可以使用InputStreamReader(字节流,编码表)
* FileWriter是使用默认码表写出文件, 如果需要使用指定码表写出, 那么可以使用OutputStreamWriter(字节流,编码表)
* Reader---InputStreamReader---FileReader

###21.01_IO流(字符流FileReader)
* 1.字符流是什么
	* 字符流是可以直接读写字符的IO流
	* 字符流读取字符, 就要先读取到字节数据, 然后转为字符. 如果要写出字符, 需要把字符转为字节再写出.    
* 2.FileReader
	* FileReader类的read()方法可以按照字符大小读取 
		FileReader fr = new FileReader("aaa.txt");	//创建字符输入流对象,关联aaa.txt
		int ch;    	    	//read()返回的是int类型
		while((ch = fr.read()) != -1) {			//将读到的字符赋值给ch   通过项目默认的码表一次读取一个字符
			System.out.println((char)ch);		//将读到的字符强转后打印
		}
		fr.close();		   //关流 

###21.02_IO流(字符流FileWriter)
* FileWriter类的write()方法可以自动把字符转为字节写出
		FileWriter fw = new FileWriter("aaa.txt");  //没有就创建，从后面写就加true
		fw.write("aaa,大家好,才是真的好");
		fw.write(97);  //写97是打印出来的是a
		fw.close();

###21.03_IO流(字符流的拷贝)
	FileReader fr = new FileReader("a.txt");
	FileWriter fw = new FileWriter("b.txt");
	int ch;
	while((ch = fr.read()) != -1) {
		fw.write(ch);   //Writer类中有一个1k的字符小缓冲区，如果不关流，就会将内容写到缓冲区里；关流会把缓冲区里的数据写出再关流。
	}
	fr.close();
	fw.close();

###21.04_IO流(什么情况下使用字符流)  只读、只写时使用
* 字符流也可以拷贝文本文件, 但不推荐使用. 因为读取时会把字节转为字符, 写出时还要把字符转回字节.

* 程序需要读取一段文本, 或者需要写出一段文本的时候可以使用字符流
    * 读取的时候是按照字符的大小读取的,不会出现半个中文
    * 写出的时候可以直接将字符串写出,不用转换为字节数组
  
 (###20.13_IO流(字节流读写中文) 
* 字节流读取中文的问题
	* 字节流在读中文的时候有可能会读到半个中文,造成乱码 
		
* 字节流写出中文的问题  (可以写但要变成字节数组)
	* 字节流直接操作的字节,写出中文必须将字符串转换成字节数组,写出回车换行  write("\r\n".getBytes());
)
###21.05_IO流(字符流是否可以拷贝非纯文本的文件)
* 不可以拷贝非纯文本的文件
   * 因为在读的时候会将字节转换为字符,在转换过程中,可能找不到对应的字符,就会用?代替,写出的时候会将字符转换成字节写出去
   * 如果是?,直接写出,这样写出之后的文件就乱了,看不了了  

###21.06_IO流(自定义字符数组的拷贝)  	  
		FileReader fr = new FileReader("aaa.txt");			//创建字符输入流,关联aaa.txt
		FileWriter fw = new FileWriter("bbb.txt");			//创建字符输出流,关联bbb.txt
		int len;
		char[] arr = new char[1024*8];				//创建字符数组   
		while((len = fr.read(arr)) != -1) {					//将数据读到字符数组中
			fw.write(arr, 0, len);							//从字符数组将有效数据写到文件上
		}	
		fr.close();											//关流释放资源
		fw.close();	

###21.07_IO流(带缓冲的字符流) 
* BufferedReader的read()方法读取字符时会一次读取若干字符到缓冲区, 然后逐个返回给程序, 降低读取文件的次数, 提高效率
* BufferedWriter的write()方法写出字符时会先写到缓冲区, 缓冲区写满时才会写到文件, 降低写文件的次数, 提高效率
		BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));	//创建字符输入流对象,关联aaa.txt
		BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));	//创建字符输出流对象,关联bbb.txt	
		int ch;				
		while((ch = br.read()) != -1) {		//read一次,会先将缓冲区读满,从缓冲去中一个一个的返给临时变量ch
			bw.write(ch);					//write一次,是将数据装到字符数组,装满后再一起写出去  8192字符 16K
		}
		br.close();							//关流
		bw.close();  

###21.08_IO流( readLine()和newLine()方法 )   更高效的读	
* BufferedReader的readLine()方法可以读取一行字符(不包含换行符号) ;只属于BufferedReader
* BufferedWriter的newLine()可以输出一个跨平台的换行符号"\r\n"   ;只属于BufferedWriter
* 
		BufferedReader br = new BufferedReader(new FileReader("aaa.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("bbb.txt"));
		String line;
		while((line = br.readLine()) != null) {  //返回值是null，底层做了判断public String readLine()
			bw.write(line);
			//bw.write("\r\n");	 //只支持windows系统    \n linux    \r mac 
			bw.newLine();		 //跨平台的  不通的系统里代表换行符
		}
		br.close();
		bw.close(); 

###21.09_IO流(将文本反转)  @@@
* 将一个文本文档上的文本反转,第一行和倒数第一行交换,第二行和倒数第二行交换
*  流对象尽量晚开早关
	 * 分析:
	 * 1,创建输入输出流对象
	 * 2,创建集合对象
	 * 3,将读到的数据存储在集合中
	 * 4,倒着遍历集合将数据写到文件上
	 * 5,关流 
	 * 注意事项:
	 * 流对象尽量晚开早关
	public static void main(String[] args) throws IOException {
		//改写后是尽量晚开早关
		// 1,创建输入输出流对象
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
		
		//2,创建集合对象
		ArrayList<String> list = new ArrayList<>();
		//3,将读到的数据存储在集合中
		String line;
		while((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();				//关流
		
		//4,倒着遍历集合将数据写到文件上
		BufferedWriter bw = new BufferedWriter(new FileWriter("revzzz.txt"));
		for(int i = list.size() - 1; i >= 0; i--) {
			bw.write(list.get(i));
			bw.newLine();
		}
		//5,关流
		bw.close();
	}

###21.10_IO流(LineNumberReader) 
* LineNumberReader是BufferedReader的子类, 具有相同的功能, 并且可以统计行号
	* 调用getLineNumber()方法可以获取当前行号
	* 调用setLineNumber()方法可以设置当前行号 //若设置为100，则从101开始
		LineNumberReader lnr = new LineNumberReader(new FileReader("aaa.txt"));
		String line;
		lnr.setLineNumber(100);									//设置行号
		while((line = lnr.readLine()) != null) {  	//readLine()一次就加1
			System.out.println(lnr.getLineNumber() + ":" + line);	//获取行号
		}
		lnr.close(); 

###21.11_IO流(装饰设计模式)
*  好处
*  耦合性不强，被装饰的类变化与装饰类的变化无关。如果是继承的话耦合性太强
		interface Coder {
			public void code();
		}
		
		class Student implements Coder {
			@Override
			public void code() {
				System.out.println("javase");
				System.out.println("javaweb");
			}
		}
		
		class HeiMaStudent implements Coder {
			   	  // 1获取被装饰的引用
			private Student s;						//获取到被包装类的引用
			public HeiMaStudent(Student s) {		//通过构造函数创建对象的时候,传入被包装的对象
			  	  // 2在构造方法中传人被装饰类的对象
				this.s = s;
			}
			  	  // 3对其原有功能进行升级
			@Override
			public void code() {					
				s.code();   //有被包装类的功能
				System.out.println("数据库");
				System.out.println("ssh");
				System.out.println("安卓");
				System.out.println(".....");
			}	
		} 

	HeiMaStudent hms = new HeiMaStudent(new Student());  //
	hms.code();

###21.12_IO流(使用指定的码表读写字符) 
* FileReader是使用默认码表读取文件, 如果需要使用指定码表读取, 那么可以使用InputStreamReader(字节流,编码表)
* FileWriter是使用默认码表写出文件, 如果需要使用指定码表写出, 那么可以使用OutputStreamWriter(字节流,编码表)
*       InputStreamReader(InputStream in, String charsetName),字节流转字符流 
*
		BufferedReader br = 						//高效的,用指定的编码表读
				new BufferedReader(new InputStreamReader( new FileInputStream("UTF-8.txt"), "UTF-8"));  //码表不区分大小写
		BufferedWriter bw = 						//高效的,用指定的编码表写
				new BufferedWriter(new OutputStreamWriter( new FileOutputStream("GBK.txt"), "GBK"));
		int ch;
		while((ch = br.read()) != -1) {
			bw.write(ch);
		}
		br.close();
		bw.close();
###21.13_IO流(转换流图解)
* 画图分析转换流

###21.14_IO流(获取文本上字符出现的次数)
* 获取一个文本上每个字符出现的次数,将结果写在times.txt上
*  * 分析:
	 * 1,创建带缓冲的输入流对象
	 * 2,创建双列集合对象TreeMap
	 * 3,将读到的字符存储在双列集合中,存储的时候要做判断,如果不包含这个键,就将键和1存储,如果包含这个键,就将该键和值加1存储
	 * 4,关闭输入流
	 * 5,创建输出流对象
	 * 6,遍历集合将集合中的内容写到times.txt中
	 * 7,关闭输出流

	public static void main(String[] args) throws IOException {
			//1,创建带缓冲的输入流对象
		BufferedReader br = new BufferedReader(new FileReader("zzz.txt"));
			//2,创建双列集合对象TreeMap
		TreeMap<Character, Integer> tm = new TreeMap<>();
			//3,将读到的字符存储在双列集合中,存储的时候要做判断,如果不包含这个键,就将键和1存储,如果包含这个键,就将该键和值加1存储
		int ch;
		while((ch = br.read()) != -1) {
			char c = (char)ch;				//强制类型转换 
			/*if(!tm.containsKey(c)) {
				tm.put(c, 1);
			}else {
				tm.put(c, tm.get(c) + 1);
			}*/
			tm.put(c, !tm.containsKey(c) ? 1 : tm.get(c) + 1);
		}
			//4,关闭输入流
		br.close();
			//5,创建输出流对象
		BufferedWriter bw = new BufferedWriter(new FileWriter("times.txt"));
			//6,遍历集合将集合中的内容写到times.txt中
		for(Character key : tm.keySet()) {
			switch (key) {
			case '\t':
				bw.write("\\t" + "=" + tm.get(key)); 	
				break;
			case '\n':
				bw.write("\\n" + "=" + tm.get(key)); 
				break;
			case '\r':
				bw.write("\\r" + "=" + tm.get(key)); 
				break;
			default:
				bw.write(key + "=" + tm.get(key)); 	//写出键和值
				break;
			}
			bw.newLine();
		}
			//7,关闭输出流
		bw.close();
	}

###21.15_IO流(试用版软件)
* 当我们下载一个试用版软件,没有购买正版的时候,每执行一次就会提醒我们还有多少次使用机会用学过的IO流知识,模拟试用版软件,试用10次机会,执行一次就提示一次您还有几次机会,如果次数到了提示请购
买正版
 * 分析:
	 */ 1,创建带缓冲的输入流对象,因为要使用readLine方法,可以保证数据的原样性
	 * 2,将读到的字符串转换为int数
	 * 3,对int数进行判断,如果大于0,就将其--写回去,如果不大于0,就提示请购买正版
	 * 4,在if判断中要将--的结果打印,并将结果通过输出流写到文件上
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("config.txt"));
		String line = br.readLine();
		int times = Integer.parseInt(line);		//将数字字符串转换为数字
		if(times > 0) {
			System.out.println("您还有" + times-- + "次机会");
			FileWriter fw = new FileWriter("config.txt");
			fw.write(times + "");
			fw.close();
		}else {
			System.out.println("您的试用次数已到,请购买正版");
		}
		br.close();
	}

###21.16_File类(递归)
* 5的阶乘	
* 递归的弊端: StackOverflowError调用的次数不能太多,否则会栈溢出
* 递归的好处: 不需要知道调用的次数
* public static int fun(int num){
		if(num==1){
			return 1;
		}else{
			return num*fun(num-1);
		}
	}
*构造方法是不能使用递归的
*递归可以无返回值

###21.17_File类(练习)
* 需求:从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java文件名

###21.18_IO流(总结)
* 1.会用BufferedReader读取GBK码表和UTF-8码表的字符
* 2.会用BufferedWriter写出字符到GBK码表和UTF-8码表的文件中
* 3.会使用BufferedReader从键盘读取一行

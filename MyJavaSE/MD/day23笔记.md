###23.01_File类递归练习(统计该文件夹大小)
* 需求:1,从键盘接收一个文件夹路径,统计该文件夹大小

###23.02_File类递归练习(删除该文件夹)
* 需求:2,从键盘接收一个文件夹路径,删除该文件夹

###23.03_File类递归练习(拷贝)
* 需求:3,从键盘接收两个文件夹路径,把其中一个文件夹中(包含内容)拷贝到另一个文件夹中
* 分析:
	 * 1,在目标文件夹中创建原文件夹
	 * 2,获取原文件夹中所有的文件和文件夹,存储在File数组中
	 * 3,遍历数组
	 * 4,如果是文件就用io流读写
	 * 5,如果是文件夹就递归调用
总结:
* C:\ 盘符不能作为原文件,目的文件
* &&前后不能有空格
* if(subFile.getName().endsWith(".java")){}要在里面

###23.04_File类递归练习(按层级打印)
* 需求:4,从键盘接收一个文件夹路径,把文件夹中的所有文件以及文件夹的名字按层级打印, 例如:
	aaa是文件夹,里面有bbb.txt,ccc.txt,ddd.txt这些文件,有eee这样的文件夹,eee中有fff.txt和ggg.txt,打印出层级来
	aaa
		bbb.txt
		ccc.txt
		ddd.txt
		eee
			fff.txt
			ggg.txt

###23.05_递归练习(斐波那契数列)
* 不死神兔
* 故事得从西元1202年说起，话说有一位意大利青年，名叫斐波那契。
* 在他的一部著作中提出了一个有趣的问题：假设一对刚出生的小兔一个月后就能长成大兔，再过一个月就能生下一对小兔，并且此后每个月都生一对小兔，一年内没有发生死亡，
* 问：一对刚出生的兔子，一年内繁殖成多少对兔子?
* 1 1 2 3 5 8 13
* 第一个月一对小兔子					1
* 第二个月一对大兔子					1
* 第三个月一对大兔子生了一对小兔子		2
* 第四个月一对大兔子生了一对小兔子
* 		 一对小兔子长成大兔子			3
* 第五个月两对大兔子生两对小兔子	
* 		 一对小兔子长成大兔子			5

###23.06_递归练习(1000的阶乘所有零和尾部零的个数)
* 需求:求出1000的阶乘所有零和尾部零的个数,不用递归做
* 
	1.public static void demo1() {		//求1000的阶乘中所有的零  472
		BigInteger bi1 = new BigInteger("1");
		for(int i = 1; i <= 1000; i++) {
			BigInteger bi2 = new BigInteger(i+"");
			bi1 = bi1.multiply(bi2);	//将bi1与bi2相乘的结果赋值给bi1
		}
		String str = bi1.toString();	//获取字符串表现形式
		int count = 0;
		for(int i = 0; i < str.length(); i++) {
			if('0' == str.charAt(i)) {	//如果字符串中出现了0字符
				count++;				//计数器加1
			}
		}
		System.out.println(count);
	}

    2.public static void demo2() {		//获取1000的阶乘尾部有多少个零 249
		BigInteger bi1 = new BigInteger("1");
		for(int i = 1; i <= 1000; i++) {
			BigInteger bi2 = new BigInteger(i+"");
			bi1 = bi1.multiply(bi2);	//将bi1与bi2相乘的结果赋值给bi1
		}
		String str = bi1.toString();	//获取字符串表现形式
		StringBuilder sb = new StringBuilder(str);
		str = sb.reverse().toString();	//链式编程
		
		int count = 0;					//定义计数器
		for(int i = 0; i < str.length(); i++) {
			if('0' != str.charAt(i)) {
				break;
			}else {
				count++;
			}
		}
		System.out.println(count);
	}

###23.07_递归练习(1000的阶乘尾部零的个数)
* 需求:求出1000的阶乘尾部零的个数,用递归做

###23.08_集合练习(约瑟夫环)
* 幸运数字
* public static int getLucklyNum(int num) {
		ArrayList<Integer> list = new ArrayList<>();		//创建集合存储1到num的对象
		for(int i = 1; i <= num; i++) {
			list.add(i);									//将1到num存储在集合中
		}
		
		int count = 1;										//用来数数的,只要是3的倍数就杀人
		for(int i = 0; list.size() != 1; i++) {				//只要集合中人数超过1,就要不断的杀
			if(i == list.size()) {							//如果i增长到集合最大的索引+1时
				i = 0;								//重新归零
			}
			
			if(count % 3 == 0) {				//如果是3的倍数
				list.remove(i--);			//就杀人
			}
			count++;
		}
		return list.get(0);  //返回最后一个人,也就是集合中的唯一一个元素
	}
package seawave.day27.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import seawave.day27.bean.Person;

public class Demo5_Method {

	/**
	 * Class.getMethod(String, Class...) 和
	 * Class.getDeclaredMethod(String,Class...)方法可以获取类中的指定方法,
	 * 调用invoke(Object,Object...)可以调用该方法, Class.getMethod("eat") invoke(obj)
	 * Class.getMethod("eat",int.class) invoke(obj,10)
	 * 
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Class clazz = Class.forName("seawave.day27.bean.Person");
		Constructor c = clazz.getConstructor(String.class, int.class); // 获取有参构造
		Person p = (Person) c.newInstance("张三", 23); // 通过有参构造创建对象

		Method m = clazz.getMethod("eat"); // 获取eat方法(eat是方法名)
		m.invoke(p);

		Method m2 = clazz.getDeclaredMethod("eat", int.class);//获取有参的eat方法 [该方法声明成私有的,需要暴力反射]
		m2.setAccessible(true); //去除权限
		m2.invoke(p, 10);

		
		//给Bean类里面Set新的值
		Field[] fields = clazz.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			//System.out.println(fields[i].getType().getSimpleName());// String
			//System.out.println(fields[i].getName());// name
			
			//set方法反射，然后赋值
			 StringBuffer sb = new StringBuffer();
	         sb.append("set");
	         sb.append(fields[i].getName().substring(0, 1).toUpperCase());//第一个字母大写
	         sb.append(fields[i].getName().substring(1));
	           
			 Method method = clazz.getMethod( sb.toString() , fields[i].getType());//方法名; 参数的类型
			
			if ("String".equals(fields[i].getType().getSimpleName())) {
				method.invoke(p, "明治");
			}else {
				method.invoke(p, 222);
			}
			
			System.out.println(p.getName() +"  "+ p.getAge());
		}

		
		
		
	}

}

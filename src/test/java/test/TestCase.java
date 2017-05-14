package test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bean.Computer;
import bean.Example;
import bean.Message;
import bean.MobilePhone;
import bean.Student;

public class TestCase {

	/**
	 * Junit专门用来测试。
	 * 方法前必须加@Test才能独立运行。
	 * 选中方法，点击"Run as Junit Test "。
	 */
	@Test
	public void test1() {
		System.out.println("Junit专业测试");
	}
	
	/**
	 * 创建Spring容器
	 * 
	 * Spring容器用来管理对象。
	 * Spring容器是IOC的核心。
	 * Spring容器本身也是一个对象。
	 */
	@Test
	public void test2() {
		//创建容器时要声明它所需的配置文件。
		//容器对象会从ClassPath下读取此文件。
		//在实例化容器后它会自动读取此文件。
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
	}
	
	/**
	 * 1.通过构造器创建bean
	 * 2.通过静态工厂方法创建bean
	 * 3.通过实例工厂方法创建bean
	 */
	@Test
	public void test3() {
		//创建Spring容器，容器自动加载配置文件，
		//自动创建文件中所声明的bean。
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从 容器中获取指定(id)的bean
		List list = (List) ctx.getBean("obj1");
		System.out.println(list);
		
		Calendar cal = (Calendar) ctx.getBean("obj2");
		System.out.println(cal);
		
		Date date = (Date) ctx.getBean("obj3");
		System.out.println(date);
	}
	
	/**
	 * bean的作用域：
	 * 每个类型的bean在容器中默认都是单列的。
	 */
	@Test
	public void test4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Map map1 = (Map) ctx.getBean("obj4");
		Map map2 = (Map) ctx.getBean("obj4");
		System.out.println(map1==map2);
	}
	/**
	 * 容器管理bean的生命周期
	 */
	@Test
	public void test5() {
		//ClassPathXmlApplicationContext继承与AbstractApplicationContext
		//后者实现了ApplicationContext接口。
		//AbstractApplicationContext里面声明了关闭容器的方法close。
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("1-----------");
		Example exa = (Example) ctx.getBean("exa");
		System.out.println(exa);
		System.out.println("2------------");
		ctx.close();
	}
	
	/**
	 * 依赖注入-sette注入
	 */
	@Test
	public void Test6() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Computer cpt = (Computer) ctx.getBean("Computer");
		System.out.println(cpt.getMainboard());
		System.out.println(cpt.getHdd());
		System.out.println(cpt.getRam());
	}
	
	/**
	 * 依赖注入-构造器注入
	 */
	@Test
	public void Test7() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		MobilePhone phone = (MobilePhone) ctx.getBean("phone");
		System.out.println(phone.getCpu());
		System.out.println(phone.getRam());
	}
	
	@Test
	public void Test8() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) ctx.getBean("student");
		System.out.println(student.getComputer().getMainboard());
		System.out.println(student.getPhone().getCpu());
	}
	
	@Test
	public void Test9() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Message msg = (Message) ctx.getBean("msg");
		System.out.println(msg.getId());
		System.out.println(msg.getName());
		System.out.println(msg.getSalary());
		System.out.println(msg.getPhone().getCpu());
		System.out.println(msg.getCities().get(0));
		System.out.println(msg.getScore().get("jsd1604"));
		System.out.println(msg.getParams().getProperty("user"));
	}
}

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
	 * Junitר���������ԡ�
	 * ����ǰ�����@Test���ܶ������С�
	 * ѡ�з��������"Run as Junit Test "��
	 */
	@Test
	public void test1() {
		System.out.println("Junitרҵ����");
	}
	
	/**
	 * ����Spring����
	 * 
	 * Spring���������������
	 * Spring������IOC�ĺ��ġ�
	 * Spring��������Ҳ��һ������
	 */
	@Test
	public void test2() {
		//��������ʱҪ����������������ļ���
		//����������ClassPath�¶�ȡ���ļ���
		//��ʵ���������������Զ���ȡ���ļ���
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
	}
	
	/**
	 * 1.ͨ������������bean
	 * 2.ͨ����̬������������bean
	 * 3.ͨ��ʵ��������������bean
	 */
	@Test
	public void test3() {
		//����Spring�����������Զ����������ļ���
		//�Զ������ļ�����������bean��
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//�� �����л�ȡָ��(id)��bean
		List list = (List) ctx.getBean("obj1");
		System.out.println(list);
		
		Calendar cal = (Calendar) ctx.getBean("obj2");
		System.out.println(cal);
		
		Date date = (Date) ctx.getBean("obj3");
		System.out.println(date);
	}
	
	/**
	 * bean��������
	 * ÿ�����͵�bean��������Ĭ�϶��ǵ��еġ�
	 */
	@Test
	public void test4() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Map map1 = (Map) ctx.getBean("obj4");
		Map map2 = (Map) ctx.getBean("obj4");
		System.out.println(map1==map2);
	}
	/**
	 * ��������bean����������
	 */
	@Test
	public void test5() {
		//ClassPathXmlApplicationContext�̳���AbstractApplicationContext
		//����ʵ����ApplicationContext�ӿڡ�
		//AbstractApplicationContext���������˹ر������ķ���close��
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("1-----------");
		Example exa = (Example) ctx.getBean("exa");
		System.out.println(exa);
		System.out.println("2------------");
		ctx.close();
	}
	
	/**
	 * ����ע��-setteע��
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
	 * ����ע��-������ע��
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

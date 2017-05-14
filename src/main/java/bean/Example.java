package bean;

import java.io.Serializable;

public class Example implements Serializable {

	public Example() {
		System.out.println("创建Example");
	}
	
	public void init() {
		System.out.println("初始化Example");
	}
	
	public void destroy() {
		System.out.println("销毁Example");
	}
}

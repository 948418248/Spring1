package bean;

import java.io.Serializable;

public class Example implements Serializable {

	public Example() {
		System.out.println("����Example");
	}
	
	public void init() {
		System.out.println("��ʼ��Example");
	}
	
	public void destroy() {
		System.out.println("����Example");
	}
}

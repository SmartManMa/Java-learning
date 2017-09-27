abstract class SuperClass 
{
	//protected abstract void print() throws Exception;
		//System.out.println("I am father");
	protected abstract void print();
}
public class SubClass extends SuperClass
{
	public static void main(String[] args) throws Exception{
		//测试覆盖
		SuperClass sub = new SubClass();
		sub.print();
		//测试重载
		SubClass sc = new SubClass();
		sc.overLoadTest("sdfghj");
		sc.overLoadTest();
		sc.overLoadTest(88);

	}
	/* 
	1、覆盖(override)时，方法名和返回值类型必须与父类完全一致
	2、访问权限修饰符可以变大权限，但不可以变小
	3、若父类方法跑出异常，则子类必须也抛出异常，否则子类覆盖父类方法不可抛出异常
	下面两个覆盖父类方法的行为是错误的：
	void print() {//访问权限变小 public > protected > 默认 >private
		System.out.println("I am son");
	}

	protected void print()
	{
		//父类抛了异常，而override是没抛
		System.out.println("I am son");	
	}


	*/
	public void print(){
		System.out.println("I am son");
	}

	//方法重载：通过方法参数类型和数量不同，来区分同名方法
	//与是否抛出异常，及访问权限修饰符无关，他们可以不同
	public void overLoadTest(String str) {
		System.out.println("I am public"+str);
	} 
	private void overLoadTest() {
		System.out.println("I am private");
	}
	void overLoadTest(int i) throws Exception{
		System.out.println("I am default-"+i);
	}

}


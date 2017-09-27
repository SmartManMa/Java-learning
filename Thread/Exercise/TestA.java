class TestA implements Runnable 
{
	public static void main(String[] args) 
	{
		new TestA();
	}
	public TestA(){
		//错误原因,递归调用，无结果
		//TestA task = new TestA();
		//new Thread(task).start();
		new Thread(this).start();
	}
	public void run() {
		System.out.println("Test");
	}
}

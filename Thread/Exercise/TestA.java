class TestA implements Runnable 
{
	public static void main(String[] args) 
	{
		new TestA();
	}
	public TestA(){
		//����ԭ��,�ݹ���ã��޽��
		//TestA task = new TestA();
		//new Thread(task).start();
		new Thread(this).start();
	}
	public void run() {
		System.out.println("Test");
	}
}

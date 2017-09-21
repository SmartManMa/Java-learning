//创建线程的一般方法
public class TestThread 
{
	public static void main (String[] args)throws Exception 
	{
		PrintChar pc1 = new PrintChar('+',100);
		PrintChar pc2 = new PrintChar('@',100);
		PrintChar pc3 = new PrintChar('#',100);

		Thread th1 = new Thread(pc1);
		Thread th2 = new Thread(pc2);
		Thread th3 = new Thread(pc3);

		th1.start();
		th2.start();
		th3.start();
		Thread.sleep(1000);
		System.out.println("***************主线程结束*************** ");
	}
}

//1.创建任务类实现Runnable接口
class PrintChar implements Runnable
{
	private char ch;
	private int times;
	public PrintChar(char ch,int times) {
		this.ch = ch;
		this.times = times;
	}
	//2.实现Runnable接口的run方法，在该方法中指定需多线程执行的任务
	public void run () {
		for (int i = 1; i<=times ;i++)
		{
			System.out.print(ch+" ");
		}
	}
}

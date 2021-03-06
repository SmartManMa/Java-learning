//创建线程的一般方法
public class TestThread 
{
	public static void main (String[] args)throws Exception 
	{	
		PrintChar pc1 = new PrintChar('+',10000);
		PrintChar pc2 = new PrintChar('@',10000);
		PrintChar pc3 = new PrintChar('#',10000);

		Thread th1 = new Thread(pc1);
		Thread th2 = new Thread(pc2);
		Thread th3 = new Thread(pc3);

		th1.start();
		th2.start();
		th3.start();
		//将上面三句改为下面三句，可正常运行，但变成了单线程
		//th1.run();
		//th2.run();
		//th3.run();
		new PrintCharByThread('$',10000).start();
		new PrintCharByThread('*',10000).start();
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
//Thread类实现了Runnable接口
//因此继承Thread也可以开启线程
//1.继承Thread
class PrintCharByThread extends Thread
{
	private char ch;
	private int times;
	public PrintCharByThread(char ch,int times) {
		this.ch = ch;
		this.times = times;
	}
	//2.重写Thread类run方法，在该方法中指定需多线程执行的任务
	public void run () {
		for (int i = 1; i<=times ;i++)
		{
			System.out.print(ch+" ");
		}
	}
}


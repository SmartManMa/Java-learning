import java.util.concurrent.*;
class ExcutorDemo 
{
	public static void main(String[] args) 
	{
		//创建线程池 包含三个线程
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//提交线程任务并执行
		executor.execute(new PrintChar('@',20));
		executor.execute(new PrintChar('*',20));
		executor.execute(new PrintChar('$',20));
		executor.execute(new PrintChar('1',20));
		executor.execute(new PrintChar('2',20));
		executor.execute(new PrintChar('3',20));
		executor.execute(new PrintChar('4',20));
		executor.execute(new PrintChar('5',20));
		//关闭线程池
		executor.shutdown();
	}
}
//1.创建任务类实现Runnable接口
class PrintChar extends Thread
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
			//显示该线程组有四个线程=线程池三个+主线程
			System.out.print(ch+"---"+this.activeCount()+"--ID--"+this.getId()+"  ");
		}
	}
}
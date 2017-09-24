public class TestJoin 
{
	public static void main(String[] args) 
	{	
		new Thread(new PrintNum(100)).start();
	}
}
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

class PrintNum implements Runnable
{	
	private int times;
	Thread thread = new Thread(new PrintChar('#',100));
	public PrintNum(int times) {
		this.times = times;
	}
	public void run () {
		//开启其他线程
		thread.start();
		try
		{
			for (int i = 1; i<=times ;i++)
			{
				System.out.print(i+" ");
				if(i==50) {
					//等待thread线程结束
					thread.join();
				}
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}

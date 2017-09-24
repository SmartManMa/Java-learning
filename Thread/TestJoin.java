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
	//2.ʵ��Runnable�ӿڵ�run�������ڸ÷�����ָ������߳�ִ�е�����
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
		//���������߳�
		thread.start();
		try
		{
			for (int i = 1; i<=times ;i++)
			{
				System.out.print(i+" ");
				if(i==50) {
					//�ȴ�thread�߳̽���
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

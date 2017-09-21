//�����̵߳�һ�㷽��
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
		System.out.println("***************���߳̽���*************** ");
	}
}

//1.����������ʵ��Runnable�ӿ�
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

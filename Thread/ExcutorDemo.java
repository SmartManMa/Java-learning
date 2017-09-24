import java.util.concurrent.*;
class ExcutorDemo 
{
	public static void main(String[] args) 
	{
		//�����̳߳� ���������߳�
		ExecutorService executor = Executors.newFixedThreadPool(3);
		//�ύ�߳�����ִ��
		executor.execute(new PrintChar('@',20));
		executor.execute(new PrintChar('*',20));
		executor.execute(new PrintChar('$',20));
		executor.execute(new PrintChar('1',20));
		executor.execute(new PrintChar('2',20));
		executor.execute(new PrintChar('3',20));
		executor.execute(new PrintChar('4',20));
		executor.execute(new PrintChar('5',20));
		//�ر��̳߳�
		executor.shutdown();
	}
}
//1.����������ʵ��Runnable�ӿ�
class PrintChar extends Thread
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
			//��ʾ���߳������ĸ��߳�=�̳߳�����+���߳�
			System.out.print(ch+"---"+this.activeCount()+"--ID--"+this.getId()+"  ");
		}
	}
}
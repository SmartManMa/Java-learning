/*
	����wait��notifyʵ��������������
*/
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class  TestMonitor
{
	private static TheBuffer buf = new TheBuffer();
	public static void main(String[] args) 
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new ProducerTask());
		executor.execute(new ProducerTask());
		executor.execute(new ProducerTask());
		executor.execute(new ConsumerTask());
		//executor.execute(new ConsumerTask());
		executor.shutdown();
	}

	//������
	private static class ProducerTask implements Runnable
	{
		private static int i = 1;
		public void run() {
			try
			{	
				//����������ProducerTask��������this����ÿ��������е�����ͬ����������ͬ��
				synchronized(TestMonitor.class) {
				int k = 0;
				while (true)
				{
					System.out.println("������:"+i);
					buf.write(i++);
					Thread.sleep((int)(Math.random()*1000));
					
				}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	//������
	private static class ConsumerTask implements Runnable
	{
		public void run() {
			try
			{
				while (true)
				{
					System.out.println("\t\t������:"+buf.read());
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	//����һ���ֿ�
		//������
	private static class TheBuffer
	{
		//����ֿ�����
		private static final int CAPACITY = 1;
		//�ֿ�����ݽṹ
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//��
		Object obj1 =new Object();
		//Object obj2 =new Object();
		//��������,�ǿ�����������������
		//����ʱ����������������

		public void write(int value) {
			synchronized(obj1) {//synchronized(obj1) start
			try
			{
				while (queue.size() == CAPACITY)
				{
					System.out.println("�ֿ�����,�ȴ�����");
					//wait noFull������������
					obj1.wait();
				}
				queue.add(value);
				//queue.add(value)��ǿգ�����ǿ�����
				obj1.notifyAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		}//synchronized(obj1) end
		//������
		public int read() {
			int value = 0;
			synchronized(obj1) {//synchronized(obj1) start
			try
			{
				while(queue.isEmpty()) {
					//�ȴ�����
					System.out.println("\t\t�ֿ��ѿ�,�ȴ�����");
					obj1.wait();
				}
				value = queue.poll();
				//value = queue.poll();�Ƴ�һ��Ԫ�غ���в���
				obj1.notifyAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				//�ͷ�����Դ
				
				return value;
			}
			}//synchronized(obj1) end
		}
	}
}

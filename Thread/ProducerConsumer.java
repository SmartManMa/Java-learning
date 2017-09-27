import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

class  ProducerConsumer
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
				synchronized(ProducerConsumer.class) {
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
		private static Lock lock = new ReentrantLock();
		//��������,�ǿ�����������������
		//����ʱ����������������
		private static Condition noFull = lock.newCondition();
		//�ǿ�ʱ����������������
		private static Condition noNull = lock.newCondition();
		//д����
		public void write(int value) {
			lock.lock();
			try
			{
				while (queue.size() == CAPACITY)
				{
					System.out.println("�ֿ�����,�ȴ�����");
					//wait noFull������������
					noFull.await();
				}
				queue.add(value);
				//queue.add(value)��ǿգ�����ǿ�����
				noNull.signalAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				//�ͷ�����Դ
				lock.unlock();
			}
		}
		//������
		public int read() {
			int value = 0;
			lock.lock();
			try
			{
				while(queue.isEmpty()) {
					//�ȴ�����
					System.out.println("\t\t�ֿ��ѿ�,�ȴ�����");
					noNull.await();
				}
				value = queue.poll();
				//value = queue.poll();�Ƴ�һ��Ԫ�غ���в���
				noFull.signalAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				//�ͷ�����Դ
				lock.unlock();
				return value;
			}
		}
	}
}

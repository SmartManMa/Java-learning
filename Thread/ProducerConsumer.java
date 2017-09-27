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

	//生产者
	private static class ProducerTask implements Runnable
	{
		private static int i = 1;
		public void run() {
			try
			{	
				//上面有三个ProducerTask对象，若用this，则每个对象持有的锁不同，并不可以同步
				synchronized(ProducerConsumer.class) {
				int k = 0;
				while (true)
				{
					System.out.println("生产者:"+i);
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
	//消费者
	private static class ConsumerTask implements Runnable
	{
		public void run() {
			try
			{
				while (true)
				{
					System.out.println("\t\t消费者:"+buf.read());
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	//定义一个仓库
		//生产者
	private static class TheBuffer
	{
		//定义仓库容量
		private static final int CAPACITY = 1;
		//仓库的数据结构
		LinkedList<Integer> queue = new LinkedList<Integer>();
		//锁
		private static Lock lock = new ReentrantLock();
		//两个条件,非空条件，及非满条件
		//非满时，唤醒生产者生产
		private static Condition noFull = lock.newCondition();
		//非空时，唤醒消费者消费
		private static Condition noNull = lock.newCondition();
		//写方法
		public void write(int value) {
			lock.lock();
			try
			{
				while (queue.size() == CAPACITY)
				{
					System.out.println("仓库已满,等待消费");
					//wait noFull条件来唤醒它
					noFull.await();
				}
				queue.add(value);
				//queue.add(value)后非空，满足非空条件
				noNull.signalAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				//释放锁资源
				lock.unlock();
			}
		}
		//读方法
		public int read() {
			int value = 0;
			lock.lock();
			try
			{
				while(queue.isEmpty()) {
					//等待不空
					System.out.println("\t\t仓库已空,等待生产");
					noNull.await();
				}
				value = queue.poll();
				//value = queue.poll();移除一个元素后队列不满
				noFull.signalAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				//释放锁资源
				lock.unlock();
				return value;
			}
		}
	}
}

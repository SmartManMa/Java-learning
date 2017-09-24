import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class AccountSyncWithLock 
{	
	//Account类对象 被多个AddTesk任务共享，
	//当前类对象只有一个Account类对象
	private Account account = new Account();
	public static void main(String[] args) 
	{
		AccountSyncWithLock as = new AccountSyncWithLock();
		Account account = as.account;
		ExecutorService executor =  Executors.newCachedThreadPool();
		for (int i=0; i<100; i++)
		{
			executor.execute(as.new AddTesk());
		}
		//一定要关闭executor，不再接受新任务，否则出错
		executor.shutdown();
		while (!executor.isTerminated()){}
		//所有个线程终止executor.isTerninated()都返回true
		System.out.println(account.getBalance());
	}

	private  class AddTesk implements Runnable
	{	//在这里加锁也是可以的，但尽量不要这么做
		//private Lock lock = new ReentrantLock();
		public void run() {
			//lock.lock();
			account.deposit(1);
			//lock.unlock();
		}
	}
	private class Account
	{   
		private Lock lock = new ReentrantLock();
		//非静态内部类不可定义静态成员
		//private static int balance = 0;
		private int balance = 0;
		public int getBalance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			lock.lock();
			int newBalance = balance + amount;
			try
			{
				Thread.sleep(10);

				balance = newBalance;
			}
			catch (Exception e)
			{
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
			
		}

	}
}

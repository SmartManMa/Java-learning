import java.util.concurrent.*;
import java.util.concurrent.locks.*;
class AccountSyncWithLock 
{	
	//Account����� �����AddTesk������
	//��ǰ�����ֻ��һ��Account�����
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
		//һ��Ҫ�ر�executor�����ٽ��������񣬷������
		executor.shutdown();
		while (!executor.isTerminated()){}
		//���и��߳���ֹexecutor.isTerninated()������true
		System.out.println(account.getBalance());
	}

	private  class AddTesk implements Runnable
	{	//���������Ҳ�ǿ��Եģ���������Ҫ��ô��
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
		//�Ǿ�̬�ڲ��಻�ɶ��徲̬��Ա
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

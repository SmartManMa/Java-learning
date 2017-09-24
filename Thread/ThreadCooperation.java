import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class ThreadCooperation 
{	private static Account account = new Account();

	public static void main(String[] args) 
	{
		ExecutorService  executor = Executors.newCachedThreadPool();
		for (int i = 0;i<10 ; i++ )
		{
			executor.execute(new DepositTask());
			executor.execute(new WithdrawTask());
		}
		
		//�ر���Դ
		executor.shutdown();

	}
	//�������
	private static class DepositTask implements Runnable
	{
		//��дRun����������������
		public void run() {
			//for (int i = 0;i<100 ; i++ )
			{
				int amount = (int)(Math.random()*10+1);
				account.deposit(amount);
			}
		}
	}
		//ȡ������
	private static class WithdrawTask implements Runnable
	{
		//��дRun����������������
		public void run() {
			//for (int i = 0;i<100 ; i++ )
			{
				int amount = (int)(Math.random()*10+1);
				account.withdraw(amount);
			}
		}
	}
	//�˻���
	private static class Account
	{	
		//����һ����,static��ʾ����Account�����������
		private static Lock lock = new ReentrantLock();
		//����һ���ź���
		private static Condition newDeposit = lock.newCondition();
		//����һ���˻����,�������static�����˻�����һ��������
		private int balance = 0;
		//�����ȡ���ķ���
		public int getBalance()
		{
			return balance;
		}
		//���ķ���
		public void deposit(int amount) {
			//��ֻ֤��һ�������������Ҵ��ʱû��ȡ�����
			lock.lock();
			try
			{
				balance +=  amount;
				System.out.println(
					"Depsit:"+amount+"\n"+"CurrentMoney:"+balance);
				//֪ͨ����ȡ��ʹ���߳�
				newDeposit.signalAll();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
			
		}

		//ȡ��ķ���
		public void withdraw(int amount) {
			//��ֻ֤��һ��ȡ�����������ȡ��ʱû�д�����
			lock.lock();
			try
			{
				//ע�⣡�����˴�������if(balance<amount)
				while (balance<amount)
				{
					//������ȴ�
					newDeposit.await();
				}
				balance -= amount;
				System.out.println(
					"Withdraw:"+amount+"\n"+"CurrentMoney:"+balance);
				
				}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}
	} 
}

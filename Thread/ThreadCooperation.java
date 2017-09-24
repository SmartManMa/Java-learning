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
		
		//关闭资源
		executor.shutdown();

	}
	//存款任务
	private static class DepositTask implements Runnable
	{
		//重写Run方法，定义存款任务
		public void run() {
			//for (int i = 0;i<100 ; i++ )
			{
				int amount = (int)(Math.random()*10+1);
				account.deposit(amount);
			}
		}
	}
		//取款任务
	private static class WithdrawTask implements Runnable
	{
		//重写Run方法，定义存款任务
		public void run() {
			//for (int i = 0;i<100 ; i++ )
			{
				int amount = (int)(Math.random()*10+1);
				account.withdraw(amount);
			}
		}
	}
	//账户类
	private static class Account
	{	
		//创建一个锁,static表示所有Account对象共用这把锁
		private static Lock lock = new ReentrantLock();
		//创建一个信号量
		private static Condition newDeposit = lock.newCondition();
		//定义一个账户余额,如果定义static则多个账户共享一个余额，不对
		private int balance = 0;
		//定义获取余额的方法
		public int getBalance()
		{
			return balance;
		}
		//存款的方法
		public void deposit(int amount) {
			//保证只有一个存款操作，并且存款时没有取款操作
			lock.lock();
			try
			{
				balance +=  amount;
				System.out.println(
					"Depsit:"+amount+"\n"+"CurrentMoney:"+balance);
				//通知其他取款和存款线程
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

		//取款的方法
		public void withdraw(int amount) {
			//保证只有一个取款操作，并且取款时没有存款操作
			lock.lock();
			try
			{
				//注意！！！此处不可用if(balance<amount)
				while (balance<amount)
				{
					//余额不足则等待
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

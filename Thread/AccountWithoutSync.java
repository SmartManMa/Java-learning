import java.util.concurrent.*;
class AccountWithoutSync 
{	
	//Account类对象 被多个AddTesk任务共享，static修饰始终只有一个Account类对象
	private static Account account = new Account();
	public static void main(String[] args) 
	{
		ExecutorService executor =  Executors.newCachedThreadPool();
		for (int i=0; i<100; i++)
		{
			executor.execute(new AddTesk());
		}
		//一定要关闭executor，不再接受新任务，否则出错
		executor.shutdown();
		while (!executor.isTerminated()){
			int i = 0;
			//System.out.println(++i);
			}
		//所有个线程终止executor.isTerninated()都返回true
			
		System.out.println(account.getBalance());
		
		//AccountWithoutSync.Account.print();
	}
	//内部类可以用private 和static修饰，因为内部类是外部类的成员
	//静态内部类所有成员变量自动静态？否
	private static class AddTesk implements Runnable
	{
		public void run() {
			account.deposit(1);
		}
	}
	private static class Account
	{   
		/*
		//静态内部类成员变量会自动初始化吗?经验证可以
		private static int balance;
		public  static void print() {
			System.out.println(balance);
		}
		*/
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		public void deposit(int amount) {
			int newBalance = balance + amount;
			try
			{
				Thread.sleep(0);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			balance = newBalance;
		}

	}
}

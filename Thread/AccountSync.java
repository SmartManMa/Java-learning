import java.util.concurrent.*;
class AccountSync 
{	
	//Account����� �����AddTesk������static����ʼ��ֻ��һ��Account�����
	private static Account account = new Account();
	public static void main(String[] args) 
	{
		ExecutorService executor =  Executors.newCachedThreadPool();
		for (int i=0; i<100; i++)
		{
			executor.execute(new AddTesk());
		}
		//һ��Ҫ�ر�executor�����ٽ��������񣬷������
		executor.shutdown();
		while (!executor.isTerminated()){
			int i = 0;
			//System.out.println(++i);
			}
		//���и��߳���ֹexecutor.isTerninated()������true
			
		System.out.println(account.getBalance());
		
		//AccountWithoutSync.Account.print();
	}
	//�ڲ��������private ��static���Σ���Ϊ�ڲ������ⲿ��ĳ�Ա
	//��̬�ڲ������г�Ա�����Զ���̬����
	private static class AddTesk implements Runnable
	{
		public void run() {
			account.deposit(1);
		}
	}
	private static class Account
	{   
		/*
		//��̬�ڲ����Ա�������Զ���ʼ����?����֤����
		private static int balance;
		public  static void print() {
			System.out.println(balance);
		}
		*/
		
		//private static int balance = 0;
		private static int balance = 0;
		public int getBalance() {
			return balance;
		}
		/*����һ�������ͬ���Ǿ�������synchronized��Ըö������,
		      ��ʱ��һ�������˸ö����ͬ���Ǿ��������߳̽�������
		  ����һ����ͬ����̬����������.��̬����������
			  synchronized��Ը��������
			  ��ʱ��һ�������˸����ͬ����̬�������߳̽�������
			  
		*/

		//public static synchronized void deposit(int amount) {
		public synchronized void deposit(int amount) {
			int newBalance = balance + amount;
			try
			{
				Thread.sleep(10);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			balance = newBalance;
		}

	}
}

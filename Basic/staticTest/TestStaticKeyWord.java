import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class TestStaticKeyWord 
{	//private static Account account = new Account();
	public static void main(String[] args) 
	{
		Account account1 = new Account();
		Account account2 = new Account();
		account1.deposit(10);
		account1.deposit(10);
		System.out.println(account2.getBalance());
	}
	private static class Account
	{
		//定义一个账户余额,如果定义static则多个账户共享一个余额，不对
		private static int balance = 0;
		//定义获取余额的方法
		public int getBalance()
		{
			return balance;
		}
		//存款的方法
		public void deposit(int amount) {
			balance = balance + amount;
		}

		//取款的方法
		public void withdraw(int amount) {
		
		}
	} 


}

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
		//����һ���˻����,�������static�����˻�����һ��������
		private static int balance = 0;
		//�����ȡ���ķ���
		public int getBalance()
		{
			return balance;
		}
		//���ķ���
		public void deposit(int amount) {
			balance = balance + amount;
		}

		//ȡ��ķ���
		public void withdraw(int amount) {
		
		}
	} 


}

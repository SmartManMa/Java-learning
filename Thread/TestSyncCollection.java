//���ϱ����Ŀ���ʧ��
//���������
import java.util.*;
class TestSyncCollection 
{	private static Set<String> hashSet = Collections.synchronizedSet(new HashSet<String>());
	
	public static void main(String[] args) 
	{
		hashSet.add("Test1");
		hashSet.add("Test2");
		hashSet.add("Test3");

		new Thread(new TraverseTask()).start();
		new Thread(new MotifyTask()).start();
		//new Thread(new TraverseTask()).start();
		//new Thread(new MotifyTask()).start();
		
	}
	private static class TraverseTask implements Runnable
	{
		public  void run(){
			synchronized(hashSet) {
				System.out.println("����");
				Iterator it = hashSet.iterator();
				try
				{
					while (it.hasNext())
					{
						System.out.println(it.next());
						Thread.sleep(100);
					}

				}
				catch (InterruptedException e)
				{
				}
				System.out.println("�������");
			}
		}	
	}
	private static class MotifyTask implements Runnable
	{
		public void run(){
			System.out.println("�޸�");
			hashSet.add("Test4");
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
			}
			
			hashSet.add("Test5");
			System.out.println("�޸����");
		}
		
	}
}

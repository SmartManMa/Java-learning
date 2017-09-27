//集合遍历的快速失败
//及解决方案
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
				System.out.println("遍历");
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
				System.out.println("遍历完成");
			}
		}	
	}
	private static class MotifyTask implements Runnable
	{
		public void run(){
			System.out.println("修改");
			hashSet.add("Test4");
			try
			{
				Thread.sleep(100);
			}
			catch (InterruptedException e)
			{
			}
			
			hashSet.add("Test5");
			System.out.println("修改完成");
		}
		
	}
}

class TestTry 
{
	public static void main(String[] args) 
	{
		//System.out.println(testOne());
		//System.out.println(testTwo());
		//System.out.println(testThree());
		System.out.println(testFour());
	}
	public static String testOne() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";

		try
		{
			return str1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			return str2;//�˴�return������
		}
		//return str3;������󣬸����Ϊ����ִ�е������
	}
	public static String testTwo() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";

		try
		{
			return str1;//�˴�return������
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			
		}
		return str3;
	}
	public static String testThree() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";

		try
		{
			System.exit(0);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			return str2;//�����δִ��
		}
		
	}
	public static String testFour() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";
		String str4="return in catch";
		//return str3;��������޷����ʵ�Try��䣬��ʱ����ִ��finally
		try
		{
			int i = 10;
			i = i/0;
		}
		catch (Exception e)
		{
			return str4;
		}
		finally 
		{
			return str2;
		}
		
	}
}

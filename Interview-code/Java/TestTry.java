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
			return str2;//此处return起作用
		}
		//return str3;编译错误，该语句为不能执行到的语句
	}
	public static String testTwo() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";

		try
		{
			return str1;//此处return起作用
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
			return str2;//此语句未执行
		}
		
	}
	public static String testFour() {
		String str1="return in try block";
		String str2="return in finally block";
		String str3="out of try_catch";
		String str4="return in catch";
		//return str3;编译错误：无法访问的Try语句，此时不会执行finally
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

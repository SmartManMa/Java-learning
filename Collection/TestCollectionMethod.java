import java.util.*;
class TestCollectionMethod 
{
	public static void main(String[] args) 
	{	
		List<Integer> list = Arrays.asList(3,9,2);

		System.out.println(Collections.max(list));
		System.out.println(Collections.min(list));
	}
}

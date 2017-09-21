import java.util.*;
class TestCloneMethod
{
	public static void main(String[] args) 
	{	
		LinkedList<String> list1 = new LinkedList<String>();
		list1.add("TEST");
		LinkedList<String> list2 = list1;//复制引用
		LinkedList<String> list3 = (LinkedList<String>)list1.clone();//复制整个链表
		list1.add("TEST+++++++++");

		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
	}
}

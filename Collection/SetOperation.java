import java.util.*;
class SetOperation 
{
	public static void main(String[] args) 
	{	
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		//为set1添加元素
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Keivn");
		set1.add("Mechael");
		//为set2添加元素
		set2.add("George");
		set2.add("Katie");
		set2.add("Keivn");
		set2.add("Ryan");
		//备份
		HashSet<String> setBackup1 = (HashSet<String>)set1.clone();
		HashSet<String> setBackup2 = (HashSet<String>)set2.clone();
		//交集
		System.out.println("----交集----");
		set1.retainAll(set2);
		System.out.println(set1);
		//并集
		set1 = (HashSet<String>)setBackup1.clone();
		//set1 = setBackup1;
		System.out.println("----并集----");
		set1.addAll(set2);
		System.out.println(set1);
		//System.out.println(setBackup1);
		//差集
		set1 = (HashSet<String>)setBackup1.clone();
		//set1 = setBackup1;
		System.out.println("----差集----");
		set1.removeAll(set2);
		System.out.println(set1);
		//System.out.println(setBackup1);
	}
}

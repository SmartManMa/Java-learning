import java.util.*;
class SetOperation 
{
	public static void main(String[] args) 
	{	
		HashSet<String> set1 = new HashSet<String>();
		HashSet<String> set2 = new HashSet<String>();
		//Ϊset1���Ԫ��
		set1.add("George");
		set1.add("Jim");
		set1.add("John");
		set1.add("Blake");
		set1.add("Keivn");
		set1.add("Mechael");
		//Ϊset2���Ԫ��
		set2.add("George");
		set2.add("Katie");
		set2.add("Keivn");
		set2.add("Ryan");
		//����
		HashSet<String> setBackup1 = (HashSet<String>)set1.clone();
		HashSet<String> setBackup2 = (HashSet<String>)set2.clone();
		//����
		System.out.println("----����----");
		set1.retainAll(set2);
		System.out.println(set1);
		//����
		set1 = (HashSet<String>)setBackup1.clone();
		//set1 = setBackup1;
		System.out.println("----����----");
		set1.addAll(set2);
		System.out.println(set1);
		//System.out.println(setBackup1);
		//�
		set1 = (HashSet<String>)setBackup1.clone();
		//set1 = setBackup1;
		System.out.println("----�----");
		set1.removeAll(set2);
		System.out.println(set1);
		//System.out.println(setBackup1);
	}
}

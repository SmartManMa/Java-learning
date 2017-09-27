abstract class SuperClass 
{
	//protected abstract void print() throws Exception;
		//System.out.println("I am father");
	protected abstract void print();
}
public class SubClass extends SuperClass
{
	public static void main(String[] args) throws Exception{
		//���Ը���
		SuperClass sub = new SubClass();
		sub.print();
		//��������
		SubClass sc = new SubClass();
		sc.overLoadTest("sdfghj");
		sc.overLoadTest();
		sc.overLoadTest(88);

	}
	/* 
	1������(override)ʱ���������ͷ���ֵ���ͱ����븸����ȫһ��
	2������Ȩ�����η����Ա��Ȩ�ޣ��������Ա�С
	3�������෽���ܳ��쳣�����������Ҳ�׳��쳣���������า�Ǹ��෽�������׳��쳣
	�����������Ǹ��෽������Ϊ�Ǵ���ģ�
	void print() {//����Ȩ�ޱ�С public > protected > Ĭ�� >private
		System.out.println("I am son");
	}

	protected void print()
	{
		//���������쳣����override��û��
		System.out.println("I am son");	
	}


	*/
	public void print(){
		System.out.println("I am son");
	}

	//�������أ�ͨ�������������ͺ�������ͬ��������ͬ������
	//���Ƿ��׳��쳣��������Ȩ�����η��޹أ����ǿ��Բ�ͬ
	public void overLoadTest(String str) {
		System.out.println("I am public"+str);
	} 
	private void overLoadTest() {
		System.out.println("I am private");
	}
	void overLoadTest(int i) throws Exception{
		System.out.println("I am default-"+i);
	}

}


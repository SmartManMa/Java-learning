class TestInc 
{
	public static void main(String[] args) 
	{
		int i = 0;
		i = i++;
		int j = 0;
		j = ++j;
		i = j;
		int k = 0;	
		k++;
		int m = 0;
		++m;
		m = m + k;

		//System.out.println(i+"Hello World!"+j);
	}
}

/*
 public static void main(java.lang.String[]);
   Code:
      0: iconst_0				//0��ջ
      1: istore_1				//ջ����ջ��Ԫ�أ�0�����ֲ�������indexΪ1��λ�� ��i=0��䡷;       
      2: iload_1				//�ӱ�����Ϊ1��λ��(0)ȡ��ֵ������ջ��(ջ��Ϊ0) ��i = i��䡷
      3: iinc          1, 1     //������Ϊ1��λ��Ԫ��(0)����  ��ʱiΪ1 ��i++��䡷
      6: istore_1				//ջ����ջ��Ԫ�أ�0�����ֲ�������indexΪ1��λ�� i=0;����iΪ0
      7: iconst_0				//0��ջ
      8: istore_2				//ջ����ջ��Ԫ�أ�0�����ֲ�������indexΪ2��λ�� ��j=0��䡷;
      9: iinc          2, 1		//������Ϊ2��λ��Ԫ��(0)����  ��ʱjΪ1 ��++j��䡷
     12: iload_2				//�ӱ�����Ϊ2��λ��(1)ȡ��ֵ������ջ��(ջ��Ϊ1) 
     13: istore_2				//ջ����ջ��Ԫ�أ�1�����ֲ�������indexΪ2��λ�� ����j=1;����jΪ1
     14: iconst_0				//0��ջ
     15: istore_3				//�ӱ�����Ϊ3��λ��(1)ȡ��ֵ������ջ��(ջ��Ϊ1) ����k=1;����kΪ1
     16: iinc          3, 1     //������Ϊ3��λ��Ԫ��(0)����  ��ʱkΪ1 ��k++��䡷
	 19: iconst_0
     20: istore        4		
	 22: iinc          4, 1
	 25: return

	 //i=0;i = i++�� jvm���ִ���أ���Ч�������ľ仰
	 1��i = 0
	 2��temp = i
	 3��i��1
	 4��i = temp

	 //j=0;j = ++j�� jvm���ִ���أ���Ч�������ľ仰
	 1��j = 0
	 2��j��1
	 3��temp = j
	 4��j = temp
     
*/

/*
 public static void main(java.lang.String[]);
   Code:
      0: iconst_0
      1: istore_1
      2: iload_1
      3: iinc          1, 1
      6: istore_1
      7: iconst_0
      8: istore_2
      9: iinc          2, 1
     12: iload_2
     13: istore_2
     14: iload_2
     15: istore_1
     16: iconst_0
     17: istore_3
     18: iinc          3, 1
     21: iconst_0
     22: istore        4
     24: iinc          4, 1
     27: iload         4
     29: iload_3
     30: iadd
     31: istore        4
     33: return
*/
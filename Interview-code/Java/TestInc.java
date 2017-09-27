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
      0: iconst_0				//0入栈
      1: istore_1				//栈弹出栈顶元素（0）到局部变量表index为1的位置 《i=0语句》;       
      2: iload_1				//从变量表为1的位置(0)取出值拷贝到栈顶(栈顶为0) 《i = i语句》
      3: iinc          1, 1     //变量表为1的位置元素(0)自增  此时i为1 《i++语句》
      6: istore_1				//栈弹出栈顶元素（0）到局部变量表index为1的位置 i=0;最终i为0
      7: iconst_0				//0入栈
      8: istore_2				//栈弹出栈顶元素（0）到局部变量表index为2的位置 《j=0语句》;
      9: iinc          2, 1		//变量表为2的位置元素(0)自增  此时j为1 《++j语句》
     12: iload_2				//从变量表为2的位置(1)取出值拷贝到栈顶(栈顶为1) 
     13: istore_2				//栈弹出栈顶元素（1）到局部变量表index为2的位置 变量j=1;最终j为1
     14: iconst_0				//0入栈
     15: istore_3				//从变量表为3的位置(1)取出值拷贝到栈顶(栈顶为1) 变量k=1;最终k为1
     16: iinc          3, 1     //变量表为3的位置元素(0)自增  此时k为1 《k++语句》
	 19: iconst_0
     20: istore        4		
	 22: iinc          4, 1
	 25: return

	 //i=0;i = i++； jvm如何执行呢？等效于下面四句话
	 1》i = 0
	 2》temp = i
	 3》i加1
	 4》i = temp

	 //j=0;j = ++j； jvm如何执行呢？等效于下面四句话
	 1》j = 0
	 2》j加1
	 3》temp = j
	 4》j = temp
     
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
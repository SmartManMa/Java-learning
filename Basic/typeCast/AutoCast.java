class AutoCast 
{	
	/**
	*对于整数常量默认是int型 浮点型常量默认为double型
	*byte   范围 -2^7 -- 2^7-1			8-bit
	*short  范围 -2^15 -- 2^15-1		16-bit
	*int    范围 -2^31 -- 2^31-1		32-bit
	*long   范围 -2^63 -- 2^63-1		64-bit
	*char   范围 0-65535(0 -- 2^16-1)	16-bit
	*float  精度 小数部分占7位			32-bit
	*double	精度 小数部分占15位			64-bit
	*/
	public static void main(String[] args) 
	{
		AutoCast.cast();
	}
	public static void cast() {
		int i,j;
		//编译错误2：
		//常量0.1默认是double型 超过float型的最大范围
		//float f1 = 0.1;
		//改正如下：
		float f1 = 0.1F;
		float f2 = 123;
		long l1 = 12345678;
		//编译错误1：
		//8888888888超过long型整数的最大范围
		//long l2=8888888888;
		//改正如下：
		long l2=88888888;
		double d1 = 2e20;
		double d2=124;
		//注意：虽然整型常量1 2 默认是int型，
		//但未1和2未超过byte范围，下面两条语句编译时并不报错
		//但byte b = b1-b2;编译出错
		byte b1 = 1;
		byte b2 = 2;
		//编译错误3：
		//byte型能表示的最大范围是127
		//byte b3 = 129;

		//编译错误8：
		//局部变量未初始化就使用
		//改正如下：为局部变量i，j赋初值0；
		i=0;
		j=0;
		j = j+10;
		i = i/10;
		//编译错误4：
		//常量0.1默认是double型,i*0.1运算时i的值也转换为double
		//i*0.1运算结果为double，java不会自动将double转为int,可以强制转换，但损失精度
		//i = i*0.1;
		//改正如下：
		i = (int)(i*0.1);
		char c1 = 'a';
		//注意：虽然整型常量125默认是int型，
		//但未125未超过byte范围，下面一条语句编译时并不报错
		//但char c = c1+c2;编译出错
		char c2 = 125;
		//编译错误5：
		//b1-b2的结果变为int型，java不会自动将int转为byte
		//byte b = b1-b2;
		//改正如下：强制类型转换，有可能损失精度
		byte b = (byte)(b1-b2);
		//编译错误6：
		//整型常量1默认是int型，运算时c1和c2的值提升为int型，
		//运算结果为int型,java不会自动将int转为char,可以强制转换，但可能损失精度
		//char c = c1+c2-1;
		char c = (char)(c1+c2-1);
		float f3 = f1+f2;
		//编译错误7：
		//浮点型常量0.1默认是double类型
		//float f4 = f1+f2*0.1;
		//改正如下：强制类型转换，有可能损失精度
		float f4 = (float)(f1+f2*0.1);
		double d = d1*i+j;
		float f = (float)(d1*5+d2);
	}
}

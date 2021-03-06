import  java.io.*;
class TestFileStream 
{
	public static void main(String[] args) 
	{
/*		if (args.length != 1)
		{
			System.out.println("Usage: java TestFileStream FileName");
			System.exit(0);
		}
		String fileName = args[0];
*/
		try
		{   //将文件封装成File对象
			//File file = new File("F:\\Java-learning\\IO\\temp.dat");
			//创建FileInputStream对象,temp.dat若存在，则覆盖，否则则创建temp.dat
			//FileOutputStream outStream = new FileOutputStream(file);
			FileOutputStream outStream = new FileOutputStream("F:\\Java-learning\\IO\\temp.dat");
			for (int i=0; i<10; i++ )
			{
				//写入
				outStream.write(i+10);
			}
			//关闭输出流
			outStream.close();

			//temp.dat若不存在，则抛出异常
			FileInputStream inStream = new FileInputStream("temp.dat");
			int value;
			//如果到达流的末尾，则返回 -1。
			while ((value = inStream.read())!= -1)
			{
				System.out.print(value+" ");
			}

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

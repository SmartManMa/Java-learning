import java.util.*;
import java.io.*;
import java.util.regex.*;
class CountKeyWord 
{
	public static void main(String[] args) 
	{  		
		if (args.length != 1)
		{
			System.out.println("Usage: java CountKeyWord FileName");
			System.exit(0);
		}
		String fileName = args[0];
		HashMap<String,Integer> hashMap = new HashMap<String,Integer>();

		String[] keywordString = {"abstract", "finally", "public",
      "boolean", "float", "return", "break", "for", "short", "byte",
      "goto", "static", "case", "if", "super", "catch", "implements",
      "switch", "char", "import", "synchronized", "class",
      "instanceof", "this", "const", "int", "throw", "continue",
      "interface", "throws", "default", "long", "transient", "do",
      "native", "try", "double", "new", "void", "else", "package",
      "volatile", "extends", "private", "while", "final",
      "protected", "true", "null","String"};
		//初始化Map
		for(String key:keywordString) {
			hashMap.put(key,0);
		}
		int count = 0;//统计总的关键字
		//Pattern pattern = Pattern.compile("[\\s*|\n|\t|\r|.|,|)|(|-|<|>]");
		Pattern pattern = Pattern.compile("[\\s*.\\s*<\\s*,\\s*>\\s*=\\s*(\\s*)]");
		try
		{
			FileReader fr = new FileReader(fileName);
			Scanner input = new Scanner(fr).useDelimiter(pattern);

			Pattern pa=input.delimiter();  
			System.out.println(pa.pattern());

			while (input.hasNext())
			{
				String token = input.next();
				//不为null，则是关键字
				if (hashMap.get(token)!=null)
				{
					//以 int 类型返回该 Integer 的值。
					int sum =hashMap.get(token).intValue();
					hashMap.put(token,++sum);
					count++;
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		Set<Map.Entry<String,Integer>> entrySet = hashMap.entrySet();
		for (Map.Entry<String,Integer> entry:entrySet)
		{
			System.out.println("关键字"+entry.getKey()+"出现了 "+entry.getValue()+" 次");
		}
		
		System.out.println("关键字共计："+count);
	}
}

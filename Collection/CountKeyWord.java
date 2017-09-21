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
		//��ʼ��Map
		for(String key:keywordString) {
			hashMap.put(key,0);
		}
		int count = 0;//ͳ���ܵĹؼ���
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
				//��Ϊnull�����ǹؼ���
				if (hashMap.get(token)!=null)
				{
					//�� int ���ͷ��ظ� Integer ��ֵ��
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
			System.out.println("�ؼ���"+entry.getKey()+"������ "+entry.getValue()+" ��");
		}
		
		System.out.println("�ؼ��ֹ��ƣ�"+count);
	}
}

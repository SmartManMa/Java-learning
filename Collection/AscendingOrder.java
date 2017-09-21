import java.util.*;
import java.io.*;
class AscendingOrder 
{
	public static void main(String[] args) 
	{
		if (args.length != 1)
		{
			System.out.println("Usage: java AscendingOrder FileName");
			System.exit(0);
		}
		String fileName = args[0];
		TreeSet<String> treeSet = new TreeSet<String>(); 
		try
		{
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader bfr = new BufferedReader(fr);
			String s = null;
			while ((s = bfr.readLine()) != null)
			{
				String[] tokens = s.split("[ |\n|\t|\r|.|,|)|(|-|\"]");
				treeSet.addAll(Arrays.asList(tokens));
			}
			for (String set : treeSet)
			{
				System.err.println(set);
			}

		}
		catch (Exception e)
		{
			System.err.println(e);
		}
	}
}

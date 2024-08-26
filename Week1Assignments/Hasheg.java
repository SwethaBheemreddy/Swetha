package Week1Assignments;
import java.util.HashSet;

public class Hasheg {
	public static void main(String args[])
	{
		HashSet<String> hss = new HashSet<>();
		/*hss.add("ccccc");
		hss.add("aaaa");
		hss.add("kjhdsgs");
		hss.add("bbbb");
		hss.add("aaa"); */
		hss.add(new City("city1" 1234, "capital1"));
		hss.add(new City("city2" 3456, "capital2"));
		hss.add(new City("city1" 1234, "capital1"));
		hss.add(new City("city3" 654321, "capital3"));
		for(City element: hss)
		{
			System.out.print(element+"\n");
		
		/*for(String element: hss)
		{
			System.out.print(element+"\t");  */
		}
	}

}

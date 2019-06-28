import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;




public class TreeSetDemo {

	public static void main(String[] args) {
		Set <Person> treeset= new TreeSet<Person>();
		  treeset.add(new Person(10,"BBB"));
		treeset.add(new Person(14,"Anirudha"));
		treeset.add(new Person(13,"sharayu"));
		treeset.add(new Person(11,"king"));
		
		Iterator<Person> iter=treeset.iterator();
		
		while(iter.hasNext())
		{
			Person ref= iter.next();
			System.out.println(ref.id);
			System.out.println(ref.name);
		}
		//serialization...
		System.out.println("Serilazation started...");
		String filename="serlization.txt";
		try {
			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(file);
			file.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Serilazation is done...");
		
		//deserilazation
		System.out.println("Deserilazation started...");
		try {
			FileInputStream fle = new FileInputStream(filename);
			ObjectInputStream obj = new ObjectInputStream(fle);
			TreeSet <Person> treeset2= (TreeSet<Person>) obj.readObject();
			Iterator<Person> iter2=treeset2.iterator();
			
			while(iter2.hasNext())
			{
				Person ref= iter2.next();
				System.out.println(ref.id);
				System.out.println(ref.name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Deserilazation Ended...");
	}

}

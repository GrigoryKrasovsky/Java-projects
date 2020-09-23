import java.util.HashMap;
import java.util.Scanner;

public class test {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap <String, HashMap<Character , Integer>> cash = new HashMap<>();
		int a =0;
		while (a<5) {
			a++;
			String string = scanner.nextLine();
			string = string.toUpperCase();
			HashMap <Character , Integer> mapOfDistinctChars = new HashMap<>();
			if(!cash.containsKey(string)) {
				for (int i =0; i<string.length();i++) {
					if(!mapOfDistinctChars.containsKey(string.charAt(i))) {
						mapOfDistinctChars.put(string.charAt(i),1);
					}else {
						int value = mapOfDistinctChars.get(string.charAt(i));
						mapOfDistinctChars.replace(string.charAt(i), value+1);
					}
				}
				System.out.println(mapOfDistinctChars.toString());
				System.out.println("not cash");
				cash.put(string, mapOfDistinctChars);
			}else {
				System.out.println(cash.get(string));
				System.out.println("cash");
			}
			
			
		}	
	}
}

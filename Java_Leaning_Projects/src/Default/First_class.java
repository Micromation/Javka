package Default;

public class First_class {
	public static void main(String[] args) {
		int age = 9;
		double x = 2.67;
		
		System.out.println("Hello World Kolega tu by� ale remake");
		System.out.println("Test Krakena");
		// Coś tam coś tam "blabla"
		System.out.println(age + x + " Coś tam coś tam \"blabla\"");
		String stringtest = "Jakub Gwadera zapuszcza żurawia";
		String substringtest = stringtest.substring(0,13);
		String substringtestvol2 = stringtest.substring(13);
		System.out.println(stringtest);
		System.out.println(substringtest);
		System.out.println(substringtestvol2);
		double number = 9;
		double result = Math.pow(number, number);
		System.out.println(result);
		
		String season = "Winter";
		String jakJest = switch (season) {
		case "Winter":
			yield "mrozi";
			default:
				yield "nico";
		};
		System.out.println(jakJest);
		
		int[] tablica = new int[10];
        //wypełnienie tablicy
        for (int i = 0; i < 10; i++) {
            tablica[i] = i + 1;
        }

        //wyświetlenie przy użyciu pętli for each
        for (int w : tablica) {
            System.out.println(w);
        }
		}
	
}

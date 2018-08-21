import java.util.Scanner;

public class Exercicio7
{
		public static void main (String args [])
		{
			Scanner s = new Scanner (System.in);

			System.out.println ("Please write down the student's name: ");
			String name = s.nextLine();

			float M1, M2, M3;

			System.out.println ("Please write down M1 grade: ");
			M1 = s.nextFloat();
			s.nextLine();

			System.out.println ("Please write down M2 grade: ");
			M2 = s.nextFloat();
			s.nextLine();

			System.out.println ("Please write down M3 grade: ");
			M3 = s.nextFloat();
			s.nextLine();
			
			float average = ((M1 + M2 + M3) / 3); 

			System.out.println ("Name: " + name);
			System.out.println ("Average: " + average);
			
			if (average >= 6)
				System.out.println ("Situation: Passed");
			else
				System.out.println ("Situation: Failed");  	
		}
}
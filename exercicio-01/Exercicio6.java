import java.util.Scanner;

public class Exercicio6
{
		public static void main (String args [])
		{
			Scanner wtf = new Scanner(System.in);
			System.out.println("Please write down 10 numbers") ; 
			
			int [] numbers = {0,0,0,0,0,0,0,0,0,0};
			int j, sum = 0, lowest = 9999999, greatest = -9999999;
			float average = 0;
			
			for ( int i = 0; i < 10; i++)
			{
				j = wtf.nextInt ();
				numbers [i] = j;
				wtf.nextLine(); 	
				sum = sum + numbers[i];
				if (numbers[i] < lowest)
					lowest = numbers[i];

				if (numbers[i] > greatest)
					greatest = numbers[i];
			}
			System.out.println ("Sum: " + sum);
			System.out.println ("Average: " + (average = sum / 10));
			System.out.println ("Highest number: " + greatest);
			System.out.println ("Lowest number: " + lowest);
		}
}
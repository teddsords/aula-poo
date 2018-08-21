public class Exercicio2
{
		public static void main (String args [])
		{
			String textnum = args[0];
			int num = Integer.parseInt (textnum);

			if (num == 1)
				System.out.print ("Domingo");
			
			else if (num == 2)
				System.out.print ("Segunda");

			else if (num == 3)
				System.out.print ("Terca");

			else if (num == 4)
				System.out.print ("Quarta");

			else if (num == 5)
				System.out.print ("Quinta");

			else if (num == 6)
				System.out.print ("Sexta");

			else if (num == 7)
				System.out.print ("Sabado");

			else
				System.out.print ("Please write a number between 1 and 7");
		}

}
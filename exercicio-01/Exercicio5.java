public class Exercicio5
{
		public static void main (String args [])
		{
			String textnum = args[0];
			int days = Integer.parseInt (textnum);
			textnum = args [1];
			int salary = Integer.parseInt(textnum);

			System.out.print ((salary / 22) * days);

		}
}
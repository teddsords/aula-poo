public class Exercicio4
{
		public static void main (String args [])
		{
			String textnum = args[0];
			int weight = Integer.parseInt (textnum);
			
			textnum = args[1];
			float height = Float.parseFloat(textnum);

			float IMC = weight / (height * height);

			System.out.print ("Your ideal weight is: " + IMC);
		}
}
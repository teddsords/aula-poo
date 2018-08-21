public class Exercicio3
{
		public static void main (String args [])
		{
			String textnum = args[0];
			int num = Integer.parseInt (textnum);

			String [] meses = {"Janeiro", "Fevereiro", "Marco", "Abril", "Maio", "Junho", "Julho" , "Agosto",
						"Setembro", "Outubro", "Novembro", "Dezembro" };

			if ( num >= 1 && num <= 12)
				System.out.print (meses[num - 1]);
		}
}
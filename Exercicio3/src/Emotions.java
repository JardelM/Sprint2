import java.util.Scanner;

public class Emotions {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String frase = in.nextLine();

		frase += " ";

		String[] sentimentoFeliz = frase.split(":-\\)");
		String[] sentimentoTriste = frase.split(":-\\(");

		if (sentimentoFeliz.length == sentimentoTriste.length) {
			System.out.println("neutro");

		} else if (sentimentoFeliz.length > sentimentoTriste.length) {
			System.out.println("divertido");

		} else
			System.out.println("chateado");

		in.close();

	}

}

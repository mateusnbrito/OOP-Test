import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		ConversaoDeUnidadesDeArea conversoes = new ConversaoDeUnidadesDeArea();

		System.out.println("O valor convertido em Pés Quadrados é: "+conversoes.m2ParaPe2(1));
		System.out.println("O valor convertido em Centímetros Quadrados é: "+conversoes.pe2ParaCm2(1));
		System.out.println("O valor convertido em Acres é: "+conversoes.milha2ParaAcre(1));
		System.out.println("O valor convertido em Pés Quadrados é: "+conversoes.acreParaPe2(1));


		System.out.println("\nInsira o valor a área do campo de futebol (Em m2): ");
		System.out.println("\nO valor convertido em Pés Quadrados, Acres e Centímetros Quadrados é: "+Arrays.toString(conversoes.m2ParaP2AcreCm2(scanner.nextDouble())));

		scanner.close();
	}
}

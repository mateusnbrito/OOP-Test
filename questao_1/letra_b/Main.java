import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		ConversaoDeUnidadesDeArea conversoes = new ConversaoDeUnidadesDeArea();

		System.out.println("\nInsira o valor a área do campo de futebol (Em m2): ");
		System.out.println("\nO valor convertido em Pés Quadrados, Acres e Centímetros Quadrados é: "+Arrays.toString(conversoes.m2ParaP2AcreCm2(scanner.nextDouble())));

		scanner.close();
	}
}

public class Main {
	public static void main(String[] args){
		ConversaoDeUnidadesDeArea conversoes = new ConversaoDeUnidadesDeArea();
    Double valor;

    valor = 1.0;

		System.out.println("O valor convertido em Pés Quadrados é: "+conversoes.m2ParaPe2(valor));
		System.out.println("O valor convertido em Centímetros Quadrados é: "+conversoes.pe2ParaCm2(valor));
		System.out.println("O valor convertido em Acres é: "+conversoes.milha2ParaAcre(valor));
		System.out.println("O valor convertido em Pés Quadrados é: "+conversoes.acreParaPe2(valor));
	}
}

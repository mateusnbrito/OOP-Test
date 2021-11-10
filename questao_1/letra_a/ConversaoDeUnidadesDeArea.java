public class ConversaoDeUnidadesDeArea {
	private double pe2EmM2 = 10.76;
	private double acreEmM2 = 0.00024;
	private double cm2EmM2 = 9996.04; // Valor obtido através de conversão. O valor real deveria ser 10000.
	private double cm2EmPe2 = 929;
	private double acreEmMilha2 = 640;
	private double pe2EmAcre = 43560;

	public double m2ParaPe2(double _input){
		return _input*this.pe2EmM2;
	}

	public double pe2ParaCm2(double _input){
		return _input*this.cm2EmPe2;
	}

	public double milha2ParaAcre(double _input){
		return _input*this.acreEmMilha2;
	}

	public double acreParaPe2(double _input){
		return _input*this.pe2EmAcre;
	}

	public double[] m2ParaP2AcreCm2(double _input){
		double[] arrayDeMedidas = {_input*this.pe2EmM2, _input*this.acreEmM2, _input*this.cm2EmM2};

		return arrayDeMedidas;
	}
}
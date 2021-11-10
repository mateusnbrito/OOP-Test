public class ConversaoDeUnidadesDeArea {
	private Double pe2EmM2 = 10.76;
	private Double acreEmM2 = 0.00024;
	private Double cm2EmM2 = 9996.04; // Valor obtido através de conversão. O valor real deveria ser 10000.
	private Double cm2EmPe2 = 929.0;
	private Double acreEmMilha2 = 640.0;
	private Double pe2EmAcre = 43560.0;

	public Double m2ParaPe2(Double _input){
		return _input*this.pe2EmM2;
	}

	public Double pe2ParaCm2(Double _input){
		return _input*this.cm2EmPe2;
	}

	public Double milha2ParaAcre(Double _input){
		return _input*this.acreEmMilha2;
	}

	public Double acreParaPe2(Double _input){
		return _input*this.pe2EmAcre;
	}

	public Double[] m2ParaP2AcreCm2(Double _input){
		Double[] arrayDeMedidas = {_input*this.pe2EmM2, _input*this.acreEmM2, _input*this.cm2EmM2};

		return arrayDeMedidas;
	}
}
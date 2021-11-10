public class ConversaoDeUnidadesDeArea {
	private Double pe2EmM2 = 10.76;
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
}
public class Nota {
  private Aluno aluno;
  private double valor;
  private Disciplina disciplina;

	Nota(Aluno _aluno, double _valor, Disciplina _disciplina){
    this.aluno = _aluno;
    this.valor = _valor;
    this.disciplina = _disciplina;
	}

	public void setValor(double _valor){
		this.valor = _valor;
	}

  public void setValor(Aluno _aluno){
		this.aluno = _aluno;
	}

  public void setDisciplina(Disciplina _disciplina){
		this.disciplina = _disciplina;
	}

	public double getValor(){
		return this.valor;
	}

  public Aluno getAluno(){
		return this.aluno;
	}

  public Disciplina getDisciplina(){
		return this.disciplina;
	}
}

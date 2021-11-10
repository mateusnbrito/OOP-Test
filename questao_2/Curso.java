import java.util.Arrays;

public class Curso {
	private String nome;
  private Disciplina[] disciplinas = {};
  private Aluno[] alunos = {};
  private Aluno[] exAlunos = {};

  Curso(){}

  Curso(String _nome){
    this.nome = _nome;
  }

  public void setNome(String _nome){
		this.nome = _nome;
	}

  public void setDisciplinas(Disciplina[] _disciplinas){
		this.disciplinas = _disciplinas;
	}

  public void addDisciplina(Disciplina _disciplina){
    this.disciplinas = Arrays.copyOf(this.disciplinas, (this.disciplinas.length)+1);
		this.disciplinas[(this.disciplinas.length)-1] = _disciplina;
	}

  public void removeDisciplina(int _codigo){
		for(int i=0; i<this.disciplinas.length; i++){
			Disciplina disciplina = this.disciplinas[i];

			if(disciplina.getCodigo() == _codigo){
				disciplina = null;
			}
		}
	}

  public void addAluno(Aluno _aluno){
    this.alunos = Arrays.copyOf(this.alunos, (this.alunos.length)+1);
		this.alunos[(this.alunos.length)-1] = _aluno;
	}

  public void addExAluno(Aluno _aluno){
    this.exAlunos = Arrays.copyOf(this.exAlunos, (this.exAlunos.length)+1);
		this.exAlunos[(this.exAlunos.length)-1] = _aluno;
	}

  public void removeAluno(int _matricula){
		for(int i=0; i<this.alunos.length; i++){
			Aluno aluno = this.alunos[i];

			if(aluno.getMatricula() == _matricula){
				aluno = null;
			}
		}
	}

	public String getNome(){
		return this.nome;
	}

  public Disciplina[] getDisciplinas(){
		return this.disciplinas;
	}

  public Aluno[] getAlunos(){
		return this.alunos;
	}

  public Aluno[] getExAlunos(){
		return this.exAlunos;
	}
}

import java.util.Arrays;

public class Aluno {
  private int matricula;
	private Curso curso;
	private Disciplina[] disciplinas = {};

	Aluno(int _matricula, Curso _curso){
		this.matricula = _matricula;
		this.curso = _curso;
	}

	public void setMatricula(int _matricula){
		this.matricula = _matricula;
	}

	public void setCurso(Curso _curso){
		this.curso = _curso;
	}

	public void addDisciplina(Disciplina _disciplina){
		disciplinas = Arrays.copyOf(disciplinas, (disciplinas.length)+1);
		disciplinas[(disciplinas.length)-1] = _disciplina;
	}

	public void removeDisciplina(int _codigo){
		for(int i=0; i<disciplinas.length; i++){
			Disciplina disciplina = disciplinas[i];

			if(disciplina.getCodigo() == _codigo){
				disciplina = null;
			}
		}
	}

	public int getMatricula(){
		return this.matricula;
	}

	public Curso getCurso(){
		return this.curso;
	}

	public Disciplina[] getdisciplinas(){
		return this.disciplinas;
	}

	public Aula[] getAulas(){
		Aula[] aulas = {};

		for(int i=0; i<disciplinas.length; i++){
			Disciplina disciplinaAtiva = disciplinas[i];

			for(int j=0; j<(disciplinaAtiva.getAulas()).length; j++){
				Aula aula = disciplinaAtiva.getAulas()[j];

			aulas = Arrays.copyOf(aulas, (aulas.length)+1);
			aulas[(aulas.length)-1] = aula;
			}
		}

		return aulas;
	}
}

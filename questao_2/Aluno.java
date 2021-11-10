import java.util.Arrays;

public class Aluno {
  private int matricula;
	private Curso curso;
	private Disciplina[] disciplinasAtivas = {};
	private Disciplina[] disciplinasConcluidas = {};

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

	public void addDisciplinaAtiva(Disciplina _disciplinaAtiva){
		disciplinasAtivas = Arrays.copyOf(disciplinasAtivas, (disciplinasAtivas.length)+1);
		disciplinasAtivas[(disciplinasAtivas.length)-1] = _disciplinaAtiva;
	}

	public void removeDisciplinaAtiva(int _codigo){
		for(int i=0; i<disciplinasAtivas.length; i++){
			Disciplina disciplinaAtiva = disciplinasAtivas[i];

			if(disciplinaAtiva.getCodigo() == _codigo){
				disciplinaAtiva = null;
			}
		}
	}

	public void addDisciplinaConcluida(Disciplina _disciplinaConcluida){
		disciplinasConcluidas = Arrays.copyOf(disciplinasConcluidas, (disciplinasConcluidas.length)+1);
		disciplinasConcluidas[(disciplinasConcluidas.length)-1] = _disciplinaConcluida;
	}

	public void removeDisciplinaConcluida(int _codigo){
		for(int i=0; i<disciplinasConcluidas.length; i++){
			Disciplina disciplinaConcluida = disciplinasConcluidas[i];

			if(disciplinaConcluida.getCodigo() == _codigo){
				disciplinaConcluida = null;
			}
		}
	}

	public int getMatricula(){
		return this.matricula;
	}

	public Curso getCurso(){
		return this.curso;
	}

	public Disciplina[] getDisciplinasAtivas(){
		return this.disciplinasAtivas;
	}

	public Disciplina[] getDisciplinasConcluidas(){
		return this.disciplinasConcluidas;
	}

	public Aula[] getAulas(){
		Aula[] aulas = {};

		for(int i=0; i<disciplinasAtivas.length; i++){
			Disciplina disciplinaAtiva = disciplinasAtivas[i];

			for(int j=0; j<(disciplinaAtiva.getAulas()).length; j++){
				Aula aula = disciplinaAtiva.getAulas()[j];

			aulas = Arrays.copyOf(aulas, (aulas.length)+1);
			aulas[(aulas.length)-1] = aula;
			}
		}

		return aulas;
	}
}

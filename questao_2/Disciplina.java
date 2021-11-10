import java.util.Arrays;

public class Disciplina {
  private int codigo;
	private String sigla;
	private String nome;
	private Aula[] aulas = {};
  private Aluno[] alunos = {};
  private Nota[] notas = {};

	Disciplina(int _codigo, String _sigla, String _nome){
		this.codigo = _codigo;
		this.sigla = _sigla;
		this.nome = _nome;
	}

	public void setCodigo(int _codigo){
		this.codigo = _codigo;
	}

	public void setSigla(String _sigla){
		this.sigla = _sigla;
	}

	public void setNome(String _nome){
		this.nome = _nome;
	}

	public void addAula(Aula _aula){
		this.aulas = Arrays.copyOf(this.aulas, (this.aulas.length)+1);
		this.aulas[(this.aulas.length)-1] = _aula;
	}

  public void addAluno(Aluno _aluno){
		this.alunos = Arrays.copyOf(this.alunos, (this.alunos.length)+1);
		this.alunos[(this.alunos.length)-1] = _aluno;
	}

  public void addNota(Nota _nota){
		this.notas = Arrays.copyOf(this.notas, (this.notas.length)+1);
		this.notas[(this.notas.length)-1] = _nota;
	}

	public int getCodigo(){
		return this.codigo;
	}

	public String getSigla(){
		return this.sigla;
	}

	public String getNome(){
		return this.nome;
	}

	public Aula[] getAulas(){
		return this.aulas;
	}

  public Aluno[] getAlunos(){
		return this.alunos;
	}

  public Nota[] getNotas(){
		return this.notas;
	}
}

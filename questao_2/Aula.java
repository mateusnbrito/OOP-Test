import java.time.LocalDate;
import java.time.LocalTime;

public class Aula {
  private LocalDate data;
	private LocalTime horarioInicio;
	private LocalTime horarioFim;
	private double duracao;
  private Disciplina disciplina;

	Aula(LocalDate _data, LocalTime _horarioInicio, LocalTime _horarioFim, double _duracao, Disciplina _disciplina){
		this.data = _data;
		this.horarioInicio = _horarioInicio;
		this.horarioFim = _horarioFim;
		this.duracao = _duracao;
    this.disciplina = _disciplina;
	}

	public void setData(LocalDate _data){
		this.data = _data;
	}

	public void setHorarioInicio(LocalTime _horarioInicio){
		this.horarioInicio = _horarioInicio;
	}

	public void setHorarioFim(LocalTime _horarioFim){
		this.horarioFim = _horarioFim;
	}

	public void setDuracao(Double _duracao){
		this.duracao = _duracao;
	}

  public void setDisciplina(Disciplina _disciplina){
		this.disciplina = _disciplina;
	}

	public LocalDate getData(){
		return this.data;
	}

	public LocalTime getHorarioInicio(){
		return this.horarioInicio;
	}

	public LocalTime getHorarioFim(){
		return this.horarioFim;
	}

	public Double getDuracao(){
		return this.duracao;
	}

  public Disciplina getDisciplina(){
		return this.disciplina;
	}
}

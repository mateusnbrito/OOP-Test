import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

public class Main {
  private Curso[] cursos = {};

  public static void main(String[] args){
    Gui gui = new Gui();
	}

  public void fecharPrograma(){
    System.exit(0);
  }

  public Optional<Curso> criarCurso(String _nome){
    Optional<Curso> optionalValue = null;

    try {
      Curso novoCurso = new Curso(_nome);

      this.cursos = Arrays.copyOf(this.cursos, (this.cursos.length)+1);
      this.cursos[(this.cursos.length)-1] = novoCurso;

      optionalValue = Optional.ofNullable(novoCurso);
    } catch (Exception e) {
      optionalValue = null;
    }

    return optionalValue;
  }

  public Optional<Curso[]> getCursos(){
    Optional<Curso[]> optionalValue = null;

    if(this.cursos.length > 0){
      optionalValue = Optional.ofNullable(this.cursos);
    }

    return optionalValue;
  }

  public Optional<Disciplina> criarDisciplina(String _nomeCurso, int _codigo, String _sigla, String _nome){
    Optional<Disciplina> optionalValue = null;
    Boolean valorRepetido = false;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigo){
            valorRepetido = true;
          }
        }

        if(!valorRepetido){
          Disciplina novaDisciplina = new Disciplina(_codigo, _sigla, _nome);

          curso.addDisciplina(novaDisciplina);
          optionalValue = Optional.ofNullable(novaDisciplina);
        }
      }
    }

    return optionalValue;
  }

  //REVER
  //Criando disciplinas
  public Optional<Disciplina[]> getDisciplinas(String _nomeCurso){
    Optional<Disciplina[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        optionalValue = Optional.ofNullable(curso.getDisciplinas());
      }
    }

    return optionalValue;
  }

  //REVER
  public Optional<Disciplina> updateDisciplina(String _nomeCurso, int _antigoCodigoDisciplina, int _novoCodigoDisciplina, String _sigla, String _nome){
    Optional<Disciplina> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _antigoCodigoDisciplina){

            disciplina.setCodigo(_novoCodigoDisciplina);
            disciplina.setSigla(_sigla);
            disciplina.setNome(_nome);

            optionalValue = Optional.ofNullable(disciplina);
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Disciplina> removeDisciplina(String _nomeCurso, int _codigoDisciplina){
    Optional<Disciplina> optionalValue = null;
    Disciplina[] disciplinas = {};

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() != _codigoDisciplina){
            disciplinas = Arrays.copyOf(disciplinas, (disciplinas.length)+1);
            disciplinas[(disciplinas.length)-1] = disciplina;
          }
          else{
            optionalValue = Optional.ofNullable(disciplina);
          }
        }

        curso.setDisciplinas(disciplinas);
      }
    }

    return optionalValue;
  }

  public Optional<Aluno> matricularAlunoCurso(String _nomeCurso, int _matriculaAluno){
    Optional<Aluno> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        Aluno aluno = new Aluno(_matriculaAluno, curso);
        
        curso.addAluno(aluno);

        optionalValue = Optional.ofNullable(aluno);
      }
    }

    return optionalValue;
  }

  public Optional<Aluno> matricularAlunoDisciplina(String _nomeCurso, int _codigoDisciplina, int _matriculaAluno){
    Optional<Aluno> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina){
            for(int l=0; l<(curso.getAlunos()).length; l++){
              Aluno aluno = curso.getAlunos()[l];

              if(aluno.getMatricula() == _matriculaAluno){
                aluno.addDisciplina(disciplina);
                disciplina.addAluno(aluno);

                optionalValue = Optional.ofNullable(aluno);
              }
            }
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Aula[]> listarAulasCurso(String _nomeCurso){
    Optional<Aula[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        Aula[] aulas = {};

        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if((disciplina.getAulas()).length > 0){
            for(int l=0; l<(disciplina.getAulas()).length; l++){
              Aula aula = disciplina.getAulas()[l];
  
              aulas = Arrays.copyOf(aulas, (aulas.length)+1);
              aulas[(aulas.length)-1] = aula;
            }
          }
        }

        optionalValue = Optional.ofNullable(aulas);
      }
    }

    return optionalValue;
  }

  public Optional<Aula[]> listarAulasDisciplina(String _nomeCurso, int _codigoDisciplina){
    Optional<Aula[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        Aula[] aulas = {};

        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina && (disciplina.getAulas()).length > 0){
            for(int l=0; l<(disciplina.getAulas()).length; l++){
              Aula aula = disciplina.getAulas()[l];
  
              aulas = Arrays.copyOf(aulas, (aulas.length)+1);
              aulas[(aulas.length)-1] = aula;

              optionalValue = Optional.ofNullable(aulas);
            }
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Aula[]> listarAulasAluno(String _nomeCurso, int _matriculaAluno){
    Optional<Aula[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso) && (curso.getDisciplinas()).length > 0){
        Aula[] aulas = {};

        for(int j=0; j<(curso.getDisciplinas()).length; j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if((disciplina.getAulas()).length > 0){
            for(int l=0; l<(disciplina.getAlunos()).length; l++){
              Aluno aluno = disciplina.getAlunos()[l];
  
              if(aluno.getMatricula() == _matriculaAluno){
                for(int m=0; m<(disciplina.getAulas()).length; m++){
                  Aula aula = disciplina.getAulas()[l];
      
                  aulas = Arrays.copyOf(aulas, (aulas.length)+1);
                  aulas[(aulas.length)-1] = aula;
                }
              }
            }
          }
        }

        optionalValue = Optional.ofNullable(aulas);
      }
    }

    return optionalValue;
  }

  public Optional<Aluno[]> listarAlunosCurso(String _nomeCurso){
    Optional<Aluno[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        optionalValue = Optional.ofNullable(curso.getAlunos());
      }
    }

    return optionalValue;
  }

  public Optional<Boolean> getStatusConclusaoAluno(String _nomeCurso, int _numeroMatricula){
    Optional<Boolean> optionalValue = null;
    Boolean disciplinasConcluidas = false;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getAlunos()).length; j++){
          Aluno aluno = curso.getAlunos()[j];
  
          if(aluno.getMatricula() == _numeroMatricula){
            for(int l=0; l<(aluno.getdisciplinas()).length; l++){
              Disciplina disciplina = aluno.getdisciplinas()[l];
  
              if(disciplina.getStatusConclusao()){
                disciplinasConcluidas = true;
              }
            }
          }
        }

        optionalValue = Optional.ofNullable(disciplinasConcluidas);
      }
    }

    return optionalValue;
  }

  public Optional<Aluno[]> listarExAlunosCurso(String _nomeCurso){
    Optional<Aluno[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        optionalValue = Optional.ofNullable(curso.getExAlunos());
      }
    }

    return optionalValue;
  }

  public Optional<Aula> criarAulaDisciplina(String _nomeCurso, int _codigoDisciplina, LocalDate _data, LocalTime _horarioInicio, LocalTime _horarioFim, Double _duracao){
    Optional<Aula> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas().length); j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina){
            Aula aula = new Aula(_data, _horarioInicio, _horarioFim, _duracao, disciplina);

            disciplina.addAula(aula);

            optionalValue = Optional.ofNullable(aula);
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Aula> modificarAulaDisciplina(String _nomeCurso, int _codigoDisciplina, LocalDate _data, LocalTime _horarioInicio, LocalTime _horarioFim, Double _duracao){
    Optional<Aula> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas().length); j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina){
            for(int l=0; l<(disciplina.getAulas()).length; l++){
              Aula aula = disciplina.getAulas()[l];

              aula.setData(_data);
              aula.setHorarioInicio(_horarioInicio);
              aula.setHorarioFim(_horarioFim);
              aula.setDuracao(_duracao);

            optionalValue = Optional.ofNullable(aula);
            }
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Nota> criarNotaDisciplina(String _nomeCurso, int _codigoDisciplina, int _matriculaAluno, Double _nota){
    Optional<Nota> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas().length); j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina){
            for(int l=0; l<(disciplina.getAlunos()).length; l++){
              Aluno aluno = disciplina.getAlunos()[l];

              if(aluno.getMatricula() == _matriculaAluno){
                Nota nota = new Nota(aluno, _nota, disciplina);

                disciplina.addNota(nota);

                optionalValue = Optional.ofNullable(nota);
              }
            }
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Nota[]> listarNotasDisciplina(String _nomeCurso, int _codigoDisciplina){
    Optional<Nota[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas().length); j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          if(disciplina.getCodigo() == _codigoDisciplina){
            Nota[] notas = disciplina.getNotas();

            optionalValue = Optional.ofNullable(notas);
          }
        }
      }
    }

    return optionalValue;
  }

  public Optional<Nota[]> listarNotasAluno(String _nomeCurso, int _matriculaAluno){
    Optional<Nota[]> optionalValue = null;

    for(int i=0; i<cursos.length; i++){
      Curso curso = cursos[i];
      Nota[] notas = {};

      if(curso.getNome().equals(_nomeCurso)){
        for(int j=0; j<(curso.getDisciplinas().length); j++){
          Disciplina disciplina = curso.getDisciplinas()[j];

          for(int l=0; l<(disciplina.getNotas()).length; l++){
            Nota nota = disciplina.getNotas()[l];

            if(nota.getAluno().getMatricula() == _matriculaAluno){
              notas = Arrays.copyOf(notas, (notas.length)+1);
              notas[(notas.length)-1] = nota;
            }
          }

          optionalValue = Optional.ofNullable(notas);
        }
      }
    }

    return optionalValue;
  }
}

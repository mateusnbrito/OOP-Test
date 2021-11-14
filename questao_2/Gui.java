import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Optional;

public class Gui extends JFrame{
  Main main = new Main();
  Container contentPane = getContentPane();

	public Gui(){
		super("Prova INF008 - Questão 2 - Mateus Nascimento Brito");

		JMenuBar menuBar = new JMenuBar();

		JMenu optionsMenu = new JMenu("Menu");
		JMenu courseMenu = new JMenu("Curso");
		JMenu subjectMenu = new JMenu("Disciplina");
		JMenu studentMenu = new JMenu("Aluno");

		JMenuItem option0 = new JMenuItem("Sair");
		JMenuItem option1 = new JMenuItem("Criar curso");
		JMenuItem option2 = new JMenuItem("Listar cursos");
		JMenuItem option3 = new JMenuItem("Matricular aluno em um curso");
		JMenuItem option4 = new JMenuItem("Listar alunos de um curso");
		JMenuItem option5 = new JMenuItem("Listar ex-alunos de um curso");
    JMenuItem option6 = new JMenuItem("Listar horários de aula de um curso");
		JMenuItem option7 = new JMenuItem("Criar disciplina");
		JMenuItem option8 = new JMenuItem("Listar disciplinas");
		JMenuItem option9 = new JMenuItem("Modificar disciplina");
    JMenuItem option10 = new JMenuItem("Remover disciplina");
		JMenuItem option11 = new JMenuItem("Matricular aluno em uma disciplina");
		JMenuItem option12 = new JMenuItem("Criar horário de aula de uma disciplina");
		JMenuItem option13 = new JMenuItem("Listar horários de aula de uma disciplina");
		JMenuItem option14 = new JMenuItem("Modificar horário de aula de uma disciplina");
		JMenuItem option15 = new JMenuItem("Inserir nota em uma disciplina");
		JMenuItem option16 = new JMenuItem("Listar notas em uma disciplina");
		JMenuItem option17 = new JMenuItem("Listar aulas de um aluno");
    JMenuItem option18 = new JMenuItem("Listar notas de um aluno");

		setJMenuBar(menuBar);

		menuBar.add(optionsMenu);

		optionsMenu.add(courseMenu);
		optionsMenu.add(subjectMenu);
		optionsMenu.add(studentMenu);
    courseMenu.add(option1);
    courseMenu.add(option2);
    courseMenu.add(option3);
    courseMenu.add(option4);
    courseMenu.add(option5);
    courseMenu.add(option6);
    subjectMenu.add(option7);
    subjectMenu.add(option8);
    subjectMenu.add(option9);
    subjectMenu.add(option10);
    subjectMenu.add(option11);
    subjectMenu.add(option12);
    subjectMenu.add(option13);
    subjectMenu.add(option14);
    subjectMenu.add(option15);
    subjectMenu.add(option16);
    studentMenu.add(option17);
    studentMenu.add(option18);
		optionsMenu.add(option0);

		option0.addActionListener((ActionListener) new ActionListener(){
			public void actionPerformed(ActionEvent event) {
        main.fecharPrograma();
			}
		});

    option1.addActionListener((ActionListener) new ActionListener(){
      Optional<Curso> curso;
      String input0Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel = new JLabel("Nome do Curso");
        JTextField textInputField = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel);
        textInputPanel.add(textInputField);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField.getText().toString();

            curso = main.criarCurso(input0Content);

            try {
              System.out.println(curso.get().getNome());
            } catch (Exception e) {
              System.out.println("O curso não pode ser criado.");
            }

            textInputField.setText("");
          }
        });
			}
		});

    option2.addActionListener((ActionListener) new ActionListener(){
      Optional<Curso[]> cursos;
      String[] colunas = {"Nome"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        cursos = main.getCursos();

        try {
          for(int i=0; i<cursos.get().length; i++){
            Curso curso = cursos.get()[i];
            String[] cursosNomes = {curso.getNome()};

            dados = Arrays.copyOf(dados, (dados.length)+1);
            dados[(dados.length)-1] = cursosNomes;
          }

          contentPane.removeAll();
          contentPane.revalidate();
          contentPane.repaint();

          contentPane.add(imprimirInfo(dados, colunas));
          limparDados();

        } catch (Exception e) {
          System.out.println("Não foram encontrados cursos.");
        }
			}
		});

    option3.addActionListener((ActionListener) new ActionListener(){
      Optional<Aluno> aluno;
      String input0Content;
      int input1Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JTextField textInputField0 = new JTextField();
        JLabel textInputLabel1 = new JLabel("Matricula do Aluno");
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            aluno = main.matricularAlunoCurso(input0Content, input1Content);

            try {
              System.out.println(aluno.get().getMatricula());
            } catch (Exception e) {
              System.out.println("Não foi possível matricular o aluno no curso.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

    option4.addActionListener((ActionListener) new ActionListener(){
      Optional<Aluno[]> alunos;
      String input0Content;
      String[] colunas = {"Matricula"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JTextField textInputField0 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();

            alunos = main.listarAlunosCurso(input0Content);

            try {
              for(int i=0; i<alunos.get().length; i++){
                Aluno aluno = alunos.get()[i];
                String[] alunoMatricula = {Integer.toString(aluno.getMatricula())};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = alunoMatricula;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Alunos não puderam ser encontrados.");
            }

            textInputField0.setText("");
          }
        });
			}
		});

    option5.addActionListener((ActionListener) new ActionListener(){
      Optional<Aluno[]> alunos;
      String input0Content;
      String[] colunas = {"Nome"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JTextField textInputField0 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();

            alunos = main.listarExAlunosCurso(input0Content);

            try {
              for(int i=0; i<alunos.get().length; i++){
                Aluno aluno = alunos.get()[i];
                String[] alunoMatricula = {Integer.toString(aluno.getMatricula())};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = alunoMatricula;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Ex-alunos não puderam ser encontrados.");
            }

            textInputField0.setText("");
          }
        });
			}
		});

    option6.addActionListener((ActionListener) new ActionListener(){
      Optional<Aula[]> aulas;
      String input0Content;
      String[] colunas = {"Início", "Fim"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JTextField textInputField0 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();

            aulas = main.listarAulasCurso(input0Content);

            try {
              for(int i=0; i<aulas.get().length; i++){
                Aula aula = aulas.get()[i];

                String[] aulaInicioFim = {(aula.getHorarioInicio()).toString(), (aula.getHorarioFim()).toString()};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = aulaInicioFim;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Aulas do curso não foram encontradas.");
            }
    
            textInputField0.setText("");
          }
        });
			}
		});

    option7.addActionListener((ActionListener) new ActionListener(){
      Optional<Disciplina> disciplina;
      String input0Content;
      int input1Content;
      String input2Content;
      String input3Content;
      String input4Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JLabel textInputLabel2 = new JLabel("Sigla da Disciplina");
        JLabel textInputLabel3 = new JLabel("Nome da Disciplina");
        JLabel textInputLabel4 = new JLabel("Nome do Docente");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JTextField textInputField3 = new JTextField();
        JTextField textInputField4 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));
        textInputField3.setPreferredSize(new Dimension(200, 24));
        textInputField4.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);
        textInputPanel.add(textInputLabel3);
        textInputPanel.add(textInputField3);
        textInputPanel.add(textInputLabel4);
        textInputPanel.add(textInputField4);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = textInputField2.getText().toString();
            input3Content = textInputField3.getText().toString();
            input4Content = textInputField4.getText().toString();

            disciplina = main.criarDisciplina(input0Content, input1Content, input2Content, input3Content, input4Content);

            try {
              System.out.println(disciplina.get().getCodigo());
            } catch (Exception e) {
              System.out.println("A disciplina não pode foi criada.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
            textInputField3.setText("");
          }
        });
			}
		});

    option8.addActionListener((ActionListener) new ActionListener(){
      Optional<Disciplina[]> disciplinas;
      String input0Content;
      String[] colunas = {"Codigo", "Sigla", "Nome", "Docente"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JTextField textInputField0 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();

            disciplinas = main.getDisciplinas(input0Content);

            try {
              for(int i=0; i<disciplinas.get().length; i++){
                Disciplina disciplina = disciplinas.get()[i];

                String[] disciplinaNome = {Integer.toString(disciplina.getCodigo()), disciplina.getSigla(), disciplina.getNome(), disciplina.getDocente()};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = disciplinaNome;
              }

              contentPane.removeAll();
              contentPane.revalidate();
              contentPane.repaint();

              contentPane.add(imprimirInfo(dados, colunas));
              limparDados();
            } catch (Exception e) {
              System.out.println("Disciplinas não foram encontradas.");
            }

            textInputField0.setText("");
          }
        });
			}
		});

    option9.addActionListener((ActionListener) new ActionListener(){
      Optional<Disciplina> disciplina;
      String input0Content;
      int input1Content;
      int input2Content;
      String input3Content;
      String input4Content;
      String input5Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Antiga Disciplina");
        JLabel textInputLabel2 = new JLabel("Código da Nova Disciplina");
        JLabel textInputLabel3 = new JLabel("Sigla da Disciplina");
        JLabel textInputLabel4 = new JLabel("Nome da Disciplina");
        JLabel textInputLabel5 = new JLabel("Nome do Docente");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JTextField textInputField3 = new JTextField();
        JTextField textInputField4 = new JTextField();
        JTextField textInputField5 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));
        textInputField3.setPreferredSize(new Dimension(200, 24));
        textInputField4.setPreferredSize(new Dimension(200, 24));
        textInputField5.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);
        textInputPanel.add(textInputLabel3);
        textInputPanel.add(textInputField3);
        textInputPanel.add(textInputLabel4);
        textInputPanel.add(textInputField4);
        textInputPanel.add(textInputLabel5);
        textInputPanel.add(textInputField5);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = Integer.parseInt(textInputField2.getText().toString());
            input3Content = textInputField3.getText().toString();
            input4Content = textInputField4.getText().toString();
            input5Content = textInputField5.getText().toString();

            disciplina = main.updateDisciplina(input0Content, input1Content, input2Content, input3Content, input4Content, input5Content);

            try {
              System.out.println(disciplina.get().getCodigo());
            } catch (Exception e) {
              System.out.println("Não foi possível atualizar a disciplina.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
            textInputField3.setText("");
            textInputField4.setText("");
          }
        });
			}
		});

    option10.addActionListener((ActionListener) new ActionListener(){
      Optional<Disciplina> disciplina;
      String input0Content;
      int input1Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            disciplina = main.removeDisciplina(input0Content, input1Content);

            try {
              System.out.println(disciplina.get().getCodigo());
            } catch (Exception e) {
              System.out.println("Não foi possível remover a disciplina.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

    option11.addActionListener((ActionListener) new ActionListener(){
      Optional<Aluno> aluno;
      String input0Content;
      int input1Content;
      int input2Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JLabel textInputLabel2 = new JLabel("Matricula do Aluno");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = Integer.parseInt(textInputField2.getText().toString());

            aluno = main.matricularAlunoDisciplina(input0Content, input1Content, input2Content);

            try {
              System.out.println(aluno.get().getMatricula());
            } catch (Exception e) {
              System.out.println("Não foi possível matricular o aluno na disciplina.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
          }
        });
			}
		});

    option12.addActionListener((ActionListener) new ActionListener(){
      Optional<Aula> aula;
      String input0Content;
      int input1Content;
      String[] input2Content;
      String[] input3Content;
      String[] input4Content;
      Double input5Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JLabel textInputLabel2 = new JLabel("Data da aula (AAAA/MM/DD)");
        JLabel textInputLabel3 = new JLabel("Horário de início da aula (HH:MM)");
        JLabel textInputLabel4 = new JLabel("Horário do fim da aula (HH:MM)");
        JLabel textInputLabel5 = new JLabel("Duração da aula (HH.MM)");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JTextField textInputField3 = new JTextField();
        JTextField textInputField4 = new JTextField();
        JTextField textInputField5 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));
        textInputField3.setPreferredSize(new Dimension(200, 24));
        textInputField4.setPreferredSize(new Dimension(200, 24));
        textInputField5.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);
        textInputPanel.add(textInputLabel3);
        textInputPanel.add(textInputField3);
        textInputPanel.add(textInputLabel4);
        textInputPanel.add(textInputField4);
        textInputPanel.add(textInputLabel5);
        textInputPanel.add(textInputField5);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = (textInputField2.getText().toString()).split("/");
            input3Content = (textInputField3.getText().toString()).split(":");
            input4Content = (textInputField4.getText().toString()).split(":");
            input5Content = Double.parseDouble(textInputField5.getText().toString());

            aula = main.criarAulaDisciplina(input0Content, input1Content, LocalDate.of(Integer.parseInt(input2Content[0]), Integer.parseInt(input2Content[1]), Integer.parseInt(input2Content[2])), LocalTime.of(Integer.parseInt(input3Content[0]), Integer.parseInt(input3Content[1])), LocalTime.of(Integer.parseInt(input4Content[0]), Integer.parseInt(input4Content[1])), input5Content);

            try {
              System.out.println(aula.get().getHorarioInicio());
            } catch (Exception e) {
              System.out.println("Não foi possível criar aula na disciplina.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
            textInputField3.setText("");
            textInputField4.setText("");
            textInputField5.setText("");
          }
        });
			}
		});

    option13.addActionListener((ActionListener) new ActionListener(){
      Optional<Aula[]> aulas;
      String input0Content;
      int input1Content;
      String[] colunas = {"Início", "Fim"};
      Object[][] dados = {};

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            aulas = main.listarAulasDisciplina(input0Content, input1Content);

            try {
              for(int i=0; i<aulas.get().length; i++){
                Aula aula = aulas.get()[i];

                String[] aulaInicioFim = {(aula.getHorarioInicio()).toString(), (aula.getHorarioFim()).toString()};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = aulaInicioFim;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Aulas da disciplina não foram encontradas.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

    option14.addActionListener((ActionListener) new ActionListener(){
      Optional<Aula> aula;
      String input0Content;
      int input1Content;
      String[] input2Content;
      String[] input3Content;
      String[] input4Content;
      Double input5Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JLabel textInputLabel2 = new JLabel("Data da aula");
        JLabel textInputLabel3 = new JLabel("Horário de início da aula");
        JLabel textInputLabel4 = new JLabel("Horário do fim da aula");
        JLabel textInputLabel5 = new JLabel("Nota");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JTextField textInputField3 = new JTextField();
        JTextField textInputField4 = new JTextField();
        JTextField textInputField5 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));
        textInputField3.setPreferredSize(new Dimension(200, 24));
        textInputField4.setPreferredSize(new Dimension(200, 24));
        textInputField5.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);
        textInputPanel.add(textInputLabel3);
        textInputPanel.add(textInputField3);
        textInputPanel.add(textInputLabel4);
        textInputPanel.add(textInputField4);
        textInputPanel.add(textInputLabel5);
        textInputPanel.add(textInputField5);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = (textInputField2.getText().toString()).split("/");
            input3Content = (textInputField3.getText().toString()).split(":");
            input4Content = (textInputField4.getText().toString()).split(":");
            input5Content = Double.parseDouble(textInputField5.getText().toString());

            aula = main.modificarAulaDisciplina(input0Content, input1Content, LocalDate.of(Integer.parseInt(input2Content[0]), Integer.parseInt(input2Content[1]), Integer.parseInt(input2Content[2])), LocalTime.of(Integer.parseInt(input3Content[0]), Integer.parseInt(input3Content[1])), LocalTime.of(Integer.parseInt(input4Content[0]), Integer.parseInt(input4Content[1])), input5Content);

            try {
              System.out.println(aula.get().getHorarioInicio());
            } catch (Exception e) {
              System.out.println("Não foi possível modificar a aula.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
            textInputField3.setText("");
            textInputField4.setText("");
            textInputField5.setText("");
          }
        });
			}
		});

    option15.addActionListener((ActionListener) new ActionListener(){
      Optional<Nota> nota;
      String input0Content;
      int input1Content;
      int input2Content;
      Double input3Content;

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JLabel textInputLabel2 = new JLabel("Matricula do Aluno");
        JLabel textInputLabel3 = new JLabel("Nota (II.DD)");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JTextField textInputField2 = new JTextField();
        JTextField textInputField3 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));
        textInputField2.setPreferredSize(new Dimension(200, 24));
        textInputField3.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);
        textInputPanel.add(textInputLabel2);
        textInputPanel.add(textInputField2);
        textInputPanel.add(textInputLabel3);
        textInputPanel.add(textInputField3);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());
            input2Content = Integer.parseInt(textInputField2.getText().toString());
            input3Content = Double.parseDouble(textInputField3.getText().toString());

            nota = main.criarNotaDisciplina(input0Content, input1Content, input2Content, input3Content);

            try {
              System.out.println(nota.get().getValor());
            } catch (Exception e) {
              System.out.println("Não foi possível criar nota na disciplina.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
            textInputField2.setText("");
            textInputField3.setText("");
          }
        });
			}
		});

    option16.addActionListener((ActionListener) new ActionListener(){
      Optional<Nota[]> notas;
      String[] colunas = {"Nota", "Aluno"};
      Object[][] dados = {};
      String input0Content;
      int input1Content;

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Código da Disciplina");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            notas = main.listarNotasDisciplina(input0Content, input1Content);

            try {
              for(int i=0; i<notas.get().length; i++){
                Nota nota = notas.get()[i];
                
                String[] notaValores = {Double.toString(nota.getValor()), Integer.toString(nota.getAluno().getMatricula())};

                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = notaValores;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Notas não puderam ser encontradas.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

    option17.addActionListener((ActionListener) new ActionListener(){
      Optional<Aula[]> aulas;
      String[] colunas = {"Disciplina", "Inicio", "Fim"};
      Object[][] dados = {};
      String input0Content;
      int input1Content;

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Matricula do Aluno");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            aulas = main.listarAulasAluno(input0Content, input1Content);

            try {
              for(int i=0; i<aulas.get().length; i++){
                Aula aula = aulas.get()[i];
                
                String[] aulaInicioFim = {(aula.getDisciplina().getNome()).toString(), (aula.getHorarioInicio()).toString(), (aula.getHorarioFim()).toString()};
    
                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = aulaInicioFim;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Aulas do aluno não foram encontradas.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

    option18.addActionListener((ActionListener) new ActionListener(){
      Optional<Nota[]> notas;
      String[] colunas = {"Disciplina", "Nota", "Aluno"};
      Object[][] dados = {};
      String input0Content;
      int input1Content;

      public void limparDados(){
        dados = Arrays.copyOf(dados, 0);
      }

			public void actionPerformed(ActionEvent event) {
        contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();

        JPanel textInputPanel = new JPanel();
        JLabel textInputLabel0 = new JLabel("Nome do Curso");
        JLabel textInputLabel1 = new JLabel("Matricula do Aluno");
        JTextField textInputField0 = new JTextField();
        JTextField textInputField1 = new JTextField();
        JButton textInputButton = new JButton("Enviar");

        textInputField0.setPreferredSize(new Dimension(200, 24));
        textInputField1.setPreferredSize(new Dimension(200, 24));

        textInputPanel.add(textInputLabel0);
        textInputPanel.add(textInputField0);
        textInputPanel.add(textInputLabel1);
        textInputPanel.add(textInputField1);

        contentPane.add(textInputPanel);
        contentPane.add(textInputButton);

        textInputPanel.setLayout(new BoxLayout(textInputPanel, BoxLayout.PAGE_AXIS));

        textInputButton.addActionListener((ActionListener) new ActionListener(){
          public void actionPerformed(ActionEvent event){
            input0Content = textInputField0.getText().toString();
            input1Content = Integer.parseInt(textInputField1.getText().toString());

            notas = main.listarNotasAluno(input0Content, input1Content);

            try {
              for(int i=0; i<notas.get().length; i++){
                Nota nota = notas.get()[i];
                
                String[] notaValores = {nota.getDisciplina().getNome(), Double.toString(nota.getValor()), Integer.toString(nota.getAluno().getMatricula())};
    
                dados = Arrays.copyOf(dados, (dados.length)+1);
                dados[(dados.length)-1] = notaValores;

                contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();

                contentPane.add(imprimirInfo(dados, colunas));
                limparDados();
              }
            } catch (Exception e) {
              System.out.println("Notas do aluno não foram encontradas.");
            }

            textInputField0.setText("");
            textInputField1.setText("");
          }
        });
			}
		});

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		setVisible(true);

		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
  }

  public JScrollPane imprimirInfo(Object[][] _dados, String[] _colunas){
    JTable tabela = new JTable(_dados, _colunas);
    JScrollPane barraRolagem = new JScrollPane(tabela);

    return barraRolagem;
  }
}

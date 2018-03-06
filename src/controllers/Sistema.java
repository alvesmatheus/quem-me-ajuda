package controllers;

public class Sistema {
	
	private AlunoController controladorAluno;
	private TutorController controladorTutor;
	private AjudaController controladorAjuda;
		
	public Sistema() {
		this.controladorAluno = new AlunoController();
		this.controladorTutor = new TutorController();
		this.controladorAjuda = new AjudaController();
	}
	
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {
		try {
			this.controladorAluno.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
		}
		
		catch (IllegalArgumentException e1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: " + e1.getMessage());
		}
		
		catch (NullPointerException e2) {
			throw new NullPointerException("Erro no cadastro de aluno: " + e2.getMessage());
		}
	}
	
	public String recuperaAluno(String matricula) {
		try {
			return this.controladorAluno.recuperaAluno(matricula);	
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por aluno: " + e.getMessage());
		}
	}

	public String listarAlunos() {
		return this.controladorAluno.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		try {
			return this.controladorAluno.getInfoAluno(matricula, atributo);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: " + e.getMessage());
		}
	}
	
	private void criarNovoTutor(String matricula) {
		this.controladorAluno.impedirAlunoNaoCadastrado(matricula, "Tutor nao encontrado");
		
		this.controladorTutor.criarNovoTutor(this.controladorAluno.getInfoAluno(matricula, "Matricula"), 
											 this.controladorAluno.getInfoAluno(matricula, "Nome"),
											 this.controladorAluno.getInfoAluno(matricula, "Curso"),
											 this.controladorAluno.getInfoAluno(matricula, "Telefone"),
											 this.controladorAluno.getInfoAluno(matricula, "Email"));
	}
	
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		try {
			this.criarNovoTutor(matricula);
			this.controladorTutor.tornarTutor(matricula, disciplina, proficiencia);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na definicao de papel: " + e.getMessage());
		}
		
		
	}
	
	public String recuperaTutor(String matricula) {
		try {
			return this.controladorTutor.recuperaTutor(matricula);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro na busca por tutor: " + e.getMessage());
		}
	}
	
	public String listarTutores() {
		return this.controladorTutor.listarTutores();
	}
	
	public void cadastrarHorario(String email, String hora, String dia) {
		try {
			this.controladorTutor.cadastrarHorario(email, hora, dia);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastrar horario: " + e.getMessage());
		}
	}
	
	public void cadastrarLocalDeAtendimento(String email, String local) {
		try {
			this.controladorTutor.cadastrarLocalDeAtendimento(email, local);
		}
		
		catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: " + e.getMessage());
		}
	}
	
	public boolean consultaHorario(String email, String hora, String dia) {
		return this.controladorTutor.consultaHorario(email, hora, dia);
	}
	
	public boolean consultaLocal(String email, String local) {
		return this.controladorTutor.consultaLocal(email, local);
	}
	
	
	
	
	private String selecionarTutor(String disciplina) {
		return this.controladorTutor.selecionarTutor(disciplina);
	}
	
	public int pedirAjudaOnline (String matriculaAluno, String disciplina) {
		String matriculaTutor = this.selecionarTutor(disciplina);
		
		return this.controladorAjuda.pedirAjudaOnline(matriculaAluno, disciplina, matriculaTutor);
	}
	
	private String selecionarTutor(String disciplina, String horario, String dia, String localInteresse) {
		return this.controladorTutor.selecionarTutor(disciplina, horario, dia, localInteresse);
	}
	
	public int pedirAjudaPresencial (String matriculaAluno, String disciplina, String horario, String dia, String localInteresse) {
		String matriculaTutor = this.selecionarTutor(disciplina, horario, dia, localInteresse); 
		
		return this.controladorAjuda.pedirAjudaPresencial(matriculaAluno, disciplina, horario, dia,
			   localInteresse, matriculaTutor);
	}
	
	public String pegarTutor(int idAjuda) {
		return this.controladorAjuda.pegarTutor(idAjuda);
	}
	
	public String getInfo(int idAjuda, String atributo) {
		return this.controladorAjuda.getInfoAjuda(idAjuda, atributo);
	}
	
	public String pegarNivel(String matriculaTutor) {
		return this.controladorTutor.pegarNivel(matriculaTutor);
	}

	public void doar(String matriculaTutor, int totalCentavos) {
		this.controladorTutor.doar(matriculaTutor, totalCentavos);
	}

	public int getTotalDinheiroTutor(String emailTutor) {
		return this.controladorTutor.getTotalDinheiro(emailTutor);
	}

}

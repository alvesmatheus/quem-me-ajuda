package models;

public class Aluno {
	
	private String matricula;
	private String nome;
	private String codigoCurso;
	private String telefone;
	private String email;
	private double nota;
	
	public Aluno(String nome, String matricula, String codigoCurso, String email) {
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.telefone = "";
		this.email = email;
		this.nota = 5.0;
	}

	public Aluno(String nome, String matricula, String codigoCurso, String email, String telefone) {
		this(nome, matricula, codigoCurso, email);
		this.telefone = telefone;
	}
	
	public String getMatricula() {
		return this.matricula;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String getCodigoCurso() {
		return this.codigoCurso;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public String getEmail() {
		return this.email;
	}

	@Override
	public String toString() {
		String toString = "";
		toString += this.getMatricula() + " - " + this.getNome() + " - " + this.getCodigoCurso();
					
		if(this.getTelefone().trim().equals(""))
			toString += this.getTelefone();
		
		return toString + this.getEmail();
	}	

}
package model;

public class Fiador {
	
	
	private int id_fiador;
	private String cpf_fiador ;
	private String nome;
	private String telefone ;
	private String email;
	private String profissao ;
	private String complemento;
	private int id_cep;
	
	
	public int getId_cep() {
		return id_cep;
	}
	public void setId_cep(int id_cep) {
		this.id_cep = id_cep;
	}
	public int getId_fiador() {
		return id_fiador;
	}
	public void setId_fiador(int id_fiador) {
		this.id_fiador = id_fiador;
	}
	public String getCpf_fiador() {
		return cpf_fiador;
	}
	public void setCpf_fiador(String cpf_fiador) {
		this.cpf_fiador = cpf_fiador;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public Fiador(int id_fiador, String cpf_fiador, String nome,
			String telefone, String email, String profissao, String complemento) {
		super();
		this.id_fiador = id_fiador;
		this.cpf_fiador = cpf_fiador;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.profissao = profissao;
		this.complemento = complemento;
	}
	public Fiador(String cpf_fiador, String nome, String telefone,
			String email, String profissao, String complemento) {
		super();
		this.cpf_fiador = cpf_fiador;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.profissao = profissao;
		this.complemento = complemento;
	}
	
	
	
	public Fiador() {
		super();
	}

	//Construtor do Fiador com a id_cep
	
	public Fiador(int id_fiador, String cpf_fiador, String nome,
			String telefone, String email, String profissao,
			String complemento, int id_cep) {
		super();
		this.id_fiador = id_fiador;
		this.cpf_fiador = cpf_fiador;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.profissao = profissao;
		this.complemento = complemento;
		this.id_cep = id_cep;
	}
	@Override
	public String toString() {
		final String ENTER = "\n";
		
		return "CPF - " + cpf_fiador + ENTER
				+ "Nome - " + nome + ENTER + "Telefone - " + telefone + ENTER +
				"E-mail - " + email + ENTER + "Profissao - " + profissao + ENTER ; 
		
	}
	
	
}// fim da classe

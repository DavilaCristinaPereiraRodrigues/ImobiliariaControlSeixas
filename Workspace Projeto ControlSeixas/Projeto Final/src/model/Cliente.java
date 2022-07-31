package model;

public class Cliente {

	private int id_cliente;
	private String cpf_cliente;
	private String nome;
	private String telefone;
	private String email;
	private String estado_civil;
	private String tipo; //comprador ou locador
	private String complemento;
	private int id_cep;
	
	
	
	
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getCpf_cliente() {
		return cpf_cliente;
	}
	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
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
	public String getEstado_civil() {
		return estado_civil;
	}
	public void setEstado_civil(String estado_civil) {
		this.estado_civil = estado_civil;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	public int getId_cep() {
		return id_cep;
	}
	public void setId_cep(int id_cep) {
		this.id_cep = id_cep;
	}
	
	
	public Cliente(int id_cliente, String cpf_cliente, String nome,
			String telefone, String email, String estado_civil, String tipo,
			String complemento) {
		super();
		this.id_cliente = id_cliente;
		this.cpf_cliente = cpf_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.tipo = tipo;
		this.complemento = complemento;
	}
	public Cliente() {
		super();
	}
	public Cliente(String cpf_cliente, String nome, String telefone,
			String email, String estado_civil, String tipo, String complemento) {
		super();
		this.cpf_cliente = cpf_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.tipo = tipo;
		this.complemento = complemento;
	}
	
	
	//construtor com id_cep, para a busca do campo cpf da tela Cliente
	public Cliente(int id_cliente, String cpf_cliente, String nome,
			String telefone, String email, String estado_civil, String tipo,
			String complemento, int id_cep) {
		super();
		this.id_cliente = id_cliente;
		this.cpf_cliente = cpf_cliente;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.tipo = tipo;
		this.complemento = complemento;
		this.id_cep = id_cep;
	}
	
	@Override
	public String toString() {
		final String ENTER = "\n";

		
		return "CPF - " + cpf_cliente +  ENTER 
				+ "Nome - " + nome + ENTER
				+ "Telefone - " + telefone + ENTER
				+ "E-mail - " + email +  ENTER + 
				"Estado Civil - " + estado_civil
				+ ENTER + "Tipo - " + tipo  ;
	}

	
}// fim da classe

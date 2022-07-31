package model;

public class Proprietario {

	private int id_prop;
	private String cpf_prop;
	private String nome;
	private String telefone;
	private String email;
	private String estado_civil;
	private String profissao;
	private String complemento;
	private int id_cep;
	
	public int getId_cep() {
		return id_cep;
	}
	public void setId_cep(int id_cep) {
		this.id_cep = id_cep;
	}
	public int getId_prop() {
		return id_prop;
	}
	public void setId_prop(int id_prop) {
		this.id_prop = id_prop;
	}
	public String getCpf_prop() {
		return cpf_prop;
	}
	public void setCpf_prop(String cpf_prop) {
		this.cpf_prop = cpf_prop;
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
	
	@Override
	public String toString() {
		final String ENTER = "\n";
		
		return "CPF - " + cpf_prop +  ENTER 
				+ "Nome - " + nome +  ENTER 
				+"Telefone - " + telefone +   ENTER + "E-mail -  "
				+ email +  ENTER  + "Estado Civil - " + estado_civil
				+  ENTER + "Profissao - " + profissao ;
	}
	public Proprietario(int id_prop, String cpf_prop, String nome,
			String telefone, String email, String estado_civil,
			String profissao, String complemento) {
		super();
		this.id_prop = id_prop;
		this.cpf_prop = cpf_prop;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.profissao = profissao;
		this.complemento = complemento;
	}
	public Proprietario() {
		super();
	}
	public Proprietario(String cpf_prop, String nome, String telefone,
			String email, String estado_civil, String profissao,
			String complemento) {
		super();
		this.cpf_prop = cpf_prop;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.profissao = profissao;
		this.complemento = complemento;
		
		}
	
	//construtor com cep
	public Proprietario(int id_prop, String cpf_prop, String nome,
			String telefone, String email, String estado_civil,
			String profissao, String complemento, int id_cep) {
		super();
		this.id_prop = id_prop;
		this.cpf_prop = cpf_prop;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.estado_civil = estado_civil;
		this.profissao = profissao;
		this.complemento = complemento;
		this.id_cep = id_cep;
	}
	
	
	
}
	
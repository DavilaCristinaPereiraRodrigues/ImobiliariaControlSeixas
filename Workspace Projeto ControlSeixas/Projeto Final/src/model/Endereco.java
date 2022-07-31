package model;

public class Endereco {
	
	private int id;
	private String cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String estado;
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", logradouro="
				+ logradouro + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Endereco() {
		super();
	}
	public Endereco(int id, String cep, String logradouro, String bairro,
			String cidade, String estado) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	public Endereco(String cep, String logradouro, String bairro,
			String cidade, String estado) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	
}// fim da classe

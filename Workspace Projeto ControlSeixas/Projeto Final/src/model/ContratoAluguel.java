package model;

public class ContratoAluguel {

	private int id_contAluguel; //chave primária
	private int num_contAluguel; //chave alternativa
	private String dt_aquisicao;
	private String dt_vencimento;
	private String dt_pag;
	private double valor;
	private double comissao_cor;
	private int fk_cliente; //cliente
	private int fk_imovel; //imovel
	private int fk_corretor; //corretor
	private int fk_prop; //prop
	
	
	
	public ContratoAluguel(int id_contAluguel, int num_contAluguel,
			String dt_aquisicao, String dt_vencimento, String dt_pag,
			double valor, double comissao_cor, int fk_cliente, int fk_imovel,
			int fk_corretor, int fk_prop) {
		super();
		this.id_contAluguel = id_contAluguel;
		this.num_contAluguel = num_contAluguel;
		this.dt_aquisicao = dt_aquisicao;
		this.dt_vencimento = dt_vencimento;
		this.dt_pag = dt_pag;
		this.valor = valor;
		this.comissao_cor = comissao_cor;
		this.fk_cliente = fk_cliente;
		this.fk_imovel = fk_imovel;
		this.fk_corretor = fk_corretor;
		this.fk_prop = fk_prop;
	}
	public int getFk_cliente() {
		return fk_cliente;
	}
	public void setFk_cliente(int fk_cliente) {
		this.fk_cliente = fk_cliente;
	}
	public int getFk_imovel() {
		return fk_imovel;
	}
	public void setFk_imovel(int fk_imovel) {
		this.fk_imovel = fk_imovel;
	}
	public int getFk_corretor() {
		return fk_corretor;
	}
	public void setFk_corretor(int fk_corretor) {
		this.fk_corretor = fk_corretor;
	}
	public int getFk_prop() {
		return fk_prop;
	}
	public void setFk_prop(int fk_prop) {
		this.fk_prop = fk_prop;
	}
	public int getId_contAluguel() {
		return id_contAluguel;
	}
	public void setId_contAluguel(int id_contAluguel) {
		this.id_contAluguel = id_contAluguel;
	}
	public int getNum_contAluguel() {
		return num_contAluguel;
	}
	public void setNum_contAluguel(int num_contAluguel) {
		this.num_contAluguel = num_contAluguel;
	}
	public String getDt_aquisicao() {
		return dt_aquisicao;
	}
	public void setDt_aquisicao(String dt_aquisicao) {
		this.dt_aquisicao = dt_aquisicao;
	}
	public String getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(String dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public String getDt_pag() {
		return dt_pag;
	}
	public void setDt_pag(String dt_pag) {
		this.dt_pag = dt_pag;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public double getComissao_cor() {
		return comissao_cor;
	}
	public void setComissao_cor(double comissao_cor) {
		this.comissao_cor = comissao_cor;
	}
	public ContratoAluguel(int id_contAluguel, int num_contAluguel,
			String dt_aquisicao, String dt_vencimento, String dt_pag,
			double valor, double comissao_cor) {
		super();
		this.id_contAluguel = id_contAluguel;
		this.num_contAluguel = num_contAluguel;
		this.dt_aquisicao = dt_aquisicao;
		this.dt_vencimento = dt_vencimento;
		this.dt_pag = dt_pag;
		this.valor = valor;
		this.comissao_cor = comissao_cor;
	}
	public ContratoAluguel(int num_contAluguel, String dt_aquisicao,
			String dt_vencimento, String dt_pag, double valor,
			double comissao_cor) {
		super();
		this.num_contAluguel = num_contAluguel;
		this.dt_aquisicao = dt_aquisicao;
		this.dt_vencimento = dt_vencimento;
		this.dt_pag = dt_pag;
		this.valor = valor;
		this.comissao_cor = comissao_cor;
	}
	public ContratoAluguel() {
		super();
	}
	@Override
	public String toString() {
		return "ContratoAluguel [id_contAluguel=" + id_contAluguel
				+ ", num_contAluguel=" + num_contAluguel + ", dt_aquisicao="
				+ dt_aquisicao + ", dt_vencimento=" + dt_vencimento
				+ ", dt_pag=" + dt_pag + ", valor=" + valor + ", comissao_cor="
				+ comissao_cor + "]";
	}
	
}//fim da classe
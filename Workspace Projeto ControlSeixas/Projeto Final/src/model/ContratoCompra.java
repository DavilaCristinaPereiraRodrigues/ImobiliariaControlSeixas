package model;

public class ContratoCompra {
	private int id_contCompra;
	private int num_contCompra; //chave alternativa
	private String dt_aquisicao;
	private double valor;
	private String tp_pag;
	private int n_parcela;
	private double comissao_cor;
	private int fk_prop; //cliente
	
	private int fk_cliente; //cliente
	private int fk_imovel; //imovel
	private int fk_fiador; //fiador
	private int fk_corretor; //fiador
	
	public int getId_contCompra() {
		return id_contCompra;
	}
	public int getFk_prop() {
		return fk_prop;
	}
	public void setFk_prop(int fk_prop) {
		this.fk_prop = fk_prop;
	}
	public void setId_contCompra(int id_contCompra) {
		this.id_contCompra = id_contCompra;
	}
	public int getNum_contCompra() {
		return num_contCompra;
	}
	public void setNum_contCompra(int num_contCompra) {
		this.num_contCompra = num_contCompra;
	}
	public String getDt_aquisicao() {
		return dt_aquisicao;
	}
	public void setDt_aquisicao(String dt_aquisicao) {
		this.dt_aquisicao = dt_aquisicao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTp_pag() {
		return tp_pag;
	}
	public void setTp_pag(String tp_pag) {
		this.tp_pag = tp_pag;
	}
	public int getN_parcela() {
		return n_parcela;
	}
	public void setN_parcela(int n_parcela) {
		this.n_parcela = n_parcela;
	}
	public double getComissao_cor() {
		return comissao_cor;
	}
	public void setComissao_cor(double comissao_cor) {
		this.comissao_cor = comissao_cor;
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
	public int getFk_fiador() {
		return fk_fiador;
	}
	public void setFk_fiador(int fk_fiador) {
		this.fk_fiador = fk_fiador;
	}
	public int getFk_corretor() {
		return fk_corretor;
	}
	public void setFk_corretor(int fk_corretor) {
		this.fk_corretor = fk_corretor;
	}
	public ContratoCompra() {
		super();
	}
	
	
	public ContratoCompra(int num_contCompra, String dt_aquisicao,
			double valor, String tp_pag, int n_parcela, double comissao_cor) {
		super();
		this.num_contCompra = num_contCompra;
		this.dt_aquisicao = dt_aquisicao;
		this.valor = valor;
		this.tp_pag = tp_pag;
		this.n_parcela = n_parcela;
		this.comissao_cor = comissao_cor;
	}
	public ContratoCompra(int num_contCompra, String dt_aquisicao,
			double valor, String tp_pag, int n_parcela, double comissao_cor,
			int fk_cliente, int fk_imovel, int fk_fiador, int fk_corretor) {
		super();
		this.num_contCompra = num_contCompra;
		this.dt_aquisicao = dt_aquisicao;
		this.valor = valor;
		this.tp_pag = tp_pag;
		this.n_parcela = n_parcela;
		this.comissao_cor = comissao_cor;
		this.fk_cliente = fk_cliente;
		this.fk_imovel = fk_imovel;
		this.fk_fiador = fk_fiador;
		this.fk_corretor = fk_corretor;
	}
	public ContratoCompra(int id_contCompra, int num_contCompra,
			String dt_aquisicao, double valor, String tp_pag, int n_parcela,
			double comissao_cor, int fk_prop, int fk_cliente, int fk_imovel,
			int fk_fiador, int fk_corretor) {
		super();
		this.id_contCompra = id_contCompra;
		this.num_contCompra = num_contCompra;
		this.dt_aquisicao = dt_aquisicao;
		this.valor = valor;
		this.tp_pag = tp_pag;
		this.n_parcela = n_parcela;
		this.comissao_cor = comissao_cor;
		this.fk_prop = fk_prop;
		this.fk_cliente = fk_cliente;
		this.fk_imovel = fk_imovel;
		this.fk_fiador = fk_fiador;
		this.fk_corretor = fk_corretor;
	}
	public ContratoCompra(int id_contCompra, int num_contCompra,
			String dt_aquisicao, double valor, String tp_pag, int n_parcela,
			double comissao_cor, int fk_cliente, int fk_imovel, int fk_fiador,
			int fk_corretor) {
		super();
		this.id_contCompra = id_contCompra;
		this.num_contCompra = num_contCompra;
		this.dt_aquisicao = dt_aquisicao;
		this.valor = valor;
		this.tp_pag = tp_pag;
		this.n_parcela = n_parcela;
		this.comissao_cor = comissao_cor;
		this.fk_cliente = fk_cliente;
		this.fk_imovel = fk_imovel;
		this.fk_fiador = fk_fiador;
		this.fk_corretor = fk_corretor;
	}
	public ContratoCompra(int id_contCompra, int num_contCompra,
			String dt_aquisicao, double valor, String tp_pag, int n_parcela,
			double comissao_cor) {
		super();
		this.id_contCompra = id_contCompra;
		this.num_contCompra = num_contCompra;
		this.dt_aquisicao = dt_aquisicao;
		this.valor = valor;
		this.tp_pag = tp_pag;
		this.n_parcela = n_parcela;
		this.comissao_cor = comissao_cor;
	}

	
	
}
	
package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.ContratoCompra;
import model.ContratoCompra;
import util.Conexao;
import util.Configurador;

public class ContratoCompraDAO {
	Configurador config = new Configurador();
	String url;
	String driver;
	String login;
	String senha;

	public ContratoCompraDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}// fim do public ContratoCompraDAO

	// M�todo incluirCompra()
	public static ContratoCompra incluirCompra(int num_contCompra,
			String dt_aquisicao, double valor, String tp_pag, int n_parcela,
			double comissao_cor, String cpf_cliente, int codigo,
			String cpf_corretor, String cpf_fiador, String cpf_prop) {

		ContratoCompra contCompra = null;
		ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();

		try {

			String sql = "insert into contrato_compra(id_contcompra, num_contcompra, dt_aquisicao,"
					+ " valor, tp_pag, n_parcela, comissao_cor, "
					+ "fk_cliente, fk_imovel, fk_corretor, fk_fiador, fk_prop) values "
					+ " (null, ? ,? ,? ,? ,? ,? ,(select id_cliente from cliente where cpf_cliente = ? ) ,"
					+ "(select id_imovel from imovel where codigo = ? ) ,"
					+ " (select id_corretor from corretor where cpf_corretor = ? ),"
					+ " (select id_fiador from fiador where cpf_fiador = ? ),"
					+ "(select id_prop from proprietario where cpf_prop = ? )) ";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(contCompraDAO.url,
					contCompraDAO.driver, contCompraDAO.login,
					contCompraDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, num_contCompra);
			comando.setString(2, dt_aquisicao);
			comando.setDouble(3, valor);
			comando.setString(4, tp_pag);
			comando.setInt(5, n_parcela);
			comando.setDouble(6, comissao_cor);
			comando.setString(7, cpf_cliente);// Cliente
			comando.setInt(8, codigo);// IMOVEL
			comando.setString(9, cpf_corretor);// Corretor
			comando.setString(10, cpf_fiador);// Fiador
			comando.setString(11, cpf_prop);// Propriet�rio

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		contCompra = new ContratoCompra(num_contCompra, dt_aquisicao, valor,
				tp_pag, n_parcela, comissao_cor);

		return contCompra;

	}// fim do incluirCompra()

	// BUSCAR CONTRATO DE COMPRA NA TELA DE PESQUISAR
	public static ContratoCompra consultarCompra(int nome_cliente) {

		ContratoCompra contCompra = null;
		ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();

		try {
			// Cria��o do select

			// Verificar se entra a op��o OR
			String sql = "select cliente.nome, contrato_compra.id_contCompra,"
					+ "imovel.id_imovel from cliente,contrato_compra,"
					+ "imovel where (contrato_compra.fk_cliente = cliente.id_cliente) "
					+ "and (contrato_compra.fk_imovel = imovel.id_imovel);";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(contCompraDAO.url,
					contCompraDAO.driver, contCompraDAO.login,
					contCompraDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			// comando.setString(1, login);
			// comando.setString(2, senha);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				contCompra = new ContratoCompra(rs.getInt("id_contCompra"),
						rs.getString("dt_aquisicao"), rs.getDouble("valor"),
						rs.getString("tp_pag"), rs.getInt("n_parcela"),
						rs.getDouble("comissao_cor"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return contCompra;

	}// fim do consultarCompra */

	public static ContratoCompra excluirCompra(int num_contCompra) {

		ContratoCompra contCompra = null;
		ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();

		try {
			
			String sql = "insert into morto_contratocompra (select id_contcompra, num_contcompra, dt_aquisicao,"
					+ "	valor, tp_pag, n_parcela, comissao_cor,  fk_cliente, fk_imovel, fk_corretor, fk_fiador,"
					+ " fk_prop from contrato_compra where num_contCompra =  ? )";
			
			// Cria��o do delete
			String sql1 = "delete from contrato_compra where num_contCompra = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(contCompraDAO.url,
					contCompraDAO.driver, contCompraDAO.login,
					contCompraDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();
			Connection con1 = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			PreparedStatement comando1 = con1.prepareStatement(sql1);
			
			comando.setInt(1, num_contCompra);
			comando1.setInt(1, num_contCompra);
			
			// Comando executado
			comando.executeUpdate();
			comando1.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return contCompra;
	}// fim do excluirCompra();

	public static ContratoCompra alterarCompra(int num_contCompra, String dt_aquisicao, double valor, String tp_pag, int n_parcela,
			double comissao_cor, String cpf_cliente, int codigo,
			String cpf_corretor, String cpf_fiador, String cpf_prop  ) {
		// aqui coloquei p/ alterar pelo id pois � tinha oltra indentifica��o
		// �nica

		ContratoCompra contCompra = null;
		ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();

		try {
			// Cria��o do update
			String sql = "update contrato_compra set num_contCompra = ? , dt_aquisicao = ?, valor = ?,  "
					+ "tp_pag = ?,  n_parcela = ?, comissao_cor = ? ,"
					+ "fk_cliente = (select id_cliente from cliente where cpf_cliente = ? ), "
					+ "fk_imovel = (select id_imovel from imovel where codigo = ? ), "
					+ "fk_corretor = (select id_corretor from corretor where cpf_corretor = ? ), "
					+ "fk_fiador = (select id_fiador from fiador where cpf_fiador = ? ), "
					+ "fk_prop = (select id_prop from proprietario where cpf_prop = ? ) "
					+ "where num_contCompra = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(contCompraDAO.url,
					contCompraDAO.driver, contCompraDAO.login,
					contCompraDAO.senha);
			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1, num_contCompra);
			comando.setString(2, dt_aquisicao);
			comando.setDouble(3, valor);
			comando.setString(4, tp_pag);
			comando.setInt(5, n_parcela);
			comando.setDouble(6, comissao_cor);
			comando.setString(7, cpf_cliente);
			comando.setInt(8, codigo); //Im�vel
			comando.setString(9, cpf_corretor);
			comando.setString(10, cpf_fiador);
			comando.setString(11, cpf_prop);
			comando.setInt(12, num_contCompra);
		

			// Comando executado

			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return contCompra;
	}// fim do alterarCompra();
	
	
	public static ContratoCompra buscarContratoCompra(int num_contCompra) {

		ContratoCompra contCompra = null;
		ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
		
		try {
			// Cria��o do select

			// PESQUISAR PELO ID E DT_AVALIACAO

			String sql = "select * from contrato_compra where num_contCompra = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(contCompraDAO.url,
					contCompraDAO.driver, contCompraDAO.login,
					contCompraDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, num_contCompra);

			ResultSet rs = comando.executeQuery();

		

			if(rs.next()) {
				contCompra = new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
						.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
						("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
						rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return contCompra;
	}// fim do buscarContrato
	
	
	//Buscar contrato Cliente
	
	
		public static ContratoCompra buscarContratoCli(int fk_cliente) {

			ContratoCompra contCompra = null;
			 ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
			try {
				// Cria��o do select

				// PESQUISAR PELO ID E DT_AVALIACAO

				String sql = "select * from contrato_compra where fk_cliente = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(contCompraDAO.url,contCompraDAO.driver,
						contCompraDAO.login,contCompraDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_cliente);

				ResultSet rs = comando.executeQuery();

			

				if(rs.next()) {
					new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
							.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
							("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
							rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return contCompra;
		}
		
		
		public static ContratoCompra buscarContratoImovel(int fk_imovel) {

			ContratoCompra contCompra = null;
			 ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
			try {
				// Cria��o do select

				// PESQUISAR PELO ID E DT_AVALIACAO

				String sql = "select * from contrato_compra where fk_imovel = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(contCompraDAO.url,contCompraDAO.driver,
						contCompraDAO.login,contCompraDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_imovel);

				ResultSet rs = comando.executeQuery();

			

				if(rs.next()) {
					new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
							.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
							("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
							rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return contCompra;
		}
		
		public static ContratoCompra buscarContratoCorretor(int fk_corretor) {

			ContratoCompra contCompra = null;
			 ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
			try {
				// Cria��o do select

				// PESQUISAR PELO ID E DT_AVALIACAO

				String sql = "select * from contrato_compra where fk_corretor = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(contCompraDAO.url,contCompraDAO.driver,
						contCompraDAO.login,contCompraDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_corretor);

				ResultSet rs = comando.executeQuery();

			

				if(rs.next()) {
					new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
							.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
							("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
							rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return contCompra;
		}
		
		public static ContratoCompra buscarContratoAluProp(int fk_prop) {

			ContratoCompra contCompra = null;
			 ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
			try {
				// Cria��o do select

				// PESQUISAR PELO ID E DT_AVALIACAO

				String sql = "select * from contrato_compra where fk_prop = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(contCompraDAO.url,contCompraDAO.driver,
						contCompraDAO.login,contCompraDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_prop);

				ResultSet rs = comando.executeQuery();

			

				if(rs.next()) {
					new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
							.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
							("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
							rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return contCompra;
		}
		

		public static ContratoCompra buscarContratoFiador(int fk_fiador) {

			ContratoCompra contCompra = null;
			 ContratoCompraDAO contCompraDAO = new ContratoCompraDAO();
			try {
				// Cria��o do select

				// PESQUISAR PELO ID E DT_AVALIACAO

				String sql = "select * from contrato_compra where fk_fiador = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(contCompraDAO.url,contCompraDAO.driver,
						contCompraDAO.login,contCompraDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_fiador);

				ResultSet rs = comando.executeQuery();

			

				if(rs.next()) {
					new ContratoCompra(rs.getInt("id_contCompra"), rs.getInt("num_contCompra"),rs
							.getString("dt_aquisicao") , rs.getDouble("valor"), rs.getString
							("tp_pag"), rs.getInt("n_parcela"), rs.getDouble("comissao_cor"), rs.getInt("fk_cliente"), rs.getInt("fk_imovel"), rs.getInt("fk_corretor"),
							rs.getInt("fk_fiador"), rs.getInt("fk_prop"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			return contCompra;
		}
		
	
}
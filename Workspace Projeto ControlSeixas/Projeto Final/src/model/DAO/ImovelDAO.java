package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import model.Imovel;
import model.Proprietario;
import util.Conexao;
import util.Configurador;

public class ImovelDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public ImovelDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}// fim do public ImovelDAO

	/*
	 * Na tela com as perguntas para o usu�rio (Pesquisar Im�veis) � preciso
	 * validar os campos preenchidos e os campos vazios. Os preenchidos devem
	 * ficar com os valores que receberam do usu�rio. Os vazios devem receber *
	 * para que aqui na consulta ao banco d� certo.
	 */

	public static Imovel incluirImovel(int codigo, String tp_negocio, String tp_pos,
			String tp_status, String tp_est, String tp_pag, double valor,
			String referencias, String descricao, String area_total,
			String area_cons, String area_util, String qtd_comodos,
			String qtd_quartos, String vaga_garagem, String dt_avaliacao,
			String complemento, String cep, String cpf_prop) {

		// id = endereco
		// id_prop = proprietario

		Imovel imovel = null;
		ImovelDAO imoDAO = new ImovelDAO();

		try {
			
		
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date data = new java.sql.Date(df.parse(dt_avaliacao).getTime()); 

			
			
			// Cria��o do insert  
			String sql = "insert into imovel(id_imovel, codigo, tp_negocio, tp_pos, tp_status, tp_est, "
					+ "tp_pag, valor, referencias, descricao, area_total, "
					+ "area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem,"
					+ "dt_avaliacao, complemento, fk_id, fk_prop )values"
					+ "(null, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, (select id from base_cep where cep = ? ) ,"
					+ " (select id_prop from proprietario where cpf_prop = ?)) ";
				//1� select -> endere�o
				//2� select -> propriet�rio
			
			
			// Obter a conex�o com o BD
			Conexao conex = new Conexao(imoDAO.url, imoDAO.driver,
					imoDAO.login, imoDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			
			comando.setInt(1, codigo);
			comando.setString(2, tp_negocio);
			comando.setString(3, tp_pos);
			comando.setString(4, tp_status);
			comando.setString(5, tp_est);
			comando.setString(6, tp_pag);
			comando.setDouble(7, valor);
			comando.setString(8, referencias);
			comando.setString(9, descricao);
			comando.setString(10, area_total);
			comando.setString(11, area_cons);
			comando.setString(12, area_util);
			comando.setString(13, qtd_comodos);
			comando.setString(14, qtd_quartos);
			comando.setString(15, vaga_garagem);
			//comando.setString(16, dt_avaliacao);
			//comando.setDate(16, dt);
			comando.setDate(16, data);
			comando.setString(17, complemento);
			comando.setString(18, cep);
			comando.setString(19, cpf_prop); // Propriet�rio
			
			
			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		imovel = new Imovel(codigo, tp_negocio, tp_pos, tp_status, tp_est, tp_pag,
				valor, referencias, descricao, area_total, area_cons,
				area_util, qtd_comodos, qtd_quartos, vaga_garagem,
				dt_avaliacao, complemento);

		return imovel;

	}// fim do incluirImovel
	
	
	
	
	
	
	

	// M�todo excluirImovel()
	public static Imovel excluirImovel(int codigo) { // excluir pelo c�digo
		Imovel imovel = null;
		ImovelDAO imovelDAO = new ImovelDAO();

		try {
			
			String sql = "insert into morto_imovel (select id_imovel, codigo, tp_negocio, tp_pos, tp_status, tp_est,"
					+ "tp_pag, valor, referencias, descricao, area_total, "
					+ "area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem,"
					+ "dt_avaliacao, complemento, fk_id, fk_prop from imovel where codigo = ?)";
			
					
			// Cria��o do delete
			String sql1 = "delete from imovel where codigo = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			
			Connection con = conex.obterConexao();
			Connection con1 = conex.obterConexao();
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			PreparedStatement comando1 = con1.prepareStatement(sql1);
			
			comando.setInt(1, codigo);
			comando1.setInt(1, codigo);
			
			// Comando executado
			comando.executeUpdate();
			comando1.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return imovel;
	}// fim do excluiImovel();

	public static Imovel alterarImovel(int codigo, String tp_negocio, String tp_pos,
			String tp_status, String tp_est, String tp_pag, double valor,
			String referencias, String descricao, String area_total,
			String area_cons, String area_util, String qtd_comodos,
			String qtd_quartos, String vaga_garagem, String dt_avaliacao,
			String complemento, String cep, String cpf_prop) { 
		// aqui coloquei p/ alterar
	// pelo id pois � tinha
	// outra indentifica��o
			// �nica

		Imovel imovel = null;
		ImovelDAO imovelDAO = new ImovelDAO();

		try {
			// Cria��o do update
			String sql = "update imovel set codigo = ?, tp_negocio = ?,  tp_pos = ? ,  tp_status = ?, "
					+ "tp_est = ?, tp_pag = ?,  valor = ?,"
					+ "  referencias = ?,  descricao = ?, area_total = ?,  area_cons = ?,  area_util = ?, "
					+ "qtd_comodos = ?, qtd_quartos = ?, vaga_garagem = ?,  dt_avaliacao = ? , complemento = ? , fk_prop = "
					+ " (select id_prop from proprietario where cpf_prop = ? ) , fk_id ="
					+ " (select id from base_cep where cep= ? ) where codigo = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);
			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			
			comando.setInt(1, codigo);
			comando.setString(2, tp_negocio);
			comando.setString(3, tp_pos);
			comando.setString(4, tp_status);
			comando.setString(5, tp_est);
			comando.setString(6, tp_pag);
			comando.setDouble(7, valor);
			comando.setString(8, referencias);
			comando.setString(9, descricao);
			comando.setString(10, area_total);
			comando.setString(11, area_cons);
			comando.setString(12, area_util);
			comando.setString(13, qtd_comodos);
			comando.setString(14, qtd_quartos);
			comando.setString(15, vaga_garagem);
			comando.setString(16, dt_avaliacao);
			comando.setString(17, complemento);
			comando.setString(18, cpf_prop);
			comando.setString(19, cep);
			comando.setInt(20, codigo);
			
			// Comando executado

			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return imovel;

	}// fim do alteraimovel();

	// select para buscar na tela de Pesquisar sempre um Im�vel

	public static List<Imovel> buscarImovel(int codigo) {

		List<Imovel> imovel = null;

		ImovelDAO imovelDAO = new ImovelDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO ID E DT_AVALIACAO

			String sql = "select * from imovel where codigo = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, codigo);

			ResultSet rs = comando.executeQuery();

			imovel = new ArrayList<Imovel>();

			while (rs.next()) {
				imovel.add(new Imovel(rs.getInt("id_imovel"), rs.getInt("codigo"), rs
						.getString("tp_negocio"), rs.getString("tp_pos"), rs
						.getString("tp_status"), rs.getString("tp_est"), rs
						.getString("tp_pag"), rs.getDouble("valor"), rs
						.getString("referencias"), rs.getString("descricao"),
						rs.getString("area_total"), rs.getString("area_cons"),
						rs.getString("area_util"), rs.getString("qtd_comodos"), rs
								.getString("qtd_quartos"), rs
								.getString("vaga_garagem"), rs
								.getString("dt_avaliacao"), rs
								.getString("complemento")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return imovel;
	}// fim do buscarimovel

	//SEM ARRAYLIST para colocarmos para pesquisar o c�digo
	public static Imovel buscarImovelCodigo(int codigo) {

		Imovel imovel = null;
		

		ImovelDAO imovelDAO = new ImovelDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO ID E DT_AVALIACAO

			String sql = "select * from imovel where codigo = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, codigo);

			ResultSet rs = comando.executeQuery();

		

			if(rs.next()) {
				imovel = new Imovel(rs.getInt("id_imovel"), rs.getInt("codigo"), rs
						.getString("tp_negocio"), rs.getString("tp_pos"), rs
						.getString("tp_status"), rs.getString("tp_est"), rs
						.getString("tp_pag"), rs.getDouble("valor"), rs
						.getString("referencias"), rs.getString("descricao"),
						rs.getString("area_total"), rs.getString("area_cons"),
						rs.getString("area_util"), rs.getString("qtd_comodos"), rs
								.getString("qtd_quartos"), rs
								.getString("vaga_garagem"), rs
								.getString("dt_avaliacao"), rs
								.getString("complemento"), rs.getInt("fk_id"), rs.getInt("fk_prop"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

		return imovel;
	}// fim do buscarimovel
	
	public static Imovel buscarImovelProp(int fk_prop) {

		Imovel imovel = null;

		ImovelDAO imovelDAO = new ImovelDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO NOME e seu Id

			String sql = "select * from imovel where fk_prop = ?";

			// Obter a conex�o com o BD
		
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk_prop);

			ResultSet rs = comando.executeQuery();

			if(rs.next()) {
				imovel = new Imovel(rs.getInt("id_imovel"), rs.getInt("codigo"), rs
						.getString("tp_negocio"), rs.getString("tp_pos"), rs
						.getString("tp_status"), rs.getString("tp_est"), rs
						.getString("tp_pag"), rs.getDouble("valor"), rs
						.getString("referencias"), rs.getString("descricao"),
						rs.getString("area_total"), rs.getString("area_cons"),
						rs.getString("area_util"), rs.getString("qtd_comodos"), rs
								.getString("qtd_quartos"), rs
								.getString("vaga_garagem"), rs
								.getString("dt_avaliacao"), rs
								.getString("complemento"), rs.getInt("fk_id"), rs.getInt("fk_prop"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	return imovel;
	} // fim do buscarImovel

	//Tela para pesquisar o impovel
	public static List<Imovel> PesquisarImovel(double valorMin, double valorMax, String bairro, String cidade, String tp_status) {

		List<Imovel> imovel = new LinkedList<Imovel>();
		ImovelDAO imovelDAO = new ImovelDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO NOME e seu Id

			String sql = "select * from imovel, base_cep where imovel.fk_id = base_cep.id and base_cep.bairro = ? and base_cep.cidade = ? and imovel.tp_status = ? and imovel.valor between ? and ?";

			// Obter a conex�o com o BD
		
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, bairro);
			comando.setString(2, cidade);	
			comando.setString(3, tp_status);
			comando.setDouble(4, valorMin);
			comando.setDouble(5, valorMax);

		

			ResultSet rs = comando.executeQuery();
			
			imovel = new ArrayList<Imovel>();
			
			while(rs.next()) {
				imovel.add ( new Imovel( rs.getInt("id_imovel"), rs.getInt("codigo"), rs
						.getString("tp_negocio"), rs.getString("tp_pos"), rs
						.getString("tp_status"), rs.getString("tp_est"), rs
						.getString("tp_pag"), rs.getDouble("valor"), rs
						.getString("referencias"), rs.getString("descricao"),
						rs.getString("area_total"), rs.getString("area_cons"),
						rs.getString("area_util"), rs.getString("qtd_comodos"), rs
								.getString("qtd_quartos"), rs
								.getString("vaga_garagem"), rs
								.getString("dt_avaliacao"), rs
								.getString("complemento"), rs.getInt("fk_id"), rs.getInt("fk_prop")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	return imovel;
	} // fim do PesquisarImovel
	
	
	public static Imovel buscarImovelFk(int fk_imovel) {

		Imovel imovel = null;

		ImovelDAO imovelDAO = new ImovelDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO NOME e seu Id

			String sql = "select * from imovel where id_imovel = ?";

			// Obter a conex�o com o BD
		
			Conexao conex = new Conexao(imovelDAO.url, imovelDAO.driver,
					imovelDAO.login, imovelDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk_imovel);

			ResultSet rs = comando.executeQuery();

			if(rs.next()) {
				imovel = new Imovel(rs.getInt("id_imovel"), rs.getInt("codigo"), rs
						.getString("tp_negocio"), rs.getString("tp_pos"), rs
						.getString("tp_status"), rs.getString("tp_est"), rs
						.getString("tp_pag"), rs.getDouble("valor"), rs
						.getString("referencias"), rs.getString("descricao"),
						rs.getString("area_total"), rs.getString("area_cons"),
						rs.getString("area_util"), rs.getString("qtd_comodos"), rs
								.getString("qtd_quartos"), rs
								.getString("vaga_garagem"), rs
								.getString("dt_avaliacao"), rs
								.getString("complemento"), rs.getInt("fk_id"), rs.getInt("fk_prop"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	return imovel;
	} // fim do buscarImovelfK
	
	
}// fim da classe
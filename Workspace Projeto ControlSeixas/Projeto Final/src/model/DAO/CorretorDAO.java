package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Corretor;
import util.Conexao;
import util.Configurador;

public class CorretorDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public CorretorDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}// fim do public clienteDAO

	public static Corretor incluirCorretor(String creci, String cpf_corretor,
			String nome, String telefone, String email, String login,
			String senha, String tp_cor, String complemento, String cep) {

		Corretor corretor = null;
		CorretorDAO corDAO = new CorretorDAO();

		try {
			// Cria��o do insert
			String sql = "insert into corretor(id_corretor, creci,"
					+ " cpf_corretor, nome, telefone, email, login, senha, "
					+ "tp_cor, complemento, fk_id )values"
					+ "(null, ?, ?, ?, ?, ?, ?, ?, ?, ? , (select id from base_cep where cep = ?))";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(corDAO.url, corDAO.driver,
					corDAO.login, corDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, creci);
			comando.setString(2, cpf_corretor);
			comando.setString(3, nome);
			comando.setString(4, telefone);
			comando.setString(5, email);
			comando.setString(6, login);
			comando.setString(7, senha);
			comando.setString(8, tp_cor);
			comando.setString(9, complemento);
			comando.setString(10, cep);

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		corretor = new Corretor(creci, cpf_corretor, nome, telefone, email,
				login, senha, tp_cor, complemento);

		return corretor;
	}// fim do incluirCorretor()

	public static Corretor excluirCorretor(String cpf_corretor) {
		Corretor corretor = null;
		CorretorDAO corDAO = new CorretorDAO();

		try {
			// Cria��o do delete

			String sql = "insert into morto_corretor (select id_corretor, creci,"
					+ " cpf_corretor, nome, telefone, email, login, senha, "
					+ "tp_cor, complemento, fk_id from corretor where cpf_corretor = ?) ";

			String sql1 = "delete from corretor where cpf_corretor = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(corDAO.url, corDAO.driver,
					corDAO.login, corDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado

			PreparedStatement comando = con.prepareStatement(sql);
			PreparedStatement comando1 = con.prepareStatement(sql1);

			comando.setString(1, cpf_corretor);
			comando1.setString(1, cpf_corretor);

			// Comando executado
			comando.executeUpdate();
			comando1.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return corretor;
	}// fim do excluirCorretor();

	public static Corretor alterarCorretor(String creci, String cpf_corretor,
			String nome, String telefone, String email, String login,
			String senha, String tp_cor, String complemento, String cep) { // n�o
																		// coloquei
																		// p/
																		// alterar
																		// o id
																		// pois
																		// ser�
																		// auto_increment

		Corretor corretor = null;
		CorretorDAO corDAO = new CorretorDAO();

		try {
			// Cria��o do update
			String sql = "update corretor set creci = ?, cpf_corretor = ?, nome = ?, telefone = ?,"
					+ "email = ? , login = ?,senha = ?, tp_cor = ? , complemento = ? , fk_id = "
					+ "(select id from base_cep where cep = ?) where cpf_corretor = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(corDAO.url, corDAO.driver,
					corDAO.login, corDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, creci);
			comando.setString(2, cpf_corretor);
			comando.setString(3, nome);
			comando.setString(4, telefone);
			comando.setString(5, email);
			comando.setString(6, login);
			comando.setString(7, senha);
			comando.setString(8, tp_cor);
			comando.setString(9, complemento);
			comando.setString(10, cep);
			comando.setString(11, cpf_corretor);

			// Comando executado

			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return corretor;
	}// fim do alterarCorretor();

	// buscar o corretor
	public static List<Corretor> buscarCorretor(String nome, String cpf_corretor) {

		List<Corretor> corretor = null;

		CorretorDAO corretorDAO = new CorretorDAO();

		try {
			// Cria��o do select

			// PESQUISAR PELO NOME E CPF_CORRETOR e creci

			String sql = "select * from corretor where (nome = ? or cpf_corretor = ?) ";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(corretorDAO.url, corretorDAO.driver,
					corretorDAO.login, corretorDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, nome);
			comando.setString(2, cpf_corretor);

			ResultSet rs = comando.executeQuery();

			corretor = new ArrayList<Corretor>();

			while (rs.next()) {
				corretor.add(new Corretor(rs.getInt("id_corretor"), rs
						.getString("creci"), rs.getString("cpf_corretor"), rs
						.getString("nome"), rs.getString("telefone"), rs
						.getString("email"), rs.getString("login"), rs
						.getString("senha"), rs.getString("tp_cor"), rs
						.getString("complemento")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return corretor;
	}// fim do buscarCorretor

	// Buscar por login e senha

	public static Corretor buscarPorLoginSenha(String login, String senha) {
	Corretor corretor = null;

	CorretorDAO corretorDAO = new CorretorDAO();
	try {
		// Cria��o do select
		String sql = "select * from corretor where login = ? and senha = ?";
	
		// Obter a conex�o com o BD
		Conexao conex = new Conexao(corretorDAO.url, corretorDAO.driver,
				corretorDAO.login, corretorDAO.senha);

		// Abrir a conexao
		Connection con = conex.obterConexao();

		// Preparar o comando para ser executado
		PreparedStatement comando = con.prepareStatement(sql);

		comando.setString(1, login);
		comando.setString(2, senha);
	
		ResultSet rs = comando.executeQuery();

		if (rs.next()) {
			corretor = new Corretor (rs.getInt("id_corretor"),rs.getString("creci"), rs.getString("cpf_corretor"), rs.getString("nome"),
					rs.getString("telefone"), rs.getString("email")
					, rs.getString("login"), rs.getString("senha"), rs.getString("tp_cor"), rs.getString("complemento"));
		}

		rs.close();
		comando.close();
		con.close();

	} catch (Exception e) {
		System.out.println(e.getMessage());
	}

	return corretor;
}

	
	// buscar o corretor somente pelo cpf
		public static Corretor buscarCorretorCpf(String cpf_corretor) {

			Corretor corretor = null;

			CorretorDAO corretorDAO = new CorretorDAO();

			try {
				// Cria��o do select

				// PESQUISAR PELO NOME E CPF_CORRETOR e creci

				String sql = "select * from corretor where cpf_corretor = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(corretorDAO.url, corretorDAO.driver,
						corretorDAO.login, corretorDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setString(1, cpf_corretor);

				ResultSet rs = comando.executeQuery();

			

			if (rs.next()) {
					corretor = new Corretor(rs.getInt("id_corretor"), rs
							.getString("creci"), rs.getString("cpf_corretor"), rs
							.getString("nome"), rs.getString("telefone"), rs
							.getString("email"), rs.getString("login"), rs
							.getString("senha"), rs.getString("tp_cor"), rs
							.getString("complemento"), rs.getInt("fk_id"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return corretor;
		}// fim do buscarCorretor
		
		
		//Buscando pela FK
		
		
		public static Corretor buscarCorretorFk(int fk_corretor) {

			Corretor corretormd = null;

			CorretorDAO corretorDAO = new CorretorDAO();

			try {
				// Cria��o do select

				// PESQUISAR PELO NOME E CPF_CORRETOR e creci

				String sql = "select * from corretor where id_corretor = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(corretorDAO.url, corretorDAO.driver,
						corretorDAO.login, corretorDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_corretor);

				ResultSet rs = comando.executeQuery();

			

			if (rs.next()) {
					corretormd = new Corretor(rs.getInt("id_corretor"),rs.getString("creci"), rs.getString("cpf_corretor"), rs.getString("nome"),
							rs.getString("telefone"), rs.getString("email")
							, rs.getString("login"), rs.getString("senha"), rs.getString("tp_cor"), rs.getString("complemento"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return corretormd;
		}// fim do buscarCorretor
		
		
		public static Corretor buscarCorretorFkCompra(int fk_corretor) {

			Corretor corretormd = null;

			CorretorDAO corretorDAO = new CorretorDAO();

			try {
				// Cria��o do select

				// PESQUISAR PELO NOME E CPF_CORRETOR e creci

				String sql = "select * from corretor where id_corretor = ?";

				// Obter a conex�o com o BD
				Conexao conex = new Conexao(corretorDAO.url, corretorDAO.driver,
						corretorDAO.login, corretorDAO.senha);

				// Abrir a conexao
				Connection con = conex.obterConexao();

				// Preparar o comando para ser executado
				PreparedStatement comando = con.prepareStatement(sql);

				comando.setInt(1, fk_corretor);

				ResultSet rs = comando.executeQuery();

			

			if (rs.next()) {
					corretormd = new Corretor(rs.getInt("id_corretor"),rs.getString("creci"), rs.getString("cpf_corretor"), rs.getString("nome"),
							rs.getString("telefone"), rs.getString("email")
							, rs.getString("login"), rs.getString("senha"), rs.getString("tp_cor"), rs.getString("complemento"));
				}

				rs.close();
				comando.close();
				con.close();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			return corretormd;
		}// fim do buscarCorretor
		
}// fim da classe

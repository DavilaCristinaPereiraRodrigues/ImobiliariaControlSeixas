package model.DAO;

import java.util.LinkedList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Cliente;
import util.Conexao;
import util.Configurador;

import java.util.ArrayList;

public class ClienteDAO {
	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public ClienteDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}// fim do public clienteDAO

	// Primeiro vem os atributos do Cliente para podermos inclu�-lo

	public static Cliente incluirCliente(String cpf_cliente, String nome,
			String telefone, String email, String estado_civil, String tipo,
			String complemento, String cep) { // n�o coloquei p/ inserir o id
												// pois ser� auto_increment,
		// id � do endere�o

		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();

		try {
			// Cria��o do insert
			String sql = "insert into cliente(id_cliente , cpf_cliente, nome, telefone, email, estado_civil, tipo, complemento, fk_id)values"
					+ "(null, ?, ?, ?, ?, ?, ? ,?, (select id from base_cep where cep = ? ))";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf_cliente);
			comando.setString(2, nome);
			comando.setString(3, telefone);
			comando.setString(4, email);
			comando.setString(5, estado_civil);
			comando.setString(6, tipo);
			comando.setString(7, complemento);
			comando.setString(8, cep);// endereco

			// Comando executado
			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		cliente = new Cliente(cpf_cliente, nome, telefone, email, estado_civil,
				tipo, complemento);

		return cliente;

	}// fim do incluirCliente

	public static List<Cliente> buscarCliente(String nome, String cpf_cliente) {

		List<Cliente> cliente = new LinkedList<Cliente>();

		ClienteDAO cliDAO = new ClienteDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO NOME E CPF
			// Se a pesquisa for pelo nome do cliente ser� algo assim: select *
			// from cliente where nome = ?
			String sql = "select * from cliente where (nome = ? or cpf_cliente = ?)";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, nome);
			comando.setString(2, cpf_cliente);

			ResultSet rs = comando.executeQuery();

			cliente = new ArrayList<Cliente>();

			while (rs.next()) {
				cliente.add(new Cliente(rs.getInt("id_cliente"), rs
						.getString("cpf_cliente"), rs.getString("nome"), rs
						.getString("telefone"),rs.getString("email"), rs.getString("estado_civil"),
						rs.getString("tipo"), rs
								.getString("complemento")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}// fim do buscar cliente

	public static Cliente excluirCliente(String cpf_cliente) { // excluir pelo
																// cpf
		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();

		try {
			// Cria��o do delete
			String sql = "insert into morto_cliente (select id_cliente , cpf_cliente, nome, telefone, email, estado_civil, tipo, complemento, fk_id "
					+ "from cliente where cpf_cliente = ? )";
							
			String sql1 = "delete from cliente where cpf_cliente = ?";
			
			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();
			Connection con1 = conex.obterConexao();
			
			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);
			PreparedStatement comando1 = con1.prepareStatement(sql1);
			
			comando.setString(1, cpf_cliente);
			comando1.setString(1, cpf_cliente);
			
			// Comando executado
			comando.executeUpdate();
			comando1.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}// fim do excluirCliente();

	public static Cliente alterarCliente(String cpf_cliente, String nome,
			String telefone, String email, String estado_civil, String tipo,
			String complemento, String cep) { // n�o coloquei p/ alterar o id
												// pois ser� auto_increment
		// id refere-se ao endere�o

		Cliente cliente = null;
		ClienteDAO cliDAO = new ClienteDAO();

		try {
			// Cria��o do update
			String sql = "update cliente set cpf_cliente = ? , nome = ? , telefone = ?, email = ?, estado_civil = ? ,tipo = ? "
					+ ", complemento = ? ,  fk_id = (select id from base_cep where cep = ?) where cpf_cliente = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf_cliente);
			comando.setString(2, nome);
			comando.setString(3, telefone);
			comando.setString(4, email);
			comando.setString(5, estado_civil);
			comando.setString(6, tipo);
			comando.setString(7, complemento);
			comando.setString(8, cep);
			comando.setString(9, cpf_cliente);
			// Comando executado

			comando.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}// fim do alterarCliente();
	
	public static Cliente buscarClienteCpf(String cpf_cliente) {

		Cliente cliente  = null;

		ClienteDAO cliDAO = new ClienteDAO();
		try {
			
			String sql = "select * from cliente where  cpf_cliente = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cpf_cliente);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs
						.getString("cpf_cliente"), rs.getString("nome"), rs
						.getString("telefone"),rs.getString("email"), rs.getString("estado_civil"),
						rs.getString("tipo"), rs
								.getString("complemento"), rs.getInt("fk_id"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}// fim do buscar cliente
	
		//Buscando pela fk quando eu for pesquisar os contratos
	
	public static Cliente buscarClienteFk(int fk_cliente) {

		Cliente cliente  = null;

		ClienteDAO cliDAO = new ClienteDAO();
		try {
			
			String sql = "select * from cliente where id_cliente = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(cliDAO.url, cliDAO.driver,
					cliDAO.login, cliDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, fk_cliente);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				cliente = new Cliente(rs.getInt("id_cliente"), rs
						.getString("cpf_cliente"), rs.getString("nome"), rs
						.getString("telefone"),rs.getString("email"), rs.getString("estado_civil"),
						rs.getString("tipo"), rs
								.getString("complemento"), rs.getInt("fk_id"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}// fim do buscar cliente
	
	}// fim da classe

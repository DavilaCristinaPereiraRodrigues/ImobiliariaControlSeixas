package model.DAO;

import model.Endereco;
import model.Imovel;
import util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.Configurador;

public class EnderecoDAO {

	Configurador config = new Configurador();

	String url;
	String driver;
	String login;
	String senha;

	public EnderecoDAO() {

		url = config.getUrl();
		driver = config.getDriver();
		login = config.getLogin();
		senha = config.getSenha();

	}// fim do public endere�o

	public static Endereco buscarEndereco(String cep) {

		Endereco endereco = null;

		EnderecoDAO endDAO = new EnderecoDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO ID E DT_AVALIACAO

			String sql = "select cep, logradouro, bairro, cidade , estado from base_cep where cep = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(endDAO.url, endDAO.driver,
					endDAO.login, endDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setString(1, cep);

			ResultSet rs = comando.executeQuery();

				if (rs.next()) {
		       endereco =  new Endereco(rs.getString("cep"), rs
						.getString("logradouro"), rs.getString("bairro"), rs
						.getString("cidade"), rs.getString("estado"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return endereco;
	}// fim do buscarEndereco
	
	
	public static Endereco buscarEndereco(int idCep) {

		Endereco endereco = null;

		EnderecoDAO endDAO = new EnderecoDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO ID E DT_AVALIACAO

			String sql = "select cep, logradouro, bairro, cidade , estado from base_cep where id = ?";

			// Obter a conex�o com o BD
			Conexao conex = new Conexao(endDAO.url, endDAO.driver,
					endDAO.login, endDAO.senha);

			// Abrir a conexao
			Connection con = conex.obterConexao();

			// Preparar o comando para ser executado
			PreparedStatement comando = con.prepareStatement(sql);

			comando.setInt(1, idCep);

			ResultSet rs = comando.executeQuery();

				if (rs.next()) {
		       endereco =  new Endereco(rs.getString("cep"), rs
						.getString("logradouro"), rs.getString("bairro"), rs
						.getString("cidade"), rs.getString("estado"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return endereco;
	}// fim do buscarEndereco pela id
	
	
	
	public static List<Endereco> PesquisarEndereco(double valorMin, double valorMax, String bairro, String cidade, String tp_status) {

		List<Endereco> endereco = new LinkedList<Endereco>();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		try {
			// Cria��o do select

			// PESQUISAR PELO NOME e seu Id

			String sql = "select * from imovel, base_cep where imovel.fk_id = base_cep.id and base_cep.bairro = ? and base_cep.cidade = ? and imovel.tp_status = ? and imovel.valor between ? and ?";

			// Obter a conex�o com o BD
		
			Conexao conex = new Conexao(enderecoDAO.url, enderecoDAO.driver,
					enderecoDAO.login, enderecoDAO.senha);

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
			
			endereco = new ArrayList<Endereco>();
			
			while(rs.next()) {
				endereco.add ( new Endereco( rs.getString("cep"), rs
						.getString("logradouro"), rs.getString("bairro"), rs
						.getString("cidade"), rs.getString("estado")));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	return endereco;
	} // fim do PesquisarImovel
	
}// fim da classe

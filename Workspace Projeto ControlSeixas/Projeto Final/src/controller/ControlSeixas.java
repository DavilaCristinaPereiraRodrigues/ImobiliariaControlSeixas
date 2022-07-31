package controller;

import java.util.List;

import model.Cliente;
import model.ContratoAluguel;
import model.ContratoCompra;
import model.Corretor;
import model.Endereco;
import model.Fiador;
import model.Imovel;
import model.Proprietario;
import model.DAO.ClienteDAO;
import model.DAO.ContratoAluguelDAO;
import model.DAO.ContratoCompraDAO;
import model.DAO.CorretorDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FiadorDAO;
import model.DAO.ImovelDAO;
import model.DAO.ProprietarioDAO;
import util.Teclado;
import view.PesquisarCliente;

public class ControlSeixas {

	// Vari�veis globais
	Fiador fiador;
	Cliente cliente;
	Imovel imovel;
	Proprietario proprietario;
	Corretor corretor;
	ContratoAluguel contAluguel;
	ContratoCompra contratoCompra;
	Endereco endereco;

	boolean logado = false; // indica se o usu�rio est� logado.

	private static final int EFETUARLOGIN = 1;

	private static final int INCLUIRFIADOR = 2;

	private static final int EXCLUIRFIADOR = 3;

	private static final int BUSCARCORRETOR = 4;

	private static final int INCLUIRCLIENTE = 5;

	private static final int ALTERARCLIENTE = 6;

	private static final int BUSCARCLIENTE = 7;

	private static final int ALTERARFIADOR = 8;

	private static final int EXCLUIRCLIENTE = 9;

	private static final int INCLUIRIMOVEL = 10;

	private static final int EXCLUIRIMOVEL = 11;

	private static final int ALTERARIMOVEL = 12;

	private static final int INCLUIRPROP = 13;

	private static final int EXCLUIRPROP = 14;

	private static final int ALTERARPROP = 15;

	private static final int INCLUIRCONTCOMPRA = 16;

	private static final int EXCLUIRCONTCOMPRA = 17;

	private static final int ALTERARCONTCOMPRA = 18;

	private static final int INCLUIRCONTALU = 19;

	private static final int EXCLUIRCONTALU = 20;

	private static final int ALTERARCONTALU = 21;

	private static final int BUSCARPROP = 22;

	private static final int BUSCARIMOVEL = 23;

	private static final int INCLUIRCORRETOR = 24;

	private static final int ALTERARCORRETOR = 25;

	private static final int BUSCARALUGUEL = 26;

	private static final int BUSCARCOMPRA = 27;

	private static final int SAIR = 28;

	public static void main(String[] args) {

		ControlSeixas cs = new ControlSeixas(); // Criando o objeto desta classe, info
		int opcao = SAIR;

		do { // in�cio de um la�o, do...while

			System.out.println("======================================");
			System.out.println("|        Escolha uma op��o           |");
			System.out.println("======================================");
			System.out.println("| 1 - EFETUAR LOGIN                  |");
			System.out.println("| 2 - INCLUIR  FIADOR                |");
			System.out.println("| 3 - EXCLUIR  FIADOR                |");
			System.out.println("| 4 - BUSCAR  CORRETOR               |");
			System.out.println("| 5-  INCLUIR CLIENTE                | ");
			System.out.println("| 6-  ALTERAR CLIENTE                |");
			System.out.println("| 7-  BUSCAR  CLIENTE                |");
			System.out.println("| 8-  ALTERAR FIADOR                 |");
			System.out.println("| 9-  EXCLUIR CLIENTE                |");
			System.out.println("| 10- INCLUIR IMOVEL                 |");
			System.out.println("| 11- EXCLUIR IMOVEL                 |");
			System.out.println("| 12- ALTERAR IMOVEL                 |");
			System.out.println("| 13- INCLUIR PROPRIETARIO           |");
			System.out.println("| 14- EXCLUIR PROPPROPRIETARIO       |");
			System.out.println("| 15- ALTERAR PROPRIETARIO           |");
			System.out.println("| 16- INCLUIR CONTRATO DE COMPRA     |");
			System.out.println("| 17- EXCLUIR CONTRATO DE COMPRA     |");
			System.out.println("| 18- ALTERAR CONTRATO DE COMPRA     |");
			System.out.println("| 19- INCLUIR CONTRATO DE ALUGUEL    |");
			System.out.println("| 20- EXCLUIR CONTRATO DE ALUGUEL    |");
			System.out.println("| 21- ALTERAR CONTRATO DE ALUGUEL    |");
			System.out.println("| 22- BUSCAR PROPPROPRIETARIO        |");
			System.out.println("| 23- BUSCAR IMOVEL                  |");
			System.out.println("| 24- INCLUIR CORRETOR               |");
			System.out.println("| 25- ALTERAR CORRETOR               |");
			System.out.println("| 26- SAIR                           |");
			System.out.println("======================================");

			opcao = Teclado.lerInt("Digite sua op��o: ");

			switch (opcao) {

			case EFETUARLOGIN:// chamando o m�todo efetuarLogin
				cs.efetuarLogin();
				break;

			case INCLUIRFIADOR:// chamando o m�todo incluirFiador
				cs.incluirFiador();
				break;

			case EXCLUIRFIADOR:
				cs.excluirFiador();
				break;
/*
			case BUSCARCORRETOR:
				cs.buscarCorretor();
				break;
*/
			case INCLUIRCLIENTE:
				cs.incluirCliente();
				break;

			case ALTERARCLIENTE:
				cs.alterarCliente();
				break;

			case ALTERARFIADOR:
				cs.alterarFiador();
				break;

			case EXCLUIRCLIENTE:
				cs.excluirCliente();
				break;

			case INCLUIRIMOVEL:
				cs.incluirImovel();
				break;

			case EXCLUIRIMOVEL:
				cs.excluirImovel();
				break;

			case ALTERARIMOVEL:
				cs.alterarImovel();
				break;

			case INCLUIRPROP:
				cs.incluirProprietario();
				break;

			case EXCLUIRPROP:
				cs.excluirProprietario();
				break;

			case ALTERARPROP:
				cs.alterarProprietario();
				break;

			case INCLUIRCONTCOMPRA:
				cs.incluirCompra();
				break;

			case EXCLUIRCONTCOMPRA:
				cs.excluirCompra();
				break;

			case ALTERARCONTCOMPRA:
				cs.alterarCompra();
				break;

			case INCLUIRCONTALU:
				cs.incluirAluguel();
				break;

			case EXCLUIRCONTALU:
				cs.excluirAluguel();
				break;

			case ALTERARCONTALU:
				cs.alterarAluguel();
				break;

			
			case BUSCARPROP:
				cs.buscarProp();
				break;

			case INCLUIRCORRETOR:
				cs.incluirCorretor();
				break;

			case ALTERARCORRETOR:
				cs.alterarCorretor();
				break;

			case SAIR:
				System.out.println("Sa�da do Sistema.");
				break;

			default:
				System.out.println("Op��o inv�lida!");

			}// fim do switch

			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != SAIR);

	}// fim do m�todo main

	// EfetuarLogin
	public void efetuarLogin() {

		String login, senha;
		login = Teclado.lerTexto("Digite o login:");
		senha = Teclado.lerTexto("Digite a senha:");

		corretor = CorretorDAO.buscarPorLoginSenha(login, senha);

		if (corretor != null) {
			logado = corretor.validarLogin(login, senha);
		} else {
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usu�rio ou senha inv�lido.");

			}// fim do else interno

		}// fim do else externo

	}

	public void incluirFiador() {

		System.out.println("Cadastro de Fiador");

		// id_fiador = Teclado.lerInt("c�digo" ); //coloquei e n�o perguntei
		// ao usu�rio
		String cpf_fiador = Teclado.lerTexto("cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("Email: ");
		String profissao = Teclado.lerTexto("Profissao");
		String complemento = Teclado.lerTexto("Complemento");

		System.out.println("\n");
		System.out.println(" Cadastro de Endere�o\n");

		// O id � auto_increment perguntar como � perguntar para o usu�rio
		// int id_endereco = Teclado.lerInt("Id endere�o");

		// S� perguntei o cep pois ir� perguntar o Cep e virar o logradouro,
		// bairro, cidade e bairro
		String cep = Teclado.lerTexto("CEP:");

		// Joga as informa��es primeiro no Endere�o
		// ArrayList da Pesquisa

		// Plural, singular, plural, singular
		endereco = EnderecoDAO.buscarEndereco(cep);

		fiador = FiadorDAO.incluirFiador(cpf_fiador, nome, telefone, email,
				profissao, complemento, cep);

		System.out.println(fiador); // amostra o objeto cadastrado
		System.out.println(endereco);

		System.out.println("===============================================");
		System.out.println("|        Fiador cadastrado com sucesso       |");
		System.out.println("===============================================");

	}// fim do incluirFiador();

	public void excluirFiador() {

		System.out.println("==================");
		System.out.println("|   Excluir Fiador |");
		System.out.println("===================");

		String cpf_fiador = Teclado
				.lerTexto("Digite o cpf do Fiador a ser excluido: ");

		FiadorDAO.excluirFiador(cpf_fiador);

		System.out.println("=========================================");
		System.out.println("|     Fiador exclu�do com Sucesso    |");
		System.out.println("=========================================");

	}// fim do excluirFiador()

	public void alterarFiador() {
		System.out.println("=====================");
		System.out.println("   Alterar Fiador    ");
		System.out.println("======================");

		String cpf_fiador = Teclado.lerTexto("CPF do fiador antigo");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("Email: ");
		String profissao = Teclado.lerTexto("Profissao");
		String complemento = Teclado.lerTexto("Complemento");

		System.out.println("Endereco \n");

		// O id � auto_increment perguntar como � perguntar para o usu�rio
		String cep = Teclado.lerTexto("CEP:");

		// Plural, singular, plural, singular
		Endereco enderecos = EnderecoDAO.buscarEndereco(cep);

		// Joga as informa��es primeiro no Endere�o depois alterado
		enderecos = EnderecoDAO.buscarEndereco(cep);

		// Joga as informa��es depois no fiador alterado
		fiador = FiadorDAO.alterarFiador(cpf_fiador, nome, telefone, email,
				profissao, complemento, cep);

		System.out.println(fiador); // amostra o objeto cadastrado

		System.out.println("Fiador alterado com sucesso");

	}// fim do alterarFiador

	public void buscarAluguel() {
		System.out.println("Buscar Aluguel");

		int num_contAluguel = Teclado.lerInt("N�mero do Contrato ");

		contAluguel = ContratoAluguelDAO.buscarContratoAlu(num_contAluguel);

		String dt_aquisicao = contAluguel.getDt_aquisicao();

		String dt_vencimento = contAluguel.getDt_vencimento();

		String dt_pag = contAluguel.getDt_pag();

		double valor = contAluguel.getValor();

		double comissao_cor = contAluguel.getComissao_cor();

		int fk_cliente = contAluguel.getFk_cliente();

		int fk_imovel = contAluguel.getFk_imovel();

		int fk_corretor = contAluguel.getFk_corretor();

		int fk_prop = contAluguel.getFk_prop();

		//Cliente
		contAluguel = ContratoAluguelDAO.buscarContratoCli(fk_cliente);
		
		cliente = ClienteDAO.buscarClienteFk(fk_cliente);
		
		
		String cpf_cliente = cliente.getCpf_cliente();
		String nome_cliente = cliente.getNome();
		


	//Imovel
		
		int codigo = imovel.getCodigo();
		
		contAluguel = ContratoAluguelDAO.buscarContratoImovel(fk_imovel);
		
		imovel = ImovelDAO.buscarImovelFk(fk_imovel);
		
		
		
		//Propriet�rio
		String cpf_prop = proprietario.getCpf_prop();
		String nome_prop = proprietario.getNome();
		
		contAluguel = ContratoAluguelDAO.buscarContratoAluProp(fk_prop);

		proprietario = ProprietarioDAO.buscarProprietariofkProp(fk_prop);

		
		//corretor

		String cpf_corretor = corretor.getCpf_corretor();
		String nome_corretor = corretor.getNome();
		
		

		contAluguel = ContratoAluguelDAO.buscarContratoCorretor(fk_corretor);
		
		corretor = CorretorDAO.buscarCorretorFk(fk_corretor);
		
		
		

	}

	public void incluirCliente() {

		System.out.println("=======================");
		System.out.println("|    Incluir Cliente  |");
		System.out.println("========================");
		// int id_fiador = Teclado.lerInt("c�digo" ); //coloquei e n�o perguntei
		// ao usu�rio
		String cpf_cliente = Teclado.lerTexto("cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("Email: ");
		String estado_civil = Teclado.lerTexto("Estado civil");
		String tipo = Teclado.lerTexto("Tipo (0 ou 1)");
		String complemento = Teclado.lerTexto("Complemento");

		System.out.println("\n");
		System.out.println("Endere�o\n");

		String cep = Teclado.lerTexto("CEP:");

		// Joga as informa��es primeiro no Endere�o

		endereco = EnderecoDAO.buscarEndereco(cep);
		String logradouro = endereco.getLogradouro();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade();
		String estado = endereco.getEstado();

		// Puxando as informa��es para o Banco de Dados

		cliente = ClienteDAO.incluirCliente(cpf_cliente, nome, telefone, email,
				estado_civil, tipo, complemento, cep);

		System.out.println(endereco);
		System.out.println(cliente); // Amostra o objeto cadastrado

		System.out.println("===============================================");
		System.out.println("|        Cliente cadastrado com sucesso       |");
		System.out.println("===============================================");

	}// fim do incluirCliente();

	public void alterarCliente() {
		System.out.println("======================");
		System.out.println("   Alterar Cliente    ");
		System.out.println("======================");

		String cpf_cliente = Teclado
				.lerTexto("Digite o cpf do Cliente a ser alterado: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("Email: ");
		String estado_civil = Teclado.lerTexto("Estado civil");
		String tipo = Teclado.lerTexto("Tipo (0 ou 1)");
		String complemento = Teclado.lerTexto("Complemento");

		System.out.println("Endere�o");

		String cep = Teclado.lerTexto("CEP:");
		// Plural, singular, plural, singular

		// Joga as informa��es primeiro no Endere�o
		endereco = EnderecoDAO.buscarEndereco(cep);

		// Joga as informa��es depois no Cliente
		cliente = ClienteDAO.alterarCliente(cpf_cliente, nome, telefone, email,
				estado_civil, tipo, complemento, cep);

		System.out.println(cliente); // Amostra o objeto alterado

		System.out.println("=====================================");
		System.out.println("   Cliente atualizado com Sucesso   ");
		System.out.println("=====================================");

	}

	public void excluirCliente() {

		System.out.println("|   Excluir Cliente |");

		String cpf_cliente = Teclado
				.lerTexto("Digite o cpf do Cliente a ser excluido: ");

		ClienteDAO.excluirCliente(cpf_cliente);

		System.out.println("=========================");
		System.out.println("| Cliente exclu�do com Sucesso|");
		System.out.println("==========================");

	}// fim do excluirCliente()

	// Primeiro tem que vir o cadastro do Propriet�rio e ap�s do im�vel
	public void incluirImovel() {
		System.out.println("====================");
		System.out.println("|    Incluir Im�vel |");
		System.out.println("====================\n");

		int codigo = Teclado.lerInt("C�digo do Im�vel: "); // N�O � A ID
		String tp_negocio = Teclado
				.lerTexto("Neg�cio (0 - loca��o, 1 - venda)");
		String tp_pos = Teclado
				.lerTexto("Posi��o: (0 -  frentes , 1 - fundos)");
		String tp_status = Teclado
				.lerTexto("Status: (0- livre, 1 - alugado, 2- vendido)");
		String tp_est = Teclado
				.lerTexto("Estrutura:(0- linear, 1 - duplex, 2- triplex)");
		String tp_pag = Teclado
				.lerTexto("Pagamento: (0-financiado, 1- quitado)");
		double valor = Teclado.lerDouble("Valor: ");
		String referencias = Teclado.lerTexto("Referencias");
		String descricao = Teclado.lerTexto("Descri��o:");
		String area_total = Teclado.lerTexto("�rea total em m�: ");
		String area_cons = Teclado.lerTexto("�rea constru�da em m�: ");
		String area_util = Teclado.lerTexto("�rea �til em m�: ");
		String qtd_comodos = Teclado.lerTexto("Quantidade de c�modos: ");
		String qtd_quartos = Teclado.lerTexto("Quantidade de quartos)");
		String vaga_garagem = Teclado.lerTexto("Vaga na Garagem");
		String dt_avaliacao = Teclado
				.lerTexto("Data de avalia��o do im�vel (dd/mm/aaaa)");
		String complemento = Teclado.lerTexto("Complemento");

		// Cria��o do Endere�o

		String cep = Teclado.lerTexto("CEP:");

		endereco = EnderecoDAO.buscarEndereco(cep);

		// Propriet�rio
		String cpf_prop = Teclado.lerTexto("Cpf do propriet�rio: ");

		proprietario = ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop);

		endereco = EnderecoDAO.buscarEndereco(cep);

		imovel = ImovelDAO.incluirImovel(codigo, tp_negocio, tp_pos, tp_status,
				tp_est, tp_pag, valor, referencias, descricao, area_total,
				area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem,
				dt_avaliacao, complemento, cep, cpf_prop);

		System.out.println(endereco);
		System.out.println(proprietario);
		System.out.println(imovel);

		System.out.println("===============================================");
		System.out.println("|        Im�vel cadastrado com sucesso       |");
		System.out.println("===============================================");
	}// fim do incluirImovel

	public void excluirImovel() {

		System.out.println("=====================");
		System.out.println("|   Excluir Im�vel  |");
		System.out.println("=====================");

		int codigo = Teclado
				.lerInt("Digite o c�digo do Im�vel que deseja excluir");

		ImovelDAO.excluirImovel(codigo);

		System.out.println("=========================================");
		System.out.println("|     Im�vel exclu�do com Sucesso    |");
		System.out.println("=========================================");

	}// fim do excluirImovel()

	public void alterarImovel() {
		System.out.println("======================");
		System.out.println("    Alterar Im�vel    ");
		System.out.println("======================");

		int id_imovel = Teclado.lerInt("Digite o c�digo do neg�cio : ");

		int codigo = Teclado.lerInt("C�digo");
		String tp_negocio = Teclado
				.lerTexto("Neg�cio (0 - loca��o, 1 - venda)");
		String tp_pos = Teclado
				.lerTexto("Posi��o: (0 -  frentes , 1 - fundos)");
		String tp_status = Teclado
				.lerTexto("Status: (0- livre, 1 - alugado, 2- vendido)");
		String tp_est = Teclado
				.lerTexto("Estrutura:(0- linear, 1 - duplex, 2- triplex)");
		String tp_pag = Teclado
				.lerTexto("Pagamento: (0-financiado, 1- quitado)");
		double valor = Teclado.lerDouble("Valor: ");
		String referencias = Teclado.lerTexto("Referencias");
		String descricao = Teclado.lerTexto("Descri��o:");
		String area_total = Teclado.lerTexto("�rea total em m�: ");
		String area_cons = Teclado.lerTexto("�rea constru�da em m�: ");
		String area_util = Teclado.lerTexto("�rea �til em m�: ");
		String qtd_comodos = Teclado.lerTexto("Quantidade de c�modos: ");
		String qtd_quartos = Teclado.lerTexto("Quantidade de quartos)");
		String vaga_garagem = Teclado.lerTexto("Vaga na Garagem:");
		String dt_avaliacao = Teclado
				.lerTexto("Data de avalia��o do im�vel (dd/mm/aaaa)");
		String complemento = Teclado.lerTexto("Complemento:");

		// Altera�ao do Endere�o
		System.out.println("Endere�o \n");
		String cep = Teclado.lerTexto("CEP:");

		// Altera�ao do Propriet�rio
		System.out.println("Propriet�rio \n");
		String cpf_prop = Teclado.lerTexto("Cpf do Propriet�rio:");

		// Plural, singular, plural, singular
		endereco = EnderecoDAO.buscarEndereco(cep);
		// Joga as informa��es primeiro no Endere�o

		ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop); // Alterar
																// buscando pelo
																// cpf_prop;

		imovel = ImovelDAO.alterarImovel(codigo, tp_negocio, tp_pos, tp_status,
				tp_est, tp_pag, valor, referencias, descricao, area_total,
				area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem,
				dt_avaliacao, complemento, cep, cpf_prop);

		System.out.println("==================================");
		System.out.println("  Im�vel atualizado com Sucesso   ");
		System.out.println("==================================");

	}

	


	// Primeiro Inclui o Propriet�rio e ap�s o Im�vel
	public void incluirProprietario() {

		System.out.println("Incluir Propriet�rio");

		String cpf_prop = Teclado.lerTexto("Cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("E-mail: ");
		String estado_civil = Teclado.lerTexto("Estado-Civil: ");
		String profissao = Teclado.lerTexto("Profiss�o: ");
		String complemento = Teclado.lerTexto("Complemento: ");

		System.out.println(" Cadastro de Endere�o\n");

		String cep = Teclado.lerTexto("CEP:");

		endereco = EnderecoDAO.buscarEndereco(cep);
		// Joga as informa��es primeiro no Endere�o

		// Propriet�rio
		proprietario = ProprietarioDAO.incluirProprietario(cpf_prop, nome,
				telefone, email, estado_civil, profissao, complemento, cep);

		System.out.println(endereco);
		System.out.println(proprietario);

	}// fim do incluirPropriet�rio

	public void excluirProprietario() {
		System.out.println("===================");
		System.out.println("|   Excluir Propriet�rio |");
		System.out.println("=================");

		String cpf_prop = Teclado
				.lerTexto("Digite o cpf do Propriet�rio a ser excluido: ");

		ProprietarioDAO.excluirProprietario(cpf_prop);

		System.out.println("=========================================");
		System.out.println("|    Propriet�rio exclu�do com Sucesso    |");
		System.out.println("=========================================");

	}// fim do excluirPropriet�rio

	public void alterarProprietario() {

		String cpf_prop = Teclado.lerTexto("Novo Cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("E-mail: ");
		String estado_civil = Teclado.lerTexto("Estado-Civil: ");
		String profissao = Teclado.lerTexto("Profiss�o: ");
		String complemento = Teclado.lerTexto("Complemento: ");

		System.out.println("* Endere�o * ");
		String cep = Teclado.lerTexto("Cep: ");
		// Joga as informa��es primeiro no Endere�o

		endereco = EnderecoDAO.buscarEndereco(cep);

		ProprietarioDAO.alterarProprietario(cpf_prop, nome, telefone, email,
				estado_civil, profissao, complemento, cep);

	}// fim do alterarPropriet�rio

	public void incluirCompra() {

		System.out.println("NOVO - Contratos de Compra ");

		int num_contCompra = Teclado.lerInt("N�mero do Contrato ");
		String dt_aquisicao = Teclado.lerTexto("Data de Aquisi��o ");
		double valor = Teclado.lerDouble("Valor ");
		String tp_pag = Teclado.lerTexto("Tipo de Pagamento ");
		int n_parcela = Teclado.lerInt("N�mero de Parcelas ");
		double comissao_cor = Teclado.lerDouble("Valor da Comiss�o ");

		System.out.println("Dados do Cliente");

		String cpf_cliente = Teclado.lerTexto("Cpf do Cliente: ");

		// List do Cliente

		cliente = ClienteDAO.buscarClienteCpf(cpf_cliente);

		System.out.println("Dados do Im�vel");

		int codigo = Teclado.lerInt("C�digo do Im�vel ");

		// List do Im�vel

		List<Imovel> imoveis = ImovelDAO.buscarImovel(codigo);

		for (Imovel imovel : imoveis) {
			System.out.println(imovel);
			System.out.println();
		}// fim do for

		System.out.println("Dados do Corretor");

		String cpf_corretor = Teclado.lerTexto("CPF do Corretor");

		// List do Corretor

		corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor);

		// array list do fiador

		String cpf_fiador = Teclado.lerTexto("CPF do Fiador");

		List<Fiador> fiadores = FiadorDAO.buscarFiador(cpf_fiador);

		for (Fiador fiador : fiadores) {
			System.out.println(fiador);
			System.out.println();
		}// fim do for
			// Joga as informa��es primeiro no Fiador

		fiadores = FiadorDAO.buscarFiador(cpf_fiador);

		// array list do propriet�rio
		System.out.println("Dados do Propriet�rio");

		String cpf_prop = Teclado.lerTexto("Cpf do Propriet�rio");

		// List do Propriet�rio

		Proprietario proprietarios = ProprietarioDAO
				.buscarProprietarioCPF_PROP(cpf_prop);

		contratoCompra = ContratoCompraDAO.incluirCompra(num_contCompra,
				dt_aquisicao, valor, tp_pag, n_parcela, comissao_cor,
				cpf_cliente, codigo, cpf_corretor, cpf_fiador, cpf_prop);

		System.out.println(contratoCompra);
	}// fim do incluirCompra

	public void excluirCompra() {

		System.out.println("Excluir Contrato de Compra \n ");

		int num_contCompra = Teclado
				.lerInt("Digite N�mero do Contrato que deseja excluir \n");

		ContratoCompraDAO.excluirCompra(num_contCompra);

		System.out.println("Contrato Exclu�do com Sucesso");

	}// fim do excluirCompra

	public void alterarCompra() {

		// FAZER DEPOIS QUE O INCLUIR ESTIVER CORRETO

	}// fim do alterarPropriet�rio

	public void incluirAluguel() {

		System.out.println("Novo - Contrato Aluguel");

		int num_contAluguel = Teclado.lerInt("N�mero do Contrato: ");
		String dt_aquisicao = Teclado.lerTexto("Data de Aquisi��o: ");
		String dt_vencimento = Teclado.lerTexto("Data de Vencimento: ");
		String dt_pag = Teclado.lerTexto("Pagar at� o dia ");
		double valor = Teclado.lerDouble("Valor do Aluguel R$ ");
		double comissao_cor = Teclado
				.lerDouble("Valor da Comiss�o do Corretor R$ ");

		System.out.println("Dados do Cliente");
		String cpf_cliente = Teclado.lerTexto("Cpf do Cliente ");

		cliente = ClienteDAO.buscarClienteCpf(cpf_cliente);

		System.out.println("Dados do Im�vel");

		int codigo = Teclado.lerInt("C�digo do Im�vel ");

		// List do Im�vel

		imovel = ImovelDAO.buscarImovelCodigo(codigo); // S� para buscar o
														// c�digo

		System.out.println(imovel);

		System.out.println("Dados do Corretor");

		String cpf_corretor = Teclado.lerTexto("CPF do Corretor");

		// List do Corretor

		corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor);

		System.out.println("Dados do Propriet�rio");

		String cpf_prop = Teclado.lerTexto("Cpf do Propriet�rio");

		// List do Propriet�rio

		proprietario = ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop);

		contAluguel = ContratoAluguelDAO.incluirAluguel(num_contAluguel,
				dt_aquisicao, dt_vencimento, dt_pag, valor, comissao_cor,
				cpf_cliente, codigo, cpf_corretor, cpf_prop);

		System.out.println(contAluguel);

	}// fim do incluirAluguel

	public void excluirAluguel() {

		System.out.println("Excluir Contrato de Aluguel");

		int num_contAluguel = Teclado
				.lerInt("N�mero do Contrato que deseja excluir: ");

		ContratoAluguelDAO.excluirAluguel(num_contAluguel);

		System.out.println("CONTRATO EXCLU�DO COM SUCESSO");

	}// fim do excluirAluguel

	public void alterarAluguel() {

	}// fim do alterarAluguel

	/*
	public void buscarCorretor() {

		System.out.println("Buscar Corretor \n");

		String cpf_corretor = Teclado.lerTexto("CPF : ");

		// ArrayList da Pesquisa
		corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor);

		String creci = corretor.getCreci();
		String nome = corretor.getNome();
		String telefone = corretor.getTelefone();
		String email = corretor.getEmail();
		String tp_cor = corretor.getTp_cor();
		String complemento = corretor.getComplemento();
		int idCep = corretor.getId_cep();

		endereco = EnderecoDAO.buscarEndereco(idCep);

		String cep = endereco.getCep();
		String logradouro = endereco.getLogradouro();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade();
		String estado = endereco.getEstado();

	}// fim do buscarCorretor
/*/
	// Buscar Fiador
	public void buscarFiador() {

		System.out.println("Buscar Fiador \n");

		String cpf_fiador = Teclado.lerTexto("CPF : ");

		fiador = FiadorDAO.buscarFiadorCpf(cpf_fiador);

		String nome = fiador.getNome();
		String telefone = fiador.getTelefone();
		String email = fiador.getEmail();
		String profissao = fiador.getProfissao();
		String complemento = fiador.getComplemento();
		int idCep = fiador.getId_cep();

		endereco = EnderecoDAO.buscarEndereco(idCep);

		String cep = endereco.getCep();
		String logradouro = endereco.getLogradouro();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade();
		String estado = endereco.getEstado();

	}// fim do buscarFiador

	public void buscarProp() {

		System.out.println("Buscar Propriet�rio \n");

		String cpf_prop = Teclado.lerTexto("CPF : ");

		proprietario = ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop);

		String nome = proprietario.getNome();
		String telefone = proprietario.getTelefone();
		String email = proprietario.getEmail();
		String estado_civil = proprietario.getEstado_civil();
		String profissao = proprietario.getProfissao();
		String complemento = proprietario.getComplemento();
		int idCep = proprietario.getId_cep();

		endereco = EnderecoDAO.buscarEndereco(idCep);

		String cep = endereco.getCep();
		String logradouro = endereco.getLogradouro();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade();
		String estado = endereco.getEstado();

	}// fim do buscarProp

	public void incluirCorretor() {

		System.out.println("Incluir Corretor");

		String creci = Teclado.lerTexto("Creci: ");
		String cpf_corretor = Teclado.lerTexto("Cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("E-mail: ");
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		String tp_cor = Teclado.lerTexto("Tipo: ");
		String complemento = Teclado.lerTexto("Complemento: ");

		// Endere�o
		System.out.println("Endere�o \n");

		// O id � auto_increment perguntar como � perguntar para o usu�rio
		String cep = Teclado.lerTexto("CEP:");

		// Joga as informa��es primeiro no Endere�o depois alterado
		endereco = EnderecoDAO.buscarEndereco(cep);

		// Incluindo o corretor
		corretor = CorretorDAO.incluirCorretor(creci, cpf_corretor, nome,
				telefone, email, login, senha, tp_cor, complemento, cep);

		System.out.println(endereco);
		System.out.println(corretor);

	}// fim do incluirCorretor() v

	public void alterarCorretor() {

		System.out.println("Alterando Corretor");

		String creci = Teclado.lerTexto("Creci: ");
		String cpf_corretor = Teclado.lerTexto("Cpf: ");
		String nome = Teclado.lerTexto("Nome: ");
		String telefone = Teclado.lerTexto("Telefone: ");
		String email = Teclado.lerTexto("E-mail: ");
		String login = Teclado.lerTexto("Login: ");
		String senha = Teclado.lerTexto("Senha: ");
		String tp_cor = Teclado.lerTexto("Tipo: ");
		String complemento = Teclado.lerTexto("Complemento: ");

		// Endere�o
		System.out.println("Alterar Endere�o \n");

		// O id � auto_increment perguntar como � perguntar para o usu�rio
		String cep = Teclado.lerTexto("CEP:");

		// Joga as informa��es primeiro no Endere�o depois alterado
		endereco = EnderecoDAO.buscarEndereco(cep);

		// Incluindo o corretor
		corretor = CorretorDAO.alterarCorretor(creci, cpf_corretor, nome,
				telefone, email, login, senha, tp_cor, complemento, cep);

		System.out.println(endereco);
		System.out.println(corretor);

	}// fim do incluirCorretor()
	
	
	public void PesquisarImovel() { //TELA DE PESQUISAR IM�VEL
		
		Double valorMin = imovel.getValor();
		Double valorMax = imovel.getValor();
		String tp_status = imovel.getTp_status();
		String bairro = endereco.getBairro();
		String cidade = endereco.getCidade();
		
		List<Imovel> imovel = ImovelDAO.PesquisarImovel(valorMin, valorMax, bairro, cidade, tp_status);
		List<Endereco> enderecos = EnderecoDAO.PesquisarEndereco(valorMin, valorMax, bairro, cidade, tp_status);
	
		
	}
	
}// fim da classe

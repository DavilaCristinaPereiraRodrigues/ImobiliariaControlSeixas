package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Endereco;
import model.Proprietario;
import model.DAO.ClienteDAO;
import model.Cliente;
import model.Corretor;
import model.DAO.ContratoAluguelDAO;
import model.DAO.CorretorDAO;
import model.DAO.FiadorDAO;
import model.Imovel;
import model.DAO.ImovelDAO;
import model.DAO.ProprietarioDAO;

import javax.swing.JPanel;

public class ContratoAluguel extends JFrame {

	String cpf_cliente;
	String cpf_corretor;
	String cpf_prop;
	int codigo;

	private JTextField txtValordaComissao;
	private JTextField txtImovel;
	private JTextField txtValorDoAluguel;
	private JTextField txtAquisicao;
	private JTextField txtDataDoVencimento;
	private JTextField txtPagamento;
	private JTextField txtNumero;// n�mero do contrato do aluguel
	private JTextField txtCliente;
	private JTextField txtNomeCliente;
	private JTextField txtCpfProp;
	private JTextField txtNomeProp;
	private JTextField txtCpfCor;
	private JTextField txtNomeCor;

	public static void main(String[] args) {

		try {
			new ContratoAluguel();
			// frame.setVisible(true);
			// frame.setResizable(false);
			// frame.setLocationRelativeTo(null);//Centraliza a janela na tela
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ContratoAluguel() {

		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setTitle("Contratos de Aluguel"); // Colocar o nome da tela
		// aqui e DISPOSE_ON_CLOSE para sair so da classe sem sai do menu
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 800, 600);
		getContentPane().setLayout(null);

		txtCliente = new JTextField();
		txtCliente.setText("");
		txtCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCliente.setColumns(10);
		txtCliente.setBounds(325, 162, 140, 20);
		getContentPane().add(txtCliente);

		txtImovel = new JTextField();
		txtImovel.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtImovel.setText("");
		txtImovel.setColumns(10);
		txtImovel.setBounds(524, 90, 126, 20);
		getContentPane().add(txtImovel);

		JLabel lblValorDaComissao = new JLabel("Comiss\u00E3o");
		lblValorDaComissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValorDaComissao.setBounds(547, 450, 96, 14);
		getContentPane().add(lblValorDaComissao);

		txtValordaComissao = new JTextField();
		txtValordaComissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtValordaComissao.setText("");
		txtValordaComissao.setColumns(10);
		txtValordaComissao.setBounds(628, 447, 89, 20);
		getContentPane().add(txtValordaComissao);

		JLabel lblAquisicao = new JLabel("Aquisi\u00E7\u00E3o");
		lblAquisicao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblAquisicao.setBounds(301, 476, 83, 23);
		getContentPane().add(lblAquisicao);

		txtAquisicao = new JTextField();
		txtAquisicao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtAquisicao.setText("");
		txtAquisicao.setColumns(10);
		txtAquisicao.setBounds(384, 477, 125, 20);
		getContentPane().add(txtAquisicao);

		JLabel lblVencimento = new JLabel("Vencimento");
		lblVencimento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblVencimento.setBounds(278, 511, 104, 14);
		getContentPane().add(lblVencimento);

		JLabel ValorDoAluguel = new JLabel(" Aluguel");
		ValorDoAluguel.setFont(new Font("Calibri", Font.PLAIN, 18));
		ValorDoAluguel.setBounds(547, 478, 83, 19);
		getContentPane().add(ValorDoAluguel);

		txtValorDoAluguel = new JTextField();
		txtValorDoAluguel.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtValorDoAluguel.setText("");
		txtValorDoAluguel.setColumns(10);
		txtValorDoAluguel.setBounds(628, 477, 93, 20);
		getContentPane().add(txtValorDoAluguel);

		JLabel lblPagamento = new JLabel("Pagar at\u00E9 ");
		lblPagamento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPagamento.setBounds(301, 440, 83, 25);
		getContentPane().add(lblPagamento);

		txtPagamento = new JTextField();
		txtPagamento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtPagamento.setBounds(382, 446, 83, 20);
		getContentPane().add(txtPagamento);
		txtPagamento.setColumns(10);

		txtDataDoVencimento = new JTextField();
		txtDataDoVencimento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtDataDoVencimento.setText("");
		txtDataDoVencimento.setColumns(10);
		txtDataDoVencimento.setBounds(384, 508, 125, 20);
		getContentPane().add(txtDataDoVencimento);

		JLabel lblNumero = new JLabel("N\u00FAmero do Contrato");
		lblNumero.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNumero.setBounds(325, 54, 156, 25);
		getContentPane().add(lblNumero);

		txtNumero = new JTextField();
		txtNumero.setText("");
		txtNumero.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(325, 90, 125, 20);
		getContentPane().add(txtNumero);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int opt1 = JOptionPane.showConfirmDialog(null,
						"Deseja salvar as altera��es? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui

					int num_contAluguel = (Integer.parseInt(txtNumero.getText()));

					model.ContratoAluguel ca = ContratoAluguelDAO
							.buscarContratoAlu(num_contAluguel);

					if (ca == null) {
						String dt_aquisicao = txtAquisicao.getText();
						double valor = (Double.parseDouble(txtValorDoAluguel
								.getText())); // convertendo
												// para
												// double
						double comissao_cor = (Double
								.parseDouble(txtValordaComissao.getText())); // convertendo
																				// para
																				// double
						String dt_vencimento = txtDataDoVencimento.getText();
						String dt_pag = txtPagamento.getText();
						String cpf_cliente = txtCliente.getText();
						String cpf_prop = txtCpfProp.getText();
						String cpf_corretor = txtCpfCor.getText();
						int codigo = (Integer.parseInt(txtImovel.getText())); // im�vel

						// aqui e para fazer os campos seres limpos apos salva
						for (int i = 0; i < getContentPane()
								.getComponentCount(); i++) {
							// varre todos os componentes

							Component c = getContentPane().getComponent(i);

							if (c instanceof JTextField) {
								// apaga os valores
								JTextField field = (JTextField) c;
								field.setText("");

							}
						}

						ContratoAluguelDAO.incluirAluguel(num_contAluguel,
								dt_aquisicao, dt_vencimento, dt_pag, valor,
								comissao_cor, cpf_cliente, codigo,
								cpf_corretor, cpf_prop);

						JOptionPane.showMessageDialog(null,
								"Contrato salvo com Sucesso! ");

					} else {

						String dt_aquisicao = txtAquisicao.getText();
						double valor = (Double.parseDouble(txtValorDoAluguel
								.getText())); // convertendo
												// para
												// double
						double comissao_cor = (Double
								.parseDouble(txtValordaComissao.getText())); // convertendo
																				// para
																				// double
						String dt_vencimento = txtDataDoVencimento.getText();
						String dt_pag = txtPagamento.getText();
						String cpf_cliente = txtCliente.getText();
						String cpf_prop = txtCpfProp.getText();
						String cpf_corretor = txtCpfCor.getText();
						int codigo = (Integer.parseInt(txtImovel.getText())); // im�vel

						// aqui e para fazer os campos seres limpos apos salva
						for (int i = 0; i < getContentPane()
								.getComponentCount(); i++) {
							// varre todos os componentes

							Component c = getContentPane().getComponent(i);

							if (c instanceof JTextField) {
								// apaga os valores
								JTextField field = (JTextField) c;
								field.setText("");

							}
						}
						ContratoAluguelDAO.alterarContratoAluguel(
								num_contAluguel, dt_aquisicao, dt_vencimento,
								dt_pag, valor, comissao_cor, cpf_cliente,
								codigo, cpf_corretor, cpf_prop);

						JOptionPane.showMessageDialog(null,
								"Contrato editado com Sucesso! ");

					}
				}// fim do switch
			}
		});// fim do Action Listener

		btnSalvar.setBounds(89, 323, 110, 41);
		getContentPane().add(btnSalvar);

		// Bot�o de Excluir
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("img\\delete84 (3).png"));
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int num_contAluguel = (Integer.parseInt(txtNumero.getText()));
				int opt1 = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja excluir ? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim exclui o Im�vel
					for (int i = 0; i < getContentPane().getComponentCount(); i++) {
						// varre todos os componentes

						Component c = getContentPane().getComponent(i);

						if (c instanceof JTextField) {
							// apaga os valores
							JTextField field = (JTextField) c;
							field.setText("");

						}
					}

				ContratoAluguelDAO.excluirAluguel(num_contAluguel);
			
				JOptionPane.showMessageDialog(null,
						"Contrato exclu�do com Sucesso! ");
				break;

			case JOptionPane.NO_OPTION:

				break;

			}// fim do switch
				
				}
		});
		btnExcluir.setBounds(89, 423, 110, 41);
		getContentPane().add(btnExcluir);

		// Bot�o para buscar o cpf do cliente
		JButton btnPesquisarCliente = new JButton("");
		btnPesquisarCliente.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnPesquisarCliente.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCliente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_cliente = txtCliente.getText();

				Cliente cliente = ClienteDAO.buscarClienteCpf(cpf_cliente); // N�O
																			// ESQUECER
																			// DE
																			// DAR
																			// UM
																			// IMPORT
																			// NO
																			// CLIENTE
																			// DO
																			// MODEL

				// Verificar se o cliente existe no Banco de Dados e vem com
				// os dados completo do cliente id, nome, telefone
				if (cliente == null) {

					JOptionPane.showMessageDialog(null,
							"Cliente n�o cadastrado");

				} else {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * "Dados do cliente \n " + cliente);//est� pegando //o
					 * m�todo toString no model Cliente e jogando neste
					 * showMessage
					 */

					int opt2 = JOptionPane.showConfirmDialog(null,
							"Dados do cliente\n " + cliente, "Cliente",
							JOptionPane.OK_CANCEL_OPTION); // o m�todo toString
															// no model Cliente
															// e jogando neste
															// showMessage

					switch (opt2) {
					case JOptionPane.CANCEL_OPTION:
						JOptionPane.showMessageDialog(null,
								"Voc� clicou em \"Cancelar\"");
						break;

					case JOptionPane.OK_OPTION:
						JOptionPane.showMessageDialog(null,
								"Dados inseridos com Sucesso");
						// Se clicar em OK joga o cliente na tela salvando-o
						String nome = cliente.getNome();

						txtNomeCliente.setText(nome);
						break;

					default:
						JOptionPane.showMessageDialog(null,
								"Voc� fechou a janela");
						break;
					}// fim do switch

				}

			}
		});

		btnPesquisarCliente.setBounds(475, 162, 33, 20);
		getContentPane().add(btnPesquisarCliente);

		JLabel lblCpfCli = new JLabel("CPF do Cliente");
		lblCpfCli.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfCli.setBounds(325, 137, 125, 14);
		getContentPane().add(lblCpfCli);

		JLabel lblNomeCli = new JLabel("Nome");
		lblNomeCli.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeCli.setBounds(522, 135, 46, 14);
		getContentPane().add(lblNomeCli);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setBounds(522, 161, 224, 20);
		txtNomeCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeCliente.setEditable(false);
		getContentPane().add(txtNomeCliente);
		txtNomeCliente.setColumns(10);

		JButton btnPesquisarImovel = new JButton("");
		btnPesquisarImovel.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnPesquisarImovel.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarImovel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int codigo = (Integer.parseInt(txtImovel.getText())); // c�digo
																		// do
																		// imovel

				Imovel imovel = ImovelDAO.buscarImovelCodigo(codigo);

				// Verificar se o c�digo existe no Banco de Dados
				if (imovel == null) {

					JOptionPane.showMessageDialog(null,
							"C�digo de im�vel n�o existente");

				} else {
					JOptionPane.showMessageDialog(null, "C�digo de im�vel: "
							+ codigo);

				}

			}
		});

		btnPesquisarImovel.setBounds(660, 88, 33, 20);
		getContentPane().add(btnPesquisarImovel);

		JLabel lblCodigoImovel = new JLabel("C\u00F3digo do im\u00F3vel");
		lblCodigoImovel.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCodigoImovel.setBounds(520, 54, 130, 25);
		getContentPane().add(lblCodigoImovel);

		JLabel lblCpf = new JLabel("CPF do Propriet\u00E1rio");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(329, 202, 150, 14);
		getContentPane().add(lblCpf);

		txtCpfProp = new JTextField();
		txtCpfProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpfProp.setBounds(325, 228, 140, 20);
		getContentPane().add(txtCpfProp);
		txtCpfProp.setColumns(10);

		JButton btnPesquisarCpfProp = new JButton("");
		btnPesquisarCpfProp.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnPesquisarCpfProp.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCpfProp.setBounds(478, 228, 33, 20);
		btnPesquisarCpfProp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_prop = txtCpfProp.getText();

				Proprietario proprietario = ProprietarioDAO
						.buscarProprietarioCPF_PROP(cpf_prop); // N�O ESQUECER
																// DE DAR UM
																// IMPORT NO
																// CLIENTE DO
																// MODEL

				// Verificar se o cliente existe no Banco de Dados e vem com
				// os dados completo do cliente id, nome, telefone
				if (proprietario == null) {

					JOptionPane.showMessageDialog(null,
							"Cliente n�o cadastrado");

				} else {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * "Dados do cliente \n " + cliente);//est� pegando //o
					 * m�todo toString no model Cliente e jogando neste
					 * showMessage
					 */

					int opt2 = JOptionPane.showConfirmDialog(null,
							"Dados do propriet�rio\n " + proprietario,
							"Propriet�rio", JOptionPane.OK_CANCEL_OPTION); // o
																			// m�todo
																			// toString
																			// no
																			// model
																			// Cliente
																			// e
																			// jogando
																			// neste
																			// showMessage

					switch (opt2) {
					case JOptionPane.CANCEL_OPTION:
						JOptionPane.showMessageDialog(null,
								"Voc� clicou em \"Cancelar\"");
						break;

					case JOptionPane.OK_OPTION:
						JOptionPane.showMessageDialog(null,
								"Dados inseridos com Sucesso");
						// Se clicar em OK joga o os dados do propriet�rio na
						// tela salvando-o

						String nome = proprietario.getNome();

						txtNomeProp.setText(nome);
						break;

					default:
						JOptionPane.showMessageDialog(null,
								"Voc� fechou a janela");
						break;
					}// fim do switch

				}
			}
		});
		getContentPane().add(btnPesquisarCpfProp);

		JLabel lblNomeProp = new JLabel("Nome");
		lblNomeProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeProp.setBounds(525, 202, 46, 14);
		getContentPane().add(lblNomeProp);

		txtNomeProp = new JTextField();
		txtNomeProp.setEditable(false);
		txtNomeProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeProp.setColumns(10);
		txtNomeProp.setBounds(525, 230, 221, 20);
		getContentPane().add(txtNomeProp);

		JLabel lblCpfCorretor = new JLabel("CPF Corretor");
		lblCpfCorretor.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfCorretor.setBounds(329, 262, 112, 14);
		getContentPane().add(lblCpfCorretor);

		txtCpfCor = new JTextField();
		txtCpfCor.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpfCor.setColumns(10);
		txtCpfCor.setBounds(325, 288, 140, 20);
		getContentPane().add(txtCpfCor);

		JButton btnPesquisarCor = new JButton("");
		btnPesquisarCor.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_corretor = txtCpfCor.getText();

				Corretor corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor); // N�O
																					// ESQUECER
																					// DE
				// Verificar se o cliente existe no Banco de Dados e vem com
				// os dados completo do cliente id, nome, telefone
				if (corretor == null) {

					JOptionPane.showMessageDialog(null,
							"Corretor n�o cadastrado");

				} else {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * "Dados do cliente \n " + cliente);//est� pegando //o
					 * m�todo toString no model Cliente e jogando neste
					 * showMessage
					 */

					int opt2 = JOptionPane.showConfirmDialog(null,
							"Dados do corretor\n " + corretor, "Corretor",
							JOptionPane.OK_CANCEL_OPTION); // o m�todo toString
															// no model Cliente
															// e jogando neste
															// showMessage

					switch (opt2) {
					case JOptionPane.CANCEL_OPTION:
						JOptionPane.showMessageDialog(null,
								"Voc� clicou em \"Cancelar\"");
						break;

					case JOptionPane.OK_OPTION:
						JOptionPane.showMessageDialog(null,
								"Dados inseridos com Sucesso");
						// Se clicar em OK joga o os dados do propriet�rio na
						// tela salvando-o

						// DO
						// MODEL
						String nome = corretor.getNome();

						txtNomeCor.setText(nome);
						break;

					default:
						JOptionPane.showMessageDialog(null,
								"Voc� fechou a janela");
						break;
					}// fim do switch

				}
			}
		}); // DAR

		btnPesquisarCor.setBounds(481, 288, 33, 20);
		getContentPane().add(btnPesquisarCor);

		txtNomeCor = new JTextField();
		txtNomeCor.setColumns(10);
		txtNomeCor.setEditable(false); // n�o editar o usu�rio
		txtNomeCor.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeCor.setBounds(525, 290, 221, 20);
		getContentPane().add(txtNomeCor);

		JLabel label_1 = new JLabel("Nome");
		label_1.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_1.setBounds(525, 262, 46, 14);
		getContentPane().add(label_1);

		JLabel lblData = new JLabel("Datas");
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblData.setBounds(384, 410, 83, 17);
		getContentPane().add(lblData);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblValor.setBounds(628, 398, 83, 17);
		getContentPane().add(lblValor);

		// Pesquisar N�mero do Contrato
		JButton btnPesqNum = new JButton("");
		btnPesqNum.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnPesqNum.setBounds(477, 90, 33, 20);
		btnPesqNum.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesqNum.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int num_contAluguel = (Integer.parseInt(txtNumero.getText()));

				model.ContratoAluguel contAluguelmd = ContratoAluguelDAO
						.buscarContratoAlu(num_contAluguel);

				if (contAluguelmd != null) {

					String dt_aquisicao = contAluguelmd.getDt_aquisicao();
					txtAquisicao.setText(dt_aquisicao);

					String dt_vencimento = contAluguelmd.getDt_vencimento();
					txtDataDoVencimento.setText(dt_vencimento);

					String dt_pag = contAluguelmd.getDt_pag();
					txtPagamento.setText(dt_pag);

					double valor = contAluguelmd.getValor(); // convertendo
					txtValorDoAluguel.setText(String.valueOf(valor));

					double comissao = contAluguelmd.getValor(); // convertendo
					txtValordaComissao.setText(String.valueOf(comissao));

					int fk_cliente = contAluguelmd.getFk_cliente();
					int fk_imovel = contAluguelmd.getFk_imovel();
					int fk_corretor = contAluguelmd.getFk_corretor();
					int fk_prop = contAluguelmd.getFk_prop();

					// Cliente

					Cliente cliente = ClienteDAO.buscarClienteFk(fk_cliente);

					String cpf_cliente = cliente.getCpf_cliente();
					txtCliente.setText(cpf_cliente); // cpf

					String nome = cliente.getNome();
					txtNomeCliente.setText(nome);

					// Prop
					Proprietario proprietario = ProprietarioDAO
							.buscarProprietariofkProp(fk_prop);

					String cpf_prop = proprietario.getCpf_prop();
					txtCpfProp.setText(cpf_prop); // cpf

					String nome_prop = proprietario.getNome();
					txtNomeProp.setText(nome_prop);

					// Imovel
					Imovel imovel = ImovelDAO.buscarImovelFk(fk_imovel);

					int codigo = imovel.getCodigo();
					txtImovel.setText(String.valueOf(codigo));

					// Corretor
					Corretor corretor = CorretorDAO
							.buscarCorretorFk(fk_corretor);

					String cpf_corretor = corretor.getCpf_corretor();
					txtCpfCor.setText(cpf_corretor); // cpf

					String nome_cor = corretor.getNome();
					txtNomeCor.setText(nome_cor);

				}// fim do if
				else {

					// se n�o estiver cadastrado um cpf no cliente amostra
					// o JoptionPANE

					JOptionPane.showMessageDialog(null,
							"Contrato n�o encontrado", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}

			}// fim do actionPerfomed

		});
		getContentPane().add(btnPesqNum);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img\\contratoCont.jpg"));
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(81, 65, 143, 151);
		getContentPane().add(label);

		JLabel lblContratoDeCompra = new JLabel("Contrato de Aluguel");
		lblContratoDeCompra.setFont(new Font("Calibri", Font.BOLD, 21));
		lblContratoDeCompra.setBounds(57, 235, 192, 20);
		getContentPane().add(lblContratoDeCompra);

		JPanel panel = new JPanel();
		panel.setBounds(32, 37, 231, 253);
		getContentPane().add(panel);

		setVisible(true);
		setResizable(false);// Fazer que a tela n�o redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro

		// imagem de fundo
		JLabel lblImagem = new JLabel("imagem");
		lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
		lblImagem.setBounds(0, -4, 1024, 728);
		getContentPane().add(lblImagem);

	}
}

package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Cliente;
import model.Corretor;
import model.Fiador;
import model.Imovel;
import model.Proprietario;
import model.DAO.ClienteDAO;
import model.DAO.ContratoAluguelDAO;
import model.DAO.ContratoCompraDAO;
import model.DAO.CorretorDAO;
import model.DAO.FiadorDAO;
import model.DAO.ImovelDAO;
import model.DAO.ProprietarioDAO;

import javax.swing.JPanel;

public class ContratoCompra extends JFrame {

	String cpf_cliente;
	String cpf_prop;
	int codigo;
	String cpf_corretor;
	
	
	private JTextField txtNumero;
	private JTextField txtValorDaComissao;
	private JTextField txtDataAqui;
	private JTextField txtValorVenda;
	private JTextField txtNparcelas;
	private JTextField txtCliente;
	private JTextField txtCodigo;
	private JTextField txtNomeCliente;
	private JTextField txtCpfProp;
	private JTextField txtNomeProp;
	private JTextField txtCpfCor;
	private JTextField txtNomeCor;
	private JTextField txtCpfFia;
	private JTextField txtNomeFia;

	public static void main(String[] args) {

		try {
			new ContratoCompra();
			// frame.setVisible(true);
			// frame.setResizable(false);
			// frame.setLocationRelativeTo(null);//Centraliza a janela na tela
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ContratoCompra() {
		super("Contrato de Compra ");

		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 800, 600);
		getContentPane().setLayout(null);

		JLabel lblDataDeAq = new JLabel("Data de Aquisi\u00E7\u00E3o");
		lblDataDeAq.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDataDeAq.setBounds(538, 353, 165, 17);
		getContentPane().add(lblDataDeAq);

		JLabel lblTipoDePag = new JLabel("Tipo de Pagamento");
		lblTipoDePag.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipoDePag.setBounds(322, 471, 152, 17);
		getContentPane().add(lblTipoDePag);

		JLabel lbNumero = new JLabel("N\u00FAmero do Contrato");
		lbNumero.setFont(new Font("Calibri", Font.PLAIN, 18));
		lbNumero.setBounds(322, 51, 162, 17);
		getContentPane().add(lbNumero);

		JLabel lblDaVenda = new JLabel("Venda");
		lblDaVenda.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDaVenda.setBounds(322, 412, 127, 17);
		getContentPane().add(lblDaVenda);

		JLabel lblValorDaComisso = new JLabel("Comiss\u00E3o");
		lblValorDaComisso.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValorDaComisso.setBounds(322, 353, 152, 17);
		getContentPane().add(lblValorDaComisso);

		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNumero.setColumns(10);
		txtNumero.setBounds(322, 79, 133, 20);
		getContentPane().add(txtNumero);

		txtValorDaComissao = new JTextField();
		txtValorDaComissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtValorDaComissao.setColumns(10);
		txtValorDaComissao.setBounds(322, 381, 133, 20);
		getContentPane().add(txtValorDaComissao);

		txtDataAqui = new JTextField();
		txtDataAqui.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtDataAqui.setColumns(10);
		txtDataAqui.setBounds(538, 381, 165, 20);
		getContentPane().add(txtDataAqui);

		txtValorVenda = new JTextField();
		txtValorVenda.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtValorVenda.setColumns(10);
		txtValorVenda.setBounds(322, 440, 165, 20);
		getContentPane().add(txtValorVenda);

		JComboBox cbTipoPag = new JComboBox(new Object[] { "Financiado",
				"A vista" });
		cbTipoPag.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbTipoPag.setBounds(322, 499, 157, 20);
		getContentPane().add(cbTipoPag);

		JLabel lblNmeroDeParcelas = new JLabel("N\u00FAmero de Parcelas");
		lblNmeroDeParcelas.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNmeroDeParcelas.setBounds(538, 413, 160, 14);
		getContentPane().add(lblNmeroDeParcelas);

		txtNparcelas = new JTextField();
		txtNparcelas.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNparcelas.setBounds(538, 440, 165, 20);
		getContentPane().add(txtNparcelas);
		txtNparcelas.setColumns(10);

		txtCliente = new JTextField();
		txtCliente.setText("");
		txtCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCliente.setColumns(10);
		txtCliente.setBounds(322, 132, 144, 20);
		getContentPane().add(txtCliente);

		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(540, 76, 126, 20);
		getContentPane().add(txtCodigo);

		JLabel lblCpfCliente = new JLabel("CPF do Cliente");
		lblCpfCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfCliente.setBounds(322, 107, 120, 14);
		getContentPane().add(lblCpfCliente);

		JLabel lblNomeCleinte = new JLabel("Nome");
		lblNomeCleinte.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeCleinte.setBounds(540, 107, 46, 14);
		getContentPane().add(lblNomeCleinte);

		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeCliente.setEditable(false);

		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(537, 133, 206, 20);
		getContentPane().add(txtNomeCliente);

		JButton btnPesquisarImovel = new JButton("");
		btnPesquisarImovel.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarImovel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int codigo = (Integer.parseInt(txtCodigo.getText())); // c�digo
																		// do
																		// imovel

				Imovel imovel = ImovelDAO.buscarImovelCodigo(codigo);

				// Verificar se o c�digo existe no Banco de Dados
				if (imovel == null) {

					JOptionPane.showMessageDialog(null,
							"C�digo de im�vel n�o existente");

				} else {
					JOptionPane.showMessageDialog(null,
							"C�digo de im�vel Existente : " + codigo);

				}

			}
		});

		btnPesquisarImovel.setBounds(694, 76, 33, 20);
		getContentPane().add(btnPesquisarImovel);

		JLabel lblCodigo = new JLabel("C\u00F3digo do Im�vel");
		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCodigo.setBounds(540, 51, 130, 23);
		getContentPane().add(lblCodigo);

		JLabel lblCpfProp = new JLabel("CPF do Propriet�rio");
		lblCpfProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfProp.setBounds(322, 163, 150, 14);
		getContentPane().add(lblCpfProp);

		txtCpfProp = new JTextField();
		txtCpfProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpfProp.setColumns(10);
		txtCpfProp.setBounds(322, 192, 144, 20);
		getContentPane().add(txtCpfProp);

		JButton btnPesquisarCpfProp = new JButton("");
		btnPesquisarCpfProp.setIcon(new ImageIcon("img\\magnifier13.png"));
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
							"Propriet�rio n�o cadastrado");

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
		btnPesquisarCpfProp.setBounds(476, 191, 33, 20);
		getContentPane().add(btnPesquisarCpfProp);

		JLabel lblNomeProp = new JLabel("Nome");
		lblNomeProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeProp.setBounds(540, 165, 46, 14);
		getContentPane().add(lblNomeProp);

		txtNomeProp = new JTextField();
		txtNomeProp.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeProp.setColumns(10);
		txtNomeProp.setEditable(false);

		txtNomeProp.setBounds(537, 192, 206, 20);
		getContentPane().add(txtNomeProp);

		JLabel lblCpfCor = new JLabel("CPF do Corretor");
		lblCpfCor.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfCor.setBounds(322, 222, 120, 14);
		getContentPane().add(lblCpfCor);

		txtCpfCor = new JTextField();
		txtCpfCor.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpfCor.setColumns(10);
		txtCpfCor.setBounds(322, 245, 144, 20);
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

		btnPesquisarCor.setBounds(476, 245, 33, 20);
		getContentPane().add(btnPesquisarCor);

		txtNomeCor = new JTextField();
		txtNomeCor.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeCor.setColumns(10);
		txtNomeCor.setEditable(false);

		txtNomeCor.setBounds(537, 245, 206, 20);
		getContentPane().add(txtNomeCor);

		JLabel label_10 = new JLabel("Nome");
		label_10.setFont(new Font("Calibri", Font.PLAIN, 18));
		label_10.setBounds(540, 225, 46, 14);
		getContentPane().add(label_10);

		txtCpfFia = new JTextField();
		txtCpfFia.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpfFia.setColumns(10);
		txtCpfFia.setBounds(322, 297, 144, 20);
		getContentPane().add(txtCpfFia);

		JLabel lblCpfFia = new JLabel("CPF do Fiador");
		lblCpfFia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpfFia.setBounds(322, 276, 120, 14);
		getContentPane().add(lblCpfFia);

		JButton btnPesquisarFiador = new JButton("");
		btnPesquisarFiador.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarFiador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_fiador = txtCpfFia.getText();

				Fiador fiador = FiadorDAO.buscarFiadorCpf(cpf_fiador); // N�O
																		// DE
				// Verificar se o cliente existe no Banco de Dados e vem
				// com
				// os dados completo do cliente id, nome, telefone
				if (fiador == null) {

					JOptionPane
							.showMessageDialog(null, "Fiador n�o cadastrado");

				} else {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * "Dados do cliente \n " + cliente);//est� pegando //o
					 * m�todo toString no model Cliente e jogando neste
					 * showMessage
					 */

					int opt2 = JOptionPane.showConfirmDialog(null,
							"Dados do Fiador\n " + fiador, "Fiador",
							JOptionPane.OK_CANCEL_OPTION); // o
															// m�todo

					switch (opt2) {
					case JOptionPane.CANCEL_OPTION:
						JOptionPane.showMessageDialog(null,
								"Voc� clicou em \"Cancelar\"");
						break;

					case JOptionPane.OK_OPTION:
						JOptionPane.showMessageDialog(null,
								"Dados inseridos com Sucesso");
						// Se clicar em OK joga o os dados do
						// propriet�rio na
						// tela salvando-o

						// DO
						// MODEL
						String nome = fiador.getNome();

						txtNomeFia.setText(nome);
						break;

					default:
						JOptionPane.showMessageDialog(null,
								"Voc� fechou a janela");
						break;
					}// fim do switch

				}
			}
		});
		btnPesquisarFiador.setBounds(476, 299, 33, 20);
		getContentPane().add(btnPesquisarFiador);

		txtNomeFia = new JTextField();
		txtNomeFia.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNomeFia.setColumns(10);
		txtNomeFia.setEditable(false);

		txtNomeFia.setBounds(537, 297, 206, 20);
		getContentPane().add(txtNomeFia);

		JLabel lblNomeFia = new JLabel("Nome");
		lblNomeFia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNomeFia.setBounds(540, 276, 46, 14);
		getContentPane().add(lblNomeFia);

		JButton btnPesquisarCliente = new JButton("");
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

		btnPesquisarCliente.setBounds(476, 134, 33, 20);
		getContentPane().add(btnPesquisarCliente);

		JButton btSalvar = new JButton("Salvar");
		btSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		btSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int opt1 = JOptionPane.showConfirmDialog(null,
						"Deseja salvar as altera��es? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui

					int num_contCompra = (Integer.parseInt(txtNumero.getText()));

					model.ContratoCompra cc = ContratoCompraDAO
							.buscarContratoCompra(num_contCompra);

					if (cc == null) {

						String dt_aquisicao = txtDataAqui.getText();
						double valor = (Double.parseDouble(txtValorVenda
								.getText())); // convertendo
												// para
												// double
						String tp_pag = (String) cbTipoPag.getSelectedItem(); // combobox
						int n_parcela = (Integer.parseInt(txtNparcelas
								.getText()));
						double comissao_cor = (Double
								.parseDouble(txtValorDaComissao.getText()));
						String cpf_cliente = txtCliente.getText();
						String cpf_prop = txtCpfProp.getText();
						String cpf_fiador = txtCpfFia.getText();
						String cpf_corretor = txtCpfCor.getText();
						int codigo = (Integer.parseInt(txtCodigo.getText())); // im�vel

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

						ContratoCompraDAO.incluirCompra(num_contCompra,
								dt_aquisicao, valor, tp_pag, n_parcela,
								comissao_cor, cpf_cliente, codigo,
								cpf_corretor, cpf_fiador, cpf_prop);

						JOptionPane.showMessageDialog(null,
								"Contrato salvo com Sucesso! ");

					} else {

						String dt_aquisicao = txtDataAqui.getText();
						double valor = (Double.parseDouble(txtValorVenda
								.getText())); // convertendo
												// para
												// double
						String tp_pag = (String) cbTipoPag.getSelectedItem(); // combobox
						int n_parcela = (Integer.parseInt(txtNparcelas
								.getText()));
						double comissao_cor = (Double
								.parseDouble(txtValorDaComissao.getText()));
						String cpf_cliente = txtCliente.getText();
						String cpf_prop = txtCpfProp.getText();
						String cpf_fiador = txtCpfFia.getText();
						String cpf_corretor = txtCpfCor.getText();
						int codigo = (Integer.parseInt(txtCodigo.getText())); // im�vel

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

						ContratoCompraDAO.alterarCompra(num_contCompra,
								dt_aquisicao, valor, tp_pag, n_parcela,
								comissao_cor, cpf_cliente, codigo,
								cpf_corretor, cpf_fiador, cpf_prop);

						JOptionPane.showMessageDialog(null,
								"Contrato editado com Sucesso! ");
					}
				}// fim do switch

			}
		});// fim do Action Listener
		btSalvar.setBounds(89, 323, 110, 41);
		getContentPane().add(btSalvar);

		JButton btExcluir = new JButton("Excluir");
		btExcluir.setIcon(new ImageIcon("img\\delete84 (3).png"));
		btExcluir.setFont(new Font("Calibri", Font.PLAIN, 14));
		btExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int num_contCompra = (Integer.parseInt(txtNumero.getText()));

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

					ContratoCompraDAO.excluirCompra(num_contCompra);
					JOptionPane.showMessageDialog(null,
							"Contrato exclu�do com Sucesso! ");
					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch

			}
		});

		btExcluir.setBounds(89, 423, 110, 41);
		getContentPane().add(btExcluir);

		// magem de fundo - tem que ser por �ltimo para aparecer a imagem

		JButton btnPesqNum = new JButton("");
		btnPesqNum.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesqNum.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int num_contCompra = (Integer.parseInt(txtNumero.getText()));

				model.ContratoCompra contCompralmd = ContratoCompraDAO
						.buscarContratoCompra(num_contCompra);

				if (contCompralmd != null) {

					String dt_aquisicao = contCompralmd.getDt_aquisicao();
					txtDataAqui.setText(dt_aquisicao);

					double valor = contCompralmd.getValor(); // convertendo
					txtValorVenda.setText(String.valueOf(valor));

					

					String tp_pag= contCompralmd.getTp_pag();
					cbTipoPag.setSelectedItem(tp_pag);
					
					
					
					int n_parcela = contCompralmd.getN_parcela();
					txtNparcelas.setText(String.valueOf(n_parcela));

					double comissao_cor = contCompralmd.getValor(); // convertendo
					txtValorDaComissao.setText(String.valueOf(comissao_cor));

					int fk_cliente = contCompralmd.getFk_cliente();

					int fk_imovel = contCompralmd.getFk_imovel();

					int fk_corretor = contCompralmd.getFk_corretor();

					int fk_fiador = contCompralmd.getFk_fiador();

					int fk_prop = contCompralmd.getFk_prop();

					Cliente cliente = ClienteDAO.buscarClienteFk(fk_cliente);

					String cpf_cliente = cliente.getCpf_cliente();
					txtCliente.setText(cpf_cliente); // cpf

					String nome_cliente = cliente.getNome();
					txtNomeCliente.setText(nome_cliente);

					// Imovel
					Imovel imovel = ImovelDAO.buscarImovelFk(fk_imovel);

					int codigo = imovel.getCodigo();
					txtCodigo.setText(String.valueOf(codigo));

					// Fiador
					Fiador fiador = FiadorDAO.buscarFiadorFk(fk_fiador);

					String cpf_fiador = fiador.getCpf_fiador();
					txtCpfFia.setText(cpf_fiador); // cpf

					String nome_fiador = fiador.getNome();
					txtNomeFia.setText(nome_fiador);

					// Prop
					Proprietario proprietario = ProprietarioDAO
							.buscarProprietariofkProp(fk_prop);

					String cpf_prop = proprietario.getCpf_prop();
					txtCpfProp.setText(cpf_prop); // cpf

					String nome_prop = proprietario.getNome();
					txtNomeProp.setText(nome_prop);

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
		btnPesqNum.setBounds(476, 79, 33, 20);
		getContentPane().add(btnPesqNum);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img\\contratoCont.jpg"));
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(73, 79, 165, 160);
		getContentPane().add(label);

		JLabel label_2 = new JLabel("Contrato de Compra");
		label_2.setFont(new Font("Calibri", Font.BOLD, 21));
		label_2.setBounds(51, 256, 192, 20);
		getContentPane().add(label_2);

		setVisible(true);
		setResizable(false);// Fazer que a tela n�o redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro

		JPanel panel = new JPanel();
		panel.setBounds(39, 63, 215, 237);
		getContentPane().add(panel);

		// imagem de fundo
		JLabel lblImagem = new JLabel("imagem");
		lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
		lblImagem.setBounds(0, -4, 1024, 728);
		getContentPane().add(lblImagem);

	}
}

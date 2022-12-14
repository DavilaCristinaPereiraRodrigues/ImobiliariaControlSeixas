package view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Endereco;
import model.DAO.EnderecoDAO;
import model.DAO.ImovelDAO;
import model.DAO.ProprietarioDAO;
import model.Proprietario;

import javax.swing.JPanel;

public class JanelaImovel extends JFrame {

	// Var?aveis globais
	String cep;
	String cpf_prop;

	JTextField txtCodigo;
	JTextField txtValor;
	JTextField txtDataAvaliacao;
	JTextField txtTotal;
	JTextField txtUtil;
	JTextField txtConstruida;
	JTextField txtReferencias;
	JTextField txtLogradouro;
	JTextField txtComplemento;
	JTextField txtCep;
	JTextField txtCidade;
	JTextField txtBairro;
	JTextField txtEstado;
	JTextField txtCpf;
	JTextField txtNome;
	JButton btnPesqImovel;
	
	public static void main(String[] args) {

		try {
			new JanelaImovel();
			// imovel.setVisible(true);
			// imovel.setResizable(false); //bloqueia o redimensionamento da
			// tela

			// imovel.setLocationRelativeTo(null); //Centraliza a janela

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public JanelaImovel() {
		super("Cadastro de Im?vel");
		
		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setTitle("Im?veis");
		// aqui e DISPOSE_ON_CLOSE para sair so da classe sem sai do menu
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 931, 654);
		getContentPane().setLayout(null);

		JLabel lblNegocio = new JLabel("Neg?cio");
		lblNegocio.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNegocio.setBounds(461, 28, 68, 17);
		getContentPane().add(lblNegocio);

		JLabel lblCodigo = new JLabel("C?digo");
		lblCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCodigo.setBounds(287, 28, 85, 17);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCodigo.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(287, 52, 110, 20);
		getContentPane().add(txtCodigo);
		

		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.LEFT);
		txtValor.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtValor.setColumns(10);
		txtValor.setBounds(606, 52, 124, 20);
		getContentPane().add(txtValor);

		JLabel lblPosicao = new JLabel("Posi??o");
		lblPosicao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblPosicao.setBounds(461, 83, 75, 17);
		getContentPane().add(lblPosicao);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblValor.setBounds(609, 28, 46, 17);
		getContentPane().add(lblValor);

		JComboBox cbPosicao = new JComboBox(new Object[] { "Frente", "Fundos" });
		cbPosicao.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbPosicao.setBounds(462, 111, 124, 20);
		getContentPane().add(cbPosicao);

		JComboBox cbtipoPagamento = new JComboBox(new Object[] { "Financiado",
				"? vista" });
		cbtipoPagamento.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbtipoPagamento.setBounds(606, 111, 131, 20);
		getContentPane().add(cbtipoPagamento);

		JLabel lblTipoDePagamento = new JLabel(" Pagamento");
		lblTipoDePagamento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipoDePagamento.setBounds(606, 83, 143, 17);
		getContentPane().add(lblTipoDePagamento);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblStatus.setBounds(750, 28, 46, 17);
		getContentPane().add(lblStatus);

		JComboBox cbStatus = new JComboBox(new Object[] { "Livre", "Alugado",
				"Vendido" });
		cbStatus.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbStatus.setBounds(750, 52, 140, 20);
		getContentPane().add(cbStatus);

		JLabel lblEstrutura = new JLabel("Estrutura");
		lblEstrutura.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstrutura.setBounds(287, 83, 75, 17);
		getContentPane().add(lblEstrutura);

		JLabel lblDataDeAvaliacao = new JLabel("Data de Avalia\u00E7\u00E3o");
		lblDataDeAvaliacao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDataDeAvaliacao.setBounds(759, 83, 151, 17);
		getContentPane().add(lblDataDeAvaliacao);

		txtDataAvaliacao = new JTextField();
		txtDataAvaliacao.setHorizontalAlignment(SwingConstants.LEFT);
		txtDataAvaliacao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtDataAvaliacao.setColumns(10);
		txtDataAvaliacao.setBounds(759, 111, 131, 20);
		getContentPane().add(txtDataAvaliacao);

		JLabel lblQuartos = new JLabel("Quartos");
		lblQuartos.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblQuartos.setBounds(390, 140, 68, 17);
		getContentPane().add(lblQuartos);

		JComboBox cbQuartos = new JComboBox(new Object[] { "1", "2", "3", "4",
				"5" });
		cbQuartos.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbQuartos.setBounds(390, 165, 59, 20);
		getContentPane().add(cbQuartos);

		JLabel lblCmodos = new JLabel("C\u00F4modos");
		lblCmodos.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCmodos.setBounds(287, 140, 75, 17);
		getContentPane().add(lblCmodos);

		JComboBox cbComodos = new JComboBox(new Object[] { "1", "2", "3", "4",
				"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
				"16", "17", "18", "19", "20" });
		cbComodos.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbComodos.setBounds(287, 165, 68, 20);
		getContentPane().add(cbComodos);

		JComboBox cbEstrutura = new JComboBox(new Object[] { "Linear",
				"Duplex", "Triplex" });
		cbEstrutura.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbEstrutura.setBounds(287, 111, 152, 20);
		getContentPane().add(cbEstrutura);

		JComboBox cbNegocio = new JComboBox(new Object[] { "Loca??o", "Venda" });
		cbNegocio.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbNegocio.setBounds(461, 52, 125, 20);
		getContentPane().add(cbNegocio);

		JLabel lblVagasNaGaragem = new JLabel("Garagem");
		lblVagasNaGaragem.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblVagasNaGaragem.setBounds(484, 140, 85, 17);
		getContentPane().add(lblVagasNaGaragem);

		JComboBox cbVagas = new JComboBox(new Object[] { "0", "1", "2", "3",
				"4", "5" });
		cbVagas.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbVagas.setBounds(484, 165, 59, 20);
		getContentPane().add(cbVagas);

		// Descri??o para ser um campo grande criamos o JEditorPane
		JEditorPane dtrpnDescricao = new JEditorPane();
		dtrpnDescricao.setFont(new Font("Calibri", Font.PLAIN, 18));
		dtrpnDescricao.setBounds(697, 359, 175, 179);
		getContentPane().add(dtrpnDescricao);

		JLabel lblArea = new JLabel("\u00C1rea");
		lblArea.setForeground(Color.WHITE);
		lblArea.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblArea.setBounds(466, 327, 68, 32);
		getContentPane().add(lblArea);

		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTotal.setBounds(342, 379, 46, 17);
		getContentPane().add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setHorizontalAlignment(SwingConstants.LEFT);
		txtTotal.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtTotal.setColumns(10);
		txtTotal.setBounds(342, 398, 93, 20);
		getContentPane().add(txtTotal);

		JLabel lblUtil = new JLabel("\u00DAtil");
		lblUtil.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblUtil.setBounds(577, 379, 33, 17);
		getContentPane().add(lblUtil);

		txtUtil = new JTextField();
		txtUtil.setHorizontalAlignment(SwingConstants.LEFT);
		txtUtil.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtUtil.setColumns(10);
		txtUtil.setBounds(462, 398, 93, 20);
		getContentPane().add(txtUtil);

		JLabel lblConstruida = new JLabel("Constru\u00EDda");
		lblConstruida.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblConstruida.setBounds(462, 379, 93, 17);
		getContentPane().add(lblConstruida);

		txtConstruida = new JTextField();
		txtConstruida.setToolTipText("\u00C1rea em m2");
		txtConstruida.setHorizontalAlignment(SwingConstants.LEFT);
		txtConstruida.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtConstruida.setColumns(10);
		txtConstruida.setBounds(577, 398, 90, 20);
		getContentPane().add(txtConstruida);

		JLabel lblReferencia = new JLabel("Refer\u00EAncias");
		lblReferencia.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblReferencia.setBounds(602, 139, 125, 17);
		getContentPane().add(lblReferencia);

		txtReferencias = new JTextField();
		txtReferencias.setHorizontalAlignment(SwingConstants.LEFT);
		txtReferencias.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtReferencias.setColumns(10);
		txtReferencias.setBounds(601, 165, 289, 20);
		getContentPane().add(txtReferencias);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o");
		lblDescricao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblDescricao.setBounds(697, 327, 125, 17);
		getContentPane().add(lblDescricao);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogradouro.setBounds(464, 196, 105, 17);
		getContentPane().add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtLogradouro.setEditable(false);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(460, 225, 277, 20);
		getContentPane().add(txtLogradouro);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblComplemento.setBounds(760, 196, 110, 17);
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(760, 225, 125, 20);
		getContentPane().add(txtComplemento);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(293, 196, 46, 17);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(293, 225, 117, 20);
		getContentPane().add(txtCep);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCidade.setBounds(293, 256, 76, 17);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(293, 281, 204, 20);
		getContentPane().add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBairro.setBounds(519, 256, 46, 17);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(519, 281, 217, 20);
		getContentPane().add(txtBairro);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(765, 256, 84, 17);
		getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(765, 281, 76, 20);
		getContentPane().add(txtEstado);

		JButton btnPesquisarCep = new JButton("");
		btnPesquisarCep.setToolTipText("Buscar Cep");
		btnPesquisarCep.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCep.setBounds(416, 225, 33, 20);
		btnPesquisarCep.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cep = txtCep.getText().toString();
				// JOptionPane.showMessageDialog(null, cep);

				Endereco endereco = EnderecoDAO.buscarEndereco(cep);

				String logradouro = endereco.getLogradouro();
				txtLogradouro.setText(logradouro);

				String bairro = endereco.getBairro();
				txtBairro.setText(bairro);

				String cidade = endereco.getCidade();
				txtCidade.setText(cidade);

				String estado = endereco.getEstado();
				txtEstado.setText(estado);

			}
		});

		getContentPane().add(btnPesquisarCep);

		// BOT?ES

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(75, 324, 110, 41);
		getContentPane().add(btnSalvar);
		btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		// Colocar um texto assim que ele passar em cima debot?o
		btnSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				
				int opt1 = JOptionPane.showConfirmDialog(null,
						"Deseja salvar as altera??es? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui
					
					int codigo = (Integer.parseInt(txtCodigo.getText())); // convertendo
					// para
					// int
					
				model.Imovel	imovel = ImovelDAO.buscarImovelCodigo(codigo);
					//saber se j? possui um codigo cadastrado igual na tabela imovel
					
					if (imovel == null) {
						
						
						String tp_negocio = (String) cbNegocio.getSelectedItem();
						String tp_pos = (String) cbPosicao.getSelectedItem();
						String tp_status = (String) cbStatus.getSelectedItem();
						String tp_est = (String) cbEstrutura.getSelectedItem();
						String tp_pag = (String) cbtipoPagamento.getSelectedItem();
						double valor = (Double.parseDouble(txtValor.getText())); // convertendo
																					// para
																					// double
						String referencias = txtReferencias.getText();
						String descricao = dtrpnDescricao.getText();
						String area_total = txtTotal.getText();
						String area_cons = txtConstruida.getText();
						String area_util = txtUtil.getText();
						String qtd_comodos = (String) cbComodos.getSelectedItem();
						String qtd_quartos = (String) cbQuartos.getSelectedItem();
						String vaga_garagem = (String) cbVagas.getSelectedItem();
						String dt_avaliacao = txtDataAvaliacao.getText();
						String complemento = txtComplemento.getText();
						String cep = txtCep.getText();
						String cpf_prop = txtCpf.getText();

						
						//aqui e para fazer os campos seres limpos apos salva 
						  for (int i=0; i < getContentPane().getComponentCount(); i++) {  
			                    //varre todos os componentes  
			  
			                    Component c = getContentPane().getComponent(i);  
			                   
			                    if (c instanceof JTextField) {  
			                        //apaga os valores  
			                        JTextField field = (JTextField) c;  
			                        field.setText("");  
			                        
			                        
			                    }
			                }  
						  
						  ImovelDAO.incluirImovel(codigo, tp_negocio, tp_pos, tp_status,
									tp_est, tp_pag, valor, referencias, descricao, area_total,
									area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem,
									dt_avaliacao, complemento, cep, cpf_prop);
							

					JOptionPane.showMessageDialog(null,"Im?vel salvo com Sucesso! ");
					
					
					

					} else { //se for igual nao pode salvar
						
						String tp_negocio = (String) cbNegocio.getSelectedItem();
						String tp_pos = (String) cbPosicao.getSelectedItem();
						String tp_status = (String) cbStatus.getSelectedItem();
						String tp_est = (String) cbEstrutura.getSelectedItem();
						String tp_pag = (String) cbtipoPagamento.getSelectedItem();
						double valor = (Double.parseDouble(txtValor.getText())); // convertendo
																					// para
																					// double
						String referencias = txtReferencias.getText();
						String descricao = dtrpnDescricao.getText();
						String area_total = txtTotal.getText();
						String area_cons = txtConstruida.getText();
						String area_util = txtUtil.getText();
						String qtd_comodos = (String) cbComodos.getSelectedItem();
						String qtd_quartos = (String) cbQuartos.getSelectedItem();
						String vaga_garagem = (String) cbVagas.getSelectedItem();
						String dt_avaliacao = txtDataAvaliacao.getText();
						String complemento = txtComplemento.getText();
						String cep = txtCep.getText();
						String cpf_prop = txtCpf.getText();
						
						//aqui e para faze os campos seres limpos apos salva 
						for (int i=0; i < getContentPane().getComponentCount(); i++) {  
		                    //varre todos os componentes  
		  
		                    Component c = getContentPane().getComponent(i);  
		                   
		                    if (c instanceof JTextField) {  
		                        //apaga os valores  
		                        JTextField field = (JTextField) c;  
		                        field.setText("");  
		                        
		                       
		                    }
		                }  
						
						
						 ImovelDAO.alterarImovel(codigo, tp_negocio, tp_pos, tp_status, tp_est, tp_pag, valor, referencias, descricao, area_total, 
								area_cons, area_util, qtd_comodos, qtd_quartos, vaga_garagem, dt_avaliacao, complemento, cep, cpf_prop);
						
						JOptionPane.showMessageDialog(null,"Im?vel editado com Sucesso! ");
						
						
					}
					
					
					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch
			}
		});// fim do Action Listener

		
		getContentPane().add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("img\\delete84 (3).png"));
		// Colocar um texto assim que ele passar em cima debot?o
		btnExcluir.setToolTipText("Excluir Imovel");
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				int codigo = (Integer.parseInt(txtCodigo.getText()));

				int opt1 = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja excluir ? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim exclui o Im?vel
					  for (int i=0; i < getContentPane().getComponentCount(); i++) {  
		                    //varre todos os componentes  
		  
		                    Component c = getContentPane().getComponent(i);  
		                   
		                    if (c instanceof JTextField) {  
		                        //apaga os valores  
		                        JTextField field = (JTextField) c;  
		                        field.setText("");  
		                        
		                    }
					  }

					ImovelDAO.excluirImovel(codigo);

					JOptionPane.showMessageDialog(null,
							"Im?vel exclu?do com Sucesso! ");
					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch

			}
		});

		btnExcluir.setBounds(75, 415, 110, 41);
		getContentPane().add(btnExcluir);

		JLabel lblProp = new JLabel("Propriet\u00E1rio");
		lblProp.setForeground(Color.WHITE);
		lblProp.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblProp.setBounds(438, 440, 110, 17);
		getContentPane().add(lblProp);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(344, 466, 46, 17);
		getContentPane().add(lblCpf);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(342, 516, 46, 17);
		getContentPane().add(lblNome);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpf.setToolTipText("Cpf do Propriet?rio");
		txtCpf.setBounds(344, 487, 151, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNome.setToolTipText("Nome do Propriet?rio");
		txtNome.setEditable(false);
		txtNome.setBounds(342, 543, 289, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JButton btnPesquisarProp = new JButton("");
		btnPesquisarProp.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarProp.setToolTipText("Buscar Cpf do Propriet?rio");
		btnPesquisarProp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_prop = txtCpf.getText();

				Proprietario proprietario = ProprietarioDAO
						.buscarProprietarioCPF_PROP(cpf_prop); // N?O ESQUECER
																// DE DAR UM
																// IMPORT NO
																// Im?vel DO
																// MODEL

				// Verificar se o Im?vel existe no Banco de Dados e vem com
				// os dados completo do Im?vel id, nome, telefone
				if (proprietario == null) {

					JOptionPane.showMessageDialog(null,
							"Im?vel n?o cadastrado");

				} else {
					/*
					 * JOptionPane.showMessageDialog(null,
					 * "Dados do Im?vel \n " + Im?vel);//est? pegando //o
					 * m?todo toString no model Im?vel e jogando neste
					 * showMessage
					 */

					int opt2 = JOptionPane.showConfirmDialog(null,
							"Dados do propriet?rio\n " + proprietario,
							"Propriet?rio", JOptionPane.OK_CANCEL_OPTION); // o

					switch (opt2) {
					case JOptionPane.CANCEL_OPTION:
						JOptionPane.showMessageDialog(null,
								"Voc? clicou em \"Cancelar\"");
						break;

					case JOptionPane.OK_OPTION:
						JOptionPane.showMessageDialog(null,
								"Dados inseridos com Sucesso");
						// Se clicar em OK joga o os dados do propriet?rio na
						// tela salvando-o

						String nome = proprietario.getNome();

						txtNome.setText(nome);
						break;

					default:
						JOptionPane.showMessageDialog(null,
								"Voc? fechou a janela");
						break;
					}// fim do switch

				}
			}
		});

		btnPesquisarProp.setBounds(501, 486, 33, 20);
		getContentPane().add(btnPesquisarProp);

		btnPesqImovel = new JButton("");
		btnPesqImovel.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesqImovel.setToolTipText("Buscar Cpf do Propriet\u00E1rio");
		btnPesqImovel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				int codigo = (Integer.parseInt(txtCodigo.getText())); // convertendo
				// para
				// int

				model.Imovel imovelmd = ImovelDAO.buscarImovelCodigo(codigo);
				//System.out.println(imovel);

				if (imovelmd != null) {

					String tp_negocio = imovelmd.getTp_negocio();//pega do imovelmd
					cbNegocio.setSelectedItem(tp_negocio ); //empura pra tela
					
					String tp_pos = imovelmd.getTp_pos();
					cbPosicao.setSelectedItem(tp_pos);

					String tp_status = imovelmd.getTp_status();
					cbStatus.setSelectedItem(tp_status);

					String tp_est = imovelmd.getTp_est();
					cbEstrutura.setSelectedItem(tp_est);

					String tp_pag = imovelmd.getTp_pag();
					cbtipoPagamento.setSelectedItem(tp_pag);
					
					String qtd_comodos = imovelmd.getQtd_comodos();
					cbComodos.setSelectedItem(qtd_comodos);
					
					String qtd_quartos =  imovelmd.getQtd_quartos();
					cbQuartos.setSelectedItem(qtd_quartos);
					
					String vaga_garagem = imovelmd.getVaga_garagem();
					cbVagas.setSelectedItem(vaga_garagem);
					
					
					//double valor=Double.parseDouble(txtValor.getText()); 
					//txtValor.setText(valor + ""); //gabiara
					
					double valor = imovelmd.getValor(); // convertendo
					txtValor.setText(String.valueOf(valor)); 
					
					
					
				
					String referencias = imovelmd.getReferencias();
					txtReferencias.setText(referencias);
					
					String descricao = imovelmd.getDescricao();
					 dtrpnDescricao.setText(descricao);
					
					String area_total = imovelmd.getArea_total();
					txtTotal.setText(area_total);
					
					String area_cons = imovelmd.getArea_cons();
					txtConstruida.setText(area_cons);
					
					String area_util = imovelmd.getArea_util();
					txtUtil.setText(area_util);
					
					
					String dt_avaliacao = imovelmd.getDt_avaliacao();
					
					//convers?o para padr?o de data brasileiro dd/mm/aaaa
					
					
					String diaString;
					diaString = dt_avaliacao.substring(8);
					String mesString;
					mesString = dt_avaliacao.substring(5, 7);
					String anoString;
					anoString = dt_avaliacao.substring(0, 4);
					int dia, mes, ano;
					dia = Integer.parseInt(diaString);
					mes = Integer.parseInt(mesString) - 1;
					ano = Integer.parseInt(anoString);
					
					DateFormat df5 = DateFormat.getDateInstance(DateFormat.MEDIUM);
					Calendar data5 = new GregorianCalendar();
					data5.set(ano, mes, dia);
					//System.out.println("Data 5 (MEDIUM): "+ df5.format(data5.getTime()));
					
					
					txtDataAvaliacao.setText(df5.format(data5.getTime()));
					
					
					
					String complemento = imovelmd.getComplemento();
					txtComplemento.setText(complemento);
					
					
				    //Endere?o
					int idCep = imovelmd.getId_cep();
					//Prop
					int fk_prop = imovelmd.getFk_prop();
					
					Endereco endereco = EnderecoDAO.buscarEndereco(idCep);

					String cep = endereco.getCep();
					txtCep.setText(cep);

					String logradouro = endereco.getLogradouro();
					txtLogradouro.setText(logradouro);

					String bairro = endereco.getBairro();
					txtBairro.setText(bairro);

					String cidade = endereco.getCidade();
					txtCidade.setText(cidade);

					String estado = endereco.getEstado();
					txtEstado.setText(estado);
					
					//Propriet?rio
					
										
					Proprietario proprietario = ProprietarioDAO.buscarProprietariofkProp(fk_prop);
					
					String nome = proprietario.getNome();
					txtNome.setText(nome);
					
					String cpf_prop = proprietario.getCpf_prop();
					txtCpf.setText(cpf_prop);
					
					

				} else { // se n?o estiver cadastrado um cpf no Im?vel amostra
							// o JoptionPANE

					JOptionPane.showMessageDialog(null, "C?digo n?o cadastrado",
							"Erro", JOptionPane.ERROR_MESSAGE);

				}

			}// fim do buscarIm?vel

		});
		btnPesqImovel.setBounds(406, 52, 33, 20);
		getContentPane().add(btnPesqImovel);
		
		

		
		JLabel lblCadastroDeImveis = new JLabel("Cadastro de Im\u00F3veis");
		lblCadastroDeImveis.setFont(new Font("Calibri", Font.BOLD, 21));
		lblCadastroDeImveis.setBounds(60, 245, 182, 17);
		getContentPane().add(lblCadastroDeImveis);

		JPanel panel = new JPanel();
		panel.setBounds(25, 40, 231, 237);
		getContentPane().add(panel);
		
		JLabel ImagemImovel = new JLabel("");
		panel.add(ImagemImovel);
		ImagemImovel.setIcon(new ImageIcon(""
				+ "img\\Imovel200.png"));
		ImagemImovel.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		//imagem de fundo
				JLabel lblImagem = new JLabel("imagem");
				lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
				lblImagem.setBounds(0, 0, 1024, 728);
				getContentPane().add(lblImagem);

		setVisible(true);
		setResizable(false);// Fazer que a tela n?o redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro
	}
	
	public void setar(int codigo){
		txtCodigo.setText(Integer.toString(codigo));
		btnPesqImovel.doClick();
	}
}


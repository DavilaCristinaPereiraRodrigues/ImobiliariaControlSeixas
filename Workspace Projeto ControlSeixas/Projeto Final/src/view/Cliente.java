package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.Teclado;
import model.Endereco;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.ImovelDAO;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;
import javax.swing.border.EmptyBorder;

public class Cliente extends JFrame {

	String cep; // var�avel global
	String cliente;
	int idCep;
	
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtLogradouro;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEstado;
 
	public static void main(String[] args) {

		try {
			new Cliente();
			// cliente.setVisible(true);
			// Fazer que a tela n�o redimensione
			// cliente.setResizable(false);
			// Fazer que a tela abra no centro
			// cliente.setLocationRelativeTo(null);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
 
	public Cliente() {
		super("Cadastro de Cliente");

		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setTitle("Cliente");
		// aqui e DISPOSE_ON_CLOSE para sair so da classe sem sai do menu
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 800, 600);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(471, 84, 46, 17);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(471, 108, 252, 20);
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(263, 154, 46, 14);
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblTipo);

		JComboBox cbTipo = new JComboBox(new Object[] { "Locat�rio",
				"Comprador" });// colocando texto no ComboBox);
		cbTipo.setBounds(263, 179, 190, 20);
		cbTipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(cbTipo);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setBounds(471, 274, 105, 18);
		lblLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(471, 303, 252, 20);
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(txtLogradouro);
		txtLogradouro.setColumns(10);
		// Para n�o editar o logradouro, que vir� do Banco
		txtLogradouro.setEditable(false);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(263, 340, 110, 14);
		lblComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(263, 365, 190, 20);
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setBounds(263, 276, 46, 14);
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setBounds(263, 301, 136, 20);
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(471, 340, 76, 14);
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCidade.setColumns(10);
		txtCidade.setBounds(471, 365, 204, 20);
		getContentPane().add(txtCidade);
		// Para n�o editar o Cidade, que vir� do Banco
		txtCidade.setEditable(false);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(263, 411, 46, 14);
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtBairro.setColumns(10);
		txtBairro.setBounds(263, 436, 187, 20);
		getContentPane().add(txtBairro);
		// Para n�o editar o Bairro, que vir� do Banco
		txtBairro.setEditable(false);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(471, 411, 84, 14);
		getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEstado.setColumns(10);
		txtEstado.setBounds(471, 436, 76, 20);
		getContentPane().add(txtEstado);
		// Para n�o editar o Estado, que vir� do Banco
		txtEstado.setEditable(false);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(263, 85, 57, 14);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpf.setBounds(263, 108, 147, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstadoCivil.setBounds(467, 154, 93, 14);
		getContentPane().add(lblEstadoCivil);

		String[] vetor = { "Solteiro", "Casado", "Divorciado", "Vi�vo",
				"Separado", "Companheiro" };// colocando
		JComboBox cbEstadoCivil = new JComboBox(vetor);
		cbEstadoCivil.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbEstadoCivil.setBounds(471, 179, 187, 20);
		getContentPane().add(cbEstadoCivil);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEmail.setBounds(263, 218, 46, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEmail.setBounds(263, 243, 190, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTelefone.setBounds(471, 218, 74, 14);
		getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtTelefone.setBounds(471, 243, 187, 20);
		getContentPane().add(txtTelefone);
		txtTelefone.setColumns(10);

		 
		
		
		// Pesquisar Cliente
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_cliente = txtCpf.getText();
				
	
				model.Cliente cliente = ClienteDAO
						.buscarClienteCpf(cpf_cliente);
		

				if (cliente!= null){
				
					String nome = cliente.getNome();
					txtNome.setText(nome);
					String telefone = cliente.getTelefone();
					txtTelefone.setText(telefone);
					String email = cliente.getEmail();
					txtEmail.setText(email);
					
					String estado_civil = cliente.getEstado_civil();
					cbEstadoCivil.setSelectedItem(estado_civil);
					
					String tipo = cliente.getTipo();
					cbTipo.setSelectedItem(tipo);

					String complemento = cliente.getComplemento();
					txtComplemento.setText(complemento);

					int idCep = cliente.getId_cep();
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

	} 	else{ //se n�o estiver cadastrado um cpf no cliente amostra o JoptionPANE
			
					JOptionPane.showMessageDialog(null, "Cpf n�o cadastrado",
							"Erro", JOptionPane.ERROR_MESSAGE);

				}


			}// fim do buscarCliente

		});
		btnPesquisar.setBounds(420, 108, 33, 20);
		getContentPane().add(btnPesquisar);
		

		JButton btnPesquisarCep = new JButton("");
		btnPesquisarCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		btnPesquisarCep.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCep.setBounds(420, 301, 33, 20);
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

		JLabel cadastro = new JLabel("Cadastro de Cliente");
		cadastro.setForeground(new Color(0, 0, 0));
		cadastro.setFont(new Font("Calibri", Font.BOLD, 24));
		cadastro.setBounds(20, 243, 240, 50);
		getContentPane().add(cadastro);
		
				// Bot�o Salvar
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.setBounds(75, 324, 110, 41);
				getContentPane().add(btnSalvar);
				btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
				btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
				

				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.setBounds(75, 415, 110, 41);
				getContentPane().add(btnExcluir);
				btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnExcluir.setIcon(new ImageIcon("img\\delete84 (2).png"));
				
				JPanel panel = new JPanel();
				panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				panel.setForeground(new Color(0, 0, 0));
				panel.setBounds(10, 42, 231, 237);
				getContentPane().add(panel);
				
				JLabel label_1 = new JLabel("");
				panel.add(label_1);
				label_1.setIcon(new ImageIcon("img\\cliente3.jpg"));
				label_1.setFont(new Font("Calibri", Font.PLAIN, 18));
				btnExcluir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {

						String cpf_cliente = txtCpf.getText();

						int opt1 = JOptionPane.showConfirmDialog(null,
								"Tem certeza que deseja excluir?  ");

						switch (opt1) {

						case JOptionPane.YES_OPTION:
							// Se clicar em Sim exclui o cliente
							  for (int i=0; i < getContentPane().getComponentCount(); i++) {  
				                    //varre todos os componentes  
				  
				                    Component c = getContentPane().getComponent(i);  
				                   
				                    if (c instanceof JTextField) {  
				                        //apaga os valores  
				                        JTextField field = (JTextField) c;  
				                        field.setText("");  
				                        
				                       
				                        
				                    }
				                }  
							
							
							ClienteDAO.excluirCliente(cpf_cliente);

							JOptionPane.showMessageDialog(null,
									"Cliente exclu�do com Sucesso! ");
							break;

						case JOptionPane.NO_OPTION:

							break;

						}// fim do switch
					}
				});
				btnSalvar.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						
						int opt1 = JOptionPane.showConfirmDialog(null,
								"Deseja salvar as altera��es? ");

						switch (opt1) {

						case JOptionPane.YES_OPTION:
							// Se clicar em Sim inclui
							
							String cpf_cliente = txtCpf.getText();
							
							model.Cliente cliente = ClienteDAO.buscarClienteCpf(cpf_cliente);
							
							//saber se j� possui um cpf cadastrado igual na tabela cliente
							//VER COM O PROFESSOR
							if (cliente == null) {
								String nome = txtNome.getText();
								String telefone = txtTelefone.getText();
								String email = txtEmail.getText();
								String complemento = txtComplemento.getText();
								String estado_civil = (String) cbEstadoCivil.getSelectedItem();
								String tipo = (String) cbTipo.getSelectedItem();
								String cep = txtCep.getText().toString();
								
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
								  
									ClienteDAO.incluirCliente(cpf_cliente, nome, telefone,
									email, estado_civil, tipo, complemento, cep);
									

							JOptionPane.showMessageDialog(null,"Cliente salvo com Sucesso! ");
							
							
							

							} else { //se for igual nao pode salvar
								
								String nome = txtNome.getText();
								String telefone = txtTelefone.getText();
								String email = txtEmail.getText();
								String complemento = txtComplemento.getText();
								String estado_civil = (String) cbEstadoCivil.getSelectedItem();
								String tipo = (String) cbTipo.getSelectedItem();
								String cep = txtCep.getText().toString();
								
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
								
								
								ClienteDAO.alterarCliente(cpf_cliente, nome, telefone, email, estado_civil, tipo, complemento, cep);
								
								JOptionPane.showMessageDialog(null,"Cliente editado com Sucesso! ");
								
								
							}
							
							
							break;

						case JOptionPane.NO_OPTION:

							break;

						}// fim do switch
					}
				});
		
				// imagem de fundo
				JLabel lblImagem = new JLabel("imagem");
				lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
				lblImagem.setBounds(0, -4, 1024, 728);
				getContentPane().add(lblImagem);

				
		setVisible(true);
		setResizable(false);// Fazer que a tela n�o redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro

	}
}

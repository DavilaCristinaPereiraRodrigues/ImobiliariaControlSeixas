package view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Endereco;
import model.DAO.ClienteDAO;
import model.DAO.CorretorDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FiadorDAO;

import javax.swing.JPanel;

public class Corretor extends JFrame {

	
	String cep; //var�avel global
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtCreci;
	private JTextField txtComplemento;
	private JTextField txtEmail;
	private JTextField txtLogin;
	private JPasswordField Senha;
	private JTextField txtLogradouro;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEstado;

	public static void main(String[] args) {
		try {
			new Corretor();
			// corretor.setVisible(true);
			// Fazer que a tela n�o redimensione
			// corretor.setResizable(false);
			// corretor.setLocationRelativeTo(null);//Centraliza a janela na
			// tela

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public Corretor() {
		super(" Cadastro de Corretor");

		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setTitle("Corretor");
		// aqui e DISPOSE_ON_CLOSE para sair so da classe sem sai do menu
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 800, 600);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(504, 38, 46, 17);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setHorizontalAlignment(SwingConstants.LEFT);
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(502, 66, 232, 20);
		getContentPane().add(txtNome);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTelefone.setBounds(503, 156, 72, 17);
		getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setHorizontalAlignment(SwingConstants.LEFT);
		txtTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(503, 184, 171, 20);
		getContentPane().add(txtTelefone);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogin.setBounds(331, 453, 53, 17);
		getContentPane().add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Calibri", Font.PLAIN, 18));
		// txtLogin.setDropMode(DropMode.ON);
		txtLogin.setBounds(380, 451, 190, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblSenha.setBounds(331, 513, 93, 17);
		getContentPane().add(lblSenha);

		// Senha ***
		Senha = new JPasswordField();
		Senha.setFont(new Font("Calibri", Font.PLAIN, 18));
		Senha.setBounds(380, 511, 190, 20);
		getContentPane().add(Senha);

		JLabel lblCriarLogin = new JLabel("Cria\u00E7\u00E3o de Login");
		lblCriarLogin.setForeground(new Color(0, 0, 0));
		lblCriarLogin.setFont(new Font("Calibri", Font.BOLD, 22));
		lblCriarLogin.setBounds(378, 409, 162, 33);
		getContentPane().add(lblCriarLogin);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(291, 38, 39, 17);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setHorizontalAlignment(SwingConstants.LEFT);
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpf.setColumns(10);
		txtCpf.setBounds(291, 66, 150, 20);
		getContentPane().add(txtCpf);

		JLabel lblCreci = new JLabel("CRECI");
		lblCreci.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCreci.setBounds(291, 97, 46, 17);
		getContentPane().add(lblCreci);

		txtCreci = new JTextField();
		txtCreci.setHorizontalAlignment(SwingConstants.LEFT);
		txtCreci.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCreci.setColumns(10);
		txtCreci.setBounds(291, 122, 134, 20);
		getContentPane().add(txtCreci);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEmail.setBounds(293, 156, 46, 17);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(291, 184, 198, 20);
		getContentPane().add(txtEmail);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogradouro.setBounds(503, 212, 105, 17);
		getContentPane().add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtLogradouro.setEditable(false);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(502, 241, 252, 20);
		getContentPane().add(txtLogradouro);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblComplemento.setBounds(291, 272, 110, 17);
		getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(291, 299, 150, 20);
		getContentPane().add(txtComplemento);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(291, 214, 46, 17);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(291, 241, 134, 20);
		getContentPane().add(txtCep);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCidade.setBounds(504, 272, 76, 17);
		getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(503, 299, 204, 20);
		getContentPane().add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBairro.setBounds(291, 330, 46, 17);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(291, 355, 187, 20);
		getContentPane().add(txtBairro);
		
		JLabel lblEsatdo = new JLabel("Estado");
		lblEsatdo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEsatdo.setBounds(503, 330, 84, 17);
		getContentPane().add(lblEsatdo);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(503, 355, 76, 20);
		getContentPane().add(txtEstado);

		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTipo.setBounds(504, 97, 46, 17);
		getContentPane().add(lblTipo);

		// Tipo do Corretor
		JComboBox cbTipo = new JComboBox(new Object[] { "Administrador",
				"Comum" });
		cbTipo.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbTipo.setBounds(505, 122, 162, 20);
		getContentPane().add(cbTipo);


		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
					int opt1 = JOptionPane.showConfirmDialog(null,
							"Deseja salvar as altera��es? ");

					switch (opt1) {

					case JOptionPane.YES_OPTION:
						// Se clicar em Sim inclui
						
						String cpf_corretor = txtCpf.getText();
						
						model.Corretor corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor);
						
						//saber se j� possui um cpf cadastrado igual na tabela corretor
						
						if (corretor == null) {
							String nome = txtNome.getText();
							String telefone = txtTelefone.getText();
							String creci = txtCreci.getText();
							String complemento = txtComplemento.getText();
							String email = txtEmail.getText();
							String login = txtLogin.getText();
							String senha = Senha.getText();
							String tp_cor = (String)cbTipo.getSelectedItem();
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
							  
							  corretor = CorretorDAO.incluirCorretor(creci, cpf_corretor, nome,
										telefone, email, login, senha, tp_cor, complemento, cep);
								

						JOptionPane.showMessageDialog(null,"Corretor salvo com Sucesso! ");
						
						
						
						
						

						} else { //se for igual nao pode salvar
							
							String nome = txtNome.getText();
							String telefone = txtTelefone.getText();
							String creci = txtCreci.getText();
							String complemento = txtComplemento.getText();
							String email = txtEmail.getText();
							String login = txtLogin.getText();
							String senha = Senha.getText();
							String tp_cor = (String)cbTipo.getSelectedItem();
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
							
							
							CorretorDAO.alterarCorretor(creci, cpf_corretor, nome, 
									telefone, email, login, senha, tp_cor, complemento, cep);
							
							JOptionPane.showMessageDialog(null,"Corretor editado com Sucesso! ");
							
							
						}
						
						
						break;

					case JOptionPane.NO_OPTION:

						break;

					}// fim do switch
			
			
	
			}
		}
		);// fim do Action Listener

		btnSalvar.setBounds(75, 324, 110, 41);
		getContentPane().add(btnSalvar);

	
		
		
		
		JButton btnPesquisarCep = new JButton("");
		btnPesquisarCep.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCep.setBounds(435, 241, 33, 20);
        btnPesquisarCep.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String cep = txtCep.getText().toString();
				//JOptionPane.showMessageDialog(null, cep);
				
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
		
		//pesquisar o corretor
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_corretor= txtCpf.getText();
				
	model.Corretor corretor = CorretorDAO.buscarCorretorCpf(cpf_corretor)	;		

				if (corretor!= null){
				
					String creci = corretor.getCreci();
					txtCreci.setText(creci);
					String nome = corretor.getNome();
					txtNome.setText(nome);
					String telefone = corretor.getTelefone();
					txtTelefone.setText(telefone);
					String email = corretor.getEmail();
					txtEmail.setText(email);
					
					String tp_cor = corretor.getTp_cor();
					cbTipo.setSelectedItem(tp_cor);
					

					String complemento = corretor.getComplemento();
					txtComplemento.setText(complemento);

					int idCep = corretor.getId_cep();
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


			}// fim do buscarCorretor

		});
		btnPesquisar.setBounds(451, 66, 33, 20);
		getContentPane().add(btnPesquisar);
		
		
		
				
				
				JButton btnExcluir = new JButton("Excluir");
				btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 14));
				btnExcluir.setIcon(new ImageIcon("img\\delete84 (2).png"));
				btnExcluir.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String cpf_corretor = txtCpf.getText();

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
							
							
							CorretorDAO.excluirCorretor(cpf_corretor);

							JOptionPane.showMessageDialog(null,
									"Corretor exclu�do com Sucesso! ");
							break;

						case JOptionPane.NO_OPTION:

							break;

						}// fim do switch
					}
				});
				btnExcluir.setBounds(75, 415, 110, 41);
				getContentPane().add(btnExcluir);
				
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon("img\\corretor2.png"));
				label.setFont(new Font("Calibri", Font.PLAIN, 18));
				label.setBounds(32, 38, 198, 200);
				getContentPane().add(label);
				
				JLabel lblCdastroDeCorretor = new JLabel("Cadastro de Corretor");
				lblCdastroDeCorretor.setForeground(Color.BLACK);
				lblCdastroDeCorretor.setFont(new Font("Calibri", Font.BOLD, 22));
				lblCdastroDeCorretor.setBounds(32, 248, 196, 33);
				getContentPane().add(lblCdastroDeCorretor);
				
				JPanel panel = new JPanel();
				panel.setBounds(10, 23, 240, 255);
				getContentPane().add(panel);
		
				
				//imagem de fundo
				JLabel lblImagem = new JLabel("");
				lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
				lblImagem.setBounds(0, 0, 1024, 728);
				getContentPane().add(lblImagem);
				
		setVisible(true);
		setResizable(false);// Fazer que a tela n�o redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro
		
		
		
	}
}

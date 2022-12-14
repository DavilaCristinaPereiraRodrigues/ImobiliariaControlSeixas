package view;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Endereco;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FiadorDAO;
import model.DAO.ProprietarioDAO;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Proprietario extends JFrame {

	String cep;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtCep;
	private JTextField txtComplemento;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtProfissao;
	private JTextField txtLogradouro;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEstado;

	public static void main(String[] args) {

		try {
			new Proprietario();
			//frame.setVisible(true);
			//frame.setResizable(false); // n?o redimensionar
			//frame.setLocationRelativeTo(null); // abrir ao meio
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public Proprietario() {
		
		super("Cadastro de Proprietario");
		getContentPane().setForeground(new Color(0, 0, 0));
		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));

		setTitle("Propriet?rio");
		// aqui e DISPOSE_ON_CLOSE para sair so da classe sem sai do menu
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 0, 800, 600);
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(473, 88, 46, 17);
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setBounds(473, 116, 258, 20);
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		getContentPane().add(txtNome);
		txtNome.setColumns(10);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(284, 89, 46, 14);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpf.setColumns(10);
		txtCpf.setBounds(284, 116, 116, 20);
		getContentPane().add(txtCpf);

		JLabel lblProfissao = new JLabel("Profissao");
		lblProfissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblProfissao.setBounds(284, 200, 90, 14);
		getContentPane().add(lblProfissao);

		txtProfissao = new JTextField();
		txtProfissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(283, 224, 166, 20);
		getContentPane().add(txtProfissao);

		

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTelefone.setBounds(284, 144, 74, 14);
		getContentPane().add(lblTelefone);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(284, 169, 166, 20);
		getContentPane().add(txtTelefone);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEmail.setBounds(473, 144, 62, 14);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(473, 169, 258, 20);
		getContentPane().add(txtEmail);

		JLabel lblEstadoCivil = new JLabel("Estado Civil");
		lblEstadoCivil.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstadoCivil.setBounds(473, 200, 116, 14);
		getContentPane().add(lblEstadoCivil);

		JComboBox cbEstadoCivil = new JComboBox(new Object[] { "Solteiro",
	   "Casado", "Divorciado", "Vi?vo",
	   "Separado", "Companheiro" });//colocar texto no comboBox
		cbEstadoCivil.setFont(new Font("Calibri", Font.PLAIN, 18));
		cbEstadoCivil.setBounds(472, 224, 146, 20);
		getContentPane().add(cbEstadoCivil);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogradouro.setBounds(472, 255, 105, 18);
		getContentPane().add(lblLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtLogradouro.setEditable(false);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(472, 284, 264, 20);
		getContentPane().add(txtLogradouro);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblComplemento.setBounds(283, 323, 110, 14);
		getContentPane().add(lblComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(283, 347, 166, 20);
		getContentPane().add(txtComplemento);
		
		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(283, 257, 46, 14);
		getContentPane().add(lblCep);
		
		txtCep = new JTextField();
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(283, 284, 123, 20);
		getContentPane().add(txtCep);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCidade.setBounds(473, 322, 76, 14);
		getContentPane().add(lblCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(472, 347, 204, 20);
		getContentPane().add(txtCidade);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBairro.setBounds(284, 385, 46, 14);
		getContentPane().add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(284, 410, 166, 20);
		getContentPane().add(txtBairro);
		
		JLabel lblEsatdo = new JLabel("Estado");
		lblEsatdo.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEsatdo.setBounds(463, 383, 84, 14);
		getContentPane().add(lblEsatdo);
		
		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(463, 410, 76, 20);
		getContentPane().add(txtEstado);
		
		JButton btnPesquisarCep = new JButton("");
		btnPesquisarCep.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisarCep.setBounds(416, 284, 33, 20);
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
		
		
		JButton btnSalvar = new JButton(" Salvar");
		btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		// Colocar um texto assim que ele passar em cima debot?o
		btnSalvar.setToolTipText("Salvar o Propriet?rio"); 
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnSalvar.setBounds(75, 311, 110, 41);
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

											
				
				int opt1 = JOptionPane.showConfirmDialog(null,
						"Deseja salvar as altera??es? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui
					String cpf_prop = txtCpf.getText();
									
					model.Proprietario proprietario = ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop);
					
					//saber se j? possui um cpf cadastrado igual na tabela cliente
					//VER COM O PROFESSOR
					if (proprietario == null) {
						String nome = txtNome.getText();
						String telefone = txtTelefone.getText();
						String email = txtEmail.getText();
						String complemento = txtComplemento.getText();
						String estado_civil = (String)cbEstadoCivil.getSelectedItem();
						String profissao =txtProfissao.getText();
						String cep = txtCep.getText().toString();
						
						//aqui e para fazer os campos seres limpos apos salva 
						  for (int i=0; i < getContentPane().getComponentCount(); i++) {  
			                    //varre todos os componentes  
			  
			                    Component c = getContentPane().getComponent(i);  
			                   
			                    if (c instanceof JTextField) {  
			                        //apaga os valores  
			                        JTextField field = (JTextField) c;  
			                        field.setText("");  
			                        
			                        
			                    }//FIM DO IF
			                }//FIM DO FOR  
						 ProprietarioDAO.incluirProprietario(cpf_prop, nome, telefone, email, 
								 estado_civil, profissao, complemento, cep);
							

					JOptionPane.showMessageDialog(null,"Propriet?rio salvo com Sucesso! ");
					
					
					

					} else { //se for igual nao pode salvar
						
						String nome = txtNome.getText();
						String telefone = txtTelefone.getText();
						String email = txtEmail.getText();
						String complemento = txtComplemento.getText();
						String estado_civil = (String)cbEstadoCivil.getSelectedItem();
						String profissao =txtProfissao.getText();
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
						
						
						ProprietarioDAO.alterarProprietario(cpf_prop, nome, telefone, email,
								estado_civil, profissao, complemento, cep);
						
						JOptionPane.showMessageDialog(null,"Propriet?rio editado com Sucesso! ");
						
						
					}
					
					
					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch				
				
				
			}
		});// fim do Action Listener

		
		
		getContentPane().add(btnSalvar);

	
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("img\\delete84 (2).png"));
		// Colocar um texto assim que ele passar em cima debot?o
		btnExcluir.setToolTipText("Excluir o Propriet?rio"); 
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_prop = txtCpf.getText();
					
				int opt1 = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja excluir? ");
				
				switch (opt1) {
				
				case JOptionPane.YES_OPTION:
					//Se clicar em Sim inclui o imovel
					
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
					ProprietarioDAO.excluirProprietario(cpf_prop);
					
					JOptionPane.showMessageDialog(null, "Propriet?rio exclu?do com Sucesso! ");
					break;

				case JOptionPane.NO_OPTION:
				
					break;

				}// fim do switch
	
			}
		});
		
		btnExcluir.setBounds(75, 415, 110, 41);
		getContentPane().add(btnExcluir);

	
		
		
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_prop = txtCpf.getText();
				
	
				model.Proprietario proprietario = ProprietarioDAO.buscarProprietarioCPF_PROP(cpf_prop);

				if (proprietario!= null){
									
					
					String nome = proprietario.getNome();
					txtNome.setText(nome);
					String telefone = proprietario.getTelefone();
					txtTelefone.setText(telefone);
					String email = proprietario.getEmail();
					txtEmail.setText(email);
					
					String estado_civil = proprietario.getEstado_civil();
					cbEstadoCivil.setSelectedItem(estado_civil);
					
					String profissao = proprietario.getProfissao();
					txtProfissao.setText(profissao);
					String complemento = proprietario.getComplemento();
					txtComplemento.setText(complemento);

					int idCep = proprietario.getId_cep();
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

	} 	else{ //se n?o estiver cadastrado um cpf no cliente amostra o JoptionPANE
			
					JOptionPane.showMessageDialog(null, "Cpf n?o cadastrado",
							"Erro", JOptionPane.ERROR_MESSAGE);

				}


			}// fim do buscarCliente

		});
		btnPesquisar.setBounds(410, 116, 33, 20);
		getContentPane().add(btnPesquisar);
		
		JLabel cadastro = new JLabel("Cadastro de Propriet\u00E1rio");
		cadastro.setBounds(20, 233, 210, 27);
		getContentPane().add(cadastro);
		cadastro.setBackground(new Color(0, 0, 0));
		cadastro.setForeground(new Color(0, 0, 0));
		cadastro.setFont(new Font("Calibri", Font.BOLD, 21));
		
		
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(240, 255, 255));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 46, 231, 222);
		getContentPane().add(panel);
		
		JLabel imagem = new JLabel("");
		panel.add(imagem);
		imagem.setIcon(new ImageIcon("img\\proprietario200.png"));
		imagem.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		
		
		
		
		//imagem de fundo
				JLabel lblImagem = new JLabel("imagem");
				lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
				lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
				lblImagem.setBounds(0, 0, 1024, 728);
				getContentPane().add(lblImagem);
	
		setVisible(true); 
		setResizable(false);//Fazer que a tela n?o redimensione
		setLocationRelativeTo(null);//Fazer que a tela abra no centro
	}
}

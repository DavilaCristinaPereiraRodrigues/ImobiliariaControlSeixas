package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import model.Endereco;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.FiadorDAO;
import model.DAO.ImovelDAO;
import model.DAO.ProprietarioDAO;

import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class Fiador extends JFrame {
	String cep;
	private JTextField txtNome;
	private JTextField txtCep;
	private JTextField txtProfissao;
	private JTextField txtCpf;
	private JTextField txtComplemento;
	private JTextField txtEmail;
	private JTextField txtLogradouro;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtEstado;
	private JTextField txtTelefone;
	private final JPanel panel = new JPanel();

	public static void main(String[] args) {

		try {
			new Fiador();
			// frame.setResizable(false);
			// frame.setVisible(true);
			// frame.setLocationRelativeTo(null);//Centraliza a janela na tela
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Fiador() {
		super("Cadastro de Fiador");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
		getContentPane().setLayout(null);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNome.setBounds(497, 72, 46, 17);
		getContentPane().add(lblNome);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtNome.setColumns(10);
		txtNome.setBounds(497, 100, 243, 20);
		getContentPane().add(txtNome);

		JLabel lblProfissao = new JLabel("Profiss\u00E3o:");
		lblProfissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblProfissao.setBounds(277, 206, 80, 17);
		getContentPane().add(lblProfissao);

		txtProfissao = new JTextField();
		txtProfissao.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtProfissao.setColumns(10);
		txtProfissao.setBounds(277, 234, 193, 20);
		getContentPane().add(txtProfissao);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCpf.setBounds(281, 72, 39, 17);
		getContentPane().add(lblCpf);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCpf.setColumns(10);
		txtCpf.setBounds(277, 100, 150, 20);
		getContentPane().add(txtCpf);

		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEmail.setBounds(497, 137, 78, 17);
		getContentPane().add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEmail.setColumns(10);
		txtEmail.setBounds(497, 165, 243, 20);
		getContentPane().add(txtEmail);

		txtTelefone = new JTextField();
		txtTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(277, 165, 193, 20);
		getContentPane().add(txtTelefone);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTelefone.setBounds(277, 138, 93, 17);
		getContentPane().add(lblTelefone);

		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblLogradouro.setBounds(277, 279, 105, 18);
		getContentPane().add(lblLogradouro);

		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtLogradouro.setEditable(false);
		txtLogradouro.setColumns(10);
		txtLogradouro.setBounds(277, 308, 283, 20);
		getContentPane().add(txtLogradouro);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblComplemento.setBounds(592, 281, 110, 14);
		getContentPane().add(lblComplemento);

		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(590, 308, 150, 20);
		getContentPane().add(txtComplemento);

		JLabel lblCep = new JLabel("CEP");
		lblCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCep.setBounds(497, 206, 46, 17);
		getContentPane().add(lblCep);

		txtCep = new JTextField();
		txtCep.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCep.setColumns(10);
		txtCep.setBounds(497, 233, 136, 20);
		getContentPane().add(txtCep);

		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCidade.setBounds(277, 351, 76, 14);
		getContentPane().add(lblCidade);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtCidade.setEditable(false);
		txtCidade.setColumns(10);
		txtCidade.setBounds(277, 376, 164, 20);
		getContentPane().add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblBairro.setBounds(463, 351, 46, 14);
		getContentPane().add(lblBairro);

		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtBairro.setEditable(false);
		txtBairro.setColumns(10);
		txtBairro.setBounds(463, 376, 171, 20);
		getContentPane().add(txtBairro);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblEstado.setBounds(656, 351, 84, 14);
		getContentPane().add(lblEstado);

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Calibri", Font.PLAIN, 18));
		txtEstado.setEditable(false);
		txtEstado.setColumns(10);
		txtEstado.setBounds(656, 376, 84, 20);
		getContentPane().add(txtEstado);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Calibri", Font.PLAIN, 14));
		btnSalvar.setIcon(new ImageIcon("img\\salvar.png"));
		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int opt1 = JOptionPane.showConfirmDialog(null,
						"Deseja salvar as alterações? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui

					String cpf_fiador = txtCpf.getText();

					model.Fiador fiador = FiadorDAO.buscarFiadorCpf(cpf_fiador);

					// saber se já possui um cpf cadastrado igual na tabela
					// cliente
					// VER COM O PROFESSOR
					if (fiador == null) {
						String nome = txtNome.getText();
						String profissao = txtProfissao.getText();
						String email = txtEmail.getText();
						String telefone = txtTelefone.getText();
						String complemento = txtComplemento.getText();
						String cep = txtCep.getText();

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

						FiadorDAO.incluirFiador(cpf_fiador, nome, telefone,
								email, profissao, complemento, cep);

						JOptionPane.showMessageDialog(null,
								"Fiador salvo com Sucesso! ");

					} else { // se for igual nao pode salvar ELE EDITA

						String nome = txtNome.getText();
						String profissao = txtProfissao.getText();
						String email = txtEmail.getText();
						String telefone = txtTelefone.getText();
						String complemento = txtComplemento.getText();
						String cep = txtCep.getText();

						// aqui e para faze os campos seres limpos apos salva
						for (int i = 0; i < getContentPane()
								.getComponentCount(); i++) {
							// varre todos os componentes

							Component c = getContentPane().getComponent(i);

							if (c instanceof JTextField) {
								// apaga os valores
								JTextField field = (JTextField) c;
								field.setText("");

							}// fim do if
						} // fim do for

						FiadorDAO.alterarFiador(cpf_fiador, nome, telefone,
								email, profissao, complemento, cep);

						JOptionPane.showMessageDialog(null,
								"Fiador editado com Sucesso! ");

					}// fim do else

					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch

			}
		});// fim do Action Listener

		btnSalvar.setBounds(75, 324, 110, 41);
		getContentPane().add(btnSalvar);

	
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon("img\\delete84 (3).png"));
		btnExcluir.setFont(new Font("Calibri", Font.PLAIN, 14));

		btnExcluir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				String cpf_fiador = txtCpf.getText();

				int opt1 = JOptionPane.showConfirmDialog(null,
						"Tem certeza que deseja excluir? ");

				switch (opt1) {

				case JOptionPane.YES_OPTION:
					// Se clicar em Sim inclui o imovel

					// aqui e para faze os campos seres limpos apos salva
					for (int i = 0; i < getContentPane().getComponentCount(); i++) {
						// varre todos os componentes

						Component c = getContentPane().getComponent(i);

						if (c instanceof JTextField) {
							// apaga os valores
							JTextField field = (JTextField) c;
							field.setText("");

						}// fim do if
					} // fim do for

					FiadorDAO.excluirFiador(cpf_fiador);
					JOptionPane.showMessageDialog(null,
							"Fiador excluído com Sucesso! ");
					break;

				case JOptionPane.NO_OPTION:

					break;

				}// fim do switch

			}
		});

		btnExcluir.setBounds(75, 415, 110, 41);
		getContentPane().add(btnExcluir);

		JButton btnPesquisarCep = new JButton("");
		btnPesquisarCep.setIcon(new ImageIcon("img\\magnifier13.png"));
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

		btnPesquisarCep.setBounds(652, 234, 33, 20);
		getContentPane().add(btnPesquisarCep);

		//Pesquisando o Cpf do fiador
		JButton btnPesquisar = new JButton("");
		btnPesquisar.setIcon(new ImageIcon("img\\magnifier13.png"));
		btnPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 String cpf_fiador= txtCpf.getText();
				 
				
				 model.Fiador fiador = FiadorDAO.buscarFiadorCpf(cpf_fiador);
				 
				 if (fiador != null){
				 
				  String nome = fiador.getNome(); 
				  txtNome.setText(nome);
				  
				  String telefone = fiador.getTelefone();
				  txtTelefone.setText(telefone); 
				  
				  String email = fiador.getEmail(); 
				  txtEmail.setText(email);
				  
				  String profissao = fiador.getProfissao();
				  txtProfissao.setText(profissao);
				  
				  
				  String complemento = fiador.getComplemento();
				  txtComplemento.setText(complemento);
				  
				  int idCep = fiador.getId_cep(); Endereco endereco =
				  EnderecoDAO.buscarEndereco(idCep);
				  
				  
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
				  
				  } else{ //se não estiver cadastrado um cpf no cliente amostra o JoptionPANE
				  
				  JOptionPane.showMessageDialog(null, "Cpf não cadastrado",
				 "Erro", JOptionPane.ERROR_MESSAGE);
				 
				 }
				

			}// fim do buscarCliente

		});
		btnPesquisar.setBounds(437, 100, 33, 20);
		getContentPane().add(btnPesquisar);
		
		
		JLabel titulo = new JLabel("Cadastro de Fiador");
		titulo.setFont(new Font("Calibri", Font.BOLD, 21));
		titulo.setBounds(51, 266, 166, 17);
		getContentPane().add(titulo);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("img\\fiador2.png"));
		label.setFont(new Font("Calibri", Font.PLAIN, 18));
		label.setBounds(31, 72, 200, 188);
		getContentPane().add(label);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 42, 231, 253);
		getContentPane().add(panel);
		
		//imagem de fundo
		JLabel lblImagem = new JLabel("imagem");
		lblImagem.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
		lblImagem.setBounds(0, 0, 1024, 728);
		getContentPane().add(lblImagem);

		setVisible(true);
		setResizable(false);// Fazer que a tela não redimensione
		setLocationRelativeTo(null);// Fazer que a tela abra no centro

	}
}

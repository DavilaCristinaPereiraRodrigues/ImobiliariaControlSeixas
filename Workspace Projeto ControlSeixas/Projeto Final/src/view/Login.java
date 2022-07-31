package view;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.DAO.ContratoCompraDAO;
import model.DAO.CorretorDAO;
import model.Corretor;

public class Login  {

	
	private JTextField txtLogin;

	private JPasswordField txtsenha;

	public static void main(String[] args) {
		
	try {
			
				new Login();
					//login.setVisible(true);
				//	login.setResizable(false);  //Fazer que a tela n�o redimensione
					//Fazer que a tela abra no centro
				//	login.setLocationRelativeTo(null);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
	public Login(){
		JFrame janelaLogIn = new JFrame("Control Seixas - Software de Controle Imobili�rio");
		JPanel painelLogIn = (JPanel) janelaLogIn.getContentPane();
		//super("Label");
	//	JFrame janelaLogIn = new JFrame("Janela de LogIn");
		//Cor do login para colocar azul, o plano de fundo
		janelaLogIn.getContentPane().setBackground(new Color(135, 206, 250));
		janelaLogIn.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 14));
				
		janelaLogIn.setTitle("Control Seixas - Software de Controle Imobili�rio");
		janelaLogIn.setDefaultCloseOperation(Menu.EXIT_ON_CLOSE);
		janelaLogIn.setBounds(100,50,1024, 728);
		janelaLogIn.getContentPane().setLayout(null);
		janelaLogIn.setVisible(true);

	
		
		
		
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(new Color(245, 255, 250));
		btnEntrar.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnEntrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			String login = txtLogin.getText();//tela
			String senha = txtsenha.getText();
			
			
			Corretor corretor = CorretorDAO.buscarPorLoginSenha(login, senha);
			
			
			
			//Fazendo O Menu do Sistema
			if(corretor != null){
				
				String tp_cor = corretor.getTp_cor();
				
				
				if (tp_cor.equals("Administrador")) {
				
					Menu menu = new Menu();
					janelaLogIn.dispose();
					menu.setLocationRelativeTo(null); //abrir ao centro
					menu.setVisible(true);
					
					String nome = corretor.getNome();
					
					JOptionPane.showMessageDialog(janelaLogIn, "Bem vindo Administrador " + nome);
				}//fim do if interno
				else {//Se n�o abre o outro menu COmum
					
					MenuComum menu1 = new MenuComum();
					janelaLogIn.dispose();
					menu1.setLocationRelativeTo(null); //abrir ao centro
					menu1.setVisible(true);
					
				}//fim do else
				
		
			}else{
				//JOptionPane.showMessageDialog(((JButton)arg0.getSource()).getParent(), "Login ou senha inv�lido.", "Erro", JOptionPane.ERROR_MESSAGE);//Este funciona sem precisar conhecer a referencia do continer/janela do componente que dispara o action
				JOptionPane.showMessageDialog(janelaLogIn, "Login ou senha inv�lido.", "Erro", JOptionPane.ERROR_MESSAGE);
				txtLogin.setText("");
				txtsenha.setText("");
			}
	


			}
		});// fim do Action Listener
		btnEntrar.setBounds(483, 464, 82, 28);
		janelaLogIn.getContentPane().add(btnEntrar);

		
		
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.LEFT);
		txtLogin.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtLogin.setColumns(10);
		txtLogin.setBounds(430, 328, 268, 20);
		janelaLogIn.getContentPane().add(txtLogin);
		
		

		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setIcon(new ImageIcon("img\\logo-01.png"));
		lblLogo.setBounds(302, 66, 396, 198);
		janelaLogIn.getContentPane().add(lblLogo);
		
		//Senha
		txtsenha = new JPasswordField();
		txtsenha.setBounds(430, 365, 268, 20);
		janelaLogIn.getContentPane().add(txtsenha);
		

		JLabel lblSenha = new JLabel("   SENHA");
		lblSenha.setIcon(new ImageIcon("img\\locked59.png"));
		lblSenha.setBounds(354, 361, 200, 28);
		janelaLogIn.getContentPane().add(lblSenha);
		
		JLabel lblLogin = new JLabel("   LOGIN");
		lblLogin.setIcon(new ImageIcon("img\\login1.png"));
		lblLogin.setBounds(354, 326, 84, 24);
		janelaLogIn.getContentPane().add(lblLogin);
		
		
		/*
		Checkbox lembrarSenha = new Checkbox("Lembrar Senha");
		lembrarSenha.setState(true);
		lembrarSenha.setBackground(new Color(192, 192, 192));
		lembrarSenha.setForeground(Color.BLACK);
		lembrarSenha.setFont(new Font("Calibri", Font.PLAIN, 12));
		lembrarSenha.setBounds(466, 425, 119, 22);
		janelaLogIn.getContentPane().add(lembrarSenha);
		*/
		//Imagem de fundo - tem que ser por �ltimo para aparecer a imagem
		JLabel label = new JLabel("   SENHA");
		label.setIcon(new ImageIcon("img\\1 (1).png"));
		label.setBounds(0, 0, 1024,728);
		janelaLogIn.getContentPane().add(label);
		
		
		
				janelaLogIn.setVisible(true); 
				janelaLogIn.setResizable(false);//Fazer que a tela n�o redimensione
				janelaLogIn.setLocationRelativeTo(null);//Fazer que a tela abra no centro

				
	}
		
}

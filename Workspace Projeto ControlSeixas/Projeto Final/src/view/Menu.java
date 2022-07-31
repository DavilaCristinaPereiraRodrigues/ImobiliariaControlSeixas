package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame {

	JMenuBar menu;
	JMenu cadastros, contratos, pesquisar, configuracao, usuario,ajuda, sairm;
	JMenuItem cliente, proprietario,imovel, fiador, corretor,compra, locacao, pesImoveis, imCompra,imLocacao, pesCont,contCompra, contLocacao,
			 adcorretor, alsenha, manual, sobre, sair;


	public Menu() {

		super("Menu");
		// Cor do menu para colocar azul, o plano de fundo
		getContentPane().setBackground(new Color(135, 206, 250));
		getContentPane().setFont(new Font("Calibri", Font.PLAIN, 18));

		menu = new JMenuBar();
		setJMenuBar(menu);
		
		// aqui entou criando para entra no menu

		cadastros = new JMenu("Cadastros");
		cadastros.setFont(new Font("Calibri", Font.PLAIN, 16));// essa linha
																// serve para
																// muda a fonte

		contratos = new JMenu("Contratos");
		contratos.setFont(new Font("Calibri", Font.PLAIN, 16));

		pesquisar = new JMenu("Pesquisar");
		pesquisar.setFont(new Font("Calibri", Font.PLAIN, 16));

		configuracao = new JMenu("Configura��o");
		configuracao.setFont(new Font("Calibri", Font.PLAIN, 16));

		ajuda = new JMenu("Ajuda");
		ajuda.setFont(new Font("Calibri", Font.PLAIN, 16));

		// aqui chamando o itens

		// Colocando a imagem ao lado da frase
		ImageIcon icon = new ImageIcon("img\\clienteMenu.jpg");
		cliente = new JMenuItem("Cliente", icon);
		cliente.setFont(new Font("Calibri", Font.PLAIN, 16));
		cliente.addActionListener( // aqui chamara a classe cliente
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nome da classe do Novo Formulario
				Cliente novoCliente = new Cliente();
				// Abre novo formul�rio
				novoCliente.setVisible(true);

			}
		});
		
		ImageIcon icon5 = new ImageIcon("img\\propri3636.jpg");
		proprietario = new JMenuItem("Proprietario", icon5);
		proprietario.setFont(new Font("Calibri", Font.PLAIN, 16));
		proprietario.addActionListener(  //aqui chamara a classe imovel
	            new ActionListener() {                  
	                public void actionPerformed(ActionEvent e) {  
	                    //Nome da classe do Novo Formulario  
	                  Proprietario proprietario = new Proprietario();  
	                    //Abre novo formul�rio  
	                    proprietario.setVisible(true);                     
	                }     
	            }  
	        );  

		ImageIcon icon6 = new ImageIcon("img\\fiadormenu.jpg");
		fiador = new JMenuItem("Fiador",icon6);
		fiador.setFont(new Font("Calibri", Font.PLAIN, 16));
		fiador.addActionListener(  //aqui chamara a classe imovel
	            new ActionListener() {                  
	                public void actionPerformed(ActionEvent e) {  
	                    //Nome da classe do Novo Formulario  
	                 Fiador fiador= new Fiador();  
	                    //Abre novo formul�rio  
	                   fiador.setVisible(true);                     
	                }     
	            }  
	        );  
		ImageIcon icon4 = new ImageIcon("img\\corretormenu.png");
		corretor = new JMenuItem("Corretor" ,icon4);
		corretor.setFont(new Font("Calibri", Font.PLAIN, 16));
		corretor.addActionListener(  //aqui chamara a classe imovel
	            new ActionListener() {                  
	                public void actionPerformed(ActionEvent e) {  
	                    //Nome da classe do Novo Formulario  
	                Corretor correto= new Corretor();  
	                    //Abre novo formul�rio  
	                   correto.setVisible(true);                     
	                }     
	            }  
	        );  

		
		ImageIcon icon2 = new ImageIcon("img\\contratos.png");
		compra = new JMenuItem("Compra", icon2);
		compra.setFont(new Font("Calibri", Font.PLAIN, 16));
		compra.addActionListener( // aqui chamara a classe contrato de compra
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nome da classe do Novo Formulario
				ContratoCompra compra = new ContratoCompra();
				// Abre novo formul�rio
				compra.setVisible(true);
			}
		});

		ImageIcon icon3 = new ImageIcon("img\\contratos.png");
		locacao = new JMenuItem("Loca��o", icon3);
		locacao.setFont(new Font("Calibri", Font.PLAIN, 16));
		locacao.addActionListener( // aqui chamara a classe contrato de loca��o
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nome da classe do Novo Formulario
				ContratoAluguel locacao = new ContratoAluguel();
				// Abre novo formul�rio
				locacao.setVisible(true);
			}
		});
		
		// Pesquisa imovel aqui n�o � um JMENUITEM ,pq ele vai ter mais dois
		// tipos nele.
		
		pesImoveis = new JMenu("Im�veis");
		pesImoveis.setFont(new Font("Calibri", Font.PLAIN, 16));

		imCompra = new JMenuItem("Compra");
		imCompra.setFont(new Font("Calibri", Font.PLAIN, 16));
		imCompra.addActionListener( // aqui chamara a classe Pesquisa imoveis
		new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Nome da classe do Novo Formulario
				PesquisarImovel compra = new PesquisarImovel();
				// Abre novo formul�rio
				compra.setVisible(true);
			}
		});

		imLocacao = new JMenuItem("Loca��o");
		imLocacao.setFont(new Font("Calibri", Font.PLAIN, 16));
		imLocacao.addActionListener( // aqui chamara a classe pesquisa imovel de
										// loca��o
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Nome da classe do Novo Formulario
					//	PesquisarImovelLocacao compra = new PesquisarImovelLocacao();
						// Abre novo formul�rio
						compra.setVisible(true);
					}
				});

		// Pesquisa Contratos aqui n�o � um JMENUITEM ,pq ele vai ter mais dois
		// tipos nele.
				
		ImageIcon icon8 = new ImageIcon("img\\imovelmenu32.jpg");
		imovel = new JMenuItem("Im�vel", icon8);
		imovel.setFont(new Font("Calibri", Font.PLAIN, 16));
		imovel.addActionListener( // aqui chamara a classe pesquisa
										// contrato de loca�ao
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Nome da classe do Novo Formulario
						JanelaImovel imovel = new JanelaImovel();
						// Abre novo formul�rio
						imovel.setVisible(true);
					}
				});


		
		// usuario aqui nao e um JMENUITEM , pq ele vai ter mais dois tipos
		// nele.
		ImageIcon icon7 = new ImageIcon("img\\senha.png");
		alsenha = new JMenuItem("Alterar senha",icon7);
		alsenha.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		manual = new JMenuItem("Manual");
		manual.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		sobre = new JMenuItem("Sobre");
		sobre.setFont(new Font("Calibri", Font.PLAIN, 16));

		sair = new JMenuItem("Sair");
		sair.setFont(new Font("Calibri", Font.PLAIN, 16));
		sair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resposta;
				resposta = JOptionPane.showConfirmDialog(null,
						"Deseja realmente sair?", "Sa�da",
						JOptionPane.YES_NO_OPTION);
				if (resposta == 0)
					System.exit(0);
			}
		});

		// aqui estou chamando eles la no menu para eles aparecerem
		menu.add(cadastros);
		menu.add(contratos);
		menu.add(pesquisar);
		menu.add(configuracao);
		menu.add(ajuda);
		menu.add(sair);

		cadastros.add(cliente);
		cadastros.add(proprietario);
		cadastros.add(imovel);
		cadastros.add(fiador);
		cadastros.add(corretor);

		contratos.add(compra);
		contratos.add(locacao);

		pesquisar.add(pesImoveis);
		pesImoveis.add(imCompra);
		pesImoveis.add(imLocacao);
	
		

		ajuda.add(manual);
		ajuda.add(sobre);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("img\\logo-01.png"));
		lblLogo.setBounds(289, 119, 470, 387);
		getContentPane().add(lblLogo);

		JLabel lblImagem = new JLabel("imagem");
		lblImagem.setIcon(new ImageIcon("img\\1 (1).png"));
		setBounds(100, 0, 1024, 728);
		getContentPane().add(lblImagem);

		
		setResizable(false);  //falso bloqueio para n redimensionar
		setVisible(true);
		setLocationRelativeTo(null); //abrir ao centro
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 0, 1024, 728);
		getContentPane().setLayout(null);

	}

	public static void main(String args[]) {
		Menu menu = new Menu();

	}
}
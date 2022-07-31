package view;
    import java.awt.Container;  
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import util.Teclado;
import model.Cliente;
import model.Endereco;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.ImovelDAO;

import javax.swing.table.AbstractTableModel;

      
    public class NovoCliente extends JFrame {  
    
    
        public static void main(String[] args) {  
    		try {
    			new NovoCliente();      
    		

    		} catch (Exception e) {
    			e.printStackTrace();
    		}
        
              
            
        }//fim do método main
        
        public NovoCliente() {
           setSize(800,600);       
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);         
           getContentPane().setLayout(null);  
            //Centraliza a janela.  
            java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();  
            int componentWidth = getWidth();  
            int componentHeight = getHeight();  
         setBounds((screenSize.width-componentWidth)/2, (screenSize.height-componentHeight)/4, componentWidth, componentHeight);  
      
            final DefaultTableModel modelo = new DefaultTableModel();  
           
            // constrói a tabela  
            JTable tabela = new JTable(modelo);  
            // Cria duas colunas  
      
               
            modelo.addColumn("Nome");  
            modelo.addColumn("CPF");  

            tabela.setPreferredScrollableViewportSize(new Dimension(580, 500));  
            tabela.getColumnModel().getColumn(0).setPreferredWidth(50);  
            tabela.getColumnModel().getColumn(1).setPreferredWidth(200);  
      
            JScrollPane scrollPane = new JScrollPane(tabela);  
            /* 
             * Tinha faltado 
             * */  
            scrollPane.setLocation(39,22);  
            scrollPane.setSize(700,495);  
            getContentPane().add(scrollPane);  
            
	            JButton btnNovo = new JButton("Novo");
	            btnNovo.setBounds(336, 528, 89, 23);
	            getContentPane().add(btnNovo);
	            setVisible(true);  
            
        }//
        
        

    	
    }
         
    
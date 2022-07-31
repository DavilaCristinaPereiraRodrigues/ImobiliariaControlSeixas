package view;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.ClienteTabelaModel;
import model.Cliente;

//Tabela para pesquisar o cliente
public class PesquisarCliente extends JFrame{

	public PesquisarCliente(List<Cliente> clientes){
		super("Lista de Clientes:");
		
		JTable tabela = new JTable();	
		ClienteTabelaModel tableModel = new ClienteTabelaModel(clientes);
		tabela.setModel(tableModel);
				
		tabela.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			//Para clicar na tabela
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(arg0.getButton()==MouseEvent.BUTTON1){
					String retorno = "";
					for (int i = 0; i < tabela.getColumnCount(); i++) {
						retorno = retorno+tabela.getColumnName(i)+": "+tabela.getValueAt(tabela.getSelectedRow(), i)+"\n";
					}
					
					JOptionPane.showMessageDialog(tabela.getParent(), retorno);
				}
			}
		});
				
						
		
		
		JScrollPane scroll = new JScrollPane();
		scroll.getViewport().add(tabela);
		scroll.setSize(100, 200);
				
		Container c = getContentPane();
		c.add(scroll);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 600);
		setVisible(true);
		setAlwaysOnTop(true);
	
		
		
	}
}
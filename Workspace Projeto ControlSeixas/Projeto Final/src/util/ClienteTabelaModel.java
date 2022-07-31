package util;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Cliente;

import model.DAO.ClienteDAO;

public class ClienteTabelaModel extends AbstractTableModel {
	private final List<Cliente> cliente;

	public ClienteTabelaModel(List<Cliente> clientes) {
		this.cliente = clientes;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return cliente.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		Cliente cli = cliente.get(linha);

		switch (coluna) {
		case 0:
			return cli.getCpf_cliente();
		case 1:
			return cli.getNome();

		default:

			break;
		}

		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "CPF";
		case 1:
			return "Nome";

		default:
			return "";
		}
	}
}

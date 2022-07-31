package util;

import java.util.List;

import model.Cliente;
import model.Endereco;
import model.Imovel;

import javax.swing.table.AbstractTableModel;

import view.PesquisarImovel;
import model.DAO.ImovelDAO;

public class ImovelTabelaModel extends AbstractTableModel {

	private final List<Imovel> imovel;
	private final List<Endereco> enderecos;

	public ImovelTabelaModel(List<Imovel> imovel, List<Endereco> enderecos) {
		this.imovel = imovel;
		this.enderecos = enderecos;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return imovel.size();
	}

	@Override
	public Object getValueAt(int linha, int coluna) {
		// TODO Auto-generated method stub
		Imovel imo = imovel.get(linha);
		Endereco end = enderecos.get(linha);

		switch (coluna) {
		case 0:
			return imo.getCodigo();
		case 1:
			return imo.getValor();
		case 2:
			return end.getBairro();
		case 3:
			return end.getCidade();
		case 4:
			return imo.getTp_status();
		default:

			break;
		}

		return null;
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "C�digo";
		case 1:
			return "Valor";
		case 2:
			return "Bairro";
		case 3:
			return "Cidade";
		case 4:
			return "Status";

		default:
			return "";
		}
	}
}

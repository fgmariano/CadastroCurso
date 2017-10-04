package control;

import java.sql.SQLException;

import javax.swing.event.TableModelListener;

import dao.CursoDAO;
import dao.CursoDAOImpl;
import model.Curso;
import tableModel.CursoTableModel;

public class CursoControl implements CursoTableModel {
	
	CursoDAO dao = new CursoDAOImpl();

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getColumnName(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void adicionar(Curso c) {
		try {
			dao.adicionar(c);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void remover(long id) {
		try {
			dao.remover(id);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(long id, Curso c) {
		try {
			dao.atualizar(id, c);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void pesquisar(String nome) {
		try {
			dao.pesquisar(nome);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}

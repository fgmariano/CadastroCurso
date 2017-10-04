package tableModel;

import javax.swing.table.TableModel;

import model.Curso;

public interface CursoTableModel extends TableModel {
	public void adicionar(Curso c);
	public void remover(long id);
	public void atualizar(long id, Curso c);
	public void pesquisar(String nome);
}

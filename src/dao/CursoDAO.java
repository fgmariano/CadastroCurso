package dao;

import java.sql.SQLException;
import java.util.List;
import model.Curso;

public interface CursoDAO {
	public void adicionar(Curso c) throws SQLException, ClassNotFoundException;
	public void atualizar(long id, Curso c) throws SQLException, ClassNotFoundException;
	public void remover (long id) throws SQLException, ClassNotFoundException;
	public List<Curso> pesquisar(String nome) throws SQLException, ClassNotFoundException;
}

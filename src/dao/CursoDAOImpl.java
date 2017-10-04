package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoDAOImpl implements CursoDAO {

	@Override
	public void adicionar(Curso c) throws SQLException, ClassNotFoundException {
		Connection con = DBResourceManager.getInstance().getCon();
		String sql = "INSERT INTO curso (id, nome, descricao, horarioInicio, horarioTermino, ativo) VALUES (?, ?, ?, ?, ?, ?) ";
		PreparedStatement stmt = con.prepareStatement( sql );
		java.sql.Date sd = new java.sql.Date( c.getHorarioInicio().getTime() );
		java.sql.Date sd1 = new java.sql.Date( c.getHorarioTermino().getTime() );
		stmt.setLong(1, c.getId() );
		stmt.setString(2, c.getNome() );
		stmt.setString(3, c.getDescricao());
		stmt.setDate(4, sd);
		stmt.setDate(5, sd1);
		stmt.setBoolean(6, c.isAtivo());
		stmt.executeUpdate();
	}

	@Override
	public void atualizar(long id, Curso c) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE curso "	+ 
			     " SET nome = ?, descricao = ?, horarioInicio = ?, horarioTermino = ?, " + 
			     " ativo = ? WHERE id = ? ";
		Connection con = DBResourceManager.getInstance().getCon();
		PreparedStatement stmt = con.prepareStatement( sql );
		java.sql.Date sd = new java.sql.Date( c.getHorarioInicio().getTime() );
		java.sql.Date sd1 = new java.sql.Date( c.getHorarioTermino().getTime() );
		stmt.setString(1, c.getNome() );
		stmt.setString(2, c.getDescricao());
		stmt.setDate(3, sd);
		stmt.setDate(4, sd1);
		stmt.setBoolean(5, c.isAtivo());
		stmt.setLong(6, id);
		stmt.executeUpdate();
	}

	@Override
	public void remover(long id) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM curso WHERE id = ? ";
		Connection con = DBResourceManager.getInstance().getCon();
		PreparedStatement stmt = con.prepareStatement( sql );
		stmt.setLong(1, id );
		stmt.executeUpdate();
	}

	@Override
	public List<Curso> pesquisar(String nome) throws SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM jogo WHERE nome like ?";
		List<Curso> cursos = new ArrayList<Curso>();
		Connection con = DBResourceManager.getInstance().getCon();
		PreparedStatement stmt = con.prepareStatement( sql );
		stmt.setString(1, "%" + nome + "%" );
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) { 
			Curso c = new Curso();
			c.setId( rs.getInt("id") );
			c.setNome( rs.getString("nome") );
			c.setDescricao( rs.getString("descricao") );
			c.setHorarioInicio( rs.getDate("horarioInicio") );
			c.setHorarioTermino( rs.getDate("horarioTermino") );
			c.setAtivo( rs.getBoolean("ativo"));
			cursos.add( c );
		}
		return cursos;
	}
	
}

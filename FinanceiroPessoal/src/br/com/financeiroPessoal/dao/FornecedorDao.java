package br.com.financeiroPessoal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.financeiroPessoal.bean.Favorecido;
import br.com.financeiroPessoal.controle.FavorecidoBean;
import br.com.financeiroPessoal.exception.DaoException;
import br.com.financeiroPessoal.util.DbUtil;

public class FornecedorDao {
	
	private static final String INSERIR = "insert into tbl_fornecedor(nome) values(?)";
	
	private static final String BUSCAR_TODOS = "select * from tbl_fornecedor";
	
	private static final String EDITAR = "update tbl_fornecedor set nome = ? where id = ?";
	
	private static final String EXCLUIR = "delete from tbl_fornecedor where id = ?";
	
	private Favorecido getBean(ResultSet result) throws DaoException, SQLException{
		Favorecido bean = new Favorecido();
		
		bean.setCodigo(result.getInt("id"));
		bean.setNomeRazao(result.getString("nome"));
		
		return bean;
	}
	
	public void inserir(Favorecido f) throws DaoException{
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			statement = conn.prepareStatement(INSERIR);
			statement.setString(1, f.getNomeRazao());
			
			statement.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			DbUtil.close(conn, statement, result);
		}
	}
	
	public List<Favorecido> listar() throws DaoException{
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		List<Favorecido> retorno = new ArrayList<Favorecido>();
		try{
			statement = conn.prepareStatement(BUSCAR_TODOS);
			result = statement.executeQuery();
			
			while(result.next()){
				Favorecido b = getBean(result);
				retorno.add(b);
			}
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			DbUtil.close(conn, statement, result);
		}
		
		return retorno;
	}
	
	public void editar(Favorecido f) throws DaoException{
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			statement = conn.prepareStatement(EDITAR);
			statement.setString(1, f.getNomeRazao());
			statement.setInt(2, f.getCodigo());
			
			statement.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			DbUtil.close(conn, statement, result);
		}
	}
	
	public void excluir(Favorecido f) throws DaoException{
		Connection conn = DbUtil.getConnection();
		PreparedStatement statement = null;
		ResultSet result = null;
		try{
			statement = conn.prepareStatement(EXCLUIR);
			statement.setInt(1, f.getCodigo());
			
			statement.executeUpdate();
		}catch(SQLException e){
			throw new DaoException(e);
		}finally{
			DbUtil.close(conn, statement, result);
		}
	}

}

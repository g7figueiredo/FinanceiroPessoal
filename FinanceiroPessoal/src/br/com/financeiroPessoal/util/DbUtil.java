package br.com.financeiroPessoal.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import br.com.financeiroPessoal.exception.DaoException;

public class DbUtil {
	
	private static final String URL_DATABASE = "jdbc:mysql://localhost:3306/financeiropessoal";//local
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String DRIVER_JDBC = "com.mysql.jdbc.Driver";
	
	static {
		try {
			Class.forName(DRIVER_JDBC);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws DaoException{
		try{
			Connection connection = DriverManager.getConnection(URL_DATABASE, USER, PASSWORD);
			connection.setAutoCommit(true);
			return connection;
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public static java.util.Date getJavaDate(ResultSet result, String nomeCampo) throws SQLException {
		Date dataFalecimento = result.getDate(nomeCampo);
		java.util.Date javaDate = null;
		if (dataFalecimento != null) {
			javaDate = new Date(dataFalecimento.getTime());
		}
		return javaDate;
	}
	
	public static java.util.Date getStampDate(ResultSet result, String nomeCampo) throws SQLException {
		Date data = new Date(result.getTimestamp(nomeCampo).getTime());
		java.util.Date javaDate = null;
		if (data != null) {
			javaDate = new Date(data.getTime());
		}
		return javaDate;
	}
	
	public static java.sql.Date getSqlDate(java.util.Date date) {
		java.sql.Date sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Date(date.getTime());
		}
		return sqlDate;
	}
	
	public static java.sql.Timestamp getSqlTimestamp(java.util.Date date){
		java.sql.Timestamp sqlDate = null;
		if (date != null) {
			sqlDate = new java.sql.Timestamp(date.getTime());
		}
		return sqlDate;
	}
        
        public static byte[] getInputStream(ResultSet result, String campo) throws IOException, SQLException{
            InputStream input = result.getBinaryStream(campo);
            byte[] bytes = new byte[input.available()];
            
            return bytes;
        }
	
	public static void close(Connection conn, PreparedStatement statement, ResultSet result){
		try{
			if (conn != null) {
				conn.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (result != null) {
				result.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement statement, ResultSet result){
		try{
			if (statement != null) {
				statement.close();
			}
			if (result != null) {
				result.close();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

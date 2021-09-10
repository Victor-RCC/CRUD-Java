package br.com.fiap.cp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.cp.model.Filme;


public class FilmesDAO {
	
	private Connection connection;
	
	public FilmesDAO(Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	public int cadastrar(Filme filme) throws SQLException {
		String sql = "INSERT INTO T_CP_FILMES"
				   + "(id, titulo,ano_lancamento, sinopse, nota, assistido, onde_assistir )"
				   + " VALUES (?,?,?,?,?,?,?)";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
		prepareStatement.setLong(1, filme.getId());
		prepareStatement.setString(2, filme.getTitulo());
		prepareStatement.setInt(3, filme.getAno_lancamento());
		prepareStatement.setString(4, filme.getSinopse());
		prepareStatement.setInt(5, filme.getNota());
		prepareStatement.setString(6, filme.getAssistido());
		prepareStatement.setString(7, filme.getOnde_assistir());
		
		return prepareStatement.executeUpdate();
	}
	
	public int excluir(Long id) throws SQLException {
		String sql = "DELETE FROM T_CP_FILMES WHERE id= ? ";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);		
		prepareStatement.setLong(1, id);
		
		return prepareStatement.executeUpdate();
		
	}
	
	public List<Filme> buscar() throws SQLException {
		
		Statement statement = connection.createStatement();
		
		statement.execute("SELECT * FROM T_CP_FILMES");
		ResultSet resultSet = statement.getResultSet();
		List<Filme> lista = new ArrayList<Filme>();
		
		while(resultSet.next()) {
			Filme filme = new Filme(resultSet.getLong("id"),
		    resultSet.getString("titulo"),
		    resultSet.getInt("ano_lancamento"),
		    resultSet.getString("sinopse"),
		    resultSet.getInt("nota"),
		    resultSet.getString("assistido"),
		    resultSet.getString("onde_assistir"));
			
			lista.add(filme);
		}
		
		return lista;
	}
	
	public List<Filme> buscarRecente() throws SQLException {
		
        Statement statement = connection.createStatement();
		
		statement.execute("SELECT * FROM T_CP_FILMES ORDER BY ano_lancamento DESC");
		ResultSet resultSet = statement.getResultSet();
		List<Filme> lista = new ArrayList<Filme>();
		
		while(resultSet.next()) {
			Filme filme = new Filme(resultSet.getLong("id"),
		    resultSet.getString("titulo"),
		    resultSet.getInt("ano_lancamento"),
		    resultSet.getString("sinopse"),
		    resultSet.getInt("nota"),
		    resultSet.getString("assistido"),
		    resultSet.getString("onde_assistir"));
			
			lista.add(filme);
	
	    }
		return lista;
		
	}
        public List<Filme> buscarAssistido() throws SQLException {
		
        Statement statement = connection.createStatement();
		
		statement.execute("SELECT * FROM T_CP_FILMES WHERE assistido = 'sim'");
		ResultSet resultSet = statement.getResultSet();
		List<Filme> lista = new ArrayList<Filme>();
		
		while(resultSet.next()) {
			Filme filme = new Filme(resultSet.getLong("id"),
		    resultSet.getString("titulo"),
		    resultSet.getInt("ano_lancamento"),
		    resultSet.getString("sinopse"),
		    resultSet.getInt("nota"),
		    resultSet.getString("assistido"),
		    resultSet.getString("onde_assistir"));
			
			lista.add(filme);
	
	    }
		return lista;
    }
        
        public List<Filme> buscarNaoAssistido() throws SQLException {
    		
            Statement statement = connection.createStatement();
    		
    		statement.execute("SELECT * FROM T_CP_FILMES WHERE assistido = 'não'");
    		ResultSet resultSet = statement.getResultSet();
    		List<Filme> lista = new ArrayList<Filme>();
    		
    		while(resultSet.next()) {
    			Filme filme = new Filme(resultSet.getLong("id"),
    		    resultSet.getString("titulo"),
    		    resultSet.getInt("ano_lancamento"),
    		    resultSet.getString("sinopse"),
    		    resultSet.getInt("nota"),
    		    resultSet.getString("assistido"),
    		    resultSet.getString("onde_assistir"));
    			
    			lista.add(filme);
    	
    	    }
    		return lista;
        }
        
        public List<Filme> buscaTitulo() throws SQLException {
        	
        	List<Filme> listaFilme = new ArrayList<>();
     	
        	String titulo = JOptionPane.showInputDialog("Digite o título");
        	
        	String sql = "SELECT *  FROM T_CP_FILMES WHERE titulo lIKE ? ";
        	
        	PreparedStatement prepareStatement = connection.prepareStatement(sql);
        	
        	prepareStatement.setString(1, "%" + titulo + "%");
        	
        	ResultSet resultSet = prepareStatement.executeQuery();
     
        		while(resultSet.next()) {
        			Filme filme = new Filme(resultSet.getLong("id"),
        					resultSet.getString("titulo"),
        					resultSet.getInt("ano_lancamento"),
        					resultSet.getString("sinopse"),
        					resultSet.getInt("nota"),
        					resultSet.getString("assistido"),
        					resultSet.getString("onde_assistir"));
        					listaFilme.add(filme);	
        	}
        		return listaFilme;
      	
     }
        
        
}

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

/**
 * Design pattern para conversa com o banco de dados.
 * 
 * @author Victor Rubem
 * @version 1.0
 * 
 *
 */

public class FilmesDAO {
	
	private Connection connection;
	
	public FilmesDAO(Connection connection) throws SQLException {
		
		/**
		 * Método construtor que recebe uma conexão
		 * 
		 * @throws SQLException - caso a conexão falhe
		 * 
		 */
		
		this.connection = connection;
	}
	
	public int cadastrar(Filme filme) throws SQLException {
		
		/**
		 * Método para cadastrar filmes
		 * 
		 * 
		 * @return prepareStatement.executeUpdate
		 * retorna se ouve alteração no banco de dados via comando sql.
		 * 
		 * @throws SQLException - caso a conexão falhe
		 * 
		 */
		
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
		
		/**
		 * Método de excluir filme por meio do id no banco de dados através de comando sql
		 * 
		 * @return prepareStatement.executeUpdate
		 * retorna se ouve alteração no banco de dados via comando sql.
		 * @throws SQLException
		 * 
		 */
		
		String sql = "DELETE FROM T_CP_FILMES WHERE id= ? ";
		
		PreparedStatement prepareStatement = connection.prepareStatement(sql);		
		prepareStatement.setLong(1, id);
		
		return prepareStatement.executeUpdate();
		
	}
	
	public List<Filme> buscar() throws SQLException {
		
		/**
		 * Método que realiza uma busca no banco de dados e retorna todas as colunas
		 * 
		 * 
		 * @return retorna uma lista com todas as informações das colunas da tabela filmes.
		 * @throws SQLException - caso a conexão falhe
		 * 
		 */
		
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
		
		/**
		 * Método que ordena os filmes pelo ano mais recente
		 * 
		 * @return retorna lista de filmes ordenada por data
		 * @throws SQLException - caso a conexão falhe 
		 * 
		 */
		
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
        	
        	/**
        	 * Método que busca todos os filmes onde a coluna assistido é igual a 'sim'
        	 * 
        	 * @return retorna a lista dos filmes que foram assistidos
        	 * @throws SQLException - caso a conexão falhe 
        	 * 
        	 */
        	
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
        	
        	/**
        	 * Método que busca todos os filmes onde a coluna assistido é igual a 'não'
        	 * 
        	 * @return retorna a lista dos filmes que não foram assistidos
        	 * @throws SQLException - caso a conexão falhe 
        	 * 
        	 */
    		
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
        	
        	/**
        	 * Método que busca filmes através de uma palavra chave
        	 * 
        	 * @return retorna a lista dos filmes que possuem os caracteres digitados 
        	 * @throws SQLException - caso a conexão falhe 
        	 * 
        	 */
        	
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

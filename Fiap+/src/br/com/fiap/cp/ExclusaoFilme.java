package br.com.fiap.cp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.cp.dao.FilmesDAO;

public class ExclusaoFilme {
	
	/**
	 * Classe que exclui filmes do banco de dados
	 *
	 *@author Victor Rubem
	 *@version 1.0
	 *
	 *
	 */

	
	public ExclusaoFilme() {
		
		/**
		 * M�todo que exclui o filme do id digitado atrav�s do m�todo excluir
		 * da classe FilmesDAO.
		 * 
		 * 
		 * 
		 */
		
		
		try {
			Connection connection = ConnectionFactory.getConnetion();
			
			FilmesDAO filmesDAO = new FilmesDAO(connection);

			String id = JOptionPane.showInputDialog("Digite o id");

			int linha = filmesDAO.excluir(Long.valueOf(id));

			if (linha > 0) {
				JOptionPane.showMessageDialog(null, "Filme apagado");
			} else {
				JOptionPane.showMessageDialog(null, "Filme n�o encontrado");
			}
			
			connection.close();
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
			"Conex�o falhou" + e.getMessage(),
			"erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}

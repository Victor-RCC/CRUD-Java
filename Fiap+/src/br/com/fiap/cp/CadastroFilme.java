package br.com.fiap.cp;

import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.cp.dao.FilmesDAO;
import br.com.fiap.cp.model.Filme;

public class CadastroFilme {
	
	/**
	 * Classe para cadastrar filmes 
	 * 
	 * @author Victor Rubem
	 * @version 1.0 
	 *
	 * 
	 */

	
	
	public CadastroFilme() {
		
		/**
		 * Método construtor que instancia um filme,
		 * que será cadastrado através do método cadastrar da classe FilmesDAO.
		 * 
		 * 
		 *
		 */
		
		try{
			
			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDAO = new FilmesDAO(connection);

			Filme filme = new Filme(Long.valueOf(JOptionPane.showInputDialog("id")),
					JOptionPane.showInputDialog("titulo: "),
					Integer.valueOf(JOptionPane.showInputDialog("ano_lancamento: ")),
					JOptionPane.showInputDialog("sinopse: "),
					Integer.valueOf(JOptionPane.showInputDialog("nota: ")),
					JOptionPane.showInputDialog("assistido: "),
					JOptionPane.showInputDialog("onde_assistir: "));

			int linha = filmesDAO.cadastrar(filme);

			if (linha > 0)
				JOptionPane.showMessageDialog(null, "Filme cadastrado");
			
			connection.close();
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Erro ao conectar" + e.getMessage(),
			"Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

}

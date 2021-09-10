package br.com.fiap.cp;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.cp.dao.FilmesDAO;
import br.com.fiap.cp.model.Filme;

public class ConsultaFilme {
	
	/**
	 * Classe responsável pela consulta no banco de dados de diversas formas.
	 * 
	 * @author Victor Rubem
	 * @version SQLException - caso a conexão falhe.
	 * 
	 */

	public static List<Filme> busca() {
		
		/**
		 * Método que busca todas as informações do banco de dados
		 * através do método buscar da classe FilmesDAO.
		 * 
		 * @return retrona lista caso exista informações nas colunas da tabela filmes,
		 * @return null caso não exista nenhuma informação a ser retornada 
		 * 
		 * 
		 * 
		 */
		
		try {

			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> lista = filmesDao.buscar();

			connection.close();

			return lista;

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null;
	}

	public static List<Filme> consultaTitulo() {
		
		/**
		 * Método que cria uma lista de filmes filtrados por uma palavra chave
		 * caso o retorno método
		 * buscaTitulo da classe FilmesDAO não for vazil.
		 * 
		 * @return lista - retorna uma lista de filmes filtrados.
		 * @return null - caso o retorno do  método buscaTitulo for vazil. 
		 * 
		 */
		try {
			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> listaFilme = new ArrayList<>();

			listaFilme = filmesDao.buscaTitulo();

			if (listaFilme.size() > 0) {
				return listaFilme;
				
			} else {
				JOptionPane.showMessageDialog(null, "Não encontrado");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();

		}
		return null;

	}

	public static List<Filme> consultaNota() {
		
		/**
		 * Método que ordena lista de filmes por maior nota.
		 * 
		 * @return lista - retorna lista ordenada por nota
		 * 
		 * 
		 */
		
		List<Filme> lista = ConsultaFilme.busca();
		Collections.sort(lista);

		return lista;
	}

	public static List<Filme> consultaRecente() {
		
		/**
		 * Método que cria uma lista de filmes ordenadas por data mais recente
		 * caso o retorno do  método buscarRecente da classe FilmesDAO não seja null 
		 * 
		 * @return lista - retorna uma lista com filmes ordernados pela data mais recente 
		 * @return null - caso o método buscarRecente retorne null.
		 * 
		 * 
		 */
		
		try {

			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> lista = filmesDao.buscarRecente();

			connection.close();

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			e.getMessage();

		}
		return null;
	}

	public static List<Filme> consultaAssistido() {
		
		/**
		 * Método que busca todos os filmes onde a coluna assistido é igual a 'sim',
		 * através do método buscarAssistido da classe FilmesDAO.
		 * 
		 * @return lista - retorna lista de filmes assistidos
		 * @return null - caso o método buscarAssistido retorne null.
		 *
		 */
		
		try {

			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> lista = filmesDao.buscarAssistido();

			connection.close();

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			e.getMessage();

		}
		return null;

	}

	public static List<Filme> consultaNaoAssistido() {
		
		/**
		 * Método que busca todos os filmes onde a coluna assistido é igual a 'não',
		 * através do método buscarNaoAssistido da classe FilmesDAO.
		 * 
		 * @return lista - retorna lista de filmes não assistidos
		 * @return null - caso o método buscarNaoAssistido retorne null.
		 *
		 */
		
		try {

			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> lista = filmesDao.buscarNaoAssistido();

			connection.close();

			return lista;

		} catch (SQLException e) {

			e.printStackTrace();
			e.getMessage();

		}
		return null;

	}

	public static List<Filme> consultaServico() {
		
		/**
		 * Método cria uma lista de filmes onde o valor da coluna onde_assistir
		 * for igual ao valor digitado.
		 * 
		 * @return listaServicos - retorna a lista
		 * @return null - retorna null caso não exista 
		 * 
		 */

		List<Filme> lista = ConsultaFilme.busca();
		List<Filme> listaServicos = new ArrayList<>();

		String servico = JOptionPane.showInputDialog("Digite o serviço");

		for (Filme filme : lista) {
			if (filme.getOnde_assistir().equals(servico)) {
				listaServicos.add(filme);
			}
		}

		if (listaServicos.size() > 0) {

			return listaServicos;

		} else {
			JOptionPane.showMessageDialog(null, "não encontrado");

		}
		return null;

	}

}

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
	 * Classe respons�vel pela consulta no banco de dados de diversas formas.
	 * 
	 * @author Victor Rubem
	 * @version SQLException - caso a conex�o falhe.
	 * 
	 */

	public static List<Filme> busca() {
		
		/**
		 * M�todo que busca todas as informa��es do banco de dados
		 * atrav�s do m�todo buscar da classe FilmesDAO.
		 * 
		 * @return retrona lista caso exista informa��es nas colunas da tabela filmes,
		 * @return null caso n�o exista nenhuma informa��o a ser retornada 
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
		 * M�todo que cria uma lista de filmes filtrados por uma palavra chave
		 * caso o retorno m�todo
		 * buscaTitulo da classe FilmesDAO n�o for vazil.
		 * 
		 * @return lista - retorna uma lista de filmes filtrados.
		 * @return null - caso o retorno do  m�todo buscaTitulo for vazil. 
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
				JOptionPane.showMessageDialog(null, "N�o encontrado");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();

		}
		return null;

	}

	public static List<Filme> consultaNota() {
		
		/**
		 * M�todo que ordena lista de filmes por maior nota.
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
		 * M�todo que cria uma lista de filmes ordenadas por data mais recente
		 * caso o retorno do  m�todo buscarRecente da classe FilmesDAO n�o seja null 
		 * 
		 * @return lista - retorna uma lista com filmes ordernados pela data mais recente 
		 * @return null - caso o m�todo buscarRecente retorne null.
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
		 * M�todo que busca todos os filmes onde a coluna assistido � igual a 'sim',
		 * atrav�s do m�todo buscarAssistido da classe FilmesDAO.
		 * 
		 * @return lista - retorna lista de filmes assistidos
		 * @return null - caso o m�todo buscarAssistido retorne null.
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
		 * M�todo que busca todos os filmes onde a coluna assistido � igual a 'n�o',
		 * atrav�s do m�todo buscarNaoAssistido da classe FilmesDAO.
		 * 
		 * @return lista - retorna lista de filmes n�o assistidos
		 * @return null - caso o m�todo buscarNaoAssistido retorne null.
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
		 * M�todo cria uma lista de filmes onde o valor da coluna onde_assistir
		 * for igual ao valor digitado.
		 * 
		 * @return listaServicos - retorna a lista
		 * @return null - retorna null caso n�o exista 
		 * 
		 */

		List<Filme> lista = ConsultaFilme.busca();
		List<Filme> listaServicos = new ArrayList<>();

		String servico = JOptionPane.showInputDialog("Digite o servi�o");

		for (Filme filme : lista) {
			if (filme.getOnde_assistir().equals(servico)) {
				listaServicos.add(filme);
			}
		}

		if (listaServicos.size() > 0) {

			return listaServicos;

		} else {
			JOptionPane.showMessageDialog(null, "n�o encontrado");

		}
		return null;

	}

}

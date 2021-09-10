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

	public static List<Filme> busca() {
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
		List<Filme> lista = ConsultaFilme.busca();
		Collections.sort(lista);

		return lista;
	}

	public static List<Filme> consultaRecente() {
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
		try {

			Connection connection = ConnectionFactory.getConnetion();

			FilmesDAO filmesDao = new FilmesDAO(connection);

			List<Filme> listaFilmeAssistido = new ArrayList<>();
			List<Filme> lista = filmesDao.buscar();

			for (Filme filme : lista) {
				if (filme.getAssistido().equals("sim")) {
					listaFilmeAssistido.add(filme);
				}
			}

			connection.close();

			return listaFilmeAssistido;

		} catch (SQLException e) {

			e.printStackTrace();
			e.getMessage();

		}
		return null;

	}

	public static List<Filme> consultaNaoAssistido() {
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

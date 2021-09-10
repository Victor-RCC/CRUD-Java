package br.com.fiap.cp.model;

import java.util.Collections;
import java.util.Comparator;

public class Filme implements Comparable<Filme> {
	
	/**
	 * Classe de filmes
	 * 
	 * @author Victor Rubem
	 * @version 1.0
	 * 
	 */
	
	private Long id;
	private String titulo;
	private int ano_lancamento;
	private String sinopse;
	private int nota;
	private String assistido;
	private String onde_assistir;
	

	public Filme(
		    String titulo,
			int ano_lancamento,
			String sinopse,
			int nota,
			String assistido,
			String onde_assistir
			) 
	{
		    this.titulo = titulo;
		    this.nota = nota;
			this.sinopse = sinopse;
			this.assistido = assistido;
			this.onde_assistir = onde_assistir;
			this.ano_lancamento = ano_lancamento;
	}
	
	public Filme(
			Long id,
		    String titulo,
			int ano_lancamento,
			String sinopse,
			int nota,
			String assistido,
			String onde_assistir
			) 
	{
			this.id = id;
		    this.titulo = titulo;
		    this.nota = nota;
			this.sinopse = sinopse;
			this.assistido = assistido;
			this.onde_assistir = onde_assistir;
			this.ano_lancamento = ano_lancamento;
	}
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public String getAssistido() {
		return assistido;
	}

	public void setAssistido(String assistido) {
		this.assistido = assistido;
	}

	public String getOnde_assistir() {
		return onde_assistir;
	}

	public void setOnde_assistir(String onde_assistir) {
		this.onde_assistir = onde_assistir;
	}

	@Override
	public String toString() {
		return "Filme id = " + id + ", titulo: " + titulo + ", ano_lancamento: "
	           + ano_lancamento + ", sinopse: "
			   + sinopse
			   + ", nota: " + nota + ", assistido: " + assistido + ", onde_assistir: "
			   + onde_assistir + "\n";
	}
	
	@Override
	public int compareTo(Filme o) {
		
		/**
		 * Método para comparar objetos filme a partir da sua nota
		 * 
		 * @return 1, -1, 0 
		 * 
		 */
		
		if(this.nota < o.getNota()) {
			return 1;
		}
		
		if(this.nota > o.getNota()) {
			return -1;
	}return 0;
 }
	 
	
}



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


import br.com.fiap.cp.CadastroFilme;
import br.com.fiap.cp.ConsultaFilme;
import br.com.fiap.cp.ExclusaoFilme;
import br.com.fiap.cp.dao.FilmesDAO;
import br.com.fiap.cp.model.Filme;

public class App extends JFrame implements ActionListener  {
	
	private List<Filme> listaFilmes = new ArrayList<Filme>();
	
	private JTextArea textLista = new JTextArea();
	private JPanel  painelBotoes = new JPanel();
	private JButton apagar = new JButton("apagar");
	private JButton cadastrar = new JButton("cadastrar");
	private JButton consultaTitulo = new JButton("consulta Título");
	private JButton consultaNota = new JButton("consulta nota");
	private JButton consultaRecente = new JButton("consulta Recente");
	private JButton consultaNaoAssistidos = new JButton("consulta não assistidos");
	private JButton consultaAssistidos = new JButton("consulta assistidos");
	private JButton consultaServicos = new JButton("consulta Serviços");
	private JLabel  qtd_filmes = new JLabel("Total = ");
	
	
	

	
	public static void main(String[] args) {
		new App();
	}
	
	public App() {
		init();
		configure();
	}

	private void configure() {
		
		painelBotoes.setPreferredSize(new Dimension(200,600));
		painelBotoes.add(apagar);
		painelBotoes.add(consultaTitulo);
		painelBotoes.add(consultaNota);
		painelBotoes.add(consultaRecente);
		painelBotoes.add(consultaNaoAssistidos);
		painelBotoes.add(consultaAssistidos);
		painelBotoes.add(consultaServicos);
		painelBotoes.add(consultaTitulo);
		
		add(cadastrar, BorderLayout.NORTH);
		add(painelBotoes, BorderLayout.WEST);
		add(qtd_filmes, BorderLayout.SOUTH);
		add(textLista);
		
		cadastrar.addActionListener(this);
		apagar.addActionListener(this);
		consultaTitulo.addActionListener(this);
		consultaNota.addActionListener(this);
		consultaRecente.addActionListener(this);
		consultaNaoAssistidos.addActionListener(this);
		consultaAssistidos.addActionListener(this);
		consultaServicos.addActionListener(this);
		
	}

	private void init() {
		update();
		
		
		setSize(600,600);
		setVisible(true);
		setTitle("Filmes");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private void update() {
		
		listaFilmes = ConsultaFilme.busca();
		
		textLista.setText(listaFilmes.toString());
		qtd_filmes.setText("Total: " + listaFilmes.size());
		
		boolean situacaoBotao = listaFilmes.size() > 0;
//		apagar.setEnabled(situacaoBotao);
		consultaTitulo.setEnabled(situacaoBotao);
		consultaNota.setEnabled(situacaoBotao);
		consultaRecente.setEnabled(situacaoBotao);
		consultaNaoAssistidos.setEnabled(situacaoBotao);
		consultaAssistidos.setEnabled(situacaoBotao);
		consultaServicos.setEnabled(situacaoBotao);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == cadastrar) {
			new CadastroFilme();
			update();
		}
		if(e.getSource() == apagar) {
			new ExclusaoFilme();
			update();
		}
		
		if(e.getSource() == consultaTitulo) {
			listaFilmes = ConsultaFilme.consultaTitulo();
			textLista.setText(listaFilmes.toString());
		}
		
		
		if(e.getSource() == consultaNota) {
			listaFilmes = ConsultaFilme.consultaNota();
			textLista.setText(listaFilmes.toString());
		}	
		
		if(e.getSource() == consultaRecente) {
			listaFilmes = ConsultaFilme.consultaRecente();
			textLista.setText(listaFilmes.toString());
	  }
		
		if(e.getSource() == consultaAssistidos) {
			listaFilmes = ConsultaFilme.consultaAssistido();
			textLista.setText(listaFilmes.toString());
		
		}			
		if(e.getSource() == consultaNaoAssistidos) {
			listaFilmes = ConsultaFilme.consultaNaoAssistido();
			textLista.setText(listaFilmes.toString());
		}
		
		if(e.getSource() == consultaServicos) {
			listaFilmes = ConsultaFilme.consultaServico();
			textLista.setText(listaFilmes.toString());
		}
	}

}

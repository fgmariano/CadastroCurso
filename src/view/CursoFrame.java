package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import control.CursoControl;
import model.Curso;

public class CursoFrame implements ActionListener {
	
	private JFrame frame = new JFrame("Cadastro de Cursos");
	private JPanel panPrincipal = new JPanel(new BorderLayout());
	private JPanel panTxt = new JPanel(new GridLayout(6, 2));
	private JPanel panBotoes = new JPanel();
	private JScrollPane panTabela = new JScrollPane();
	private JTextField txtId = new JTextField();
	private JTextField txtNome = new JTextField();
	private JTextField txtDescricao = new JTextField();
	private JTextField txtInicio = new JTextField();
	private JTextField txtTermino = new JTextField();
	private JButton salvar = new JButton("Salvar");
	private JButton excluir = new JButton("Excluir");
	private CursoControl control = new CursoControl();
	private JTable tabela = new JTable( control );
	private JRadioButton verdadeiro = new JRadioButton("Ativo", false);
	private JRadioButton falso = new JRadioButton("Inativo", false);
	
	public CursoFrame() {
		panTxt.add(new JLabel("Id"));
		panTxt.add(txtId);
		panTxt.add(new JLabel("Nome"));
		panTxt.add(txtNome);
		panTxt.add(new JLabel("Descricao"));
		panTxt.add(txtDescricao);
		panTxt.add(new JLabel("Horario Inicio"));
		panTxt.add(txtInicio);
		panTxt.add(new JLabel("Horario Termino"));
		panTxt.add(txtTermino);
		panTxt.add(verdadeiro);
		panTxt.add(falso);
		
		panBotoes.add(salvar);
		panBotoes.add(excluir);
		
		panTabela.add( tabela );
		
		panPrincipal.add(panTxt, BorderLayout.NORTH);
		panPrincipal.add(panTabela, BorderLayout.CENTER);
		panPrincipal.add(panBotoes, BorderLayout.SOUTH);
		
		
		
		salvar.addActionListener( this );
		excluir.addActionListener( this );
		
		frame.setContentPane( panPrincipal );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setVisible( true );
	}
	
	public static void main(String[] args) {
		new CursoFrame();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Salvar")) {
			control.adicionar( formToCurso() );
		} else if (cmd.equals("Excluir")) {
			control.remover( Long.parseLong(txtId.getText()) );
		}
	}
	
	public Curso formToCurso() {
		Curso c = new Curso();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			c.setId( Long.parseLong(txtId.getText()));
			c.setNome(txtNome.getText());
			c.setDescricao(txtDescricao.getText());
			c.setHorarioInicio( sdf.parse(txtInicio.getText()) );
			c.setHorarioTermino( sdf.parse(txtTermino.getText() ));
			if (verdadeiro.isSelected()) {
				c.setAtivo( true );
			} else if (falso.isSelected()) {
				c.setAtivo( false );
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return c;
	}
	
}

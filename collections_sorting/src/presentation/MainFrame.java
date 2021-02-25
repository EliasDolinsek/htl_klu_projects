package presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import htlklu.sorting.Country;

import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	private ArrayList<Country> countries = new ArrayList<>();
	private CountryTabelModel tabelModel;
	
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton btnNewButton;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initComponents();
	}
	
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		setupCountriesModel();
		table = new JTable();
		table.setModel(tabelModel);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}
	
	private void setupCountriesModel() {
        countries.add(new Country("Österreich", "Wien", 8504850, 838790));
        countries.add(new Country("Guatemala", "Ligonha", 3311, 8387));
        countries.add(new Country("India", "Faizabad", 153047, 83877));
        countries.add(new Country("China", "Hulan Ergi", 277672, 83870));
        countries.add(new Country("Mauritania", "Kiffa", 73930, 8387912));
        countries.add(new Country("Deutschland", "Berlin", 3769000, 838));
        countries.add(new Country("Italien", "Rom", 2873000, 83875));
        
        tabelModel = new CountryTabelModel(countries);
	}

}

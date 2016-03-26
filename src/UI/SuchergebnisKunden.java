package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Gasflasche;
import Model.Kunde;

import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class SuchergebnisKunden extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7669470156049500576L;
	private JTable table;
	private ArrayList<Kunde> kunden;
	private DefaultTableModel table_model;
	private GasflaschenVerwaltung mainFrame;
	/**
	 * Create the panel.
	 */
	public SuchergebnisKunden(ArrayList<Kunde> kunden, GasflaschenVerwaltung frame) {
		this.mainFrame = frame;
		this.kunden = kunden;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{300, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table_model = new DefaultTableModel();
		
		table_model.addColumn("Kundennummer");
		
		table_model.addColumn("Name");
		
		table_model.addColumn("Ansprechpartner");
		
		table_model.addColumn("Telefon");
		
		for(int i = 0; i<kunden.size(); i++){
			table_model.addRow(new Object[] {
											this.kunden.get(i).getKundenNummer(),
											this.kunden.get(i).getName(),
											this.kunden.get(i).getAnsprechpartner(),
											this.kunden.get(i).getTelefon()
											});
		}
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		table = new JTable(table_model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		add(panel, gbc_panel);
		
		JButton btnAnzeigen = new JButton("Anzeigen");
		btnAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showKunde();
			}
		});
		panel.add(btnAnzeigen);

	}
	
	//Wenn das Panel schon einmal aufgerufen wurde muss ein Neues Suchergebnis angezeigt werden
	public void newSearch(ArrayList<Kunde> list){
		this.kunden = list;
		for(int i = 0; i<kunden.size(); i++){
			table_model.addRow(new Object[] {
					this.kunden.get(i).getKundenNummer(),
					this.kunden.get(i).getName(),
					this.kunden.get(i).getAnsprechpartner(),
					this.kunden.get(i).getTelefon()
					});
		}
	}
	
	//Wechsel zum KundenDetails-Panel wird initiiert.
	public void showKunde(){
		int indexOfSelectedRow = this.table.getSelectedRow();
		this.mainFrame.changeToKunde(false, this.kunden.get(indexOfSelectedRow));
	}
	
	//Wenn das Panel verlassen wird, wird die Tabelle geleert
	public void clearSuche(){
		this.kunden = null;
		if (this.table_model.getRowCount() > 0) {
		    for (int i = this.table_model.getRowCount() - 1; i > -1; i--) {
		    	this.table_model.removeRow(i);
		    }
		}
	}

}

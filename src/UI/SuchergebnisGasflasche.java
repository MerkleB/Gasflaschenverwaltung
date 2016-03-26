package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Model.Gasflasche;
import Model.Kunde;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

public class SuchergebnisGasflasche extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7182267763023944017L;
	private ArrayList<Gasflasche> gasflaschen;
	private DefaultTableModel table_model;
	private GasflaschenVerwaltung mainFrame;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public SuchergebnisGasflasche(ArrayList<Gasflasche> flaschen, GasflaschenVerwaltung frame) {
		this.gasflaschen = flaschen;
		this.mainFrame = frame;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[]{266, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		table_model = new DefaultTableModel();
		
		table_model.addColumn("Flaschennummer");
		
		table_model.addColumn("Art");
		
		table_model.addColumn("Charge");
		
		for(int i = 0; i<gasflaschen.size(); i++){
			table_model.addRow(new Object[] {
											this.gasflaschen.get(i).getFlaschenNummer(),
											this.gasflaschen.get(i).getArt(),
											this.gasflaschen.get(i).getCharge()
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
				showGasflasche();
			}
		});
		panel.add(btnAnzeigen);

	}
	
	//Wenn das Panel schon einmal aufgerufen wurde muss ein Neues Suchergebnis angezeigt werden
	public void newSearch(ArrayList<Gasflasche> list){
		this.gasflaschen = list;
		for(int i = 0; i<gasflaschen.size(); i++){
			table_model.addRow(new Object[] {
											this.gasflaschen.get(i).getFlaschenNummer(),
											this.gasflaschen.get(i).getArt(),
											this.gasflaschen.get(i).getCharge()
											});
		}
	}
	
	//Wechsel zum GasflaschenDetails-Panel wird initiiert. 
	public void showGasflasche(){
		int indexOfSelectedRow = this.table.getSelectedRow();
		this.mainFrame.changeToGasflasche(false, this.gasflaschen.get(indexOfSelectedRow));
	}
	
	//Wenn das Panel verlassen wird, wird die Tabelle geleert
	public void clearSuche(){
		this.gasflaschen = null;
		if (this.table_model.getRowCount() > 0) {
		    for (int i = this.table_model.getRowCount() - 1; i > -1; i--) {
		    	this.table_model.removeRow(i);
		    }
		}
	}

}

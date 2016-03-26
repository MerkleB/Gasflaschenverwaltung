package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Model.Gasflasche;
import Model.Kunde;

import java.awt.Component;

public class Suchfenster extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5281897011775607489L;
	private GasflaschenVerwaltung mainFrame;
	private JTextField textFlaschennummer;
	private JTextField textKundennummer;
	private JTextField textCharge;
	private JTextField textKundeNr;
	private JTextField textKundeName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnGasflasche;
	private JRadioButton rdbtnKunde;

	/**
	 * Create the panel.
	 */
	public Suchfenster(GasflaschenVerwaltung frame) {
		this.mainFrame = frame;
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		rdbtnGasflasche = new JRadioButton("Gasflasche");
		buttonGroup.add(rdbtnGasflasche);
		GridBagConstraints gbc_rdbtnGasflasche = new GridBagConstraints();
		gbc_rdbtnGasflasche.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnGasflasche.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnGasflasche.gridx = 0;
		gbc_rdbtnGasflasche.gridy = 1;
		panel.add(rdbtnGasflasche, gbc_rdbtnGasflasche);
		
		rdbtnGasflasche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				radioButtonChanged();
			}
		});
		
		rdbtnKunde = new JRadioButton("Kunde");
		buttonGroup.add(rdbtnKunde);
		GridBagConstraints gbc_rdbtnKunde = new GridBagConstraints();
		gbc_rdbtnKunde.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnKunde.anchor = GridBagConstraints.WEST;
		gbc_rdbtnKunde.gridx = 0;
		gbc_rdbtnKunde.gridy = 5;
		panel.add(rdbtnKunde, gbc_rdbtnKunde);
		
		rdbtnKunde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				radioButtonChanged();
			}
		});
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 210, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblFlaschennummer = new JLabel("Flaschennummer");
		GridBagConstraints gbc_lblFlaschennummer = new GridBagConstraints();
		gbc_lblFlaschennummer.anchor = GridBagConstraints.EAST;
		gbc_lblFlaschennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlaschennummer.gridx = 0;
		gbc_lblFlaschennummer.gridy = 2;
		panel_2.add(lblFlaschennummer, gbc_lblFlaschennummer);
		
		textFlaschennummer = new JTextField();
		textFlaschennummer.setEditable(false);
		GridBagConstraints gbc_textFlaschennummer = new GridBagConstraints();
		gbc_textFlaschennummer.insets = new Insets(0, 0, 5, 0);
		gbc_textFlaschennummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFlaschennummer.gridx = 2;
		gbc_textFlaschennummer.gridy = 2;
		panel_2.add(textFlaschennummer, gbc_textFlaschennummer);
		textFlaschennummer.setColumns(10);
		
		JLabel lblKunde = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblKunde = new GridBagConstraints();
		gbc_lblKunde.anchor = GridBagConstraints.EAST;
		gbc_lblKunde.insets = new Insets(0, 0, 5, 5);
		gbc_lblKunde.gridx = 0;
		gbc_lblKunde.gridy = 3;
		panel_2.add(lblKunde, gbc_lblKunde);
		
		textKundennummer = new JTextField();
		textKundennummer.setEditable(false);
		GridBagConstraints gbc_textKundennummer = new GridBagConstraints();
		gbc_textKundennummer.insets = new Insets(0, 0, 5, 0);
		gbc_textKundennummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKundennummer.gridx = 2;
		gbc_textKundennummer.gridy = 3;
		panel_2.add(textKundennummer, gbc_textKundennummer);
		textKundennummer.setColumns(10);
		
		JLabel lblCharge = new JLabel("Charge");
		GridBagConstraints gbc_lblCharge = new GridBagConstraints();
		gbc_lblCharge.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharge.anchor = GridBagConstraints.EAST;
		gbc_lblCharge.gridx = 0;
		gbc_lblCharge.gridy = 4;
		panel_2.add(lblCharge, gbc_lblCharge);
		
		textCharge = new JTextField();
		textCharge.setEditable(false);
		GridBagConstraints gbc_textCharge = new GridBagConstraints();
		gbc_textCharge.insets = new Insets(0, 0, 5, 0);
		gbc_textCharge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCharge.gridx = 2;
		gbc_textCharge.gridy = 4;
		panel_2.add(textCharge, gbc_textCharge);
		textCharge.setColumns(10);
		
		JLabel lblKundennummer = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblKundennummer = new GridBagConstraints();
		gbc_lblKundennummer.anchor = GridBagConstraints.EAST;
		gbc_lblKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennummer.gridx = 0;
		gbc_lblKundennummer.gridy = 6;
		panel_2.add(lblKundennummer, gbc_lblKundennummer);
		
		textKundeNr = new JTextField();
		textKundeNr.setEditable(false);
		GridBagConstraints gbc_textKundeNr = new GridBagConstraints();
		gbc_textKundeNr.insets = new Insets(0, 0, 5, 0);
		gbc_textKundeNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKundeNr.gridx = 2;
		gbc_textKundeNr.gridy = 6;
		panel_2.add(textKundeNr, gbc_textKundeNr);
		textKundeNr.setColumns(10);
		
		JLabel lblKundenname = new JLabel("Kunde");
		GridBagConstraints gbc_lblKundenname = new GridBagConstraints();
		gbc_lblKundenname.anchor = GridBagConstraints.EAST;
		gbc_lblKundenname.insets = new Insets(0, 0, 0, 5);
		gbc_lblKundenname.gridx = 0;
		gbc_lblKundenname.gridy = 7;
		panel_2.add(lblKundenname, gbc_lblKundenname);
		
		textKundeName = new JTextField();
		textKundeName.setEditable(false);
		GridBagConstraints gbc_textKundeName = new GridBagConstraints();
		gbc_textKundeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKundeName.gridx = 2;
		gbc_textKundeName.gridy = 7;
		panel_2.add(textKundeName, gbc_textKundeName);
		textKundeName.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JButton btnSuchen = new JButton("Suchen");
		GridBagConstraints gbc_btnSuchen = new GridBagConstraints();
		gbc_btnSuchen.gridx = 9;
		gbc_btnSuchen.gridy = 0;
		panel_3.add(btnSuchen, gbc_btnSuchen);
		
		btnSuchen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performSuchen();
			}
		});
		
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblKunde, textFlaschennummer, textKundennummer, textCharge, textKundeNr, textKundeName, btnSuchen, lblFlaschennummer, lblCharge, lblKundennummer, lblKundenname, panel_2}));
		
	}

	private void radioButtonChanged(){ //Wenn ein RadioButton angeklickt wurde werden die zugehörigen Felder editierbar gemacht
		if(this.rdbtnGasflasche.isSelected()){
			System.out.println("Gasflaschen suchen");
			this.textFlaschennummer.setEditable(true);
			this.textKundennummer.setEditable(true);
			this.textCharge.setEditable(true);
			
			this.textKundeNr.setEditable(false);
			this.textKundeName.setEditable(false);
		}
		if(this.rdbtnKunde.isSelected()){
			System.out.println("Kunden suchen");
			this.textKundeNr.setEditable(true);
			this.textKundeName.setEditable(true);
			
			this.textFlaschennummer.setEditable(false);
			this.textKundennummer.setEditable(false);
			this.textCharge.setEditable(false);
		}
		
	}
	
	private void performSuchen(){ //Je nachdem welcher RadioButton aktiv ist, wird im Rahmenprogramm (GasflaschenVerwaltung mainFrame) das Suchergebnis der Gasflaschen oder der Kunden gerufen
		if(this.rdbtnGasflasche.isSelected()){
			ArrayList<Gasflasche> listOfGasflaschen = this.mainFrame.getDB_Handler()
							.getBottle(this.textFlaschennummer.getText(), 
										this.textKundennummer.getText(), 
										this.textCharge.getText());
			this.mainFrame.changeToSuchergebnisGasflaschen(listOfGasflaschen);
		}
		if(this.rdbtnKunde.isSelected()){
			ArrayList<Kunde> listOfKunden = this.mainFrame.getDB_Handler()
							.getCustomer(this.textKundeNr.getText(), 
										  this.textKundeName.getText());
			this.mainFrame.changeToSuchergebnisKunden(listOfKunden);
		}
	}
}

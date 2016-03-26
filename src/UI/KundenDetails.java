package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import Database.DatabaseActionHandler;
import Model.Kunde;

import java.awt.Component;

public class KundenDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2094999367456515366L;
	private JTable table;
	private JPanel panel;
	private JLabel lblKdnNr; 
	private JTextField textName;
	private JTextField textEmail;
	private JTextField textTelefon;
	private JTextField textFax;
	private JTextField textOrt;
	private JTextField textPLZ;
	private JTextField textAnsprechpartner;
	private JTextField textStrasse;
	private JTextField textLand;
	private JButton btnBearbeiten;
	private JButton btnAbbrechen;
	private Kunde kunde;
	private GasflaschenVerwaltung mainFrame;
	private boolean CreateMode; 

	/**
	 * Create the panel.
	 */
 	public KundenDetails(Kunde kunde, GasflaschenVerwaltung mainFrame, boolean create) {
 		this.CreateMode = create;
 		this.kunde = kunde;
 		this.mainFrame = mainFrame;
 		
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);
		
		panel = new JPanel();
		splitPane.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblKundennummer = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblKundennummer = new GridBagConstraints();
		gbc_lblKundennummer.anchor = GridBagConstraints.EAST;
		gbc_lblKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblKundennummer.gridx = 0;
		gbc_lblKundennummer.gridy = 0;
		panel.add(lblKundennummer, gbc_lblKundennummer);
		
		lblKdnNr = new JLabel(this.kunde.getKundenNummer());
		GridBagConstraints gbc_lblKdnNr = new GridBagConstraints();
		gbc_lblKdnNr.anchor = GridBagConstraints.WEST;
		gbc_lblKdnNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblKdnNr.gridx = 1;
		gbc_lblKdnNr.gridy = 0;
		panel.add(lblKdnNr, gbc_lblKdnNr);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		panel.add(lblName, gbc_lblName);
		
		textName = new JTextField();
		textName.setEditable(false);
		GridBagConstraints gbc_textName = new GridBagConstraints();
		gbc_textName.insets = new Insets(0, 0, 5, 5);
		gbc_textName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textName.gridx = 1;
		gbc_textName.gridy = 1;
		panel.add(textName, gbc_textName);
		textName.setColumns(5);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		panel.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 5);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 2;
		panel.add(textEmail, gbc_textEmail);
		textEmail.setColumns(5);
		
		JLabel lblTelNr = new JLabel("Telefon");
		GridBagConstraints gbc_lblTelNr = new GridBagConstraints();
		gbc_lblTelNr.anchor = GridBagConstraints.EAST;
		gbc_lblTelNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelNr.gridx = 2;
		gbc_lblTelNr.gridy = 2;
		panel.add(lblTelNr, gbc_lblTelNr);
		
		textTelefon = new JTextField();
		textTelefon.setEditable(false);
		GridBagConstraints gbc_textTelefon = new GridBagConstraints();
		gbc_textTelefon.insets = new Insets(0, 0, 5, 0);
		gbc_textTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelefon.gridx = 3;
		gbc_textTelefon.gridy = 2;
		panel.add(textTelefon, gbc_textTelefon);
		textTelefon.setColumns(5);
		
		JLabel lblFax = new JLabel("Fax");
		GridBagConstraints gbc_lblFax = new GridBagConstraints();
		gbc_lblFax.anchor = GridBagConstraints.EAST;
		gbc_lblFax.insets = new Insets(0, 0, 5, 5);
		gbc_lblFax.gridx = 0;
		gbc_lblFax.gridy = 4;
		panel.add(lblFax, gbc_lblFax);
		
		textFax = new JTextField();
		textFax.setEditable(false);
		GridBagConstraints gbc_textFax = new GridBagConstraints();
		gbc_textFax.insets = new Insets(0, 0, 5, 5);
		gbc_textFax.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFax.gridx = 1;
		gbc_textFax.gridy = 4;
		panel.add(textFax, gbc_textFax);
		textFax.setColumns(5);
		textFax.setColumns(5);
		
		JLabel lblAnsprechpartner = new JLabel("Ansprechpartner");
		GridBagConstraints gbc_lblAnsprechpartner = new GridBagConstraints();
		gbc_lblAnsprechpartner.anchor = GridBagConstraints.EAST;
		gbc_lblAnsprechpartner.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnsprechpartner.gridx = 2;
		gbc_lblAnsprechpartner.gridy = 4;
		panel.add(lblAnsprechpartner, gbc_lblAnsprechpartner);
		
		textAnsprechpartner = new JTextField();
		textAnsprechpartner.setEditable(false);
		GridBagConstraints gbc_textAnsprechpartner = new GridBagConstraints();
		gbc_textAnsprechpartner.insets = new Insets(0, 0, 5, 0);
		gbc_textAnsprechpartner.fill = GridBagConstraints.HORIZONTAL;
		gbc_textAnsprechpartner.gridx = 3;
		gbc_textAnsprechpartner.gridy = 4;
		panel.add(textAnsprechpartner, gbc_textAnsprechpartner);
		textAnsprechpartner.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.anchor = GridBagConstraints.EAST;
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 0;
		gbc_lblOrt.gridy = 5;
		panel.add(lblOrt, gbc_lblOrt);
		
		textOrt = new JTextField();
		textOrt.setEditable(false);
		GridBagConstraints gbc_textOrt = new GridBagConstraints();
		gbc_textOrt.insets = new Insets(0, 0, 5, 5);
		gbc_textOrt.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOrt.gridx = 1;
		gbc_textOrt.gridy = 5;
		panel.add(textOrt, gbc_textOrt);
		textOrt.setColumns(5);
		
		JLabel lblPlz = new JLabel("PLZ");
		GridBagConstraints gbc_lblPlz = new GridBagConstraints();
		gbc_lblPlz.anchor = GridBagConstraints.EAST;
		gbc_lblPlz.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlz.gridx = 2;
		gbc_lblPlz.gridy = 5;
		panel.add(lblPlz, gbc_lblPlz);
		
		textPLZ = new JTextField();
		textPLZ.setEditable(false);
		GridBagConstraints gbc_textPLZ = new GridBagConstraints();
		gbc_textPLZ.insets = new Insets(0, 0, 5, 0);
		gbc_textPLZ.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPLZ.gridx = 3;
		gbc_textPLZ.gridy = 5;
		panel.add(textPLZ, gbc_textPLZ);
		
		JLabel lblStrae = new JLabel("Stra\u00DFe");
		GridBagConstraints gbc_lblStrae = new GridBagConstraints();
		gbc_lblStrae.anchor = GridBagConstraints.EAST;
		gbc_lblStrae.insets = new Insets(0, 0, 5, 5);
		gbc_lblStrae.gridx = 0;
		gbc_lblStrae.gridy = 6;
		panel.add(lblStrae, gbc_lblStrae);
		
		textStrasse = new JTextField();
		textStrasse.setEditable(false);
		GridBagConstraints gbc_textStrasse = new GridBagConstraints();
		gbc_textStrasse.insets = new Insets(0, 0, 5, 5);
		gbc_textStrasse.fill = GridBagConstraints.HORIZONTAL;
		gbc_textStrasse.gridx = 1;
		gbc_textStrasse.gridy = 6;
		panel.add(textStrasse, gbc_textStrasse);
		textStrasse.setColumns(10);
		
		JLabel lblLand = new JLabel("Land");
		GridBagConstraints gbc_lblLand = new GridBagConstraints();
		gbc_lblLand.anchor = GridBagConstraints.EAST;
		gbc_lblLand.insets = new Insets(0, 0, 5, 5);
		gbc_lblLand.gridx = 0;
		gbc_lblLand.gridy = 7;
		panel.add(lblLand, gbc_lblLand);
		
		textLand = new JTextField();
		textLand.setEditable(false);
		GridBagConstraints gbc_textLand = new GridBagConstraints();
		gbc_textLand.insets = new Insets(0, 0, 5, 5);
		gbc_textLand.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLand.gridx = 1;
		gbc_textLand.gridy = 7;
		panel.add(textLand, gbc_textLand);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 8;
		panel.add(panel_1, gbc_panel_1);
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setVisible(false);
		panel_1.add(btnAbbrechen);
		
		btnAbbrechen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleAbbrechenWasClicked();
			}
		});
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 3;
		gbc_panel_2.gridy = 8;
		panel.add(panel_2, gbc_panel_2);
		
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleBearbeitenWasClicked();
			}
		});
		panel_2.add(btnBearbeiten);
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblKdnNr, textName, textEmail, lblTelNr, textTelefon, textFax, textAnsprechpartner, textOrt, textPLZ, textStrasse, textLand, btnAbbrechen, btnBearbeiten, lblKundennummer, lblName, lblEmail, lblFax, lblAnsprechpartner, lblOrt, lblPlz, lblStrae, lblLand, panel_1, panel_2}));
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		System.out.println("KundenDetails: Costructor");
		this.setFields();
		
		if(this.CreateMode){ //Wenn dieses Panel geoeffnet wurde um einen Kunden anzulegen, dann gehe in den Edit Modus
			this.changeToEditMode();
		}else this.setFieldsEditable(false);
	}
 	
 	//Anzuzeigender Kunde wird geändert wenn das Panel erneut angezeigt wird
 	public void changeDisplayedKunde(Kunde kunde, boolean createMode){
 		this.CreateMode = createMode;
 		this.kunde = kunde;
 		System.out.println("KundenDetails: changeDisplayedKunde");
 		this.setFields();
 		if(this.CreateMode){
 			this.changeToEditMode();
 		}
 	}
 	
 	//Felder werden gesetzt
 	private void setFields(){
 		this.setFieldsEditable(true);
 		this.lblKdnNr.setText(this.kunde.getKundenNummer());
 		this.textName.setText(this.kunde.getName());
 		this.textEmail.setText(this.kunde.getEMail());
 		this.textTelefon.setText(this.kunde.getTelefon());
 		this.textFax.setText(this.kunde.getFax());
 		this.textAnsprechpartner.setText(this.kunde.getAnsprechpartner());
 		this.textLand.setText(this.kunde.getLand());
 		this.textOrt.setText(this.kunde.getOrt());
 		this.textPLZ.setText(this.kunde.getPLZ());
 		this.textStrasse.setText(this.kunde.getStrasse());
 		
 		System.out.println("Nach setField ist die KundenNummer: "+this.lblKdnNr.getText());
 	}

 	//Wenn Bearbeiten geklickt wurde wechseln wir in den Edit-Mode
 	//Der Bearbeiten-Button wird zum Save-Button 
	private void handleBearbeitenWasClicked(){
		if(btnBearbeiten.getText().equals("Bearbeiten")){
			this.changeToEditMode();
		}else handleButtonSaveWasClicked();
	}
	
	//Beim Klick auf Abbrechen werden alle Felder zurück gesetzt
	//Save wird zu Bearbeiten und Abbrechen wird wieder unsichtbar
	private void handleAbbrechenWasClicked(){
		this.btnAbbrechen.setVisible(false);
		this.btnBearbeiten.setText("Bearbeiten");
		this.setFields();
		this.setFieldsEditable(false);
	}
	
	//Wechsel zum Edit-Mode
	private void changeToEditMode(){
		this.btnBearbeiten.setText("Save");
		this.setFieldsEditable(true);
	}
	
	//Felder werden Editierbar
	//Abbrechen wird sichtbar
	private void setFieldsEditable(boolean editable){
		this.btnAbbrechen.setEnabled(editable);
		this.btnAbbrechen.setVisible(editable);
		this.textName.setEditable(editable);
		this.textEmail.setEditable(editable);
		this.textTelefon.setEditable(editable);
		this.textFax.setEditable(editable);
		this.textAnsprechpartner.setEditable(editable);
		this.textOrt.setEditable(editable);
		this.textPLZ.setEditable(editable);
		this.textStrasse.setEditable(editable);
		this.textLand.setEditable(editable);
	}
	
	//Wenn der Save-Button gedrückt wurde, dann wird der Inhalt der Felder in das Kundenobjekt geladen 
		//anschließend wird es zum Datenbank-Aktionsbehandler geschickt. 
		//je nachdem in welchem Modus wir und befinden wird entweder eine vorhandene Flasche geändert oder eine neue angelegt
		//Im zweiten Falle verlassen wir anschließend den create Modus.
		//In  beiden Fällen wechseln wir in den Display-Modus
	private void handleButtonSaveWasClicked(){
		this.kunde.setKundenNummer(this.lblKdnNr.getText());
		this.kunde.setEMail(this.textEmail.getText());
		this.kunde.setTelefon(this.textTelefon.getText());
		this.kunde.setFax(this.textFax.getText());
		this.kunde.setAnsprechpartner(this.textAnsprechpartner.getText());
		this.kunde.setName(this.textName.getText());
		this.kunde.setOrt(this.textOrt.getText());
		this.kunde.setPLZ(this.textPLZ.getText());
		this.kunde.setStrasse(this.textStrasse.getText());
		this.kunde.setLand(this.textLand.getText());
		
		if(CreateMode){
			this.changeDisplayedKunde(this.mainFrame.getDB_Handler().createCustomer(this.kunde), false);
		}else this.mainFrame.getDB_Handler().changeCustomer(this.kunde);
		//Gehe in Display Modus
		this.setFieldsEditable(false);
		this.btnAbbrechen.setVisible(false);
		this.btnBearbeiten.setText("Bearbeiten");
	}
	
}

package UI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Database.DatabaseActionHandler;
import Model.Gasflasche;
import Model.Kunde;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class GasflaschenDetails extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4004918254295902053L;
	private JLabel lblNr;
	private JTextField textCharge;
	private JTextField textKundennummer;
	private JTextField textFuellmenge;
	private JTextField textGewicht;
	private JTextField textLebensmitteleignung;
	private JTextField textFuellstatus;
	private JTextField textTuevdatum;
	private JCheckBox chckbxPfand;
	private JCheckBox chckbxRestdruckventil;
	private JComboBox<String> cbArt;
	private JButton btnBearbeiten;
	private JButton btnAbbrechen;
	private Gasflasche gasflasche;
	private GasflaschenVerwaltung mainFrame;
	private boolean CreateMode; 
	private JLabel lblGasArt;
	private JComboBox<String> cbGasArt;

	/**
	 * Create the panel.
	 */
	public GasflaschenDetails(Gasflasche gasflasche, GasflaschenVerwaltung mainFrame, boolean create) {
		this.gasflasche = gasflasche;
		this.mainFrame = mainFrame;
		this.CreateMode = create;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{98, 0, 102, 0, 74, 111, 0};
		gbl_panel.rowHeights = new int[]{31, 14, 20, 23, 20, 20, 23, 20, 31, 62, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		JLabel lblFlaschennummer = new JLabel("Flaschennummer");
		GridBagConstraints gbc_lblFlaschennummer = new GridBagConstraints();
		gbc_lblFlaschennummer.anchor = GridBagConstraints.NORTH;
		gbc_lblFlaschennummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFlaschennummer.insets = new Insets(0, 0, 5, 5);
		gbc_lblFlaschennummer.gridx = 0;
		gbc_lblFlaschennummer.gridy = 1;
		panel.add(lblFlaschennummer, gbc_lblFlaschennummer);
		
		lblNr = new JLabel("");
		GridBagConstraints gbc_lblNr = new GridBagConstraints();
		gbc_lblNr.anchor = GridBagConstraints.NORTH;
		gbc_lblNr.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNr.insets = new Insets(0, 0, 5, 5);
		gbc_lblNr.gridx = 2;
		gbc_lblNr.gridy = 1;
		panel.add(lblNr, gbc_lblNr);
		
		JLabel lblArt = new JLabel("Art");
		GridBagConstraints gbc_lblArt = new GridBagConstraints();
		gbc_lblArt.anchor = GridBagConstraints.EAST;
		gbc_lblArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblArt.gridx = 0;
		gbc_lblArt.gridy = 2;
		panel.add(lblArt, gbc_lblArt);
		
		cbArt = new JComboBox<String>();
		cbArt.setModel(new DefaultComboBoxModel<String>(new String[] {"Kohlens\u00E4ure", "Propan", "Sauerstoff"}));
		GridBagConstraints gbc_cbArt = new GridBagConstraints();
		gbc_cbArt.anchor = GridBagConstraints.NORTH;
		gbc_cbArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbArt.insets = new Insets(0, 0, 5, 5);
		gbc_cbArt.gridx = 2;
		gbc_cbArt.gridy = 2;
		panel.add(cbArt, gbc_cbArt);
		
		cbArt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleArtHasChanged();
			}
		});
		
		JLabel lblNewLabel = new JLabel("Kundennummer");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		textKundennummer = new JTextField();
		textKundennummer.setEditable(false);
		GridBagConstraints gbc_textKundennummer = new GridBagConstraints();
		gbc_textKundennummer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKundennummer.insets = new Insets(0, 0, 5, 5);
		gbc_textKundennummer.gridx = 2;
		gbc_textKundennummer.gridy = 3;
		panel.add(textKundennummer, gbc_textKundennummer);
		textKundennummer.setColumns(10);
		
		chckbxPfand = new JCheckBox("Pfand");
		chckbxPfand.setEnabled(false);
		GridBagConstraints gbc_chckbxPfand = new GridBagConstraints();
		gbc_chckbxPfand.anchor = GridBagConstraints.NORTHEAST;
		gbc_chckbxPfand.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxPfand.gridx = 4;
		gbc_chckbxPfand.gridy = 3;
		panel.add(chckbxPfand, gbc_chckbxPfand);
		
		JLabel lblGewicht = new JLabel("Gewicht");
		GridBagConstraints gbc_lblGewicht = new GridBagConstraints();
		gbc_lblGewicht.anchor = GridBagConstraints.EAST;
		gbc_lblGewicht.insets = new Insets(0, 0, 5, 5);
		gbc_lblGewicht.gridx = 0;
		gbc_lblGewicht.gridy = 4;
		panel.add(lblGewicht, gbc_lblGewicht);
		
		textGewicht = new JTextField();
		textGewicht.setEditable(false);
		GridBagConstraints gbc_textGewicht = new GridBagConstraints();
		gbc_textGewicht.anchor = GridBagConstraints.NORTH;
		gbc_textGewicht.fill = GridBagConstraints.HORIZONTAL;
		gbc_textGewicht.insets = new Insets(0, 0, 5, 5);
		gbc_textGewicht.gridx = 2;
		gbc_textGewicht.gridy = 4;
		panel.add(textGewicht, gbc_textGewicht);
		textGewicht.setColumns(10);
		
		JLabel lblFllmenge = new JLabel("F\u00FCllmenge");
		GridBagConstraints gbc_lblFllmenge = new GridBagConstraints();
		gbc_lblFllmenge.anchor = GridBagConstraints.EAST;
		gbc_lblFllmenge.insets = new Insets(0, 0, 5, 5);
		gbc_lblFllmenge.gridx = 4;
		gbc_lblFllmenge.gridy = 4;
		panel.add(lblFllmenge, gbc_lblFllmenge);
		
		textFuellmenge = new JTextField();
		textFuellmenge.setEditable(false);
		GridBagConstraints gbc_textFuellmenge = new GridBagConstraints();
		gbc_textFuellmenge.anchor = GridBagConstraints.NORTH;
		gbc_textFuellmenge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFuellmenge.insets = new Insets(0, 0, 5, 0);
		gbc_textFuellmenge.gridx = 5;
		gbc_textFuellmenge.gridy = 4;
		panel.add(textFuellmenge, gbc_textFuellmenge);
		textFuellmenge.setColumns(10);
		
		JLabel lblFllstatus = new JLabel("F\u00FCllstatus");
		GridBagConstraints gbc_lblFllstatus = new GridBagConstraints();
		gbc_lblFllstatus.anchor = GridBagConstraints.EAST;
		gbc_lblFllstatus.insets = new Insets(0, 0, 5, 5);
		gbc_lblFllstatus.gridx = 0;
		gbc_lblFllstatus.gridy = 5;
		panel.add(lblFllstatus, gbc_lblFllstatus);
		
		textFuellstatus = new JTextField();
		textFuellstatus.setEditable(false);
		GridBagConstraints gbc_textFuellstatus = new GridBagConstraints();
		gbc_textFuellstatus.anchor = GridBagConstraints.NORTH;
		gbc_textFuellstatus.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFuellstatus.insets = new Insets(0, 0, 5, 5);
		gbc_textFuellstatus.gridx = 2;
		gbc_textFuellstatus.gridy = 5;
		panel.add(textFuellstatus, gbc_textFuellstatus);
		textFuellstatus.setColumns(10);
		
		JLabel lblTvdatum = new JLabel("T\u00FCv-Datum");
		GridBagConstraints gbc_lblTvdatum = new GridBagConstraints();
		gbc_lblTvdatum.anchor = GridBagConstraints.EAST;
		gbc_lblTvdatum.insets = new Insets(0, 0, 5, 5);
		gbc_lblTvdatum.gridx = 0;
		gbc_lblTvdatum.gridy = 6;
		panel.add(lblTvdatum, gbc_lblTvdatum);
		
		textTuevdatum = new JTextField();
		textTuevdatum.setEditable(false);
		textTuevdatum.setText("TT.MM.JJJJ");
		GridBagConstraints gbc_textTuevdatum = new GridBagConstraints();
		gbc_textTuevdatum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTuevdatum.insets = new Insets(0, 0, 5, 5);
		gbc_textTuevdatum.gridx = 2;
		gbc_textTuevdatum.gridy = 6;
		panel.add(textTuevdatum, gbc_textTuevdatum);
		textTuevdatum.setColumns(10);
		
		chckbxRestdruckventil = new JCheckBox("Restdruckventil");
		chckbxRestdruckventil.setEnabled(false);
		GridBagConstraints gbc_chckbxRestdruckventil = new GridBagConstraints();
		gbc_chckbxRestdruckventil.anchor = GridBagConstraints.NORTHEAST;
		gbc_chckbxRestdruckventil.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxRestdruckventil.gridx = 4;
		gbc_chckbxRestdruckventil.gridy = 6;
		panel.add(chckbxRestdruckventil, gbc_chckbxRestdruckventil);
		
		JLabel lblNewLabel_1 = new JLabel("Lebensmitteleignung");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 7;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textLebensmitteleignung = new JTextField();
		textLebensmitteleignung.setEditable(false);
		GridBagConstraints gbc_textLebensmitteleignung = new GridBagConstraints();
		gbc_textLebensmitteleignung.anchor = GridBagConstraints.NORTH;
		gbc_textLebensmitteleignung.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLebensmitteleignung.insets = new Insets(0, 0, 5, 5);
		gbc_textLebensmitteleignung.gridx = 2;
		gbc_textLebensmitteleignung.gridy = 7;
		panel.add(textLebensmitteleignung, gbc_textLebensmitteleignung);
		textLebensmitteleignung.setColumns(10);
		
		JLabel lblCharge = new JLabel("Charge");
		GridBagConstraints gbc_lblCharge = new GridBagConstraints();
		gbc_lblCharge.anchor = GridBagConstraints.EAST;
		gbc_lblCharge.insets = new Insets(0, 0, 5, 5);
		gbc_lblCharge.gridx = 4;
		gbc_lblCharge.gridy = 7;
		panel.add(lblCharge, gbc_lblCharge);
		
		textCharge = new JTextField();
		textCharge.setEditable(false);
		GridBagConstraints gbc_textCharge = new GridBagConstraints();
		gbc_textCharge.anchor = GridBagConstraints.NORTH;
		gbc_textCharge.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCharge.insets = new Insets(0, 0, 5, 0);
		gbc_textCharge.gridx = 5;
		gbc_textCharge.gridy = 7;
		panel.add(textCharge, gbc_textCharge);
		textCharge.setColumns(10);
		
		lblGasArt = new JLabel("Gas Art");
		GridBagConstraints gbc_lblGasArt = new GridBagConstraints();
		gbc_lblGasArt.anchor = GridBagConstraints.EAST;
		gbc_lblGasArt.insets = new Insets(0, 0, 5, 5);
		gbc_lblGasArt.gridx = 0;
		gbc_lblGasArt.gridy = 8;
		panel.add(lblGasArt, gbc_lblGasArt);
		
		cbGasArt = new JComboBox<String>();
		cbGasArt.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Treibgas", "Brenngas"}));
		GridBagConstraints gbc_cbGasArt = new GridBagConstraints();
		gbc_cbGasArt.insets = new Insets(0, 0, 5, 5);
		gbc_cbGasArt.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbGasArt.gridx = 2;
		gbc_cbGasArt.gridy = 8;
		panel.add(cbGasArt, gbc_cbGasArt);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 9;
		panel.add(panel_1, gbc_panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleAbbrechenWasClicked();
			}
		});
		btnAbbrechen.setEnabled(false);
		btnAbbrechen.setVisible(false);
		panel_1.add(btnAbbrechen);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 5;
		gbc_panel_2.gridy = 9;
		panel.add(panel_2, gbc_panel_2);
		
		btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				handleBearbeitenWasClicked();
			}
		});
		panel_2.add(btnBearbeiten);
		
		panel.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblArt, lblFlaschennummer, lblNewLabel, lblNr, chckbxPfand, cbArt, lblGewicht, textKundennummer, textGewicht, lblFllmenge, textFuellmenge, lblFllstatus, textFuellstatus, lblTvdatum, textTuevdatum, chckbxRestdruckventil, lblNewLabel_1, textLebensmitteleignung, lblCharge, textCharge, panel_1, btnAbbrechen, panel_2, btnBearbeiten}));
		
		this.setFields();
		
		if(this.CreateMode){ //Wenn dieses Panel geoeffnet wurde um einen Kunden anzulegen, dann gehe in den Edit Modus
			this.changeToEditMode();
		}else this.setFieldsEditable(false);
	}
	
	public void changeDisplayedGasflasche(Gasflasche flasche, boolean createMode){
		this.CreateMode = createMode;
 		this.gasflasche = flasche;
 		this.setFields();
 		if(this.CreateMode){
 			this.changeToEditMode();
 		}
 	}
 	
 	private void setFields(){ //Setzt die Felder auf dem Panel entsprechend dem übergebenen Gasflaschen Objekts
 		//this.setFieldsEditable(true);
 		this.lblNr.setText(this.gasflasche.getFlaschenNummer());
 		this.cbArt.setSelectedItem(this.gasflasche.getArt());
 		
 		if("Treibgas".equalsIgnoreCase(this.gasflasche.getTreibgasODERBrenngas()) || "Brenngas".equalsIgnoreCase(this.gasflasche.getTreibgasODERBrenngas())){
 			this.cbGasArt.setSelectedItem(this.gasflasche.getTreibgasODERBrenngas());
 		}else this.cbGasArt.setSelectedItem("");
 		
 		this.textCharge.setText(this.gasflasche.getCharge());
 		this.textFuellmenge.setText(this.gasflasche.getFuellmenge());
 		this.textFuellstatus.setText(this.gasflasche.getVollODERLeer());
 		this.textGewicht.setText(this.gasflasche.getGewicht());
 		this.textKundennummer.setText(this.gasflasche.getKundendNummer());
 		this.textLebensmitteleignung.setText(this.gasflasche.getLebensmitteleignung());
 		this.textTuevdatum.setText(this.gasflasche.getTuevDatum());
 		System.out.println("setFields Tüvdatum: " + this.gasflasche.getTuevDatum());
 		
 		if("Pfandflasche".equalsIgnoreCase(this.gasflasche.getPfandODEREigentum())){
 			this.chckbxPfand.setSelected(true);
 		}else this.chckbxPfand.setSelected(false);
 		
 		if("ja".equalsIgnoreCase(this.gasflasche.getRestdruckventil())){
 			this.chckbxRestdruckventil.setSelected(true);
 		}
 	}

 	//Wenn der Knopf "Bearbeiten" gedrückt wurde ändert sich sein Text in "Save" und das Panel wechselt in den Edit Mode
	private void handleBearbeitenWasClicked(){
		if(btnBearbeiten.getText().equals("Bearbeiten")){
			this.changeToEditMode();
		}else handleButtonSaveWasClicked();
	}
	
	//Wenn "Abbrechen"  gedrückt wurde werden die Felder zurückgesetzt und der Save-Button wird wieder zum "Bearbeiten"-Button
	//Der Abbrechen-Button wird wieder ausgeblendet
	private void handleAbbrechenWasClicked(){ 
		this.btnAbbrechen.setVisible(false);
		this.btnBearbeiten.setText("Bearbeiten");
		this.setFields();
		this.setFieldsEditable(false);
	}
	
	//Bearbeiten-Button wird zum Save-Button
	//Felder werden editierbar und der Abbrechen-Button wird sichtbar
	private void changeToEditMode(){
		this.btnBearbeiten.setText("Save");
		this.setFieldsEditable(true);
	}
	
	//Abrechen Button wird Sichtbar
	//Felder werden editierbar
	private void setFieldsEditable(boolean editable){
		this.btnAbbrechen.setEnabled(editable);
		this.btnAbbrechen.setVisible(editable);
		
		//Für den Fall das "editable" true ist wird sichergestellt, dass Charge und Restdruckventil nicht verändert werden 
		//können, wenn die Art der Flasche nicht Sauerstoff ist.
		if("Sauerstoff".equalsIgnoreCase((String)this.cbArt.getSelectedItem())){
			this.textCharge.setEditable(editable);
			this.chckbxRestdruckventil.setEnabled(editable);
		}else{
			this.textCharge.setEditable(false);
			this.chckbxRestdruckventil.setEnabled(false);
		}
		
		this.textFuellmenge.setEditable(editable);
		this.textFuellstatus.setEditable(editable);
		this.textGewicht.setEditable(editable);
		this.textKundennummer.setEditable(editable);
		
		//Für den Fall das "editable" true ist wird sichergestellt, dass die Lebensmitteleignung nicht verändert werden 
		//kann, wenn die Art der Flasche nicht "Kohlensäure" ist.
		if("Kohlensäure".equalsIgnoreCase((String)this.cbArt.getSelectedItem())){
		this.textLebensmitteleignung.setEditable(editable);
		}else this.textLebensmitteleignung.setEditable(false);
		
		this.textTuevdatum.setEditable(editable);
		
		//Für den Fall das "editable" true ist wird sichergestellt, dass Pfand nicht verändert werden 
		//kann, wenn die Art der Flasche nicht Propan oder Kohlensäure ist.
		if("Propan".equalsIgnoreCase((String)this.cbArt.getSelectedItem()) || "Kohlensäure".equalsIgnoreCase((String)this.cbArt.getSelectedItem())){
		this.chckbxPfand.setEnabled(editable);
		}else this.chckbxPfand.setEnabled(false);
		
		//Für den Fall das "editable" true ist wird sichergestellt, dass die GasArt nicht verändert werden 
		//kann, wenn die Art der Flasche nicht Propan ist.
		if("Propan".equalsIgnoreCase((String)this.cbArt.getSelectedItem())){
 			this.cbGasArt.setEditable(editable);
 		}else this.cbGasArt.setEditable(false);
		
		this.cbArt.setEditable(editable);
	}
	
	//Wenn sich die FlaschenArt ändern werden die entsprechenden Felder ein- oder ausgegraut.
	private void handleArtHasChanged(){
		if(this.btnBearbeiten.getText().equals("Save")){ //Sind wir wirklich im Edit-Mode?
			String flaschenArt = (String)this.cbArt.getSelectedItem();
			if(flaschenArt.equalsIgnoreCase("Sauerstoff")){
				textCharge.setEditable(true);
				chckbxRestdruckventil.setEnabled(true);
				cbGasArt.setEditable(false);
				chckbxPfand.setEnabled(false);
				textLebensmitteleignung.setEditable(false);
			}else if(flaschenArt.equalsIgnoreCase("Propan")){
				cbGasArt.setEditable(true);
				chckbxPfand.setEnabled(true);
				textCharge.setEditable(false);
				chckbxRestdruckventil.setEnabled(false);
				textLebensmitteleignung.setEditable(false);
			}else if(flaschenArt.equalsIgnoreCase("Kohlensäure")){
				chckbxPfand.setEnabled(true);
				chckbxRestdruckventil.setEnabled(false);
				textLebensmitteleignung.setEditable(true);
				cbGasArt.setEditable(false);
			}
		}
	}
	
	//Wenn der Save-Button gedrückt wurde, dann wird der Inhalt der Felder in das Gasflaschenobjekt geladen 
	//anschließend wird es zum Datenbank-Aktionsbehandler geschickt. 
	//je nachdem in welchem Modus wir und befinden wird entweder eine vorhandene Flasche geändert oder eine neue angelegt
	//Im zweiten Falle verlassen wir anschließend den create Modus.
	//In  beiden Fällen wechseln wir in den Display-Modus
	private void handleButtonSaveWasClicked(){
		//Befülle das Gasflaschenobjekt für die Weiterverarbeitung
		this.gasflasche.setArt((String)this.cbArt.getSelectedItem());
		this.gasflasche.setCharge(textCharge.getText());
		this.gasflasche.setFuellmenge(textFuellmenge.getText());
		this.gasflasche.setGewicht(textGewicht.getText());
		this.gasflasche.setKundendNummer(textKundennummer.getText());
		this.gasflasche.setLebensmitteleignung(textLebensmitteleignung.getText());
		
		if(chckbxPfand.isSelected()){
		this.gasflasche.setPfandODEREigentum("Pfandflasche");
		}else this.gasflasche.setPfandODEREigentum("");
		
		if(chckbxRestdruckventil.isSelected()){
		this.gasflasche.setRestdruckventil("ja");
		}else this.gasflasche.setRestdruckventil("nein");
		
		if(this.cbGasArt.isEditable()){
		this.gasflasche.setTreibgasODERBrenngas((String)this.cbGasArt.getSelectedItem());
		}else this.gasflasche.setTreibgasODERBrenngas("");
		
		try{
		this.gasflasche.setTuevDatum(textTuevdatum.getText());
		}catch (ParseException e) { System.out.println(e.getMessage()); }
		
		this.gasflasche.setVollODERLeer(textFuellstatus.getText());
		
		if(this.CreateMode){
			this.changeDisplayedGasflasche(this.mainFrame.getDB_Handler().createBottle(this.gasflasche), false);
		}else{
			this.mainFrame.getDB_Handler().changeBottle(this.gasflasche);
		}
		//Gehe in Display Modus
		this.setFieldsEditable(false);
		this.btnAbbrechen.setVisible(false);
		this.btnBearbeiten.setText("Bearbeiten");
	}

}

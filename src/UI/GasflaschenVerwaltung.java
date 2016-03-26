package UI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Database.DatabaseActionHandler;
import Model.Gasflasche;
import Model.Kunde;

import java.awt.BorderLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GasflaschenVerwaltung {

	private JFrame frame;
	private DatabaseActionHandler db_handler;
	private JPanel content;
	private ArrayList<String> sequenceOfPanels;
	private Hauptmenue hauptmenu;
	private Suchfenster suchfenster;
	private SuchergebnisGasflasche sucheGasflaschen;
	private SuchergebnisKunden sucheKunden;
	private GasflaschenDetails gasFlaschenDetails;
	private KundenDetails kundenDetails;
	private JButton zurueckButton;
	private CardLayout contentCardLayout; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GasflaschenVerwaltung window = new GasflaschenVerwaltung();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GasflaschenVerwaltung() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		this.db_handler = new DatabaseActionHandler();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel header = new JPanel();
		GridBagConstraints gbc_header = new GridBagConstraints();
		gbc_header.insets = new Insets(0, 0, 5, 0);
		gbc_header.fill = GridBagConstraints.BOTH;
		gbc_header.gridx = 0;
		gbc_header.gridy = 0;
		frame.getContentPane().add(header, gbc_header);
		
		JPanel zurueck = new JPanel();
		GridBagConstraints gbc_zurueck = new GridBagConstraints();
		gbc_zurueck.insets = new Insets(0, 0, 5, 0);
		gbc_zurueck.fill = GridBagConstraints.BOTH;
		gbc_zurueck.gridx = 0;
		gbc_zurueck.gridy = 1;
		frame.getContentPane().add(zurueck, gbc_zurueck);
		
		this.content = new JPanel();
		GridBagConstraints gbc_content = new GridBagConstraints();
		gbc_content.fill = GridBagConstraints.BOTH;
		gbc_content.gridx = 0;
		gbc_content.gridy = 2;
		frame.getContentPane().add(content, gbc_content);
		this.contentCardLayout = new CardLayout(0, 0);
		content.setLayout(this.contentCardLayout);
		
		zurueckButton = new JButton("<- Zur\u00FCck");
		zurueck.add(zurueckButton);
		zurueckButton.setVisible(false);
		
		zurueckButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				performZurueck();
			}
		});
		
		//Setzt aktuelles Panel und fügt es dem gehe-zurück Pfad hinzu.
		this.hauptmenu = new Hauptmenue(this);
		content.add(hauptmenu, "hauptmenu");
		this.sequenceOfPanels = new ArrayList<String>();
		this.sequenceOfPanels.add("hauptmenu");
		
		frame.setSize(800, 500);
		}
		
		public DatabaseActionHandler getDB_Handler(){
			return this.db_handler;
		}
		
		public void changeToSuche(){ //Wechselt zum Suchfenster-Panel
			if(this.suchfenster == null){
				this.suchfenster = new Suchfenster(this);
			}
			this.content.add(suchfenster, "suchfenster");
			this.contentCardLayout.show(content, "suchfenster");
			this.sequenceOfPanels.add("suchfenster");
			this.leaveHauptmenu();
		}
		
		public void changeToGasflasche(boolean createMode, Gasflasche gasflasche){ //Wechselt zum GasflascheDetails Panel: Kann aus dem Hauptmenu und den Suchergebnissen aufgerufen werden
			if(this.gasFlaschenDetails == null){ //Wurde bereit ein entspr. Panel angelegt?
					this.gasFlaschenDetails = new GasflaschenDetails(gasflasche, this, createMode);
			}else if(gasflasche != null){ // Wenn ja, dann tausche das objekt gasflasche aus und erstelle kein neues Panel
				this.gasFlaschenDetails.changeDisplayedGasflasche(gasflasche, createMode);
			}
			//Wechselt das Panel und fügt es dem zurück-gehen-Pfad hinzu
			this.content.add(gasFlaschenDetails, "gasFlaschenDetails");
			this.contentCardLayout.show(content, "gasFlaschenDetails");
			this.sequenceOfPanels.add("gasFlaschenDetails");
			this.leaveHauptmenu();
		}
		
		public void changeToKunde(boolean createMode, Kunde kunde){ //Wechselt zum KundeDetails Panel: Kann aus dem Hauptmenu und den Suchergebnissen aufgerufen werden
			if(this.kundenDetails == null){ //Wurde bereit ein entspr. Panel angelegt?
					this.kundenDetails = new KundenDetails(kunde, this, createMode);				
			}else if(kunde != null){ // Wenn ja, dann tausche das objekt gasflasche aus und erstelle kein neues Panel
				this.kundenDetails.changeDisplayedKunde(kunde, createMode);
			}
			//Wechselt das Panel und fügt es dem zurück-gehen-Pfad hinzu
			this.content.add(kundenDetails, "kundenDetails");
			this.contentCardLayout.show(content, "kundenDetails");
			this.sequenceOfPanels.add("kundenDetails");
			this.leaveHauptmenu();
			
		}
		
		public void changeToSuchergebnisGasflaschen(ArrayList<Gasflasche> list){ //Wechselt zum SuchergebnisKunde Panel: Kann nur aus dem Suchfenster gerufen werden
			if(this.sucheGasflaschen == null){
				this.sucheGasflaschen = new SuchergebnisGasflasche(list, this);
			}
			//Es wurde bereits einmal nach Gasflaschen gesucht daher wird ein neues Suchergebnis angezeigt
			else sucheGasflaschen.newSearch(list); 
			
			this.content.add(sucheGasflaschen, "sucheGasflaschen");
			this.contentCardLayout.show(content, "sucheGasflaschen");
			this.sequenceOfPanels.add("sucheGasflaschen");
		}
		
		public void changeToSuchergebnisKunden(ArrayList<Kunde> list){ //Wechselt zum SuchergebnisKunde Panel: Kann nur aus dem Suchfenster gerufen werden
			if(this.sucheKunden == null){
				this.sucheKunden = new SuchergebnisKunden(list, this); 
			}
			//Es wurde bereits einmal nach Kunden gesucht daher wird ein neues Suchergebnis angezeigt
			else sucheKunden.newSearch(list);
				
			this.content.add(sucheKunden, "sucheKunden");
			this.contentCardLayout.show(content, "sucheKunden");
			this.sequenceOfPanels.add("sucheKunden");
		}
		
		public void performZurueck(){ //Geht anhand des zuvor gefüllten zurück-gehe-Pfades zum vorherigen Panel
			int indexOfLatestPanel = this.sequenceOfPanels.size()-1; //Index des aktivens Panels
			String lastPanel = this.sequenceOfPanels.get(indexOfLatestPanel-1); //hole den Namen des letzten Panels
			this.contentCardLayout.show(content, lastPanel);
			
			if(this.sequenceOfPanels.get(indexOfLatestPanel).equals("sucheKunden")){
				this.sucheKunden.clearSuche();
			}else if(this.sequenceOfPanels.get(indexOfLatestPanel).equals("sucheGasflaschen")){
				this.sucheGasflaschen.clearSuche();
			}
			
			this.sequenceOfPanels.remove(indexOfLatestPanel);
			if(lastPanel.equals("hauptmenu")){
				this.enterHauptmenu();
			}
		}
		
		private void leaveHauptmenu(){ //Wenn das Hauptmenu verlassen wird soll der Zurück-Button erscheinen
			this.zurueckButton.setVisible(true);
		}
		
		private void enterHauptmenu(){ //Wenn das Hauptmenu betreten wird soll der Zurück-Button verschwinden
			this.zurueckButton.setVisible(false);
		}
}

package UI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import Model.Gasflasche;
import Model.Kunde;

import java.awt.Component;
import java.awt.BorderLayout;

public class Hauptmenue extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private GasflaschenVerwaltung mainFrame;
	
	public Hauptmenue(GasflaschenVerwaltung frame) {
		
		this.mainFrame = frame;
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		;
		
		JButton btnSuche = new JButton("Suche");
		GridBagConstraints gbc_btnSuche = new GridBagConstraints();
		gbc_btnSuche.insets = new Insets(0, 0, 5, 0);
		gbc_btnSuche.gridx = 0;
		gbc_btnSuche.gridy = 0;
		panel.add(btnSuche, gbc_btnSuche);
		btnSuche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("Suche was clicked");
				handleClick(0);
			}
		});
		
		JButton btnNeueGasflasche = new JButton("Neue Gasflasche");
		GridBagConstraints gbc_btnNeueGasflasche = new GridBagConstraints();
		gbc_btnNeueGasflasche.insets = new Insets(0, 0, 5, 0);
		gbc_btnNeueGasflasche.gridx = 0;
		gbc_btnNeueGasflasche.gridy = 1;
		panel.add(btnNeueGasflasche, gbc_btnNeueGasflasche);
		
		btnNeueGasflasche.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleClick(1);
			}
		});
		
		JButton btnNeuerKunde = new JButton("Neuer Kunde");
		GridBagConstraints gbc_btnNeuerKunde = new GridBagConstraints();
		gbc_btnNeuerKunde.insets = new Insets(0, 0, 5, 0);
		gbc_btnNeuerKunde.gridx = 0;
		gbc_btnNeuerKunde.gridy = 2;
		panel.add(btnNeuerKunde, gbc_btnNeuerKunde);
		
		btnNeuerKunde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				handleClick(2);
			}
		});
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{btnSuche, btnNeueGasflasche, btnNeuerKunde}));
	}
	
	//Hier wird entschieden ob ein Kunde/ eine Gasflasche gesucht werden soll
	//oder ein Kunde / eine Gasflasche angelegt werden soll.
	private void handleClick(int number){
		if(number == 0){
			this.mainFrame.changeToSuche();
		}else if(number == 1){
			this.mainFrame.changeToGasflasche(true, new Gasflasche("", "", "", "", "", "", "", "", "", "", "", ""));
		}else{
			this.mainFrame.changeToKunde(true, new Kunde("", "", "", "", "", "", "", "", "", ""));
		}
	}

}

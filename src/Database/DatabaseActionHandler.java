package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.Integer;
import Model.*;

public class DatabaseActionHandler {
private DatabaseConnector db_connector;
private SQLHelper sql_helper;

public DatabaseActionHandler(){
	try {
		this.setDB_connector(new DatabaseConnector());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
	this.setSql_helper(new SQLHelper());
}

public DatabaseConnector getDB_connector() {
	return db_connector;
}

private void setDB_connector(DatabaseConnector db_connector) {
	this.db_connector = db_connector;
}

public SQLHelper getSql_helper() {
	return sql_helper;
}

private void setSql_helper(SQLHelper sql_helper) {
	this.sql_helper = sql_helper;
}

//Schickt eine Abfrage an die Datenbank
private ResultSet sendQuery(String query){ 
	Connection connection = this.db_connector.getConnection();
	ResultSet result = null;
	if (connection != null) {
		try {
			Statement statement = connection.createStatement();
			result = statement.executeQuery(query);
		} catch (Exception e) { System.out.println(""+e.getMessage());}
		} else {
			System.out.println("Failed to make connection!");
		}
	return result;
}

//Convertiert das ResultSet einer Gasflaschen-Abfrage zu einer Liste von Gasflaschen
private ArrayList<Gasflasche> convertGasflascheResultSetToArrayList(ResultSet resultSet){
	ArrayList<Gasflasche> gasflaschen = new ArrayList<Gasflasche>();
	try{
		while (resultSet.next()) {
			
			gasflaschen.add(new Gasflasche(resultSet.getString("FLASCHENNR"), resultSet.getString("ART"), 
					resultSet.getString("KDNR"), resultSet.getString("TUEVDATUM"), 
					resultSet.getString("VOLLODERLEER"), resultSet.getString("FUELLMENGE"), 
					resultSet.getString("GEWICHT"), resultSet.getString("CHARGE"), 
					resultSet.getString("RESTDRUCKVENTIL"), resultSet.getString("TREIBGASODERBRENNGAS"), 
					resultSet.getString("PFANDODEREIGENTUM"), resultSet.getString("LEBENSMITTELEIGNUNG")));
				}
		} catch (Exception e) { System.out.println(""+e.getMessage());}
	
	return gasflaschen;
}

//Convertiert das ResultSet einer Kunden-Abfrage zu einer Liste von Kunden
private ArrayList<Kunde> convertKundeResultSetToArrayList(ResultSet resultSet){
	ArrayList<Kunde> kunden = new ArrayList<Kunde>();
	try{
		while (resultSet.next()) {
			
			kunden.add(new Kunde(resultSet.getString("KDNR"), resultSet.getString("NAME"), 
					resultSet.getString("TELEFON"), resultSet.getString("FAX"), 
					resultSet.getString("EMAIL"), resultSet.getString("ANSPRECHPARTNER"), 
					resultSet.getString("STRASSE"), resultSet.getString("PLZ"), 
					resultSet.getString("ORT"), resultSet.getString("LAND")));
				}
		} catch (Exception e) { System.out.println(""+e.getMessage());}
	
	return kunden;
}

//Liefert eine List von Gasflaschen zurück
public ArrayList<Gasflasche> getBottle(){
    String select = this.getSql_helper().createSelect("Gasflasche");
    
	ResultSet result = this.sendQuery(select);
	return this.convertGasflascheResultSetToArrayList(result);
}

//Liefert eine List von Gasflaschen zurück, liefert dem SQL-Helper Daten um ein SQL-Statement zu bauen
public ArrayList<Gasflasche> getBottle(String bottle_id, String customer_id, String charge){
	String[] columns = {"FLASCHENNR","KDNR","CHARGE"};
	String[] arguments = {bottle_id, customer_id, charge};
	String select = this.getSql_helper().createSelect("Gasflasche", columns, arguments); 				
	
	ResultSet result = this.sendQuery(select);
	return this.convertGasflascheResultSetToArrayList(result);
}

//Nimmt ein GasflaschenObjekt und lässt damit ein Update Select erstellen. Lässt dieses an die Datenbank schicken.
public Gasflasche changeBottle(Gasflasche bottle){
	String[] columns = {"FlaschenNr", "Art", "KdNr", "TuevDatum", "VollOderLeer", "FuellMenge", "Gewicht", "Charge", 
			"RestdruckVentil", "TreibgasOderBrenngas", "PfandOderEigentum", "LebensmittelEignung"};	

	String[] arguments = {bottle.getFlaschenNummer(), bottle.getArt(), bottle.getKundendNummer(), bottle.getTuevDatum()
			, bottle.getVollODERLeer(), bottle.getFuellmenge(), bottle.getGewicht(), bottle.getCharge()
			, bottle.getRestdruckventil(), bottle.getTreibgasODERBrenngas(), bottle.getPfandODEREigentum()
			, bottle.getLebensmitteleignung()};
	
	String update = sql_helper.createUpdate("Gasflasche", columns, arguments);
	System.out.println(update);
	
	ResultSet result = this.sendQuery(update);
	System.out.println(result);
	
	return this.getBottle(bottle.getFlaschenNummer(), "", "").get(0);
}

//Nimmt ein GasflaschenObjekt und lässt damit ein Insert Select erstellen. Lässt dieses an die Datenbank schicken.
public Gasflasche createBottle(Gasflasche bottle){
	ResultSet result = this.sendQuery("select max(FLASCHENNR) as MAX from Gasflasche"); //Höchste vergebene Id holen
	String lastId = "";
		try{
		result.next();
		lastId = result.getString("MAX");
		} catch (Exception e) { System.out.println(""+e.getMessage());}

	
	int lastIdNum = Integer.parseInt(lastId.split("F")[1]);
	lastIdNum++;
	lastId = Integer.toString(lastIdNum);
	//setze fuehrende Nullen vor die Zahl. 7 Stellen sind es. 
	//Differenz zwischen der Laenge von lastId und 7 ist die Anzahl der benoetigten Nullen. 
	for(int i = 0; i < (7-lastId.length()); i++){
		lastId = "0" + lastId;
	}
	lastId = "F" + lastId; 
	
	String[] columns = {"FlaschenNr", "Art", "KdNr", "TuevDatum", "VollOderLeer", "FuellMenge", "Gewicht", "Charge", 
						"RestdruckVentil", "TreibgasOderBrenngas", "PfandOderEigentum", "LebensmittelEignung"};	
	
	String[] arguments = {lastId, bottle.getArt(), bottle.getKundendNummer(), bottle.getTuevDatum()
						, bottle.getVollODERLeer(), bottle.getFuellmenge(), bottle.getGewicht(), bottle.getCharge()
						, bottle.getRestdruckventil(), bottle.getTreibgasODERBrenngas(), bottle.getPfandODEREigentum()
						, bottle.getLebensmitteleignung()};
	String insert = this.sql_helper.createInsert("Gasflasche", columns, arguments);
	
	System.out.println(insert);
	
	result = this.sendQuery(insert);
	
	System.out.println(result);
	System.out.println(lastId);
	return this.getBottle(lastId, "", "").get(0);
}

//liefert eine Liste von Kunden
public ArrayList<Kunde> getCustomer(){ 
	String select = this.getSql_helper().createSelect("Kunde");
	ResultSet result = this.sendQuery(select);
	
	return this.convertKundeResultSetToArrayList(result);
}

//Übergibt an den SQL-Helper argumente und lässt daraus ein SQL-Statement erzeugen.
//liefert eine Liste von Kunden
public ArrayList<Kunde> getCustomer(String customer_id, String name){ 
	String[] arguments = {customer_id, name};
	String[] columns = {"KDNR","NAME"};
	
	String select = this.getSql_helper().createSelect("Kunde", columns, arguments);
	ResultSet result = this.sendQuery(select);
	
	return this.convertKundeResultSetToArrayList(result);
}

//Nimmt ein KundenObjekt und lässt damit ein Update Select erstellen. Lässt dieses an die Datenbank schicken.
public Kunde changeCustomer(Kunde kunde){
	String[] arguments = {kunde.getKundenNummer(), kunde.getName(), kunde.getTelefon(), kunde.getFax(), kunde.getEMail(), kunde.getAnsprechpartner()
						, kunde.getStrasse(), kunde.getPLZ(), kunde.getOrt(), kunde.getLand()};
	String[] columns = {"KdNr", "Name", "Telefon", "Fax", "Email", "Ansprechpartner", "Strasse", "Plz", "Ort", "Land"};
	
	String update = sql_helper.createUpdate("Kunde", columns, arguments);
	
	System.out.println(update);
	
	ResultSet result = this.sendQuery(update);
	System.out.println(result);
	
	return this.getCustomer(kunde.getKundenNummer(), "").get(0);
}

//Nimmt ein KundenObjekt und lässt damit ein Insert Select erstellen. Lässt dieses an die Datenbank schicken.
public Kunde createCustomer(Kunde kunde){
	ResultSet result = this.sendQuery("select max(KdNr) as MAX from Kunde where KdNr < 'D888888'"); //Höchste vergebene Id holen die weder TUEV noch Schrott ist
	String lastId = "";
	try{
	result.next();
	lastId = result.getString("MAX");
	} catch (Exception e) { System.out.println(""+e.getMessage());}
	
	int lastIdNum = Integer.parseInt(lastId.split("D")[1]);
	lastIdNum++;
	lastId = Integer.toString(lastIdNum);
	//setze fuehrende Nullen vor die Zahl. 7 Stellen sind es. 
	//Differenz zwischen der Laenge von lastId und 7 ist die Anzahl der benoetigten Nullen. 
	for(int i = 0; i < (7-lastId.length()); i++){
		lastId = "0" + lastId;
	}
	lastId = "D" + lastId; 
	
	String[] columns = {"KdNr", "Name", "Telefon", "Fax", "Email", "Ansprechpartner", 
						"Strasse", "Plz", "Ort", "Land"};	
	
	String[] arguments = {lastId, kunde.getName()
						, kunde.getTelefon(), kunde.getFax(), kunde.getEMail(), kunde.getAnsprechpartner()
						, kunde.getStrasse(), kunde.getPLZ(), kunde.getOrt()
						, kunde.getLand()};
	String insert = this.sql_helper.createInsert("Kunde", columns, arguments);
	
	System.out.println(insert);
	
	result = this.sendQuery(insert);
	
	System.out.println(result);
	System.out.println(lastId);
	return this.getCustomer(lastId, "").get(0);

}

}

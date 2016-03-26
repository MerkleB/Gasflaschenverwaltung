package Model;

public class Kunde {
private String KundenNummer;
private String Name;
private String Telefon;
private String Fax;
private String EMail;
private String Ansprechpartner;
private String Strasse;
private String PLZ;
private String Ort;
private String Land;

public Kunde(String KdNr,String Name,String Telefon,String Fax,String EMail,String Ansprechpartner,String Strasse,String PLZ,String Ort,String Land){
	this.setKundenNummer(KdNr);
	this.setName(Name);
	this.setTelefon(Telefon);
	this.setFax(Fax);
	this.setEMail(EMail);
	this.setAnsprechpartner(Ansprechpartner);
	this.setStrasse(Strasse);
	this.setPLZ(PLZ);
	this.setOrt(Ort);
	this.setLand(Land);
}

public String getKundenNummer() {
	return KundenNummer;
}

public void setKundenNummer(String kdNr) {
	KundenNummer = kdNr;
}

public String getName() {
	return Name;
}

public void setName(String name) {
	Name = name;
}

public String getTelefon() {
	return Telefon;
}

public void setTelefon(String telefon) {
	Telefon = telefon;
}

public String getFax() {
	return Fax;
}

public void setFax(String fax) {
	Fax = fax;
}

public String getEMail() {
	return EMail;
}

public void setEMail(String eMail) {
	EMail = eMail;
}

public String getAnsprechpartner() {
	return Ansprechpartner;
}

public void setAnsprechpartner(String ansprechpartner) {
	Ansprechpartner = ansprechpartner;
}

public String getStrasse() {
	return Strasse;
}

public void setStrasse(String strasse) {
	Strasse = strasse;
}

public String getPLZ() {
	return PLZ;
}

public void setPLZ(String pLZ) {
	PLZ = pLZ;
}

public String getOrt() {
	return Ort;
}

public void setOrt(String ort) {
	Ort = ort;
}

public String getLand() {
	return Land;
}

public void setLand(String land) {
	Land = land;
}
}

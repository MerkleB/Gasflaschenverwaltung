package Model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Gasflasche {
private String FlaschenNummer;
private String Art;
private String KundendNummer;
private String TuevDatum;
private String VollODERLeer;
private String Fuellmenge;
private String Gewicht;
private String Charge;
private String Restdruckventil;
private String TreibgasODERBrenngas;
private String PfandODEREigentum;
private String Lebensmitteleignung;

public Gasflasche(String FlaschenNummer,String Art,String KundendNummer,String TuevDatum,String VollODERLeer,String Fuellmenge,String Gewicht,String Charge,String Restdruckventil,String TreibgasODERBrenngas,String PfandODEREigentum,String Lebensmitteleignung){
	this.setFlaschenNummer(FlaschenNummer);
	this.setArt(Art);
	this.setKundendNummer(KundendNummer);
	
	try{
	this.setTuevDatum(TuevDatum);
	}catch (ParseException e){ System.out.println(""+e.getMessage());}
	
	this.setVollODERLeer(VollODERLeer);
	this.setFuellmenge(Fuellmenge);
	this.setGewicht(Gewicht);
	this.setCharge(Charge);
	this.setRestdruckventil(Restdruckventil);
	this.setPfandODEREigentum(PfandODEREigentum);
	this.setTreibgasODERBrenngas(TreibgasODERBrenngas);
}

public String getFlaschenNummer() {
	return FlaschenNummer;
}
public void setFlaschenNummer(String flaschenNummer) {
	FlaschenNummer = flaschenNummer;
}
public String getArt() {
	return Art;
}
public void setArt(String art) {
	Art = art;
}
public String getKundendNummer() {
	return KundendNummer;
}
public void setKundendNummer(String kundendNummer) {
	KundendNummer = kundendNummer;
}
public String getTuevDatum() {
	return TuevDatum;
}
public void setTuevDatum(String tuevDatum) throws ParseException {
	if(tuevDatum.length() > 10){
		String[] date = tuevDatum.split("-");
		date[2] = date[2].split(" ")[0];
		TuevDatum = date[2] + "." + date[1] + "." + date[0];
	}else TuevDatum = tuevDatum;
}
public String getVollODERLeer() {
	return VollODERLeer;
}
public void setVollODERLeer(String vollODERLeer) {
	VollODERLeer = vollODERLeer;
}
public String getFuellmenge() {
	return Fuellmenge;
}
public void setFuellmenge(String fuellmenge) {
	Fuellmenge = fuellmenge;
}
public String getGewicht() {
	return Gewicht;
}
public void setGewicht(String gewicht) {
	Gewicht = gewicht;
}
public String getCharge() {
	return Charge;
}
public void setCharge(String charge) {
	Charge = charge;
}
public String getRestdruckventil() {
	return Restdruckventil;
}
public void setRestdruckventil(String restdruckventil) {
	Restdruckventil = restdruckventil;
}
public String getTreibgasODERBrenngas() {
	return TreibgasODERBrenngas;
}
public void setTreibgasODERBrenngas(String treibgasODERBrenngas) {
	TreibgasODERBrenngas = treibgasODERBrenngas;
}
public String getPfandODEREigentum() {
	return PfandODEREigentum;
}
public void setPfandODEREigentum(String pfandODEREigentum) {
	PfandODEREigentum = pfandODEREigentum;
}
public String getLebensmitteleignung() {
	return Lebensmitteleignung;
}
public void setLebensmitteleignung(String lebensmitteleignung) {
	Lebensmitteleignung = lebensmitteleignung;
}

}

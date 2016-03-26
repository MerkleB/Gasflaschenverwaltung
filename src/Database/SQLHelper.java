package Database;

public class SQLHelper {

	public SQLHelper(){
	}
	
	public String createSelect(String table){
		String result = "select * from (select * from " + table;
		result = result + ") where rownum <= ";
		if(table.equalsIgnoreCase("kunde")){
			result = result + " 100";
		}else result = result + " 500";
		return result;
	}
	
	public String createSelect(String table, String[] columnNames, String[] arguments){
		boolean allArgumentsAreEmpty = true;	
		String result = "select * from (select * from " + table;
		boolean thereIsAnArgumentBefore = false;
		if(arguments.length > 0 && columnNames.length > 0){ //Sicherstellen das kein leeres Array uebergeben wurde.
			result = result + " where ";
			
			for(int i = 0; i < arguments.length; i++){
				if(arguments[i] != null && !"".equalsIgnoreCase(arguments[i])){ //Ist das aktuelle Argument weder NULL noch leer?
					if(thereIsAnArgumentBefore){ //Folgt das aktuelle Argument auf ein anderes? 
						result = result + "or ";	//Dann schreibe ein "or" davor.
					}
					result = result +" "+ columnNames[i] +" = '" + arguments[i] + "' ";
					thereIsAnArgumentBefore = true;
					allArgumentsAreEmpty = false;
				}else{
					thereIsAnArgumentBefore = false;
				}
			}
		}
		//top 100 bzw. 500 selektieren
		result = result + ") where rownum <= ";
		if(table.equalsIgnoreCase("kunde")){
			result = result + " 100";
		}else result = result + " 500";
		
		if(allArgumentsAreEmpty){ //Pruefen ob nicht-leere Argumente geliefert wurden.
			result =  this.createSelect(table);
		}
		return result;
	}
	
	public String createInsert(String table, String[] columnNames, String[] arguments){
		String result = "insert into " + table + "(";
		//Insert into Gasflasche(FlaschenNr, Art, KdNr, TuevDatum, VollODERLeer, Fuellmenge, Gewicht, Charge, Restdruckventil, TreibgasODERBrenngas, PfandODEREigentum, Lebensmitteleignung)
		//Values ('F000023','Sauerstoff',''D000000,'19.06.2025','Vollgut','2 l','5.25 kg','15/08/16/04','ja','','','');
		for(int i = 0; i < columnNames.length; i++){
			if(i > 0){ //Wenn noch keine Spalte eingetragen wurde soll an die aktuelle kein Komma vorangestellt werden
				result = result + ", ";
			}
			result = result + columnNames[i];
		}
		
		result = result + ") Values (";
		
		for(int i = 0; i < arguments.length; i++){
			if(i > 0){ //Wenn noch keine Wert eingetragen wurde soll an den aktuellen kein Komma vorangestellt werden
				result = result + ", ";
			}
			result = result + "'" + arguments[i] + "'";
		}
		result = result + ")";
		return result;
	}
	
	public String createUpdate(String table, String[] columns, String[] arguments){
		String result = "UPDATE "+ table + " set ";
		
		for(int i = 1; i < arguments.length; i++){ //Die Id in der ersten Spalte wird erst in der WHERE-Clause verwendet.
			if(i > 1){ //Wenn noch keine Wert eingetragen wurde soll an den aktuellen kein Komma vorangestellt werden
				result = result + ", ";
			}
			result = result + columns[i] + " = " +  "'"+ arguments[i] + "'";
		}
		result = result + " where " + columns[0] + " = " + "'" + arguments[0] + "'";
		
		return result;
	}
}

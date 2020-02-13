package es.mdef.acing;

import com.esotericsoftware.jsonbeans.Json;
import com.other.library.Book;

import app.tienda.turno.Turno;
import app.tienda.valor.Numero;

public class EjemploDependencias {

	public static void main(String[] args) {
		Turno<Numero> turno;
//		Coche coche;
		
		Json json = new Json();
		Book libro = new Book("53463", "Don Quijote", "Classic Novel");
	    System.out.println(json.prettyPrint(libro));
	}

}

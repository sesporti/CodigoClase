package es.mdef.vehiculos;

import es.mdef.comun.Arrancable;

public class Moto extends VehiculoConRuedas implements Arrancable {

	Object[] ruedas = new Object[2];
	
	@Override
	public int getNumeroDeRuedas() {
		return ruedas.length;
	}
	
	public Moto(String color, String modelo) {
		super(color, modelo);
	}

	@Override
	public String toString() {
		return "Moto: " + super.toString();
	}

}

package es.mdef.comun;

public class Ordenador implements Arrancable {
	boolean arrancado = false;
	
	@Override
	public boolean arrancar() {
		System.out.println("Arranco al pulsar botón de encendido");
		arrancado = true;
		return arrancado;
	}

	@Override
	public String toString() {
		return "Ordenador " + ((arrancado)?"encendido":"apagado");
	}

}

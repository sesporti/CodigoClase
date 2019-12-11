package es.mdef.comun;

public interface Arrancable {

	default boolean arrancar() {
		System.err.println("Se arranca como sea");
		return true;
	}
}

package app.tienda;

import java.util.Objects;

import app.tienda.valor.Numero;
import app.tienda.valor.Serializado;

public class PruebaMaximo {

	public static void main(String[] args) {
		Serializado<Numero> miNumero = new Numero(97);
		Numero limite = new Numero(101);
		while (!limite.equals(miNumero)) {
			System.out.println(miNumero + " es igual " + miNumero.ultimo() + " " + Serializado.comprobarMaximo(miNumero));
			miNumero = miNumero.siguiente();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

package es.mdef.comun;

public class Mueble implements Coloreable {
	String color;
	
	@Override
	public String getColor() {
		return color;
	}

	public Mueble(String color) {
		super();
		this.color = color;
	}

	@Override
	public String toString() {
		return "Mueble [color=" + color + "]";
	}

}

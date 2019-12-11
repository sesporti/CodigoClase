package es.mdef.vehiculos;

import es.mdef.comun.Coloreable;

public class Igualdad {

	  public static void main(String[] args) {
	    Coche coche1 = new Coche("Azul", "Seat Ibiza");
	    coche1.setMatricula("1234 BBB");
	    //...
	    Coloreable coche3 = coche1;
	    // coche3.setMatricula("5678 CCC");// error!

	    //...
	    Object coche4 =new Moto("Negra", "Suzuki");
	    
	    Moto moto = ((Moto) coche4);
	    
	    System.out.println(coche3);
	    System.out.println("coche1 y coche3 son el mismo: "
	    		+ (coche1 == coche3));
	    System.out.println(coche4);
	  }
	}

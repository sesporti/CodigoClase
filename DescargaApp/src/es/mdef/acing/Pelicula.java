package es.mdef.acing;

public class Pelicula extends ContenidoImpl {
   private Director director;
   private Actor[] actoresPrincipales;

   public Pelicula(Identificador id, String titulo) {
	   super(id, titulo);
   }
   
   
}

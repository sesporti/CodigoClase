package app.tienda.valor;

public class Numero implements Serializado<Numero> {
    public static final Numero PRIMERO = new Numero(0);
    public static final Numero ULTIMO = new Numero(99);; 
    private final int numero;
    
    public Numero(int numero) {
        this.numero = numero;
    }
    
    public static Numero siguienteAl(Numero actual) {
        return new Numero(actual.numero + 1);
    }
    
	public Numero siguiente() {
		return siguienteAl(this);
	}

    @Override
    public Numero primero() {
        return PRIMERO;
    }

    @Override
    public Numero ultimo() {
        return ULTIMO;
    }

    @Override
    public String toString() {
        return Integer.toString(numero);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Numero other = (Numero) obj;
        if (numero != other.numero)
            return false;
        return true;
    }

}

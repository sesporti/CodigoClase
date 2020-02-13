package app.tienda.valor;

public class Letra implements Serializado<Letra> {
    static String LETRAS_VALIDAS = "ABC";
    private String letra;
    
    public Letra() {
    	letra = LETRAS_VALIDAS.split("")[LETRAS_VALIDAS.length() - 1];
    }
    
    public Letra(String letra) {
        this.letra = letra;
    }
    
    private String cogerLetraNumero(int numero) {
        return LETRAS_VALIDAS.substring(numero, numero + 1);
    }
    
    @Override
    public Letra siguiente() {
        int index = LETRAS_VALIDAS.indexOf(this.letra);
        return new Letra(cogerLetraNumero((index + 1) % LETRAS_VALIDAS.length()));
    }

    @Override
    public Letra primero() {
        return new Letra(cogerLetraNumero(0));
    }

    @Override
    public Letra ultimo() {
        return new Letra(cogerLetraNumero(LETRAS_VALIDAS.length() - 1));
    }

    @Override
    public String toString() {
        return letra;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((letra == null) ? 0 : letra.hashCode());
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
        Letra other = (Letra) obj;
        if (letra == null) {
            if (other.letra != null)
                return false;
        } else if (!letra.equals(other.letra))
            return false;
        return true;
    }

}
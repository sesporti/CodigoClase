package app.tienda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class ColeccionCliente {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente();
		cliente1.pedirTurno();
//		System.out.println("El turno del cliente es: "
//				+ cliente.);
		
		Cliente cliente2 = new Cliente();
		cliente2.pedirTurno();
		
		Collection<Cliente> clientes = new ArrayList<>();
		clientes.add(cliente1);
		clientes.add(cliente2);
		clientes.add(cliente2);
		clientes.add(new Cliente());
		((List<Cliente>) clientes).get(clientes.size() - 1).pedirTurno();
		
		List<Cliente> clienteLista = new ArrayList<>(clientes);
		clienteLista.get(clientes.size() - 1).pedirTurno();
		
		//System.out.println(clientes);
		//clientes.forEach(c -> System.out.println(c));
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente);
		}
	}

}

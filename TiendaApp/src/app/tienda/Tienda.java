package app.tienda;

import java.util.Arrays;
import java.util.Objects;

import app.tienda.turno.GeneradorTurnos;
import app.tienda.turno.Turno;

public class Tienda {

	public static void main(String[] args) {
		
		new GeneradorTurnos<String>();
		
		Turno.pasaTurno();
		// System.out.println(Turno.);
		Turno miTurno = Turno.cogerTurno();
		System.out.println(miTurno);
		miTurno = Turno.cogerTurno();
		System.out.println(miTurno);

		Cliente cliente1 = new Cliente();
		cliente1.pedirTurno();
//		System.out.println("El turno del cliente es: "
//				+ cliente.);
		
		Cliente cliente2 = new Cliente();
		cliente2.pedirTurno();
		
		Cliente[] clientes = new Cliente[] {
				cliente1,
				cliente2,
				new Cliente()
			};
		
		System.out.println(Arrays.toString(clientes));
		miTurno.pasaTurno();
		System.out.println("El turno actual es: " 
				+ miTurno.verValorActual());
		Turno.pasaTurno();
		Turno.pasaTurno();
		
		Cliente alQueLeToca = clienteActual(clientes);
		System.out.println("Le toca a "
				+ ((alQueLeToca != null) ? alQueLeToca : "nadie"));
	}

	static Cliente clienteActual(Cliente[] clientes) {
		Cliente cliente = null;
//		Turno turnoActual = new Turno(Turno.verValorActual());
		for(Cliente c : clientes) {
//			if(c.getTurno().getValor() == Turno.verValorActual()) {
			if(Turno.getTurnoActual().equals(c.getTurno())){
			//if(Objects.equals(Turno.getTurnoActual(), c.getTurno())){
				cliente = c;
				break;
			}
		}
		
		return cliente;
	}
}

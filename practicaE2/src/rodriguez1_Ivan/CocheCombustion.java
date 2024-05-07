package rodriguez1_Ivan;

import java.util.Scanner;

public class CocheCombustion extends Coche {
	private int capacidad;

	public CocheCombustion() {
		super();
	}

	public CocheCombustion(String matricula, int numPuertas, int potencia, int dias, int capacidad) {
		super(matricula, numPuertas, potencia, dias);
		this.capacidad = capacidad;
	}

	@Override
	public double precioPorHora() {
		return 10;
	}

	@Override
	public double precioPorDia() {
		return 80;
	}

	@Override
	public double presupuesto(int dias) {
		return (precioPorDia() * dias + 100);
	}

	@Override
	public double presupuesto(byte horas) {
		return (precioPorHora() * horas + 100);
	}
	
	public void imprimirDatos() {
		System.out.println("Matricula: " + super.getMatricula());
		System.out.println("Numero de Puertas: " + super.getNumPuertas());
		System.out.println("Potencia (CV): " + super.getPotencia());
		System.out.println("Capacidad: " + this.capacidad);
		System.out.println("Precio x Dia: " + precioPorDia());
		System.out.println("Precio x Hora: " + precioPorHora());
		System.out.println();
	}

	public CocheCombustion generarCoche() { // Metodo creado para poder dar de alta coches de combustion
		Scanner in = new Scanner(System.in);
		CocheCombustion coche = new CocheCombustion();
		
		System.out.print("Matricula: ");
		coche.setMatricula(in.nextLine());
		System.out.println();
		System.out.print("Numero de Puertas: ");
		coche.setNumPuertas(in.nextInt());
		System.out.println();
		System.out.print("Potencia (CV): ");
		coche.setPotencia(in.nextInt());
		System.out.println();
		System.out.print("Capacidad: ");
		coche.setCapacidad(in.nextInt());
		System.out.println();
		
		return coche;
	}

	/**
	 * @return the capacidad
	 */
	public int getCapacidad() {
		return capacidad;
	}

	/**
	 * @param capacidad the capacidad to set
	 */
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	
}

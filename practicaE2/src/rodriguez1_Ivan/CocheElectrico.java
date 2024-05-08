package rodriguez1_Ivan;

import java.io.Serializable;
import java.util.Scanner;

public class CocheElectrico extends Coche implements Serializable {
	private int autonomia;

	public CocheElectrico() {
		super();
	}

	public CocheElectrico(String matricula, int potencia, int dias) {
		super(matricula, 5, potencia, dias);
	}

	@Override
	public double precioPorHora() {
		return 3;
	}

	@Override
	public double precioPorDia() {
		return 70;
	}

	@Override
	public double presupuesto(int dias) {
		return (precioPorDia() * dias);
	}

	@Override
	public double presupuesto(byte horas) {
		Scanner in = new Scanner(System.in);
		int km = 0;
		
		System.out.print("Numero de km a circular: ");
		km = in.nextInt();
		System.out.println();

		return (precioPorHora() * horas + 0.5 * km);
	}
	
	public void imprimirDatos() {
		System.out.println("Matricula: " + super.getMatricula());
		System.out.println("Numero de Puertas: " + super.getNumPuertas());
		System.out.println("Potencia (CV): " + super.getPotencia());
		System.out.println("Autonomia: " + this.autonomia);
		System.out.println("Precio x Dia: " + precioPorDia());
		System.out.println("Precio x Hora: " + precioPorHora());
		System.out.println();
	}
	
	public CocheElectrico generarCoche() { // Metodo creado para poder dar de alta coches electricos
		Scanner in = new Scanner(System.in);
		CocheElectrico coche = new CocheElectrico();
		
		System.out.print("Matricula: ");
		coche.setMatricula(in.nextLine());
		System.out.println();
		coche.setNumPuertas(5);
		System.out.print("Potencia (CV): ");
		coche.setPotencia(in.nextInt());
		System.out.println();
		System.out.print("Autonomia: ");
		coche.setAutonomia(in.nextInt());
		System.out.println();
		
		return coche;
	}

	/**
	 * @return the autonomia
	 */
	public int getAutonomia() {
		return autonomia;
	}

	/**
	 * @param autonomia the autonomia to set
	 */
	public void setAutonomia(int autonomia) {
		this.autonomia = autonomia;
	}
	
}

package rodriguez1_Ivan;

import java.io.Serializable;
import java.util.Scanner;

public class Moto extends Vehiculo implements Serializable {
	private int cilindrada;

	public Moto() {
		super();
	}

	public Moto(String matricula, int cilindrada) {
		super(matricula);
		this.cilindrada = cilindrada;
	}
	
	public void imprimirDatos() {
		System.out.println("Matricula: " + super.getMatricula());
		System.out.println("Cilindrada: " + this.cilindrada);
		System.out.println("Precio x Dia: " + precioPorDia());
		System.out.println("Precio x Hora: " + precioPorHora());
		System.out.println();
	}

	@Override
	public double precioPorHora() {
		int[] cilindradas = {125, 250, 600, 1100};
		double[] preciosBase = {5, 6.25, 8.13, 11.25};
		double precioBase = 0;
		
		for(int i = 0; i < cilindradas.length ; i++) {
			if(this.cilindrada >= cilindradas[i]) precioBase = preciosBase[i];
		}
		
		return precioBase;
	}

	@Override
	public double precioPorDia() {
		int[] cilindradas = {125, 250, 600, 1100};
		int[] preciosBase = {40, 50, 65, 90};
		double precioBase = 0;
		
		for(int i = 0; i < cilindradas.length ; i++) {
			if(this.cilindrada >= cilindradas[i]) precioBase = preciosBase[i];
		}

		return precioBase;
	}

	@Override
	public double presupuesto(int dias) {
		return (dias * precioPorDia());
	}

	@Override
	public double presupuesto(byte horas) {
		return (horas * precioPorDia());
	}
	
	public Moto generarMoto() { // Metodo creado para poder dar de alta motos
		Scanner in = new Scanner(System.in);
		Moto moto = new Moto();
		
		System.out.print("Matricula: ");
		moto.setMatricula(in.nextLine());
		System.out.println();
		System.out.print("Cilindrada: ");
		moto.setCilindrada(in.nextInt());
		System.out.println();
		
		return moto;
	}

	/**
	 * @return the cilindrada
	 */
	public int getCilindrada() {
		return cilindrada;
	}

	/**
	 * @param cilindrada the cilindrada to set
	 */
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
}

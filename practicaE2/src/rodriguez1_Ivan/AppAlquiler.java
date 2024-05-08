package rodriguez1_Ivan;

import java.util.Scanner;

public class AppAlquiler {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ListaVehiculos obj = new ListaVehiculos();
		String matricula = "", dni = "";
		int resp = 0, tipo = 0, dias = 0;
		byte horas = 0, descuento = 0;
		
		try {
			do {
				System.out.println("|-----------------------------------------------|");
				System.out.println("|		Menu Vehiculos			|");
				System.out.println("|-----------------------------------------------|");
				System.out.println();
				System.out.println("0) Salir");
				System.out.println("1) Alta coche eléctrico");
				System.out.println("2) Alta coche combustión");
				System.out.println("3) Alta moto");
				System.out.println("4) Baja de vehículo");
				System.out.println("5) Consultar vehículos disponibles");
				System.out.println("6) Precio por hora");
				System.out.println("7) Precio por días");
				System.out.println("8) Presupuestos por horas");
				System.out.println("9) Presupuestos por días");
				System.out.println("10) Alquilar vehículo");
				System.out.println("11) Devolver vehículo");
				System.out.println("12) Modificar descuento coche");
				System.out.println("13) Guardar Fichero");
				System.out.println("14) Cargar datos Fichero");
				System.out.print("Opcion: ");
				resp = in.nextInt();
				in.nextLine();
				System.out.println();
				
				switch(resp) {
					case 0:
						System.out.println("Saliendo...");
						break;
						
					case 1:
						CocheElectrico cocheElec = new CocheElectrico();
						obj.addVehiculo(cocheElec.generarCoche());
						break;
						
					case 2:
						CocheCombustion cocheComb = new CocheCombustion();
						obj.addVehiculo(cocheComb.generarCoche());
						break;
						
					case 3:
						Moto moto = new Moto();
						obj.addVehiculo(moto.generarMoto());
						break;
						
					case 4:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.println();
						obj.bajaVehiculo(matricula);
						break;
						
					case 5:
						System.out.println("1) Coches Electricos");
						System.out.println("2) Coches de Combustión");
						System.out.println("3) Motos");
						System.out.print("Seleccionar: ");
						tipo = in.nextInt();
						System.out.println();
						obj.mostrarVehiculosDisponible(tipo);
						break;
						
					case 6:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.println();
						obj.precioPorHora(matricula);
						break;
						
					case 7:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.println();
						obj.precioPorDia(matricula);
						break;
						
					case 8:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.print("Horas: ");
						horas = in.nextByte();
						System.out.println();
						obj.presupuestoHoras(matricula, horas);
						break;
						
					case 9:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.print("Dias: ");
						dias = in.nextInt();
						System.out.println();
						obj.presupuestoDias(matricula, dias);
						break;
						
					case 10:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.print("DNI: ");
						dni = in.nextLine();
						System.out.println();
						obj.alquilar(matricula, dni);
						break;
						
					case 11:
						System.out.print("Matricula: ");
						matricula = in.nextLine();
						System.out.println();
						obj.devolver(matricula);
						break;
						
					case 12:
						CocheCombustion coche = new CocheCombustion();
						System.out.print("Dias: ");
						dias = in.nextInt();
						System.out.print("Descuento: ");
						descuento = in.nextByte();
						System.out.println();
						coche.modificarDescuento(dias, descuento);
						break;
						
					case 13:
						obj.guardarFichero();
						System.out.println("Fichero guardado");
						System.out.println();
						break;
						
					case 14:
						System.out.println("1) Coches Electricos");
						System.out.println("2) Coches de Combustión");
						System.out.println("3) Motos");
						System.out.println("4) Todos");
						System.out.print("Seleccionar: ");
						tipo = in.nextInt();
						System.out.println();
						obj.cargarDatos(tipo);
						break;
						
					default:
						System.out.println("Opcion introducidad no valida");
						System.out.println();
						break;
				}
			}while(resp != 0);
			
			}catch (Exception ex) {
				System.out.println();
				System.out.println("Error: " + ex.getMessage());
				System.out.println();
			}
		
	}

}

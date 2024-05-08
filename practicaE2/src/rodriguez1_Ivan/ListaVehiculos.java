package rodriguez1_Ivan;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaVehiculos {
	private ArrayList <Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

	public ListaVehiculos() {
		super();
	}

	public ListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
		super();
		this.listaVehiculos = listaVehiculos;
	}

	public void addVehiculo(Vehiculo vehiculo) {
		this.listaVehiculos.add(vehiculo);
		System.out.println("Vehiculo añadido");
		System.out.println();
	}
	
	public boolean bajaVehiculo(String matricula) {
		boolean borrado = false;
		Vehiculo vehiculo;
		
		Iterator<Vehiculo> it = this.listaVehiculos.iterator();
		while(it.hasNext()) {
			vehiculo = it.next();
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
				if(vehiculo.isAlquilado() == true) System.out.println("No se puede dar de baja, vehiculo actualmente alquilado");
				else {
					borrado = true;
					it.remove();
					System.out.println("Vehiculo dado de baja.");
				}
			}
		}
		System.out.println();
		return borrado;
	}
	
	public boolean alquilar(String matricula, String dni) {
		boolean alquilado = false;
		
		Vehiculo vehiculo = buscarVehiculo(matricula);
		if(vehiculo == null ) System.out.println("No existe el vehiculo");
		else {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
			alquilado = vehiculo.alquilar(dni);
			if(alquilado == false) System.out.println("No se puede alquilar, vehiculo actualmente alquilado");
			else System.out.println("Vehiculo alquilado.");
			}
		}
		System.out.println();
		return alquilado;
	}
	
	public boolean devolver(String matricula) {
		boolean devuelto = false;
		boolean existe = false;
		
		Vehiculo vehiculo = buscarVehiculo(matricula);
		if(vehiculo == null ) System.out.println("No existe el vehiculo");
		else {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) {
			existe = true;
			devuelto = vehiculo.devolver();
			if(devuelto == false) System.out.println("No se puede devolver, vehiculo actualmente no alquilado");
			else System.out.println("Vehiculo devuelto.");
			}
		}
		if(existe == false) System.out.println("No existe el vehiculo.");
		System.out.println();
		return devuelto;
	}
	
	public void mostrarVehiculosDisponible(int tipo) {
		switch(tipo) {
		case 1:
			for(Vehiculo vehiculo : this.listaVehiculos) {
				if(vehiculo instanceof CocheElectrico) ((CocheElectrico)vehiculo).imprimirDatos();
			}
			break;
		
		case 2:
			for(Vehiculo vehiculo : this.listaVehiculos) {
				if(vehiculo instanceof CocheCombustion) ((CocheCombustion)vehiculo).imprimirDatos();
			}
			break;
			
		case 3:
			for(Vehiculo vehiculo : this.listaVehiculos) {
				if(vehiculo instanceof Moto) ((Moto)vehiculo).imprimirDatos();
			}
			break;
			
		default:
			System.out.println("Opcion introducida no registrada");
			break;
		}
		System.out.println();
	}
	
	public Vehiculo buscarVehiculo(String matricula) {
		Vehiculo vehiculoDevolver = null;
		
		for(Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) vehiculoDevolver = vehiculo;
		}
		
		return vehiculoDevolver;
	}
	
	public void precioPorHora(String matricula) { // Metodo para mostrar el precio por hora de una matricula
		for(Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) System.out.println("Precio por Hora: " + vehiculo.precioPorHora());
		}
	}
	
	public void precioPorDia(String matricula) { // Metodo para mostrar el precio por dia de una matricula
		for(Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) System.out.println("Precio por Dia: " + vehiculo.precioPorDia());
		}
	}
	
	public void presupuestoDias(String matricula, int dias) { // Metodo para mostrar el presupuesto por dia de una matricula
		for(Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) System.out.println("Presupuesto por Dias: " + vehiculo.presupuesto(dias));
		}
	}
	
	public void presupuestoHoras(String matricula, byte horas) { // Metodo para mostrar el presupuesto por horas de una matricula
		for(Vehiculo vehiculo : this.listaVehiculos) {
			if(vehiculo.getMatricula().equalsIgnoreCase(matricula)) System.out.println("Presupuesto por Horas: " + vehiculo.presupuesto(horas));
		}
	}
	
	public void guardarFichero() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileOutputStream fichero = null;
		try {
			fichero = new FileOutputStream("vehiculos.dat");
			ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
			tuberia.writeObject(this.listaVehiculos);
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fichero.close();
			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void cargarDatos(int opcion) throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream fis;
		try {
			  fis = new FileInputStream("vehiculos.dat");
			  ObjectInputStream ois = new ObjectInputStream(fis);
			  ArrayList<Vehiculo> list = (ArrayList<Vehiculo>) ois.readObject();
			  ois.close();
			  switch(opcion) {
			  case 1:
				  for(Vehiculo vehiculo : list) {
				  	  if(vehiculo instanceof CocheElectrico) this.listaVehiculos.add(vehiculo);
				  }
				  System.out.println("Datos cargados.");
				  break;
				  
			  case 2:
				  for(Vehiculo vehiculo : list) {
				  	  if(vehiculo instanceof CocheCombustion) this.listaVehiculos.add(vehiculo);
				  }
				  System.out.println("Datos cargados.");
				  break;
				  
			  case 3:
				  for(Vehiculo vehiculo : list) {
				  	  if(vehiculo instanceof Moto) this.listaVehiculos.add(vehiculo);
				  }
				  System.out.println("Datos cargados.");
				  break;
				  
			  case 4:
				  for(Vehiculo vehiculo : list) {
				  	  this.listaVehiculos.add(vehiculo);
				  }
				  System.out.println("Datos cargados.");
				  break;
				  
			  default:
				  System.out.println("Opcion introducida no registrada");
				  break;
			  }
			  System.out.println();
		}catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}catch(IOException ex) {
			ex.printStackTrace();
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}

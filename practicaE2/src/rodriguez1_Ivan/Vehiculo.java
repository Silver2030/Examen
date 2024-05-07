package rodriguez1_Ivan;

public abstract class Vehiculo {
	private String matricula;
	private boolean alquilado;
	private String dni;
	
	public Vehiculo() {
		super();
	}

	public Vehiculo(String matricula) {
		super();
		this.matricula = matricula;
		this.alquilado = false;
		this.dni = "";
	}

	public boolean alquilar(String dni) {
		boolean alquilado = false;
		
		if(this.alquilado == false) {
			this.alquilado = true;
			this.dni = dni;
			alquilado = true;
		}
		
		return alquilado;
	}
	
	public boolean devolver() {
		boolean devolver = false;
		
		if(this.alquilado == true) {
			this.alquilado = false;
			this.dni = "";
			devolver = true;
		}
		
		return devolver;
	}
	
	public void imprimirDatos(){
		if(this.alquilado == true) {
			System.out.println("Matricula: " + this.matricula);
			System.out.println("Alquilado: " + this.alquilado);
		}else {
			System.out.println("Matricula: " + this.matricula);
			System.out.println("Alquilado: " + this.alquilado);
			System.out.println("DNI cliente: " + this.dni);
		}
		System.out.println();
	}
	
	public void alquilado() {
		System.out.println("Alquilado: " + this.alquilado);
		System.out.println();
	}
	
	public void dniCliente() {
		System.out.println("DNI cliente: " + this.dni);
		System.out.println();
	}
	
	public abstract double precioPorHora();
	
	public abstract double precioPorDia();
	
	public abstract double presupuesto(int dias);
	
	public abstract double presupuesto(byte horas);

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the alquilado
	 */
	public boolean isAlquilado() {
		return alquilado;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
}

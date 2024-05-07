package rodriguez1_Ivan;

public class Coche extends Vehiculo {
	private int numPuertas;
	private int potencia;
	private int[] dias = {10, 20, 30, 40, 50, 60, 70, 80, 90};
	private double[] descuentos = {0.97, 0.94, 0.93, 0.91, 0.90, 0.88, 0.87, 0.86, 0.85,};

	public Coche() {
		super();
	}
	
	public Coche(String matricula, int numPuertas, int potencia, int dias) {
		super(matricula);
		this.numPuertas = numPuertas;
		this.potencia = potencia;
	}
	
	public double descuento(int dias) {
		double descuento = 0.0;
		
		for(int i = 0; i < this.dias.length ; i++) {
			if(dias >= this.dias[i]) descuento = this.descuentos[i];
		}
		
		return descuento;
	}
	
	public void modificarDescuento(int dias, byte descuento) {
		double descuentoTotal = descuento / 100;
		
		if((descuentoTotal >= 0.0)&&(descuentoTotal <= 0.5)) {
			for(int i = 0; i < this.dias.length ; i++) {
				if(dias == this.dias[i]) {
					this.descuentos[i] = descuentoTotal;
					System.out.println("Descuento modificado.");
				}
			}
		}else System.out.println("Descuento introducido no valido.");
		System.out.println();
	}
	
	@Override
	public double precioPorHora() {
		return 0;
	}

	@Override
	public double precioPorDia() {
		return 0;
	}

	@Override
	public double presupuesto(int dias) {
		return 0;
	}

	@Override
	public double presupuesto(byte horas) {
		return 0;
	}

	/**
	 * @return the numPuertas
	 */
	public int getNumPuertas() {
		return numPuertas;
	}

	/**
	 * @param numPuertas the numPuertas to set
	 */
	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	/**
	 * @return the potencia
	 */
	public int getPotencia() {
		return potencia;
	}

	/**
	 * @param potencia the potencia to set
	 */
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	/**
	 * @return the dias
	 */
	public int[] getDias() {
		return dias;
	}

	/**
	 * @param dias the dias to set
	 */
	public void setDias(int[] dias) {
		this.dias = dias;
	}

	/**
	 * @return the descuentos
	 */
	public double[] getDescuentos() {
		return descuentos;
	}

	/**
	 * @param descuentos the descuentos to set
	 */
	public void setDescuentos(double[] descuentos) {
		this.descuentos = descuentos;
	}
	
}

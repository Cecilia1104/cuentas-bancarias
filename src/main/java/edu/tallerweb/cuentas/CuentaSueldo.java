package edu.tallerweb.cuentas;

/**
 * Es el tipo de cuenta m�s simple, ya que se rige por la premisa de que en
 * tanto y en cuanto se tenga tanto o m�s dinero en cuenta del que se quiere
 * extraer, la operaci�n se debe efectuar correctamente.
 */
public class CuentaSueldo extends AbstractCuenta {

	private Double saldo;

	public CuentaSueldo() {
		this.saldo = 0.0;
	}
	
	/**
	 * No hay reglas adicionales para el dep�sito
	 * @param monto a depositar
	 */
	public void depositar(final Double monto) {
		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"Los depositos no pueden ser negativos");
		}
		this.saldo += monto;
	}
	
	/**
	 * No hay reglas adicionales para la extracci�n
	 * @param monto a extraer
	 */
	public void extraer(final Double monto) {
		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"La extraccion no puede ser negativa");
		}
		if (monto > this.saldo) {
			throw new CuentaBancariaException(
					"Los fondos son insuficiente para extraer");
		}
		this.saldo -= monto;
	}
	
	/**
	 * Permite saber el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public Double getSaldo() {
		return this.saldo;
	}

}

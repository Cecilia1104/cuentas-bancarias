package edu.tallerweb.cuentas;

public class CuentaCorriente extends AbstractCuenta {

	private Double descubiertoTotal;// Es el que me brinda el banco
	private Double saldodescubierto;// ES el utilizado en la operacion
	private Double comision;
	private Double deposito;

	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal = descubiertoTotal;
		this.saldo = 0.0;

	}

	public void depositar(final Double monto) throws CuentaBancariaException {
		if (monto < 0.0)
			throw new CuentaBancariaException(
					"Los depositos deben ser positivos");
		else {
			this.saldo = this.descubiertoTotal + monto;
			deposito = monto;
		}

	}

	public void extraer(final Double monto) throws CuentaBancariaException {
		if (monto < 0.0)
			throw new CuentaBancariaException(
					"La cantidad a retirar debe ser positiva");
		if (monto > this.saldo)
			throw new CuentaBancariaException(
					"Los fondos son insuficientes para el retiro");
		else {
			saldodescubierto = monto - deposito;// Descubierto usado

			comision = saldodescubierto * 0.05;// Comision sobre el descubierto
												// usado

			this.saldo -= monto;// Saldo + Descubierto disponible

		}
		if (saldodescubierto < 0.0) {// El monto es suficiente para la
										// extraccion, no uso descubierto
			comision = 0.0;
			saldodescubierto = 0.0;
		}

	}

	public Double getSaldo() {
		return this.saldo;
	}

	public Double getSaldodescubierto() {
		return saldodescubierto;

	}

	public Double getComision() {
		return comision;
	}
}

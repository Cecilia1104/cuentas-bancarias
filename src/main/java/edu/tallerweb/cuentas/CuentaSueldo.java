package edu.tallerweb.cuentas;

public class CuentaSueldo extends AbstractCuenta {
	private double saldo;

	public CuentaSueldo() {
		this.saldo = 0.0;
	}

	public void depositar(final Double monto) {
		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"Los depositos no pueden ser negativos");
		}
		this.saldo += monto;
	}

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

	public Double getSaldo() {
		return this.saldo;
	}

}

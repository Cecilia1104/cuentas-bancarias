package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {
	private Integer ce;
	private Double adicional;
	private Double saldo;
	private Integer limite;

	public CajaAhorros() {
		this.saldo = 0.0;
		this.ce = 0;

	}

	public void depositar(final Double monto) {

		if (monto > 0.0) {
			this.saldo += monto;

		} else {
			throw new CuentaBancariaException(
					"Los depositos deber ser positivos");
		}
	}

	public void extraer(final Double monto) {
		this.ce++;

		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"La extraccion no puede ser negativa");

		} else {
			if (this.saldo > monto) {
				this.saldo -= monto;

				if (this.ce >= limite) {
					this.saldo -= this.adicional;

				} else {
					throw new CuentaBancariaException(
							"Saldo insuficiente para realizar la extraccion");
				}
			}
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

}

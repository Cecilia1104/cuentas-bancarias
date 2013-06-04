package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {
	private Integer ce;
	private Double adicional = 6.0;
	private Double saldo;
	private Integer limite = 6;

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

			} else {
				throw new CuentaBancariaException(
						"Saldo insuficiente para realizar la extraccion");
			}
			if (this.ce >= limite) {
				this.saldo -= adicional;

			}
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

}

package edu.tallerweb.cuentas;

public class CajaAhorros extends AbstractCuenta {
	private Integer ce;
	private Double adicional;

	public CajaAhorros() {
		this.saldo = 0.0;
		this.ce = 0;
		this.adicional = 6.0;

	}

	public void depositar(final Double monto) throws CuentaBancariaException {

		if (monto < 0.0)
			throw new CuentaBancariaException(
					"Los depositos deber ser positivos");
		this.saldo += monto;
	}

	public void extraer(final Double monto) throws CuentaBancariaException {
		this.ce++;

		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"La extraccion no puede ser negativa");

		} else {
			if (this.saldo > monto) {
				this.saldo -= monto;

				if (this.ce >= 6)
					this.saldo -= this.adicional;

			} else
				throw new CuentaBancariaException(
						"Saldo insuficiente para realizar la extraccion");
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

}

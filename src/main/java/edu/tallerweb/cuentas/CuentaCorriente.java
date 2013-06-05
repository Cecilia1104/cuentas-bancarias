package edu.tallerweb.cuentas;

public class CuentaCorriente extends AbstractCuenta {
	private Double saldo;
	private Double descubiertoTotal; // Es el que me brinda el banco
	private Double descubierto; // ES el utilizado en la operacion
	private Double descubiertofinal; // El que me queda para la prox operacion
	private Double descubiertolibre;
	private final Double comision = 0.05;
	private Double total;

	public CuentaCorriente(final Double descubiertoTotal) {
		this.descubiertoTotal = descubiertoTotal;
		this.saldo = 0.0;
	}

	public void depositar(final Double monto) {

		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"Los depositos deben ser positivos");
		} else {
			this.saldo += monto;
			total = this.descubiertoTotal + monto;
		}
	}

	public void extraer(final Double monto) {

		if (monto < 0.0) {
			throw new CuentaBancariaException(
					"La cantidad a retirar debe ser positiva");
		}
		if (monto < this.saldo) {
			this.saldo -= monto;
		} else {

			if (monto < total) {
				descubierto = (monto - this.saldo);
				descubiertolibre = this.descubiertoTotal - descubierto;
				descubiertofinal = descubiertolibre - (descubierto * comision);
				this.saldo = 0.0;

			} else {
				throw new CuentaBancariaException(
						"Saldo insuficiente para realizar la operacion");
			}
		}
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public Double getDescubierto() {
		return descubiertofinal;
	}
}

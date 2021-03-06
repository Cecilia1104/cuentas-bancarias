package edu.tallerweb.cuentas;

import org.junit.Assert;
import org.junit.Test;

public class CuentaTests {

	// Cuenta Sueldo
	@Test
	public void queVerifiqueLaConsignaSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(4000.0);

		Assert.assertEquals(
				"al depositar $ 4000.0 en una cuenta vacia, tiene $ 4000.0",
				4000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(500.0);

		Assert.assertEquals(
				"al extraer $ 500.0 de una cuenta con $ 4000.0 se obtienen $ 3500.0",
				3500.0, cuenta.getSaldo(), 0.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionSaldoInsuficienteSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoSePuedeExtraerNegativoSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(3500.0);

		cuenta.extraer(-1000.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoSePuedeDepositarNegativoSueldo() {
		CuentaSueldo cuenta = new CuentaSueldo();
		cuenta.depositar(-500.0);

	}

	// Caja de Ahorros
	@Test
	public void queVerifiqueLaConsignaCaja() {
		CajaAhorros cuenta = new CajaAhorros();

		cuenta.depositar(3000.0);
		Assert.assertEquals(
				"al depositar $ 3000.0 en una cuenta vacia, tiene $ 3000.0",
				3000.0, cuenta.getSaldo(), 0.0);

		cuenta.extraer(50.0);
		Assert.assertEquals(
				"al extraer $ 50.0 de una cuenta con $ 3000.0 se obtienen $ 2950.0 con adicional $0",
				2950.0, cuenta.getSaldo(), 0.0);
		cuenta.extraer(50.0);

		cuenta.extraer(50.0);

		cuenta.extraer(50.0);

		cuenta.extraer(50.0);

		cuenta.extraer(100.0);

		cuenta.extraer(300.0);
		Assert.assertEquals(
				"al extraer $ 600.0 de una cuenta con $ 2950.0 se obtienen $ 2350.0 con adicional $12.0 por ser la septima",
				2338, cuenta.getSaldo(), 0.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionSaldoInsuficente() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(3500.0);

		cuenta.extraer(4000.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoSePuedeExtraerNegativoCaja() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(3500.0);

		cuenta.extraer(-1000.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoSePuedeDepositarNegativoCaja() {
		CajaAhorros cuenta = new CajaAhorros();
		cuenta.depositar(-1500.0);

		cuenta.extraer(1000.0);
	}

	// Cuenta Corriente
	@Test
	public void queSePuedeDepositarEnUnaCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(0.0);
		cuenta.depositar(1000.0);

		Assert.assertEquals(
				"al depositar $ 1000.0 en una cuenta vacia, tiene $ 1000.0",
				1000.0, cuenta.getSaldo(), 0.0);
	}

	@Test
	public void queSePuedeExtraerEnUnaCuentaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(0.0);
		cuenta.depositar(1000.0);
		cuenta.extraer(100.0);
		Assert.assertEquals(
				"al extraer $ 100.0 en una cuenta con $1000.0, tiene $ 900.0",
				900.0, cuenta.getSaldo(), 0.0);
	}

	@Test
	public void queVerifiqueLaConsignaCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(500.0);

		cuenta.depositar(1000.0);

		cuenta.extraer(1100.0);

		Assert.assertEquals(
				"al extraer $ 1100.0 de la cuenta me queda: $0 de saldo ", 0.0,
				cuenta.getSaldo(), 0.0);

		Assert.assertEquals("y el descubierto es de $395", 395,
				cuenta.getDescubierto(), 0.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoPoderExtraerNegativoCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1000.0);

		cuenta.depositar(3000.0);

		cuenta.extraer(-1000.0);
	}

	@Test(expected = CuentaBancariaException.class)
	public void queVerifiqueLaConsignaExceptionNoPuedoDepositarNegativoCorriente() {
		CuentaCorriente cuenta = new CuentaCorriente(1000.0);

		cuenta.depositar(-500.0);

	}

	@Test(expected = CuentaBancariaException.class)
	public void queNoSePuedeExtraerEnDescubiertoDeUnaCuentaCorrienteMasDelDisponibleConImpuesto() {
		CuentaCorriente cuenta = new CuentaCorriente(1000.0);
		cuenta.depositar(100.0);
		cuenta.extraer(3000.0);

	}

}

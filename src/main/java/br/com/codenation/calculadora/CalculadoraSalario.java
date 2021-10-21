package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public static long calcularSalarioLiquido(double salarioBase) {
		//Documentação do método: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-
		return Math.round(calcularIrrf(salarioBase));
	}

	private static double calcularInss(double salarioBase) {
		double salarioComDescontoInss = salarioBase;
		if (salarioBase <= 1039) {
			return 0;
		} else if (salarioBase <= 1500) {
			salarioComDescontoInss = salarioBase - salarioBase * (0.08);
		} else if (salarioBase > 1500 && salarioBase <= 4000) {
			salarioComDescontoInss = salarioBase - salarioBase * (0.09);
		} else if (salarioBase > 4000) {
			salarioComDescontoInss = salarioBase - salarioBase * (0.11);
		}
		return salarioComDescontoInss;
	}

	private static double calcularIrrf(double salarioBase) {
		double salarioInss = calcularInss(salarioBase);

		if (salarioInss > 3000 && salarioInss <= 6000) {
			salarioInss -= salarioInss * (0.075);
		} else if (salarioInss > 6000) {
			salarioInss -= salarioInss * (0.15);
		}
		return salarioInss;
	}
}
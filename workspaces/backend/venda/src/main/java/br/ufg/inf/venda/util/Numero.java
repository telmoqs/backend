package br.ufg.inf.venda.util;

public class Numero {

	private static Numero numero = new Numero();

	/**
	 * @deprecated utilize os metodos estaticos ou o metodo getInstance() para
	 *             obter uma instancia
	 */
	public Numero() {
		numero = this;
	}

	public static Numero getInstance() {
		if (numero == null) {
			numero = new Numero();
		}
		return numero;
	}

	/**
	 * Remove a formatação do CPF
	 * 
	 * @param cpf
	 *            CPF formatado
	 * @return CPF sem formatação
	 */
	public static String removerFormatoCPF(String cpf) {
		return cpf.trim().replaceAll("(\\.|\\-)+", "");
	}

	/**
	 * Remove a formatação do CEP - Código de Endereçamento Postal
	 * 
	 * @param cep
	 *            CEP formatado
	 * @return CEP sem formatação
	 */
	public static String removerFormatoCEP(String cep) {
		return cep.trim().replaceAll("(\\.|\\-)+", "");
	}

	/**
	 * Remover o formatação do telefone
	 * 
	 * @param fone
	 *            Número do telefone formatado
	 * @return Número telefone sem formatação
	 */
	public static String removerFormatoFone(String fone) {
		return fone.trim().replaceAll("(\\(|\\)|\\-)+", "");
	}

	/**
	 * Formata valores de CPF
	 * 
	 * @param Numero
	 *            CPF a ser formatado
	 * @deprecated utilize o método formatarCpf(String numero)
	 */
	public String FormatarCPF(String Numero) {
		String AuxCPF = Numero.trim();
		while (AuxCPF.length() < 11)
			AuxCPF = "0" + AuxCPF;
		AuxCPF = AuxCPF.substring(0, 3) + "." + AuxCPF.substring(3, 6) + "." + AuxCPF.substring(6, 9) + "-" + AuxCPF.substring(9, 11);
		return AuxCPF;
	}

	/**
	 * Formata valores de CPF
	 * 
	 * @param Numero
	 *            CPF a ser formatado
	 */
	static public String formatarCpf(String numero) {
		return getInstance().FormatarCPF(numero);
	}

	public String formatarFone(String fone) {
		String foneAux = fone.trim();
		return "(" + foneAux.substring(0, 2) + ")" + foneAux.substring(2, 6) + "-" + foneAux.substring(6);
	}

	/**
	 * valida valores do CPF
	 * 
	 * @param Numero
	 *            CPF
	 * @return <i> true </i> se CPF é válido e <i> false </i> se CPF não é
	 *         valido
	 */
	public static boolean validarCPF(String xCPF) {
		try {
			// Testa se o CPF é válido ou não
			int d1, d4, xx, nCount, resto, digito1, digito2;
			String Check;
			String Separadores = "/-.";
			d1 = 0;
			d4 = 0;
			xx = 1;
			for (nCount = 0; nCount < xCPF.length() - 2; nCount++) {
				String s_aux = xCPF.substring(nCount, nCount + 1);

				if (Separadores.indexOf(s_aux) == -1) {
					d1 = d1 + (11 - xx) * Integer.valueOf(s_aux).intValue();
					d4 = d4 + (12 - xx) * Integer.valueOf(s_aux).intValue();
					xx++;
				}
				;
			}
			;
			resto = (d1 % 11);
			if (resto < 2) {
				digito1 = 0;
			} else {
				digito1 = 11 - resto;
			}

			d4 = d4 + 2 * digito1;
			resto = (d4 % 11);
			if (resto < 2) {
				digito2 = 0;
			} else {
				digito2 = 11 - resto;
			}

			Check = String.valueOf(digito1) + String.valueOf(digito2);

			String s_aux2 = xCPF.substring(xCPF.length() - 2, xCPF.length());

			if (s_aux2.compareTo(Check) != 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}
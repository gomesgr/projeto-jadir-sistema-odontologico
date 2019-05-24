package br.edu.unicid.util;

public class ManipuladorDeString {
	
	public static String transformarRg(String rg) {
		String valueToBeReturned = "";
		char[] vec = rg.toCharArray();
		for (int i = 0; i < rg.length(); i++) {
			switch (i) {
			case 5:
			case 2:
				valueToBeReturned += "." + vec[i];
				break;
			case 8:
				valueToBeReturned += "-" + vec[i];
				break;
			default:
				valueToBeReturned += vec[i];
				break;
			}
		}
		return valueToBeReturned;
	}

	public static String transformarCpf(String cpf) {
		char[] vec = cpf.toCharArray();
		String n = "";
		for (int i = 0; i < cpf.length(); i++) {
			switch (i) {
			case 6:
			case 3:
				n += "." + vec[i];
				break;
			case 9:
				n += "-" + vec[i];
				break;
			default:
				n += vec[i];
				break;
			}
		}
		return n;
	}
}
package br.com.fiap.fintech.util.tests;

import br.com.fiap.fintech.util.criptography.CriptografiaUtils;

public class TesteCriptografia {

	public static void main(String[] args) {
		
		try {
			System.out.println(CriptografiaUtils.criptografar("123456"));
			System.out.println(CriptografiaUtils.criptografar("123456"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

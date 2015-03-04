package br.com.cf.entity;

public class GeradorDeSenhas {

	public GeradorDeSenhas() {
	}

	public static void main(String[] args) {

		for (int i = 0; i <= 2085; i++) {
			String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8",
					"9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
					"l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
					"x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I",
					"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
					"V", "W", "X", "Y", "Z" };

			String senha = "";

		for (int x = 0; x < 10; x++) {
				int j = (int) (Math.random() * carct.length);
				senha += carct[j];

		}

			System.out.println(senha);
		}
	}
}

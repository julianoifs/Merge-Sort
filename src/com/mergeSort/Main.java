package com.mergeSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] vetorA = new int[10];
        int[] vetorOrdenado = new int[vetorA.length];

        // vetor desordenado
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = 1 + (int) (Math.random() * vetorA.length);
        }
        System.out.println("*** Vetor Desordenado ***");
        System.out.print(Arrays.toString(vetorA) + "\n");

        mergesort(vetorA, vetorOrdenado, 0, vetorA.length - 1);
		System.out.println("\n*** Vetor Ordenado ***");
		System.out.print(Arrays.toString(vetorA) + "\n");

    }

    public static void mergesort(int[] v, int[] w, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
            
			mergesort(v, w, inicio, meio);
			mergesort(v, w, meio + 1, fim);
			intercalar(v, w, inicio, meio, fim);
		}
	}

	private static void intercalar(int[] v, int[] w, int inicio, int meio, int fim) {
		for (int k = inicio; k <= fim; k++) {
			w[k] = v[k];
		}
		int i = inicio;
		int j = meio + 1;

		for (int k2 = inicio; k2 <= fim; k2++) {
			if (i > meio) {
				v[k2] = w[j++];
			} else if (j > fim) {
				v[k2] = w[i++];
			} else if (w[i] < w[j]) {
				v[k2] = w[i++];
			} else {
				v[k2] = w[j++];
			}
		}
	}
}

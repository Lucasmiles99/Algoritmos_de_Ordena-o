package Tipos_de_Algoritmos;

import java.util.Arrays;

public class RadixSort {

    private static int comparacoes = 0;
    private static int trocas = 0;

    // Função principal para fazer o Radix Sort
    public void sort(int[] arr) {
        int max = getMax(arr);

        // Aplica o counting sort para cada dígito. Note que o divisor exp é usado para pegar o dígito.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Função para obter o maior valor no array
    int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            comparacoes++; // Comparação
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Função para fazer o counting sort de arr[] de acordo com o dígito representado por exp
    void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // Array de saída
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Conta o número de ocorrências de cada dígito
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Muda count[i] para que count[i] contenha a posição de arr[i] no array de saída
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            trocas++; // Troca
        }

        // Copia o array de saída para arr[], para que arr[] contenha os números ordenados de acordo com o dígito atual
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Método principal para testar o Radix Sort
    public static void main(String[] args) {
        int[] vetorAleatorio100k = new int[100000];
        int[] vetorOrdenado100k = new int[100000];
        int[] vetorInvertido100k = new int[100000];
        
        for (int i = 0; i < 100000; i++) {
            vetorAleatorio100k[i] = (int)(Math.random() * 100000);
            vetorOrdenado100k[i] = i;
            vetorInvertido100k[i] = 100000 - i;
        }

        RadixSort radixSort = new RadixSort();

        System.out.println("Vetor Aleatório (100k elementos):");
        resetMetrics();
        long inicio = System.currentTimeMillis();
        radixSort.sort(vetorAleatorio100k);
        long fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Ordenado (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        radixSort.sort(vetorOrdenado100k);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Invertido (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        radixSort.sort(vetorInvertido100k);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        int[] vetorAleatorio1M = new int[1000000];
        int[] vetorOrdenado1M = new int[1000000];
        int[] vetorInvertido1M = new int[1000000];
        
        for (int i = 0; i < 1000000; i++) {
            vetorAleatorio1M[i] = (int)(Math.random() * 1000000);
            vetorOrdenado1M[i] = i;
            vetorInvertido1M[i] = 1000000 - i;
        }

        System.out.println("Vetor Aleatório (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        radixSort.sort(vetorAleatorio1M);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Ordenado (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        radixSort.sort(vetorOrdenado1M);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Invertido (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        radixSort.sort(vetorInvertido1M);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
    }

    private static void resetMetrics() {
        comparacoes = 0;
        trocas = 0;
    }

    private static void printMetrics(long inicio, long fim) {
        long tempoGasto = fim - inicio;
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo gasto: " + tempoGasto + " ms");
    }
}
package Tipos_de_Algoritmos;

import java.util.Random;

public class QuickSort {

    private static int comparacoes = 0;
    private static int trocas = 0;

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = medianOfThreePartition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int medianOfThreePartition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(arr, low, mid, high);
        swap(arr, pivotIndex, high); // Move pivot to end
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparacoes++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                trocas++;
            }
        }

        swap(arr, i + 1, high);
        trocas++;

        return i + 1;
    }

    private static int medianOfThree(int[] arr, int low, int mid, int high) {
        if (arr[low] > arr[mid]) {
            swap(arr, low, mid);
        }
        if (arr[low] > arr[high]) {
            swap(arr, low, high);
        }
        if (arr[mid] > arr[high]) {
            swap(arr, mid, high);
        }
        return mid;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] vetorAleatorio100k = new int[100000];
        int[] vetorOrdenado100k = new int[100000];
        int[] vetorInvertido100k = new int[100000];

        Random rand = new Random();

        for (int i = 0; i < 100000; i++) {
            vetorAleatorio100k[i] = rand.nextInt(100000);
            vetorOrdenado100k[i] = i;
            vetorInvertido100k[i] = 100000 - i;
        }

        System.out.println("Vetor Aleatório (100k elementos):");
        resetMetrics();
        long inicio = System.currentTimeMillis();
        quickSort(vetorAleatorio100k, 0, vetorAleatorio100k.length - 1);
        long fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Ordenado (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        quickSort(vetorOrdenado100k, 0, vetorOrdenado100k.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Invertido (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        quickSort(vetorInvertido100k, 0, vetorInvertido100k.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        int[] vetorAleatorio1M = new int[1000000];
        int[] vetorOrdenado1M = new int[1000000];
        int[] vetorInvertido1M = new int[1000000];

        for (int i = 0; i < 1000000; i++) {
            vetorAleatorio1M[i] = rand.nextInt(1000000);
            vetorOrdenado1M[i] = i;
            vetorInvertido1M[i] = 1000000 - i;
        }

        System.out.println("Vetor Aleatório (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        quickSort(vetorAleatorio1M, 0, vetorAleatorio1M.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Ordenado (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        quickSort(vetorOrdenado1M, 0, vetorOrdenado1M.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);

        System.out.println("Vetor Invertido (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        quickSort(vetorInvertido1M, 0, vetorInvertido1M.length - 1);
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
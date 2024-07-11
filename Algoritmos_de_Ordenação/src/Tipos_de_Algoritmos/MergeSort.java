package Tipos_de_Algoritmos;

public class MergeSort {
    
    private static int comparacoes = 0;
    private static int trocas = 0;

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        System.arraycopy(arr, left, L, 0, n1);
        System.arraycopy(arr, mid + 1, R, 0, n2);
        
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            comparacoes++; // Comparação
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
                trocas++; // Troca
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
            trocas++; // Troca
        }
        
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
            trocas++; // Troca
        }
    }

    public static void main(String[] args) {
        int[] vetorAleatorio100k = new int[100000];
        int[] vetorOrdenado100k = new int[100000];
        int[] vetorInvertido100k = new int[100000];
        
        for (int i = 0; i < 100000; i++) {
            vetorAleatorio100k[i] = (int)(Math.random() * 100000);
            vetorOrdenado100k[i] = i;
            vetorInvertido100k[i] = 100000 - i;
        }

        System.out.println("Vetor Aleatório (100k elementos):");
        resetMetrics();
        long inicio = System.currentTimeMillis();
        mergeSort(vetorAleatorio100k, 0, vetorAleatorio100k.length - 1);
        long fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Ordenado (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        mergeSort(vetorOrdenado100k, 0, vetorOrdenado100k.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Invertido (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        mergeSort(vetorInvertido100k, 0, vetorInvertido100k.length - 1);
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
        mergeSort(vetorAleatorio1M, 0, vetorAleatorio1M.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Ordenado (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        mergeSort(vetorOrdenado1M, 0, vetorOrdenado1M.length - 1);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Invertido (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        mergeSort(vetorInvertido1M, 0, vetorInvertido1M.length - 1);
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
package Tipos_de_Algoritmos;

public class HeapSort {

    private static int comparacoes = 0;
    private static int trocas = 0;
    
    public void sort(int arr[]) {
        int n = arr.length;

        // Constrói o heap (rearranja o array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extrai um por um os elementos do heap
        for (int i = n - 1; i >= 0; i--) {
            // Move a raiz atual para o final
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            trocas++; // Troca

            // Chama max heapify na heap reduzida
            heapify(arr, i, 0);
        }
    }

    // Para rearranjar uma subárvore com a raiz em node i, que é um índice em arr[]. n é o tamanho do heap
    void heapify(int arr[], int n, int i) {
        int largest = i; // Inicializa largest como raiz
        int left = 2 * i + 1; // left = 2*i + 1
        int right = 2 * i + 2; // right = 2*i + 2

        // Se o filho da esquerda é maior que a raiz
        comparacoes++; // Comparação
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Se o filho da direita é maior que largest até agora
        comparacoes++; // Comparação
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Se largest não é a raiz
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            trocas++; // Troca

            // Recursivamente heapify a subárvore afetada
            heapify(arr, n, largest);
        }
    }

    // Método principal para testar o Heap Sort
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
        new HeapSort().sort(vetorAleatorio100k);
        long fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Ordenado (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        new HeapSort().sort(vetorOrdenado100k);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Invertido (100k elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        new HeapSort().sort(vetorInvertido100k);
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
        new HeapSort().sort(vetorAleatorio1M);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Ordenado (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        new HeapSort().sort(vetorOrdenado1M);
        fim = System.currentTimeMillis();
        printMetrics(inicio, fim);
        
        System.out.println("Vetor Invertido (1M elementos):");
        resetMetrics();
        inicio = System.currentTimeMillis();
        new HeapSort().sort(vetorInvertido1M);
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
package Tipos_de_Algoritmos;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        int comparacoes = 0;
        long trocas = 0;
        long inicio = System.currentTimeMillis();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    // Troca os elementos
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocas++;
                }
            }
        }
        
        long fim = System.currentTimeMillis();
        long tempoGasto = fim - inicio;
        
        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo gasto: " + tempoGasto + " ms");
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
        bubbleSort(vetorAleatorio100k.clone());
        
        System.out.println("Vetor Ordenado (100k elementos):");
        bubbleSort(vetorOrdenado100k.clone());
        
        System.out.println("Vetor Invertido (100k elementos):");
        bubbleSort(vetorInvertido100k.clone());

        int[] vetorAleatorio1M = new int[1000000];
        int[] vetorOrdenado1M = new int[1000000];
        int[] vetorInvertido1M = new int[1000000];
        
        for (int i = 0; i < 1000000; i++) {
            vetorAleatorio1M[i] = (int)(Math.random() * 1000000);
            vetorOrdenado1M[i] = i;
            vetorInvertido1M[i] = 1000000 - i;
        }

        System.out.println("Vetor Aleatório (1M elementos):");
        bubbleSort(vetorAleatorio1M.clone());
        
        System.out.println("Vetor Ordenado (1M elementos):");
        bubbleSort(vetorOrdenado1M.clone());
        
        System.out.println("Vetor Invertido (1M elementos):");
        bubbleSort(vetorInvertido1M.clone());
    }
}
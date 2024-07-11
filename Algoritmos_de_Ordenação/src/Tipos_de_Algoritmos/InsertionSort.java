package Tipos_de_Algoritmos;

public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int n = arr.length;
        long comparacoes = 0;
        long trocas = 0;
        long inicio = System.currentTimeMillis();

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            comparacoes++;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
                comparacoes++;
                trocas++;
            }
            arr[j + 1] = key;
        }

        long fim = System.currentTimeMillis();
        long tempoGasto = fim - inicio;

        System.out.println("Comparações: " + comparacoes);
        System.out.println("Trocas: " + trocas);
        System.out.println("Tempo gasto: " + tempoGasto + " ms");
    }

    public static void main(String[] args) {
        // Teste com 100k elementos
        testarVetor(100000);

        // Teste com 1M elementos
        testarVetor(1000000);
    }

    private static void testarVetor(int tamanho) {
        int[] vetorAleatorio = new int[tamanho];
        int[] vetorOrdenado = new int[tamanho];
        int[] vetorInvertido = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = (int) (Math.random() * tamanho);
            vetorOrdenado[i] = i;
            vetorInvertido[i] = tamanho - i;
        }

        System.out.println("Vetor Aleatório (" + tamanho + " elementos):");
        insertionSort(vetorAleatorio.clone());

        System.out.println("Vetor Ordenado (" + tamanho + " elementos):");
        insertionSort(vetorOrdenado.clone());

        System.out.println("Vetor Invertido (" + tamanho + " elementos):");
        insertionSort(vetorInvertido.clone());
    }
}
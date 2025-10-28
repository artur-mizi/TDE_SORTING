public class SelectionSort {

    static long iteracoes = 0;
    static long trocas = 0;

    public static void selectionSort(int tamanho, int[] vetor) {
        for (int i = 0; i < tamanho - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < tamanho; j++) {
                if (vetor[j] < vetor[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = vetor[i];
                vetor[i] = vetor[minIndex];
                vetor[minIndex] = temp;
                trocas++;
            }
        }
        iteracoes++;
    }

    public static void printVetor(String titulo, int[] v) {
        System.out.print(titulo + ": ");
        for (int x : v) System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {

        int[] vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28};
        int[] vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32};
        int[] vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6};

        int[][] vetores = {vetor1, vetor2, vetor3};

        for (int n = 0; n < vetores.length; n++) {
            System.out.println("\n-----");
            System.out.println("Ordenando vetor " + (n + 1));

            int[] atual = vetores[n].clone();
            printVetor("Vetor original", atual);

            iteracoes = 0;
            trocas = 0;

            selectionSort(atual.length, atual);

            printVetor("Vetor final ordenado", atual);
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println("Trocas: " + trocas);
            System.out.println("-----\n");
        }
    }
}

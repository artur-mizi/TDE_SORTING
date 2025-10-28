public class GnomeSort {

    static long iteracoes = 0;
    static long trocas = 0;

    public static void gnomeSort(int[] vetor) {
        int i = 0;
        int n = vetor.length;

        while (i < n) {
            if (i == 0 || vetor[i - 1] <= vetor[i]) {
                i++;
            } else {
                int tmp = vetor[i];
                vetor[i] = vetor[i - 1];
                vetor[i - 1] = tmp;
                trocas++;
                i--;
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

            gnomeSort(atual);

            printVetor("Vetor final ordenado", atual);
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println("Trocas: " + trocas);
            System.out.println("-----\n");

            iteracoes = 0;
            trocas = 0;
        }
    }
}

public class CombSort {

    static long trocas = 0;
    static long iteracoes = 0;

    public static void combSort(int[] A) {
        int n = A.length;
        int gap = n;
        boolean sorted = false;

        while (!sorted) {
            iteracoes++;
            gap = (int) (gap / 1.3);
            if (gap <= 1) {
                gap = 1;
                sorted = true;
            }

            for (int i = 0; i < n - gap; i++) {
                int sm = i + gap;
                if (A[i] > A[sm]) {
                    int aux = A[sm];
                    A[sm] = A[i];
                    A[i] = aux;
                    trocas += 3;
                    sorted = false;
                }
            }
        }
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

            trocas = 0;
            iteracoes = 0;

            combSort(atual);

            printVetor("Vetor final ordenado", atual);
            System.out.println("Iteracoes: " + iteracoes);
            System.out.println("trocas: " + trocas);
            System.out.println("-----n");
        }
    }
}

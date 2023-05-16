import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSort {

    // Implementação do algoritmo Insertion Sort
    public static void insertionSort(int[] array) {
        int n = array.length;
        int trocas = 0;
        int comparacoes = 0;
        for (int i = 1; i < n; i++) {  // a chave vai iniciar no indice 1
            int chave = array[i];
            int j = i - 1;  // J vai representar o elemento anterior
            while (j >= 0 && array[j] > chave) {  // aqui estou dizendo que enquanto o elemento chave for menor que o elemento anterior e o elemento anterior for maior ou igual a 0
                array[j + 1] = array[j]; //ele desloca o elemento anterior a uma posição a direita
                j--;
                trocas++;
                comparacoes++;
            }
            // aqui insiro o elemento atual na posição correta
            array[j + 1] = chave;
            trocas++;
        }
        System.out.printf("Número de trocas: %d\n", trocas);
        System.out.printf("Número de comparações: %d\n", comparacoes);
    }
    public static void main(String[] args) {
        Scanner tc = new Scanner(System.in);
        System.out.println("Digite o tamanho do array: ");
        int n = tc.nextInt();
        int[] array = new int[n];
        System.out.println("Deseja gerar números aleatórios? (s/n)");
        char opcao = tc.next().charAt(0);
        // Preenchimento do array com números aleatórios ou input do usuário
        if (opcao == 's' || opcao == 'S') {
            Random r = new Random();
            for (int i = 0; i < n; i++) {
                array[i] = r.nextInt(1000);
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.printf("Digite o %dº número: ", i + 1);
                array[i] = tc.nextInt();
            }
        }
        tc.close();

        System.out.println("Array original: " + Arrays.toString(array)); // imprimo o array passado pelo usuário
        long inicio = System.currentTimeMillis(); // inicio o cronometro
        insertionSort(array); // Chama o algoritmo de ordenação
        long fim = System.currentTimeMillis(); // finaliza o cronometro
        long tempoDeExecucao = fim - inicio;  // subtraio o inicio e o fim do cronometro pra descobrir o tempo gasto
        System.out.println("Array ordenado: " + Arrays.toString(array)); // imprimo o array ordenado
        System.out.printf("Tempo levado para ordenar o array: " + tempoDeExecucao + " milissegundos");
    }
}
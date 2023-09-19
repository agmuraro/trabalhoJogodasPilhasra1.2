import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o tamanho das pilhas: ");
        int tamanho = scanner.nextInt();
        System.out.print("Digite 1 para ordem crescente ou 2 para ordem decrescente: ");
        int ordem = scanner.nextInt();

        Jogo jogo = new Jogo(tamanho, ordem);
        jogo.jogar();
    }
}
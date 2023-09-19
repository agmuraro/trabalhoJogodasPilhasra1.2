import java.util.Random;
import java.util.Scanner;

class Jogo {
    private Pilha pilha1;
    private Pilha pilha2;
    private Pilha pilha3;
    private int tamanho;
    private int ordem;
    private int jogadas = 0;

    public Jogo(int tamanho, int ordem) {
        this.tamanho = tamanho;
        this.ordem = ordem;
        pilha1 = new Pilha(ordem);
        pilha2 = new Pilha(ordem);
        pilha3 = new Pilha(ordem);

        Random random = new Random();

        for (int i = 0; i < tamanho; i++) {
            pilha1.push(random.nextInt(100) + 1);
        }
    }

    public void jogar() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPilha 1: " + pilha1);
            System.out.println("Pilha 2: " + pilha2);
            System.out.println("Pilha 3: " + pilha3);

            System.out.println("\nMenu de opções:");
            System.out.println("0 - Sair do jogo");
            System.out.println("1 - Movimentar");
            System.out.println("2 - Solução automática");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 0:
                    System.out.println("Jogo encerrado.");
                    return;
                case 1:
                    System.out.print("Informe a pilha de origem (1, 2, ou 3): ");
                    int origem = scanner.nextInt();
                    System.out.print("Informe a pilha de destino (1, 2, ou 3): ");
                    int destino = scanner.nextInt();

                    Pilha pilhaOrigem = null;
                    Pilha pilhaDestino = null;

                    if (origem == 1) {
                        pilhaOrigem = pilha1;
                    } else if (origem == 2) {
                        pilhaOrigem = pilha2;
                    } else if (origem == 3) {
                        pilhaOrigem = pilha3;
                    }

                    if (destino == 1) {
                        pilhaDestino = pilha1;
                    } else if (destino == 2) {
                        pilhaDestino = pilha2;
                    } else if (destino == 3) {
                        pilhaDestino = pilha3;
                    }

                    if (pilhaOrigem != null && pilhaDestino != null) {
                        if (pilhaOrigem.validaMovimento(pilhaDestino)) {
                            int valor = pilhaOrigem.pop();
                            pilhaDestino.push(valor);

                            if ((pilha1.size() == tamanho && pilha1.validaOrdenacao()) ||
                                    (pilha2.size() == tamanho && pilha2.validaOrdenacao()) ||
                                    (pilha3.size() == tamanho && pilha3.validaOrdenacao())) {
                                jogadas++;
                                System.out.println("Ordenação concluída em " + jogadas + " jogadas.");
                                System.out.println("Pilha 1 organizada: " + pilha1);
                                return;
                            }
                            jogadas++; // Incrementa jogadas após um movimento
                        } else {
                            System.out.println("Movimento inválido. Tente novamente.");
                        }
                    }
                    break;
                case 2:
                    pilha1.ordenar();
                    System.out.println("Solução automática aplicada. Pilha 1 organizada.");
                    System.out.println("Ordenação concluída em " + jogadas + " jogadas.");
                    System.out.println("Pilha 1 organizada: " + pilha1);
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
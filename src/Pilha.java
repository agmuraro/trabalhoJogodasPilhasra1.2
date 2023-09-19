
import java.util.Stack;

class Pilha extends Stack<Integer> {
    private int ordem;

    public Pilha(int ordem) {
        this.ordem = ordem;
    }

    public boolean validaMovimento(Pilha destino) {
        if (destino.isEmpty()) {
            return true;
        }
        int topoDestino = destino.peek();
        int topoOrigem = this.peek();
        return (ordem == 1 && topoOrigem < topoDestino) || (ordem == 2 && topoOrigem > topoDestino);
    }

    public void ordenar() {
        if (ordem == 1) {
            this.sort((a, b) -> a - b);
        } else if (ordem == 2) {
            this.sort((a, b) -> b - a);
        }
    }

    public boolean validaOrdenacao() {
        Pilha auxiliar = new Pilha(ordem);
        auxiliar.addAll(this);

        if (ordem == 1) {
            auxiliar.sort((a, b) -> a - b);
        } else if (ordem == 2) {
            auxiliar.sort((a, b) -> b - a);
        }

        return this.equals(auxiliar);
    }
}

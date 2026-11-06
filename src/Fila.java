import java.util.ArrayList;
import java.util.Collections; //arruma as variaveis para que TODAS fiquem em ordem
import java.util.PriorityQueue; //coloca em prioridade, no caso a maior idade

import entities.Pessoa;

public class Fila {
    PriorityQueue<Pessoa> fila = new PriorityQueue<>();

    public Fila(){
        fila = new PriorityQueue<>();
    }

    public void adicionar(Pessoa pessoa){
        fila.add(pessoa);
    }

    public Pessoa chamarProximo(){
        return fila.poll();
    }

    public int tamanho(){
        return fila.size();
    }

    public boolean estaVazia(){
        return fila.isEmpty();
    }

    public ArrayList<Pessoa> listar(){
        ArrayList<Pessoa> copia = new ArrayList<>(fila);
        Collections.sort(copia); //arruma a ordem de todas
        return copia;
    }

}

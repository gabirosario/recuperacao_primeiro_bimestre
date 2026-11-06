import java.time.LocalDate;
import java.util.Set; //se tentar adcionar um cpf existente ele guarda só um
import java.util.HashSet; //verifica se um elemento ja existe

import entities.Pessoa;

public class Gerenciador {
    private Fila fila;
    private Set<String> cpfs; 
    private int contadorSenha;

    public Gerenciador(){
        fila = new Fila();
        cpfs = new HashSet<>(); //são os cpfs da lista
        contadorSenha = 0; 
    }

    private String gerarSenha(){
        contadorSenha++;
        return String.format("%03d", contadorSenha);
    }

    public String cadastrarPessoa(String nome, String cpf, String telefone, LocalDate dataNascimento){
        if (cpfs.contains(cpf)){ //verifica se alguem da lista tem o cpf duplicado
            return "Cpf já cadastrado!";
        }
        
        if(dataNascimento.isAfter(LocalDate.now())){
            return "Data de nascimento inválida!";
        }

        String senha = gerarSenha();
        Pessoa pessoa = new Pessoa(nome.trim(), cpf, telefone.trim(), dataNascimento, senha);

        cpfs.add(cpf); //adiciona cpf na lista 
        fila.adicionar(pessoa);

        return "Cadastro realizado! Sua senha é: " + senha;
    }

    public Pessoa chamarProximo(){
        Pessoa pessoa = fila.chamarProximo();
        if(pessoa != null){
            cpfs.remove(pessoa.getCpf());
        }
        return pessoa;
    }

    public String listarFila(){
        if (fila.estaVazia()){
            return "Fila vazia";
        }
        String texto = "Fila: \n";
        int posicao = 1;
        for(Pessoa p : fila.listar()){
            texto +=posicao + "° - " + p + "\n";
            posicao++;
        }
        return texto;
    }

    public int tamanhoFila(){
        return fila.tamanho();
    }

}

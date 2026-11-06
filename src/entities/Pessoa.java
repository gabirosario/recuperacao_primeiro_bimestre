package entities;

import java.time.LocalDate;
import java.time.Period;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate dataNascimento;
    private String senha;


    public Pessoa(String nome, String cpf, String telefone, LocalDate dataNascimento, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
    return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade(){
        return Period.between(dataNascimento, LocalDate.now()).getYears(); //faz a conta entre a data nasc e hoje em dia.
    }

    @Override
    public int compareTo(Pessoa outra) {
        int resultado = this.dataNascimento.compareTo(outra.dataNascimento); //compara as idades 
        return resultado;
    }

    @Override
    public String toString() {
        return "Nome:" + nome + "\n- Senha: " + senha +"\n- Idade: " + getIdade();
    } 
}    
    


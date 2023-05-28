package catolica.negreira.santiago;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    private final int tamanho;
    private final List<LinkedList<Funcionario>> tabela;

    public HashTable(int tamanho) {
        this.tamanho = tamanho;
        tabela = new ArrayList<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            tabela.add(new LinkedList<>());
        }
    }

    public int hashFunction(double salario) {
        return (int) (salario % tamanho);
    }

    public void cadastrarFuncionario(Funcionario funcionario) {
        int posicao = hashFunction(funcionario.getSalario());
        tabela.get(posicao).add(funcionario);
    }

    public void concederAumento(double percentual) {
        for (LinkedList<Funcionario> lista : tabela) {
            for (Funcionario funcionario : lista) {
                double novoSalario = funcionario.getSalario() + (funcionario.getSalario() * percentual / 100);
                funcionario.setSalario(novoSalario);
            }
        }
    }

    public double consultarSomaSalarial() {
        double soma = 0;
        for (LinkedList<Funcionario> lista : tabela) {
            for (Funcionario funcionario : lista) {
                if (funcionario.getSalario() > 500) {
                    soma += funcionario.getSalario();
                }
            }
        }
        return soma;
    }

    public List<Funcionario> consultarFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        for (LinkedList<Funcionario> lista : tabela) {
            funcionarios.addAll(lista);
        }
        return funcionarios;
    }

    public void excluirPorNome(String nome) {
        for (LinkedList<Funcionario> lista : tabela) {
            lista.removeIf(funcionario -> funcionario.getNome().equals(nome));
        }
    }
}

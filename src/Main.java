import entities.Carro;

import java.util.ArrayList;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int resp;
        ArrayList<Carro> listaCarros = new ArrayList<>();
        Carro carro = new Carro();

        do {
            System.out.println("=== SISTEMA DE ESTACIONAMENTO ===");
            System.out.println("1 - Adicionar carro");
            System.out.println("2 - Remover carro");
            System.out.println("3 - Listar carro");
            System.out.println("0 - Sair");

            System.out.println("ESCOLHA UMA OPÇÃO");
            resp = input.nextInt();
            input.nextLine();

            switch (resp){
                case 1: listaCarros.add(carro.adicionarCarro(listaCarros));
                    break;
                case 2: carro.removerCarro(listaCarros);
                    break;
                case 3: carro.listarCarro(listaCarros);
                    break;
                case 0:
                    System.out.println("Finalizando...");
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }

        }while (resp != 0);
    }
}
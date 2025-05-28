package entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Carro {
    private String modelo;
    private String placa;
    private String cor;
    private LocalDateTime horaEntrada;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm");
    Scanner input = new Scanner(System.in);

    public Carro() {
    }
    public Carro(String modelo, String placa, String cor, LocalDateTime horaEntrada) {
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
        this.horaEntrada = horaEntrada;
    }

    public String getModelo() {
        return modelo;
    }
    public String getPlaca() {
        return placa;
    }
    public String getCor() {
        return cor;
    }
    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public Carro adicionarCarro(ArrayList<Carro> list){

        System.out.println("==ADICIONAR CARRO== \n");
        System.out.println("Digite o modelo do carro");
        String modelo = input.nextLine();

        System.out.println("Digite a placa do carro");
        String placa = input.nextLine();

        System.out.println("Digite a cor do carro");
        String cor = input.nextLine();

        LocalDateTime horaEntrada = LocalDateTime.now();

        for (Carro carro : list) {
            if(placa.equals(carro.placa)){
                System.out.println("ERRO");
                System.out.println("PLACAS IGUAIS FINALIZANDO A OPERAÇÃO");
                return null;
            }
        }

        return new Carro(modelo, placa, cor, horaEntrada);
    }
    public void listarCarro(ArrayList<Carro> list){
        System.out.println("==LISTA DE CARROS==");
        list.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "Placa: " +getPlaca()+" | Modelo: "+getModelo()+" | Cor: "+getCor()+" | Entrada: "+ formatter.format(getHoraEntrada());
    }
    public void removerCarro(ArrayList<Carro> list){
        System.out.println("==REMOVER CARRO==");
        System.out.println("Informe a placa");
        String placa = input.nextLine();

        list.removeIf(carro -> {

            if (placa.equals(carro.placa)){
                Duration tempo = Duration.between(carro.getHoraEntrada(), LocalDateTime.now());
                long minutosTotais = tempo.toMinutes();

                long horasSaida = minutosTotais / 60;
                long minSaida = minutosTotais % 60;

                System.out.println("CARRO REMOVIDO");
                System.out.println("Tempo " + horasSaida+"h : " + minSaida+"min");
                return true;
            }
            return false;
        });

    }
}

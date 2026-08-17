package main;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       SISTEMA DE REPARTOS SPEEDFAST");
        System.out.println("========================================");
        System.out.println();

        // Creación de pedidos
        Pedido pedidoComida = new PedidoComida(
                1,
                "Av. Providencia 1234"
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Las Condes 2456"
        );

        Pedido pedidoExpress = new PedidoExpress(
                3,
                "Av. Vicuña Mackenna 789"
        );

        // Sobreescritura: Java ejecuta el método correspondiente
        // al tipo real de cada objeto.
        System.out.println("--- ASIGNACIÓN AUTOMÁTICA ---");
        System.out.println();

        pedidoComida.asignarRepartidor();
        System.out.println();

        pedidoEncomienda.asignarRepartidor();
        System.out.println();

        pedidoExpress.asignarRepartidor();
        System.out.println();

        // Sobrecarga: se utiliza la versión que recibe
        // el nombre del repartidor.
        System.out.println("--- ASIGNACIÓN CON REPARTIDOR ---");
        System.out.println();

        pedidoComida.asignarRepartidor("Juan Pérez");
        System.out.println();

        pedidoEncomienda.asignarRepartidor("Camila Soto");
        System.out.println();

        pedidoExpress.asignarRepartidor("Luis Díaz");
        System.out.println();

        System.out.println("========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("========================================");
    }
}
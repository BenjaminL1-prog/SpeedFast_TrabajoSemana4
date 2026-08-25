
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
                "Av. Providencia 1234",
                4.0
        );

        Pedido pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Las Condes 2456",
                6.0
        );

        Pedido pedidoExpress = new PedidoExpress(
                3,
                "Av. Vicuña Mackenna 789",
                7.0
        );

        // Pedido de comida
        System.out.println("--- PEDIDO COMIDA ---");
        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        System.out.println();

        // Pedido de encomienda
        System.out.println("--- PEDIDO ENCOMIENDA ---");
        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        System.out.println();

        // Pedido express
        System.out.println("--- PEDIDO EXPRESS ---");
        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
        System.out.println();

        // Comparación de tiempos
        System.out.println("========================================");
        System.out.println("       COMPARACIÓN DE TIEMPOS");
        System.out.println("========================================");
        System.out.println("Comida:       "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        System.out.println("Encomienda:   "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        System.out.println("Express:      "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
        System.out.println("========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("========================================");
    }
}


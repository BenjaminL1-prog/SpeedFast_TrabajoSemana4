package main;

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
        PedidoComida pedidoComida = new PedidoComida(
                1,
                "Av. Providencia 1234",
                4.0
        );

        PedidoEncomienda pedidoEncomienda = new PedidoEncomienda(
                2,
                "Av. Las Condes 2456",
                6.0
        );

        PedidoExpress pedidoExpress = new PedidoExpress(
                3,
                "Av. Vicuña Mackenna 789",
                7.0
        );

        // Pedido de comida
        System.out.println("--- PEDIDO COMIDA ---");
        pedidoComida.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoComida.calcularTiempoEntrega() + " minutos");
        pedidoComida.asignarRepartidor();
        System.out.println();

        // Pedido de encomienda
        System.out.println("--- PEDIDO ENCOMIENDA ---");
        pedidoEncomienda.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoEncomienda.calcularTiempoEntrega() + " minutos");
        pedidoEncomienda.asignarRepartidor();
        System.out.println();

        // Pedido express
        System.out.println("--- PEDIDO EXPRESS ---");
        pedidoExpress.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoExpress.calcularTiempoEntrega() + " minutos");
        pedidoExpress.asignarRepartidor("Pedro González");
        System.out.println();

        // Reserva de pedidos
        System.out.println("========================================");
        System.out.println("          RESERVA DE PEDIDOS");
        System.out.println("========================================");
        pedidoComida.reservarPedido();
        pedidoEncomienda.reservarPedido();
        pedidoExpress.reservarPedido();
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
        System.out.println();

        // Despacho de pedidos
        System.out.println("========================================");
        System.out.println("          DESPACHO DE PEDIDOS");
        System.out.println("========================================");
        pedidoComida.despachar();
        pedidoEncomienda.despachar();
        System.out.println();

        // Cancelación de pedido
        System.out.println("========================================");
        System.out.println("        CANCELACIÓN DE PEDIDO");
        System.out.println("========================================");
        System.out.println("Cancelando Pedido Express #003...");
        pedidoExpress.cancelar();
        System.out.println();

        // Historial
        System.out.println("========================================");
        System.out.println("       HISTORIAL DE ENTREGAS");
        System.out.println("========================================");
        pedidoComida.verHistorial();
        pedidoEncomienda.verHistorial();
        pedidoExpress.verHistorial();
        System.out.println();

        System.out.println("========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("========================================");
    }
}
package main;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       SISTEMA DE REPARTOS SPEEDFAST");
        System.out.println("========================================");
        System.out.println();

        // Creación de pedidos
        PedidoComida pedidoComida1 = new PedidoComida(
                1,
                "Av. Providencia 1234",
                4.0
        );

        PedidoComida pedidoComida2 = new PedidoComida(
                2,
                "Av. Apoquindo 456",
                3.0
        );

        PedidoEncomienda pedidoEncomienda1 = new PedidoEncomienda(
                3,
                "Av. Las Condes 2456",
                6.0
        );

        PedidoEncomienda pedidoEncomienda2 = new PedidoEncomienda(
                4,
                "Av. Kennedy 1234",
                5.0
        );

        PedidoExpress pedidoExpress1 = new PedidoExpress(
                5,
                "Av. Vicuña Mackenna 789",
                7.0
        );

        PedidoExpress pedidoExpress2 = new PedidoExpress(
                6,
                "Av. Grecia 321",
                4.0
        );

        // Pedido de comida
        System.out.println("--- PEDIDO COMIDA ---");
        pedidoComida1.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoComida1.calcularTiempoEntrega() + " minutos");
        pedidoComida1.asignarRepartidor();
        System.out.println();

        // Pedido de encomienda
        System.out.println("--- PEDIDO ENCOMIENDA ---");
        pedidoEncomienda1.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoEncomienda1.calcularTiempoEntrega() + " minutos");
        pedidoEncomienda1.asignarRepartidor();
        System.out.println();

        // Pedido express
        System.out.println("--- PEDIDO EXPRESS ---");
        pedidoExpress1.mostrarResumen();
        System.out.println("Tiempo estimado: "
                + pedidoExpress1.calcularTiempoEntrega() + " minutos");
        pedidoExpress1.asignarRepartidor("Pedro González");
        System.out.println();

        // Reserva de pedidos
        System.out.println("========================================");
        System.out.println("          RESERVA DE PEDIDOS");
        System.out.println("========================================");
        pedidoComida1.reservarPedido();
        pedidoEncomienda1.reservarPedido();
        pedidoExpress1.reservarPedido();
        System.out.println();

        // Comparación de tiempos
        System.out.println("========================================");
        System.out.println("       COMPARACIÓN DE TIEMPOS");
        System.out.println("========================================");
        System.out.println("Comida:       "
                + pedidoComida1.calcularTiempoEntrega() + " minutos");
        System.out.println("Encomienda:   "
                + pedidoEncomienda1.calcularTiempoEntrega() + " minutos");
        System.out.println("Express:      "
                + pedidoExpress1.calcularTiempoEntrega() + " minutos");
        System.out.println("========================================");
        System.out.println();

        // Despacho de pedidos
        System.out.println("========================================");
        System.out.println("          DESPACHO DE PEDIDOS");
        System.out.println("========================================");
        pedidoComida1.despachar();
        pedidoEncomienda1.despachar();
        System.out.println();

        // Cancelación de pedido
        System.out.println("========================================");
        System.out.println("        CANCELACIÓN DE PEDIDO");
        System.out.println("========================================");
        System.out.println("Cancelando Pedido Express #005...");
        pedidoExpress1.cancelar();
        System.out.println();

        // Historial
        System.out.println("========================================");
        System.out.println("       HISTORIAL DE ENTREGAS");
        System.out.println("========================================");
        pedidoComida1.verHistorial();
        pedidoEncomienda1.verHistorial();
        pedidoExpress1.verHistorial();
        System.out.println();

        // Creación de repartidores
        Repartidor camila = new Repartidor("Camila");
        Repartidor luis = new Repartidor("Luis");
        Repartidor pedro = new Repartidor("Pedro");

        // Asignación de pedidos
        camila.agregarPedido(pedidoComida1);
        camila.agregarPedido(pedidoComida2);

        luis.agregarPedido(pedidoEncomienda1);
        luis.agregarPedido(pedidoEncomienda2);

        pedro.agregarPedido(pedidoExpress1);
        pedro.agregarPedido(pedidoExpress2);

        // Ejecución concurrente
        System.out.println("========================================");
        System.out.println("       INICIO DE ENTREGAS CONCURRENTES");
        System.out.println("========================================");

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(camila);
        executor.submit(luis);
        executor.submit(pedro);

        executor.shutdown();

        try {
            while (!executor.isTerminated()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("El proceso de entregas fue interrumpido.");
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }

        System.out.println();
        System.out.println("========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("========================================");
    }
}

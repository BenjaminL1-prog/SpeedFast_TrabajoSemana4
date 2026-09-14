package main;

import model.Pedido;
import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;
import model.ZonaDeCarga;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

        // Lista para controlar los pedidos creados
        ArrayList<Pedido> pedidos = new ArrayList<>();

        pedidos.add(pedidoComida1);
        pedidos.add(pedidoComida2);
        pedidos.add(pedidoEncomienda1);
        pedidos.add(pedidoEncomienda2);
        pedidos.add(pedidoExpress1);
        pedidos.add(pedidoExpress2);

        // Creación de la zona de carga compartida
        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        System.out.println("========================================");
        System.out.println("       CARGA DE PEDIDOS");
        System.out.println("========================================");

        for (Pedido pedido : pedidos) {
            zonaDeCarga.agregarPedido(pedido);
        }

        System.out.println();

        // Creación de repartidores
        Repartidor camila = new Repartidor("Camila", zonaDeCarga);
        Repartidor luis = new Repartidor("Luis", zonaDeCarga);
        Repartidor pedro = new Repartidor("Pedro", zonaDeCarga);

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

            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                System.out.println("El proceso de entregas tardó demasiado.");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            System.out.println("El proceso de entregas fue interrumpido.");

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        // Verificación final
        System.out.println();
        System.out.println("========================================");
        System.out.println("       ESTADO FINAL DE LOS PEDIDOS");
        System.out.println("========================================");

        boolean todosEntregados = true;

        for (Pedido pedido : pedidos) {

            System.out.println("Pedido #"
                    + String.format("%03d", pedido.getIdPedido())
                    + " - Estado: "
                    + pedido.getEstado());

            if (pedido.getEstado() != model.EstadoPedido.ENTREGADO) {
                todosEntregados = false;
            }
        }

        System.out.println();

        if (todosEntregados) {
            System.out.println("Todos los pedidos han sido entregados correctamente");
        } else {
            System.out.println("Algunos pedidos no fueron entregados correctamente.");
        }

        System.out.println("========================================");
        System.out.println("       PROCESO FINALIZADO");
        System.out.println("========================================");
    }
}
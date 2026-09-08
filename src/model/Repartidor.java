package model;

import java.util.ArrayList;
import java.util.Random;

public class Repartidor implements Runnable {

    private String nombre;
    private ArrayList<Pedido> pedidos;
    private Random random;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<>();
        this.random = new Random();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void run() {

        for (Pedido pedido : pedidos) {

            System.out.println("[Repartidor: " + nombre + "] "
                    + "Entregando Pedido #"
                    + String.format("%03d", pedido.getIdPedido()) + "...");

            try {
                int tiempoEspera = 1000 + random.nextInt(3000);
                Thread.sleep(tiempoEspera);

                System.out.println("[Repartidor: " + nombre + "] "
                        + "Pedido #"
                        + String.format("%03d", pedido.getIdPedido())
                        + " entregado.");

            } catch (InterruptedException e) {

                System.out.println("[Repartidor: " + nombre + "] "
                        + "Entrega interrumpida.");

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[Repartidor: " + nombre
                + "] Finalizó sus entregas.");
    }
}


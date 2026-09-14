package model;

public class Repartidor implements Runnable {

    private String nombre;
    private ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ZonaDeCarga getZonaDeCarga() {
        return zonaDeCarga;
    }

    public void setZonaDeCarga(ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (true) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            System.out.println("[Repartidor: " + nombre + "] "
                    + "retiró Pedido #"
                    + String.format("%03d", pedido.getIdPedido())
                    + " - Estado: " + pedido.getEstado());

            try {
                int tiempoEntrega = 2000;

                System.out.println("[Repartidor: " + nombre + "] "
                        + "Entregando Pedido #"
                        + String.format("%03d", pedido.getIdPedido())
                        + "...");

                Thread.sleep(tiempoEntrega);

                pedido.setEstado(EstadoPedido.ENTREGADO);

                System.out.println("[Repartidor: " + nombre + "] "
                        + "Pedido #"
                        + String.format("%03d", pedido.getIdPedido())
                        + " entregado. Estado: "
                        + pedido.getEstado());

            } catch (InterruptedException e) {

                System.out.println("[Repartidor: " + nombre + "] "
                        + "Entrega interrumpida.");

                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("[Repartidor: " + nombre
                + "] No quedan pedidos disponibles. Finalizó su jornada.");
    }
}
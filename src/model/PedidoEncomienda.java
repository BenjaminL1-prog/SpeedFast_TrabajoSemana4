package model;

public class PedidoEncomienda extends Pedido {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * getDistanciaKm()));
    }

    public void asignarRepartidor() {
        System.out.println("Repartidor asignado automáticamente: Daniela Tapia");
    }

    public void asignarRepartidor(String nombre) {
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }
}
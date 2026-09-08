package model;

public class PedidoComida extends Pedido {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }

    public void asignarRepartidor() {
        System.out.println("Repartidor asignado automáticamente: Luis Díaz");
    }

    public void asignarRepartidor(String nombre) {
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }
}

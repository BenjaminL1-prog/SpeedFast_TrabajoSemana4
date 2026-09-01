package model;

public class PedidoExpress extends Pedido {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        if (getDistanciaKm() > 5) {
            return 15;
        }

        return 10;
    }

    public void asignarRepartidor() {
        System.out.println("Repartidor asignado automáticamente: Carlos Soto");
    }

    public void asignarRepartidor(String nombre) {
        System.out.println("Repartidor asignado manualmente: " + nombre);
    }
}
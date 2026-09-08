package model;

import interfaces.Despachable;
import interfaces.Cancelable;
import interfaces.Rastreable;

import java.util.ArrayList;

public abstract class Pedido implements Despachable, Cancelable, Rastreable {

    private int idPedido;
    private String direccionEntrega;
    private double distanciaKm;

    private ArrayList<String> historial = new ArrayList<>();

    public Pedido(int idPedido, String direccionEntrega, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccionEntrega = direccionEntrega;
        this.distanciaKm = distanciaKm;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void mostrarResumen() {
        System.out.println("Pedido #" + String.format("%03d", idPedido));
        System.out.println("Dirección: " + direccionEntrega);
        System.out.println("Distancia: " + distanciaKm + " km");
    }

    public abstract int calcularTiempoEntrega();

    public void reservarPedido() {
        System.out.println("Pedido reservado correctamente.");
        historial.add("Pedido #" + String.format("%03d", idPedido) + " - reservado");
    }

    @Override
    public void despachar() {
        System.out.println("Pedido despachado correctamente.");
        historial.add("Pedido #" + String.format("%03d", idPedido) + " - despachado");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido cancelado exitosamente.");
        historial.add("Pedido #" + String.format("%03d", idPedido) + " - cancelado");
    }

    @Override
    public void verHistorial() {
        System.out.println("Historial de entregas:");

        if (historial.isEmpty()) {
            System.out.println("- No hay movimientos registrados.");
        } else {
            for (String registro : historial) {
                System.out.println("- " + registro);
            }
        }
    }
}

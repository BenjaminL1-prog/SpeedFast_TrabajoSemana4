# SpeedFast

Sistema de gestión de pedidos desarrollado en Java para la empresa de reparto **SpeedFast**.

El proyecto representa distintos tipos de servicios de entrega y utiliza conceptos fundamentales de **Programación Orientada a Objetos**, especialmente herencia, polimorfismo, sobrecarga y sobreescritura de métodos.

## Descripción

SpeedFast ofrece tres tipos de servicio:

* **Pedido de Comida:** requiere un repartidor que disponga de mochila térmica.
* **Pedido de Encomienda:** requiere validación del peso y embalaje.
* **Pedido Express:** requiere encontrar un repartidor cercano con disponibilidad inmediata.

El sistema utiliza una jerarquía de clases para representar estos distintos tipos de pedidos y permite asignar repartidores mediante métodos polimórficos.

## Estructura del proyecto

```text
src
├── main
│   └── Main.java
│
└── model
    ├── Pedido.java
    ├── PedidoComida.java
    ├── PedidoEncomienda.java
    └── PedidoExpress.java
```

### Clases principales

**Pedido**

Clase base que contiene los atributos generales de un pedido:

* `idPedido`
* `direccionEntrega`
* `tipoPedido`

También define los métodos `asignarRepartidor()` y su versión sobrecargada.

**PedidoComida**

Extiende `Pedido` y sobrescribe la lógica de asignación considerando la disponibilidad de una mochila térmica.

**PedidoEncomienda**

Extiende `Pedido` y sobrescribe la lógica de asignación considerando la validación del peso y embalaje.

**PedidoExpress**

Extiende `Pedido` y sobrescribe la lógica de asignación considerando la cercanía y disponibilidad inmediata del repartidor.

**Main**

Contiene la ejecución del sistema y demuestra el uso de las distintas implementaciones mediante polimorfismo y sobrecarga.

## Conceptos de POO aplicados

* **Herencia:** las clases específicas heredan de `Pedido`.
* **Sobreescritura:** cada subclase implementa su propia versión de `asignarRepartidor()`.
* **Sobrecarga:** se utiliza una segunda versión de `asignarRepartidor()` que recibe el nombre del repartidor.
* **Polimorfismo:** objetos de las clases derivadas son manejados mediante referencias de tipo `Pedido`.

## Tecnologías

* Java
* IntelliJ IDEA
* Git
* GitHub

## Ejecución

El programa se ejecuta desde la clase:

```text
Main.java
```

La ejecución muestra en consola la asignación de repartidores para los tres tipos de pedido.

## Autor

Proyecto académico desarrollado para la asignatura **Desarrollo Orientado a Objetos II**.

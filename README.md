# SpeedFast

Sistema de gestión de pedidos desarrollado en Java para la empresa de reparto **SpeedFast**.

El proyecto representa distintos tipos de pedidos y utiliza conceptos fundamentales de **Programación Orientada a Objetos**, especialmente clases abstractas, herencia, polimorfismo y sobreescritura de métodos.

## Descripción

SpeedFast gestiona tres tipos de pedidos:

* **Pedido de Comida:** calcula su tiempo de entrega considerando una base de 15 minutos más 2 minutos por cada kilómetro.
* **Pedido de Encomienda:** calcula su tiempo de entrega considerando una base de 20 minutos más 1,5 minutos por cada kilómetro.
* **Pedido Express:** tiene un tiempo base de 10 minutos y agrega 5 minutos adicionales cuando la distancia supera los 5 km.

El sistema utiliza una jerarquía de clases basada en una clase abstracta `Pedido`, permitiendo reutilizar atributos y métodos comunes y definir un cálculo de tiempo específico para cada tipo de pedido.

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

Clase abstracta que contiene los atributos generales de un pedido:

* `idPedido`
* `direccionEntrega`
* `distanciaKm`

También implementa el método `mostrarResumen()` y declara el método abstracto `calcularTiempoEntrega()`.

**PedidoComida**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando la fórmula de 15 minutos base más 2 minutos por cada kilómetro.

**PedidoEncomienda**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando la fórmula de 20 minutos base más 1,5 minutos por cada kilómetro, ajustando el resultado a un número entero.

**PedidoExpress**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando un tiempo base de 10 minutos y agregando 5 minutos cuando la distancia supera los 5 km.

**Main**

Contiene la ejecución del sistema y demuestra el uso de las distintas implementaciones mediante polimorfismo, mostrando el resumen y el tiempo estimado de cada pedido.

## Conceptos de POO aplicados

* **Clase abstracta:** `Pedido` define la estructura y comportamiento común de los pedidos.
* **Herencia:** las clases específicas heredan de `Pedido`.
* **Sobreescritura:** cada subclase implementa su propia versión de `calcularTiempoEntrega()`.
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

La ejecución muestra en consola el resumen de los tres tipos de pedido y sus respectivos tiempos estimados de entrega.

## Autor

Proyecto académico desarrollado para la asignatura **Desarrollo Orientado a Objetos II**, Benjamín Lizama.


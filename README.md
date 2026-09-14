# SpeedFast

Sistema de gestión de pedidos desarrollado en Java para la empresa de reparto **SpeedFast**.

El proyecto representa distintos tipos de pedidos y utiliza conceptos fundamentales de **Programación Orientada a Objetos**, especialmente clases abstractas, herencia, polimorfismo, sobrecarga, sobreescritura e interfaces.

En esta semana se incorpora el uso de **programación multihilo**, permitiendo ejecutar las entregas de distintos repartidores de manera concurrente mediante `Runnable`, `Thread.sleep()` y `ExecutorService`.

## Descripción

SpeedFast gestiona tres tipos de pedidos:

* **Pedido de Comida:** calcula su tiempo de entrega considerando una base de 15 minutos más 2 minutos por cada kilómetro.
* **Pedido de Encomienda:** calcula su tiempo de entrega considerando una base de 20 minutos más 1,5 minutos por cada kilómetro.
* **Pedido Express:** tiene un tiempo base de 10 minutos y agrega 5 minutos adicionales cuando la distancia supera los 5 km.

El sistema utiliza una jerarquía de clases basada en una clase abstracta `Pedido`, permitiendo reutilizar atributos y métodos comunes y definir un cálculo de tiempo específico para cada tipo de pedido.

Además, se incorporan interfaces para separar responsabilidades relacionadas con el despacho, la cancelación y el seguimiento de los pedidos.

En esta versión se incorpora la clase `Repartidor`, que implementa `Runnable` y permite simular las entregas de varios repartidores de manera concurrente. Cada repartidor procesa sus pedidos de forma secuencial y utiliza `Thread.sleep()` para simular el tiempo de entrega.

## Estructura del proyecto

```text
src
├── main
│   └── Main.java
│
├── model
│   ├── Pedido.java
│   ├── PedidoComida.java
│   ├── PedidoEncomienda.java
│   ├── PedidoExpress.java
│   └── Repartidor.java
│
└── interfaces
    ├── Despachable.java
    ├── Cancelable.java
    └── Rastreable.java
```

### Clases principales

**Pedido**

Clase abstracta que contiene los atributos generales de un pedido:

* `idPedido`
* `direccionEntrega`
* `distanciaKm`

También implementa el método `mostrarResumen()` y declara el método abstracto `calcularTiempoEntrega()`.

Además, implementa las interfaces `Despachable`, `Cancelable` y `Rastreable`, incorporando las funcionalidades de despacho, cancelación y visualización del historial de operaciones.

**PedidoComida**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando la fórmula de 15 minutos base más 2 minutos por cada kilómetro.

También permite asignar un repartidor de forma automática o manual mediante el método sobrecargado `asignarRepartidor()`.

**PedidoEncomienda**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando la fórmula de 20 minutos base más 1,5 minutos por cada kilómetro, ajustando el resultado a un número entero.

También permite asignar un repartidor de forma automática o manual.

**PedidoExpress**

Extiende `Pedido` y sobrescribe `calcularTiempoEntrega()` utilizando un tiempo base de 10 minutos y agregando 5 minutos cuando la distancia supera los 5 km.

También permite asignar un repartidor de forma automática o manual.

**Repartidor**

Representa a un repartidor encargado de realizar una lista de pedidos.

Contiene:

* `nombre`
* Lista de pedidos asignados

Implementa la interfaz `Runnable`, permitiendo que cada repartidor sea ejecutado como una tarea independiente.

El método `run()` procesa los pedidos asignados de forma secuencial y utiliza `Thread.sleep()` con tiempos aleatorios para simular el proceso de entrega.

Durante la ejecución se muestra en consola el progreso de cada entrega y la finalización de las tareas del repartidor.

**Main**

Contiene la ejecución del sistema y demuestra el uso de las distintas clases mediante polimorfismo.

La simulación incluye la creación de pedidos, asignación de repartidores, cálculo del tiempo estimado, reserva, despacho, cancelación y visualización del historial de operaciones.

También crea tres repartidores, asignando dos pedidos a cada uno, y utiliza `ExecutorService` para ejecutar sus tareas de manera concurrente.

### Interfaces

**Despachable**

Define el método `despachar()`, encargado de representar el despacho de un pedido.

**Cancelable**

Define el método `cancelar()`, encargado de representar la cancelación de un pedido.

**Rastreable**

Define el método `verHistorial()`, encargado de mostrar el historial de operaciones realizadas sobre los pedidos.

## Conceptos de POO y programación multihilo aplicados

* **Clase abstracta:** `Pedido` define la estructura y comportamiento común de los pedidos.
* **Herencia:** las clases específicas heredan de `Pedido`.
* **Sobreescritura:** cada subclase implementa su propia versión de `calcularTiempoEntrega()`.
* **Sobrecarga:** `asignarRepartidor()` permite asignar un repartidor automáticamente o recibir un nombre mediante un parámetro.
* **Polimorfismo:** las clases derivadas utilizan y especializan los comportamientos definidos en `Pedido`.
* **Interfaces:** `Despachable`, `Cancelable` y `Rastreable` separan responsabilidades funcionales del sistema.
* **Encapsulamiento:** los atributos de `Pedido` son privados y se accede a ellos mediante métodos `get` y `set`.
* **Runnable:** `Repartidor` implementa `Runnable` para representar una tarea que puede ejecutarse de forma concurrente.
* **Thread.sleep():** se utiliza para simular el tiempo que demora cada entrega.
* **ExecutorService:** administra la ejecución concurrente de los repartidores mediante un grupo de hilos.
* **Programación concurrente:** los distintos repartidores pueden realizar sus entregas simultáneamente.

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

La ejecución muestra en consola el resumen de los tres tipos de pedido, sus respectivos tiempos estimados, la asignación de repartidores, la reserva, el despacho, la cancelación y el historial de operaciones.

Finalmente, se simulan las entregas de tres repartidores de manera concurrente, mostrando en consola el progreso de cada pedido hasta completar todas las entregas.

## Autor

Proyecto académico desarrollado para la asignatura **Desarrollo Orientado a Objetos II**, Benjamín Lizama.

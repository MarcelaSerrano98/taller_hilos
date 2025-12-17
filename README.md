
# 🏃‍♂️ Taller: La Gran Carrera de Relevos Multihilo

Este proyecto es una simulación de una carrera de relevos olímpica desarrollada en **Java**, utilizando conceptos avanzados de concurrencia y programación multihilo.

El objetivo principal es demostrar la diferencia entre la **ejecución paralela** (entre equipos competidores) y la **ejecución secuencial sincronizada** (entre corredores del mismo equipo).

## 📋 Descripción del Proyecto

En esta competencia participan dos equipos (Equipo Rojo y Equipo Azul). Cada equipo tiene 3 corredores. Las reglas son estrictas:
1. **Paralelismo:** Ambos equipos corren al mismo tiempo.
2. **Sincronización:** Dentro de un equipo, el **Corredor 2** no puede comenzar hasta que el **Corredor 1** termine su tramo y entregue el testigo.

## ⚙️ Arquitectura y Tecnologías

El proyecto fue refactorizado para cumplir con los estándares modernos de Java (versión "Reto: Modernización a `ExecutorService`").

* **Lenguaje:** Java
* **Concurrencia:** `java.util.concurrent`
* **Patrón de Diseño:** Productor-Consumidor (simplificado mediante Executors).

### ¿Cómo funciona la sincronización?

En lugar de gestionar los hilos manualmente con `Thread` y `join()`, se implementó un **Pool de Hilos** inteligente:

1.  **Clase `Corredor` (Tarea):** Implementa la interfaz `Runnable`. Simula el esfuerzo físico mediante `Thread.sleep()` con tiempos aleatorios.
2.  **Clase `Equipo` (Orquestador):** Utiliza un `ExecutorService` configurado como `newSingleThreadExecutor`.
    * *¿Por qué SingleThread?* Al asignar un único hilo de ejecución por equipo, el `Executor` garantiza automáticamente que los corredores encolados se ejecuten en estricto orden de llegada (FIFO), respetando el relevo sin necesidad de bloqueos manuales.

## 📂 Estructura del Proyecto

```text
src/
└── com/
    └── relevos/
        ├── Main.java              // Punto de entrada. Inicia los equipos en paralelo.
        └── dominio/
            ├── Corredor.java      // Lógica de la tarea (Runnable).
            └── Equipo.java        // Administrador del ExecutorService.

```

## 🚀 Cómo Ejecutar

1. Clona el repositorio o descarga el código.
2. Compila el proyecto desde la terminal o tu IDE favorito.
3. Ejecuta la clase `Main`.

**Salida esperada en consola:**

Verás que los mensajes de los equipos Rojo y Azul se intercalan (paralelismo), pero los corredores 1, 2 y 3 de cada equipo siempre respetan su orden.

```text
El equipo Rojo está listo en la línea de salida.
El equipo Azul está listo en la línea de salida.
Rojo-1 recibe el testigo y comienza a correr 🏃
Azul-1 recibe el testigo y comienza a correr 🏃
...
Rojo-1 terminó su tramo...
Rojo-2 recibe el testigo...

```

## ✒️ Autor

**Laura Marcela Albarracín Serrano**


---


# Árbol AVL en Java 🌳

Este proyecto implementa un **Árbol AVL** en Java, con métodos de inserción, eliminación y búsqueda.

## 📌 Características
- Balanceo automático mediante rotaciones.
- Inserción y eliminación de elementos enteros.
- Impresión en consola del árbol en orden.

## 🚀 Cómo ejecutar el programa
1. Clonar el repositorio:
   ```sh
   git clone https://github.com/NataliaWilsonr/arbolesAVL.git

## 📖 Métodos principales del Árbol AVL

Aquí tienes una explicación detallada de los métodos más importantes:

### 🌱 Inserción de elementos

```java
public void insertar(T elemento);
```

- **Propósito:** Agrega un nuevo elemento al árbol AVL de forma ordenada.
- **Cómo funciona:**
    - Si el árbol está vacío, el elemento se convierte en la raíz.
    - Si el elemento es menor, se inserta en el subárbol izquierdo.
    - Si el elemento es mayor, se inserta en el subárbol derecho.
    - Después de cada inserción, se verifica el **balance** del árbol y se aplican **rotaciones** si es necesario.

📌 **Ejemplo de uso:**

```java
ArbolAVL<Integer> arbol = new ArbolAVL<>();
arbol.insertar(30);
arbol.insertar(20);
arbol.insertar(40);
```

---

### 🪓 Eliminación de elementos

```java
public void eliminar(T elemento);
```

- **Propósito:** Elimina un nodo del árbol y ajusta la estructura para mantener el balance.
- **Cómo funciona:**
    - Si el nodo no tiene hijos, se elimina directamente.
    - Si el nodo tiene un solo hijo, el hijo toma su lugar.
    - Si el nodo tiene dos hijos, se reemplaza con su **sucesor in-order**.
    - Después de la eliminación, se verifica el **balance** y se aplican **rotaciones** si es necesario.

📌 **Ejemplo de uso:**

```java
arbol.eliminar(30);
```

---

### 🔍 Búsqueda de elementos

```java
public boolean buscar(T elemento);
```

- **Propósito:** Busca un elemento en el árbol AVL.
- **Cómo funciona:**
    - Se recorre el árbol como en un ABB.
    - Si se encuentra el elemento, retorna `true`; de lo contrario, retorna `false`.

📌 **Ejemplo de uso:**

```java
boolean encontrado = arbol.buscar(20); // Devuelve true si 20 está en el árbol.

```

---

### 📏 Balanceo del árbol

```java
private NodoABB<T> balancear(NodoABB<T> nodo);
```

- **Propósito:** Verifica si un nodo está desbalanceado y aplica la rotación correspondiente.
- **Tipos de rotaciones usadas:**
    - **Rotación simple a la derecha** (Caso Izquierda-Izquierda).
    - **Rotación simple a la izquierda** (Caso Derecha-Derecha).
    - **Rotación doble izquierda-derecha** (Caso Izquierda-Derecha).
    - **Rotación doble derecha-izquierda** (Caso Derecha-Izquierda).

📌 **Ejemplo de uso (interno, no se llama directamente)**

Este método se ejecuta automáticamente después de `insertar` o `eliminar`.

---

### 📜 Impresión del árbol

```java
public void imprimirEnOrden();
```

- **Propósito:** Muestra los elementos en orden ascendente (de menor a mayor).
- **Ejemplo de salida en consola:**
    
    ```java
    Árbol en orden después de las operaciones:
    10 20 30 40 50
    
    ```
    

---

## 👨‍💻 Autor

- **[Nat Wilson R]**

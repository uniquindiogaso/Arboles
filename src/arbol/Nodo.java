package arbol;

public class Nodo<T> implements Comparable<T> {

    Nodo<T> izquierda;
    Nodo<T> derecha;
    private T valor;

    public Nodo() {
    }

    public Nodo(T valor) {
        this.valor = valor;

    }

    public Nodo(Nodo<T> izquierda, Nodo<T> derecha, T valor) {
        this.izquierda = izquierda;
        this.derecha = derecha;
        this.valor = valor;
    }

    public void insertar(Nodo<T> nodo) {
       
        int comparacion = nodo.compareTo(valor);
                       
        if (comparacion > 0) { //derecha

            if (derecha == null) {
                derecha = nodo;
            } else {
                derecha.insertar(nodo);
            }
        } 
        else if (comparacion < 0) { //izquierda
            if (izquierda == null) {
                izquierda = nodo;
            } else {
                izquierda.insertar(nodo);
            }
        }

    }
    

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.valueOf(getValor()); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(T objeto) {
        Comparable<T> datoActual = (Comparable<T>) this.valor;
        return datoActual.compareTo(objeto);
    }

}

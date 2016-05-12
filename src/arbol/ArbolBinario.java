package arbol;

/**
 *
 * @author Admin
 * @param <T>
 */
public class ArbolBinario<T> {

    private Nodo raiz;
    private int peso;
    private int hojas;

    public ArbolBinario() {
        peso = 0;
    }

    public ArbolBinario(Nodo raiz) {
        this.raiz = raiz;
        peso = 0;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(T dato) {
        if (estaVacio()) {
            raiz = new Nodo(dato);
            peso++;
        } else {
            raiz.insertar(new Nodo(dato));
        }

    }

    public int getPeso() {
        conteo(raiz);
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public ArbolBinario(int hojas) {
        this.hojas = hojas;
    }

    public void imprimirArbolBinario(Nodo raiz, int level) {
        if (raiz == null) {
            return;
        }
        imprimirArbolBinario(raiz.getDerecha(), level + 1);
        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t");
            }
            System.out.println("|-------" + raiz.getValor());
        } else {
            System.out.println(raiz.getValor());
        }
        imprimirArbolBinario(raiz.getIzquierda(), level + 1);
    }

    /**
     * (izquierdo, raíz, derecho).
     *
     * @param nodo
     */
    private void inOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        inOrden(nodo.getIzquierda());
        System.out.println("" + nodo.getValor());
        inOrden(nodo.getDerecha());
    }

    /**
     * (raíz, izquierdo, derecho)
     *
     * @param nodo
     */
    private void preOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        System.out.println("" + nodo.getValor());
        inOrden(nodo.getIzquierda());
        inOrden(nodo.getDerecha());
    }

    /**
     * (izquierdo, derecho, raíz).
     *
     * @param nodo
     */
    private void posOrden(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        posOrden(nodo.getIzquierda());
        posOrden(nodo.getDerecha());
        System.out.println("" + nodo.getValor());
    }

    /**
     * Contar elementos del Arbol
     *
     * @param nodo
     */
    private void conteo(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        if (nodo.getIzquierda() != null) {
            peso++;
            conteo(nodo.getIzquierda());
        }

        if (nodo.getDerecha() != null) {
            peso++;
            conteo(nodo.getDerecha());

        }
    }

    private void numHoja(Nodo nodo) {
        if (nodo == null) {
            hojas++;
            return;
        }
        if (nodo.getIzquierda() == null) {
            hojas++;
           
        }else{
             numHoja(nodo.getIzquierda());
        }

        if (nodo.getDerecha() == null) {
            hojas++;           
        }else{
            numHoja(nodo.getDerecha());
        }
    }

    public void inOrden() {
        inOrden(raiz);
    }

    public void preOrden() {
        preOrden(raiz);
    }

    public void posOrden() {
        posOrden(raiz);
    }

    /**
     * Recorrido Raiz , Izquierda , Derecha
     */
    public void preOrden(Nodo raiz, int nivel) {
        if (raiz == null) {
            return;
        } else {
            if (raiz.getIzquierda() != null) {
                preOrden(raiz.getIzquierda(), nivel + 1);
                System.out.println("" + raiz.getValor());
            }

            if (raiz.getDerecha() != null) {
                preOrden(raiz.getDerecha(), nivel + 1);
                System.out.println("" + raiz.getValor());
            }
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public int getHojas() {
        return hojas;
    }

    public void setHojas(int hojas) {
        this.hojas = hojas;
    }

    
}

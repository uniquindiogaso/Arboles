package arbol;

/**
 *
 * @author Admin
 * @param <T>
 */
public class ArbolBinario<T extends Comparable> {

    private Nodo raiz;
    private int peso;
    private int hojas;
    private int nodosInternos;
    private int sumatoria;

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
            return;
        }
        //Si Nodo no tiene hijos tanto en la izq como en la derecha aumente conteo
        if (nodo.getIzquierda() == null && nodo.getDerecha() == null) {
            hojas++;
        } else {
            numHoja(nodo.getIzquierda());
            numHoja(nodo.getDerecha());
        }
    }

    private void numNodosInternos(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        if (nodo.getDerecha() != null || nodo.getIzquierda() != null) {
            nodosInternos++;
            numNodosInternos(nodo.getDerecha());
            numNodosInternos(nodo.getIzquierda());
        }
    }

    public Double obtenerSumatoria() {
        Double res = 0.0;
        try {
            Number claseNumerica = (Number) raiz.getValor();

            res = sumatoria(raiz);
        } catch (ClassCastException e) {
            System.err.println("Solo se permiten sumatorias de elementos numericos");
        }

        return res;

    }

    private Double sumatoria(Nodo nodo) {
//        if (nodo == null) {
//            return;
//        }
//        sumatoria(nodo.getIzquierda());
//        sumatoria(nodo.getDerecha());
//        
//        if(nodo.getValor() instanceof Number){
//            sumatoria += ((Number) nodo.getValor()).intValue();
//        }else{
//            System.err.println("Solo se pueden sumar numeros");
//            return;
//        }       

        if (nodo == null) {
            return 0.0;
        }
        return (sumatoria(nodo.getIzquierda()) + sumatoria(nodo.getDerecha()) + ((Number) nodo.getValor()).doubleValue());

    }

    private boolean elementoExiste(Nodo<T> nodo, T elemento) {

        if (nodo != null) {
            if (elemento.compareTo(nodo.getValor()) == 0) {
                return true;
            } else {
                if (elemento.compareTo(nodo.getValor()) < 0) {
                    return elementoExiste(nodo.getIzquierda(), elemento);
                } else {
                    return elementoExiste(nodo.getDerecha(), elemento);
                }
            }
        }
        return false;
    }

    public void eliminar(T dato) {
        this.raiz = eliminar(dato, raiz);

    }

    private Nodo<T> eliminar(T dato, Nodo<T> nodo) {
        if (nodo == null) {
            return null;
        }
        if (nodo.getValor().compareTo(dato) == 0) {
            return unir(nodo.getIzquierda(), nodo.getDerecha());
        }
        if (dato.compareTo(nodo.getValor()) < 0) {
            nodo.setIzquierda(eliminar(dato, nodo.getIzquierda()));
        } else {
            nodo.setDerecha(eliminar(dato, nodo.getDerecha()));
        }
        return nodo;
    }

    private Nodo<T> unir(Nodo nodoIzquierdo, Nodo nodoDerecho) {
        if (nodoIzquierdo == null) {
            return nodoDerecho;
        }
        if (nodoDerecho == null) {
            return nodoIzquierdo;
        }
        Nodo<T> centro = unir(nodoIzquierdo.getDerecha(), nodoDerecho.getIzquierda());
        nodoIzquierdo.setDerecha(centro);
        nodoDerecho.setIzquierda(nodoIzquierdo);
        return nodoDerecho;
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
        numHoja(raiz);
        return hojas;
    }

    public int getNodosInternos() {
        numNodosInternos(raiz);
        return nodosInternos;
    }

    public int getSumatoria() {
        // sumatoria(raiz);
        return sumatoria;
    }

    public boolean existe(T elemento) {
        return elementoExiste(raiz, elemento);
    }

}

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

    private void sumatoria(Nodo nodo) {
        if (nodo == null) {
            return;
        }
        sumatoria(nodo.getIzquierda());
        sumatoria(nodo.getDerecha());
        
        if(nodo.getValor() instanceof Number){
            sumatoria += ((Number) nodo.getValor()).intValue();
        }else{
            System.err.println("Solo se pueden sumar numeros");
            return;
        }       
        
    }
    
    private boolean elementoExiste(Nodo nodo , T elemento){
        if (nodo == null){
            return false;
        }else{
            if (nodo.getValor() == elemento){
                return true;
            }else{
                return elementoExiste(nodo.getDerecha(),elemento);
            }
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
        numHoja(raiz);
        return hojas;
    }



    public int getNodosInternos() {
        numNodosInternos(raiz);
        return nodosInternos;
    }


    public int getSumatoria() {
        sumatoria(raiz);
        return sumatoria;
    }

    
    public boolean existe(T elemento){
        return elementoExiste(raiz, elemento);
    }
    
}

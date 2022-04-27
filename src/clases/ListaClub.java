package clases;

public class ListaClub {

    public class Nodo {
        private Socio socio;
        private Nodo siguiente;

        public Nodo (Socio socio) {
            this.socio = socio;
            this.siguiente = null;
        }

        public Socio getSocio() {
            return socio;
        }

        public void setSocio(Socio socio) {
            this.socio = socio;
        }

        public Nodo getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo siguiente) {
            this.siguiente = siguiente;
        }
    }


    private Nodo primero;

    private ListaClub () {
        this.primero = null;
    }

    public static ListaClub crearListaClub(){
        return new ListaClub();
    }

    public void agregarSocio(Socio socio) {
        if (this.primero == null){
            this.primero = new Nodo(socio);
            return;
        }
        Nodo aux = this.primero;
        while (aux.getSiguiente() != null) {
            aux = aux.getSiguiente();
        }
        aux.setSiguiente(new Nodo(socio));
    }

    public boolean estaVacio() {
        if (this.primero == null)
            return true;
        else return false;
    }

    public int cantidad() {
        Nodo aux = this.primero;
        int cantidad = 0;
        while (aux != null) {
            cantidad++;
            aux = aux.getSiguiente();
        }
        return cantidad;
    }

    public boolean esta(Socio socio){
        return esta(this.primero, socio);
    }

    private boolean esta(Nodo aux, Socio socio) {
        if (aux == null)
            return false;
        else if (aux.getSocio().equals(socio))
            return true;

        return esta(aux.getSiguiente(), socio);
    }

    public Socio ultimoSocio() {
        if (this.primero == null)
            return null;

        Nodo aux = this.primero;

        while (aux.getSiguiente() != null){
            aux = aux.getSiguiente();
        }
        return aux.getSocio();
    }

    public void mostrarClub() {
        Nodo aux = this.primero;
        System.out.println("El club está conformado por: ");
        System.out.print("{ ");
        while (aux != null) {
            System.out.print(aux.getSocio());
            if (aux.getSiguiente() != null)
                System.out.print(", ");
            aux = aux.getSiguiente();
        }
        System.out.println(" }");
    }
}

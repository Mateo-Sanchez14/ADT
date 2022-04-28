package club;

public class ListaClub {

    //<editor-fold defaultstate="collapsed" desc="Clase Nodo">
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
    //</editor-fold>

    //Variables de clase
    private Nodo primero;

    //<editor-fold defaultstate="collapsed" desc="Constructor">
    private ListaClub () {
        this.primero = null;
    }


    public static ListaClub crearListaClub(){
        return new ListaClub();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Main">
    public static void main(String[] args) {
        ListaClub listaClub = ListaClub.crearListaClub();

        listaClub.agregarSocio(new Socio(1));
        listaClub.agregarSocio(new Socio(2));
        listaClub.agregarSocio(new Socio(3));
        listaClub.agregarSocio(new Socio(4));
        listaClub.agregarSocio(new Socio(5));

        listaClub.mostrarClub();


        boolean estaSocio5 = listaClub.esta(new Socio(5));
        System.out.println("estaSocio5 = " + estaSocio5);
        boolean estaSocio10 = listaClub.esta(new Socio(10));
        System.out.println("estaSocio10 = " + estaSocio10);

        boolean esClubVacio = listaClub.estaVacio();
        System.out.println("esClubVacio = " + esClubVacio);

        Socio ultimoSocio = listaClub.ultimoSocio();
        System.out.println("ultimoSocio = " + ultimoSocio);

        System.out.println("Segundo Club");

        ListaClub listaClub2 = ListaClub.crearListaClub();
        listaClub2.agregarSocio(new Socio(3));
        listaClub2.agregarSocio(new Socio(4));
        listaClub2.agregarSocio(new Socio(5));

        listaClub2.mostrarClub();

        boolean esSocioComun5 = listaClub.esSocioComun(listaClub2,new Socio(5));
        System.out.println("esSocioComun5 = " + esSocioComun5);

        boolean esSocioComun4 = listaClub2.esSocioComun(listaClub,new Socio(4));
        System.out.println("esSocioComun4 = " + esSocioComun4);

        boolean esSocioComun2 = listaClub.esSocioComun(listaClub2,new Socio(2));
        System.out.println("esSocioComun2 = " + esSocioComun2);

        boolean esSocioComun1 = listaClub2.esSocioComun(listaClub,new Socio(1));
        System.out.println("esSocioComun1 = " + esSocioComun1);

        ListaClub nuevoClub = unirClubes(listaClub,listaClub2);

        System.out.println("El club unido es: ");
        if (nuevoClub != null)
            nuevoClub.mostrarClub();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Métodos de Usuario">
    public static ListaClub unirClubes(ListaClub club1, ListaClub club2) {
        ListaClub clubUnido = ListaClub.crearListaClub();
        Nodo aux1 = club1.primero;
        Nodo aux2 = club2.primero;
        clubUnido.primero = aux1;

        if (aux1 == null && aux2 == null)
            return null;


        if (aux1 == null) {
            clubUnido.primero = aux2;
            return clubUnido;
        }else if(aux2 == null){
            return clubUnido;
        }


        while (aux1.getSiguiente() != null)
            aux1 = aux1.getSiguiente();

        aux1.setSiguiente(aux2);

        return clubUnido;
    }
    // </editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos de Clase">
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
        return this.primero == null;
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

    public boolean esSocioComun(ListaClub otroClub, Socio socio) {
        Nodo aux1 = this.primero;
        Nodo aux2 = otroClub.primero;
        boolean estaEnUno = false;
        while (aux1 != null){
            if (aux1.getSocio().equals(socio)) {
                estaEnUno = true;
                break;
            }
            aux1 = aux1.getSiguiente();
        }
        if (!estaEnUno)
            return false;
        
        while (aux2 != null) {
            if (aux2.getSocio().equals(socio))
                return true;
            aux2 = aux2.getSiguiente();
        }
        return false;
    }
    //</editor-fold>

}

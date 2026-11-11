package arreglos.tienda.modelo;

public class AppStore {
    private static final int MAX = 4;
    private Juego juegos[];
    private int indice;

    public AppStore(){
        juegos = new Juego[MAX];
        indice = -1;
    }

    public Juego[] getJuegos() {
        return juegos;
    }
    /*
    No se utilizan pq se debería ingresar uno a uno los juegos
    public void setJuegos(Juego juegos[]) {
        this.juegos = juegos;
    }
    */

    public void inicializarDatos(){
        agregarJuego(new Juego("Fifa2026","Deportes",15,45,50));
        agregarJuego(new Juego("Fornite","Acción",20,60,20));

    }
    public boolean agregarJuego(Juego j){
        if(j != null && indice < MAX - 1){
            juegos[++indice] = j;
            return true;
        }
        return false;
    }
    public Juego buscarJuego(String nombre){
        if(nombre != null && !nombre.trim().isEmpty() ){
            for(int i = 0; i <= indice; i++){
                if (juegos[i].getNombre().equalsIgnoreCase(nombre)) {
                    return juegos[i];
                }
            }
            return null;
        }
        return null;

    }
    public boolean comprar(String nombre, int cantidad){
        if(nombre != null && !nombre.trim().isEmpty() && cantidad > 0){
            Juego j = buscarJuego(nombre);
            if(j != null){
                return j.comprar(cantidad);
            }
            return false;
        }
        return false;
    }

    public double vender(String nombre, int cantidad){
        //no se realiza la validación pq el buscar y el vender ya lo validan
        Juego j = buscarJuego(nombre);
        if(j != null){
            if(j.vender(cantidad)){
                return j.getPrecio() * cantidad;
            }
            return 0;
        }
        return 0;
    }

    public String masVendido(){
        String nombre = null;
        if(indice >= 0){
            int mayor = juegos[0].getLicenciasVendidas();
            nombre = juegos[0].getNombre();
            for(int i = 1; i <= indice; i++){
                if(juegos[i].getLicenciasVendidas() > mayor){
                    mayor = juegos[i].getLicenciasVendidas();
                    nombre = juegos[i].getNombre();
                }
            }
        }
        return nombre;

    }

}

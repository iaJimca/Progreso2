package arreglos.tienda.interfaz;

import arreglos.tienda.modelo.AppStore;
import arreglos.tienda.modelo.Juego;

import javax.swing.*;
import java.util.Scanner;

public class MainTienda {
    private static Scanner sc = new Scanner(System.in);
    private static AppStore as1 = new AppStore();

    static void main() {
        as1.inicializarDatos();
        int opc;
        int cantidad;
        do{
            menu();
            opc = Integer.parseInt(sc.nextLine());
            switch (opc){
                case 1:{
                    ingresarJuego();
                }break;
                case 2:{
                    mostrarJuegos();
                }break;
                case 3:{
                    buscarJuego();
                }break;
                case 4:{
                    comprarLicencias();
                }break;
                case 5:{
                    venderLicencias();
                }break;
                case 6:{
                    juegoMasVendido();
                }break;
                case 7:{
                    System.out.println("Gracias por usar AppStore Udla");
                }break;
                default:
                    System.out.println("No es una opción válida");
            }

        }while(opc != 7);
    }
    public static void menu(){
        System.out.println("**********AppStore Udla**********");
        System.out.println("1. Ingresar Juego");
        System.out.println("2. Mostrar juegos");
        System.out.println("3. Buscar juego");
        System.out.println("4. Comprar");
        System.out.println("5. Vender");
        System.out.println("6. Juego más vendido");
        System.out.println("7. Salir");
        System.out.print("Ingrese una opcion: ");
    }

    public static void ingresarJuego(){
        System.out.println("*******Ingreso de datos********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la categoria: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese el tamanio: ");
        int tamanio = Integer.parseInt(sc.nextLine());
        System.out.print("Ingrese el precio: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Ingrese el stock inicial: ");
        int licenciasDisponibles = Integer.parseInt(sc.nextLine());
        if(as1.agregarJuego(new Juego(nombre,categoria,tamanio,precio,licenciasDisponibles))){
            JOptionPane.showMessageDialog(null,"Juego agregado con éxito");
        }else
            JOptionPane.showMessageDialog(null,"No fue posible agregar el Juego");
    }
    public static void mostrarJuegos(){
        Juego juegos[] = as1.getJuegos();
        for(Juego j : juegos){
            if(j != null){
                System.out.println(j);
            }else {
                System.out.println("No hay mas juegos");
                return;
            }
        }
    }

    public static void buscarJuego(){
        System.out.println("*******Buscar juego********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        Juego j = as1.buscarJuego(nombre);
        if(j != null){
            System.out.println(j);
        }else{
            System.out.println("No se encontró el juego");
        }
    }

    public static void comprarLicencias(){
        System.out.println("*******Comprar licencias********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());
        if(as1.comprar(nombre, cantidad)){
            System.out.println("Compra realizada con éxito");
        }else{
            System.out.println("No fue posible realizar la compra (revise el nombre y la cantidad)");
        }
    }

    public static void venderLicencias(){
        System.out.println("*******Vender licencias********");
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = Integer.parseInt(sc.nextLine());
        double total = as1.vender(nombre, cantidad);
        if(total > 0){
            System.out.println("Venta realizada con éxito. Total a pagar: $" + total);
        }else{
            System.out.println("No fue posible realizar la venta (juego inexistente, cantidad inválida o sin stock)");
        }
    }

    public static void juegoMasVendido(){
        String nombre = as1.masVendido();
        if(nombre != null){
            System.out.println("El juego más vendido es: " + nombre);
        }else{
            System.out.println("No hay juegos registrados");
        }
    }
}
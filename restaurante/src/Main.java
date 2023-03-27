import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean MenuPrincipal = false;
        File archivo = new File("/Users/danielgomezperez/Desktop/examen_practico/ficheros/Menu.txt");
        Scanner sc = new Scanner(System.in);
        Menu menu = new Menu();
        System.out.println("Bienvenido a tu restaurante personalizado. A continuación se generará un menú:");
        List <Plato> platos = new ArrayList<>();
        platos = menu.getPlatosAleatorios(platos);
        for(Plato plato : platos){
            System.out.println(plato.getNombre());
        }
        while(!MenuPrincipal){
            boolean CambiarMenu = false;
            while(!CambiarMenu) {
                try {
                    System.out.println("¿Deseas hacer otro, guardar el actual o continuar?\n 1.- Guardar el actual\n2.- Hacer otro\n3.- Continuar");
                    int eleccion = sc.nextInt();
                    switch (eleccion) {
                        case 1:
                            if (archivo.length() != 0) {
                                System.out.println("¡Atención! El archivo contiene un menú. ¿Estás seguro de que quieres sobreescribirlo? \n1.- Sí\n 2.- No");
                                int sobreescribir = sc.nextInt();
                                switch (sobreescribir) {
                                    case 1:
                                        menu.EscribirMenu(platos);
                                        menu.EscribirHistorico(platos);
                                        break;
                                    case 2:
                                        break;
                                }
                            } else {
                                menu.EscribirMenu(platos);
                                menu.EscribirHistorico(platos);
                            }
                            break;
                        case 2:
                            platos.removeAll(platos);
                            platos = menu.getPlatosAleatorios(platos);
                            for (Plato plato : platos) {
                                System.out.println(plato.getNombre());
                            }
                            System.out.println("¿Quieres guardarlo?\n1.- Sí\n2.- No");
                            int guardar = sc.nextInt();
                            switch (guardar) {
                                case 1:
                                    menu.EscribirMenu(platos);
                                    menu.EscribirHistorico(platos);
                                    break;
                                case 2:
                                    break;
                            }

                            break;
                        case 3:
                            MenuPrincipal = true;
                            CambiarMenu = true;
                            break;

                    }
                } catch (Exception e) {
                    System.out.println(e.toString());
                }
            }
            System.out.println("Quieres comprobar el histórico de menús? \n 1.- Sí \n2.- No");
            try {
                int EleccionHistorico = sc.nextInt();

                switch (EleccionHistorico) {
                    case 1:
                        List<String> HistoricoMenus = new ArrayList<>();
                        HistoricoMenus = menu.leerHistorico();
                        for (String linea : HistoricoMenus) {
                            System.out.println(linea);
                        }
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opción no contemplada");
                        break;
                }
            }catch(Exception e){
                System.out.println(e.toString());
            }
            System.out.println("¿Quieres modificar la ruta de algun archivo?\n1.- Sí\n 2.- No");
            try {
                int ModificacionRuta = sc.nextInt();
                switch (ModificacionRuta) {
                    case 1:
                        String NuevaRuta;
                        int contador = 0;
                        boolean Modificacion = false;
                        while (!Modificacion) {
                            if (contador != 0) {
                                System.out.println("¿Quieres continuar?\n1.- Sí \n 2.- No");
                                int continuar = sc.nextInt();
                                switch (continuar) {
                                    case 1:
                                        break;
                                    case 2:
                                        Modificacion = true;
                                        break;
                                }
                                if (Modificacion == true) {
                                    break;
                                }
                            }
                            System.out.println("¿Qué archivo quieres modificar?\n 1.- Entrantes.txt \n2.- Primeros.txt\n3.- Segundos.txt\n4.- Postres.txt\n5.- Menus.txt\n6.- Historico.txt");
                            int archivoAModificar = sc.nextInt();
                            switch (archivoAModificar) {
                                case 1:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.nextLine();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Entrantes.txt");
                                    } catch (IOException e) {
                                        throw new RuntimeException(e);
                                    }
                                    contador++;
                                    break;
                                case 2:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.next();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Primeros.txt");
                                    } catch (IOException e) {
                                        System.out.println(e.toString());
                                    }
                                    contador++;
                                    break;
                                case 3:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.next();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Segundos.txt");
                                    } catch (IOException e) {
                                        System.out.println(e.toString());
                                    }
                                    contador++;
                                    break;
                                case 4:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.next();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Postres.txt");
                                        contador++;
                                    } catch (IOException e) {
                                        System.out.println(e.toString());
                                    }
                                    break;
                                case 5:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.next();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Menu.txt");
                                    } catch (IOException e) {
                                        System.out.println(e.toString());
                                    }
                                    contador++;
                                    break;
                                case 6:
                                    System.out.println("Introduce la ruta del nuevo archivo");
                                    sc.next();
                                    NuevaRuta = sc.nextLine();
                                    try {
                                        Almacenamiento.ModificarRuta(NuevaRuta, "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Historico.txt");
                                    } catch (IOException e) {
                                        System.out.println(e.toString());
                                    }
                                    contador++;
                                    break;
                                default:
                                    System.out.println("Opción no contemplada. Por favor, selecciona una opción válida");
                                    contador++;
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Hasta luego");
                        MenuPrincipal = true;
                        break;
                    default:
                        System.out.println("Opción no contemplada");
                        break;
                }
            }catch(Exception e){
                System.out.println(e.toString());
            }
        }
    }
}
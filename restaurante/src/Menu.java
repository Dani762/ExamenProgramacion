import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Plato> platosAleatorios;

    Menu(){
        platosAleatorios = new ArrayList<>();
    }

    public List<Plato> getPlatosAleatorios(List<Plato> platosAleatorios) {
        Almacenamiento llamadaPlatos = new Almacenamiento();
        platosAleatorios.add(llamadaPlatos.getEntranteRandom());
        platosAleatorios.add(llamadaPlatos.getPrimeroRandom());
        platosAleatorios.add(llamadaPlatos.getSegundoRandom());
        platosAleatorios.add(llamadaPlatos.getPostreRandom());
        this.platosAleatorios = platosAleatorios;
        return this.platosAleatorios;
    }
    public void EscribirMenu(List <Plato> platos){
        FileWriter archivo;
        BufferedWriter escritor;
        try {
            archivo = new FileWriter("/Users/danielgomezperez/Desktop/examen_practico/ficheros/Menu.txt");
            escritor = new BufferedWriter(archivo);
            for (Plato plato : platos){
                escritor.write(plato.getNombre() + "\n");
            }
            escritor.close();
            archivo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Plato> LeerMenu (List <Plato> platos){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Menu.txt";
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader(ruta);
            lector = new BufferedReader(archivo);
            int contador = 0;
            String linea;
            while((linea = lector.readLine()) != null){
              switch (contador){
                  case 0:
                      platos.add(new Entrante(linea));
                      break;
                  case 1:
                      platos.add(new Primero(linea));
                      break;
                  case 2:
                      platos.add(new Segundo(linea));
                      break;
                  case 3:
                      platos.add(new Postre(linea));
                      break;

              }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return platos;
    }

    public void EscribirHistorico (List <Plato> menu){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Historico.txt";
        FileWriter archivo;
        BufferedWriter escritor;
        try {
            archivo = new FileWriter(ruta, true);
            escritor = new BufferedWriter(archivo);
            escritor.write("Nuevo menú\n");
            for (Plato plato : menu){
                escritor.write(plato.getNombre() + "\n");
            }
            escritor.close();
            archivo.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> leerHistorico(){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Historico.txt";
        List<String> HistoricoMenus = new ArrayList<>();
        FileReader archivo;
        BufferedReader lector;
        try {
            archivo = new FileReader(ruta);
            lector = new BufferedReader(archivo);
            String linea;
            while((linea = lector.readLine()) != null){
                Menu menu;
                HistoricoMenus.add(linea);
            }
            lector.close();
            archivo.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return HistoricoMenus;
    }
}

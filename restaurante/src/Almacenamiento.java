import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Almacenamiento implements Inventario, Serializable {



    @Override
    public Entrante LeerEntrante(String ruta) {
        ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Entrantes.txt";
        List<String> entrantes = new ArrayList<>();
        Random random = new Random();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                entrantes.add(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int aleatorio = random.nextInt(entrantes.size());
        return new Entrante(entrantes.get(aleatorio));
    }
    @Override
        public Plato LeerPrimero(String ruta) {
        ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Primeros.txt";
        List<String> primeros = new ArrayList<>();
        Random random = new Random();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                primeros.add(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int aleatorio = random.nextInt(primeros.size());
        return new Primero(primeros.get(aleatorio));
    }

    @Override
    public Plato LeerSegundo(String ruta) {
        ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Segundos.txt";
        List<String> segundos = new ArrayList<>();
        Random random = new Random();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                segundos.add(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int aleatorio = random.nextInt(segundos.size());
        return new Segundo(segundos.get(aleatorio));
    }

    @Override
    public Plato LeerPostre(String ruta) {
        ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Postres.txt";
        List<String> postre = new ArrayList<>();
        Random random = new Random();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;
            while ((linea = lector.readLine()) != null) {
                postre.add(linea);
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int aleatorio = random.nextInt(postre.size());
        return new Postre(postre.get(aleatorio));
    }

    @Override
    public void escribirFicheros(String ruta) {

    }
    public Entrante getEntranteRandom(){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Entrantes.txt";
        Entrante entrante = LeerEntrante(ruta);

        return entrante;
    }
    public Primero getPrimeroRandom(){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Primeros.txt";
        Primero primero = (Primero) LeerPrimero(ruta);
        return primero;
    }
    public Segundo getSegundoRandom(){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Segundos.txt";
        Segundo segundo = (Segundo) LeerSegundo(ruta);
        return segundo;
    }
    public Postre getPostreRandom(){
        String ruta = "/Users/danielgomezperez/Desktop/examen_practico/ficheros/Postres.txt";
        Postre postre = (Postre)LeerPostre(ruta);
        return postre;
    }
    public static File ModificarRuta(String ruta, String RutaActual) throws IOException{
        Path RutaAhora = Paths.get(RutaActual);
        Path nuevaRuta = Paths.get(ruta);
        Files.move(RutaAhora,nuevaRuta, StandardCopyOption.REPLACE_EXISTING);
        return nuevaRuta.toFile();
    }
}

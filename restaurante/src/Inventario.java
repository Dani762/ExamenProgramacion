public interface Inventario {

    public Plato LeerEntrante(String ruta);
    public Plato LeerPrimero(String ruta);
    public Plato LeerSegundo(String ruta);
    public Plato LeerPostre(String ruta);
    public void escribirFicheros(String ruta);
}

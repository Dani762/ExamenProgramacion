public class Main {

    public static void main(String[] args) {
        int max = 10;
        float y = 4.5F;
        Valores val = new Valores(max);
        System.out.println("El máximo tamaño del array es " + val.getMax_tam());
        System.out.println("Se rellena con valores al azar");
        val.ranValues(y);
        System.out.println("Son los siguientes:");
        for (float f : val.getVal()) {
            System.out.println(f);
        }
        System.out.println("Se recoge el primer valor: " + val.getVal(0));
        System.out.println("Se recoge el último valor: " + val.getVal(val.getVal().length-1));
        System.out.println("Se rellena con valores al azar entre un rango dado");
        val.ranValues(100, 1000);
        System.out.println("Son los siguientes:");
        for (float f : val.getVal()) {
            System.out.println(f);
        }
        System.out.println("Se recoge un valor al azar entre un min y max dados: " + val.getVal(0, val.getVal().length));
    }
}
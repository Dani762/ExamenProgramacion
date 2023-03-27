public class Valores implements modularValues{
    private int max_tam;
    private float [] val;

    public Valores(){}

    public Valores(int max_tam){
        this.max_tam = max_tam;
        this.val = new float[max_tam];
    }

    public int getMax_tam() {
        return max_tam;
    }

    public void setMax_tam(int max_tam) {
        this.max_tam = max_tam;
    }

    @Override
    public float getVal(int index) {
        return this.val [index];
    }

    @Override
    public float getVal(int min, int max) {
        int r = (int) Math.floor((Math.random()*max) + min);
        float r_val = 0f;
        try {
            r_val = this.val[r];
        } catch (IndexOutOfBoundsException e){
            System.out.println("Error, índice fuera del array");
        }
        return r_val;
    }

    @Override
    public void ranValues() {

    }

    public void ranValues(float v) {
        v = -1f;
        for(int i=0;i<this.val.length;i++){
            v = (float) (Math.random() * this.val.length);
            this.val[i] = v;
        }
    }

    @Override
    public void ranValues(int min, int max) {
        float v = -1f;
        for (int i = 0; i < this.val.length; i++) {
            v = (float) ((Math.random() * max - min) + min);
            this.val[i] = v;
        }
    }

    @Override
    public float[] getVal() {
        return val;
    }

    @Override
    public float getVal(float index){
        float r_val = 0f;
        try {
            r_val = val[(int) index];
        } catch (IndexOutOfBoundsException e){
            System.out.println("Error, índice fuera del array");
        }
        return r_val;
    }

}
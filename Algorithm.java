package encryptdecrypt;

public abstract class Algorithm {
    protected String st;
    protected int key;

    public Algorithm(String s, int key) {
        this.st = s;
        this.key = key;
    }

    public void setSt(String st) {
        this.st = st;
    }

    public String getSt() {
        return st;
    }



    public abstract void encrypt ();
    public abstract void decrypt ();
}


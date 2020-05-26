package encryptdecrypt;

public class Unicode extends Algorithm {

    public Unicode (String s, int key) {
        super(s, key);
    }

    public  void encrypt () {
        char [] res = this.st.toCharArray();
        for(int i = 0; i < res.length; i++ ){
            int aux = res[i] + this.key;
            aux = aux % 127;
            res[i] = (char) aux;

        }
        this.setSt(new String(res));

    }
    public  void decrypt (){
        char [] res = st.toCharArray();
        for(int i = 0; i < res.length; i++ ){
            int aux = res[i] - key;
            if (aux < 0) {
                aux = 127 + aux;
            }
            res[i] = (char) aux;

        }
        this.setSt(new String(res));
    }
}

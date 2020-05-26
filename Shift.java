package encryptdecrypt;

public class Shift extends Algorithm {

    public Shift (String s, int key) {
        super(s, key);
    }


    public void encrypt () {
        char [] res = this.st.toCharArray();
        for(int i = 0; i < res.length; i++ ){
            int aux;
            if (res[i] >= 97 && res[i] <= 122) {
                aux = res[i] + this.key;
                if (aux > 122 ) {
                    aux = 96 + aux - 122;
                }
                res[i] = (char) aux;
            } else if (res[i] >= 65 && res[i] <= 90) {
                aux = res[i] + this.key;
                if (aux > 90) {
                    aux = 64 + aux - 90;
                }
                res[i] = (char) aux;
            }

        }
        this.setSt(new String(res));

    }

    public void decrypt (){
        char [] res = this.st.toCharArray();
        for(int i = 0; i < res.length; i++ ){
            int aux;
            if (res[i] >= 97 && res[i] <= 122) {
                aux = res[i] - this.key;
                if (aux < 97 ) {
                    aux =  122 + aux - 97 + 1;
                }
                res[i] = (char) aux;
            } else if (res[i] >= 65 && res[i] <= 90) {
                aux = res[i] - this.key;
                if (aux < 65) {
                    aux = 90 + aux - 65 + 1 ;
                }
                res[i] = (char) aux;
            }

        }
        this.setSt(new String(res));
    }
}

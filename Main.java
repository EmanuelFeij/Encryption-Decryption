package encryptdecrypt;



import java.io.*;
import java.util.Scanner;


public class Main {




    public static <printWriter> void main(String[] args) throws FileNotFoundException {
        //Scanner scanner = new Scanner(System.in);
        String command = "enc";
        int num = 0;
        String message = "";
        String alg = "";




        File fileIn = null;
        File fileOut = null;
        for (int i = 0; i < args.length; i++) {

            switch (args[i]) {
                case "-mode" :
                    command = new String(args[i+1]);
                    i++;
                    break;
                case "-key" :
                    num = Integer.parseInt(args[i+1]);
                    i++;
                    break;
                case "-data" :
                    message = new String(args[i+1]);
                    i++;
                    break;
                case "-in" :
                    fileIn = new File(args[i+1]);
                    i++;
                    break;
                case "-out" :
                    fileOut = new File(args[i+1]);
                    i++;
                    break;
                case "-alg" :
                    alg = new String(args[i+1]);
                    i++;
                    break;

            }

        }

        switch (command) {
            case "enc" :
                Algorithm algImpl;
                if ("shift".equals(alg)) {
                    algImpl = new Shift("", num);
                } else {
                    algImpl = new Unicode("", num);
                }
                if (fileIn != null && fileOut != null) {
                    String data;


                    try (Scanner scanner = new Scanner(fileIn);
                         PrintWriter printWriter = new PrintWriter(fileOut) ) {
                        while (scanner.hasNext()) {
                            data = scanner.nextLine();
                            algImpl.setSt(data);
                            algImpl.encrypt();
                            printWriter.print(algImpl.getSt());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                } else {
                    algImpl.setSt(message);
                    algImpl.encrypt();
                    System.out.println(algImpl.getSt());
                    break;
                }
            case "dec" :
                Algorithm algImplem2;
                if ("shift".equals(alg)) {
                    algImplem2 = new Shift("", num);
                } else {
                    algImplem2 = new Unicode("", num);
                }
                if (fileIn != null && fileOut != null) {
                    String data;


                    try (Scanner scanner = new Scanner(fileIn);
                         PrintWriter printWriter = new PrintWriter(fileOut) ) {
                        while (scanner.hasNext()) {
                            data = scanner.nextLine();
                            algImplem2.setSt(data);
                            algImplem2.decrypt();
                            printWriter.print(algImplem2.getSt());
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    algImplem2.setSt(message);
                    algImplem2.decrypt();
                    System.out.println(algImplem2.getSt());
                    break;
                }
        }

    }
}
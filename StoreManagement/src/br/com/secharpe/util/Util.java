package br.com.secharpe.util;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author LuizAlexandre17 <luizalexandreluz@unesc.net>
 */
public class Util {

    public void escrever(String username) throws IOException {
        //O segundo parametro "true" indica append para o arquivo em quest�o.
        FileOutputStream escritorArquivos = null;
        try {
            escritorArquivos = new FileOutputStream("user.last", false);
            int tamanho = 0;
            String msg = username;
            while (tamanho < msg.length()) {
                escritorArquivos.write((int) msg.charAt(tamanho++));
            }
        } finally {
            escritorArquivos.flush();
            escritorArquivos.close();
        }
    }

    public String lerArquivo() {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("user.last"));
            String str;
            StringBuffer buf = new StringBuffer();
            while (in.ready()) {
                str = in.readLine();
                buf.append(str);
            }
            return buf.toString();
        } catch (IOException e) {
            //erro.erro
            return null;
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                //erro.erro
            }
        }
    }
}

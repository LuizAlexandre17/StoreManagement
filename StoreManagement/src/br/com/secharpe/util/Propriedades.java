package br.com.secharpe.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author luandr
 */
public final class Propriedades {

    public static void setProp(String prpt, String value) {

        OutputStream output = null;
        Properties prop = new Properties();

        verificacao:
        try {

            output = new FileOutputStream(Vars.PROP_FILE);

            // set the properties value
            if (prpt.equals("") && value.equals("")) {
                break verificacao;
            }
            prop.setProperty(prpt, value);

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }

        }

    }

    public static String getProp(String prpt) {
        FileInputStream input = null;
        try {
            input = new FileInputStream(Vars.PROP_FILE);
            Properties prop = new Properties();
            prop.load(input);
            return prop.getProperty(prpt);
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
        return null;
    }

    public static String getLang() {
        String str = "";
        for (String name : Vars.LANG_LIST) {
            BufferedReader in = null;
            try {
                in = new BufferedReader(new FileReader("lang.cfg"));
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
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ex) {
                        //erro.erro
                    }
                }
            }
        }
        return str;
    }
}

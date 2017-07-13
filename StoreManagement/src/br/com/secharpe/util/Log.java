package br.com.secharpe.util;

/**
 * Classe para gerenciar arquivo de Log
 *
 * Estudantes de Ciência da Computação - 4 fase.
 *
 * @author Luan Darabas
 * @author Luiz Alexandre da Luz
 * @author Maurício Generoso
 *
 * @since 30/10/2016
 * @version 1.1
 */
public final class Log {

    private String file;
    private final java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private final java.util.Date date = new java.util.Date();

    public void put(String file, String message) {
        try {
            java.io.BufferedWriter buffer = new java.io.BufferedWriter(new java.io.FileWriter("log.txt", true));
            renameDotJava(file);
            write("[" + this.date + "] [" + this.file + "] [CONSTRUTOR] :: " + message, buffer);
        } catch (java.io.IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void put(String file, String function, String message) {
        try {
            java.io.BufferedWriter buffer = new java.io.BufferedWriter(new java.io.FileWriter("log.txt", true));
            renameDotJava(file);
            write("[" + this.date + "] [" + this.file + "] [" + function + "] :: " + message, buffer);
        } catch (java.io.IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void put(String file, String function, int number, String message) {
        try {
            java.io.BufferedWriter buffer = new java.io.BufferedWriter(new java.io.FileWriter("log.txt", true));
            renameDotJava(file);
            write("[" + this.date + "] [" + this.file + "] [" + function + "] [" + number + "] :: " + message, buffer);
        } catch (java.io.IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void write(String content, java.io.BufferedWriter buffer) {
        try {
            buffer.write(content + System.getProperty("line.separator"));
            buffer.flush();
        } catch (java.io.IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            System.out.println(content);
            try {
                buffer.close();
            } catch (java.io.IOException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private void renameDotJava(String file) {
        this.file = file.toUpperCase() + ".java".toUpperCase();
    }
}

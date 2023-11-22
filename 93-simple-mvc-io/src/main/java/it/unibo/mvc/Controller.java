package it.unibo.mvc;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import it.unibo.mvc.api.SimpleController;

/**
 * Application controller. Performs the I/O.
 */
public class Controller implements SimpleController{

    public static final String SEP = File.separator;
    public static final String FILE_NAME = System.getProperty("user.home") + SEP + "output.txt";
    private File output;

    public Controller() {
        this.output = new File(FILE_NAME);
    }

    @Override
    public void setFile(File file) {
        this.output = file;
    }

    @Override
    public File getFile() {
        return this.output;
    }

    @Override
    public String getPath() {
        return this.output.getPath();
    }

    @Override
    public void writeContent(String content) throws IOException {
        final OutputStream file = new FileOutputStream(this.output.getPath());
        final DataOutputStream out = new DataOutputStream(file);
        out.writeUTF(content);
    }
}

package it.unibo.mvc.api;

import java.io.File;
import java.io.IOException;

public interface SimpleController {

    public void setFile(File file);

    public File getFile();

    public String getPath();

    public void writeContent(String content) throws IOException;
}

package ServerDemo;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class MyObjectOutputStream extends ObjectOutputStream{
    protected MyObjectOutputStream(OutputStream outputStream)throws IOException,SecurityException{
        super(outputStream);
    }

    protected void writeStreamHeader() throws IOException,SecurityException{

    }

}

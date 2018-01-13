package com.johnny.store.common;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class XmlSerializeUtils {
    public static <T> void serializeToFile(T obj, String xmlName) throws FileNotFoundException{
        File xmlFile = new File(xmlName);
        FileOutputStream outputStream = new FileOutputStream(xmlFile);
        XMLEncoder xmlEncoder = new XMLEncoder(outputStream, "UTF-8", true, 0);
        xmlEncoder.writeObject(obj);
        xmlEncoder.close();
    }

    public static <T> T deserializeToObject(String xmlName) throws FileNotFoundException{
        File xmlFile = new File(xmlName);
        FileInputStream inputStream = new FileInputStream(xmlFile);
        XMLDecoder xd = new XMLDecoder(inputStream);
        T obj = (T)xd.readObject();
        xd.close();
        return obj;
    }

    public static <T> T deserializeToObject(InputStream stream) throws FileNotFoundException{
        XMLDecoder xd = new XMLDecoder(stream);
        T obj = (T)xd.readObject();
        xd.close();
        return obj;
    }
}

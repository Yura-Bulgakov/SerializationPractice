package org.example.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class XmlToJsonAdapter<T, V> {
    private TypeMapper<T, V> typeMapper;
    private Class<T> tClass;
    private Class<V> vClass;
    private XmlMapper xmlMapper;
    private ObjectMapper objectMapper;

    public XmlToJsonAdapter(TypeMapper<T, V> typeMapper, Class<T> tClass, Class<V> vClass) {
        this.typeMapper = typeMapper;
        this.tClass = tClass;
        this.vClass = vClass;
        xmlMapper = new XmlMapper();
        objectMapper = new ObjectMapper();
    }

    public void adapt(String xmlFile, String jsonFile) throws IOException {
        try (InputStream inputStream = getClass().getResourceAsStream(xmlFile)) {
            if (inputStream != null) {
                T data = xmlMapper.readValue(inputStream, tClass);
                V writeData = typeMapper.map(data);
                objectMapper.writeValue(new File(jsonFile), writeData);
                System.out.printf("Перезапись данных из %s в %s прошла успешно %n", xmlFile, jsonFile);
            } else {
                System.out.println("Не удалось загрузить файл: " + xmlFile);
            }
        }
    }

}

package org.example.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.client.ClientInfo;
import org.example.person.PersonInfo;
import org.mapstruct.factory.Mappers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class XmlToJsonAdapter {
    private ClientToPersonMapper clientToPersonMapper;

    public XmlToJsonAdapter() {
        clientToPersonMapper = Mappers.getMapper(ClientToPersonMapper.class);
    }

    public void adapt(String xmlFile, String jsonFile) {
        XmlMapper xmlMapper = new XmlMapper();
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream(xmlFile)) {
            if (inputStream != null) {
                ClientInfo clientInfo = xmlMapper.readValue(inputStream, ClientInfo.class);
                PersonInfo personInfo = clientToPersonMapper.clientInfoToPersonInfo(clientInfo);
                objectMapper.writeValue(new File(jsonFile), personInfo);
                System.out.printf("Перезапись данных из %s в %s прошла успешно %n", xmlFile, jsonFile);
            } else {
                System.out.println("Не удалось загрузить файл: " + xmlFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

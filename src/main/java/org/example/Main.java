package org.example;

import org.example.client.ClientInfo;
import org.example.mapping.ClientToPersonMapper;
import org.example.mapping.FilePath;
import org.example.mapping.XmlToJsonAdapter;
import org.example.person.PersonInfo;
import org.mapstruct.factory.Mappers;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        XmlToJsonAdapter<ClientInfo, PersonInfo> xmlToJsonAdapter = new XmlToJsonAdapter<>(
                Mappers.getMapper(ClientToPersonMapper.class), ClientInfo.class, PersonInfo.class);
        try {
            xmlToJsonAdapter.adapt(FilePath.XML_FILE, FilePath.JSON_FILE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
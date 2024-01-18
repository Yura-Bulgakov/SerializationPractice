package org.example;

import org.example.mapping.FilePath;
import org.example.mapping.XmlToJsonAdapter;

public class Main {
    public static void main(String[] args) {
        XmlToJsonAdapter xmlToJsonAdapter = new XmlToJsonAdapter();
        xmlToJsonAdapter.adapt(FilePath.XML_FILE, FilePath.JSON_FILE);
    }
}
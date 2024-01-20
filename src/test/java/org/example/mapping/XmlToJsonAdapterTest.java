package org.example.mapping;

import org.example.client.ClientInfo;
import org.example.person.PersonInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.io.*;

@ExtendWith(MockitoExtension.class)
class XmlToJsonAdapterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originOut = System.out;
    private TypeMapper<ClientInfo, PersonInfo> typeMapperMock;
    private XmlToJsonAdapter<ClientInfo, PersonInfo> adapter;

    @BeforeEach
    void setUp() {
        typeMapperMock = Mockito.mock(TypeMapper.class);
        adapter = new XmlToJsonAdapter<>(typeMapperMock, ClientInfo.class, PersonInfo.class);
        System.setOut(new PrintStream(outContent));
    }

    private String getCapturedOut() {
        System.setOut(originOut);
        return outContent.toString().trim();
    }

    @Test
    void adaptSuccessful() throws IOException {
        Mockito.when(typeMapperMock.map(Mockito.any())).thenReturn(new PersonInfo());
        String xmlFilePath = "/TestClientInfo.xml";
        File tempFile = File.createTempFile("tempFile", ".json", new File("src/test/resources"));
        Assertions.assertDoesNotThrow(() -> adapter.adapt(xmlFilePath, tempFile.getPath()));
    }

    @Test
    void adaptNotExistingFile() throws IOException {
        String xmlFilePath = "/nnnn.xml";
        File tempFile = File.createTempFile("tempFile", ".json", new File("src/test/resources"));
        Assertions.assertThrows(FileNotFoundException.class, () -> adapter.adapt(xmlFilePath, tempFile.getPath()));
        tempFile.deleteOnExit();
    }

    @Test
    void adaptIOExceptionThrown() throws IOException {
        Mockito.when(typeMapperMock.map(Mockito.any())).thenAnswer(new Answer<Object>() {
            @Override
            public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
                throw new IOException();
            }
        });
        String xmlFilePath = "/TestClientInfo.xml";
        File tempFile = File.createTempFile("tempFile", ".json", new File("src/test/resources"));
        Assertions.assertThrows(IOException.class, () -> adapter.adapt(xmlFilePath, tempFile.getPath()));
        tempFile.deleteOnExit();
    }
}
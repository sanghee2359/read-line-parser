package com.line.Writer;

import java.io.IOException;
import java.util.List;

public interface sqlWriter<T> {
    void createAFile();
    void writeSql(List<T> contents) throws IOException;
}

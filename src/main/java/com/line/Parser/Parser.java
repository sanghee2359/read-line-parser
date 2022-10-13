package com.line.Parser;

public interface Parser<T> {
    // parsing할 파일의 자료형에 따라 Object를 다양하게 받기 위해 제네릭 <T>
    T parse(String str);
}

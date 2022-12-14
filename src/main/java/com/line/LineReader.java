package com.line;
import com.line.Parser.Parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// 리팩토링
/*
1. parser 인터페이스 생성
2. constructor 생성 : parser 값을 받아준다.
3. isRemoveColumName : 첫번째 줄을 넘어가고 다음줄부터 실행할 것인지 결정하는 변수
*/
public class LineReader<T> {
    Parser<T> parser;
    boolean isRemoveColumName = true;

    public LineReader(Parser<T> parser) {
        this.parser = parser;
    }
    public LineReader(Parser<T> parser, boolean isRemoveColumName) {
        this.parser = parser;
        this.isRemoveColumName = isRemoveColumName;
    }


    List<T> readLines(String filename) throws IOException {
        List<T> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        if(isRemoveColumName){
            br.readLine();
        }
        while((str = br.readLine())!= null){
            // 인터페이스 Parser의 객체 parser을 통해 parse() 메소드 사용
            result.add(parser.parse(str));

            // str은 한 줄 씩 읽어왔는데, parser을 사용함으로서 원하는 정보만 뽑아 쓸 수 있다.
            //result.add(str);
        }
        return result;
    }
}

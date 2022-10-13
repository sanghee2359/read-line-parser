package com.line.Parser;
// 첫번째 filereader : 파일 내용을 string으로 한 줄씩 읽어옴

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineReader {
    List<String> readLine(String filename) throws IOException {    // default 메소드
        List<String> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String str;
        while((str= br.readLine())!= null){     // filename 의 한 줄씩 읽어옴
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        LineReader lr = new LineReader();
        String targetFile = "C:\\Users\\wjdtk\\Downloads\\서울시 병의원 위치 정보.csv";
        List<String> line = lr.readLine(targetFile);
        System.out.println(line.size());
    }
}
/*
* 19040 개의 병원 정보가 들어갔다.
 */
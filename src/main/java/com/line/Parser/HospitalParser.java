package com.line.Parser;

import com.line.domain.Hospital;

// Parse 의 구현체
public class HospitalParser implements Parser<Hospital>{ // type = Hospital
    private String replaceAllQuot(String str){
        return str.replaceAll("\"", "");
    }
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        return new Hospital(replaceAllQuot(splitted[0]), replaceAllQuot(splitted[1]), replaceAllQuot(splitted[3]),
                replaceAllQuot(splitted[6]), replaceAllQuot(splitted[10]), replaceAllQuot(splitted[7]));  // hospital 객체 생성
    }
}

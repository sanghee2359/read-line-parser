package com.line.Parser;

import com.line.domain.Hospital;

// Parse 의 구현체
public class HospitalParser implements Parser<Hospital>{ // type = Hospital

    @Override
    public Hospital parse(String str) {
        str= str.replaceAll("\"", "");
        String[] splitted = str.split(",");
        return new Hospital(splitted[0], splitted[1], splitted[3],
                splitted[6], splitted[10], splitted[7]);  // hospital 객체 생성
    }
}

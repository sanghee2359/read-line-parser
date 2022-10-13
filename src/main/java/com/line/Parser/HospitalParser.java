package com.line.Parser;

import com.line.domain.Hospital;

// Parse 의 구현체 1
public class HospitalParser implements Parser<Hospital>{ // type이 Hospital
    @Override
    public Hospital parse(String str) {
        String[] splitted = str.split(",");
        return new Hospital(splitted[0], splitted[1], splitted[3], splitted[6], splitted[10]);  // hospital 객체 생성
    }
}

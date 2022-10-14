package com.line.Parser;

import com.line.domain.Hospital;

// Parse 의 구현체
public class HospitalParser implements Parser<Hospital>{ // type = Hospital
    @Override
    public Hospital parse(String str) {
        str = str.replaceAll("\"", "");
        String[] splitted = str.split(",");
        String name = splitted[10];
        String subDivision = getSubDivision(name);
        return new Hospital(splitted[0], splitted[1], splitted[2], splitted[6], name, subDivision);  // hospital 객체 생성
    }

    private String getSubDivision(String name) {
        String[] subdibisions = {"소아과", "피부과", "성형외과", "정형외과", "산부인과", "관절", "안과", "가정의학과", "비뇨기과", "치과", "내과", "외과"};
        for(String subDivision : subdibisions){
            if(name.contains(subDivision))
                return subDivision;
        }
        return "";
    }

}

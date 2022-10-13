package com.line;

import com.line.Parser.HospitalParser;
import com.line.domain.Hospital;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "C:\\Users\\wjdtk\\Downloads\\서울시 병의원 위치 정보.csv";
        hospitalLineReader.readLines(filename);
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);

        System.out.println(hospitals.size());

        for(Hospital hospital : hospitals){
            System.out.print("id:"+ hospital.getId());
            System.out.print(", 주소:"+hospital.getAddress());
            System.out.print(", 구역:"+hospital.getDistinct());
            System.out.print(", 병원 분류:"+hospital.getCategory());
            System.out.print(", 응급실 개수:"+hospital.getEmergency_room());
            System.out.print(", 병원 이름:"+hospital.getName());
            System.out.print(", 비고:"+hospital.getSubdivision());
            System.out.println();
        }
    }
}
/*
...
id:A1119528, 주소:서울특별시 서초구 서초대로77길 3 4층 (서초동 아라타워), 구역:서울특별시 서초구, 병원 분류:의원, 응급실 개수:2, 병원 이름:신데렐라성형외과의원, 비고:평일 점심시간 13:00~14:00(토요일 점심시간 없음)
id:A1117217, 주소:서울특별시 서초구 서초대로77길 3 아라타워 4층 (서초동), 구역:서울특별시 서초구, 병원 분류:치과의원, 응급실 개수:2, 병원 이름:신데렐라치과의원, 비고:점심시간 13:00~14:00
...
*/

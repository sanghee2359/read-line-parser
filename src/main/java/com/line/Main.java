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
            System.out.print(", 주요 진료 :"+hospital.getCategory());
            System.out.print(", 응급실 개수 :"+hospital.getEmergency_room());
            System.out.print(", 병원 이름 :"+hospital.getName());
            System.out.print(", 주요 진료 유무:"+hospital.getSubdivision());
            System.out.println();
        }
    }
}

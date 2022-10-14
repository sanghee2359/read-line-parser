package com.line;

import com.line.Parser.HospitalParser;
import com.line.Writer.HospitalWriter;
import com.line.domain.Hospital;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        LineReader<Hospital> hospitalLineReader = new LineReader<>(new HospitalParser());
        String filename = "C:\\Users\\wjdtk\\Downloads\\서울시 병의원 위치 정보.csv";
        List<Hospital> hospitals = hospitalLineReader.readLines(filename);
//        List<String> lines = new ArrayList<>();

        for(Hospital hospital : hospitals){
            System.out.printf("%s,%s,%s,%s,%d,%s,%s\n",hospital.getId(),hospital.getAddress(), hospital.getDistrict(),hospital.getCategory(),
                    hospital.getEmergency_room(),hospital.getName(),hospital.getSubdivision());
        }
        String targetName = "seoul_hospital_insert.sql";
        HospitalWriter writer = new HospitalWriter(targetName);
        writer.writeSql(hospitals);
    }
}
/*
...
A1108483,서울특별시 용산구 우사단로 3 (보광동),서울특별시 용산구,치과의원,2,힐탑치과의원,치과
A1123123,서울특별시 성동구 아차산로 113 삼진빌딩 3층 301302호 (성수동2가),서울특별시 성동구,의원,2,힘내라내과의원,내과
B1105361,서울특별시 강서구 화곡로 429 토피아 401호 (가양동),서울특별시 강서구,한의원,2,힘내라한의원,
A1121827,서울특별시 양천구 목동서로 383 3 5층 (신정동),서울특별시 양천구,의원,2,힘찬나아라정형외과의원,정형외과
B1102407,서울특별시 강동구 천호대로 1027,서울특별시 강동구,한의원,2,힘찬마디한의원,
A1103025,서울특별시 강서구 곰달래로 223 (화곡동),서울특별시 강서구,의원,2,힘찬부성정형외과의원,정형외과
B1101664,서울특별시 용산구 한강대로 109 (한강로2가 용성비즈텔),서울특별시 용산구,한의원,2,힘찬세상경희한의원,
C1108476,서울특별시 강남구 봉은사로 213 센트럴타워 5~8층 (논현동),서울특별시 강남구,한방병원,2,힘찬큐한방병원,
C1108345,서울특별시 강서구 강서로 173 터보빌딩 789층 (화곡동),서울특별시 강서구,한방병원,2,힘찬하나로한방병원,
A1116520,서울특별시 은평구 은평로 170 305호 (응암동 상현빌딩),서울특별시 은평구,의원,2,힘튼의원,
 */
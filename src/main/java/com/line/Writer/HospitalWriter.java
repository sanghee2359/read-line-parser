package com.line.Writer;

import com.line.domain.Hospital;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HospitalWriter implements sqlWriter<Hospital>{
    File file;

    public HospitalWriter(String filename) {
        this.file = new File(filename);
        createAFile();
    }

    @Override
    public void createAFile() {
        try{
            if(file.createNewFile()){
                System.out.println("File created");
            }else {
                System.out.println("File already exists");
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void writeSql(List<Hospital> contents) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        String insertStatement = String.format("INSERT INTO `like-lion-db`.`Seoul_hospital`\n" +
                "(`id`,`address`,`district`,`category`,`emergency_room`,`name`,`subdivision`)" +
                "\nVALUES\n");
        writer.write(insertStatement);

        for(int i = 0; i < contents.size(); i++){
            Hospital content = contents.get(i);
            writer.newLine(); // 첫번째 입력 전에 한칸 뛰기
            writer.write(String.valueOf(content));
            if(i < contents.size() -1){
                writer.write(",");
            }
        }
        writer.flush();
        writer.close();
        System.out.println("파일이 생성되었습니다.");
    }
}



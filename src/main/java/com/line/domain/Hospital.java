package com.line.domain;

// HospitalParser로 split한 정보를
// id, name, address 등등으로 알려주는 클래스구나
public class Hospital {
    private String id;
    private String address;
    private String distinct;
    private String category;
    private Integer emergency_room; // 제네릭<T>에 들어가기 때문에 Integer
    private String name;
    private String subdivision;

    public Hospital(String id, String address, String category,
                    String name, String subdivision) {
        this.id = id.replaceAll("\"", "");
        this.address = address.replaceAll("\"", "");
        this.category = category.replaceAll("\"", "");
        this.emergency_room = emergency_room;
        this.name = name.replaceAll("\"", "");
        this.subdivision = subdivision.replaceAll("\"", "");
        setDistrict();
    }

    private void setDistrict() {
        String[] arr = address.split(" ");
        this.distinct = arr[0]+" "+arr[1];
    }
    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }
    public String getDistinct() {
        return distinct;
    }
    public String getCategory() {
        return category;
    }
    public Integer getEmergency_room() {
        return emergency_room;
    }
    public String getName() {
        return name;
    }
    public String getSubdivision() {
        return subdivision;
    }
}

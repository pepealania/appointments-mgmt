package com.simplilearn.course.model;

public class Participant {
    private int id;
    private String name;
    private int age;
    private String email;
    private int batchId;

    public Participant() {}

    public Participant(int id, String name, int age, String email, int batchId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.batchId = batchId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getBatchId() { return batchId; }
    public void setBatchId(int batchId) { this.batchId = batchId; }
}

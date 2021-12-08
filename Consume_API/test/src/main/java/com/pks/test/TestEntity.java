package com.pks.test;


import javax.persistence.*;

@Entity
@Table
public class TestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data1;
    private String data2;

    private TestEntity2 testEntity2;

    public TestEntity(Long id, String data1, String data2, TestEntity2 testEntity2) {
        this.id = id;
        this.data1 = data1;
        this.data2 = data2;
        this.testEntity2 = testEntity2;
    }

    public TestEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public TestEntity2 getTestEntity2() {
        return testEntity2;
    }

    public void setTestEntity2(TestEntity2 testEntity2) {
        this.testEntity2 = testEntity2;
    }
}

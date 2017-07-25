package com.example.nhutl.sqlexample.dto;

/**
 * Created by nhutl on 7/23/2017.
 */

public class Column {
    private  String cot1;
    private String cot2;
    private String cot3;
    private String cot4;
    private  int cot5;
    private int cot6;

    public String getCot1() {
        return cot1;
    }

    public void setCot1(String cot1) {
        this.cot1 = cot1;
    }

    public String getCot2() {
        return cot2;
    }

    public void setCot2(String cot2) {
        this.cot2 = cot2;
    }

    public String getCot3() {
        return cot3;
    }

    public void setCot3(String cot3) {
        this.cot3 = cot3;
    }

    public String getCot4() {
        return cot4;
    }

    public void setCot4(String cot4) {
        this.cot4 = cot4;
    }


    public int getCot5() {
        return cot5;
    }

    public void setCot5(int cot5) {
        this.cot5 = cot5;
    }

    public int getCot6() {
        return cot6;
    }

    public void setCot6(int cot6) {
        this.cot6 = cot6;
    }

    public Column(String cot1, String cot2, String cot3, String cot4, String cot5, String cot6) {

        this.cot1 = cot1;
        this.cot2 = cot2;
        this.cot3 = cot3;
        this.cot4 = cot4;
        this.cot4 = cot5;
        this.cot4 = cot6;
    }

    public Column(String cot1, String cot2, String cot3, String cot4) {

        this.cot1 = cot1;
        this.cot2 = cot2;
        this.cot3 = cot3;
        this.cot4 = cot4;
    }

    public Column() {

    }
}

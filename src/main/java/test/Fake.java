package test;


/**
 * Fake Object (model)
 */
public class Fake {

    public String field1;
    public Integer field2;


    public Fake() {
    }

    public Fake(String field1, Integer field2) {
        this.field1 = field1;
        this.field2 = field2;
    }


    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public Integer getField2() {
        return field2;
    }

    public void setField2(Integer field2) {
        this.field2 = field2;
    }
}

package test;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


/**
 * Fake Repository
 */
@Component
public class FakeRepository {


    public Class<?> getModel() {
        return Fake.class;
    }

    public Fake getById(Integer id) {
        return new Fake("value1", 10);
    }


    public List<Fake> getList() {
        List<Fake> list = new LinkedList<Fake>();

        list.add(new Fake("field1", 1));
        list.add(new Fake("field1", 2));
        list.add(new Fake("field1", 3));


        return list;

    }

    public void delete(Integer id) {
    }

    public void update(Fake e) {

    }

    public void create(Fake e) {

    }


}

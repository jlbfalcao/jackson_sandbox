package test;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


/**
 * Fake Repository
 */
@Component
public class FakeRepository {


    public Fake getById(Integer id) {
        return new Fake("value1", 10);
    }


    public List<Fake> getList() {
        List<Fake> list = new LinkedList<Fake>();

        list.add(new Fake("field1", 55));
        list.add(new Fake("field1", 55));
        list.add(new Fake("field1", 55));


        return list;

    }

}

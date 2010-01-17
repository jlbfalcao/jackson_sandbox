package test;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.naming.Context;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;


/**
 * Main Controller
 */
@Controller
@RequestMapping("/**")
public class SimpleRest {

    @Autowired
    public ApplicationContext context;


    /**
     * Retorna lista de Modelo
     *
     * @param model
     * @param map
     * @return
     */
    @RequestMapping(value = "/{model}", method = RequestMethod.GET)
    public String getList(@PathVariable String model,
                          @RequestParam(value = "length", required = false, defaultValue = "10") Integer len,
                          @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          ModelMap map) {

        System.out.println(model);
        System.out.println("context=" + context);

        try {

            Object o = context.getBean(String.format("%sRepository", model));

            // validar se tem uma determinada anotação
            System.out.println("is_component=" + o.getClass().isAnnotationPresent(Component.class));

            // qual objeto?
            System.out.println("object=" + o.getClass().getName());


            map.addAttribute("list", o.getClass().getMethod("getList").invoke(o));


        } catch (NoSuchBeanDefinitionException ex) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return ""; // 
    }

    /**
     * Retorna uma instancia.
     *
     * @param model
     * @param id
     * @param map
     * @return
     */

    @RequestMapping(value = "/{model}/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable String model, @PathVariable String id, ModelMap map) {

        System.out.println(model);
        System.out.println("context=" + context);

        try {

            Object o = context.getBean(String.format("%sRepository", model));

            // validar se tem uma determinada anotação
            System.out.println("is_component=" + o.getClass().isAnnotationPresent(Component.class));

            // qual objeto?
            System.out.println("object=" + o.getClass().getName());


            map.addAttribute("model", o.getClass().getMethod("getById", Integer.class).invoke(o, Integer.parseInt(id)));


        } catch (NoSuchBeanDefinitionException ex) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return ""; //
    }


    /**
     * Esse exemplo não funcionou, mas a idéia é usar quando um objeto tiver uma lista.
     *
     * > /usuario/1/amigos
     *
     * @param model
     * @param id
     * @param f
     * @param map
     * @return
     */

    @RequestMapping(value = "/{model}/{id}/{f}", method = RequestMethod.GET)
    public String getFieldList(@PathVariable String model, @PathVariable String id, @PathVariable String f, ModelMap map) {

        System.out.println(model);
        System.out.println("context=" + context);

        try {

            Object o = context.getBean(String.format("%sRepository", model));

            // validar se tem uma determinada anotação
            System.out.println("is_component=" + o.getClass().isAnnotationPresent(Component.class));

            // qual objeto?
            System.out.println("object=" + o.getClass().getName());


            Object entity = o.getClass().getMethod("getById", Integer.class).invoke(o, Integer.parseInt(id));

            map.addAttribute(entity.getClass().getMethod(String.format("get%s", f )).invoke(entity));


        } catch (NoSuchBeanDefinitionException ex) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return ""; //
    }


    /**
     * Some put test.
     *
     * @param body
     * @param map
     * @throws IOException
     */
    @RequestMapping(value = "/{model}/{id}", method = RequestMethod.PUT)
    public void handle(@PathVariable String model, @PathVariable String id,
                       @RequestBody String body, ModelMap map) throws IOException {

        System.out.println(model);
        System.out.println("context=" + context);

        try {

            Object o = context.getBean(String.format("%sRepository", model));

            // validar se tem uma determinada anotação
            System.out.println("is_component=" + o.getClass().isAnnotationPresent(Component.class));

            // qual objeto?
            System.out.println("object=" + o.getClass().getName());


            map.addAttribute("model", o.getClass().getMethod("update", Integer.class).invoke(o, Integer.parseInt(id)));


        } catch (NoSuchBeanDefinitionException ex) {

        } catch (InvocationTargetException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NoSuchMethodException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


    }

}

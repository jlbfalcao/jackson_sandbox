package test;

/**
 * Created by IntelliJ IDEA.
 * User: falcao
 * Date: Jan 17, 2010
 * Time: 8:23:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class ExtField {


    public Boolean allowBlank;
//    public conver
    public String mapping;
    public String name;
    public String type;

    public Boolean isAllowBlank() {
        return allowBlank;
    }

    public void setAllowBlank(Boolean allowBlank) {
        this.allowBlank = allowBlank;
    }

    public String getMapping() {
        return mapping;
    }

    public void setMapping(String mapping) {
        this.mapping = mapping;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

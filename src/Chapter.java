import java.io.Serializable;
import java.util.Objects;
/**
 *  Chapter value description
 */

public class Chapter implements Serializable {
        private String name; //Поле не может быть null, Строка не может быть пустой
        private String parentLegion;
    public Chapter(){}
    public  Chapter(String name1,String parentLegion){
        this.name=name1;
        this.parentLegion=parentLegion;
    }


    public String getName(){
        return name;
    }

    public String getParentLegion(){
        return parentLegion;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion);
    }
    }

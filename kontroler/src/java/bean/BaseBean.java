/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

/**
 *
 * @author admin
 */
public abstract class BaseBean {
    public String getJsonRow()  {
        String jsonRow = "{";
        java.lang.reflect.Field[] fields = this.getClass().getDeclaredFields();
        int size = fields.length;
        int i = 0;
        
        for(java.lang.reflect.Field field : fields){
            try{
            jsonRow += "'" + field.getName() + "':'" + field.get(this) + "'";
            if(++i != size) jsonRow += ",";
            }
            catch(Exception e){}
        }
        
        jsonRow += "}";
        return jsonRow;
    }
}

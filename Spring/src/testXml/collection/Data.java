package testXml.collection;

import java.sql.PreparedStatement;
import java.util.*;

public class Data {
    private String[] arrayData;
    private List<String> listDate;
    private Set<String> setData;
    private Map<String, String> mapData;
    private Properties propertiesData;

    public String[] getArrayData() {
        return arrayData;
    }

    public void setArrayData(String[] arrayData) {
        this.arrayData = arrayData;
    }

    public List<String> getListDate() {
        return listDate;
    }

    public void setListDate(List<String> listDate) {
        this.listDate = listDate;
    }

    public Set<String> getSetData() {
        return setData;
    }

    public void setSetData(Set<String> setData) {
        this.setData = setData;
    }

    public Map<String, String> getMapData() {
        return mapData;
    }

    public void setMapData(Map<String, String> mapData) {
        this.mapData = mapData;
    }

    public Properties getPropertiesData() {
        return propertiesData;
    }

    public void setPropertiesData(Properties propertiesData) {
        this.propertiesData = propertiesData;
    }

    @Override
    public String toString() {
        return "Data{" +
                "\narrayData=" + Arrays.toString(arrayData) +
                ", \nlistDate=" + listDate +
                ", \nsetData=" + setData +
                ", \nmapData=" + mapData +
                ", \npropertiesData=" + propertiesData +
                '}';
    }
}

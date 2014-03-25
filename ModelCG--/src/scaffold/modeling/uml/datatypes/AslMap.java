package scaffold.modeling.uml.datatypes;

import scaffold.modeling.uml.basic.UmlDataType;
import scaffold.modeling.uml.basic.UmlPackage;
import scaffold.modeling.uml.basic.UmlType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "test.modeling.uml.datatype")
public class AslMap extends UmlDataType {   
    public static AslMap create(UmlType baseType) {
        AslMap map = (AslMap) UmlType.getTypeByName("Map<" + baseType.getName() + ">");
        
        if (map == null) {
            map = new AslMap(baseType);
            UmlType.registerType(map);
            UmlPackage.getDefaultPackage().addOwnedType(map.getID());        
        }
        
        return map;
    }
    
    private AslMap() {        
    }
    
    private AslMap(UmlType baseType) {
        super("Map<" + baseType.getName() + ">");
        this.baseTypeID = baseType.getID();
    }   

    @Override
    public boolean isMap() { return true; }    
    
    public UmlType getBaseType() {
        return UmlType.getType(this.baseTypeID);
    }
    
    public String baseTypeID;
}

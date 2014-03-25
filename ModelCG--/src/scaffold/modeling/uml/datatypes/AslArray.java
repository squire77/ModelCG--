package scaffold.modeling.uml.datatypes;

import scaffold.modeling.uml.basic.UmlDataType;
import scaffold.modeling.uml.basic.UmlPackage;
import scaffold.modeling.uml.basic.UmlType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "test.modeling.uml.datatype")
public class AslArray extends UmlDataType {
    public static AslArray create(UmlType baseType) {
        AslArray arr = (AslArray) UmlType.getTypeByName("Array[" + baseType.getName() + "]");
        
        if (arr == null) {
            arr = new AslArray(baseType);
            UmlType.registerType(arr);
            UmlPackage.getDefaultPackage().addOwnedType(arr.getID());
        }
        
        return arr;
    }
    
    private AslArray() {        
    }
    
    private AslArray(UmlType baseType) {
        super("Array[" + baseType.getName() + "]");
        this.baseTypeID = baseType.getID();
    }  

    @Override
    public boolean isArray() { return true; }        
    
    public UmlType getBaseType() {
        return UmlType.getType(this.baseTypeID);
    }
    
    public String baseTypeID;
}

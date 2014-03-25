package scaffold.modeling.uml.datatypes;

import scaffold.modeling.uml.basic.UmlPackage;
import scaffold.modeling.uml.basic.UmlPrimitiveType;
import scaffold.modeling.uml.basic.UmlType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "test.modeling.uml.datatype")
public class AslUserDefinedType extends UmlPrimitiveType {
    public static AslUserDefinedType create(String name) {
        AslUserDefinedType ut = new AslUserDefinedType(name);
        UmlType.registerType(ut);
        UmlPackage.getDefaultPackage().addOwnedType(ut.getID());        
        return ut;
    }
    
    private AslUserDefinedType() {        
    }
    
    private AslUserDefinedType(String name) {
        super(name);
    }    
    
    @Override
    public boolean isUserDefinedType() { return true; }    
}

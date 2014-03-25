package scaffold.modeling.uml.datatypes;

import scaffold.modeling.uml.basic.UmlPrimitiveType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "test.modeling.uml.datatype")
public class AslBoolean extends UmlPrimitiveType {
    private AslBoolean() {
        super("boolean");
    }

    @Override
    public boolean isBoolean() { return true; }
        
    public static AslBoolean getInstance() {
        if (_instance == null) {
            _instance = new AslBoolean();
        }
        
        return _instance;
    }

    private static AslBoolean _instance;
}

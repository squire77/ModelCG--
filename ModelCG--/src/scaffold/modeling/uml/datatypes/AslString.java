package scaffold.modeling.uml.datatypes;

import scaffold.modeling.uml.basic.UmlPrimitiveType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "test.modeling.uml.datatype")
public class AslString extends UmlPrimitiveType {
    private AslString() {
        super("string");
    }
    
    @Override
    public boolean isString() { return true; }

    public static AslString getInstance() {
        if (_instance == null) {
            _instance = new AslString();
        }
        
        return _instance;
    }

    private static AslString _instance;
}

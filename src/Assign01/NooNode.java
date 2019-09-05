package Assign01;

import java.util.ArrayList;
import java.util.List;

public class NooNode {

    int degree;

    NooNode parent = null;
    List<NooNode> childs = new ArrayList<NooNode>();

    NooNode(int _degree){
        degree = _degree;
    }

    void AddChild(NooNode _child){
        _child.parent = this;
        childs.add(_child);
    }

    String PrintCstr(){
        switch (degree){
            case 1:
                return childs.get(0).PrintCstr() + "    printf(\"%d\", r);\n";
            case 2:
                return childs.get(0).PrintCstr() + "    t1 = r;\n    r = t1 + 1;\n";
            case 3:
                // base case
                return "    r = 0;\n";
            case 4:
                String res4 = "";
                res4 += childs.get(0).PrintCstr();
                res4 += childs.get(1).PrintCstr();
                return res4;
            case 5:
                String res5 = "";
                res5 += childs.get(0).PrintCstr();
                res5 += "    t1 = r;\n    if(t1 != 0){\n";
                res5 += childs.get(1).PrintCstr();
                res5 += "    }\n    else{\n";
                res5 += childs.get(2).PrintCstr();
                res5 += "    }\n";
                return res5;
            default:
                return "Wrong Degree: " + degree;
        }
    }

}

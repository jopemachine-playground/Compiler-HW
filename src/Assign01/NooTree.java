package Assign01;

import java.util.Arrays;

public class NooTree {

    NooNode root;

    int nodeCount = 0;

    public NooTree(String line){
        String[] nodeArr = line.split("'");

        // 빈 값 제거
        nodeArr = Arrays.stream(nodeArr)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);

        nodeCount = nodeArr.length;
        root = new NooNode(nodeArr[0].length());

        TreeIterator iter = new TreeIterator(root, null, 0);

        // nodeArr의 갯수 만큼 반복하면서 트리를 생성
        for(int nodeArrIndex = 1; nodeArrIndex < nodeArr.length; nodeArrIndex++){
            iter = AddNode(iter, new NooNode(nodeArr[nodeArrIndex].length()));
        }
    }

    TreeIterator AddNode(TreeIterator _iter, NooNode _newNode){
        switch (_iter.iter.degree){
            case 1:
            case 2:
                _iter.iter.AddChild(_newNode);
                _iter.iter = _newNode;
                break;
            case 3:
                _iter.iter.AddChild(_newNode);
                if(_iter.returnNode != null) {
                    _iter.iter = _iter.returnNode;
                    _iter.ChildNum++;
                }
                break;
            case 4:
//                _iter.iter.childs.get(_iter.ChildNum)
//                int cs = _iter.iter.childs.size();
//                _iter.iter.childs.get(cs).AddChild(_newNode);
                 _iter.returnNode = _iter.iter;

                break;
            case 5:
//                _iter.iter.AddChild(_newNode);
                _iter.returnNode = _iter.iter;
                break;
            default:
                break;
        }

        return _iter;
    }

    class TreeIterator {
        NooNode iter;
        NooNode returnNode;
        int ChildNum;

        TreeIterator(NooNode _iter, NooNode _returnNode, int _ChildNum){
            iter =_iter;
            returnNode = _returnNode;
            ChildNum = _ChildNum;
        }
    }

    String ParseToC(){
        return root.PrintCstr();
    }
}

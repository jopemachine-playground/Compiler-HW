package cnu.compiler19.hw1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

        TreeIterator iter = new TreeIterator(root);

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
                if(_iter.retNodeQue.peek() != null) {
                    _iter.retNodeQue.pop().AddChild(_newNode);
                    _iter.iter = _newNode;
                }
                break;
            case 4:
                _iter.iter.AddChild(_newNode);
                _iter.retNodeQue.add(_iter.iter);
                _iter.iter = _newNode;
                break;
            case 5:
                _iter.iter.AddChild(_newNode);
                // 두 번 리턴하므로 두 번 push 한다
                _iter.retNodeQue.add(_iter.iter);
                _iter.retNodeQue.add(_iter.iter);
                _iter.iter = _newNode;
                break;
            default:
                break;
        }

        return _iter;
    }

    class TreeIterator {
        NooNode iter;
        // 중첩된 if문 등의 case를 고려하기 위해서 Map<int, NooNode>의 변수가 필요
        // Depth에 해당하는 돌아갈 노드를 갖고 있다.
        Stack<NooNode> retNodeQue = new Stack<NooNode>();

        TreeIterator(NooNode _iter){
            iter        =       _iter;
        }
    }

    String ParseToC(){
        return root.PrintCstr();
    }
}

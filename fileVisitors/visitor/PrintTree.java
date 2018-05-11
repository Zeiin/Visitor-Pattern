package fileVisitors.visitor;

import fileVisitors.util.NodeTree;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Results;

public class PrintTree implements VisitorI{

    public void visit(NodeTree tree){
            Results res = new Results(tree.outFileName);
            traverse(tree.getRoot(),res);
        }
        
    private void traverse(NodeTree.Node node, Results re){
            if(node.getLeft() != null){
                 traverse(node.getLeft(),re);
            }
            re.writeLine(node.getWord());
            if(node.getRight() != null){
                 traverse(node.getRight(),re);
            }         
        }
    }

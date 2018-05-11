package fileVisitors.visitor;

import fileVisitors.util.NodeTree;
import fileVisitors.util.MyLogger;

public class PalindromeHighlight implements VisitorI{

    public void visit(NodeTree tree){
            traverse(tree.getRoot());
        }
        
    private void traverse(NodeTree.Node node){
        if(node != null) {
            String word = node.getWord();
            String rev = new StringBuilder(word).reverse().toString();
            
            if(word.equals(rev)){
                node.setWord(word.toUpperCase());
            }
            traverse(node.getLeft());
            traverse(node.getRight());
         }
        }
    }

package fileVisitors.visitor;

import fileVisitors.util.NodeTree;
import fileVisitors.util.MyLogger;

public class PrimeLength implements VisitorI{

    public void visit(NodeTree tree){
            traverse(tree.getRoot());
        }
        
    private void traverse(NodeTree.Node node){
        if(node != null) {
            int length = node.getWord().length();
            boolean isPrime = true;
            
            for(int i=2;i<=Math.sqrt(length);i++){
                if(length % i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                String suffix = node.getWord();
                suffix += "-PRIME";
                node.setWord(suffix);
            }
            traverse(node.getLeft());
            traverse(node.getRight());
         }
        }
    }

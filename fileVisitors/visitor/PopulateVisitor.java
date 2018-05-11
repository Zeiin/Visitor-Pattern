package fileVisitors.visitor;

import fileVisitors.util.NodeTree;
import fileVisitors.util.MyLogger;
import fileVisitors.util.FileProcessor;

public class PopulateVisitor implements VisitorI{

    public void visit(NodeTree tree){
        FileProcessor inp = new FileProcessor(tree.inpFileName);
        
        String line = inp.readLine();
        while(line != null) {
            String[] words = line.split(" ");
            for(String i : words) {
                if(i.length() > 0) {
                    tree.addNode(i);
                }
            }
            line = inp.readLine();
        }
    }

}
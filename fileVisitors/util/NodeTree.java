package fileVisitors.util;
//This
import fileVisitors.util.MyLogger;
import fileVisitors.visitor.PopulateVisitor;
import fileVisitors.visitor.PrimeLength;
import fileVisitors.visitor.PalindromeHighlight;
import fileVisitors.visitor.PrintTree;
/**
 * NodeTree is the data structure that will hold all words as nodes
 * and provides means of accessing them in logarithmic time
 */
public class NodeTree {
        /**
         * Node is the object that represents a single word and keeps track
         * of the number of occurrences
         */
        public class Node {
            private String word;
            private volatile int count;
            private Node left;
            private Node right;
            
            /**
             * Sole constructor
             * 
             * @param aWord     the distinct word that will be assigned
             */
            public Node(String aWord) {
                word = aWord;
                count = 0;
                left = null;
                right = null;
                incrementCount();
                String message = "Node constructor called";
                MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
            }
            
            public String getWord() {
                return word;
            }
            
            public int getCount() {
                return count;
            }
            
            public Node getLeft() {
                return left;
            }
            
            public Node getRight() {
                return right;
            }
            
            public void setWord(String aWord){
                word = aWord;
            }
            public void setCount(int newCount) {
                count = newCount;
            }
        
            public void decrementCount() {
                int currentCount = getCount();
                if(currentCount > 0) {
                    setCount(currentCount - 1);
                }
                String message = "Word decremented: " + getWord();
                MyLogger.writeMessage(message, MyLogger.DebugLevel.FROM_RESULTS);
            }
            
            public void incrementCount() {
                int currentCount = getCount();
                setCount(currentCount + 1);
                String message = "Word incremented: " + getWord();
                MyLogger.writeMessage(message, MyLogger.DebugLevel.IN_RESULTS);
            }
            
            public void setLeft(Node newNode) {
                left = newNode;
            }
            
            public void setRight(Node newNode) {
                right = newNode;
            }
        }

    private Node root;
    public String inpFileName;
    public String outFileName;
    
    /**
     * Default constructor
     */
    public NodeTree() {
        root = null;
        String message = "NodeTree constructor called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    public NodeTree(String in, String out){
        root = null;
        inpFileName = in;
        outFileName = out;
        String message = "NodeTree constructor called";
        MyLogger.writeMessage(message, MyLogger.DebugLevel.CONSTRUCTOR);
    }
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node newNode) {
        root = newNode;
    }

    /**
     * Insert function for tree
     * Adds a new node if it does not yet exist,
     * else increments the count of the node with the word
     * 
     * @param key       the word of the new node to be added
     */
    public synchronized void addNode(String key) {
        Node currentNode = getRoot();
        if(currentNode == null) {
            Node newNode = new Node(key);
            setRoot(newNode);
        } else {
            String currentWord = currentNode.getWord();
            while(!currentWord.equals(key)) {
                int compareValue = currentWord.compareTo(key);
                if(compareValue < 0) {
                    Node rightSubtree = currentNode.getRight();
                    if(rightSubtree != null) {
                        currentNode = rightSubtree;
                    } else {
                        Node newNode = new Node(key);
                        currentNode.setRight(newNode);
                        return;
                    }
                } else {
                    Node leftSubtree = currentNode.getLeft();
                    if(leftSubtree != null) {
                        currentNode = leftSubtree;
                    } else {
                        Node newNode = new Node(key);
                        currentNode.setLeft(newNode);
                        return;
                    }
                }
                currentWord = currentNode.getWord();
            }
            currentNode.incrementCount();
        }
    }
    
    /**
     * Search function for tree
     * 
     * @param key       the word of the node to be returned
     * 
     * @return the node with the given key, otherwise null
     */
    public Node findNode(String key) {
        Node currentNode = getRoot();
        while(currentNode != null) {
            String currentWord = currentNode.getWord();
            int compareValue = currentWord.compareTo(key);
            if(compareValue < 0) {
                currentNode = currentNode.getRight();
            } else if(compareValue == 0) {
                return currentNode;
            } else {
                currentNode = currentNode.getLeft();
            }
        }
        return currentNode;
    }
    
    /**
     * Delete function for tree
     * Only decrements the count of a target node if its count 
     * is at least 1
     * 
     * @param key       the word of the node to decrement
     */
    public synchronized void deleteNode(String key) {
        Node targetNode = findNode(key);
        if(targetNode != null) {
            targetNode.decrementCount();
        }
    }
    public void accept(PopulateVisitor v){
        v.visit(this);
    }
    public void accept(PrimeLength v){
        v.visit(this);
    }
    public void accept(PalindromeHighlight v){
        v.visit(this);
    }
    public void accept(PrintTree v){
        v.visit(this);
    }
}


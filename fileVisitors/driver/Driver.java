package fileVisitors.driver;
import java.lang.Integer;
import fileVisitors.util.Results;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;
import fileVisitors.util.NodeTree;
import fileVisitors.visitor.*;
public class Driver 
{
     
	public static void main(String[] args) {
		NodeTree tester = new NodeTree(args[0],args[1]);
		PopulateVisitor pop = new PopulateVisitor();
		PrimeLength prim = new PrimeLength();
		PalindromeHighlight pali = new PalindromeHighlight();
		PrintTree print = new PrintTree();
		tester.accept(pop);
		tester.accept(pali);
		tester.accept(prim);
		tester.accept(print);
	}
}
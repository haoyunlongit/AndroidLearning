import javax.print.DocFlavor;
import java.rmi.UnexpectedException;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        AlgorithmBase base = new RemoveNthFromEnd();
        base.execute();
    }
}

package base;

public abstract class AlgorithmBase {
    protected abstract void doExecute();

    static public class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public void execute() {
        doExecute();
    }
}

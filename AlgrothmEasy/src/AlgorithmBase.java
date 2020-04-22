abstract public class AlgorithmBase {
    abstract void doExecute();

    static  public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void execute() {
        doExecute();
    }
}

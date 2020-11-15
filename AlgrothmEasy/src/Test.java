import com.sun.tools.javac.Main;
import sort.QuickSort;
import sort.SelectSort;
import sort.base.ISort;
import sort.InsertSort;
import sort.ShellSort;
import sort.base.SystemSort;
import tool.SortCompare;

import java.lang.reflect.Proxy;
import java.util.LinkedList;
import java.util.List;


public class Test {
    public static void main(String[] args) {
        Man man = new Man();

        NormalHandler normalHandler = new NormalHandler(man);
        IPerson person = (IPerson)Proxy.newProxyInstance(man.getClass().getClassLoader(), new Class[]{IPerson.class}, normalHandler);
        person.say();

        IPerson tempPerson = (IPerson) Proxy.newProxyInstance(man.getClass().getClassLoader(), new Class[]{IPerson.class}, normalHandler);

        boolean check = false;
        check |= true;
        check |= false;
        System.out.println("~~~");
    }
}

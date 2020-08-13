package com.hyl.hotfix;

public class LoadBugClass {
    public LoadBugClass() {
        System.out.println(com.hyl.hackdex.Antiazyload.class);
    }

    public String getBugString()
    {
        BugClass bugClass = new BugClass();
        new InnerClass();
        return bugClass.doSome();
    }

    static class InnerClass implements temp {

        @Override
        public void test() {

        }
    }

    interface temp {
        void test();
    }
}

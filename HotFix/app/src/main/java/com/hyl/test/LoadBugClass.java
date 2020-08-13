package com.hyl.test;

import com.hyl.hotfix.BugClass;

public class LoadBugClass {
    public String getBugString()
    {
        BugClass bugClass = new BugClass();
        new InnerClass();
        return bugClass.doSome();
    }

    interface temp {
        void test();
    }

    static class InnerClass implements temp {

        @Override
        public void test() {

        }
    }
}

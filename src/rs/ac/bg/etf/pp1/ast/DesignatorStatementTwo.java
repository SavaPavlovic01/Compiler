// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementTwo extends DesignatorStatement {

    private Test Test;

    public DesignatorStatementTwo (Test Test) {
        this.Test=Test;
        if(Test!=null) Test.setParent(this);
    }

    public Test getTest() {
        return Test;
    }

    public void setTest(Test Test) {
        this.Test=Test;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Test!=null) Test.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Test!=null) Test.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Test!=null) Test.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementTwo(\n");

        if(Test!=null)
            buffer.append(Test.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementTwo]");
        return buffer.toString();
    }
}

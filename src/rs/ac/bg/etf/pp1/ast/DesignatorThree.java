// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorThree extends Designator {

    private String I1;
    private DesignatorLoop DesignatorLoop;

    public DesignatorThree (String I1, DesignatorLoop DesignatorLoop) {
        this.I1=I1;
        this.DesignatorLoop=DesignatorLoop;
        if(DesignatorLoop!=null) DesignatorLoop.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public DesignatorLoop getDesignatorLoop() {
        return DesignatorLoop;
    }

    public void setDesignatorLoop(DesignatorLoop DesignatorLoop) {
        this.DesignatorLoop=DesignatorLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorLoop!=null) DesignatorLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorLoop!=null) DesignatorLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorLoop!=null) DesignatorLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorThree(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(DesignatorLoop!=null)
            buffer.append(DesignatorLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorThree]");
        return buffer.toString();
    }
}

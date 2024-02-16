// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclLoopOne extends ConstDeclLoop {

    private ConstDeclLoop ConstDeclLoop;
    private ConstDeclNext ConstDeclNext;

    public ConstDeclLoopOne (ConstDeclLoop ConstDeclLoop, ConstDeclNext ConstDeclNext) {
        this.ConstDeclLoop=ConstDeclLoop;
        if(ConstDeclLoop!=null) ConstDeclLoop.setParent(this);
        this.ConstDeclNext=ConstDeclNext;
        if(ConstDeclNext!=null) ConstDeclNext.setParent(this);
    }

    public ConstDeclLoop getConstDeclLoop() {
        return ConstDeclLoop;
    }

    public void setConstDeclLoop(ConstDeclLoop ConstDeclLoop) {
        this.ConstDeclLoop=ConstDeclLoop;
    }

    public ConstDeclNext getConstDeclNext() {
        return ConstDeclNext;
    }

    public void setConstDeclNext(ConstDeclNext ConstDeclNext) {
        this.ConstDeclNext=ConstDeclNext;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclLoop!=null) ConstDeclLoop.accept(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclLoop!=null) ConstDeclLoop.traverseTopDown(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclLoop!=null) ConstDeclLoop.traverseBottomUp(visitor);
        if(ConstDeclNext!=null) ConstDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclLoopOne(\n");

        if(ConstDeclLoop!=null)
            buffer.append(ConstDeclLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNext!=null)
            buffer.append(ConstDeclNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclLoopOne]");
        return buffer.toString();
    }
}

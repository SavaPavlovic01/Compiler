// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclLoopBoolOne extends ConstDeclLoopBool {

    private ConstDeclLoopBool ConstDeclLoopBool;
    private ConstDeclNextBool ConstDeclNextBool;

    public ConstDeclLoopBoolOne (ConstDeclLoopBool ConstDeclLoopBool, ConstDeclNextBool ConstDeclNextBool) {
        this.ConstDeclLoopBool=ConstDeclLoopBool;
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.setParent(this);
        this.ConstDeclNextBool=ConstDeclNextBool;
        if(ConstDeclNextBool!=null) ConstDeclNextBool.setParent(this);
    }

    public ConstDeclLoopBool getConstDeclLoopBool() {
        return ConstDeclLoopBool;
    }

    public void setConstDeclLoopBool(ConstDeclLoopBool ConstDeclLoopBool) {
        this.ConstDeclLoopBool=ConstDeclLoopBool;
    }

    public ConstDeclNextBool getConstDeclNextBool() {
        return ConstDeclNextBool;
    }

    public void setConstDeclNextBool(ConstDeclNextBool ConstDeclNextBool) {
        this.ConstDeclNextBool=ConstDeclNextBool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.accept(visitor);
        if(ConstDeclNextBool!=null) ConstDeclNextBool.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.traverseTopDown(visitor);
        if(ConstDeclNextBool!=null) ConstDeclNextBool.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.traverseBottomUp(visitor);
        if(ConstDeclNextBool!=null) ConstDeclNextBool.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclLoopBoolOne(\n");

        if(ConstDeclLoopBool!=null)
            buffer.append(ConstDeclLoopBool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNextBool!=null)
            buffer.append(ConstDeclNextBool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclLoopBoolOne]");
        return buffer.toString();
    }
}

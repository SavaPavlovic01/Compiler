// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclLoopNumOne extends ConstDeclLoopNum {

    private ConstDeclLoopNum ConstDeclLoopNum;
    private ConstDeclNextNum ConstDeclNextNum;

    public ConstDeclLoopNumOne (ConstDeclLoopNum ConstDeclLoopNum, ConstDeclNextNum ConstDeclNextNum) {
        this.ConstDeclLoopNum=ConstDeclLoopNum;
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.setParent(this);
        this.ConstDeclNextNum=ConstDeclNextNum;
        if(ConstDeclNextNum!=null) ConstDeclNextNum.setParent(this);
    }

    public ConstDeclLoopNum getConstDeclLoopNum() {
        return ConstDeclLoopNum;
    }

    public void setConstDeclLoopNum(ConstDeclLoopNum ConstDeclLoopNum) {
        this.ConstDeclLoopNum=ConstDeclLoopNum;
    }

    public ConstDeclNextNum getConstDeclNextNum() {
        return ConstDeclNextNum;
    }

    public void setConstDeclNextNum(ConstDeclNextNum ConstDeclNextNum) {
        this.ConstDeclNextNum=ConstDeclNextNum;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.accept(visitor);
        if(ConstDeclNextNum!=null) ConstDeclNextNum.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.traverseTopDown(visitor);
        if(ConstDeclNextNum!=null) ConstDeclNextNum.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.traverseBottomUp(visitor);
        if(ConstDeclNextNum!=null) ConstDeclNextNum.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclLoopNumOne(\n");

        if(ConstDeclLoopNum!=null)
            buffer.append(ConstDeclLoopNum.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNextNum!=null)
            buffer.append(ConstDeclNextNum.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclLoopNumOne]");
        return buffer.toString();
    }
}

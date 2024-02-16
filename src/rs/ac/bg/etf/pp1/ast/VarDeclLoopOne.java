// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class VarDeclLoopOne extends VarDeclLoop {

    private VarDeclLoop VarDeclLoop;
    private VarDeclNext VarDeclNext;

    public VarDeclLoopOne (VarDeclLoop VarDeclLoop, VarDeclNext VarDeclNext) {
        this.VarDeclLoop=VarDeclLoop;
        if(VarDeclLoop!=null) VarDeclLoop.setParent(this);
        this.VarDeclNext=VarDeclNext;
        if(VarDeclNext!=null) VarDeclNext.setParent(this);
    }

    public VarDeclLoop getVarDeclLoop() {
        return VarDeclLoop;
    }

    public void setVarDeclLoop(VarDeclLoop VarDeclLoop) {
        this.VarDeclLoop=VarDeclLoop;
    }

    public VarDeclNext getVarDeclNext() {
        return VarDeclNext;
    }

    public void setVarDeclNext(VarDeclNext VarDeclNext) {
        this.VarDeclNext=VarDeclNext;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclLoop!=null) VarDeclLoop.accept(visitor);
        if(VarDeclNext!=null) VarDeclNext.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclLoop!=null) VarDeclLoop.traverseTopDown(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclLoop!=null) VarDeclLoop.traverseBottomUp(visitor);
        if(VarDeclNext!=null) VarDeclNext.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDeclLoopOne(\n");

        if(VarDeclLoop!=null)
            buffer.append(VarDeclLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclNext!=null)
            buffer.append(VarDeclNext.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDeclLoopOne]");
        return buffer.toString();
    }
}

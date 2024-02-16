// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorLoopTwo extends DesignatorLoop {

    private Expr Expr;
    private DesignatorLoop DesignatorLoop;

    public DesignatorLoopTwo (Expr Expr, DesignatorLoop DesignatorLoop) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.DesignatorLoop=DesignatorLoop;
        if(DesignatorLoop!=null) DesignatorLoop.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
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
        if(Expr!=null) Expr.accept(visitor);
        if(DesignatorLoop!=null) DesignatorLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(DesignatorLoop!=null) DesignatorLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(DesignatorLoop!=null) DesignatorLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorLoopTwo(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorLoop!=null)
            buffer.append(DesignatorLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorLoopTwo]");
        return buffer.toString();
    }
}

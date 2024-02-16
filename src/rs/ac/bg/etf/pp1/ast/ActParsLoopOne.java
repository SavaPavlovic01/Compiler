// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ActParsLoopOne extends ActParsLoop {

    private ActParsLoop ActParsLoop;
    private Expr Expr;

    public ActParsLoopOne (ActParsLoop ActParsLoop, Expr Expr) {
        this.ActParsLoop=ActParsLoop;
        if(ActParsLoop!=null) ActParsLoop.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public ActParsLoop getActParsLoop() {
        return ActParsLoop;
    }

    public void setActParsLoop(ActParsLoop ActParsLoop) {
        this.ActParsLoop=ActParsLoop;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ActParsLoop!=null) ActParsLoop.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActParsLoop!=null) ActParsLoop.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActParsLoop!=null) ActParsLoop.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParsLoopOne(\n");

        if(ActParsLoop!=null)
            buffer.append(ActParsLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParsLoopOne]");
        return buffer.toString();
    }
}

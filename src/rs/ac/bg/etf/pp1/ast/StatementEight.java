// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StatementEight extends Statement {

    private Expr Expr;
    private PrintLoop PrintLoop;

    public StatementEight (Expr Expr, PrintLoop PrintLoop) {
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.PrintLoop=PrintLoop;
        if(PrintLoop!=null) PrintLoop.setParent(this);
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public PrintLoop getPrintLoop() {
        return PrintLoop;
    }

    public void setPrintLoop(PrintLoop PrintLoop) {
        this.PrintLoop=PrintLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Expr!=null) Expr.accept(visitor);
        if(PrintLoop!=null) PrintLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(PrintLoop!=null) PrintLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(PrintLoop!=null) PrintLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementEight(\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(PrintLoop!=null)
            buffer.append(PrintLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementEight]");
        return buffer.toString();
    }
}

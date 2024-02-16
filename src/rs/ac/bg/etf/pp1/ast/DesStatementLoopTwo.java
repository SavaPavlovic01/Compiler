// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class DesStatementLoopTwo extends DesStatementLoop {

    private DesStatementLoop DesStatementLoop;

    public DesStatementLoopTwo (DesStatementLoop DesStatementLoop) {
        this.DesStatementLoop=DesStatementLoop;
        if(DesStatementLoop!=null) DesStatementLoop.setParent(this);
    }

    public DesStatementLoop getDesStatementLoop() {
        return DesStatementLoop;
    }

    public void setDesStatementLoop(DesStatementLoop DesStatementLoop) {
        this.DesStatementLoop=DesStatementLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesStatementLoop!=null) DesStatementLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesStatementLoop!=null) DesStatementLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesStatementLoop!=null) DesStatementLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesStatementLoopTwo(\n");

        if(DesStatementLoop!=null)
            buffer.append(DesStatementLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesStatementLoopTwo]");
        return buffer.toString();
    }
}

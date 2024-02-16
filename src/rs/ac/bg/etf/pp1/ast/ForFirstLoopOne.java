// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ForFirstLoopOne extends ForFirstLoop {

    private DesignatorStatement DesignatorStatement;
    private ForFirstLoop ForFirstLoop;

    public ForFirstLoopOne (DesignatorStatement DesignatorStatement, ForFirstLoop ForFirstLoop) {
        this.DesignatorStatement=DesignatorStatement;
        if(DesignatorStatement!=null) DesignatorStatement.setParent(this);
        this.ForFirstLoop=ForFirstLoop;
        if(ForFirstLoop!=null) ForFirstLoop.setParent(this);
    }

    public DesignatorStatement getDesignatorStatement() {
        return DesignatorStatement;
    }

    public void setDesignatorStatement(DesignatorStatement DesignatorStatement) {
        this.DesignatorStatement=DesignatorStatement;
    }

    public ForFirstLoop getForFirstLoop() {
        return ForFirstLoop;
    }

    public void setForFirstLoop(ForFirstLoop ForFirstLoop) {
        this.ForFirstLoop=ForFirstLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.accept(visitor);
        if(ForFirstLoop!=null) ForFirstLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorStatement!=null) DesignatorStatement.traverseTopDown(visitor);
        if(ForFirstLoop!=null) ForFirstLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorStatement!=null) DesignatorStatement.traverseBottomUp(visitor);
        if(ForFirstLoop!=null) ForFirstLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForFirstLoopOne(\n");

        if(DesignatorStatement!=null)
            buffer.append(DesignatorStatement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForFirstLoop!=null)
            buffer.append(ForFirstLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForFirstLoopOne]");
        return buffer.toString();
    }
}

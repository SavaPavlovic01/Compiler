// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class DesignatorStatementFive extends DesignatorStatement {

    private Help Help;
    private DesStatementLoop DesStatementLoop;
    private Designator Designator;
    private Designator Designator1;

    public DesignatorStatementFive (Help Help, DesStatementLoop DesStatementLoop, Designator Designator, Designator Designator1) {
        this.Help=Help;
        if(Help!=null) Help.setParent(this);
        this.DesStatementLoop=DesStatementLoop;
        if(DesStatementLoop!=null) DesStatementLoop.setParent(this);
        this.Designator=Designator;
        if(Designator!=null) Designator.setParent(this);
        this.Designator1=Designator1;
        if(Designator1!=null) Designator1.setParent(this);
    }

    public Help getHelp() {
        return Help;
    }

    public void setHelp(Help Help) {
        this.Help=Help;
    }

    public DesStatementLoop getDesStatementLoop() {
        return DesStatementLoop;
    }

    public void setDesStatementLoop(DesStatementLoop DesStatementLoop) {
        this.DesStatementLoop=DesStatementLoop;
    }

    public Designator getDesignator() {
        return Designator;
    }

    public void setDesignator(Designator Designator) {
        this.Designator=Designator;
    }

    public Designator getDesignator1() {
        return Designator1;
    }

    public void setDesignator1(Designator Designator1) {
        this.Designator1=Designator1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Help!=null) Help.accept(visitor);
        if(DesStatementLoop!=null) DesStatementLoop.accept(visitor);
        if(Designator!=null) Designator.accept(visitor);
        if(Designator1!=null) Designator1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Help!=null) Help.traverseTopDown(visitor);
        if(DesStatementLoop!=null) DesStatementLoop.traverseTopDown(visitor);
        if(Designator!=null) Designator.traverseTopDown(visitor);
        if(Designator1!=null) Designator1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Help!=null) Help.traverseBottomUp(visitor);
        if(DesStatementLoop!=null) DesStatementLoop.traverseBottomUp(visitor);
        if(Designator!=null) Designator.traverseBottomUp(visitor);
        if(Designator1!=null) Designator1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorStatementFive(\n");

        if(Help!=null)
            buffer.append(Help.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesStatementLoop!=null)
            buffer.append(DesStatementLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator!=null)
            buffer.append(Designator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Designator1!=null)
            buffer.append(Designator1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorStatementFive]");
        return buffer.toString();
    }
}

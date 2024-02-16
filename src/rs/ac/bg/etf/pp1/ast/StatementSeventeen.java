// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StatementSeventeen extends Statement {

    private IfIdent IfIdent;
    private Condition Condition;
    private HelpIf HelpIf;
    private Statement Statement;
    private DummyElse DummyElse;
    private Statement Statement1;

    public StatementSeventeen (IfIdent IfIdent, Condition Condition, HelpIf HelpIf, Statement Statement, DummyElse DummyElse, Statement Statement1) {
        this.IfIdent=IfIdent;
        if(IfIdent!=null) IfIdent.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.HelpIf=HelpIf;
        if(HelpIf!=null) HelpIf.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
        this.DummyElse=DummyElse;
        if(DummyElse!=null) DummyElse.setParent(this);
        this.Statement1=Statement1;
        if(Statement1!=null) Statement1.setParent(this);
    }

    public IfIdent getIfIdent() {
        return IfIdent;
    }

    public void setIfIdent(IfIdent IfIdent) {
        this.IfIdent=IfIdent;
    }

    public Condition getCondition() {
        return Condition;
    }

    public void setCondition(Condition Condition) {
        this.Condition=Condition;
    }

    public HelpIf getHelpIf() {
        return HelpIf;
    }

    public void setHelpIf(HelpIf HelpIf) {
        this.HelpIf=HelpIf;
    }

    public Statement getStatement() {
        return Statement;
    }

    public void setStatement(Statement Statement) {
        this.Statement=Statement;
    }

    public DummyElse getDummyElse() {
        return DummyElse;
    }

    public void setDummyElse(DummyElse DummyElse) {
        this.DummyElse=DummyElse;
    }

    public Statement getStatement1() {
        return Statement1;
    }

    public void setStatement1(Statement Statement1) {
        this.Statement1=Statement1;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfIdent!=null) IfIdent.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(HelpIf!=null) HelpIf.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
        if(DummyElse!=null) DummyElse.accept(visitor);
        if(Statement1!=null) Statement1.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfIdent!=null) IfIdent.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(HelpIf!=null) HelpIf.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
        if(DummyElse!=null) DummyElse.traverseTopDown(visitor);
        if(Statement1!=null) Statement1.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfIdent!=null) IfIdent.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(HelpIf!=null) HelpIf.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        if(DummyElse!=null) DummyElse.traverseBottomUp(visitor);
        if(Statement1!=null) Statement1.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementSeventeen(\n");

        if(IfIdent!=null)
            buffer.append(IfIdent.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Condition!=null)
            buffer.append(Condition.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(HelpIf!=null)
            buffer.append(HelpIf.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DummyElse!=null)
            buffer.append(DummyElse.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement1!=null)
            buffer.append(Statement1.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementSeventeen]");
        return buffer.toString();
    }
}

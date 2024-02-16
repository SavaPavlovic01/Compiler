// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StatementEighteen extends Statement {

    private IfIdent IfIdent;
    private Condition Condition;
    private HelpIf HelpIf;
    private Statement Statement;

    public StatementEighteen (IfIdent IfIdent, Condition Condition, HelpIf HelpIf, Statement Statement) {
        this.IfIdent=IfIdent;
        if(IfIdent!=null) IfIdent.setParent(this);
        this.Condition=Condition;
        if(Condition!=null) Condition.setParent(this);
        this.HelpIf=HelpIf;
        if(HelpIf!=null) HelpIf.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
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

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(IfIdent!=null) IfIdent.accept(visitor);
        if(Condition!=null) Condition.accept(visitor);
        if(HelpIf!=null) HelpIf.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(IfIdent!=null) IfIdent.traverseTopDown(visitor);
        if(Condition!=null) Condition.traverseTopDown(visitor);
        if(HelpIf!=null) HelpIf.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(IfIdent!=null) IfIdent.traverseBottomUp(visitor);
        if(Condition!=null) Condition.traverseBottomUp(visitor);
        if(HelpIf!=null) HelpIf.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementEighteen(\n");

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

        buffer.append(tab);
        buffer.append(") [StatementEighteen]");
        return buffer.toString();
    }
}

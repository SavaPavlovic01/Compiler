// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StatementEleven extends Statement {

    private For For;
    private FirstSemi FirstSemi;
    private SecondSemi SecondSemi;
    private Statement Statement;

    public StatementEleven (For For, FirstSemi FirstSemi, SecondSemi SecondSemi, Statement Statement) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.FirstSemi=FirstSemi;
        if(FirstSemi!=null) FirstSemi.setParent(this);
        this.SecondSemi=SecondSemi;
        if(SecondSemi!=null) SecondSemi.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public FirstSemi getFirstSemi() {
        return FirstSemi;
    }

    public void setFirstSemi(FirstSemi FirstSemi) {
        this.FirstSemi=FirstSemi;
    }

    public SecondSemi getSecondSemi() {
        return SecondSemi;
    }

    public void setSecondSemi(SecondSemi SecondSemi) {
        this.SecondSemi=SecondSemi;
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
        if(For!=null) For.accept(visitor);
        if(FirstSemi!=null) FirstSemi.accept(visitor);
        if(SecondSemi!=null) SecondSemi.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(FirstSemi!=null) FirstSemi.traverseTopDown(visitor);
        if(SecondSemi!=null) SecondSemi.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(FirstSemi!=null) FirstSemi.traverseBottomUp(visitor);
        if(SecondSemi!=null) SecondSemi.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementEleven(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstSemi!=null)
            buffer.append(FirstSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SecondSemi!=null)
            buffer.append(SecondSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementEleven]");
        return buffer.toString();
    }
}

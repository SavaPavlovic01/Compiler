// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StatementTen extends Statement {

    private For For;
    private ForFirst ForFirst;
    private FirstSemi FirstSemi;
    private ForSecond ForSecond;
    private SecondSemi SecondSemi;
    private ForThird ForThird;
    private Statement Statement;

    public StatementTen (For For, ForFirst ForFirst, FirstSemi FirstSemi, ForSecond ForSecond, SecondSemi SecondSemi, ForThird ForThird, Statement Statement) {
        this.For=For;
        if(For!=null) For.setParent(this);
        this.ForFirst=ForFirst;
        if(ForFirst!=null) ForFirst.setParent(this);
        this.FirstSemi=FirstSemi;
        if(FirstSemi!=null) FirstSemi.setParent(this);
        this.ForSecond=ForSecond;
        if(ForSecond!=null) ForSecond.setParent(this);
        this.SecondSemi=SecondSemi;
        if(SecondSemi!=null) SecondSemi.setParent(this);
        this.ForThird=ForThird;
        if(ForThird!=null) ForThird.setParent(this);
        this.Statement=Statement;
        if(Statement!=null) Statement.setParent(this);
    }

    public For getFor() {
        return For;
    }

    public void setFor(For For) {
        this.For=For;
    }

    public ForFirst getForFirst() {
        return ForFirst;
    }

    public void setForFirst(ForFirst ForFirst) {
        this.ForFirst=ForFirst;
    }

    public FirstSemi getFirstSemi() {
        return FirstSemi;
    }

    public void setFirstSemi(FirstSemi FirstSemi) {
        this.FirstSemi=FirstSemi;
    }

    public ForSecond getForSecond() {
        return ForSecond;
    }

    public void setForSecond(ForSecond ForSecond) {
        this.ForSecond=ForSecond;
    }

    public SecondSemi getSecondSemi() {
        return SecondSemi;
    }

    public void setSecondSemi(SecondSemi SecondSemi) {
        this.SecondSemi=SecondSemi;
    }

    public ForThird getForThird() {
        return ForThird;
    }

    public void setForThird(ForThird ForThird) {
        this.ForThird=ForThird;
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
        if(ForFirst!=null) ForFirst.accept(visitor);
        if(FirstSemi!=null) FirstSemi.accept(visitor);
        if(ForSecond!=null) ForSecond.accept(visitor);
        if(SecondSemi!=null) SecondSemi.accept(visitor);
        if(ForThird!=null) ForThird.accept(visitor);
        if(Statement!=null) Statement.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(For!=null) For.traverseTopDown(visitor);
        if(ForFirst!=null) ForFirst.traverseTopDown(visitor);
        if(FirstSemi!=null) FirstSemi.traverseTopDown(visitor);
        if(ForSecond!=null) ForSecond.traverseTopDown(visitor);
        if(SecondSemi!=null) SecondSemi.traverseTopDown(visitor);
        if(ForThird!=null) ForThird.traverseTopDown(visitor);
        if(Statement!=null) Statement.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(For!=null) For.traverseBottomUp(visitor);
        if(ForFirst!=null) ForFirst.traverseBottomUp(visitor);
        if(FirstSemi!=null) FirstSemi.traverseBottomUp(visitor);
        if(ForSecond!=null) ForSecond.traverseBottomUp(visitor);
        if(SecondSemi!=null) SecondSemi.traverseBottomUp(visitor);
        if(ForThird!=null) ForThird.traverseBottomUp(visitor);
        if(Statement!=null) Statement.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementTen(\n");

        if(For!=null)
            buffer.append(For.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForFirst!=null)
            buffer.append(ForFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FirstSemi!=null)
            buffer.append(FirstSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForSecond!=null)
            buffer.append(ForSecond.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SecondSemi!=null)
            buffer.append(SecondSemi.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ForThird!=null)
            buffer.append(ForThird.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Statement!=null)
            buffer.append(Statement.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementTen]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ExprFour extends Expr {

    private Term Term;
    private AddopLoop AddopLoop;

    public ExprFour (Term Term, AddopLoop AddopLoop) {
        this.Term=Term;
        if(Term!=null) Term.setParent(this);
        this.AddopLoop=AddopLoop;
        if(AddopLoop!=null) AddopLoop.setParent(this);
    }

    public Term getTerm() {
        return Term;
    }

    public void setTerm(Term Term) {
        this.Term=Term;
    }

    public AddopLoop getAddopLoop() {
        return AddopLoop;
    }

    public void setAddopLoop(AddopLoop AddopLoop) {
        this.AddopLoop=AddopLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Term!=null) Term.accept(visitor);
        if(AddopLoop!=null) AddopLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Term!=null) Term.traverseTopDown(visitor);
        if(AddopLoop!=null) AddopLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Term!=null) Term.traverseBottomUp(visitor);
        if(AddopLoop!=null) AddopLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprFour(\n");

        if(Term!=null)
            buffer.append(Term.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(AddopLoop!=null)
            buffer.append(AddopLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprFour]");
        return buffer.toString();
    }
}

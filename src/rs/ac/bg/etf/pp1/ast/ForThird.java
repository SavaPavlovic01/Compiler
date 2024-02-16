// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ForThird implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ForFirst ForFirst;

    public ForThird (ForFirst ForFirst) {
        this.ForFirst=ForFirst;
        if(ForFirst!=null) ForFirst.setParent(this);
    }

    public ForFirst getForFirst() {
        return ForFirst;
    }

    public void setForFirst(ForFirst ForFirst) {
        this.ForFirst=ForFirst;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ForFirst!=null) ForFirst.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ForFirst!=null) ForFirst.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ForFirst!=null) ForFirst.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ForThird(\n");

        if(ForFirst!=null)
            buffer.append(ForFirst.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ForThird]");
        return buffer.toString();
    }
}

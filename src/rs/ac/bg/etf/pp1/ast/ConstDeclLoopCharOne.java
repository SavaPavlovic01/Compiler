// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclLoopCharOne extends ConstDeclLoopChar {

    private ConstDeclLoopChar ConstDeclLoopChar;
    private ConstDeclNextChar ConstDeclNextChar;

    public ConstDeclLoopCharOne (ConstDeclLoopChar ConstDeclLoopChar, ConstDeclNextChar ConstDeclNextChar) {
        this.ConstDeclLoopChar=ConstDeclLoopChar;
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.setParent(this);
        this.ConstDeclNextChar=ConstDeclNextChar;
        if(ConstDeclNextChar!=null) ConstDeclNextChar.setParent(this);
    }

    public ConstDeclLoopChar getConstDeclLoopChar() {
        return ConstDeclLoopChar;
    }

    public void setConstDeclLoopChar(ConstDeclLoopChar ConstDeclLoopChar) {
        this.ConstDeclLoopChar=ConstDeclLoopChar;
    }

    public ConstDeclNextChar getConstDeclNextChar() {
        return ConstDeclNextChar;
    }

    public void setConstDeclNextChar(ConstDeclNextChar ConstDeclNextChar) {
        this.ConstDeclNextChar=ConstDeclNextChar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.accept(visitor);
        if(ConstDeclNextChar!=null) ConstDeclNextChar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.traverseTopDown(visitor);
        if(ConstDeclNextChar!=null) ConstDeclNextChar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.traverseBottomUp(visitor);
        if(ConstDeclNextChar!=null) ConstDeclNextChar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclLoopCharOne(\n");

        if(ConstDeclLoopChar!=null)
            buffer.append(ConstDeclLoopChar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclNextChar!=null)
            buffer.append(ConstDeclNextChar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclLoopCharOne]");
        return buffer.toString();
    }
}

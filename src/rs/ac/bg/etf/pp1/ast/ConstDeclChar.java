// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclChar extends ConstDecl {

    private Type Type;
    private String I2;
    private Character C3;
    private ConstDeclLoopChar ConstDeclLoopChar;

    public ConstDeclChar (Type Type, String I2, Character C3, ConstDeclLoopChar ConstDeclLoopChar) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.C3=C3;
        this.ConstDeclLoopChar=ConstDeclLoopChar;
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.setParent(this);
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public String getI2() {
        return I2;
    }

    public void setI2(String I2) {
        this.I2=I2;
    }

    public Character getC3() {
        return C3;
    }

    public void setC3(Character C3) {
        this.C3=C3;
    }

    public ConstDeclLoopChar getConstDeclLoopChar() {
        return ConstDeclLoopChar;
    }

    public void setConstDeclLoopChar(ConstDeclLoopChar ConstDeclLoopChar) {
        this.ConstDeclLoopChar=ConstDeclLoopChar;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclLoopChar!=null) ConstDeclLoopChar.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclChar(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(" "+tab+C3);
        buffer.append("\n");

        if(ConstDeclLoopChar!=null)
            buffer.append(ConstDeclLoopChar.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclChar]");
        return buffer.toString();
    }
}

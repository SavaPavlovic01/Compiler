// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclBool extends ConstDecl {

    private Type Type;
    private String I2;
    private Boolean B3;
    private ConstDeclLoopBool ConstDeclLoopBool;

    public ConstDeclBool (Type Type, String I2, Boolean B3, ConstDeclLoopBool ConstDeclLoopBool) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.B3=B3;
        this.ConstDeclLoopBool=ConstDeclLoopBool;
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.setParent(this);
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

    public Boolean getB3() {
        return B3;
    }

    public void setB3(Boolean B3) {
        this.B3=B3;
    }

    public ConstDeclLoopBool getConstDeclLoopBool() {
        return ConstDeclLoopBool;
    }

    public void setConstDeclLoopBool(ConstDeclLoopBool ConstDeclLoopBool) {
        this.ConstDeclLoopBool=ConstDeclLoopBool;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclLoopBool!=null) ConstDeclLoopBool.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclBool(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(" "+tab+B3);
        buffer.append("\n");

        if(ConstDeclLoopBool!=null)
            buffer.append(ConstDeclLoopBool.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclBool]");
        return buffer.toString();
    }
}

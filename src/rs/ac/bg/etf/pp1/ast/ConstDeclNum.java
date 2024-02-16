// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclNum extends ConstDecl {

    private Type Type;
    private String I2;
    private Integer N3;
    private ConstDeclLoopNum ConstDeclLoopNum;

    public ConstDeclNum (Type Type, String I2, Integer N3, ConstDeclLoopNum ConstDeclLoopNum) {
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.I2=I2;
        this.N3=N3;
        this.ConstDeclLoopNum=ConstDeclLoopNum;
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.setParent(this);
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

    public Integer getN3() {
        return N3;
    }

    public void setN3(Integer N3) {
        this.N3=N3;
    }

    public ConstDeclLoopNum getConstDeclLoopNum() {
        return ConstDeclLoopNum;
    }

    public void setConstDeclLoopNum(ConstDeclLoopNum ConstDeclLoopNum) {
        this.ConstDeclLoopNum=ConstDeclLoopNum;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(Type!=null) Type.accept(visitor);
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(ConstDeclLoopNum!=null) ConstDeclLoopNum.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclNum(\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+I2);
        buffer.append("\n");

        buffer.append(" "+tab+N3);
        buffer.append("\n");

        if(ConstDeclLoopNum!=null)
            buffer.append(ConstDeclLoopNum.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclNum]");
        return buffer.toString();
    }
}

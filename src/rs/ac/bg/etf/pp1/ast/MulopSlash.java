// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class MulopSlash extends Mulop {

    public MulopSlash () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MulopSlash(\n");

        buffer.append(tab);
        buffer.append(") [MulopSlash]");
        return buffer.toString();
    }
}

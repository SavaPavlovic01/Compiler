// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StaticInitListEnd extends StaticInitList {

    private StaticInit StaticInit;

    public StaticInitListEnd (StaticInit StaticInit) {
        this.StaticInit=StaticInit;
        if(StaticInit!=null) StaticInit.setParent(this);
    }

    public StaticInit getStaticInit() {
        return StaticInit;
    }

    public void setStaticInit(StaticInit StaticInit) {
        this.StaticInit=StaticInit;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticInit!=null) StaticInit.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticInit!=null) StaticInit.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticInit!=null) StaticInit.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StaticInitListEnd(\n");

        if(StaticInit!=null)
            buffer.append(StaticInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StaticInitListEnd]");
        return buffer.toString();
    }
}

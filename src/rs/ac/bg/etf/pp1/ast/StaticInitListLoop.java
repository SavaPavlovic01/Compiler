// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class StaticInitListLoop extends StaticInitList {

    private StaticInitList StaticInitList;
    private StaticInit StaticInit;

    public StaticInitListLoop (StaticInitList StaticInitList, StaticInit StaticInit) {
        this.StaticInitList=StaticInitList;
        if(StaticInitList!=null) StaticInitList.setParent(this);
        this.StaticInit=StaticInit;
        if(StaticInit!=null) StaticInit.setParent(this);
    }

    public StaticInitList getStaticInitList() {
        return StaticInitList;
    }

    public void setStaticInitList(StaticInitList StaticInitList) {
        this.StaticInitList=StaticInitList;
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
        if(StaticInitList!=null) StaticInitList.accept(visitor);
        if(StaticInit!=null) StaticInit.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticInitList!=null) StaticInitList.traverseTopDown(visitor);
        if(StaticInit!=null) StaticInit.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticInitList!=null) StaticInitList.traverseBottomUp(visitor);
        if(StaticInit!=null) StaticInit.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StaticInitListLoop(\n");

        if(StaticInitList!=null)
            buffer.append(StaticInitList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StaticInit!=null)
            buffer.append(StaticInit.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StaticInitListLoop]");
        return buffer.toString();
    }
}

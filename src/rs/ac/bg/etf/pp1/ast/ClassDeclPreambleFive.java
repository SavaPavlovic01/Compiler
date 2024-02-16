// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclPreambleFive extends ClassDeclPreamble {

    private StaticInitList StaticInitList;
    private VarDeclList VarDeclList;

    public ClassDeclPreambleFive (StaticInitList StaticInitList, VarDeclList VarDeclList) {
        this.StaticInitList=StaticInitList;
        if(StaticInitList!=null) StaticInitList.setParent(this);
        this.VarDeclList=VarDeclList;
        if(VarDeclList!=null) VarDeclList.setParent(this);
    }

    public StaticInitList getStaticInitList() {
        return StaticInitList;
    }

    public void setStaticInitList(StaticInitList StaticInitList) {
        this.StaticInitList=StaticInitList;
    }

    public VarDeclList getVarDeclList() {
        return VarDeclList;
    }

    public void setVarDeclList(VarDeclList VarDeclList) {
        this.VarDeclList=VarDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(StaticInitList!=null) StaticInitList.accept(visitor);
        if(VarDeclList!=null) VarDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(StaticInitList!=null) StaticInitList.traverseTopDown(visitor);
        if(VarDeclList!=null) VarDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(StaticInitList!=null) StaticInitList.traverseBottomUp(visitor);
        if(VarDeclList!=null) VarDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclPreambleFive(\n");

        if(StaticInitList!=null)
            buffer.append(StaticInitList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclList!=null)
            buffer.append(VarDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclPreambleFive]");
        return buffer.toString();
    }
}

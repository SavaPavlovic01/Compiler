// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ProgramSeven extends Program {

    private ProgName ProgName;
    private DeclLists DeclLists;

    public ProgramSeven (ProgName ProgName, DeclLists DeclLists) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.DeclLists=DeclLists;
        if(DeclLists!=null) DeclLists.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public DeclLists getDeclLists() {
        return DeclLists;
    }

    public void setDeclLists(DeclLists DeclLists) {
        this.DeclLists=DeclLists;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(DeclLists!=null) DeclLists.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(DeclLists!=null) DeclLists.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(DeclLists!=null) DeclLists.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ProgramSeven(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DeclLists!=null)
            buffer.append(DeclLists.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ProgramSeven]");
        return buffer.toString();
    }
}

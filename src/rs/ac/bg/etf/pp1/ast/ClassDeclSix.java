// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class ClassDeclSix extends ClassDecl {

    private String I1;
    private ClassDeclPreamble ClassDeclPreamble;

    public ClassDeclSix (String I1, ClassDeclPreamble ClassDeclPreamble) {
        this.I1=I1;
        this.ClassDeclPreamble=ClassDeclPreamble;
        if(ClassDeclPreamble!=null) ClassDeclPreamble.setParent(this);
    }

    public String getI1() {
        return I1;
    }

    public void setI1(String I1) {
        this.I1=I1;
    }

    public ClassDeclPreamble getClassDeclPreamble() {
        return ClassDeclPreamble;
    }

    public void setClassDeclPreamble(ClassDeclPreamble ClassDeclPreamble) {
        this.ClassDeclPreamble=ClassDeclPreamble;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ClassDeclPreamble!=null) ClassDeclPreamble.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ClassDeclPreamble!=null) ClassDeclPreamble.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ClassDeclPreamble!=null) ClassDeclPreamble.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ClassDeclSix(\n");

        buffer.append(" "+tab+I1);
        buffer.append("\n");

        if(ClassDeclPreamble!=null)
            buffer.append(ClassDeclPreamble.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ClassDeclSix]");
        return buffer.toString();
    }
}

// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class FormParsLoopVar extends FormParsLoop {

    private FormParsLoop FormParsLoop;
    private Type Type;
    private FormParName FormParName;

    public FormParsLoopVar (FormParsLoop FormParsLoop, Type Type, FormParName FormParName) {
        this.FormParsLoop=FormParsLoop;
        if(FormParsLoop!=null) FormParsLoop.setParent(this);
        this.Type=Type;
        if(Type!=null) Type.setParent(this);
        this.FormParName=FormParName;
        if(FormParName!=null) FormParName.setParent(this);
    }

    public FormParsLoop getFormParsLoop() {
        return FormParsLoop;
    }

    public void setFormParsLoop(FormParsLoop FormParsLoop) {
        this.FormParsLoop=FormParsLoop;
    }

    public Type getType() {
        return Type;
    }

    public void setType(Type Type) {
        this.Type=Type;
    }

    public FormParName getFormParName() {
        return FormParName;
    }

    public void setFormParName(FormParName FormParName) {
        this.FormParName=FormParName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FormParsLoop!=null) FormParsLoop.accept(visitor);
        if(Type!=null) Type.accept(visitor);
        if(FormParName!=null) FormParName.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FormParsLoop!=null) FormParsLoop.traverseTopDown(visitor);
        if(Type!=null) Type.traverseTopDown(visitor);
        if(FormParName!=null) FormParName.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FormParsLoop!=null) FormParsLoop.traverseBottomUp(visitor);
        if(Type!=null) Type.traverseBottomUp(visitor);
        if(FormParName!=null) FormParName.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("FormParsLoopVar(\n");

        if(FormParsLoop!=null)
            buffer.append(FormParsLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Type!=null)
            buffer.append(Type.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormParName!=null)
            buffer.append(FormParName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [FormParsLoopVar]");
        return buffer.toString();
    }
}

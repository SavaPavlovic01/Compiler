// generated with ast extension for cup
// version 0.8
// 7/1/2024 1:50:3


package rs.ac.bg.etf.pp1.ast;

public class PrintLoopOne extends PrintLoop {

    private Integer N1;
    private PrintLoop PrintLoop;

    public PrintLoopOne (Integer N1, PrintLoop PrintLoop) {
        this.N1=N1;
        this.PrintLoop=PrintLoop;
        if(PrintLoop!=null) PrintLoop.setParent(this);
    }

    public Integer getN1() {
        return N1;
    }

    public void setN1(Integer N1) {
        this.N1=N1;
    }

    public PrintLoop getPrintLoop() {
        return PrintLoop;
    }

    public void setPrintLoop(PrintLoop PrintLoop) {
        this.PrintLoop=PrintLoop;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(PrintLoop!=null) PrintLoop.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(PrintLoop!=null) PrintLoop.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(PrintLoop!=null) PrintLoop.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("PrintLoopOne(\n");

        buffer.append(" "+tab+N1);
        buffer.append("\n");

        if(PrintLoop!=null)
            buffer.append(PrintLoop.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [PrintLoopOne]");
        return buffer.toString();
    }
}

package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.CondFactOne;
import rs.ac.bg.etf.pp1.ast.CondFactTwo;
import rs.ac.bg.etf.pp1.ast.CondTermLoopOne;
import rs.ac.bg.etf.pp1.ast.CondTermLoopTwo;
import rs.ac.bg.etf.pp1.ast.CondTermOne;
import rs.ac.bg.etf.pp1.ast.ConditionLoopEnd;
import rs.ac.bg.etf.pp1.ast.ConditionLoopOne;
import rs.ac.bg.etf.pp1.ast.ConditionOne;
import rs.ac.bg.etf.pp1.ast.DesStatementLoopOne;
import rs.ac.bg.etf.pp1.ast.DesStatementLoopThree;
import rs.ac.bg.etf.pp1.ast.DesStatementLoopTwo;
import rs.ac.bg.etf.pp1.ast.DesignatorStatementFour;
import rs.ac.bg.etf.pp1.ast.FormParsArr;
import rs.ac.bg.etf.pp1.ast.FormParsLoopArr;
import rs.ac.bg.etf.pp1.ast.FormParsLoopVar;
import rs.ac.bg.etf.pp1.ast.FormParsVar;
import rs.ac.bg.etf.pp1.ast.VarDeclNextOne;
import rs.ac.bg.etf.pp1.ast.VarDeclNextTwo;
import rs.ac.bg.etf.pp1.ast.VarDeclOne;
import rs.ac.bg.etf.pp1.ast.VarDeclTwo;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;

public class CounterVisitor extends VisitorAdaptor {
	protected int count;
	
	public int getCount(){
		return count;
	}
	
	public static class FormParamCounter extends CounterVisitor{
		
		public void visit(FormParsArr formParamDecl){
			count++;
		}
		
		public void visit(FormParsVar form) {
			count++;
		}
		
		public void visit(FormParsLoopArr a) {
			count++;
		}
		
		public void visit(FormParsLoopVar a) {
			count++;
		}
	}
	
	public static class LocalVarCounter extends CounterVisitor{
		
		public void visit(VarDeclOne v) {
			count++;
		}
		
		public void visit(VarDeclTwo v) {
			count++;
		}
		
		public void visit(VarDeclNextOne v) {
			count++;
		}
		
		public void visit(VarDeclNextTwo v) {
			count++;
		}
	}
	
	public static class UnwrapCounter extends CounterVisitor{
		public void visit(DesStatementLoopOne node) {
			count++;
		}
		
		public void visit(DesStatementLoopTwo node) {
			count++;
		}
		
		public void visit(DesStatementLoopThree node) {
			count++;
		}
		
		public void visit(DesignatorStatementFour node) {
			count++;
		}
	}
	
	public static class OrCounter extends CounterVisitor {
		public void visit(ConditionLoopOne node) {
			count++;
		}
		
		public void visit(ConditionLoopEnd node) {
			count++;
		}
		
		public void visit(ConditionOne node) {
			count++;
		}
	}
	
	public static class AndCounter extends CounterVisitor {
		public void visit(CondTermLoopOne node) {
			count++;
		}
		
		public void visit(CondTermLoopTwo node) {
			count++;
		}
		
		public void visit(CondTermOne node) {
			count++;
		}
	}
	
	public static class ExprCounter extends CounterVisitor {
		public void visit(CondFactOne node) {
			count++;
		}
		public void visit(CondFactTwo node) {
			count++;
		}
	}
}

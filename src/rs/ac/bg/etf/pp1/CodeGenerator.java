package rs.ac.bg.etf.pp1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

import org.apache.log4j.Logger;

import rs.ac.bg.etf.pp1.CounterVisitor.AndCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.ExprCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.FormParamCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.LocalVarCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.OrCounter;
import rs.ac.bg.etf.pp1.CounterVisitor.UnwrapCounter;
import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class CodeGenerator extends VisitorAdaptor {

	public int mainPc;
	public boolean in_namespace = false;
	public String namespace_name = "";
	public Struct last_seen_type = null;
	public boolean in_func = false;
	public String func_name = "";
	public int cur_unwrap_cnt = 0;
	public ArrayList<Obj> list = new ArrayList<Obj>();
	public Stack<Integer> ifs_to_patch = new Stack<Integer>();
	
	public Stack<Integer> or_to_patch = new Stack<Integer>();
	public Stack<Integer> and_to_patch = new Stack<Integer>();
	public Stack<Integer> or_end_patch = new Stack<Integer>();
	public Stack<Integer> jump_over_else = new Stack<Integer>();
	Logger log = Logger.getLogger(getClass());
	
	int cur_or_cnt = 0;
	int cur_and_cnt = 0;
	int or_loaded = 0;
	int expr_cnt = 0;
	int loaded = 0;
	
	public Stack<Stack<Integer>> or_stacks = new Stack<Stack<Integer>>();
	public Stack<Stack<Integer>> or_end_stacks = new Stack<Stack<Integer>>();
	public Stack<Stack<Integer>> and_stacks = new Stack<Stack<Integer>>();
	public Stack<Stack<Integer>> if_stacks = new Stack<Stack<Integer>>();
	
	boolean dump_code = true;
	
	
	public void visit(MethodName name) {
		if(name.getI1().equals("main")) {
			mainPc = Code.pc;
		}
		String curName = name.getI1();
		if(in_namespace) curName = namespace_name + "::" + curName;
		
		name.obj = Tab.insert(Obj.Meth, curName, last_seen_type);
		name.obj.setAdr(Code.pc);
		FormParamCounter fpc = new FormParamCounter();
		LocalVarCounter lvc = new LocalVarCounter();
		
		SyntaxNode parent = name.getParent();
		parent.traverseTopDown(fpc);
		parent.traverseTopDown(lvc);
		Code.put(Code.enter);
		Code.put(fpc.count);
		Code.put(fpc.count+lvc.count);
		in_func = true;
		func_name = name.getI1();
	}
	
	public void visit(MethodDeclOne decl) {
		Code.put(Code.trap);
		Code.put(1);
		in_func = false;
	}
	
	
	
	public void visit(MethodDeclTwo decl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
		in_func = false;
	}
	
	public void visit(MethodDeclThree decl) {
		Code.put(Code.trap);
		Code.put(1);
		in_func = false;
	}
	
	public void visit(MethodDeclFour decl) {
		Code.put(Code.exit);
		Code.put(Code.return_);
		in_func = false;
	}
	
	public void visit(FactorNum num) {
		if(!dump_code) return;
		Code.loadConst(num.getN1());
		num.struct = Tab.intType;
	}
	
	public void visit(FactorChar chr) {
		if(!dump_code) return;
		Code.loadConst(chr.getC1());
		chr.struct = Tab.charType;
	}
	
	public void visit(FactorBool b) {
		if(!dump_code) return;
		if(!b.getB1()) {
			Code.loadConst(0);
		}else {
			Code.loadConst(1);
		}
		b.struct = ExtendedTab.boolType;
	}
	
	public void visit(FactorParen node) {
		// idk
		node.struct = node.getExpr().struct;
	}
	
	public void visit(FactorNewArr node) {
		if(!dump_code) return;
		Code.put(Code.newarray);
		if(last_seen_type == Tab.charType || last_seen_type == ExtendedTab.boolType) {
			Code.put(0);
		}else {
			Code.put(1);
		}
		
		node.struct = new Struct(Struct.Array, last_seen_type);
	}
	
	public void visit(FactorNewConstructor a) {
		// nece
	}
	
	public void visit(FactorNewConstructorArgs a) {
		// nece
	}
	
	public void visit(ProgName node) {
		Tab.dump();
	}
	
	public void visit(FactorTest node) {
		node.struct = node.getTest().struct;
	}
	boolean doing_args = false;
	public void visit(FactorDesignator node) {
		if(!dump_code) return;
		if(node.getDesignator().obj.getType().getKind() == Struct.Array) {
			if(doing_args && !node.getDesignator().obj.getName().equals("sava")) {
				Code.load(node.getDesignator().obj);
				return;
			}
			if(node.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.baload);
			}else {
				Code.put(Code.aload);
			}
			node.struct = node.getDesignator().obj.getType().getElemType();
		}else {
			Code.load(node.getDesignator().obj);
			node.struct = node.getDesignator().obj.getType();
		}
		
		log.info(node.getDesignator().obj.getName() + node.getDesignator().obj.getAdr());
		
	}
	
	public void visit(TypeVar node) {
		Obj cur = Tab.find(node.getI1());
		last_seen_type = cur.getType();
	}
	
	public void visit(TypeNamespace node) {
		// msm da nece nikad
	}
	
	public void visit(DesignatorOne node) {
		// todo: implement
		Obj cur = Tab.find(node.getI1() + "::" + node.getI2());
		if(cur == Tab.noObj) {
			cur = node.obj;
		}
		//node.obj = cur;
		//log.info("HAHAH" + node.obj.getName());
		//node.obj.getType().ki
		Obj temp = node.obj;
		node.obj = new Obj(Obj.Var, "sava",new Struct(Struct.Array,temp.getType()));
		node.obj.setAdr(temp.getAdr());
		node.obj.setLevel(temp.getLevel());
		Code.load(temp);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		/*
		if(cur.getType().getKind() == Struct.Char)
			Code.put(Code.baload);
		else 
			Code.put(Code.aload);
		*/
	}
	
	public void visit(DesignatorTwo des) {
		
		Obj cur = Tab.find(des.getI1() + "::" + des.getI2());
		if(cur == Tab.noObj) {
			cur = des.obj;
		}
		if(des.obj.getKind() == Obj.Con) {
			des.obj = Tab.find(des.getI1() + "::" + des.getI2());
		}
		if(des.obj.getKind() == Obj.Meth) {
			des.obj = Tab.find(des.getI1() + "::" + des.getI2());
		}
		//des.obj = cur;
		//Code.load(des.obj);
	}
	
	public void visit(DesignatorThree node) {
		Obj cur = Tab.find(node.getI1());
		if(cur == Tab.noObj && in_namespace) {
			cur = Tab.find(node.obj.getName());
		}
		if(cur == Tab.noObj) {
			cur = node.obj;
		}
		//node.obj = cur;
		//log.info(cur.getAdr());
		Obj temp = node.obj;
		node.obj = new Obj(Obj.Var, "sava",new Struct(Struct.Array,temp.getType()));
		node.obj.setAdr(temp.getAdr());
		node.obj.setLevel(temp.getLevel());
		Code.load(temp);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		/*
		if(cur.getType().getKind() == Struct.Char)
			Code.put(Code.baload);
		else 
			Code.put(Code.aload);
		*/
	}
	
	public void visit(DesignatorFour des) {
		/*
		log.info(des.obj.getName());
		Obj cur = Tab.find(des.getI1());
		if(cur == Tab.noObj && in_namespace) {
			cur = Tab.find(namespace_name + "::" + des.getI1());
		}
		//log.info(cur.getName() + cur.getAdr());
		if(cur != Tab.noObj) {
			des.obj = cur;
		}*/
		if(des.obj.getKind() == Obj.Con ) {
			des.obj = Tab.find(des.obj.getName());
		}
		if(des.obj.getKind() == Obj.Meth) {
			des.obj = Tab.find(des.getI1());
			if (des.obj == Tab.noObj && in_namespace) {
				des.obj = Tab.find(namespace_name + "::" + des.getI1());
			}
		}
		//Code.load(des.obj);
	}
	
	public void visit(ExprOne node) {
		//Code.put(Code.neg);
		node.struct = node.getTerm().struct;
	}
	
	public void visit(ExprFour node) {
		node.struct = node.getTerm().struct;
	}
	
	public void visit(AddopLoopOne node) {
		if(!dump_code) return;
		if(node.getAddop() instanceof AddopPlus) {
			Code.put(Code.add);
		}else {
			Code.put(Code.sub);
		}
	}
	
	public void visit(TermOne node) {
		if(!dump_code) return;
		node.struct = node.getFactor().struct;
		if(node.getMulop() instanceof MulopStar) {
			Code.put(Code.mul);
		} else if(node.getMulop() instanceof MulopSlash) {
			Code.put(Code.div);
		}else {
			Code.put(Code.rem);
		}
		
		if(node.getParent() instanceof ExprOne)
			Code.put(Code.sub);
	}
	
	public void visit(TermTwo node) {
		if(!dump_code) return;
		node.struct = node.getFactor().struct;
		if(node.getParent() instanceof ExprOne)
			Code.put(Code.sub);
	}
	
	public void visit(MulopLoopOne node) {
		if(!dump_code) return;
		if(node.getMulop() instanceof MulopStar) {
			Code.put(Code.mul);
		} else if(node.getMulop() instanceof MulopSlash) {
			Code.put(Code.div);
		}else {
			Code.put(Code.rem);
		}
	}
	
	public void visit(MulopLoopEnd node) {
		// nista
	}
	
	public void visit(Min node) {
		if(!dump_code) return;
		if(node.getParent() instanceof ExprOne) {
			Code.loadConst(0);
		}
	}
	
	public void visit(StatementEight node) {
		if(node.getExpr().struct == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
	}
	
	public void visit(StatementNine node) {
		if(node.getExpr().struct == Tab.intType) {
			Code.loadConst(5);
			Code.put(Code.print);
		}else {
			Code.loadConst(1);
			Code.put(Code.bprint);
		}
		
	}
	
	public void visit(ConstDeclNum node) {
		String curName = node.getI2();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, Tab.intType);
		obj.setLevel(0);
		obj.setAdr(node.getN3());
		//Code.load(obj);
		//Code.load(obj);
	}
	
	public void visit(ConstDeclChar node) {
		String curName = node.getI2();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, Tab.charType);
		obj.setLevel(0);
		obj.setAdr(node.getC3());
		//Code.load(obj);
	}
	
	public void visit(ConstDeclBool node) {
		String curName = node.getI2();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, ExtendedTab.boolType);
		obj.setLevel(0);
		if(node.getB3()) {
			obj.setAdr(0);
		}else {
			obj.setAdr(1);
		}
		//Code.load(obj);
	}
	
	public void visit(ConstDeclNextNum node) {
		String curName = node.getI1();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, Tab.intType);
		obj.setLevel(0);
		obj.setAdr(node.getN2());
		//Code.load(obj);
	}
	
	public void visit(ConstDeclNextChar node) {
		String curName = node.getI1();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, Tab.charType);
		obj.setLevel(0);
		obj.setAdr(node.getC2());
		//Code.load(obj);
	}
	
	public void visit(ConstDeclNextBool node) {
		String curName = node.getI1();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Con, curName, ExtendedTab.boolType);
		obj.setLevel(0);
		if(node.getB2()) {
			obj.setAdr(0);
		}else {
			obj.setAdr(1);
		}
		//Code.load(obj);
		
	}
	
	public void visit(VarDeclOne node) {
		String curName = node.getI2();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Var, curName, new Struct(Struct.Array, last_seen_type));
		//Code.load(obj);
	}
	
	public void visit(VarDeclTwo node) {
		String curName = node.getI2();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Var, curName, last_seen_type);
		//Code.load(obj);
	}
	
	public void visit(VarDeclNextOne node) {
		String curName = node.getI1();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Var, curName, new Struct(Struct.Array, last_seen_type));
	}
	
	public void visit(VarDeclNextTwo node) {
		String curName = node.getI1();
		if (in_namespace) curName = namespace_name + "::" + curName;
		Obj obj = Tab.insert(Obj.Var, curName, last_seen_type);
		//Code.load(obj);
	}
	
	public void visit(DesignatorStatementOne node) {
		if(!dump_code) return;
		if(node.getExpr().struct.getKind() == Struct.Array) {
			Code.store(node.getDesignator().obj);
			return;
		}
		if(node.getDesignator().obj.getType().getKind() != Struct.Array) {
			Code.store(node.getDesignator().obj);
		}else {
			if((node.getDesignator().obj.getType().getElemType() == Tab.charType)) {
				Code.put(Code.bastore);
			}else {
				Code.put(Code.astore);
			}
		}
			
	}
	
	public void visit(TestOne node) {
		doing_args = false;
		if(node.getDesignator().obj.getName().equals("ord")) {
			return;
		}
		if(node.getDesignator().obj.getName().equals("chr")) {
			Code.loadConst(48);
			Code.put(Code.add);
			return;
		}
		if(node.getDesignator().obj.getName().equals("len")) {
			//Code.load(node.getDesignator().obj);
			Code.put(Code.arraylength);
			return;
		}
		Code.put(Code.call);
		
		Code.put2(node.getDesignator().obj.getAdr() - Code.pc + 1);
	}
	
	public void visit(TestTwo node) {
		Code.put(Code.call);
		
		Code.put2(node.getDesignator().obj.getAdr() - Code.pc + 1);
	}
	
	public void visit(Help node) {
		SyntaxNode parent = node.getParent();
		
		UnwrapCounter uc = new UnwrapCounter();
		parent.traverseTopDown(uc);
		cur_unwrap_cnt=uc.count;
		log.info(cur_unwrap_cnt +"GLEDAJ ME");
	}
	
	public void visit(DesStatementLoopOne node) {
		list.add(node.getDesignator().obj);
	}
	
	public void visit(DesStatementLoopTwo node) {
		list.add(new Obj(Obj.NO_VALUE,"",Tab.intType));
	}
	
	public void visit(DesStatementLoopThree node) {
		list.add(node.getDesignator().obj);
	}
	
	public void visit(DesStatementLoopFour node) {
		list.add(new Obj(Obj.NO_VALUE,"",Tab.intType));
	}
	
	private void unwrap(Obj des1, Obj des2, int size) {
		
		Code.loadConst(0);
		Code.put(Code.dup);
		Code.loadConst(size);
		Code.put(Code.dup);
		//
		Code.load(des2);
		Code.put(Code.arraylength);
		Code.loadConst(size);
		Code.put(Code.jcc + Code.eq);
		int aaa = Code.pc;
		Code.put2(0);
		//
		int loopAdr = Code.pc;
		Code.load(des2);
		Code.put(Code.arraylength);
		Code.put(Code.jcc + Code.eq);
		
		int fixAdr = Code.pc;
		Code.put2(0);
		Code.fixup(aaa);
		Code.load(des2);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.dup_x1);
		if(des1.getType().getElemType() == Tab.charType) {
			Code.put(Code.baload);
		}else {
			Code.put(Code.aload);
		}
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		Code.load(des1);
		Code.put(Code.dup_x2);
		Code.put(Code.pop);
		if(des1.getType().getElemType() == Tab.charType) {
			Code.put(Code.bastore);
		}else {
			Code.put(Code.astore);
		}
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.const_1);
		Code.put(Code.add);
		Code.put(Code.dup_x1);
		Code.put(Code.dup_x1);
		Code.put(Code.pop);
		Code.put(Code.dup);
		Code.putJump(loopAdr);
		Code.fixup(fixAdr);
		Code.put(Code.pop);
		Code.put(Code.pop);
		Code.put(Code.pop);
	}
	
	public void visit(DesignatorStatementFive node) {
		if(!dump_code) return;
		int temp = list.size();
		for(Obj curObj:list) {
			if(curObj.getKind() == Obj.NO_VALUE) {
				temp--;
				continue;
			}
			Code.load(node.getDesignator1().obj);
			Code.loadConst(--temp);
			if(node.getDesignator1().obj.getType().getElemType() == Tab.charType) 
				Code.put(Code.baload);
			else 
				Code.put(Code.aload);
			if(curObj.getType().getKind() == Struct.Array) {
				if(curObj.getType().getElemType() == Tab.charType) {
					Code.put(Code.bastore);
				}else Code.put(Code.astore);
			}else Code.store(curObj);
		}
		
		unwrap(node.getDesignator().obj,node.getDesignator1().obj,list.size());
		list.clear();
	}
	
	public void visit(DesignatorStatementSix node) {
		if(!dump_code) return;
		unwrap(node.getDesignator().obj,node.getDesignator1().obj,0);
		list.clear();
	}
	
	public void visit(CondFactOne node) {
		SyntaxNode curNode = node;
		while(!(curNode instanceof Statement)) {
			if(curNode instanceof CondTermLoop || curNode instanceof CondTermOne) {
				Code.loadConst(0);
				//and_to_patch.add(Code.pc);
				and_stacks.peek().add(Code.pc);
				Code.put(Code.jcc + Code.eq);
				Code.put2(0);
				loaded++;
				return;
			}
			if(curNode instanceof ConditionLoop || curNode instanceof ConditionOne) {
				//and_to_patch.size()>0
				if(and_stacks.peek().size()>0) {
					int i = and_stacks.peek().size();
					int cnt = 0;
					while(cnt < i ) {
						int temp = Code.pc;
						Code.pc = Code.pc - 2;
						Code.fixup(and_stacks.peek().pop()+1);
						Code.pc = temp;
						cnt++;
					}
				}
				int temp = or_loaded + 1;
				int temp1 = cur_or_cnt + 1;
				log.info(or_loaded + " TU SAM " + cur_or_cnt);
				
				Code.loadConst(1);
				//or_to_patch.add(Code.pc);
				or_stacks.peek().add(Code.pc);
				Code.put(Code.jcc + Code.eq);
				Code.put2(0);
				++loaded;
				if(loaded==expr_cnt) {
					//or_end_patch.add(Code.pc);
					or_end_stacks.peek().add(Code.pc);
					Code.putJump(0);
				}
				return;
			}
			curNode= curNode.getParent();
		}
		
		Code.loadConst(1);
		//ifs_to_patch.add(Code.pc);
		if_stacks.peek().add(Code.pc);
		Code.putFalseJump(Code.eq, 0);
	}
	
	private void put_cond_jmp(Relop node) {
		if(node instanceof RelopComp) {
			Code.putFalseJump(Code.eq, 0);
		}
		if(node instanceof RelopNotEq) {
			Code.put(Code.jcc + Code.eq);
			Code.put2(0);
		}
		if(node instanceof RelopBigger) {
			Code.put(Code.jcc + Code.le);
			Code.put2(0);
		}
		if(node instanceof RelopSmaller) {
			Code.put(Code.jcc + Code.ge);
			Code.put2(0);
		}
		if(node instanceof RelopBeq) {
			Code.put(Code.jcc + Code.lt);
			Code.put2(0);
		}
		if(node instanceof RelopLeq) {
			Code.put(Code.jcc + Code.gt);
			Code.put2(0);
		}
	}
	
	private void put_cond_jmp_reverse(Relop node) {
		if(node instanceof RelopComp) {
			Code.put(Code.jcc + Code.eq);
			Code.put2(0);
		}
		if(node instanceof RelopNotEq) {
			Code.put(Code.jcc + Code.ne);
			Code.put2(0);
		}
		if(node instanceof RelopBigger) {
			Code.put(Code.jcc + Code.gt);
			Code.put2(0);
		}
		if(node instanceof RelopSmaller) {
			Code.put(Code.jcc + Code.lt);
			Code.put2(0);
		}
		if(node instanceof RelopBeq) {
			Code.put(Code.jcc + Code.ge);
			Code.put2(0);
		}
		if(node instanceof RelopLeq) {
			Code.put(Code.jcc + Code.le);
			Code.put2(0);
		}
	}
	
	public void visit(CondFactTwo node) {
		Code.put(Code.sub);
		SyntaxNode curNode = node;
		if(node.getParent() instanceof ForSecond) {
			Code.loadConst(0);
			//ifs_to_patch.add(Code.pc);
			if_stacks.peek().add(Code.pc);
			put_cond_jmp(node.getRelop());
			return;
		}
		while(!(curNode instanceof Statement)) {
			if(curNode instanceof CondTermLoop || curNode instanceof CondTermOne) {
				Code.loadConst(0);
				//and_to_patch.add(Code.pc);
				and_stacks.peek().add(Code.pc);
				put_cond_jmp(node.getRelop());
				loaded++;
				return;
			}
			if(curNode instanceof ConditionLoop || curNode instanceof ConditionOne) {
				//and_to_patch.size()>0
				if(and_stacks.peek().size()>0) {
					//int i = and_to_patch.size();
					int i = and_stacks.peek().size();
					int cnt = 0;
					while(cnt < i ) {
						int temp = Code.pc;
						Code.pc = Code.pc - 5;
						//Code.fixup(and_to_patch.pop()+1);
						Code.fixup(and_stacks.peek().pop()+1);
						Code.pc = temp;
						cnt++;
					}
				}
				int temp = or_loaded + 1;
				int temp1 = cur_or_cnt + 1;
				log.info(loaded + " TU SAM " + expr_cnt);
				
				Code.loadConst(0);
				//or_to_patch.add(Code.pc);
				or_stacks.peek().add(Code.pc);
				put_cond_jmp_reverse(node.getRelop());
				++loaded;
				if(loaded==expr_cnt) {
					//or_end_patch.add(Code.pc);
					or_end_stacks.peek().add(Code.pc);
					Code.putJump(0);
				}
				return;
			}
			curNode= curNode.getParent();
		}
		
		Code.loadConst(0);
		//ifs_to_patch.add(Code.pc);
		if_stacks.peek().add(Code.pc);
		put_cond_jmp(node.getRelop());
		
	}
	
	public void visit(StatementSeventeen node) {
		if(jump_over_else.size()>0) {
			Code.fixup(jump_over_else.pop()+1);
		}
	}
	
	public void visit(StatementEighteen node) {
		int i = and_stacks.peek().size();
		int cnt = 0;
		while(cnt < i ) {
			Code.fixup(and_stacks.peek().pop()+1);
			cnt++;
		}
		and_stacks.pop();
		i = if_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(if_stacks.peek().pop()+1);
			cnt++;
		}
		if_stacks.pop();
		i = or_end_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(or_end_stacks.peek().pop()+1);
			cnt++;
		}
		
		or_end_stacks.pop();
		or_loaded = 0;
		cur_and_cnt = 0;
		cur_or_cnt = 0;
		loaded = 0;
		
	}
	
	public void visit(HelpIf node) {
		
		int i = or_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(or_stacks.peek().pop()+1);
			cnt++;
		}
		or_stacks.pop();
	}
	
	public void visit(IfIdent node) {
		AndCounter andC = new AndCounter();
		OrCounter orC = new OrCounter();
		ExprCounter exprC = new ExprCounter();
		node.getParent().traverseTopDown(andC);
		node.getParent().traverseTopDown(orC);
		node.getParent().traverseTopDown(exprC);
		cur_or_cnt = orC.getCount();
		cur_and_cnt = andC.getCount();
		expr_cnt = exprC.getCount();
		
		log.info(cur_or_cnt + "OVDE");
		log.info(cur_and_cnt + "OVDE");
		if_stacks.add(new Stack<Integer>());
		or_stacks.add(new Stack<Integer>());
		and_stacks.add(new Stack<Integer>());
		or_end_stacks.add(new Stack<Integer>());
	}
	
	public void visit(DummyElse node) {
		if(or_end_stacks.peek().size()>0) {
			int temp = Code.pc;
			Code.pc = Code.pc +3;
			Code.fixup(or_end_stacks.peek().pop()+1);
			Code.pc = temp;
		}
		or_end_stacks.pop();
		int temp = and_stacks.peek().size();
		int cnt = 0;
		while(cnt < temp) {
			int temp1 = Code.pc;
			Code.pc = Code.pc +3;
			Code.fixup(and_stacks.peek().pop()+1);
			Code.pc = temp1;
			cnt++;
		}
		and_stacks.pop();
		int i = if_stacks.peek().size();
		cnt = 0;
		while(cnt < i ) {
			int temp1 = Code.pc;
			Code.pc += 3; 
			Code.fixup(if_stacks.peek().pop()+1);
			Code.pc = temp1;
			cnt++;
		}
		if_stacks.pop();
		jump_over_else.add(Code.pc);
		Code.putJump(0);
	}
	
	public void visit(NamespaceName node) {
		in_namespace = true;
		namespace_name = node.getI1();
	}
	
	public void visit(NamespaceOne node) {
		in_namespace = false;
	}
	
	public void visit(NamespaceTwo node) {
		in_namespace = false;
	}
	
	public void visit(NamespaceThree node) {
		in_namespace = false;
	}
	
	public void visit(NamespaceFour node) {
		in_namespace = false;
	}
	
	public Stack<Integer> for_loopback_addr = new Stack<Integer>();
	
	public void visit(For node) {
		or_end_stacks.add(new Stack<Integer>());
		or_stacks.add(new Stack<Integer>());
		and_stacks.add(new Stack<Integer>());
		if_stacks.add(new Stack<Integer>());
		continue_stack.add(new Stack<Integer>());
		break_stack.add(new Stack<Integer>());
	}
	
	public void visit(FirstSemi node) {
		for_loopback_addr.add(Code.pc);
	}
	
	public void visit(SecondSemi node) {
		SyntaxNode parent = node.getParent();
		if(parent instanceof StatementTen || parent instanceof StatementThirteen || parent instanceof StatementFourteen) dump_code = false;
		int i = or_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(or_stacks.peek().pop()+1);
			cnt++;
		}
		or_stacks.pop();
	}
	
	public void visit(StatementTen node) {
		dump_code = true;
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		node.getForThird().traverseBottomUp(this);
		Code.putJump(for_loopback_addr.pop());
		int i = if_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(if_stacks.peek().pop()+1);
			cnt++;
		}
		if_stacks.pop();
		i = and_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(and_stacks.peek().pop());
			cnt++;
		}
		and_stacks.pop();
		i = or_end_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(or_end_stacks.peek().pop());
			cnt++;
		}
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementEleven node) {
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		Code.putJump(for_loopback_addr.pop());
		if_stacks.pop();
		and_stacks.pop();
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementTwelve node) {
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		Code.putJump(for_loopback_addr.pop());
		int i = if_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(if_stacks.peek().pop()+1);
			cnt++;
		}
		if_stacks.pop();
		i = and_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(and_stacks.peek().pop());
			cnt++;
		}
		and_stacks.pop();
		i = or_end_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(or_end_stacks.peek().pop());
			cnt++;
		}
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementThirteen node) {
		dump_code = true;
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		node.getForThird().traverseBottomUp(this);
		Code.putJump(for_loopback_addr.pop());
		if_stacks.pop();
		and_stacks.pop();
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementFourteen node) {
		dump_code = true;
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		node.getForThird().traverseBottomUp(this);
		Code.putJump(for_loopback_addr.pop());
		int i = if_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(if_stacks.peek().pop()+1);
			cnt++;
		}
		if_stacks.pop();
		i = and_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(and_stacks.peek().pop());
			cnt++;
		}
		and_stacks.pop();
		i = or_end_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(or_end_stacks.peek().pop());
			cnt++;
		}
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementFifteen node) {
		dump_code = true;
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		Code.putJump(for_loopback_addr.pop());
		int i = if_stacks.peek().size();
		int cnt = 0;
		while(cnt < i) {
			Code.fixup(if_stacks.peek().pop()+1);
			cnt++;
		}
		if_stacks.pop();
		i = and_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(and_stacks.peek().pop());
			cnt++;
		}
		and_stacks.pop();
		i = or_end_stacks.peek().size();
		cnt = 0;
		while(cnt < i) {
			Code.fixup(or_end_stacks.peek().pop());
			cnt++;
		}
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(StatementSixteen node) {
		Stack<Integer> cur = continue_stack.pop();
		for(int curAdr:cur) {
			Code.fixup(curAdr);
		}
		Code.putJump(for_loopback_addr.pop());
		if_stacks.pop();
		and_stacks.pop();
		or_end_stacks.pop();
		Stack<Integer> curBreak = break_stack.pop();
		for(int curAdr:curBreak) {
			Code.fixup(curAdr);
		}
	}
	
	public void visit(ForThird node) {
		dump_code = true;
	}
	
	public void visit(StatementFour node) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	public void visit(StatementFive node) {
		Code.put(Code.exit);
		Code.put(Code.return_);
	}
	
	Stack<Stack<Integer>> continue_stack = new Stack<Stack<Integer>>();
	Stack<Stack<Integer>> break_stack = new Stack<Stack<Integer>>();
	
	public void visit(StatementTwo node) {
		Code.put(Code.jmp);
		break_stack.peek().add(Code.pc);
		Code.put2(0);
	}
	
	public void visit(StatementThree node) {
		Code.put(Code.jmp);
		continue_stack.peek().add(Code.pc);
		Code.put2(0);
	}
	
	public void visit(DesignatorStatementThree node) {
		if(!dump_code) return;
		if(node.getDesignator().obj.getType().getKind() == Struct.Array) {
			Code.put(Code.dup2);
			if(node.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.baload);
			}else {
				Code.put(Code.aload);
			}
			Code.loadConst(1);
			Code.put(Code.add);
			if(node.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.bastore);
			}else {
				Code.put(Code.astore);
			}

		}else {
			Code.load(node.getDesignator().obj);
			Code.loadConst(1);
			Code.put(Code.add);
			Code.store(node.getDesignator().obj);
		}
		
	}
	
	public void visit(DesignatorStatementFour node) {
		if(!dump_code) return;
		if(node.getDesignator().obj.getType().getKind() == Struct.Array) {
			Code.put(Code.dup2);
			if(node.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.baload);
			}else {
				Code.put(Code.aload);
			}
			Code.loadConst(1);
			Code.put(Code.sub);
			if(node.getDesignator().obj.getType().getElemType() == Tab.charType) {
				Code.put(Code.bastore);
			}else {
				Code.put(Code.astore);
			}

		}else {
			Code.load(node.getDesignator().obj);
			Code.loadConst(1);
			Code.put(Code.sub);
			Code.store(node.getDesignator().obj);
		}
	}
	
	public void visit(StatementSix node) {
		
		if(node.getDesignator().obj.getType().getKind()==Struct.Array) {
			if(node.getDesignator().obj.getType().getElemType()==Tab.charType) {
				Code.put(Code.bread);
				Code.put(Code.bastore);
			}else {
				Code.put(Code.read);
				Code.put(Code.astore);
			}
			
		}else {
			if(node.getDesignator().obj.getType() == Tab.charType) {
				Code.put(Code.bread);
				Code.store(node.getDesignator().obj);
			}else {
				Code.put(Code.read);
				Code.store(node.getDesignator().obj);
			}
		}
	}
	
	public void visit(MyDummy node) {
		doing_args = true;
	}
}

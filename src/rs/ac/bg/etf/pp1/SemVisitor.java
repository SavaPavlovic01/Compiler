package rs.ac.bg.etf.pp1;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

import java_cup.astext.MyUtils;
import rs.ac.bg.etf.pp1.ast.*;
import rs.ac.bg.etf.pp1.ast.ProgramOne;
import rs.ac.bg.etf.pp1.ast.VisitorAdaptor;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;

public class SemVisitor extends VisitorAdaptor {

	// provera da li redefinisano
	// condition da vrati obj
	
	Logger log = Logger.getLogger(getClass());
	public String cur_namespace = "";
	public boolean in_namespace=false;
	public boolean in_func = false;
	public Struct last_seen_type = null;
	public int cur_param_cnt = 0;
	public Obj cur_meth = null;
	
	public String cur_designator = "";
	public int cur_designator_cnt = 0;
	public ArrayList<Struct> desStatement = new ArrayList<Struct>();
	public ArrayList<Struct> actParams = new ArrayList<Struct>();
	public Collection<Obj> formalParams;
	
	public boolean in_loop = false;
	
	int nVars;
	boolean error_detected = false;
	
	public void visit(ProgName name) {
		
		name.obj =Tab.insert(Obj.Prog, name.getI1(), Tab.noType);
		log.info("Opened scope");
		Tab.openScope();
	}
	
	public void visit(ProgramOne prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");	
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramTwo prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramThree prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");	
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramFour prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");	
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramFive prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");		
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramSix prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj && mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 
				&& mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");	
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramSeven prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(ProgramEight prog) {
		nVars = Tab.currentScope.getnVars();
		Obj mainFunc = Tab.find("main");
		if(!(mainFunc != Tab.noObj &&	mainFunc.getKind() == Obj.Meth && mainFunc.getType() == Tab.noType && mainFunc.getLevel() == 0 && mainFunc.getFpPos()==0)){
			log.error("Ne postoji main");	
			error_detected = true;
		}
		Tab.chainLocalSymbols(prog.getProgName().obj);
		log.info("Closed program scope");
		Tab.closeScope();
	}
	
	public void visit(NamespaceName name) {
		cur_namespace = name.getI1();
		in_namespace=true;
		log.info(cur_namespace);
	}
	
	public void visit(NamespaceTwo namespace) {
		log.info("Ended " + cur_namespace);
		cur_namespace = "";
		in_namespace=false;
	}
	
	public void visit(NamespaceThree namespace) {
		log.info("Ended " + cur_namespace);
		cur_namespace = "";
		in_namespace=false;
	}
	
	public void visit(NamespaceFour namespace) {
		log.info("Ended " + cur_namespace);
		cur_namespace = "";
		in_namespace=false;
	}
	
	public void visit(NamespaceOne namespace) {
		log.info("Ended " + cur_namespace);
		cur_namespace = "";
		in_namespace=false;
	}
	
	public void visit(TypeVar type) {
		Obj node = Tab.find(type.getI1());
		if (node == Tab.noObj) {
			log.error("Los tip" + type.getI1());
			error_detected = true;
			type.struct=Tab.noType;
		} else {
			if(node.getKind() == Obj.Type) {
				type.struct= node.getType();
				last_seen_type = node.getType();
			} else {
				log.error("Ne razumem ja nista ovde");
				error_detected = true;
			}
		}
	}
	
	public void visit(TypeNamespace type) {
		Obj node = Tab.find(type.getI1()+"::"+type.getI2());
		if (node == Tab.noObj) {
			log.error("Los tip" + type.getI1());
			error_detected = true;
			type.struct=Tab.noType;
		} else {
			if(node.getKind() == Obj.Type) {
				type.struct= node.getType();
				last_seen_type = node.getType();
			} else {
				log.error("Ne razumem ja nista ovde");
				error_detected = true;
			}
		}
	}
	
	public void visit(ConstDeclNum constDecl) {
		String name = constDecl.getI2();
		if (in_namespace) name = cur_namespace + "::" + name;
		if (constDecl.getType().struct.equals(Tab.intType)) {
			Tab.insert(Obj.Con, name, Tab.intType);
		} else {
			log.error("TREBA INT");
			error_detected = true;
		}
	}
	
	public void visit(ConstDeclBool constDecl) {
		String name = constDecl.getI2();
		if (in_namespace) name = cur_namespace + "::" + name;
		if (constDecl.getType().struct.equals(ExtendedTab.boolType)) {
			Tab.insert(Obj.Con, name, ExtendedTab.boolType);
		} else {
			log.error("TREBA BOOL");
			error_detected = true;
		}
	}
	
	public void visit(ConstDeclChar constDecl) {
		String name = constDecl.getI2();
		if (in_namespace) name = cur_namespace + "::" + name;
		if(constDecl.getType().struct.equals(Tab.charType)) {
			Tab.insert(Obj.Con, name, Tab.charType);
		} else {
			log.error(constDecl.getI2()+ " should be char at line " +constDecl.getLine());
			error_detected = true;
		}
	}
	
	public void visit(ConstDeclNextNum constDecl) {
		String name = constDecl.getI1();
		if (in_namespace) name = cur_namespace + "::" + name;
		log.info("OVDE");
		Tab.insert(Obj.Con, name, Tab.intType);
	}
	
	public void visit(ConstDeclNextChar constDecl) {
		String name = constDecl.getI1();
		if (in_namespace) name = cur_namespace + "::" + name;
		Tab.insert(Obj.Con, name, Tab.charType);
	}
	
	public void visit(ConstDeclNextBool constDecl) {
		String name = constDecl.getI1();
		if (in_namespace) name = cur_namespace + "::" + name;
		Tab.insert(Obj.Con, name, ExtendedTab.boolType);
	}
	
	public void visit(VarDeclOne varDecl) {
		String name = varDecl.getI2();
		if (in_namespace && cur_meth == null) name = cur_namespace + "::" + name;
		if(Tab.find(varDecl.getI2())==Tab.noObj) {
			varDecl.obj=Tab.insert(Obj.Var, name, new Struct(Struct.Array, varDecl.getType().struct));
		} else {
			log.error("Double definition of "+ varDecl.getI2()+" at line " + varDecl.getLine());
			error_detected = true;
		}
	}
	
	public void visit(VarDeclTwo varDecl) {
		String name = varDecl.getI2();
		if (in_namespace && cur_meth == null) name = cur_namespace + "::" + name;
		if(Tab.find(varDecl.getI2())==Tab.noObj) {
			varDecl.obj=Tab.insert(Obj.Var, name, varDecl.getType().struct);
		} else {
			log.error("Double definition of "+ varDecl.getI2()+" at line " + varDecl.getLine());
			error_detected = true;
		}
	}
	
	public void visit(VarDeclNextOne varDecl) {
		String name = varDecl.getI1();
		if (in_namespace && cur_meth == null) name = cur_namespace + "::" + name;
		if(Tab.find(varDecl.getI1())==Tab.noObj) {
			Tab.insert(Obj.Var, name, new Struct(Struct.Array, last_seen_type));
		} else {
			log.error("Double definition of "+ varDecl.getI1()+" at line " + varDecl.getLine());
			error_detected = true;
		}
	}
	
	public void visit(VarDeclNextTwo varDecl) {
		String name = varDecl.getI1();
		if (in_namespace && cur_meth == null) name = cur_namespace + "::" + name;
		if(Tab.find(varDecl.getI1())==Tab.noObj) {
			Tab.insert(Obj.Var, name, last_seen_type);
		} else {
			log.error("Double definition of "+ varDecl.getI1()+" at line " + varDecl.getLine());
			error_detected = true;
		}
	}
	
	public void visit(MethodName name) {
		String full_name = name.getI1();
		in_func = true;
		if(in_namespace) full_name = cur_namespace + "::" + full_name;
		if(name.getParent() instanceof MethodDeclOne) {
			name.obj=Tab.insert(Obj.Meth,full_name , last_seen_type);
			cur_meth = name.obj;
		} else if(name.getParent() instanceof MethodDeclThree) {
			name.obj=Tab.insert(Obj.Meth,full_name , last_seen_type);
			cur_meth = name.obj;
		} else {
			name.obj = Tab.insert(Obj.Meth, full_name, Tab.noType);
			cur_meth = name.obj;
		}
		
		log.info("Method opened scope");
		Tab.openScope();
	}
	
	public void visit(MethodDeclOne decl) {
		
		decl.getMethodName().obj.setFpPos(cur_param_cnt);
		log.info(decl.getMethodName().getI1()+" has "+cur_param_cnt);
		Tab.chainLocalSymbols(decl.getMethodName().obj);
		log.info("Method closed scope");
		cur_param_cnt=0;
		cur_meth = null;
		in_func = false;
		Tab.closeScope();
	}
	
	public void visit(MethodDeclTwo decl) {
		decl.getMethodName().obj.setFpPos(cur_param_cnt);
		log.info(decl.getMethodName().getI1()+" has "+cur_param_cnt);
		Tab.chainLocalSymbols(decl.getMethodName().obj);
		log.info("Method closed scope");
		cur_param_cnt=0;
		cur_meth = null;
		in_func = false;
		Tab.closeScope();
	}
	
	public void visit(MethodDeclThree decl) {
		decl.getMethodName().obj.setFpPos(cur_param_cnt);
		log.info(decl.getMethodName().getI1()+" has "+cur_param_cnt);
		Tab.chainLocalSymbols(decl.getMethodName().obj);
		log.info("Method closed scope");
		cur_param_cnt=0;
		cur_meth = null;
		in_func = false;
		Tab.closeScope();
	}
	
	public void visit(MethodDeclFour decl) {
		decl.getMethodName().obj.setFpPos(cur_param_cnt);
		log.info(decl.getMethodName().getI1()+" has "+cur_param_cnt);
		Tab.chainLocalSymbols(decl.getMethodName().obj);
		log.info("Method closed scope");
		cur_param_cnt=0;
		cur_meth = null;
		in_func = false;
		Tab.closeScope();
	}
	/*
	public void visit(FormParsArr par) {
		cur_param_cnt++;
		log.info("Found formal par");
		Tab.insert(Obj.Var, par.getFormParName().getI1(), new Struct(Struct.Array,par.getType().struct));
	}
	
	public void visit(FormParsVar par) {
		cur_param_cnt++;
		log.info("Found formal par");
		Tab.insert(Obj.Var, par.getFormParName().getI1(), par.getType().struct);
	}
	
	public void visit(FormParsLoopArr par) {
		cur_param_cnt++;
		log.info("Found formal par");
		Tab.insert(Obj.Var, par.getFormParName().getI1(), new Struct(Struct.Array,par.getType().struct));
	}
	
	public void visit(FormParsLoopVar par) {
		cur_param_cnt++;
		log.info("Found formal par");
		Tab.insert(Obj.Var, par.getI3(), par.getType().struct);
	}*/
	
	public void visit(FormParName node) {
		cur_param_cnt++;
		Tab.insert(Obj.Var, node.getI1(), last_seen_type);
	}
	
	public void visit(FactorNum num) {
		num.struct = Tab.intType;
	}
	
	public void visit(FactorBool num) {
		num.struct = ExtendedTab.boolType;
	}
	
	public void visit(FactorChar ch) {
		ch.struct = Tab.charType;
	}
	
	public void visit(FactorNewArr arr) {
		arr.struct = new Struct(Struct.Array, last_seen_type);
		if(arr.getExpr().struct != Tab.intType) {
			log.error("Mora int kod niza");
			error_detected = true;
		}
	}
	
	public void visit(FactorParen paren) {
		paren.struct = paren.getExpr().struct;
	}
	
	public void visit(FactorDesignator fd) {
		fd.struct = fd.getDesignator().obj.getType();
	}
	
	public void visit(FactorTest test) {
		// ovde treba samo da prosledis return tip funkcije 
		test.struct = test.getTest().struct;
	}
	
	public void visit(TestOne test) {
		test.struct = test.getDesignator().obj.getType();
		formalParams=test.getDesignator().obj.getLocalSymbols();
		int argCnt = test.getDesignator().obj.getFpPos();
		if(test.getDesignator().obj.getName().equals("chr") ||
				test.getDesignator().obj.getName().equals("len") ||
				test.getDesignator().obj.getName().equals("ord") ) {
			argCnt = 1;
		}
		
		if(argCnt > actParams.size()) {
			log.error("Too few arguments line: " + test.getLine());
			log.error("expected " + argCnt + " got " + actParams.size());
			error_detected = true;
			actParams.clear();
			return;
		}
		if(argCnt < actParams.size()) {
			log.error("Too many arguments line: " + test.getLine());
			log.error("expected " + argCnt + " got " + actParams.size());
			error_detected = true;
			actParams.clear();
			return;
		}
		
		int i = 0;
		for(Obj curObj:formalParams) {
			if(i==argCnt) break;
			if(!actParams.get(i).equals(curObj.getType())) {
				if(curObj.getType().getKind() == Struct.Array && curObj.getType().getElemType() == Tab.noType)
					continue;
				log.error("Wrong type passed line: " + test.getLine());
				error_detected = true;
				break;
			}
			i++;	
		}
		
		
		actParams.clear();
	}
	
	public void visit(TestTwo test) {
		test.struct = test.getDesignator().obj.getType();
		int argCnt = test.getDesignator().obj.getFpPos();
		if(test.getDesignator().obj.getName().equals("chr") ||
				test.getDesignator().obj.getName().equals("len") ||
				test.getDesignator().obj.getName().equals("ord") ) {
			argCnt = 1;
		}
		
		if(argCnt > 0) {
			log.error("Too few arguments line: " + test.getLine());
			log.error("expected " + argCnt + " got " + actParams.size());
			error_detected = true;
			actParams.clear();
			return;
		}
		
	}
	
	public void visit(DesignatorLoopOne d) {
		// nece nikad
	}
	
	public void visit(DesignatorLoopTwo d) {
		cur_designator_cnt++;
		if(d.getExpr().struct != Tab.intType) {
			log.error("Mora int kod niza");
			error_detected = true;
		}
	}
	
	public void visit(DesignatorLoopThree d) {
		// nece nikad
	}
	
	public void visit(DesignatorLoopFour d) {
		cur_designator_cnt++;
		if(d.getExpr().struct != Tab.intType) {
			log.error("Mora int kod niza");
			error_detected = true;
		}
	}
	
	public void visit(DesignatorTwo d) {
		
		Obj temp = Tab.find(d.getI1() + "::" + d.getI2());
		if(temp == Tab.noObj) {
			log.error(d.getI1() + "::" + d.getI2() + " nije definisan");
			error_detected = true;
			d.obj = temp;
		}else {
			if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
				d.obj = Tab.noObj;
				log.error("Has to be a function line: " + d.getLine());
				error_detected = true;
			}else {
				cur_designator = d.getI1() + "::" + d.getI2();
				d.obj = temp;
			}
			
		}
		
	}
	
	public void visit(DesignatorFour d) {
		String name = d.getI1();
		
		Obj temp = Tab.find(name);
		if(temp == Tab.noObj) {
			if (in_namespace == true) {
				name = cur_namespace + "::" + name;
			}
			temp = Tab.find(name);
			if(temp == Tab.noObj) {
				log.error(name + " nije definisan");
				error_detected = true;
				d.obj = temp;
			}else {
				if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
					d.obj = Tab.noObj;
					log.error("Has to be a function line: " + d.getLine());
					error_detected = true;
				}else {
					cur_designator = name;
					d.obj = temp;
				}
			}
			
		}else {
			if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
				d.obj = Tab.noObj;
				log.error("Has to be a function line: " + d.getLine());
				error_detected = true;
			}else {
				cur_designator = name;
				d.obj = temp;
			}
		}
	}
	
	public void visit(DesignatorOne d) {
		Obj temp = Tab.find(d.getI1() + "::" + d.getI2());
		if(temp == Tab.noObj) {
			log.error(d.getI1() + " nije definisan");
			error_detected = true;
			d.obj = Tab.noObj;
		}else {
			if(temp.getType().getKind() != Struct.Array) {
				log.error("Not indexable line: " + d.getLine());
				error_detected = true;
				d.obj = Tab.noObj;
				return;
			}
			if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
				d.obj = Tab.noObj;
				log.error("Has to be a function line: " + d.getLine());
				error_detected = true;
			}else {
				cur_designator = d.getI1() + "::" + d.getI2();
				d.obj = new Obj(Obj.Var,"",temp.getType().getElemType());
				d.obj.setAdr(temp.getAdr());
				d.obj.setLevel(temp.getLevel());
			}
		}
	}
	
	public void visit(DesignatorThree d) {
		String name = d.getI1();
		Obj temp = Tab.find(name);
		if(temp == Tab.noObj) {
			if(in_namespace == true) {
				name = cur_namespace + "::" + name;
			}
			temp = Tab.find(name);
			if(temp == Tab.noObj) {
				log.error(d.getI1() + " nije definisan");
				error_detected = true;
				d.obj = Tab.noObj;
			}else {
				if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
					d.obj = Tab.noObj;
					log.error("Has to be a function line: " + d.getLine());
					error_detected = true;
				}else {
					cur_designator = name;
					d.obj = new Obj(Obj.Var,"",temp.getType().getElemType());
					d.obj.setAdr(temp.getAdr());
					d.obj.setLevel(temp.getLevel());
				}
			}
			
		}else {
			if(temp.getType().getKind() != Struct.Array) {
				log.error("Not indexable line: " + d.getLine());
				error_detected = true;
				d.obj = Tab.noObj;
				return;
			}
			if((d.getParent() instanceof TestOne || d.getParent() instanceof TestTwo) && temp.getKind() != Obj.Meth) {
				d.obj = Tab.noObj;
				log.error("Has to be a function line: " + d.getLine());
				error_detected = true;
			}else {
				cur_designator = name;
				d.obj = new Obj(Obj.Var,"",temp.getType().getElemType());
				d.obj.setAdr(temp.getAdr());
				d.obj.setLevel(temp.getLevel());
			}
		}
	}
	
	public void visit(TermOne to) {
		if(to.getFactor().struct != Tab.intType) {
			log.error("Mulop mora uz int " + to.getFactor().struct.getKind() + " " + to.getLine());
			error_detected = true;
			to.struct = Tab.noType;
		} else {
			to.struct = Tab.intType;
		}
	}
	
	public void visit(TermTwo tt) {
		tt.struct = tt.getFactor().struct;
	}
	
	public void visit(MulopLoopOne loop) {
		if(loop.getFactor().struct != Tab.intType) {
			log.error("Mulop mora uz int" + loop.getLine());
			error_detected = true;
		} 
	}
	
	public void visit(MulopLoopEnd loop) {
		if(loop.getFactor().struct != Tab.intType) {
			log.error("Mulop mora uz int" + loop.getLine());
			error_detected = true;
		} 
	}
	
	public void visit(ExprOne expr) {
		if(expr.getTerm().struct != Tab.intType) {
			log.error("addop mora uz int");
			error_detected = true;
			expr.struct = Tab.noType;
		}else {
			expr.struct = Tab.intType;
		}
	}
	/*
	public void visit(ExprTwo expr) {
		if(expr.getTerm().struct != Tab.intType) {
			log.error("addop mora uz int");
			error_detected = true;
			expr.struct = Tab.noType;
		}else {
			expr.struct = Tab.intType;
		}
	}
	
	public void visit(ExprThree expr) {
		expr.struct = expr.getTerm().struct;
	}*/
	
	public void visit(ExprFour expr) {
		if(!(expr.getAddopLoop() instanceof AddopLoopEnd)) {
			if(expr.getTerm().struct != Tab.intType) {
				log.error("addop mora uz int");
				error_detected = true;
				expr.struct = Tab.noType;
			}else {
				expr.struct = Tab.intType;
			}
		}
		expr.struct = expr.getTerm().struct;
		
	}
	
	public void visit(AddopLoopOne loop) {
		if(loop.getTerm().struct != Tab.intType) {
			log.error("addop mora uz int");
			error_detected = true;
		}
	}
	
	public void visit(AddopLoopEnd loop) {
		/*if(loop.getTerm().struct != Tab.intType) {
			log.error("addop mora uz int");
			error_detected = true;
		}*/
	}
	
	public void visit(ConditionOne condition) {
		if(condition.getCondTerm().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + condition.getLine());
			error_detected = true;
		}
		condition.struct = ExtendedTab.boolType;
	}
	
	public void visit(ConditionTwo condition) {
		if(condition.getCondTerm().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + condition.getLine());
			error_detected = true;
		}
		condition.struct = ExtendedTab.boolType;
	}
	
	public void visit(ConditionLoopOne condition) {
		if(condition.getCondTerm().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + condition.getLine());
			error_detected = true;
		}
	}
	
	public void visit(ConditionLoopEnd condition) {
		if(condition.getCondTerm().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + condition.getLine());
			error_detected = true;
		}
		
	}
	
	public void visit(CondTermOne cond) {
		if(cond.getCondFact().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + cond.getLine());
			error_detected = true;
		}
		cond.struct = ExtendedTab.boolType;
	}
	
	public void visit(CondTermTwo cond) {
		if(cond.getCondFact().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + cond.getLine());
			error_detected = true;
		}
		cond.struct = ExtendedTab.boolType;
	}
	
	public void visit(CondTermLoopOne cond) {
		if(cond.getCondFact().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + cond.getLine());
			error_detected = true;
		}
	}
	
	public void visit(CondTermLoopTwo cond) {
		if(cond.getCondFact().struct != ExtendedTab.boolType) {
			log.error("Bool type expected " + cond.getLine());
			error_detected = true;
		}
	}
	
	public void visit(CondFactOne cond) {
		cond.struct = cond.getExpr().struct;
	}
	
	public void visit(CondFactTwo cond) {
		if(cond.getExpr().struct == null) return;
		if(!cond.getExpr().struct.equals(cond.getExpr1().struct)) {
			log.error("Comparison between uncompatible types");
			error_detected = true;
		}
		cond.struct = ExtendedTab.boolType;
	}
	
	public void visit(DesignatorStatementOne state) {
		if(state.getDesignator().obj == null) return;
		if(state.getDesignator().obj.getKind() == Obj.Meth) {
			log.error("Assignment between incompatible types line:" + state.getLine());
			error_detected = true;
			return;
		}
		if(!(state.getDesignator().obj.getType().equals(state.getExpr().struct))) {
			log.error("Assignment between incompatible types line:" + state.getLine());
			error_detected = true;
			log.error(state.getDesignator().obj.getType().getKind());
			log.error(state.getExpr().struct.getKind());
		}
	}
	
	public void visit(DesignatorStatementThree state) {
		if(state.getDesignator().obj.getType() != Tab.intType || 
				state.getDesignator().obj.getKind() != Obj.Var) {
			log.error("Increment only on int type line:" + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(DesignatorStatementFour state) {
		if(state.getDesignator().obj.getType() != Tab.intType ||
				state.getDesignator().obj.getKind() != Obj.Var) {
			log.error("Increment only on int type line:" + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(DesignatorStatementFive state) {
		if(!(state.getDesignator1().obj.getType().getKind() == Struct.Array)) {
			log.error("Left side of assignment has to be array line: " +state.getLine());
			error_detected = true;
		}
		if(!state.getDesignator1().obj.getType().equals(state.getDesignator().obj.getType())) {
			log.error("Incompatible types line: " + state.getLine());
			error_detected = true;
		}
		
		for(int i = 0; i<desStatement.size();i++) {
			if(desStatement.get(i) != state.getDesignator1().obj.getType().getElemType()) {
				log.error("Incompatible type line: " + state.getLine() );
				error_detected = true;
				break;
			}
		}
		desStatement.clear();
	}
	
	public void visit(DesignatorStatementSix state) {
		if(!(state.getDesignator1().obj.getType().getKind() == Struct.Array)) {
			log.error("Left side of assignment has to be array line: " +state.getLine());
			error_detected = true;
		}
		if(!state.getDesignator1().obj.getType().equals(state.getDesignator().obj.getType())) {
			log.error("Incompatible types line: " + state.getLine());
			error_detected = true;
		}
		
		for(int i = 0; i<desStatement.size();i++) {
			if(desStatement.get(i) != state.getDesignator1().obj.getType().getElemType()) {
				log.error("Incompatible type line: " + state.getLine() );
				error_detected = true;
				break;
			}
		}
		desStatement.clear();
	}
	
	public void visit(DesStatementLoopOne loop) {
		desStatement.add(loop.getDesignator().obj.getType());
	}
	
	public void visit(DesStatementLoopThree loop) {
		desStatement.add(loop.getDesignator().obj.getType());
	}
	
	public void visit(ActPars par) {
		actParams.add(par.getExpr().struct);
	}
	
	public void visit(ActParsLoopOne par) {
		actParams.add(par.getExpr().struct);
	}
	
	public void visit(StatementSeventeen state) {
		if(state.getCondition().struct != ExtendedTab.boolType) {
			log.error("Bool type expected line: " + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(For f) {
		in_loop = true;
	}
	
	public void visit(StatementTen state) {
		in_loop = false;
	}
	
	public void visit(StatementEleven state) {
		in_loop = false;
	}
	
	public void visit(StatementTwelve state) {
		in_loop = false;
	}
	
	public void visit(StatementThirteen state) {
		in_loop = false;
	}
	
	public void visit(StatementFourteen state) {
		in_loop = false;
	}	
	
	public void visit(StatementFifteen state) {
		in_loop = false;
	}
	
	public void visit(StatementSixteen state) {
		in_loop = false;
	}
	
	public void visit(StatementTwo state) {
		if(!in_loop) {
			log.error("Brake outside of loop line:" + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementThree state) {
		if(!in_loop) {
			log.error("Continue outside of loop line:" + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementFour state) {
		if(!in_func) {
			log.error("Return outside of function line: " + state.getLine());
			error_detected = true;
			return;
		}
		if(!state.getExpr().struct.equals(cur_meth.getType())) {
			log.error("Wrong return type line: " + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementFive state) {
		if(!in_func) {
			log.error("Return outside of function line: " + state.getLine());
			error_detected = true;
			return;
		}
		if(cur_meth.getType() != Tab.noType) {
			log.error("Wrong return type line: " + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementEight state) {
		if(state.getExpr().struct.getKind() == Struct.Array) {
			log.error("cant be array line: " + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementNine state) {
		if(state.getExpr().struct.getKind() == Struct.Array) {
			log.error("cant be array line: " + state.getLine());
			error_detected = true;
		}
	}
	
	public void visit(StatementSix state) {
		if(state.getDesignator().obj.getKind() == Obj.Meth) {
			log.error(state.getLine());
			error_detected = true;
		}
		if(state.getDesignator().obj.getType().getKind() == Struct.Array) {
			log.error(state.getLine());
			error_detected = true;
		}
	}
}

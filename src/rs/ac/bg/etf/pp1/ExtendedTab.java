package rs.ac.bg.etf.pp1;

import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class ExtendedTab extends Tab {
	public static final Struct boolType = new Struct(Struct.Bool);
	
	
	public static void Init() {
		init();
		currentScope.addToLocals(new Obj(Obj.Type, "bool", boolType));
	}
	
	
	/*
	public static void dump() {
		
	}*/
}

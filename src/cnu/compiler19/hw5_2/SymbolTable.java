package cnu.compiler19.hw5_2;

import java.util.HashMap;
import java.util.Map;

import cnu.compiler19.hw5_2.MiniCParser.Fun_declContext;
import cnu.compiler19.hw5_2.MiniCParser.Local_declContext;
import cnu.compiler19.hw5_2.MiniCParser.Var_declContext;

import static cnu.compiler19.hw5_2.BytecodeGenListenerHelper.*;


public class SymbolTable {
	enum Type {
		INT, INTARRAY, VOID, ERROR
	}
	
	static public class VarInfo {
		Type type; 
		int id;
		int initVal;
		
		public VarInfo(Type type,  int id, int initVal) {
			this.type = type;
			this.id = id;
			this.initVal = initVal;
		}
		public VarInfo(Type type,  int id) {
			this.type = type;
			this.id = id;
			this.initVal = 0;
		}
	}

	static public class FInfo {
		public String sigStr;

		FInfo(){}

		FInfo(String _sigStr){
			this.sigStr = _sigStr;
		}
	}
	
	private Map<String, VarInfo> _lsymtable = new HashMap<>();	// local v.
	private Map<String, VarInfo> _gsymtable = new HashMap<>();	// global v.
	private Map<String, FInfo> _fsymtable = new HashMap<>();	// function 
	
		
	private int _globalVarID = 0;
	private int _localVarID = 0;
	private int _labelID = 0;
	private int _tempVarID = 0;
	
	SymbolTable(){
		initFunDecl();
		initFunTable();
	}
	
	void initFunDecl(){		// at each func decl
		_localVarID = 0;
		_labelID = 0;
		_tempVarID = 32;		
	}
	
	void putLocalVar(String varname, Type type){
		//<Fill here>
		_lsymtable.put(varname, new VarInfo(type, _localVarID++));
	}
	
	void putGlobalVar(String varname, Type type){
		//<Fill here>
		_gsymtable.put(varname, new VarInfo(type, _globalVarID++));
	}
	
	void putLocalVarWithInitVal(String varname, Type type, int initVar){
		//<Fill here>
		_lsymtable.put(varname, new VarInfo(type, _localVarID++, initVar));
	}
	void putGlobalVarWithInitVal(String varname, Type type, int initVar){
		//<Fill here>
		_gsymtable.put(varname, new VarInfo(type, _globalVarID++, initVar));
	}
	
	void putParams(MiniCParser.ParamsContext params) {
		for(int i = 0; i < params.param().size(); i++) {
		//<Fill here>

		}
	}
	
	private void initFunTable() {
		_fsymtable.put("_print", new FInfo("java/io/PrintStream/println(I)V"));
		_fsymtable.put("main", new FInfo("main([Ljava/lang/String;)V"));
	}
	
	public String getFunSpecStr(String fname) {		
		// <Fill here>
		if(_fsymtable.get(fname) != null) return _fsymtable.get(fname).sigStr;
		else return "";
	}

	public String getFunSpecStr(Fun_declContext ctx) {
		// <Fill here>
		return _fsymtable.get(ctx.IDENT().getText()).sigStr;
	}
	
	public String putFunSpecStr(Fun_declContext ctx) {
		String fname = getFunName(ctx);
		String argtype = "";	
		String rtype = "";
		String res = "";
		
		// <Fill here>	
		
		res =  fname + "(" + argtype + ")" + rtype;
		
		FInfo finfo = new FInfo(res);
		_fsymtable.put(fname, finfo);
		
		return res;
	}
	
	String getVarId(String name){
		// <Fill here>
		// local variable 중 찾고, 없으면 global에서 찾는다.
		// global에도 있고 local에도 있다면, 변수 가리기로 local만 찾아진다.

		if(_lsymtable.get(name) != null){
			return Integer.toString(_lsymtable.get(name).id);
		}
		else{
			return Integer.toString(_gsymtable.get(name).id);
		}

	}
	
	Type getVarType(String name){
		VarInfo lvar = (VarInfo) _lsymtable.get(name);
		if (lvar != null) {
			return lvar.type;
		}
		
		VarInfo gvar = (VarInfo) _gsymtable.get(name);
		if (gvar != null) {
			return gvar.type;
		}
		
		return Type.ERROR;	
	}

	String newLabel() {
		return "label" + _labelID++;
	}
	
	String newTempVar() {
		String id = "";
		return id + _tempVarID--;
	}

	// global
	public String getVarId(Var_declContext ctx) {
		// <Fill here>
		return getVarId(ctx.IDENT().getText());
	}

	// local
	public String getVarId(Local_declContext ctx) {
		String sname = "";
		sname += getVarId(ctx.IDENT().getText());
		return sname;
	}
	
}

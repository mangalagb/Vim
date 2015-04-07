import java.util.LinkedList;


public class Module {
	public String name;
	private LinkedList<String> fromModule;
	private LinkedList<String> toModule;
	private LinkedList<String> includes;
	
	public Module(String pName){
		name = pName;
		fromModule = new LinkedList<String>();
		toModule = new LinkedList<String>();
		includes= new LinkedList<String>();
	}
	
	
	public LinkedList<String> getFromModule(){
		return fromModule;
	}
	public LinkedList<String> getToModule(){
		return toModule;
	}
	public LinkedList<String> getIncludes(){
		return includes;
	}
	
	public void addFromModule(String pModule){
		if(!fromModule.contains(pModule)){
			fromModule.add(pModule);
		}
	}
	
	public void addToModule(String pModule){
		if(!toModule.contains(pModule)){
			toModule.add(pModule);
		}
	}
	
	public void addIncludes(String pModule){
		if(!includes.contains(pModule)){
			includes.add(pModule);
		}
	}
}

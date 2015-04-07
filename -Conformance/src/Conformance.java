/**
 * This program reads the CSV file with the file dependencies. The file
 * consists of calls From file, to File names separated with comma.
 * Using hash map each file is mapped to corresponding module.
 * Each module has list of modules that it makes calls to as well as
 * a list modules from which this module is called.   
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Conformance {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		HashMap<String, Module> hm = new HashMap<String, Module>();
		//loading filenames and corresponding modules to the hash map
		Module Base = new Module("Base");
		hm.put("globals.h", Base);
		hm.put("macros.h", Base);
		hm.put("main.c", Base);
		hm.put("misc1.c", Base);
		hm.put("misc2.c", Base);
		hm.put("structs.h", Base);
		hm.put("version.c", Base);
		hm.put("version.h", Base);
		hm.put("vim.h", Base);
		hm.put("vimio.h", Base);
		hm.put("vimrun.c", Base);
		hm.put("vimtbar.h", Base);
		hm.put("sha256.c", Base);
		hm.put("regexp.c", Base);
		hm.put("regexp.h", Base);
		hm.put("option.c", Base);
		hm.put("option.h", Base);
		hm.put("iid_ole.c", Base);
		hm.put("getchar.c", Base);
		hm.put("feature.h", Base);
		hm.put("eval.c", Base);
		hm.put("dlldata.c", Base);
		hm.put("dosinst.c", Base);
		hm.put("dosinst.h", Base);
		hm.put("hardcopy.c", Base);
		hm.put("hashtab.c", Base);
		hm.put("blowfish.c", Base);
		hm.put("nbdebug.c", Base);
		hm.put("nbdebug.h", Base);
		hm.put("netbeans.c", Base);
		hm.put("proto.h", Base);
		hm.put("mbyte.c", Base);
		hm.put("wsdebug.c", Base);
		hm.put("wsdebug.h", Base);
		hm.put("workshop.c", Base);
		hm.put("workshop.h", Base);
		hm.put("integration.c", Base);
		hm.put("integration.h", Base);
		hm.put("ascii.h", Base);
		hm.put("charset.c", Base);
		hm.put("digraph.c", Base);
		hm.put("keymap.h", Base);
		
		//Alphabetical Mapping Module
		Module AM = new Module("Alphabetical Mappings");
		hm.put("arabic.c", AM);
		hm.put("arabic.h", AM);
		hm.put("farsi.c", AM);
		hm.put("farsi.h", AM);
		hm.put("glbl_ime.cpp", AM);
		hm.put("glbl_ime.h", AM);
		hm.put("hangulin.c", AM);
		
		//Screen Module
		Module Screen = new Module("Screen");
		hm.put("gui.c", Screen);
		hm.put("gui.h", Screen);
		hm.put("gui_at_fs.c", Screen);
		hm.put("gui_at_sb.c", Screen);
		hm.put("gui_at_sb.h", Screen);
		hm.put("gui_athena.c", Screen);
		hm.put("gui_beval.c", Screen);
		hm.put("gui_beval.h", Screen);
		hm.put("gui_gtk_f.c", Screen);
		hm.put("gui_gtk.c", Screen);
		hm.put("gui_gtk_f.h", Screen);
		hm.put("gui_gtk_vms.h", Screen);
		hm.put("gui_gtk_x11.c", Screen);
		hm.put("gui_mac.c", Screen);
		hm.put("gui_motif.c", Screen);
		hm.put("gui_photon.c", Screen);
		hm.put("gui_riscos.h", Screen);
		hm.put("gui_riscos.c", Screen);
		hm.put("gui_w16.c", Screen);
		hm.put("gui_w32.c", Screen);
		hm.put("gui_w32_rc.h", Screen);
		hm.put("gui_w48.c", Screen);
		hm.put("gui_x11.c", Screen);
		hm.put("gui_x11_pm.h", Screen);
		hm.put("gui_xmdlg.c", Screen);
		hm.put("gui_xmebw.c", Screen);
		hm.put("gui_xmebw.h", Screen);
		hm.put("gui_xmebwp.h", Screen);
		hm.put("guiw16rc.h", Screen);
		hm.put("screen.c", Screen);
		hm.put("term.c", Screen);
		hm.put("term.h", Screen);
		hm.put("termlib.c", Screen);
		hm.put("ui.c", Screen);
		hm.put("window.c", Screen);
		hm.put("move.c", Screen);
		hm.put("menu.c", Screen);
		hm.put("popupmnu.c", Screen);
		hm.put("message.c", Screen);
		hm.put("pty.c", Screen);
		
		//OS Module
		Module OS = new Module("OS");
		hm.put("os_amiga.c", OS);
		hm.put("os_amiga.h", OS);
		hm.put("os_beos.c", OS);
		hm.put("os_beos.h", OS);
		hm.put("os_dos.h", OS);
		hm.put("os_mac.h", OS);
		hm.put("os_mac_conv.c", OS);
		hm.put("os_mint.h", OS);
		hm.put("os_msdos.c", OS);
		hm.put("os_msdos.h", OS);
		hm.put("os_mswin.c", OS);
		hm.put("os_os2_cfg.h", OS);
		hm.put("os_qnx.h", OS);
		hm.put("os_qnx.c", OS);
		hm.put("os_riscos.c", OS);
		hm.put("os_riscos.h", OS);
		hm.put("os_unix.c", OS);
		hm.put("os_unix.h", OS);
		hm.put("os_unixx.h", OS);
		hm.put("os_vms.c", OS);
		hm.put("os_vms_conf.h", OS);
		hm.put("os_vms_mms.c", OS);
		hm.put("os_w32dll.c", OS);
		hm.put("os_w32exe.c", OS);
		hm.put("os_win16.c", OS);
		hm.put("os_win16.h", OS);
		hm.put("os_win32.c", OS);
		hm.put("os_win32.h", OS);
		hm.put("xpm_w32.c", OS);
		hm.put("xpm_w32.h", OS);
		hm.put("uninstal.c", OS);
		
		//Programming Languages interfaces
		Module PL = new Module("Programming Languages");
		hm.put("if_cscope.c", PL);
		hm.put("if_cscope.h", PL);
		hm.put("if_lua.c", PL);
		hm.put("if_mzsch.c", PL);
		hm.put("if_mzsch.h", PL);
		hm.put("if_ole.cpp", PL);
		hm.put("if_ole.h", PL);
		hm.put("if_perlsfio.c", PL);
		hm.put("if_py_both.h", PL);
		hm.put("if_python.c", PL);
		hm.put("if_python3.c", PL);
		hm.put("if_ruby.c", PL);
		hm.put("if_sniff.c", PL);
		hm.put("if_sniff.h", PL);
		hm.put("if_tcl.c", PL);
		hm.put("if_xcmdsrv.c", PL);
		
		//Buffer Module
		Module Buffer = new Module("Buffer");
		hm.put("buffer.c", Buffer);
		hm.put("fileio.c", Buffer);
		hm.put("fold.c", Buffer);
		hm.put("syntax.c", Buffer);
		hm.put("tag.c", Buffer);
		hm.put("spell.c", Buffer);
		hm.put("memfile.c", Buffer);
		hm.put("memline.c", Buffer);
		hm.put("mark.c", Buffer);
		hm.put("diff.c", Buffer);
		hm.put("edit.c", Buffer);
		hm.put("quickfix.c", Buffer);
		
		//Commands Module
		Module Commands = new Module("Commands");
		hm.put("ex_cmds.c", Commands);
		hm.put("ex_cmds.h", Commands);
		hm.put("ex_cmds2.c", Commands);
		hm.put("ex_docmd.c", Commands);
		hm.put("ex_eval.c", Commands);
		hm.put("ex_getln.c", Commands);
		hm.put("undo.c", Commands);
		hm.put("search.c", Commands);
		hm.put("normal.c", Commands);
		hm.put("ops.c", Commands);
		
		//opening file with dependencies
		File file = new File("./vim_decomp_FileDependencies.csv");
		BufferedReader bufRdr  = new BufferedReader(new FileReader(file));
		String line = null;
		String fromFile = null;
		String toFile = null;
		System.out.println("Starting. \n\n");
		while((line = bufRdr.readLine()) != null){
			StringTokenizer st = new StringTokenizer(line,",");
			fromFile = st.nextToken();
			toFile	= st.nextToken();
			fromFile = fromFile.replace("src\\", "");
			toFile = toFile.replace("src\\", "");
			
			Module fromModule = (Module) hm.get(fromFile);
			Module toModule = (Module) hm.get(toFile);
			
			if(toModule == null || fromModule == null){
				if(fromModule == null){
					System.out.println("Null value encountered for fromFile: " + fromFile);
				}				
				if(toModule == null){
					System.out.println("Null value encountered for toFile: " + toFile);
				}
			}else{
				fromModule.addToModule(toModule.name);
				toModule.addFromModule(fromModule.name);
			}
		}
		
		//close the file with file dependencies
		bufRdr.close();
		
		//getting the list of files from the hash map to check for includes
		String[] files = new String[hm.size()];
		files = (String[])( hm.keySet().toArray(files));
		

		for(int i = 0; i<files.length; i++){
			File leFile = new File("/home/2010/knagiy/workspace/comp529/vim_src/" + files[i]);
			BufferedReader bufRdr2  = new BufferedReader(new FileReader(leFile));
			line = null;
			String libraryFile = null;
			while((line = bufRdr2.readLine()) != null){
				if(line.contains("# include") || line.contains("#include")){
					if(line.contains("\"")){
						StringTokenizer st = new StringTokenizer(line,"\"");
						st.nextToken();
						libraryFile	= st.nextToken();
						Module leModule = hm.get(files[i]);
						Module includedModule = hm.get(libraryFile);
						if(leModule != null && includedModule!=null){
							leModule.addIncludes(includedModule.name);
						}
					}
					
				}
			}
			bufRdr2.close();
		}
		
		//Printing the output for each module
		System.out.println("Base module:");
		System.out.println("called from: " + Base.getFromModule().toString());
		System.out.println("calls: " + Base.getToModule().toString());
		System.out.println("Inludes: " + Base.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("Alphabetical Mappings module:");
		System.out.println("called from: " + AM.getFromModule().toString());
		System.out.println("calls: " + AM.getToModule().toString());
		System.out.println("Inludes: " + AM.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("Screen module:");
		System.out.println("called from: " + Screen.getFromModule().toString());
		System.out.println("calls: " + Screen.getToModule().toString());
		System.out.println("Inludes: " + Screen.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("OS module:");
		System.out.println("called from: " + OS.getFromModule().toString());
		System.out.println("calls: " + OS.getToModule().toString());
		System.out.println("Inludes: " + OS.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("Progaramming Languages module:");
		System.out.println("called from: " +  PL.getFromModule().toString());
		System.out.println("calls: " +  PL.getToModule().toString());
		System.out.println("Inludes: " + PL.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("Buffer module:");
		System.out.println("called from: " +  Buffer.getFromModule().toString());
		System.out.println("calls: " +  Buffer.getToModule().toString());
		System.out.println("Inludes: " + Buffer.getIncludes().toString());
		System.out.println();
		System.out.println();
		System.out.println("Commands module:");
		System.out.println("called from: " +  Commands.getFromModule().toString());
		System.out.println("calls: " +  Commands.getToModule().toString());
		System.out.println("Inludes: " + Commands.getIncludes().toString());
	}
	
	
}

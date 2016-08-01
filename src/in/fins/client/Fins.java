package in.fins.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;

import in.fins.client.content.FinsShell;

public class Fins implements EntryPoint {
	
	private static final Logger log = Logger.getLogger(Fins.class.getName());
	
	@Override
	public void onModuleLoad() {
		RootLayoutPanel rp = RootLayoutPanel.get();
		FinsShell finsShell = new FinsShell();
		rp.add(finsShell);
		
		log.info("Module loaded. BaseURL - " + GWT.getModuleBaseURL());
	}

}

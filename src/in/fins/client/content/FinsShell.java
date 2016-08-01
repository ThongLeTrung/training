package in.fins.client.content;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import in.fins.client.event.EventBus;
import in.fins.client.event.StatusEvent;
import in.fins.client.event.StatusEvent.StatusHandler;
import in.fins.client.widget.ContentPanel;
import in.fins.client.widget.MenuBar;
import in.fins.client.widget.Status;

public class FinsShell extends ResizeComposite implements StatusHandler{

	interface FinsShellBinder extends UiBinder<Widget, FinsShell> {}
	private static UiBinder<Widget, FinsShell> binder = GWT.create(FinsShellBinder.class);

	@UiField
	Label logoLabel;
	@UiField
	ContentPanel contentPanel;
	@UiField
	MenuBar menuBar;
	@UiField
    Status status;
	
	public FinsShell() {
		initWidget(binder.createAndBindUi(this));
		contentPanel.addTab("Home",	new DateBox());
		if (!GWT.isProdMode()) {
			contentPanel.addTab("Log", new LogTab());
		}
		EventBus.get().addHandler(StatusEvent.TYPE, this);
        EventBus.get().fireEvent(new StatusEvent("message"));
	}

	@Override
	public void onStatusChange(StatusEvent event) {
		status.setText(event.getStatus());
	}
}
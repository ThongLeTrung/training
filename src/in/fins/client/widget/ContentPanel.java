package in.fins.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.TabLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import in.fins.client.event.EventBus;
import in.fins.client.event.MenuEvent;
import in.fins.client.event.MenuHandler;

public class ContentPanel extends ResizeComposite implements MenuHandler{

	interface ContentPanelBinder extends UiBinder<Widget, ContentPanel> {
	}

	private static UiBinder<Widget, ContentPanel> binder = GWT.create(ContentPanelBinder.class);

	@UiField
	TabLayoutPanel tab;

	public ContentPanel() {
		initWidget(binder.createAndBindUi(this));
		EventBus.get().addHandler(MenuEvent.TYPE, this);
	}

	public void addTab(String text, Composite content) {
        tab.add(content,text);
		tab.selectTab(tab.getWidgetCount() - 1);
	}

	@Override
	public void onMenuSelection(MenuEvent menuEvent) {
		String contentName = menuEvent.getMenu();
		addTab(contentName, new DateBox());
		
	}
}
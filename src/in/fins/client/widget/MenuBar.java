package in.fins.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.ResizeComposite;
import com.google.gwt.user.client.ui.Widget;

public class MenuBar extends ResizeComposite {

	interface MenuBarBinder extends UiBinder<Widget, MenuBar> {
	}

	private static UiBinder<Widget, MenuBar> binder = GWT
			.create(MenuBarBinder.class);

	public MenuBar() {
		initWidget(binder.createAndBindUi(this));
	}
}
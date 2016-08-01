package in.fins.client.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class Status extends Composite implements HasText {

	interface StatusBinder extends UiBinder<Widget, Status> {
	}

	private static UiBinder<Widget, Status> binder = GWT
			.create(StatusBinder.class);

	@UiField
	HTML html;

	public Status() {
		initWidget(binder.createAndBindUi(this));
	}

	public void setText(String text) {
		html.setText(text);
	}

	public String getText() {
		return html.getText();
	}

}
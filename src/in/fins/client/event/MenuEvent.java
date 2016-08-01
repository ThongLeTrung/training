package in.fins.client.event;

import com.google.web.bindery.event.shared.Event;

public class MenuEvent extends Event<MenuHandler>{
	public static final Type<MenuHandler> TYPE = new Type<MenuHandler>();
	private String menu;
	
	public MenuEvent(String menu){
		this.menu = menu;
	}
	
	public String getMenu(){
		return menu;
	}
	
	@Override
	public Type<MenuHandler> getAssociatedType(){
		return TYPE;
	}
	
	@Override
	protected void dispatch(MenuHandler handler){
		handler.onMenuSelection(this);
	}
}
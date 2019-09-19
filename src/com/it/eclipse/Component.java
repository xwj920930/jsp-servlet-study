package com.it.eclipse;
//基础接口
public interface Component {
	public void biu();
}
//具体实现类
class ComponentImpl implements Component{
	@Override
	public void biu() {
		System.out.println("biubiubiu");
	}
}
//装饰类
class Decorator implements Component{
	Component component;
	public Decorator(Component component) {
		this.component=component;
	}
	@Override
	public void biu() {
		this.component.biu();
	}
}
//具体装饰类
class DecoratorEx extends Decorator{
	public DecoratorEx(Component component) {
		super(component);
	}
	public void biu() {
		System.out.println("ready");
		this.component.biu();
	}
	
}

package io.github.prospector.modmenu.mixin;

import net.minecraft.client.gui.widgets.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Button.class)
public interface MixinGuiButton {

	@Accessor
	int getWidth();

	@Accessor
	void setWidth(int width);

	@Accessor
	void setHeight(int height);

}

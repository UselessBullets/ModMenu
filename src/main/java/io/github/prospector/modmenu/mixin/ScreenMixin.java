package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import net.minecraft.client.gui.MainMenuScreen;
import net.minecraft.client.gui.Screen;
import net.minecraft.client.gui.menu.PauseMenuScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Screen.class)
public class ScreenMixin {

	@Shadow public int height;

	@Inject(at = @At("HEAD"), method = "addButton", cancellable = true)
	protected void addButton(ButtonWidget var1, CallbackInfoReturnable info) {
		if (((Object) this) instanceof MainMenuScreen) {
			if (var1.y <= this.height / 4 + 48 + 24 * 3) {
				var1.y -= 12;
			}
			if (var1.y > this.height / 4 + 48 + 24 * 3) {
				var1.y += 12;
			}
		}
		if (((Object) this) instanceof PauseMenuScreen) {
			if (var1.y >= this.height / 4 - 16 + 24 * 4 - 1 && !(var1 instanceof ModMenuButtonWidget)) {
				var1.y += 24;
			}
			var1.y -= 12;
		}
	}
}
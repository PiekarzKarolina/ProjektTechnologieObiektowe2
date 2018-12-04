package game;

import com.google.inject.AbstractModule;
import controller.NurikabeBoardController;

public class GameModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Game.class).to(NurikabeBoardController.class);
    }
}

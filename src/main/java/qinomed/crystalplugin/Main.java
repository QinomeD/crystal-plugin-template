package qinomed.crystalplugin;

import ovh.crystallauncher.crystal.plugin.AbstractPlugin;
import ovh.crystallauncher.crystal.plugin.EPluginEventType;
import ovh.crystallauncher.crystal.plugin.PluginManager;

@SuppressWarnings("unused")
public class Main extends AbstractPlugin {
    @Override
    public void onPluginLoad(PluginManager pluginManager) {
        // Do something on load
    }

    @Override
    public void eventReceived(EPluginEventType eventType, Object ctx) {
        // Listen for launcher events
        // Check for a specific event type
        // Cast ctx argument accordingly (if the context is present)
    }

    @Override
    public void onPluginUnload(PluginManager pluginManager) {
        // Do something on unload
    }
}

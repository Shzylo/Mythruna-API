package examples.java;

import mythruna.PlayerContext;
import mythruna.event.EventDispatcher;
import mythruna.event.EventListener;
import mythruna.event.EventType;
import mythruna.event.PlayerEvent;
import mythruna.event.PlayerEvents;

import org.progeeks.cmd.Environment;
import org.progeeks.cmd.Result;
import org.progeeks.tool.console.Shell;
import org.progeeks.tool.console.ShellCommand;
import org.progeeks.tool.console.ShellEnvironment;

/*
 * A demonstration of how to use permissions.
 * You may first want to visit how to add commands to players at:
 * 
 * https://github.com/Shzylo/Mythruna-API/blob/master/examples/java/AddShellCommand.java
 */
public class Permissions {
	public static void ifPlayerHasPermission() {
		EventDispatcher.getInstance().addListener(PlayerEvents.playerJoined, new EventListener<PlayerEvent>() {
			@Override
			public void newEvent(EventType<PlayerEvent> type, PlayerEvent event) {
				final PlayerContext context = event.getContext();
				/*
				 * Okay, this is the same as the AddShellCommand tutorial, except
				 * this one checks for permissions before adding the command.
				 */
				if (context.getPlayerData().get("grant.admin")) {
					Shell shell = context.getShell();

					ShellCommand cmd = new ShellCommand() {
						private static final long serialVersionUID = 1L;

						@Override
						public Result execute(Environment env) {
							return null;
						}

						@Override
						public boolean isSimple() {
							return false;
						}

						@Override
						public String[] getHelp() {
							String[] help = { "Only admins get this command." };
							return help;
						}

						@Override
						public String getDescription() {
							return "Only admins can use this command.";
						}

						@Override
						public int execute(ShellEnvironment shellEnv, String str) {
							context.echo("You are an admin!");
							return 0;
						}
					};
					shell.registerCommand("admin", cmd);
				}
			}
		});
	}
}

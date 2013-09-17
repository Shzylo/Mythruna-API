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
 * A demonstration of how to add a command to a player.
 */
public class AddShellCommand {
	public static void addShellCommand() { //Name the method as you wish, I just used 'addShellCommand()'
		EventDispatcher.getInstance().addListener(PlayerEvents.playerJoined, new EventListener<PlayerEvent>() {
			@Override
			public void newEvent(EventType<PlayerEvent> type, PlayerEvent event) {
				final PlayerContext context = event.getContext();
				Shell shell = context.getShell();
				
				ShellCommand cmd = new ShellCommand() {
					private static final long serialVersionUID = 1L;
					
					// This method is seemingly useless.
					@Override
					public Result execute(Environment env) {
						return null;
					}
					
					// This method is seemingly useless.
					@Override
					public boolean isSimple() {
						return false;
					}
					
					@Override
					public String[] getHelp() {
						String[] help = {"This is command help information", "This is more help information"};
						return help;
					}
					
					@Override
					public String getDescription() {
						return "This is the command description";
					}
					
					@Override
					public int execute(ShellEnvironment shellEnv, String str) {
						context.echo("You executed the command!");
						shellEnv.getShell().getCommands();
						return 0;
					}
				};
				shell.registerCommand("test", cmd);
			}
		});
	}
}

import mythruna.event.EventDispatcher;
import mythruna.event.EventListener;
import mythruna.event.EventType;
import mythruna.event.PlayerEvent;
import mythruna.event.PlayerEvents;

/** We are just using the PlayerEvents.playerJoined for this method. Full list of Events:
 * 
 * PlayerEvents.playerJoined (PlayerEvent)
 * PlayerEvevnts.playerLeft (PlayerEvent)
 * ServerEvents.serverStarted (ServerEvent)
 * ServerEvents.serverStopping (ServerEvent)
 * ServerEvents.newConnection (ServerEvent)
 * ServerEvents.playerConnected (ServerEvent)
 * ServerEvents.playerDisconnected (ServerEvent)
 * ServerEvents.playerChatted (ServerPlayerEvent)
 * WorldEvents.cellChanged (CellEvent)
 */
public class On {
	public static void onPlayerJoined() { //Name this whatever you want, MUST BE PUBLIC AND STATIC!
		// Adding the event
		EventDispatcher.getInstance().addListener(PlayerEvents.playerJoined, new EventListener<PlayerEvent>() {
			@Override
			public void newEvent(EventType<PlayerEvent> type, PlayerEvent event) { //Registers the event
				String playerName = event.getContext().getPlayerData().get("characterInfo.name");
				event.getContext().echo("Hello there, " + playerName);
			}
		});
	}
}

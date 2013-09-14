import mythruna.event.EventDispatcher;
import mythruna.event.EventListener;
import mythruna.event.EventType;
import mythruna.event.PlayerEvent;
import mythruna.event.PlayerEvents;

public class OnMethod {
	public static void onPlayerJoined() { //Name this whatever you want, MUST BE PUBLIC AND STATIC!
		// Adding the event
		EventDispatcher.getInstance().addListener(PlayerEvents.playerJoined, new EventListener<PlayerEvent>() {
			public void newEvent(EventType<PlayerEvent> type, PlayerEvent event) { //Registers the event
				String playerName = event.getContext().getPlayerData().get("characterInfo.name");
				event.getContext().echo("Hello there, " + playerName);
			}
		});
	}
}

/* Example of the 'on' Method.
 * Methods:
 * - newConnection: Called when there is a new connection on the server.
 * - playerConnected: When a player is currently logging into the server.
 * - playerDisconnected: When a player is currently disconnecting.
 *
 * - playerJoin: When the player Joins. On a server, this is called after 'playerConnected'.
 * - playerLeft: When the player Leaves. On a server, this is called after 'playerDisconnected'.
 *
 * - playerChatted: When the player has said something in the chat.
 * - cellChanged: When a block in the world is changed.
 *
 * - serverStarted: When the server finishes loading.
 * - serverStopped: When the server finishes stopping.
 */
println "on Method Loaded"

on([playerJoin]) {
  type, event -> //This just basically initializes it.

	// we are getting the player here
	// we asked for it, which 'it' is the player.
	// having no idea what their name is by default,
	// so we put 'name?'.
	// if we cannot find the name, their name is "Unknown".
	def playerName = it.name?:"Unknown"

	console.echo("Hello there, " + playerName)
}

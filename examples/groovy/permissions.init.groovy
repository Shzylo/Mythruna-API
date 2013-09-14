println "Permissions Example Loaded"
// This is only for servers, really.
on([playerJoined]) { //We will use playerJoined for this
  type, event -> //initialize the event

	/**
	 * playerData - gets the player's data info
	 * 
	 * get(String grant) - lets get the grant, you want to
	 * put as your permission, 'grant.<permission>' admin is
	 * default for administrators
	 * 
	 * != null will check if the player does have the grant.
	 */
	if(playerData.get("grant.admin") != null) {

		//check out the addShellCommand Example for info on it.
		addShellCommand(shell, "Hello", "Just a Test", null) {
			console.echo("Hello World")
		}
	}
}
